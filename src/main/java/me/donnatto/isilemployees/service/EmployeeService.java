package me.donnatto.isilemployees.service;

import me.donnatto.isilemployees.model.Address;
import me.donnatto.isilemployees.model.Employee;
import me.donnatto.isilemployees.repository.AddressRepository;
import me.donnatto.isilemployees.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private AddressRepository addressRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository, AddressRepository addressRepository) {
        this.employeeRepository = employeeRepository;
        this.addressRepository = addressRepository;
    }

    public void creatEmployee(Employee employee) {
        employeeRepository.create(employee);
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
