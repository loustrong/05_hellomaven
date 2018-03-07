<%@ page language="java" pageEncoding="UTF-8"%>
<%--在jsp页面中导入自定义标签库 --%>
<%--<%@taglib uri="/simpletag" prefix="gacl" %>--%>
<%--在jsp页面中也可以使用这种方式导入标签库，直接把uri设置成标签库的tld文件所在目录 --%>
<%@taglib uri="/WEB-INF/simpletag.tld" prefix="gacl"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>通过标签的属性控制标签体的执行次数</title>
  </head>

  <body>
       <%--在jsp页面中使用自定义标签，标签有一个count属性 --%>
          <gacl:demo5 count="4">
              <h1>孤傲苍狼</h1>
          </gacl:demo5>
  </body>
</html>