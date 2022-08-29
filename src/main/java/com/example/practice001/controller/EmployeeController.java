package com.example.practice001.controller;

import com.example.practice001.model.Employee;
import com.example.practice001.repository.EmployeeRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {
    private final EmployeeRepository employeeRepository;

    public EmployeeController(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/getAll")
    public List<Employee> getAll(){
        return employeeRepository.findAll();
    }

    @GetMapping("/get/{id}")
    public Employee getById(@PathVariable Long id){
        return employeeRepository.findById(id);
    }

    @PostMapping ("/insert")
    public Employee insert(
            @RequestParam String name,
            @RequestParam String gender,
            @RequestParam String email)
    {
        return employeeRepository.save(new Employee(name,gender,email));
    }

    @DeleteMapping("/delete/{id}")
    public Employee deleteById(@PathVariable Long id){
        return employeeRepository.deleteById(id);
    }

    @PutMapping("/update")
    public Employee update(
            @RequestParam Long id,
            @RequestParam String name,
            @RequestParam String gender,
            @RequestParam String email
    ){
        return employeeRepository.update(new Employee(id,name,gender,email));
    }
}
