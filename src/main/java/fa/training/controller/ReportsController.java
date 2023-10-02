package fa.training.controller;

import fa.training.dto.InjectionResultReportDto;
import fa.training.dto.VaccineTypeDto;
import fa.training.service.CustomerService;
import fa.training.service.InjectionResultService;
import fa.training.service.VaccineService;
import fa.training.service.VaccineTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
@RequestMapping(value = "/report")
public class ReportsController {

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
//        System.out.println("-------------INJECTION_RESULT------------------");
        List<InjectionResultReportDto> injectionResultReportDtoList = injectionResultService.findAll();
//        injectionResultReportDtoList.forEach(e -> {
//            System.out.println("-------------------------------");
//            System.out.println("id : " + e.getInjectionResultId());
//            System.out.println("name : " + e.getPrevention());
//            System.out.println();
//        });
//        System.out.println("-------------VACCINE_TYPE------------------");
        List<VaccineTypeDto> vaccineTypeDtoList = vaccineTypeService.findAll();
//        vaccineTypeDtoList.forEach(e -> {
//            System.out.println("-------------------------------");
//            System.out.println("id : " + e.getVaccineTypeId());
//            System.out.println("name : " + e.getVaccineTypeName());
//            System.out.println();
//        });
        model.addAttribute("vaccineTypeDtoList", vaccineTypeDtoList);
        model.addAttribute("injectionResultReportDtoList", injectionResultReportDtoList);
        return "reports/Report";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String reportCustomer(Model model) {
        return "reports/ReportCustomer";
    }

    @RequestMapping(value = "/vaccine", method = RequestMethod.GET)
    public String reportVaccine(Model model) {
        return "reports/ReportVaccine";
    }
}
