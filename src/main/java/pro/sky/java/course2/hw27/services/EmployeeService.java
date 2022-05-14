package pro.sky.java.course2.hw27.services;

import org.springframework.stereotype.Service;
import pro.sky.java.course2.hw27.data.Employee;
import pro.sky.java.course2.hw27.exeptions.EmployeeNotFoundException;

import java.util.Map;

@Service
public class EmployeeService {
    private final Map<String, Employee> employees;

    public EmployeeService(Map<String, Employee> employees) {
        this.employees = employees;
    }


    public void addEmployee(String lastName, String firstName) {
        Employee employee = new Employee(lastName, firstName);
        employees.put(createKey(lastName, firstName), employee);
    }

    public void removeEmployee(String lastName, String firstName) {
        if (!employees.containsKey(createKey(lastName, firstName))) {
            throw new EmployeeNotFoundException();
        }
        employees.remove(createKey(lastName, firstName));
    }

    public Employee findEmployee(String lastName, String firstName) {
        if (!employees.containsKey(createKey(lastName, firstName))) {
            throw new EmployeeNotFoundException();
        }
        return employees.get(createKey(lastName, firstName));
    }

    public Map<String,Employee> printEmployees() {
        return employees;
    }

    private String createKey(String lastName, String firstName) {
        return lastName + firstName;
    }

}


