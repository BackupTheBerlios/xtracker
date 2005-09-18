<%@ page language="java" import="java.util.*" %>
<%@ taglib uri="http://struts.application-servers.com/layout" prefix="layout" %>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-bean" prefix="bean"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-html" prefix="html"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-logic" prefix="logic"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-template" prefix="template"%>
<%@ taglib uri="http://jakarta.apache.org/struts/tags-nested" prefix="nested"%>

<layout:html layout="false" key="page.title">
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
</layout:html>

