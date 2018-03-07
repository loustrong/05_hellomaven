<%@ page language="java" pageEncoding="UTF-8"%>
<%--在jsp页面中导入自定义标签库 --%>
<%@taglib uri="/gaclTagLib" prefix="gacl" %>
<%--在jsp页面中也可以使用这种方式导入标签库，直接把uri设置成标签库的tld文件所在目录
<%@taglib uri="/WEB-INF/TagLib.tld" prefix="gacl"%>
--%>
<%--在Jsp页面中使用防盗链标签 
当用户尝试直接通过URL地址(http://localhost:8080/JavaWeb_JspTag_study_20140816/simpletag/refererTagTest.jsp)访问这个页面时，
防盗链标签的标签处理器内部就会进行处理，将请求重定向到/index.jsp
--%>
<gacl:referer site="http://localhost:8080" page="/refer/index.jsp"/>
<!DOCTYPE HTML>
<html>
  <head>
    <title>防盗链标签测试</title>
  </head>

  <body>
     网站内部资料
  </body>
</html>