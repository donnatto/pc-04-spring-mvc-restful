package me.donnatto.isilemployees.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Address {
    private Long addressId;
    private String country;
    private String city;
    private String street;
}
