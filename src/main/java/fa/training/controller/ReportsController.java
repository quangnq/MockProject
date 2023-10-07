package fa.training.controller;

import fa.training.dto.BaseChartDto;
import fa.training.dto.InjectionResultReportDto;
import fa.training.dto.InjectionResultReportSearchDto;
import fa.training.dto.VaccineTypeDto;
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
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDate;
import java.util.HashMap;
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
    public String reportTotal(Model model, InjectionResultReportSearchDto searchDto, HttpServletRequest request) {
        searchDto.validate();
//        System.out.println("-------------INJECTION_RESULT------------------");
        List<InjectionResultReportDto> injectionResultReportDtoList = injectionResultService.findByFilter(searchDto);
//        System.out.println("-------------VACCINE_TYPE------------------");
        List<VaccineTypeDto> vaccineTypeDtoList = vaccineTypeService.findAll();

        BaseChartDto baseChartDto = injectionResultService.getInjectionResultChartDto();
        model.addAttribute("vaccineTypeDtoList", vaccineTypeDtoList);
        model.addAttribute("injectionResultReportDtoList", injectionResultReportDtoList);
        model.addAttribute("baseChartDto", baseChartDto);
        model.addAttribute("searchDto", searchDto);

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
