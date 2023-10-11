package com.zoe.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {
    private Integer id;  //ID
    private String username;  //username
    private String password;  //password
    private String name;  //user name
    private Short gender;  //gender, 1 for man, 2 for woman
    private Short job;  //job, 1 for general manager, 2 for vice-general manager,
                            // 3 for accountant, 4 for employee
    private LocalDate entryDate;
    private Integer deptID;  //department id
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
