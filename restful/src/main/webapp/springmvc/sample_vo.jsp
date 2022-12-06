<%@ page contentType="text/html;charset=UTF-8"%>
<%@ page import="com.poscoict.glueframework.context.GlueContext" %>
<%@ page import="com.poscoict.glueframework.web.control.GlueWebConstants" %>
<%@ page import="com.poscoict.glueframework.biz.control.GlueBizControlConstants" %>
<%@ page import="java.util.*" %>
<%@ page import="sample.vo.*" %>
<html>
<head>
<title>Sample(resultType)</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<body bgcolor="#FFFFFF" text="#000000" topmargin=10 leftmargin=10>
<form name="form1" method="post" action="sample_vo.mvc">
<b>Employee 정보</b>
<hr>
&nbsp;부서 : <input type="text" name="deptno" value="<%= request.getParameter("deptno")!=null ? request.getParameter("deptno") : "" %>">
<input type=submit name="custom" value="조회">
<hr>
<input type='checkbox' disabled>
| <input type=text name='empno_insert' value='' size=4>
| <input type=text name='ename_insert' value='' size=8>
| <input type=text name='job' value='' size=12 disabled>
| <input type=text name='mgr' value='' size=4 disabled>
| <input type=text name='hiredate' value='' disabled>
| <input type=text name='sal_insert' value='' size=4>
| <input type=text name='comm' value='' size=4 disabled>
| <input type=text name='deptno_insert' value='<%=request.getParameter("deptno")!=null ? request.getParameter("deptno") : "10"%>' size=2 readonly>
<input type=submit name="insert" value="등록">
<hr>
<input type=submit name="update" value="수정">
<input type=submit name="delete" value="삭제">
<hr>
<%
    GlueContext ctx =
    (GlueContext)  request.getAttribute(GlueWebConstants.CONTEXT);

    if(ctx!=null)
    {
        List<EmpVO> rowSet = (List<EmpVO>)ctx.get("EmpListUsingVO");
        if(rowSet!=null)
        {
            int i=0;
            for(EmpVO row : rowSet)
            {
%><input type='checkbox' name='chk' value='<%=i++%>'>
| <input type=text name='EMPNO' value='<%=row.getEmpno() %>' size=4 readonly>
| <input type=text name='ENAME' value='<%=row.getEname()  %>' size=8>
| <input type=text name='JOB' value='<%=row.getJob()    %>' size=12 readonly>
| <input type=text name='MGR' value='<%=row.getMgr() %>' size=4 readonly>
| <input type=text name='HIREDATE' value='<%=row.getHiredate() %>' readonly>
| <input type=text name='SAL' value='<%=row.getSal() %>' size=4>
| <input type=text name='COMM' value='<%=row.getComm() %>' size=4 readonly>
| <input type=text name='DEPTNO' value='<%=row.getDeptno() %>' size=2 readonly><br><%
            }
        }
    }
%>
<hr>
Glue Service Name : <input type="text" name="ServiceName" value="sample-service">
</form>
</body> 
</html>
