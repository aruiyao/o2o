package com.cry.o2o.util;

import javax.servlet.http.HttpServletRequest;
import com.google.code.kaptcha.Constants;

public class CodeUtil {
	/** 
	 * 检查验证码是否和预期相符
	 * @param request
	 * @return
	 * @author CRY
	 * @since 2019-09-23
	 */
	public static boolean checkVerifyCode(HttpServletRequest request) {
		String verifyCodeExpected = (String) request.getSession()
				.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		String verifyCodeActual = HttpServletRequestUtil.getString(request, "verifyCodeActual");
		if (verifyCodeActual == null || !verifyCodeActual.equalsIgnoreCase(verifyCodeExpected)) {
			return false;
		}
		return true;
	}
}
