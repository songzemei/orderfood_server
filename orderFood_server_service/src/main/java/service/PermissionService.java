//package service;
//
//import dao.PermissionDao;
//import domain.Permission;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//
//import java.util.List;
//import java.util.UUID;
//
//@Service
//public class PermissionService {
//    @Autowired
//    private PermissionDao permissionDao;
//
//    //查询所有权限
//    public List<Permission> findAll() {
//        return permissionDao.findAll();
//    }
//
//    //添加权限
//    public void add(Permission permission) {
//        permission.setId(UUID.randomUUID().toString());
//        permissionDao.add(permission);
//    }
//
//    //根据权限id 修改权限
//    public void updateById(Permission permission) {
//        permissionDao.updateById(permission);
//    }
//
//    public Permission findById(String id) {
//        return permissionDao.findById(id);
//    }
//
//    //根据角色id查询 角色没有的权限
//    public List<Permission> findOtherByRoleId(String roleId) {
//        return permissionDao.findOtherByRoleId(roleId);
//    }
//}
