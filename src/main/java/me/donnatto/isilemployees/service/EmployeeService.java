package me.donnatto.isilemployees.service;

import me.donnatto.isilemployees.model.Employee;
import me.donnatto.isilemployees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public void creatEmployee(Employee employee) {
        String name = employee.getName();
        Long addId = employee.getAddressId();
        Employee newEmployee = new Employee(name, addId);
        employeeRepository.create(newEmployee);
    }

    public List<Employee> readEmployees() {
        return employeeRepository.findAll();
    }

    public void updateEmployee(Employee employee) {
        employeeRepository.update(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.delete(id);
    }

    public Employee findEmployee(Long id) {
        return employeeRepository.findById(id);
    }
}
