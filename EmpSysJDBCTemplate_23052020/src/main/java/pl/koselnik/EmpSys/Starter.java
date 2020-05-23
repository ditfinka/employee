package pl.koselnik.EmpSys;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pl.koselnik.EmpSys.Domain.dto.AddressCreationDto;
import pl.koselnik.EmpSys.Domain.repository.AddressRepository;
import pl.koselnik.EmpSys.Domain.repository.EmployeeRepository;

@Component
public class Starter implements CommandLineRunner {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    AddressRepository addressRepository;
    @Autowired
    AddressCreationDto addressCreationDto;

    @Override
    public void run(String... args) throws Exception {

    }
}
