package com.example.employeepayrolldto.Service;

import com.example.employeepayrolldto.Dto.EmployeeDto;
import com.example.employeepayrolldto.Exception.EmployeeException;
import com.example.employeepayrolldto.Model.EmployeeData;
import com.example.employeepayrolldto.Repository.EmployeeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepo employeeRepo;

    public List<EmployeeData> data() {
        return employeeRepo.findAll();
    }

    public Object saveAll(EmployeeDto employeeDto) {
        EmployeeData employeeData =new EmployeeData(employeeDto);
        return employeeRepo.save(employeeData);
    }

    public Optional<EmployeeData> findById(int id) {
        return employeeRepo.findById(id);
    }

    public Boolean deleteById(int id) {
           Optional<EmployeeData> employeeID=employeeRepo.findById(id);
               if(employeeID.isPresent()){
               employeeRepo.deleteById(id);
               return true;
        }
        else{
              return false;
        }
    }

    public List<EmployeeData> findBydepartment(String department) {
        List<EmployeeData> employeeData = employeeRepo.findBydepartment(department);
            if (employeeData.isEmpty()){
            throw new EmployeeException("Department not founded");
        }
            else{
            return employeeData;
        }
    }
}

