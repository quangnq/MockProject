package fa.training.controller;

import fa.training.repository.InjectionResultRepository;
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

    @Autowired
    InjectionResultRepository injectionResultRepository;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String reportTotal(Model model) {
        // test select chart value
        return "Login";
    }
}
