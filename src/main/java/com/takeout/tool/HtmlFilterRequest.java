package com.takeout.tool;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;

/**
 * 将html中的标签进行转义
 * @author m_xiong
 *
 */
public class HtmlFilterRequest extends HttpServletRequestWrapper {

	private HttpServletRequest request;

	public HtmlFilterRequest(HttpServletRequest request) {
        super(request);
        this.request = request;
    }

	@Override
	public String getParameter(String name) {
		String value = this.request.getParameter(name);
        if (value == null) {
            return null;
        }
		return htmlFilter(value);
	}


	public String htmlFilter(String message) {
		StringBuffer result = new StringBuffer();
		for (int i = 0; i < message.length(); i++) {
			switch (message.charAt(i)) {
			case '<':
				result.append("&lt;");
				break;
			case '>':
				result.append("&gt;");
				break;
			case '&':
				result.append("&amp;");
				break;
			case '"':
				result.append("&quot;");
				break;
			case ' ':
				result.append("&nbsp;");
				break;
			default:
				result.append(message.charAt(i));
			}
		}
		return result.toString();
	}

		
}
