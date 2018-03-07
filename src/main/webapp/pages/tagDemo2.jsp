<%@ page language="java" pageEncoding="UTF-8"%>
<%--在jsp页面中导入自定义标签库 --%>
<%@taglib uri="/gacl" prefix="gacl" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>控制jsp页面是否执行</title>
  </head>
  
  <body>
         <h1>jsp页面的内容1</h1>
         <%--在jsp页面中使用自定义标签 demo2标签是不带标签体的--%>
         <gacl:demo2/>
         <h1>jsp页面的内容2</h1>
  </body>
</html>