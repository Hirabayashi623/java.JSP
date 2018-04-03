package techscore.lesson6;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;

import techscore.common.UtilTag;

public class MyTag6_2 extends UtilTag {
	// 属性の値を格納するための入れ物の準備
	private String msg = "";
	// 属性名に対応したgetter/setterの準備（フィールド変数名と一致する必要はない）
	public void setMessage(String msg){
		this.msg = msg;
	}
	public String getMessage(){
		return this.msg;
	}

	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.print("<p>StartTag</p>");
			out.print("Message : " + msg + "<br>");

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
