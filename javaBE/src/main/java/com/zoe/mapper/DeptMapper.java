package com.zoe.mapper;

import com.zoe.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface DeptMapper {

    //Query all department info
    @Select("select * from tb_dept")
    List<Dept> deptList();

    //Delete department
    @Delete("delete from tb_dept where id = #{id}")
    void deleteDept(Integer id);

    //add new department
    @Insert("insert into tb_dept(name, create_time, update_time) " +
            "values (#{name}, #{createTime}, #{updateTime})")
    void addDept(Dept dept);

    //get id department
    @Select("select * from tb_dept where id = #{id}")
    Dept getDept(Integer id);

    //update dept.id department
    @Update("update tb_dept set name=#{name}, update_time=#{updateTime} " +
            "where id=#{id}")
    void updateDept(Dept dept);
}
