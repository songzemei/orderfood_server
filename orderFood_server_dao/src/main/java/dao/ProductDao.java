package dao;

import domain.Product;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductDao {

    //查找所有产品
    @Select("select * from product")
    List<Product> all();

    //通过id修改产品
    @Update("update  product set productName=#{productName},productPrice=#{productPrice},productPhoto=#{productPhoto} where id=#{id}")
    void update(Product product);

    //添加产品
    @Insert("insert into product values(#{id},#{productName},#{productPrice},#{productPhoto})")
    void add(Product product);

    //删除产品
    @Delete("delete from product where id=#{id}")
    void delete(String id);

    //根据id 查找产品
    @Select("select * from product where id=#{id}")
    Product findById(String id);

}
