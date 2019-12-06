package dao;

import domain.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleDao {

    //通过管理员id查找role
    @Select("select * from role where id in(select roleId from admin_role where adminId =#{id})")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "permissions", column = "id", many = @Many(select = "dao.PermissionDao.findByRoleId"))
    })
    List<Role> findRolesByAdminId(String id);

    //查看所有角色
    @Select("select * from role")
    List<Role> all();

    //添加角色
    @Insert("insert into role values(#{id},#{roleName},#{roleDesc})")
    void add(Role role);

    //根据管理员Id查询 没有的角色
    @Select("SELECT * FROM role WHERE id NOT IN(SELECT roleId FROM admin_role WHERE adminId=#{adminId})")
    List<Role> findOtherByAdminId(String adminId);

    //根据roleid查找role
    @Select("select * from role where id=#{id}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "admins", column = "id", many = @Many(select = "dao.AdminDao.findByRoleId")),
            @Result(property = "permissions", column = "id", many = @Many(select = "dao.PermissionDao.findByRoleId"))
    })
    Role findById(String id);

    //根据roleid修改role的名字和描述
    @Update("update role set roleName=#{roleName},roleDesc=#{roleDesc} where id=#{id}")
    void updateById(Role role);

    //给角色添加权限
    @Insert("insert into role_permission values(#{roleId},#{permissionId})")
    void addPermission(@Param("roleId") String roleId, @Param("permissionId") String permissionId);
}
