package dao;

import domain.Member;
import org.apache.ibatis.annotations.Many;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MemberDao {
    //查询所有会员
    @Select("select * from member")
    List<Member> all();

    //根据会员id 查询会员
    @Select("select * from member where id=#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "addresses",column = "id",many = @Many(select = "dao.AddressDao.findByMemberId")),
    })
    Member findById(String id);
}
