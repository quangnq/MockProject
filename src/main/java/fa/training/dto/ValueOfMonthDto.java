package fa.training.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ValueOfMonthDto {
    private Integer month;

    private Long value;

    private Integer year;

    public ValueOfMonthDto(Integer month, Long value, Integer year) {
        this.month = month;
        this.value = value;
        this.year = year;
    }
}
