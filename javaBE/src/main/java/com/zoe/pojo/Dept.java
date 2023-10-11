package com.zoe.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Dept {
    private Integer id;  //ID
    private String name;  //department name
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
