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
        String name = employee.getName();
        Address address = employee.getAddress();
        Employee newEmployee = new Employee(name, address);
        addressRepository.create(address);
        employeeRepository.create(newEmployee);
    }

    public List<Employee> readEmployees() {
        return employeeRepository.findAll();
    }

    public void updateEmployee(Employee employee) {
        Address address = employee.getAddress();
        addressRepository.update(address);
        employeeRepository.update(employee);
    }

    public void deleteEmployee(Long id) {
        employeeRepository.delete(id);
    }

    public Employee findEmployee(Long id) {
        return employeeRepository.findById(id);
    }
}
