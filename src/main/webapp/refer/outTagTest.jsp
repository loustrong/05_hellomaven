<%@ page language="java" pageEncoding="UTF-8"%>
<%--在jsp页面中导入自定义标签库 --%>
<%@taglib uri="/gaclTagLib" prefix="c" %>
<%--在jsp页面中也可以使用这种方式导入标签库，直接把uri设置成标签库的tld文件所在目录
<%@taglib uri="/WEB-INF/TagLib.tld" prefix="c"%>
--%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>out标签测试</title>
  </head>

  <body>
          <%--使用out标签输出content属性的内容 --%>
          <c:out content="<a href='http://www.cnblogs.com'>访问博客园</a>"/>
          <hr/>
          <%--使用out标签输出 content属性的内容，内容中的html代码会进行转义处理--%>
          <c:out content="<a href='http://www.cnblogs.com'>访问博客园</a>" escapeHtml="true"/>
  </body>
</html>