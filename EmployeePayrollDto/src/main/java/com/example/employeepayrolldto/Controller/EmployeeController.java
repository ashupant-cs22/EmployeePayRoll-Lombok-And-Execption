package com.example.employeepayrolldto.Controller;

import com.example.employeepayrolldto.Dto.EmployeeDto;
import com.example.employeepayrolldto.Dto.ResponseDto;
import com.example.employeepayrolldto.Model.EmployeeData;
import com.example.employeepayrolldto.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;


        @PostMapping("/save")
            public ResponseEntity<ResponseDto> save(@RequestBody EmployeeDto employeeDto){
            ResponseDto responseDto = new ResponseDto("Data is been saved" , employeeService.saveAll(employeeDto));
            return new ResponseEntity<>(responseDto, HttpStatus.CREATED);
        }

        @GetMapping("/data")
            public ResponseEntity<ResponseDto> data(){
            ResponseDto responseDto= new ResponseDto("Data is been displaying" , employeeService.data());
            return new ResponseEntity<>(responseDto,HttpStatus.OK);
        }

        @GetMapping("/find/{id}")
            public ResponseEntity<ResponseDto> findById(@PathVariable int id){
            Optional<EmployeeData> empData = employeeService.findById(id);
            String message = empData.isPresent() ? "Employee id found" : "employee id not found";
            ResponseDto responseDto= new ResponseDto(message,employeeService.findById(id));
            return new ResponseEntity<>(responseDto,HttpStatus.OK);
        }

        @GetMapping("/search/{department}")
            public ResponseEntity<ResponseDto> findBydepartment(@PathVariable String department){
            List<EmployeeData> employeeDataList;
            employeeDataList= employeeService.findBydepartment(department);
            ResponseDto responseDto = new ResponseDto("Data found by department" , employeeDataList);
            return new ResponseEntity<>(responseDto , HttpStatus.OK);
    }

        @DeleteMapping("/delete/{id}")
            public ResponseEntity<ResponseDto> delete(@PathVariable int id) {
            Boolean isEmpId = employeeService.deleteById(id);
            String message = isEmpId ? "ID deleted " : "ID not found";
            ResponseDto responseDto = new ResponseDto(message,employeeService.deleteById(id));
            return new ResponseEntity<>(responseDto, HttpStatus.ACCEPTED);
        }
}

