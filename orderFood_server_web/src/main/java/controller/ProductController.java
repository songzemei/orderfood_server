package controller;

import com.github.pagehelper.PageInfo;
import domain.Product;
import domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import service.ProductService;

import java.io.IOException;
import java.util.List;

@Controller
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    //分页查找所有产品
    @RequestMapping("/all")
    public ModelAndView all(@RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize) {
        PageInfo<Product> products = productService.all(pageNum, pageSize);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute("products", products);
        modelAndView.setViewName("product_list");
        return modelAndView;
    }

    //分页查询所有产品 并按照价格排序
    @RequestMapping("/allOrderBy")
    public ModelAndView allOrderBy(String orderBy, @RequestParam(defaultValue = "1") int pageNum, @RequestParam(defaultValue = "5") int pageSize) {
        ModelAndView modelAndView = new ModelAndView();
        PageInfo<Product> products = productService.allOrderBy(pageNum, pageSize, orderBy);
        modelAndView.getModelMap().addAttribute("products", products);
        modelAndView.setViewName("product_list");
        return modelAndView;
    }

    //通过id修改产品
    @RequestMapping("/update")
    public String update(Product product) {
        productService.update(product);
        return "redirect:/product/all";
    }

    //添加产品
    @RequestMapping("/add")
    public String add(Product product) {
        productService.add(product);
        return "redirect:/product/all";
    }

    //删除产品
    @RequestMapping("/delete")
    public String delete(String[] ids) {
        if (ids != null) {
            productService.delete(ids);
        }
        return "redirect:/product/all";
    }

    //根据id 查找产品
    @RequestMapping("/findById")
    public ModelAndView findById(String id) {
        Product product = productService.findById(id);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.getModelMap().addAttribute("product",product);
        modelAndView.setViewName("product_update");
        return modelAndView;
    }

    //上传菜品图片
    @RequestMapping("/upload")
    public @ResponseBody
    Result upload(MultipartFile file) throws IOException {
        Result result = productService.upload(file);
        return result;
    }
}
