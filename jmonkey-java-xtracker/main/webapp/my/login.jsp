<%@ page language="java" import="java.util.*" %>
<%@ include file="/taglibs.jsp"%>
<html:html>
<head>
<title><bean:message key="page.title" /></title>
<%@ include file="/styles.jsp"%>
<%@ include file="/scripts.jsp"%>
<%@ include file="/theme.jsp"%>
</head>
<body>
	<layout:panel styleClass="FORM" key="view.panel.label.login" align="left">
		<layout:form method="POST" action="j_security_check" styleClass="FORM">
  			<table border="0" cellspacing="5">
    		<tr>
      			<th align="right"><layout:message key="view.label.username"/>:</th>
      			<td align="left"><layout:text name="j_username" styleClass="FIELD"></td>
    		</tr>
    		<tr>
      			<th align="right"><layout:message key="view.label.password"/>:</th>
      			<td align="left"><layout:password name="j_password"  styleClass="FIELD"></td>
    		</tr>
    		<tr>
      			<td align="right" colspan="2">
      				<layout:submit>
						<layout:message key="view.label.login"/>
					</layout:submit>
				</td>
    		</tr>
  			</table>
 		</layout:form>
	</layout:panel>
</body>
</html:html>

