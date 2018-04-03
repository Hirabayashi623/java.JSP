<%@ page contentType="text/html; charset=utf-8" %>
<%@ taglib uri="/WEB-INF/tld/techscore/lesson6/my.tld" prefix="sample" %>

<html>
<head>
	<title></title>
	<meta http-equiv="Content-Type" content="text/html" charset="utf-8" />
</head>
<body>
	<sample:sample1>Body</sample:sample1>

	<sample:sample2 message="Message">Body</sample:sample2>

	<% request.setAttribute("test1", "test"); %>
	<% session.setAttribute("test2", "test"); %>
	<sample:sample3 name="test1" />
	<sample:sample3 name="test2" />
</body>
</html>