package com.example.employeepayrolldto.Repository;

import com.example.employeepayrolldto.Model.EmployeeData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface EmployeeRepo extends JpaRepository<EmployeeData, Integer> {

    List<EmployeeData> findBydepartment(String department);
}
