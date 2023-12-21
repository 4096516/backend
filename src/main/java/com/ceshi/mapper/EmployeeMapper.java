package com.ceshi.mapper;

import com.ceshi.dto.EmployeePageQueryDTO;
import com.ceshi.eitity.Employee;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 员工信息数据访问接口
 */
@Mapper
public interface EmployeeMapper {

    /**
     * 分页查询员工信息
     * @param employeePageQueryDTO 分页查询条件
     * @return 分页查询结果
     */
    List<Employee> pageQuery(EmployeePageQueryDTO employeePageQueryDTO);

    /**
     * 获取员工总数
     * @return 员工总数
     */
    Long getTotalNum();

    /**
     * 根据员工ID查找员工信息
     * @param id 员工ID
     * @return 查找到的员工信息
     */
    Employee findById(int id);

    /**
     * 更新员工信息
     * @param existingEmployee 已存在的员工信息
     * @return 受影响的行数
     */
    int updateEmployee(Employee existingEmployee);

    /**
     * 插入新员工信息
     * @param newEmployee 新员工信息
     * @return 受影响的行数
     */
    int insert(Employee newEmployee);

    /**
     * 根据员工ID删除员工信息
     * @param id 员工ID
     * @return 受影响的行数
     */
    int deleteById(int id);

    /**
     * 获取所有员工信息
     * @return 所有员工信息的列表
     */
    List<Employee> getAllEmployees();
}
