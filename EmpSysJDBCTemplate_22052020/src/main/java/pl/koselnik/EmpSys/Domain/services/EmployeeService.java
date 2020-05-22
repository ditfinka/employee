package pl.koselnik.EmpSys.Domain.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.koselnik.EmpSys.Domain.Employee;
import pl.koselnik.EmpSys.Domain.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

@Component
public class EmployeeService {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return new ArrayList<>(employeeRepository.getAllEmployees());
    }

    public void saveEmployeeToDB(Employee employee) {
        if(employee.getActive() == null){
            employeeRepository.setEmployeeActive(employee);
        }
        employeeRepository.saveEmployeeToDB(employee);

    }

    public Employee getEmployee() {
        return employeeRepository.getEmployee();
    }
}
