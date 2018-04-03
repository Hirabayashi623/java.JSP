
<%@ page contentType="text/html; charset=utf-8" %>
<%@ page import="techscore.lesson3.AnimalBean" %>
<html>
<head>
	<title></title>
	<meta http-equiv="Content-Type" content="text/html" charset="utf-8" />
</head>
<body>
	<jsp:useBean id="animal" class="techscore.lesson3.AnimalBean" scope="session" />
	<%=animal.getName() %>
</body>
</html>