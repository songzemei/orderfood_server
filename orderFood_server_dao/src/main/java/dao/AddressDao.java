package dao;

import domain.Address;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressDao {
    //根据会员id 查找所有地址
    @Select("SELECT * FROM address WHERE id IN(SELECT addressId FROM member_address WHERE memberId=#{memberId})")
    List<Address> findByMemberId(String memberId);
}
