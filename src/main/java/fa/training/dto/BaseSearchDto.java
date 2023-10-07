package fa.training.dto;

import fa.training.exception.MockFinalException;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import java.time.LocalDate;

@Data
public class BaseSearchDto {

    private String fromDate;

    private String toDate;

    public void validate() {
        if (StringUtils.isNotEmpty(this.fromDate)) {
            try {
                LocalDate.parse(this.fromDate);
            } catch (Exception e) {
//                throw new MockFinalException("From Date is invalid");
                fromDate = "";
            }
        }
        if (StringUtils.isNotEmpty(this.toDate)) {
            try {
                LocalDate.parse(this.toDate);
            } catch (Exception e) {
//                throw new MockFinalException("To Date is invalid");
                toDate = "";
            }
        }
    }
}
