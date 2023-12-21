package com.ceshi.controller;

import com.ceshi.dto.EmployeePageQueryDTO;
import com.ceshi.eitity.Employee;
import com.ceshi.result.PageResult;
import com.ceshi.result.Result;
import com.ceshi.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/employee")
@CrossOrigin
@Api(tags = "员工管理")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 获取所有员工信息（分页查询）
     * @param employeePageQueryDTO 分页查询条件
     * @return 包含员工信息的分页结果
     */
    @GetMapping("/list")
    @ApiOperation("分页获取所有员工信息")
    public Result getAllEmployee(EmployeePageQueryDTO employeePageQueryDTO) {
        return employeeService.pageQuery(employeePageQueryDTO);
    }

    /**
     * 保存新员工信息
     * @param newEmployee 新员工信息
     * @return 包含保存后的员工信息的结果
     */
    @PostMapping("/save")
    @ApiOperation("保存新员工信息")
    public Result saveEmployee(@RequestBody Employee newEmployee) {
        Employee savedEmployee = employeeService.saveEmployee(newEmployee);
        return Result.success(savedEmployee);
    }

    /**
     * 根据员工ID查找员工信息
     * @param id 员工ID
     * @return 包含查找到的员工信息的结果
     */
    @GetMapping("/findById/{id}")
    @ApiOperation("根据员工ID获取员工信息")
    public Result findById(@PathVariable int id) {
        Employee employee = employeeService.findById(id);
        if (employee != null) {
            return Result.success(employee);
        } else {
            return Result.error("找不到该职员信息");
        }
    }

    /**
     * 更新员工信息
     * @param updatedEmployee 更新后的员工信息
     * @return 更新结果
     */
    @PutMapping("/update")
    @ApiOperation("更新员工信息")
    public Result updateEmployee(@RequestBody Employee updatedEmployee) {
        Result result = employeeService.updateEmployee(updatedEmployee);
        return result;
    }

    /**
     * 根据员工ID删除员工信息
     * @param id 员工ID
     * @return 删除结果
     */
    @DeleteMapping("/deleteById/{id}")
    @ApiOperation("根据员工ID删除员工信息")
    public Result deleteEmployee(@PathVariable int id) {
        return employeeService.deleteById(id);
    }

    /**
     * 导出员工数据
     * @param response HTTP响应对象
     * @throws IOException 可能抛出的IO异常
     */
    @GetMapping("/export")
    @ApiOperation("导出员工数据")
    public void exportEmployees(HttpServletResponse response) throws IOException {
        employeeService.exportEmployeeData(response);
    }
}
