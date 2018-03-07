<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%--在jsp页面中导入自定义标签库 --%>
<%--<%@taglib uri="/simpletag" prefix="gacl" %>--%>
<%--在jsp页面中也可以使用这种方式导入标签库，直接把uri设置成标签库的tld文件所在目录 --%>
<%@taglib uri="/WEB-INF/simpletag.tld" prefix="gacl"%>
<!DOCTYPE HTML>
<html>
  <head>
    <title>如果标签接收的属性值是一个复合数据类型，该如何给标签的属性赋值</title>
  </head>

  <body>
     <%--
     在jsp页面中使用自定义标签，标签有一个date属性 ，是一个复合数据类型
       如果标签的属性值是8种基本数据类型，那么在JSP页面在传递字符串时，JSP引擎会自动转换成相应的类型
       但如果标签的属性值是复合数据类型，那么JSP引擎是无法自动转换的，
       这里将一个字符串赋值给demo6标签的date属性，在运行标签时就会出现如下错误：
     Unable to convert string "1988-05-07" to class "java.util.Date" for attribute "date": 
     Property Editor not registered with the PropertyEditorManager
          <gacl:demo6 date="1988-05-07">
          </gacl:demo6>
      --%>
      <%--如果一定要给标签的复合属性赋值，那么可以采用表达式的方式给复合属性赋值，如下所示： --%>
      
      <%
          Date d = new Date();
        request.setAttribute("date", d);
      %>
      
      <gacl:demo6 date="${date}"/>
      <hr/>
      <gacl:demo6 date="<%=new Date()%>"/>
  </body>
</html>