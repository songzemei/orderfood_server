package dao;

import domain.Orders;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersDao {

    //分页查询所有未配送的订单  即 orderStatus=0
    @Select("select * from orders where orderStatus=0")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "cars", column = "id", many = @Many(select = "dao.CarDao.findByOrdersId")),
            @Result(property = "address", column = "addressId", one = @One(select = "dao.AddressDao.findById")),
            @Result(property = "member", column = "memberId", one = @One(select = "dao.MemberDao.findById"))
    })
    List<Orders> allUnFinish();

    //分页查询所有已完成的订单  即 orderStatus=1
    @Select("select * from orders where orderStatus=1")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "cars", column = "id", many = @Many(select = "dao.CarDao.findByOrdersId")),
            @Result(property = "address", column = "addressId", one = @One(select = "dao.AddressDao.findById")),
            @Result(property = "member", column = "memberId", one = @One(select = "dao.MemberDao.findById"))
    })
    List<Orders> allFinish();

    //根据订单id查找对应的订单
    @Select("select * from orders where  id=#{ordersId}")
    @Results({
            @Result(id = true, property = "id", column = "id"),
            @Result(property = "cars", column = "id", many = @Many(select = "dao.CarDao.findByOrdersId")),
            @Result(property = "address", column = "addressId", one = @One(select = "dao.AddressDao.findById"))
    })
    Orders info(String ordersId);

    //查询营业额 已完成的订单才算进去 orderStatus=1的订单
    @Select("SELECT SUM(totalPrice) FROM orders WHERE orderStatus=1")
    Double income();

    //更改订单状态为已配送
    @Update("update orders set orderStatus=1 where id=#{id}")
    void updateStatus(String id);

//    //根据会员id查找对应的订单 再根据订单id查找订单里的产品
//    @Select("select * from orders where memberId=#{memberId}")
//    @Results({
//            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "cars", column = "id", many = @Many(select = "dao.CarDao.findByOrdersId")),
//            @Result(property = "address", column = "addressId", one = @One(select = "dao.AddressDao.findById"))
//    })
//    List<Orders> findByMemberId(String memberId);
//
//    //添加订单
//    @Insert("insert into orders values(#{id},#{orderTime},#{orderStatus},#{orderDesc},#{memberId},#{payType},#{totalPrice},#{addressId})")
//    void add(Orders orders);
//
//    //根据订单id 修改订单状态 1：已完成/0：未完成
//    @Update("update orders set ordersStatus='1' where id=#{id}")
//    void updateOrdersStatus(String id);
//
//    //根据会员id和订单id查找对应的订单
//    @Select("select * from orders where memberId=#{memberId} and id=#{ordersId}")
//    @Results({
//            @Result(id = true, property = "id", column = "id"),
//            @Result(property = "cars", column = "id", many = @Many(select = "dao.CarDao.findByOrdersId")),
//            @Result(property = "address", column = "addressId", one = @One(select = "dao.AddressDao.findById"))
//    })
//    Orders info(@Param("memberId") String memberId, @Param("ordersId") String ordersId);
}
