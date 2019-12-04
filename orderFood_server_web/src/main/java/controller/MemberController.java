package controller;

import com.github.pagehelper.PageInfo;
import domain.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.MemberService;

import java.util.List;

@Controller
@RequestMapping("/member")
public class MemberController {
    @Autowired
    private MemberService memberService;

    //分页查询所有会员
    @RequestMapping("/all")
    public ModelAndView all(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize) {
        PageInfo<Member> members = memberService.all(pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute("members",members);
        modelAndView.setViewName("member_list");
        return modelAndView;
    }

    //分页查询所有会员 并按照余额排序
    @RequestMapping("/allOrderBy")
    public ModelAndView allOrderBy(String orderBy, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Member> members = memberService.allOrderBy(pageNum, pageSize, orderBy);
        modelAndView.getModelMap().addAttribute("members", members);
        modelAndView.setViewName("member_list");
        return modelAndView;
    }

    //根据会员id 查询会员
    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        Member member = memberService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute("member",member);
        modelAndView.setViewName("member_show");
        return modelAndView;
    }
}
