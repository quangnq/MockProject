package fa.training.service;

import fa.training.dto.BaseChartDto;
import fa.training.dto.InjectionResultReportDto;
import fa.training.dto.InjectionResultReportSearchDto;
import fa.training.dto.ValueOfMonthDto;
import fa.training.entity.InjectionResultEntity;
import fa.training.repository.InjectionResultRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Arrays;
import java.util.List;

@Service
public class InjectionResultService {

    @Autowired
    InjectionResultRepository injectionResultRepository;

    @Transactional
    public List<InjectionResultReportDto> findAll() {
        List<InjectionResultEntity> entityList = injectionResultRepository.findAll();
        return InjectionResultReportDto.cloneFromEntityList(entityList);
    }

    @Transactional
    public List<InjectionResultReportDto> findByFilter(InjectionResultReportSearchDto searchDto) {
        return InjectionResultReportDto.cloneFromEntityList(injectionResultRepository.findByFilter(searchDto));
    }

    @Transactional
    public void getInjectionResultChartDto(Integer year) {
        BaseChartDto baseChartDto = injectionResultRepository.buildMinMaxYear();
        boolean hasGettingValue = true;
        if (year == null) {
            year = baseChartDto.getMinYear();
        } else if (year < baseChartDto.getMinYear()) {
            hasGettingValue = false;
            baseChartDto.setMinYear(year);
        } else if (year > baseChartDto.getMaxYear()) {
            hasGettingValue = false;
            baseChartDto.setMaxYear(year);
        }

        if (hasGettingValue) {
            List<ValueOfMonthDto> valueOfMonthDtoList = injectionResultRepository.getValueMonthOfYear(year);
            baseChartDto.setValueOfMonthDto(valueOfMonthDtoList);
        }

        for (int i = baseChartDto.getMinYear(); i <= baseChartDto.getMaxYear(); i++) {
            baseChartDto.getYears().add(i);
        }

        System.out.println(baseChartDto.getYears());
        System.out.println();
        System.out.println(baseChartDto.getValueOfMonthDto());

    }
}
