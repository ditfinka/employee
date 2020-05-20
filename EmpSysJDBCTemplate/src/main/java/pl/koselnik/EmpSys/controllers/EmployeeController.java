package pl.koselnik.EmpSys.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.beanvalidation.LocalValidatorFactoryBean;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import pl.koselnik.EmpSys.Domain.Address;
import pl.koselnik.EmpSys.Domain.Employee;
import pl.koselnik.EmpSys.Domain.repository.AddressRepository;
import pl.koselnik.EmpSys.Domain.services.AddressService;
import pl.koselnik.EmpSys.Domain.services.EmployeeService;
import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Controller
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    AddressService addressService;



    //For messages_pl.properties
    @Bean
    public LocalValidatorFactoryBean localValidatorFactoryBean(MessageSource messageSource) {
        LocalValidatorFactoryBean bean = new LocalValidatorFactoryBean();
        bean.setValidationMessageSource(messageSource);
        return bean;
    }

    @RequestMapping("/")
    public String startPage(Model model) {
        model.addAttribute("start");
        return "home";
    }

    @RequestMapping("/employees")
    public String getEmployees(Model model) {
        List<Employee> allEmployees = employeeService.getAllEmployees();
        model.addAttribute("naglowek","Lista Firm");
        model.addAttribute("employees", allEmployees);
        return "employees";
    }
// For single object
//    @RequestMapping("/new")
//    public String addNewEmployee(Model model) {
//        model.addAttribute("employee", new Employee()).addAttribute("address", new Address());
//        //model.addAttribute("employee",Employee.builder().setActive(true));
//        return "new_employee_form";
//    }


    @GetMapping("/new")
    public String showCreateFormForEmployeeAndAddresses(Model model) {

        if(addressService.getCheck()== false) {
            for (int i = 1; i <= 2; i++) {
                addressService.newAddress(new Address());
            }
        }
        model.addAttribute("employee", new Employee()).addAttribute("form", addressService);
        System.out.println(addressService);
        return "new_employee_form";
    }



    @RequestMapping(value = "/employees", method = RequestMethod.POST)
    public String saveEmployeeAndAddress(@ModelAttribute @Valid Employee employee,
                                        BindingResult bindingResultEmployee,
                                        @ModelAttribute @Valid AddressRepository addressesFromForm,
                                        BindingResult bindingResultAddressRepository, Model model)  {

        if(bindingResultEmployee.hasErrors() || bindingResultAddressRepository.hasErrors()) {

            List<Address> list = addressService.getAddresses();
System.out.println(list);
            model.addAttribute("employee", employee).addAttribute("form", list);
            return "new_employee_form";

        } else{
            ExecutorService executor = Executors.newSingleThreadExecutor();
            Runnable runnableEmployee = () -> employeeService.saveEmployeeToDB(employee);
          //  AddressRepository addressesList = addressesFromForm.getAddresses();
          //  Runnable runnableAddress = () -> addressService.saveAddressToDB(addressesList);

            executor.submit(runnableEmployee);
          //  executor.submit(runnableAddress);

            return "redirect:/employees";
        }
    }






}

