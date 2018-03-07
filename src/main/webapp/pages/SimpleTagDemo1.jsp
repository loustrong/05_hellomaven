<%@ page language="java" pageEncoding="UTF-8"%>
<%--在jsp页面中导入自定义标签库 --%>
<%@taglib uri="/simpletag" prefix="gacl" %>
<!DOCTYPE HTML>
<html>
  <head>
    <title>用简单标签控制标签体是否执行</title>
  </head>
  
  <body>
  
  <%--在jsp页面中使用自定义标签 demo1标签是带有标签体的，标签体的内容是"孤傲苍狼"这几个字符串--%>
    <gacl:demo1>
       gacl_xdp
    </gacl:demo1>
  </body>
</html>