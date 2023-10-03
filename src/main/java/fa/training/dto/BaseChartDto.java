package fa.training.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class BaseChartDto {
    private Integer minYear;
    private Integer maxYear;
    private Integer selectedYear;
    private List<Integer> years = new ArrayList<>();
    private List<ValueOfMonthDto> valueOfMonthDto;

    public BaseChartDto(Integer minYear, Integer maxYear) {
        this.minYear = minYear;
        this.maxYear = maxYear;
    }
}
