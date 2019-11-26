package me.donnatto.isilemployees.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import me.donnatto.isilemployees.model.Address;
import me.donnatto.isilemployees.model.Employee;
import me.donnatto.isilemployees.service.AddressService;
import me.donnatto.isilemployees.service.EmployeeService;

@Controller
@RequestMapping("/employees")
public class EmployeeController {

  EmployeeService empService;
  AddressService addService;

  @Autowired
  public EmployeeController(EmployeeService empService, AddressService addService) {
    this.empService = empService;
    this.addService = addService;
  }

  @GetMapping
  public String getAll(Model model) {
    List<Employee> employees = empService.readEmployees();
    model.addAttribute("employees", employees);
    return "employees";
  }

  @GetMapping("/add")
  public String newEmployee(Model model) {
    model.addAttribute("employee", new Employee());
    return "employees-add";
  }

  @PostMapping("/add")
  public String saveEmployee(Employee employee, Model model) {
    try {
      Address address = employee.getAddress();
      addService.createAddress(address);
      empService.creatEmployee(employee);
      return "redirect:/employees";
    } catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("error", e);
      return "error";
    }
  }

  @GetMapping("/edit/{id}")
  public String getForUpdate(@PathVariable Long id, Model model) {
    try {
      Employee employee = empService.findEmployee(id);
      model.addAttribute("employee", employee);
      return "employees-edit";
    } catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("error", e);
      return "error";
    }
  }

  @PostMapping("/edit/{id}")
  public String updateEmp(@PathVariable Long id, Employee employee, Model model) {
    try {
      Employee currEmp = empService.findEmployee(id);
      Address currAddress = addService.findAddress(currEmp.getAddress().getAddressId());

      currEmp.setName(employee.getName());
      currEmp.setAddress(employee.getAddress());
      currAddress.setCountry(employee.getAddress().getCountry());
      currAddress.setCity(employee.getAddress().getCity());
      currAddress.setStreet(employee.getAddress().getStreet());

      addService.updateAddress(currAddress);
      empService.updateEmployee(currEmp);
      return "redirect:/employees";
    } catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("error", e);
      return "error";
    }
  }

  @GetMapping("/delete/{id}")
  public String delete(@PathVariable Long id, Model model) {
    try {
      Employee emp = empService.findEmployee(id);
      Integer addId = emp.getAddress().getAddressId();
      empService.deleteEmployee(id);
      addService.deleteAddress(addId);
      return "redirect:/employees";
    } catch (Exception e) {
      e.printStackTrace();
      model.addAttribute("error", e);
      return "error";
    }
  }

}