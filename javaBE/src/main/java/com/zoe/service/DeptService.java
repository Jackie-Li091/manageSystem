package com.zoe.service;

import com.zoe.pojo.Dept;

import java.util.List;

public interface DeptService {

    //query all department
    List<Dept> deptList();

    //delete id department
    void deleteDept(Integer id);

    //add dept department
    void addDept(Dept dept);

    //get id dept
    Dept getDept(Integer id);

    //update dept department
    void updateDept(Dept dept);
}
