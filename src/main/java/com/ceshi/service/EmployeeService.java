package com.ceshi.service;

import com.ceshi.dto.EmployeePageQueryDTO;
import com.ceshi.eitity.Employee;
import com.ceshi.result.Result;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 员工信息服务接口
 */
public interface EmployeeService {

    /**
     * 分页查询员工信息
     * @param employeePageQueryDTO 分页查询条件
     * @return 包含员工信息的分页结果
     */
    Result pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 根据员工ID查找员工信息
     * @param id 员工ID
     * @return 查找到的员工信息
     */
    Employee findById(int id);

    /**
     * 更新员工信息
     * @param updatedEmployee 更新后的员工信息
     * @return 更新结果
     */
    Result updateEmployee(Employee updatedEmployee);

    /**
     * 保存新员工信息
     * @param newEmployee 新员工信息
     * @return 包含保存后的员工信息的结果
     */
    Employee saveEmployee(Employee newEmployee);

    /**
     * 根据员工ID删除员工信息
     * @param id 员工ID
     * @return 删除结果
     */
    Result deleteById(int id);

    /**
     * 导出员工数据到Excel文件
     * @param response HTTP响应对象
     * @throws IOException 可能抛出的IO异常
     */
    void exportEmployeeData(HttpServletResponse response) throws IOException;
}
