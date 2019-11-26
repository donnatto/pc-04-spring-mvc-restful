package me.donnatto.isilemployees.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Employee {
    private Long id;
    private String name;
    private Long addressId;

    public Employee(String name, Long addressId) {
        this.name = name;
        this.addressId = addressId;
    }
}
