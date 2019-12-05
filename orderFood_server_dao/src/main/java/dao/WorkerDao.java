package dao;

import domain.Worker;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface WorkerDao {
    //查询所有配送员
    @Select("select * from worker")
    List<Worker> all();

    //查询所有空闲的配送员 workStatus=0
    @Select("select * from worker where workStatus=0")
    List<Worker> freeWorker();

    //接单后更改配送员信息
    @Update("update worker set workStatus=#{workStatus},orderTime=#{orderTime},balance=#{balance},ordersCount=#{ordersCount} where id=#{id}")
    void addOrders(Worker worker);

    //根据id查询配送员
    @Select("select * from worker where id=#{id}")
    Worker findById(String id);

    //配送一单的时间为60s 超过60s就把配送员状态改为0：空闲
    @Update("update worker set workStatus=0 ,orderTime=null where id=#{id}")
    void ordersFinish(String id);
}
