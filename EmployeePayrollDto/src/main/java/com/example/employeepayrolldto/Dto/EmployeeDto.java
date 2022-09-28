package com.example.employeepayrolldto.Dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class EmployeeDto {

    String firstName;
    String lastName;
    String department;
    String gender;
    String message;
    private Long salary;

}