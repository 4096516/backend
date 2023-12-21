package com.ceshi.eitity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 员工实体类
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Employee {

    // 员工ID
    private int id;

    // 员工姓名
    private String empName;

    // 员工性别
    private String sex;

    // 员工年龄
    private Integer age;

    // 员工部门名称
    private String deptName;

    // 员工学历名称
    private String empDegreeName;

}
