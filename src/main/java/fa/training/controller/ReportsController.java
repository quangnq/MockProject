package fa.training.controller;

import fa.training.dto.*;
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
    public String reportTotal(Model model, InjectionResultReportSearchDto searchDto) {
        searchDto.validate();
//        System.out.println("-------------INJECTION_RESULT------------------");
        List<InjectionResultReportDto> reportDtoList = injectionResultService.findByFilter(searchDto);
//        System.out.println("-------------VACCINE_TYPE------------------");
        List<VaccineTypeDto> vaccineTypeDtoList = vaccineTypeService.findAll();

        BaseChartDto baseChartDto = injectionResultService.getChartDto();
        model.addAttribute("vaccineTypeDtoList", vaccineTypeDtoList);
        model.addAttribute("reportDtoList", reportDtoList);
        model.addAttribute("baseChartDto", baseChartDto);
        model.addAttribute("searchDto", searchDto);

        return "reports/Report";
    }

    @RequestMapping(value = "/customer", method = RequestMethod.GET)
    public String reportCustomer(Model model, CustomerReportSearchDto searchDto) {
        searchDto.validate();
        List<CustomerReportDto> reportDtoList = customerService.findByFilter(searchDto);
        BaseChartDto baseChartDto = injectionResultService.getChartDto();

        model.addAttribute("searchDto", searchDto);
        model.addAttribute("reportDtoList", reportDtoList);
        model.addAttribute("baseChartDto", baseChartDto);

        return "reports/ReportCustomer";
    }

    @RequestMapping(value = "/vaccine", method = RequestMethod.GET)
    public String reportVaccine(Model model, VaccineReportSearchDto searchDto) {
        searchDto.validate();
        List<VaccineReportDto> reportDtoList = vaccineService.findByFilter(searchDto);
        BaseChartDto baseChartDto = injectionResultService.getChartDto();
        List<VaccineTypeDto> vaccineTypeDtoList = vaccineTypeService.findAll();

        model.addAttribute("vaccineTypeDtoList", vaccineTypeDtoList);
        model.addAttribute("searchDto", searchDto);
        model.addAttribute("reportDtoList", reportDtoList);
        model.addAttribute("baseChartDto", baseChartDto);

        return "reports/ReportVaccine";
    }
}
