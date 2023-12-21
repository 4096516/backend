package com.ceshi.service.impl;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.ceshi.dto.EmployeePageQueryDTO;
import com.ceshi.eitity.Employee;
import com.ceshi.mapper.EmployeeMapper;
import com.ceshi.result.PageResult;
import com.ceshi.result.Result;
import com.ceshi.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.List;

/**
 * 员工信息服务实现类
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeMapper employeeMapper;

    /**
     * 执行分页查询，获取一页的员工数据
     *
     * @param employeePageQueryDTO 分页查询条件
     * @return 包含员工信息的分页结果
     */
    @Override
    public Result pageQuery(EmployeePageQueryDTO employeePageQueryDTO) {
        // 执行分页查询，获取一页的员工数据
        List<Employee> page = employeeMapper.pageQuery(employeePageQueryDTO);
        // 获取总记录数
        Long total = employeeMapper.getTotalNum();
        // 封装为分页结果对象
        PageResult pageResult = new PageResult(total, page);
        return Result.success(pageResult);
    }

    /**
     * 根据员工ID查找员工信息
     *
     * @param id 员工ID
     * @return 查找到的员工信息
     */
    @Override
    public Employee findById(int id) {
        return employeeMapper.findById(id);
    }

    /**
     * 更新员工信息
     *
     * @param updatedEmployee 更新后的员工信息
     * @return 更新结果
     */
    @Override
    public Result updateEmployee(Employee updatedEmployee) {
        // 根据ID查找原有员工信息
        Employee existingEmployee = employeeMapper.findById(updatedEmployee.getId());
        if (existingEmployee != null) {
            // 更新员工信息
            existingEmployee.setEmpName(updatedEmployee.getEmpName());
            existingEmployee.setSex(updatedEmployee.getSex());
            existingEmployee.setAge(updatedEmployee.getAge());
            existingEmployee.setDeptName(updatedEmployee.getDeptName());
            existingEmployee.setEmpDegreeName(updatedEmployee.getEmpDegreeName());
            // 执行更新操作
            int rowsAffected = employeeMapper.updateEmployee(existingEmployee);
            // 根据更新影响的行数返回相应结果
            if (rowsAffected > 0) {
                return Result.success("员工信息更新成功");
            } else {
                return Result.error("员工信息更新失败");
            }
        } else {
            return Result.error("找不到该员工信息");
        }
    }

    /**
     * 保存新员工信息
     *
     * @param newEmployee 新员工信息
     * @return 包含保存后的员工信息的结果
     */
    @Override
    public Employee saveEmployee(Employee newEmployee) {
        // 插入新员工信息
        int rows = employeeMapper.insert(newEmployee);
        if (rows > 0) {
            // 插入成功，通过主键查询插入后的实体对象
            Employee insertedEmployee = employeeMapper.findById(newEmployee.getId());
            return insertedEmployee;
        } else {
            // 插入失败，根据需要处理错误情况
            throw new RuntimeException("新增职员失败");
        }
    }

    /**
     * 根据员工ID删除员工信息
     *
     * @param id 员工ID
     * @return 删除结果
     */
    @Override
    public Result deleteById(int id) {
        // 根据ID删除员工信息
        int rowsAffected = employeeMapper.deleteById(id);
        // 根据删除影响的行数返回相应结果
        if (rowsAffected > 0) {
            return Result.success("员工删除成功");
        } else {
            return Result.error("员工删除失败");
        }
    }

    /**
     * 导出员工数据到Excel文件
     *
     * @param response HTTP响应对象
     * @throws IOException 可能抛出的IO异常
     */
    @Override
    public void exportEmployeeData(HttpServletResponse response) throws IOException {
        // 设置响应头，指定文件名为 employee_template.xlsx 并且提示浏览器将其作为附件下载
        String fileName = URLEncoder.encode("employee_template", "UTF-8");
        response.setHeader("Content-Disposition", "attachment; filename=" + fileName + ".xlsx");
        response.setHeader("Access-Control-Expose-Headers", "Content-Disposition");
        // 获取响应的输出流
        ServletOutputStream outputStream = response.getOutputStream();
        // 模板文件的路径
        ClassPathResource resource = new ClassPathResource("/template/employee_template.xlsx");
        // 创建 ExcelWriter 对象，将数据写入输出流，并使用模板
        ExcelWriter excelWriter = EasyExcel.write(outputStream).withTemplate(resource.getInputStream()).build();
        // 从数据库中获取所有职工数据
        List<Employee> employees = employeeMapper.getAllEmployees();
        // 将数据填充到工作表的 Sheet1
        excelWriter.fill(employees, EasyExcel.writerSheet(0).build());
        // 完成 Excel 写入操作
        excelWriter.finish();
    }
}
