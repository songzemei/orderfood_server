package service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import dao.ProductDao;
import domain.Product;
import domain.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import util.UploadUtil;

import java.io.IOException;
import java.util.List;
import java.util.UUID;

@Service
public class ProductService {
    @Autowired
    private ProductDao productDao;

    //分页查找所有产品
    public PageInfo<Product> all(int pageNum, int pageSize) {
        PageHelper.startPage(pageNum,pageSize);
        List<Product> products = productDao.all();
        return new PageInfo<>(products);
    }

    //分页查询所有产品 并按照价格排序
    public PageInfo<Product> allOrderBy(int pageNum, int pageSize,String orderBy) {
        PageHelper.startPage(pageNum, pageSize,orderBy);
        List<Product> products = productDao.all();
        return new PageInfo<>(products);
    }

    //通过id修改产品
    public void update(Product product) {
        productDao.update(product);
    }

    //添加产品
    public void add(Product product) {
        product.setId(UUID.randomUUID().toString());
        productDao.add(product);
    }

    //删除产品
    public void delete(String[] ids) {
        for (String id:ids) {
            productDao.delete(id);
        }
    }

    //根据id 查找产品
    public Product findById(String id) {
        return productDao.findById(id);
    }

    //上传菜品图片
    public Result upload(MultipartFile file) throws IOException {
        String name = file.getOriginalFilename();
        name = UUID.randomUUID() + "_" + name;
        UploadUtil.uploadToImgServer(file, "http://localhost:81/upload/", name);
        Result result = new Result();
        result.setResult(true);
        result.setMessage(name);
        return result;
    }
}
