package me.donnatto.isilemployees.service;

import me.donnatto.isilemployees.model.Address;
import me.donnatto.isilemployees.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressService {

    private AddressRepository addressRepository;

    @Autowired
    public AddressService(AddressRepository addressRepository) {
        this.addressRepository = addressRepository;
    }

    public void createAddress(Address address) {
        addressRepository.create(address);
    }

    public List<Address> readAddress() {
        return addressRepository.findAll();
    }

    public void updateAddress(Address address) {
        addressRepository.update(address);
    }

    public void deleteAddress(Long id) {
        addressRepository.delete(id);
    }

    public Address findAddress(Long id) {
        return addressRepository.findById(id);
    }
}
