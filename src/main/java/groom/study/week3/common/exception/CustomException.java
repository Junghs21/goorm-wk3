package groom.study.week3.common.exception;

import groom.study.week3.common.Constants;
import org.springframework.http.HttpStatus;

public class CustomException extends Exception {
    private Constants.ExceptionClass exceptionClass;
    private HttpStatus httpStatus;

    public CustomException(Constants.ExceptionClass exceptionClass, HttpStatus httpStatus, String message) {
        super(exceptionClass.toString() + message);
        this.exceptionClass = exceptionClass;
        this.httpStatus = httpStatus;
    }

    public Constants.ExceptionClass getExceptionClass() {
        return exceptionClass;
    }

    public int getHttpStatusCode() {
        //구현
        return this.httpStatus.value();
    }

    public String getHttpStatusType() {
        //구현
        return this.httpStatus.getReasonPhrase();
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

}