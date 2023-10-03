package fa.training.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@Data
public class ValueOfMonthDto {
    private Integer month;

    private Long value;

    public ValueOfMonthDto(Integer month, Long value) {
        this.month = month;
        this.value = value;
    }
}
