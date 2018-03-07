<%@ page language="java" pageEncoding="UTF-8"%>
<%--在jsp页面中导入自定义标签库 --%>
<%@taglib uri="/gaclTagLib" prefix="c" %>
<%--在jsp页面中也可以使用这种方式导入标签库，直接把uri设置成标签库的tld文件所在目录
<%@taglib uri="/WEB-INF/TagLib.tld" prefix="c"%>
--%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>when和otherwise标签测试</title>
  </head>

  <body>
      <c:choose>
          <c:when test="${user==null}">
          when标签标签体输出的内容：
              <h3>用户为空</h3>
          </c:when>
          <c:otherwise>
              用户不为空
          </c:otherwise>
      </c:choose>
          <hr/>
      <c:choose>
          <c:when test="${user!=null}">
              用户不为空
          </c:when>
          <c:otherwise>
          otherwise标签标签体输出的内容：
              <h3>用户为空</h3>
          </c:otherwise>
      </c:choose>
  </body>
</html>