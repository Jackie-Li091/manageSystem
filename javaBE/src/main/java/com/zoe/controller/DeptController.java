package com.zoe.controller;

import com.zoe.pojo.Dept;
import com.zoe.pojo.Result;
import com.zoe.service.DeptService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("/depts")
@RestController
public class DeptController {
    //test log
    private static Logger log = LoggerFactory.getLogger(DeptController.class);

    @Autowired
    private DeptService deptService;


    //.get, get all department
    //@RequestMapping(value = "/depts", method = RequestMethod.GET)
    @GetMapping
    public Result deptList(){
        log.info("Query all department info");
        List<Dept> deptList = deptService.deptList();

        return Result.success(deptList);
    }

    //.delete/id, delete one department
    @DeleteMapping("/{id}")
    public Result deleteDept(@PathVariable Integer id){
        log.info("delete department: {}", id);
        deptService.deleteDept(id);

        return Result.success();
    }

    //.dept, add one department
    @PostMapping
    public Result addDept(@RequestBody Dept dept){
        log.info("add new department: {}", dept.getName());
        deptService.addDept(dept);

        return Result.success();
    }

    //.dept/id, get one department
    @GetMapping("/{id}")
    public Result getDept(@PathVariable Integer id){
        log.info("query dept: {}", id);
        Dept dept = deptService.getDept(id);

        return Result.success(dept);
    }

    //.dept, update one department
    @PutMapping
    public Result updateDept(@RequestBody Dept dept){
        log.info("add new department: {}, {}", dept.getId(), dept.getName());
        deptService.updateDept(dept);

        return Result.success();
    }
}
