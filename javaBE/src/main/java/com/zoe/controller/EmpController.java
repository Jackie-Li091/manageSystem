package com.zoe.controller;

import com.zoe.pojo.Emp;
import com.zoe.pojo.EmpPageBean;
import com.zoe.pojo.Result;
import com.zoe.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@Slf4j
@RequestMapping("/emp")
@RestController
public class EmpController {

    @Autowired
    private EmpService empService;

    //.emp, get employee info (can customize page size)
    @GetMapping
    public Result empPage(@RequestParam(defaultValue = "1") Integer startNum,
                          @RequestParam(defaultValue = "10") Integer pageSize,
                          String name, Short gender,
                          @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
                          @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
        log.info("employee query, page: {}, size: {}, query: {} {} {} {}",
                startNum, pageSize, name, gender, begin, end);
        EmpPageBean empPageBean = empService.empPage(startNum, pageSize, name, gender, begin, end);

        return Result.success(empPageBean);
    }

    //.emp/{ids}, delete all request emp
    @DeleteMapping("/{ids}")
    public Result deleteEmpByIds(@PathVariable List<Integer> ids){
        log.info("delete: {}", ids);
        empService.deleteEmpByIds(ids);

        return Result.success();
    }

    //.emp, add new employee
    @PostMapping
    public Result addEmp(@RequestBody Emp emp){
        log.info("add emp: {}", emp);
        empService.addEmp(emp);

        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getEmp(@PathVariable Integer id){
        Emp emp = empService.getEmp(id);

        return Result.success(emp);
    }
}
