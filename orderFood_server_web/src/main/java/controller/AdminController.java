//package controller;
//
//
//import domain.Admin;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.access.annotation.Secured;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.servlet.ModelAndView;
//import service.AdminService;
//
//
//import javax.annotation.security.RolesAllowed;
//import java.util.List;
//
//@Controller
//@RequestMapping("/admin")
//public class AdminController {
//    @Autowired
//    private AdminService adminService;
//
//    //查询所有管理员
//    @RequestMapping("/findAll")
////    @Secured({"ROLE_admin"})
//    public ModelAndView findAll() {
////        int i=1/0;
//        List<Admin> admins = adminService.findAll();
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.getModelMap().addAttribute("admins", admins);
//        modelAndView.setViewName("admin_list");
//        return modelAndView;
//    }
//
//    //添加管理员
//    @RequestMapping("/add")
//    public String add(Admin Admin) {
//        adminService.add(Admin);
//        return "redirect:/admin/findAll";
//    }
//
//    //根据 管理员id 查找管理员
//    @RequestMapping("/findById")
//    public ModelAndView findById(String id) {
//        Admin admin = adminService.findById(id);
//        ModelAndView modelAndView = new ModelAndView();
//        modelAndView.getModelMap().addAttribute("admin", admin);
//        modelAndView.setViewName("admin_show");
//        return modelAndView;
//    }
//
//    //给管理员添加角色
//    @RequestMapping("/addRoleToAdmin")
//    public String addRoleToadmin(String adminId, String[] roleIds) {
//        for (String roleId:roleIds) {
//            adminService.addRoleToAdmin(adminId,roleId);
//        }
//        return "redirect:/admin/findAll";
//    }
//}
