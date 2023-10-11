package com.zoe.service;

import com.zoe.pojo.Emp;
import com.zoe.pojo.EmpPageBean;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.util.List;

public interface EmpService {
    EmpPageBean empPage(Integer startNum, Integer pageSize,
                        String name, Short gender, LocalDate begin, LocalDate end);

    void deleteEmpByIds(List<Integer> ids);

    void addEmp(Emp emp);

    Emp getEmp(Integer id);
}
