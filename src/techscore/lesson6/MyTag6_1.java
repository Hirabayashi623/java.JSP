package techscore.lesson6;

import java.io.IOException;

import javax.servlet.jsp.JspException;

import techscore.common.UtilTag;

public class MyTag6_1 extends UtilTag {
	public int doStartTag() throws JspException {
		try {
			pageContext.getOut().print("<p>StartTag</p>");
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		// ボディ部を評価する
		return EVAL_BODY_INCLUDE;
	}

	public int doEndTag() throws JspException{
		try {
			pageContext.getOut().print("<p>EndTag</p>");
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}

		return 0;
	}
}
