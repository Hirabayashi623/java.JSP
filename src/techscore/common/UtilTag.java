package techscore.common;

import java.io.IOException;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.Tag;

public class UtilTag implements Tag {
	protected Tag parentTag = null;
	protected PageContext pageContext = null;

	public int doStartTag() throws JspException{
		try {
			pageContext.getOut().print("<p>StartTag</p>");
		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}

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

	@Override
	public Tag getParent() {
		return parentTag;
	}

	@Override
	public void setParent(Tag parentTag) {
		this.parentTag = parentTag;
	}

	@Override
	public void setPageContext(PageContext pageContext) {
		this.pageContext = pageContext;
	}

	@Override
	public void release() {
		// 実装不要
	}

}
