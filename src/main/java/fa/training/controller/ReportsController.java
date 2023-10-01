package fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "/report")
public class ReportsController {

    @RequestMapping(value = "", method = RequestMethod.GET)
    public String reportTotal(Model model) {
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
