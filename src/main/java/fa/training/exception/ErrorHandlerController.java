package fa.training.exception;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

/**
 * Lớp {@code ErrorHandlerController} là một ControllerAdvice được sử dụng để xử lý các ngoại lệ (exceptions)
 * trong ứng dụng. Nó ghi log lỗi và trả về một ResponseEntity chứa lỗi gốc, để giúp theo dõi và gỡ lỗi ứng dụng.
 *
 * @see ExceptionHandler
 * @see ResponseEntity
 * @see WebRequest
 * @version 1.0
 * @since 1 thg 10, 2023
 */
@ControllerAdvice
public class ErrorHandlerController {
	 /**
     * Phương thức xử lý các ngoại lệ (exceptions) trong ứng dụng và trả về một ResponseEntity chứa lỗi gốc.
     *
     * @param ex      Ngoại lệ (exception) được ném ra.
     * @param request Đối tượng {@code WebRequest} chứa thông tin về yêu cầu HTTP.
     * @return Một ResponseEntity chứa lỗi gốc.
     * @throws Exception Nếu có lỗi trong quá trình xử lý.
     */
    @ExceptionHandler(value = {Exception.class})
    protected ResponseEntity handleException(Exception ex, WebRequest request) throws Exception {
        ex.printStackTrace();

        throw ex;
    }
}
