package controller;

import com.github.pagehelper.PageInfo;
import domain.Orders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.OrdersService;

@Controller
@RequestMapping("/orders")
public class OrdersController {
    @Autowired
    private OrdersService ordersService;

    //分页查询所有未配送的订单  即 orderStatus=0
    @RequestMapping("/allUnFinish")
    public ModelAndView allUnFinish(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize) {
        PageInfo<Orders> allOrders = ordersService.allUnFinish(pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute("allOrders", allOrders);
        modelAndView.setViewName("orders_list_unfinish");
        return modelAndView;
    }

    //分页查询所有已完成的订单  即 orderStatus=1
    @RequestMapping("/allFinish")
    public ModelAndView allFinish(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize) {
        PageInfo<Orders> allOrders = ordersService.allFinish(pageNum, pageSize);
        double income = ordersService.income();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute("allOrders", allOrders);
        modelAndView.getModelMap().addAttribute("income", income);
        modelAndView.setViewName("orders_list_finish");
        return modelAndView;
    }

        //根据订单id查找对应的订单
    @RequestMapping("/info")
    public ModelAndView info(String ordersId) {
        Orders orders = ordersService.info(ordersId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute("orders", orders);
        modelAndView.setViewName("orders_info");
        return modelAndView;
    }

//    //根据会员id查找对应的所有订单 分页
//    @RequestMapping("/all")
//    public ModelAndView findByMemberId(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize) {
//        PageInfo<Orders> allOrders = ordersService.findByMemberId(pageNum, pageSize);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.getModelMap().addAttribute("allOrders", allOrders);
//        modelAndView.setViewName("orders_list");
//        return modelAndView;
//    }

//    //根据会员id和订单id查找对应的订单
//    @RequestMapping("/info")
//    public ModelAndView info(String ordersId) {
//        Orders orders = ordersService.info(ordersId);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.getModelMap().addAttribute("orders", orders);
//        modelAndView.setViewName("orders_info");
//        return modelAndView;
//    }
}
