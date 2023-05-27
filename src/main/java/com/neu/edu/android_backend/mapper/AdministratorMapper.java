package com.neu.edu.android_backend.mapper;

import com.neu.edu.android_backend.po.Administrator;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface AdministratorMapper {
    @Select("SELECT * FROM administrator WHERE id = #{id}")
    Administrator getAdministratorById(String id);

    @Select("SELECT * FROM administrator")
    List<Administrator> getAllAdministrators();

    @Select("SELECT * FROM administrator WHERE name = #{name}")
    Administrator getAdministratorByName(String name);

    @Insert("INSERT INTO administrator (id, password, name) VALUES (#{id}, #{password}, #{name})")
    void addAdministrator(Administrator administrator);

    @Update("UPDATE administrator SET password = #{password}, name = #{name} WHERE id = #{id}")
    void updateAdministrator(Administrator administrator);

    @Delete("DELETE FROM administrator WHERE id = #{id}")
    void deleteAdministrator(String id);
}
