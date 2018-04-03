<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/WEB-INF/tld/techscore/lesson7/my.tld" prefix="sample" %>

<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>

<html>
<head>
	<title></title>
	<meta http-equiv="Content-Type" content="text/html" charset="utf-8" />
</head>
<body>
	<%
		List<String> list = new ArrayList<String>();
		list.add("monkey");
		list.add("rabbit");
		request.setAttribute("list1", list);
	%>
	<sample:sample1 item="item1" list="list1">
		<%=pageContext.getAttribute("item1") %><br>
	</sample:sample1>

</body>
</html>