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


/**
 * Lớp {@code ReportsController} là một bộ điều khiển Spring MVC đảm nhận nhiệm vụ xử lý
 * các yêu cầu liên quan đến việc tạo và hiển thị các báo cáo liên quan đến dữ liệu tiêm chủng
 * của khách hàng, thông tin về vaccine và kết quả tiêm chủng.
 *
 * Bộ điều khiển này cung cấp các phương thức để tạo ra các loại báo cáo khác nhau, bao gồm:
 * - Báo cáo Tổng kết Kết quả Tiêm chủng
 * - Báo cáo Khách hàng
 * - Báo cáo Vaccine
 *
 * Mỗi báo cáo có thể được lọc dựa trên tiêu chí cụ thể bằng cách sử dụng các Đối tượng Truyền dữ liệu (DTO) đã cung cấp.
 *
 * @author phinv1
 * @version 1.0
 * @since 1 thg 10, 2023
 */
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
    
    /**
     * Xử lý yêu cầu GET để tạo Báo cáo Tổng kết Kết quả Tiêm chủng.
     *
     * @param model      Model Spring MVC để thêm các thuộc tính cho việc hiển thị view.
     * @param searchDto  InjectionResultReportSearchDto chứa các tiêu chí lọc.
     * @return Tên view để hiển thị Báo cáo Tổng kết Kết quả Tiêm chủng.
     */   
    @RequestMapping(value = "", method = RequestMethod.GET)
    public String reportTotal(Model model, InjectionResultReportSearchDto searchDto) {
        searchDto.validate();
        
        List<InjectionResultReportDto> reportDtoList = injectionResultService.findByFilter(searchDto);
        
        List<VaccineTypeDto> vaccineTypeDtoList = vaccineTypeService.findAll();

        BaseChartDto baseChartDto = injectionResultService.getChartDto();
        model.addAttribute("vaccineTypeDtoList", vaccineTypeDtoList);
        model.addAttribute("reportDtoList", reportDtoList);
        model.addAttribute("baseChartDto", baseChartDto);
        model.addAttribute("searchDto", searchDto);

        return "reports/Report";
    }
        
    /**
     * Xử lý yêu cầu GET để tạo Báo cáo Khách hàng.
     *
     * @param model      Model Spring MVC để thêm các thuộc tính cho việc hiển thị view.
     * @param searchDto  CustomerReportSearchDto chứa các tiêu chí lọc.
     * @return Tên view để hiển thị Báo cáo Khách hàng.
     */
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
    
    /**
     * Xử lý yêu cầu GET để tạo Báo cáo Vaccine.
     *
     * @param model      Model Spring MVC để thêm các thuộc tính cho việc hiển thị view.
     * @param searchDto  VaccineReportSearchDto chứa các tiêu chí lọc.
     * @return Tên view để hiển thị Báo cáo Vaccine.
     */
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
