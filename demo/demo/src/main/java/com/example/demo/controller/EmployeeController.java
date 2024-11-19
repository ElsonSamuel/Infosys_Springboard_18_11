package com.example.demo.controller;

import com.example.demo.model.Employee;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final Map<Integer, Employee> employeeDatabase = new HashMap<>();

    public EmployeeController() {
        employeeDatabase.put(1, new Employee(1, "Deepak", "Front-End Developer"));
        employeeDatabase.put(2, new Employee(2, "Joseph", "Back-End Developer"));
        employeeDatabase.put(3, new Employee(3, "Hari", "UX Designer"));
    }

    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        return employeeDatabase.getOrDefault(id, new Employee(0, "Not Found", "N/A"));
    }

    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        if (employeeDatabase.containsKey(employee.getId())) {
            return "Employee with ID " + employee.getId() + " already exists!";
        }
        employeeDatabase.put(employee.getId(), employee);
        return "Employee added successfully!";
    }

    @GetMapping
    public Map<Integer, Employee> getAllEmployees() {
        return employeeDatabase;
    }
}


