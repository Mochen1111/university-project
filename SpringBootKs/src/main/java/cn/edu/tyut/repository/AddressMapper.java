package cn.edu.tyut.repository;

import cn.edu.tyut.domain.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface
AddressMapper {

    // 根据地址ID查询地址信息
    @Select("SELECT * FROM address WHERE addressId = #{addressId}")
    Address findAddressById(@Param("addressId") Integer addressId);

    // 根据用户ID查询地址列表
    @Select("SELECT * FROM address WHERE uid = #{uid}")
    List<Address> findAddressesByUserId(@Param("uid") Integer uid);

    // 插入地址信息
    @Insert("INSERT INTO address(uid, address) VALUES(#{uid}, #{address})")
    @SelectKey(statement = "SELECT LAST_INSERT_ID()", keyProperty = "addressId", before = false, resultType = Integer.class)
    int insertAddress(Address address);

    // 更新地址信息
    @Update("UPDATE address SET uid=#{uid}, address=#{address} WHERE addressId=#{addressId}")
    int updateAddress(Address address);

    // 删除地址信息
    @Delete("DELETE FROM address WHERE addressId=#{addressId}")
    int deleteAddress(@Param("addressId") Integer addressId);
}