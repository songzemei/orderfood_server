package dao;

import domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PermissionDao {

    //根据roleid查找权限
    @Select("SELECT * FROM permission WHERE id IN(SELECT permissionId FROM role_permission WHERE roleId =#{roleId})")
    List<Permission> findByRoleId(String roleId);

    //查找所有权限
    @Select("select * from permission")
    List<Permission> findAll();

    //添加权限
    @Insert("insert into permission values(#{id},#{permissionName},#{url})")
    void add(Permission permission);

    //根据 权限id 修改 权限名和权限路径
    @Update("update permission set permissionName=#{permissionName},url=#{url} where id=#{id}")
    void updateById(Permission permission);

    //根据权限id查找权限
    @Select("select * from permission where id=#{id}")
    Permission findById(String id);

    //根据roleid查询角色没有的权限
    @Select("select * from permission where id not in(select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherByRoleId(String roleId);
}
