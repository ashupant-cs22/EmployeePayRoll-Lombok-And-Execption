package com.example.employeepayrolldto.Service;

import com.example.employeepayrolldto.Dto.EmployeeDto;
import com.example.employeepayrolldto.Model.EmployeeData;

import java.util.List;

public interface IEmployeeService {

    Object save(EmployeeDto employeeDto);

    Object displayAll(EmployeeDto employeeDto);

    Object findById(EmployeeDto employeeDto);

    Object delete(EmployeeDto employeeDto);

    List<EmployeeData> findBydepartment(String department);

}
