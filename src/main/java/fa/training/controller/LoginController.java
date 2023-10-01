package fa.training.controller;

import fa.training.service.CustomerService;
import fa.training.service.InjectionResultService;
import fa.training.service.VaccineService;
import fa.training.service.VaccineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = {"/", "/login"})
public class LoginController {

    @Autowired
    CustomerService customerService;

    @Autowired
    VaccineService vaccineService;

    @Autowired
    InjectionResultService injectionResultService;

    @Autowired
    VaccineTypeService vaccineTypeService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String reportTotal(Model model) {

        System.out.println("-------------VACCINE_TYPE------------------");
        vaccineTypeService.findAll().forEach(e -> {
            System.out.println("-------------------------------");
            System.out.println("id : " + e.getVaccineTypeId());
            System.out.println("name : " + e.getVaccineTypeName());
            System.out.println();
        });

        System.out.println("-------------VACCINE------------------");
        vaccineService.findAll().forEach(e -> {
            System.out.println("-------------------------------");
            System.out.println("id : " + e.getVaccineId());
            System.out.println("name : " + e.getVaccineName());
            System.out.println();
        });

        System.out.println("-------------CUSTOMER------------------");
        customerService.findAll().forEach(e -> {
            System.out.println("-------------------------------");
            System.out.println("id : " + e.getCustomerId());
            System.out.println("name : " + e.getFullName());
            System.out.println();
        });

        System.out.println("-------------INJECTION_RESULT------------------");
        injectionResultService.findAll().forEach(e -> {
            System.out.println("-------------------------------");
            System.out.println("id : " + e.getInjectionResultId());
            System.out.println("name : " + e.getInjectionDate());
            System.out.println();
        });

        return "Login";
    }
}
