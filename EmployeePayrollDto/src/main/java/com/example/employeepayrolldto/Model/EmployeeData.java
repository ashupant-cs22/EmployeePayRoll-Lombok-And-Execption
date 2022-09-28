package com.example.employeepayrolldto.Model;

import com.example.employeepayrolldto.Dto.EmployeeDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@NoArgsConstructor
@Data
@AllArgsConstructor
@Entity
public class EmployeeData {
    String firstName;
    String lastName;
    String department;
    String gender;
    String message;
    Long salary;
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Integer id;

    public EmployeeData(EmployeeDto employeeDto) {
        this.firstName = employeeDto.getFirstName();
        this.lastName = employeeDto.getLastName();
        this.department = employeeDto.getDepartment();
        this.message = employeeDto.getMessage();
        this.gender = employeeDto.getGender();
        this.salary = employeeDto.getSalary();

    }

}
