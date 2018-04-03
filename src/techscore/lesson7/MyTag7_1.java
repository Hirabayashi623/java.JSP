package techscore.lesson7;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.PageContext;
import javax.servlet.jsp.tagext.IterationTag;
import javax.servlet.jsp.tagext.Tag;

public class MyTag7_1 implements IterationTag {

	protected Tag parentTag = null;
	protected PageContext pageContext = null;
	protected Iterator<?> it = null;
	protected String item = null;

	public void setList(String name){
		List<?> list = (List<?>)pageContext.findAttribute(name);
		this.it = list.iterator();
	}

	public void setItem(String item){
		this.item = item;
	}

	// doStartTag実行後に実行されるメソッド
	// 返り値はEVAL_BODY_AGAIN（ボディ部の再評価）またはSKIP_BODY（ボディ部スキップ）
	@Override
	public int doAfterBody() throws JspException {
		int ret_value = EVAL_BODY_AGAIN;

		if(it.hasNext()){
			// 2回目以降のループはここで処理
			pageContext.setAttribute(item, it.next());
		}else{
			ret_value = SKIP_BODY;
		}

		return ret_value;
	}

	public int doStartTag() throws JspException {
		int ret_value = EVAL_BODY_INCLUDE;

		try {
			pageContext.getOut().print("<p>StartTag</p>");
			if(it.hasNext()){
				// 1つ目の要素はここで使用
				pageContext.setAttribute(item, it.next());
			}else{
				ret_value = SKIP_BODY;
			}

		} catch (IOException e) {
			e.printStackTrace();
			throw new JspException(e.getMessage());
		}
		return ret_value;

	}

	public int doEndTag() throws JspException {
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
