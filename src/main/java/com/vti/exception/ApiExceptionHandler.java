package com.vti.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ApiExceptionHandler {
   
	// Tất cả các Exception không được khai báo sẽ được xử lý tại đây
	@ExceptionHandler(Exception.class)
	@ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
	public ErrorMessage handlerAllException(Exception ex, WebRequest request) {
		// quá trình kiểm soát lỗi diễn ra ở đây
		return new ErrorMessage(10000, ex.getLocalizedMessage());
	}
	
	// IndexOutOfBoundsException sẽ được xử lý riêng tại đây
	@ExceptionHandler(IndexOutOfBoundsException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage IndexOfException(Exception ex, WebRequest request) {
		return new ErrorMessage(10100,"Đối tượng không tồn tại"); 
	}
	
	// NullPointerException sẽ được xử lý riêng tại đây
	@ExceptionHandler(NullPointerException.class)
	@ResponseStatus(value = HttpStatus.BAD_REQUEST)
	public ErrorMessage nullPointException(Exception ex, WebRequest request) {
		return new ErrorMessage(100123, "Object không tồn tại"); 
	}
	
}
