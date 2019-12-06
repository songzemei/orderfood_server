package controller;

import domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import service.RoleService;

import java.util.List;


@Controller
@RequestMapping("/role")
public class RoleController {
    @Autowired
    private RoleService roleService;

    //查询所有角色
    @RequestMapping("/all")
    public ModelAndView findAll() {
        List<Role> roles = roleService.all();
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute("roles", roles);
        modelAndView.setViewName("role_list");
        return modelAndView;
    }

    //添加角色
    @RequestMapping("/add")
    public String add(Role role) {
        roleService.add(role);
        return "redirect:/role/all";
    }

    //根据管理员id 查询 该管理员没有的角色
    @RequestMapping("/findOtherByAdminId")
    public ModelAndView findOtherByUserId(String adminId) {
        List<Role> otherRoles = roleService.findOtherByAdminId(adminId);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute("otherRoles", otherRoles);
        modelAndView.getModelMap().addAttribute("adminId", adminId);
        modelAndView.setViewName("admin_role_add");
        return modelAndView;
    }

    //根据角色id 查找角色
    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        Role role = roleService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute("role", role);
        modelAndView.setViewName("role_info");
        return modelAndView;
    }

    //根据角色id 修改角色
    @RequestMapping("/updateById")
    public String updateById(Role role) {
        roleService.updateById(role);
        return "redirect:/role/all";
    }

    //给角色添加权限
    @RequestMapping("/addPermission")
    public String addPermission(String roleId, String[] permissionIds) {
        for (String permissionId : permissionIds) {
            roleService.addPermission(roleId, permissionId);
        }
        return "redirect:/role/all";
    }
}

