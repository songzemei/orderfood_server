//package service;
//
//import dao.RoleDao;
//import domain.Role;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class RoleService {
//    @Autowired
//    private RoleDao roleDao;
//
//    //查询所有角色
//    public List<Role> findAll() {
//        return roleDao.findAll();
//    }
//
//    //添加角色
//    public void add(Role role) {
//        role.setId(UUID.randomUUID().toString());
//        roleDao.add(role);
//    }
//
//    //根据管理员id查询 该管理员没有的角色
//    public List<Role> findOtherByAdminId(String adminId) {
//        return roleDao.findOtherByAdminId(adminId);
//    }
//
//    //根据角色id 查找角色
//    public Role findById(String id) {
//        return roleDao.findById(id);
//    }
//
//    //根据角色id 修改角色
//    public void updateById(Role role) {
//        roleDao.updateById(role);
//    }
//
//    //给角色添加权限
//    public void addPermission(String roleId, String permissionId) {
//        roleDao.addPermission(roleId, permissionId);
//    }
//}
