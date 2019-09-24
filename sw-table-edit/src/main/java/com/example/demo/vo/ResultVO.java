package com.example.demo.vo;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用返回VO
 * 
 * @author xuliangyi
 *
 */

public class ResultVO<T> {
	/**
	 * 状态码
	 */
	private Integer code;

	/**
	 * 消息信息
	 */
	private String msg;

	/**
	 * 条数
	 */
	private Integer count;

	/**
	 * 数据
	 */
	private List<T> data;

	/**
	 * 默认code=0 默认自动new data 默认count=0
	 */
	public ResultVO() {
		this.code = 0;
		this.count = 0;
		this.data = new ArrayList<T>();
	}

	/**
	 * @return the code
	 */
	public Integer getCode() {
		return code;
	}

	/**
	 * @param code
	 *            the code to set
	 */
	public void setCode(Integer code) {
		this.code = code;
	}

	/**
	 * @return the msg
	 */
	public String getMsg() {
		return msg;
	}

	/**
	 * @param msg
	 *            the msg to set
	 */
	public void setMsg(String msg) {
		this.msg = msg;
	}

	/**
	 * @return the count
	 */
	public Integer getCount() {
		return count;
	}

	/**
	 * @param count
	 *            the count to set
	 */
	public void setCount(Integer count) {
		this.count = count;
	}

	/**
	 * @return the data
	 */
	public List<T> getData() {
		return data;
	}

	/**
	 * @param data
	 *            the data to set
	 */
	public void setData(List<T> data) {
		this.data = data;
	}
}
