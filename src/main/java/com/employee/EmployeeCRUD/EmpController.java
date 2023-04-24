package com.employee.EmployeeCRUD;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class EmpController {
    private final EmpRepository empRepository;

    @GetMapping("/employees")
    List<Employee> all() {
        return empRepository.findAll();
    }

    @GetMapping("/employees/{id}")
    Employee getEmp(@PathVariable long id) {
        return empRepository.findById(id).orElseThrow(() -> new EmployeeNotFoundException(id));
    }

    @PostMapping("/employees")
    Employee createEmployee(@RequestBody Employee emp) {
        return empRepository.save(emp);
    }

    @PostMapping("/employees/{id}")
    Employee updateEmp(@RequestBody Employee employee, @PathVariable long id) {
        return empRepository.findById(id).map(emp -> {
                    emp.setFirstName(employee.getFirstName());
                    emp.setLastName(employee.getLastName());
                    emp.setDepartment(employee.getDepartment());
                    emp.setLocation(employee.getLocation());
                    return empRepository.save(employee);
                }
        ).orElseGet(() -> {
            return empRepository.save(employee);
        });
    }

    @DeleteMapping("employees/{id}")
    void deleteEmp(@PathVariable long id) {
        empRepository.deleteById(id);
    }
}
