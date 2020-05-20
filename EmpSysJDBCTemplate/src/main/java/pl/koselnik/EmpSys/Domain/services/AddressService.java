package pl.koselnik.EmpSys.Domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import pl.koselnik.EmpSys.Domain.Address;
import pl.koselnik.EmpSys.Domain.repository.AddressRepository;
import java.util.List;

@Component
public class AddressService {

    @Autowired
    AddressRepository addressRepository;

    public void saveAddressToDB(List<Address> addressesFromFrom) {
        addressRepository.saveAddressToDB(addressesFromFrom);
    }


    public void newAddress(Address address) {
        addressRepository.addAddress(address);
    }

    public List<Address> getAddresses() {
        return addressRepository.getAddresses();
    }

    public Boolean getCheck() {
        return addressRepository.isCheckOfAddressIni();
    }

    @Override
    public String toString() {
        return "AddressService{" +
                "addressRepository=" + addressRepository +
                '}';
    }
}
