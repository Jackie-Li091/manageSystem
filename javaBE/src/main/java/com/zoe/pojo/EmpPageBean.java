package com.zoe.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * packing emp page return data
 *      include all data count and requested data
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EmpPageBean {
    private Long total;  //variable name match request
    private List rows;
}
