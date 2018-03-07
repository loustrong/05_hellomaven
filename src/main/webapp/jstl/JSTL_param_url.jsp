<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>


<c:url value="http://www.baidu.com" var="paramUrl">
    <c:param name="userName" value="孤傲苍狼"/>
     <c:param name="pwd">123456</c:param>
 </c:url>
 <a href="${paramUrl}">百度首页(带参数)</a>


</body>
</html>