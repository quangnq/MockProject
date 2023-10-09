package fa.training.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InjectionResultReportSearchDto extends BaseSearchDto {
    private String vaccineType;

    private String prevention;

}
