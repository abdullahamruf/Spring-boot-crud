package com.example.angularjavaproject.Controller;

import com.example.angularjavaproject.Model.Employee;
import com.example.angularjavaproject.Repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api/v1/")
public class EmployeeController {
    @Autowired
    private EmployeeRepository employeeRepository;
    @GetMapping("/employee")
    public List<Employee> getAllemployee(){
       return  employeeRepository.findAll();    }

    @PostMapping("/employee")
    public Employee CreateEmployee( @RequestBody Employee employee){
        return employeeRepository.save(employee);
    }
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable Long id){
        Employee employee=employeeRepository.findById(id).orElseThrow();
        return ResponseEntity.ok(employee);
    }
    @PutMapping("/employee/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable Long id, @RequestBody Employee getEmployee){
        Employee employee=employeeRepository.findById(id).orElseThrow();
        employee.setFirstName(getEmployee.getFirstName());
        employee.setLastName(getEmployee.getLastName());
        employee.setEmailId(getEmployee.getEmailId());
        employee.setDesignation(getEmployee.getDesignation());
        Employee updateEmployee= employeeRepository.save(employee);
        return ResponseEntity.ok(updateEmployee);
    }
    @DeleteMapping("/employee/{id}")
    public ResponseEntity<Employee> deletebyid(@PathVariable Long id){
        Employee employee=employeeRepository.findById(id).orElseThrow();
        employeeRepository.deleteById(id);
        return ResponseEntity.ok(employee);

    }



}
