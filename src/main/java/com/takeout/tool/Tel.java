package com.takeout.tool;

public class Tel {
	private String tel;

	public Tel(String tel) {
		this.tel = tel;
	}

	public String safeTel() {
		if (tel.length()!=11) {
			return errtel();
		}
		return safenum(tel);
	}

	private String errtel() {
		return "错误手机号码";
	}

	private String safenum(String tel) {
		return tel.replaceAll(tel.substring(3, 7), "****");
	}
}
