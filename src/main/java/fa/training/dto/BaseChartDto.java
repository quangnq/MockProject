package fa.training.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseChartDto {
    private Map<String, Long[]> yearAndMonthValue = new LinkedHashMap<>();

    public BaseChartDto(List<ValueOfMonthDto> valueOfMonths) {
        if (CollectionUtils.isEmpty(valueOfMonths)) {
            return;
        }
        int minYear = valueOfMonths.get(0).getYear();
        int maxYear = valueOfMonths.get(valueOfMonths.size() - 1).getYear();
        for (int year = minYear; year <= maxYear; year++) {
            // khởi tạo giá trị tháng của năm ban đâù
            yearAndMonthValue.put(String.valueOf(year), new Long[]{0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l, 0l});
        }
        for (ValueOfMonthDto dto : valueOfMonths) {
            Long[] monthValues =  yearAndMonthValue.get(String.valueOf(dto.getYear()));
            monthValues[dto.getMonth() - 1] = dto.getValue();
        }
    }
}
