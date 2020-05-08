package com.yj.vo;

import java.io.Serializable;

public class ResultVo implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 8774291738803727341L;
	
	public static final String STATUS_SUCCESS="1";
	
	public static final String STATUS_FAILURE="0";

	public static final String STATUS_FAILURETwo="2";

	public static final String URL_TYPE="YES";
	
	private String status;
	
	private Object data;
	
	private String message;

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		return "ResultVo [status=" + status + ", data=" + data + ", message=" + message + "]";
	}
	public static ResultVo buildSuccessResult() {
		return new ResultVo(STATUS_SUCCESS,null,"成功");
	}
    public static ResultVo buildSuccessResult(Object data) {
    	return new ResultVo(STATUS_SUCCESS,data,"成功");
    }
    public static ResultVo buildFailureResult(String message) {
    	return new ResultVo(STATUS_FAILURE,null,message);
    }
	public ResultVo(String status, Object data, String message) {
		super();
		this.status = status;
		this.data = data;
		this.message = message;
	}

	public ResultVo() {
		super();
	}

}
