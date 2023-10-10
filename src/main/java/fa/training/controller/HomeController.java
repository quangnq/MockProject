package fa.training.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping(value = "")
public class HomeController {
     
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String reportTotal(Model model) {

        return "redirect:/report";
    }
    
}
