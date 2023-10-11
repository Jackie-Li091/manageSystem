package com.zoe.service.impl;

import com.zoe.mapper.DeptMapper;
import com.zoe.pojo.Dept;
import com.zoe.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl  implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> deptList(){
        return deptMapper.deptList();
    }

    @Override
    public void deleteDept(Integer id) {
        deptMapper.deleteDept(id);
    }

    @Override
    public void addDept(Dept dept) {
        //complement data
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.addDept(dept);
    }

    @Override
    public Dept getDept(Integer id) {
        return deptMapper.getDept(id);
    }

    @Override
    public void updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());

        deptMapper.updateDept(dept);
    }
}
