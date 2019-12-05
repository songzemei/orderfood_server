package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.OrdersDao;
import dao.WorkerDao;
import domain.Result;
import domain.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class WorkerService {
    @Autowired
    private WorkerDao workerDao;
    @Autowired
    private OrdersDao ordersDao;

    //分页查询所有配送员
    public PageInfo<Worker> all(int pageNum, int pageSize) {
        judge();
        PageHelper.startPage(pageNum, pageSize);
        List<Worker> workers = workerDao.all();
        return new PageInfo<>(workers);
    }

    //查询所有空闲的配送员 workStatus=0
    public List<Worker> freeWorker() {
        judge();
        return workerDao.freeWorker();
    }

    //配送员接单 -接单后 将workStatus改为1:工作中,余额+5,新增接单时间,将订单状态改为1：已配送,接单数量+1
    public Result addOrders(String workerId, String ordersId) {
        Worker worker = workerDao.findById(workerId);
        worker.setworkStatus(1);
        worker.setBalance(worker.getBalance() + 5);
        worker.setOrderTime(new Date());
        worker.setOrdersCount(worker.getOrdersCount() + 1);
        workerDao.addOrders(worker);
        ordersDao.updateStatus(ordersId);
        return new Result(true, "订单配送成功！");
    }

    //配送一单的时间为60s 超过60s就把配送员状态改为0：空闲
    public void judge() {
        List<Worker> workers = workerDao.all();
        for (Worker worker : workers) {
            if (worker.getOrderTime()!=null){
                if (worker.getworkStatus() == 1 && (new Date().getTime() - worker.getOrderTime().getTime()) > 60 * 1000) {
                    workerDao.ordersFinish(worker.getId());
                }
            }
        }
    }

}
