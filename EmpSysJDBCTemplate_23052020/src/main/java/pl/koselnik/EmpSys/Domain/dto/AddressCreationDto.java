package pl.koselnik.EmpSys.Domain.dto;

import pl.koselnik.EmpSys.Domain.Address;
import java.util.List;

public class AddressCreationDto {

    private List<Address> addresses;
    private boolean checkOfAddressIni = false;



    public AddressCreationDto() {
    }

    public AddressCreationDto(List<Address> addresses) {
        this.addresses = addresses;
    }

    public void addAddress(Address address) {
        if (addresses.size() == 1) {
            address.setType("C");
        } else address.setType("P");;
        checkOfAddressIni = true;
        this.addresses.add(address);
    }

    public List<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Address> addresses) {
        this.addresses = addresses;
    }

    public boolean isCheckOfAddressIni() {
        return checkOfAddressIni;
    }
}
