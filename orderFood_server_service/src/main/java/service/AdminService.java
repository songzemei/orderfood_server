package service;

import dao.AdminDao;
import domain.Admin;
import domain.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class AdminService implements UserDetailsService {
    @Autowired
    private AdminDao adminDao;
//    @Autowired
//    private BCryptPasswordEncoder encoder;


    //spring-security验证登录
    @Override
    public User loadUserByUsername(String username) throws UsernameNotFoundException {
        /**
         * 这个方法是给spring security调用的
         * spring security调用该方法，返回一个User对象
         * spring security通过操作该User对象完成认证。
         * 也就是说，不管我们查出来是什么对象，都要转成spring security的User对象
         */
        Admin admin = adminDao.findByUsername(username);
        // 把自己的admin对象转成SpringSecurity的User对象
        List<SimpleGrantedAuthority> list = new ArrayList();
        for (Role role : admin.getRoles()) {
            System.out.println(role);
            list.add(new SimpleGrantedAuthority(role.getRoleName()));
        }
        User user = new User(admin.getUsername(),
                "{noop}" + admin.getPassword(),
//                admin.getPassword(),
                admin.getStatus() == 1 ? true : false,
                true,
                true,
                true,
                list);
        return user;
    }

//    //查询所有管理员
//    public List<Admin> findAll() {
//        return adminDao.findAll();
//    }
//
//    //添加管理员
//    public void add(Admin admin) {
//        admin.setId(UUID.randomUUID().toString());
////        admin.setPassword(encoder.encode(admin.getPassword()));
//        adminDao.add(admin);
//    }
//
//    //根据 管理员id 查找管理员
//    public Admin findById(String id) {
//        return adminDao.findById(id);
//    }
//
//    //给管理员添加角色
//    public void addRoleToAdmin(String adminId, String roleId) {
//        adminDao.addRoleToAdmin(adminId, roleId);
//    }
}
