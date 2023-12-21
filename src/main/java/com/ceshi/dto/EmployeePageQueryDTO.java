package com.ceshi.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeePageQueryDTO implements Serializable {

    //当前页
    private Long currentPage;

    //每页记录数
    private Long pageSize;

    private Long id;

    private String empName;

    private String sex;

    private Integer age;

    private String deptName;

    private String empDegreeName;
}
