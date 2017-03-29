package com.evaluator.service.model;

/**
 * Java POJO to represent Solutin document
 * 
 * @author Jagan
 * @version 1.0
 */
public class Solution {

	private String _id;
	private String code;
	private int state;

	public String get_id() {
		return _id;
	}

	public void set_id(String _id) {
		this._id = _id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
	}

}
