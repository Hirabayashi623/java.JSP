package techscore.lesson6;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;

import techscore.common.UtilTag;

public class MyTag6_3 extends UtilTag {
	// 属性の値を格納するための入れ物の準備
	private String name = "";
	// 属性名に対応したgetter/setterの準備（フィールド変数名と一致する必要はない）
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}

	public int doStartTag() throws JspException {
		try {
			JspWriter out = pageContext.getOut();
			out.print("<p>StartTag</p>");

			if(pageContext.getAttribute(name, PageContext.REQUEST_SCOPE)!=null){
				out.print(name + " is found at request");
			}else if(pageContext.getAttribute(name, PageContext.SESSION_SCOPE)!=null){
				out.print(name + " is found at session");
			}

		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		// ボディ部を評価する
		return SKIP_BODY;
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
