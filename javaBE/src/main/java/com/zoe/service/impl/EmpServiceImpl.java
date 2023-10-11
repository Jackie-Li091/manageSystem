package com.zoe.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zoe.mapper.EmpMapper;
import com.zoe.pojo.Emp;
import com.zoe.pojo.EmpPageBean;
import com.zoe.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;

    //query employee by customize size
    @Override
    public EmpPageBean empPage(Integer startNum, Integer pageSize,
                               String name, Short gender, LocalDate begin, LocalDate end) {
        /* Long count = empMapper.countEmp();
        Integer start = (startNum - 1) * pageSize;
        List<Emp> emp = empMapper.empPerPage(start, pageSize);*/

        PageHelper.startPage(startNum, pageSize);
        List<Emp> empList = empMapper.empPerPage(name, gender, begin, end);
        Page<Emp> p = (Page<Emp>) empList;
        EmpPageBean empPageBean = new EmpPageBean(p.getTotal(), p.getResult());

        return empPageBean;
    }

    @Override
    public void deleteEmpByIds(List<Integer> ids) {
        empMapper.deleteEmpByIds(ids);
    }

    @Override
    public void addEmp(Emp emp) {
        emp.setCreateTime(LocalDateTime.now());
        emp.setUpdateTime(LocalDateTime.now());
        empMapper.insertNewEmp(emp);
    }

    @Override
    public Emp getEmp(Integer id) {
        return empMapper.getEmp(id);
    }
}
