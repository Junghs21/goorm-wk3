package groom.study.week3.common.exception;

import java.util.HashMap;
import java.util.Map;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice //(basePackages = "groom.study.week3.common.exception")
public class CustomExceptionHandler {

    private final Logger LOGGER = LoggerFactory.getLogger(CustomExceptionHandler.class);

    @ExceptionHandler(CustomException.class)
    public ResponseEntity<Map<String, String>> handleException(CustomException e, jakarta.servlet.http.HttpServletRequest request) {
        //구현
        LOGGER.error("CustomException 발생: {}", e.getMessage());

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("code", String.valueOf(e.getHttpStatusCode()));
        errorResponse.put("error type", e.getHttpStatusType());
        errorResponse.put("message", e.getMessage());

        return new ResponseEntity<>(errorResponse, e.getHttpStatus());
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, String>> handleException(RuntimeException e, jakarta.servlet.http.HttpServletRequest request) {
        //구현
        LOGGER.error("RuntimeException 발생: {}", e.getMessage());

        Map<String, String> errorResponse = new HashMap<>();
        errorResponse.put("code", "400");
        errorResponse.put("error type", "Bad Request");
        errorResponse.put("message", e.getMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }
}