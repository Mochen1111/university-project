package cn.edu.tyut.repository;

import cn.edu.tyut.domain.GoodImage;
import org.apache.ibatis.annotations.*;

@Mapper
public interface GoodImageMapper {

    // 根据ID查询商品图片信息
    @Select("SELECT * FROM goodimage WHERE id = #{id}")
    GoodImage findGoodImageById(@Param("id") Integer id);

    // 插入商品图片信息
    @Insert("INSERT INTO goodimage(id, image1, image2, image3, image4, image5, image6, image7, image8, image9) " +
            "VALUES(#{id}, #{image1}, #{image2}, #{image3}, #{image4}, #{image5}, #{image6}, #{image7}, #{image8}, #{image9})")
    int insertGoodImage(GoodImage goodImage);

    // 更新商品图片信息
    @Update("UPDATE goodimage SET image1=#{image1}, image2=#{image2}, image3=#{image3}, image4=#{image4}, " +
            "image5=#{image5}, image6=#{image6}, image7=#{image7}, image8=#{image8}, image9=#{image9} WHERE id=#{id}")
    int updateGoodImage(GoodImage goodImage);

    // 删除商品图片信息
    @Delete("DELETE FROM goodimage WHERE id=#{id}")
    int deleteGoodImage(@Param("id") Integer id);
}