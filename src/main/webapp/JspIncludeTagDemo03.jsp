<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<h1>JspIncludeTagDemo03.jsp</h1>
<hr/>
<jsp:include page="/Inc.jsp">
    <jsp:param name="parm1" value="hello" />
    <jsp:param name="parm2" value="gacl" />
</jsp:include>