package dao;



import domain.Admin;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AdminDao {
    @Select("select * from admin where username=#{username}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "roles", column = "id", many = @Many(select = "dao.RoleDao.findRolesByAdminId"))
    })
    Admin findByUsername(String username);//通过username查找管理员
//
//    @Select("select * from admin")
//    List<Admin> findAll();//查看所有管理员
//
//    @Insert("insert into admin values(#{id},#{username},#{password},#{email},#{phoneNum},#{status})")
//    void add(Admin admin);//添加管理员
//
//    @Select("select * from admin where id=#{id}")
//    @Results({
//            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "roles", column = "id", many = @Many(select = "dao.RoleDao.findRolesByAdminId"))
//    })
//    Admin findById(String id);//通过id查找管理员
//
//    @Insert("insert into admin_role values(#{adminId},#{roleId})")
//    void addRoleToAdmin(@Param("adminId") String adminId, @Param("roleId") String roleId);//给管理员添加角色
//
//    @Select("SELECT * FROM admin WHERE id IN(SELECT adminId FROM admin_role WHERE roleId =#{roleId})")
//    List<Admin> findByRoleId(String roleId);//通过roleid查找管理员
}
