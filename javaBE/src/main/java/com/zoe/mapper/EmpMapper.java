package com.zoe.mapper;

import com.zoe.pojo.Emp;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.time.LocalDate;
import java.util.List;

@Mapper
public interface EmpMapper {
/*
    //query number of all emp
    @Select("select count(*) from tb_emp")
    public Long countEmp();

    //query by custom size
    @Select("select * from tb_emp limit #{startNum}, #{pageSize}")
    public List<Emp> empPerPage(Integer startNum, Integer pageSize); */


    //query emp list, customize size
    public List<Emp> empPerPage(String name, Short gender, LocalDate begin, LocalDate end);

    //delete all needed emp
    void deleteEmpByIds(List<Integer> ids);

    //insert new employee
    @Insert("insert into tb_emp (username, name, gender, job, entry_date, dept_id, create_time, update_time)" +
            "values (#{username},#{name},#{gender},#{job},#{entryDate},#{deptID},#{createTime},#{updateTime})")
    void insertNewEmp(Emp emp);

    //get employee by id
    @Select("select * from tb_emp where id = #{id}")
    Emp getEmp(Integer id);
}
