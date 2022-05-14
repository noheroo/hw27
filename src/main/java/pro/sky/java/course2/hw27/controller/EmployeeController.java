package pro.sky.java.course2.hw27.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pro.sky.java.course2.hw27.data.Employee;
import pro.sky.java.course2.hw27.services.EmployeeService;

import java.util.Map;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/add")
    public String addEmployee(@RequestParam String lastname, @RequestParam String firstname) {
        employeeService.addEmployee(lastname, firstname);
        return "Employee added";
    }

    @GetMapping("/remove")
    public String deleteEmployee(@RequestParam String lastname, @RequestParam String firstname) {
        employeeService.removeEmployee(lastname, firstname);
        return "Employee removed";
    }

    @GetMapping("/find")
    public Employee findEmployee(@RequestParam String lastname, @RequestParam String firstname) {
        return employeeService.findEmployee(lastname, firstname);
    }

    @GetMapping("/print")
    public Map<String, Employee> printEmployees() {
        return employeeService.printEmployees();
    }
}
