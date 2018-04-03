package common;

import java.io.File;
import java.io.IOException;
import java.nio.file.FileVisitOption;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.servlet.jsp.tagext.BodyTagSupport;


public class IndexTag extends BodyTagSupport{

	public static void main(String[] args) throws Exception{
		Path path = Paths.get("./WebContent/jsp");
		System.out.println(makeList(path));
//		System.out.println(path.toAbsolutePath());
//		Files.list(path).forEach(System.out::println);
	}

	public static String enclose(String target, String tag){
		return "<" + tag + ">" + target + "</" + tag + ">";
	}

	public static String startTag(String tag){
		return "<" + tag + ">";
	}

	public String endTag(String tag){
		return "</" + tag + ">";
	}

	public static String makeList(Path path){
		StringBuilder sb = new StringBuilder();
		sb.append("<ol>");
		try {
			Files.list(path).forEach(p -> {
				if(Files.isDirectory(p)){
					sb.append("<li><h4>").append(p.getFileName()).append("</h4>\r\n");
					sb.append(makeList(p));
					sb.append("</li>\r\n");
				}else{
					sb.append("<li>").append(p.getFileName()).append("</li>\r\n");
				}
			});
		} catch (IOException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}
		sb.append("</ol>\r\n");
		return sb.toString();
	}
}
