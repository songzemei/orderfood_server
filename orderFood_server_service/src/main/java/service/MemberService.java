package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.github.pagehelper.page.PageMethod;
import dao.MemberDao;
import domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MemberService {
    @Autowired
    private MemberDao memberDao;

    //查找所有会员
    public PageInfo<Member> all(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<Member> members = memberDao.all();
        return new PageInfo<>(members);
    }

    //分页查询所有会员 并按照余额排序
    public PageInfo<Member> allOrderBy(int pageNum, int pageSize,String orderBy) {
        PageHelper.startPage(pageNum, pageSize,orderBy);
        List<Member> members = memberDao.all();
        return new PageInfo<>(members);
    }

    //根据会员id 查询会员
    public Member findById(String id) {
        return memberDao.findById(id);
    }
}
