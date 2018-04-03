package techscore.lesson8;

import java.io.BufferedReader;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.BodyContent;
import javax.servlet.jsp.tagext.BodyTag;
import javax.servlet.jsp.tagext.Tag;

public class MyTag8_1 implements BodyTag{
	private Tag parentTag = null;
	private PageContext pageContext = null;
	private BodyContent bodyContent = null;

	// setBodyContent実行直後に実行される
	@Override
	public void doInitBody() throws JspException {
		// 初期化的なことが必要であれば実装
		// 処理内容はdoAfterBodyに実装
	}

	// doStartTag実行直後に呼ばれる
	@Override
	public void setBodyContent(BodyContent bodyContent) {
		this.bodyContent = bodyContent;
	}

	@Override
	public int doAfterBody() throws JspException {
		// bodyへの書き込みは、BodyContent.getEnclosingWriterメソッドを使用
		JspWriter out = bodyContent.getEnclosingWriter();
		StringBuilder sb = new StringBuilder();
		try {
			sb.append("<table border=\"1\" cellspacing=\"0\">");
			sb.append("<tr>");

			{
				/* ボディ部からの値の取得は
				 * ①gerReaderで取得できる「java.io.Reader」
				 * ②getString
				 * の2通りで可能
				 */
				BufferedReader br = new BufferedReader(bodyContent.getReader());
				String line = "";
				while((line = br.readLine())!=null){
					Arrays.asList(line.split("\t")).forEach(s -> sb.append("<td>" + s + "</td>"));
				}
			}

			sb.append("</tr>");
			sb.append("</table>");
			out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		return SKIP_BODY;
	}

	@Override
	public int doEndTag() throws JspException {
		return EVAL_PAGE;
	}

	@Override
	public int doStartTag() throws JspException {
		return EVAL_BODY_BUFFERED;
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
