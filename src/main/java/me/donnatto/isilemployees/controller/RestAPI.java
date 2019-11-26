package me.donnatto.isilemployees.controller;

import me.donnatto.isilemployees.model.Address;
import me.donnatto.isilemployees.model.Employee;
import me.donnatto.isilemployees.service.AddressService;
import me.donnatto.isilemployees.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestAPI {

    private AddressService addressService;
    private EmployeeService employeeService;

    @Autowired
    public RestAPI(AddressService addressService, EmployeeService employeeService) {
        this.addressService = addressService;
        this.employeeService = employeeService;
    }


    // EMPLOYEES***************************
    @GetMapping("/employees")
    public ResponseEntity getAllEmployees() {
        List<Employee> employees = employeeService.readEmployees();
        if (employees == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(employees, HttpStatus.OK);
    }

    @GetMapping("/employees/{id}")
    public ResponseEntity getEmployeeById(@PathVariable Long id) {
        Employee currentEmployee = employeeService.findEmployee(id);
        if (currentEmployee == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(currentEmployee, HttpStatus.OK);
    }

    @PostMapping("/employees")
    public ResponseEntity createEmployee(@RequestBody Employee employee) {
        employeeService.creatEmployee(employee);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/employees/{id}")
    public ResponseEntity updateEmployee(@PathVariable Long id, @RequestBody Employee employee) {
        Employee currentEmployee = employeeService.findEmployee(id);
        if (currentEmployee == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        currentEmployee.setName(employee.getName());
        Address address = new Address(employee.getAddress().getCountry(), employee.getAddress().getCity(), employee.getAddress().getStreet());

        currentEmployee.setAddress(address);

        employeeService.updateEmployee(currentEmployee);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/employees/{id}")
    public ResponseEntity deleteEmployee(@PathVariable Long id) {
        Employee currentEmployee = employeeService.findEmployee(id);
        if (currentEmployee == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        employeeService.deleteEmployee(id);
        return new ResponseEntity(HttpStatus.OK);
    }


    // ADDRESSES**************************
    @GetMapping("/addresses")
    public ResponseEntity getAllAddresses() {
        List<Address> addresses = addressService.readAddress();
        if (addresses == null) {
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity(addresses, HttpStatus.OK);
    }

    @GetMapping("/addresses/{id}")
    public ResponseEntity getAddressById(@PathVariable Long id) {
        Address currentAddress = addressService.findAddress(id);
        if (currentAddress == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity(currentAddress, HttpStatus.OK);
    }

    @PostMapping("/addresses")
    public ResponseEntity createAddress(@RequestBody Address address) {
        addressService.createAddress(address);
        return new ResponseEntity(HttpStatus.CREATED);
    }

    @PutMapping("/addresses/{id}")
    public ResponseEntity updateAddress(@PathVariable Long id, @RequestBody Address address) {
        Address currentAddress = addressService.findAddress(id);
        if (currentAddress == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
        currentAddress.setCountry(address.getCountry());
        currentAddress.setCity(address.getCity());
        currentAddress.setStreet(address.getStreet());

        addressService.updateAddress(currentAddress);

        return new ResponseEntity(HttpStatus.OK);
    }

    @DeleteMapping("/addresses/{id}")
    public ResponseEntity deleteAddress(@PathVariable Long id) {
        Address currentAddress = addressService.findAddress(id);
        if (currentAddress == null) {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }

        addressService.deleteAddress(id);
        return new ResponseEntity(HttpStatus.OK);
    }
}
