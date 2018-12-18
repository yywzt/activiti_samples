package com.example.aspect;

import com.example.config.ResponseData;
import com.example.exception.NoLoginException;
import lombok.extern.slf4j.Slf4j;
import org.activiti.engine.repository.Model;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Title: 全局异常处理切面 Description: 利用 @ControllerAdvice + @ExceptionHandler
 * 组合处理Controller层RuntimeException异常
 * 
 * @author rico
 * @created 2017年7月4日 下午4:29:07
 */
@ControllerAdvice   // 控制器增强
@ResponseBody
@Slf4j
public class ExceptionAspect {

    private static ModelAndView modelAndView = new ModelAndView("/");

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler(HttpMessageNotReadableException.class)
	public ModelAndView handleHttpMessageNotReadableException(
			HttpMessageNotReadableException e, HttpServletRequest request) {
		log.error("could_not_read_json...", e);
		String info = "could_not_read_json";
        //自定义数据放入request中
        request.setAttribute("info",info);
        return modelAndView;
	}

	/**
	 * 400 - Bad Request
	 */
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	@ExceptionHandler({MethodArgumentNotValidException.class})
	public ModelAndView handleValidationException(MethodArgumentNotValidException e, HttpServletRequest request) {
		log.error("parameter_validation_exception...", e);
        BindingResult bindingResult = e.getBindingResult();
        List<ObjectError> allErrors = bindingResult.getAllErrors();
        StringBuffer msg = new StringBuffer();
        allErrors.forEach(objectError -> {
            msg.append(objectError.getDefaultMessage()).append(" ");
        });
		String info = msg.toString();
        //自定义数据放入request中
        request.setAttribute("info",info);
        return modelAndView;
	}

	/**
	 * 405 - Method Not Allowed。HttpRequestMethodNotSupportedException
	 * 是ServletException的子类,需要Servlet API支持
	 */
	@ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
	@ExceptionHandler(HttpRequestMethodNotSupportedException.class)
	public ModelAndView handleHttpRequestMethodNotSupportedException(
	        HttpRequestMethodNotSupportedException e, HttpServletRequest request) {
		log.error("request_method_not_supported...", e);
		String info = "request_method_not_supported";
        //自定义数据放入request中
        request.setAttribute("info",info);
        return modelAndView;
	}

	/**
	 * 415 - Unsupported Media Type。HttpMediaTypeNotSupportedException
	 * 是ServletException的子类,需要Servlet API支持
	 */
	@ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
	@ExceptionHandler({ HttpMediaTypeNotSupportedException.class })
	public ModelAndView handleHttpMediaTypeNotSupportedException(Exception e, HttpServletRequest request) {
		log.error("content_type_not_supported...", e);
		String info = "content_type_not_supported";
        //自定义数据放入request中
        request.setAttribute("info",info);
        return modelAndView;
	}

	/**
	 * 500 - Internal Server Error
	 */
//	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
//	@ExceptionHandler(TokenException.class)
//	public ModelAndView handleTokenException(Exception e, HttpServletRequest request) {
//		log.error("Token is invaild...", e);
//		String info = "Token is invaild";
//        //自定义数据放入request中
//        request.setAttribute("info",info);
//		return modelAndView;
//	}

	/**
	 * 500 - Internal Server Error
	 */
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	@ExceptionHandler(Exception.class)
	public ModelAndView handleException(Exception e,HttpServletRequest request) {
		log.error("Internal Server Error...", e);
		String info = "Internal Server Error";
        //自定义数据放入request中
        request.setAttribute("info",info);
        return modelAndView;
	}

	/**
	 * 403 - Internal Server Error
	 */
	@ResponseStatus(HttpStatus.FORBIDDEN)
	@ExceptionHandler(NoLoginException.class)
	public ModelAndView handleNoLoginException(Exception e,HttpServletRequest request) {
		log.error("请先登录", e);
		String info = e.getMessage();
        //自定义数据放入request中
        request.setAttribute("info",info);
        return modelAndView;
	}
}
