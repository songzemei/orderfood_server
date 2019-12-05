package dao;

import domain.Address;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao {
    //根据会员id 查找所有地址
    @Select("SELECT * FROM address WHERE memberId=#{memberId}")
    List<Address> findByMemberId(String memberId);

    //通过addressid 查找地址
    @Select("select * from address where id=#{id}")
    Address findById(String id);
}
