package com.kpap.basis.exception;


/**
 * 
 * 自定义业务异常类<BR>
 *
 * @auther shenhaiwen
 * @date 2016-12-16 下午01:04:32
 */
public class BusinessException extends RuntimeException {

	private static final long serialVersionUID = -8886477785483121022L;
	
	private String errorCode;
	

	public String getErrorCode() {
		return errorCode;
	}

	public void setErrorCode(String errorCode) {
		this.errorCode = errorCode;
	}

	public BusinessException() {
		super();
	}

	/**
	 * 
	 * @param message
	 *            消息
	 * @param cause
	 *            原因
	 */
	public BusinessException(String message, Throwable cause) {
		super(message, cause);

	}

	/**
	 * 
	 * @param message
	 *            消息
	 */
	public BusinessException(String message) {
		super(message);

	}

	/**
	 * 
	 * @param cause
	 *            原因
	 */
	public BusinessException(Throwable cause) {
		super(cause);

	}
	
	/**
	 * 构造函数.
	 * 
	 * @param errorCode
	 *            指定的异常编码.
	 * @param message
	 *            异常的确切信息
	 */
	public BusinessException(String errorCode, String message) {
		super(message);
		this.errorCode = errorCode;
	}
	

}
