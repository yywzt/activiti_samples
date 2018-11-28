package com.example.constant;

/**        
 * Title: 常量    
 * Description: 
 * @author yanzt
 * @created 2018年7月4日 17:14:25
 */      
public class Constants {

	/**
	 * 存储当前登录用户id的字段名
	 */
	public static final String CURRENT_USER_ID = "CURRENT_USER_ID";

	/**
	 * token有效期（小时）
	 */
	public static final int TOKEN_EXPIRES_HOUR = 72;

	/**  存放Token的header字段  (@author: rico) */      
	public static final String DEFAULT_TOKEN_NAME = "X-Token";

	/**   存放sessionId的key*/
	public static final String SESSION_ID_KEY = "SESSION_ID_KEY";
	/**   存放sessionId的key*/
	public static final String SESSION_ID = "SESSION_ID";
	/**   存放sessionId的key*/
	public static final String USER = "USER";

	/**   session有效期 分钟*/
	public static final int SESSION_EXPIRES_MIN = 30;

}
