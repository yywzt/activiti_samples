package com.example.config;

/**
 * Title: 统一响应结构 
 * Description:使用REST框架实现前后端分离架构，我们需要首先确定返回的JSON响应结构是统一的，
 * 也就是说，每个REST请求将返回相同结构的JSON响应结构。不妨定义一个相对通用的JSON响应结构，其
 * 中包含两部分：元数据与返回值，其中，元数据表示操作是否成功与返回值消息等，返回值对应服务端方法所返回的数据。
 * { "success": true, "message": "ok" , "data": ... }
 * 
 * @author rico
 * @created 2017年7月4日 下午5:06:00
 */
public class ResponseData<T> {

	private static final String OK = "ok";
	private static final String ERROR = "static/error";

	private boolean success;
	private String message;
	private Object data;   // 响应内容

	public ResponseData(boolean success) {
		this.success = success;
	}

	public ResponseData(boolean success, String message) {
		this.success = success;
		this.message = message;
	}

	public ResponseData(boolean success, Object data) {
		this.success = success;
		this.data = data;
	}

	public ResponseData(boolean success, String message, Object data) {
		this.success = success;
		this.message = message;
		this.data = data;
	}

	public static <T> ResponseData<T> success() {
		return new ResponseData<T>(true);
	}

	public static <T> ResponseData<T> success(Object data) {
		return new ResponseData<T>(true,data);
	}

	public static <T> ResponseData<T> failure() {
		return new ResponseData<T>(false);
	}

	public static <T> ResponseData<T> failure(String message) {
		return new ResponseData<T>(false,message);
	}

	public boolean isSuccess() {
		return success;
	}

	public String getMessage() {
		return message;
	}

	public Object getData() {
		return data;
	}
}