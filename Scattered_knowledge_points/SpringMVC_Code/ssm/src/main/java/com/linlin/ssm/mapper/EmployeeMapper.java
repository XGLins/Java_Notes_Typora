package com.linlin.ssm.mapper;

import com.linlin.ssm.pojo.Employee;
import org.springframework.context.annotation.Bean;

import java.util.List;

public interface EmployeeMapper {

    /**
     * 查询所有的员工信息
     * */
    List<Employee> getAllEmployee();
}
