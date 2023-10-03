package fa.training.dto;

import fa.training.exception.MockFinalException;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class InjectionResultReportSearchDto extends BaseSearchDto {
    private String vaccineType;

    private String prevention;

}
