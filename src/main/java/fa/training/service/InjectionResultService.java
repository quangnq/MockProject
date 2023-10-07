package fa.training.service;

import fa.training.dto.BaseChartDto;
import fa.training.dto.InjectionResultReportDto;
import fa.training.dto.InjectionResultReportSearchDto;
import fa.training.dto.ValueOfMonthDto;
import fa.training.repository.InjectionResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class InjectionResultService {

    @Autowired
    InjectionResultRepository injectionResultRepository;

    @Transactional
    public List<InjectionResultReportDto> findByFilter(InjectionResultReportSearchDto searchDto) {
        return InjectionResultReportDto.cloneFromEntityList(injectionResultRepository.findByFilter(searchDto));
    }

    @Transactional
    public BaseChartDto getChartDto() {

        List<ValueOfMonthDto> valueOfMonthDtoList = injectionResultRepository.getValueMonthOfYear();
        BaseChartDto baseChartDto = new BaseChartDto(valueOfMonthDtoList);

        return baseChartDto;

    }
}
