package controller;

import com.github.pagehelper.PageInfo;
import domain.Result;
import domain.Worker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.WorkerService;

import java.util.List;

@Controller
@RequestMapping("worker")
public class WorkerController {
    @Autowired
    private WorkerService workerService;

    //查询所有配送员
    @RequestMapping("all")
    public ModelAndView all(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize) {
        PageInfo<Worker> workers = workerService.all(pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute("workers", workers);
        modelAndView.setViewName("worker_list");
        return modelAndView;
    }

    //查询所有空闲的配送员 workStatus=0
    @RequestMapping("allFree")
    public ModelAndView allFree(String ordersId) {
        List<Worker> freeWorkers = workerService.freeWorker();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute("freeWorkers", freeWorkers);
        modelAndView.getModelMap().addAttribute("ordersId", ordersId);
        modelAndView.setViewName("freeWorker_list");
        return modelAndView;
    }

    //配送员接单
    @RequestMapping("addOrders")
    public ModelAndView addOrders(String workerId, String ordersId) {
        Result result = workerService.addOrders(workerId, ordersId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute("result", result);
        modelAndView.setViewName("result");
        return modelAndView;
    }
}
