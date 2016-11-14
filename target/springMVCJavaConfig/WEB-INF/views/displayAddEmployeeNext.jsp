<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib prefix="c" uri ="http://java.sun.com/jstl/core_rt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<style type="text/css">
 .markerCls {
 }
</style>
 <link rel="stylesheet" href="<spring:theme code='css'/>" type="text/css">
 <title><spring:message code="com.spring.mvc.employee.add.title"/></title>
</head>
<body>
  <h3><spring:message code="com.spring.mvc.employee.add.title"/></h3>
  <table>
   <tr>
    <td>
     <span>
   	   <a href="?lang=en">English</a>|
       <a href="?lang=ur">Urdu</a>
     </span>
    </td>
   </tr>
   <tr>
    <td>
     <span>
   	   <a href="?currentTheme=default">Default</a>|
       <a href="?currentTheme=wheat">Wheat</a>|
       <a href="?currentTheme=purple">Purple</a>
     </span>
    </td>
   </tr>
  </table>
  <form:form action="addEmployee" commandName="employee" method="post" enctype="multipart/form-data" id = "employeeFormLast">
   <table>
    <tr> 
     <th>
      <spring:message code ="com.spring.mvc.employee.present.address"/>
     </th>
     </tr>
     <tr>
      <td> 
       <form:label path="addresses['present'].street">
        <spring:message code="com.spring.mvc.employee.addresses.street"/>
       </form:label>
      </td>
      <td>               
       <form:input path="addresses['present'].street"/>
      </td>
      <td>
       <form:errors path="addresses"/>
      </td>
     </tr>
     <tr>
      <td>
       <form:label path="addresses['present'].city">
        <spring:message code="com.spring.mvc.employee.addresses.city"/>
       </form:label>
      </td>
      <td>
       <form:input path="addresses['present'].city"/>
      </td>
      <td>
       <form:errors path="addresses['present']"/>
      </td>
     </tr>
     <tr>
      <td>
       <form:label path="addresses['present'].state">
        <spring:message code="com.spring.mvc.employee.addresses.state"/>
       </form:label>
      </td>
      <td>
       <form:input path="addresses['present'].state"/>
      </td>
      <td>
       <form:errors path="addresses['present']"/>
      </td>
     </tr>
     <tr>
      <td>
       <form:label path="addresses['present'].pin">
        <spring:message code="com.spring.mvc.employee.addresses.pin"/>
       </form:label>
      </td>
      <td>
       <form:input path="addresses['present'].pin"/>
      </td>
      <td>
       <form:errors path="addresses['present']"/>
      </td>
     </tr>
     <tr>
      <td>
       <form:label path="addresses['present'].country">
        <spring:message code="com.spring.mvc.employee.addresses.country"/>
       </form:label>
      </td>
     <td>
      <form:input path="addresses['present'].country"/>
     </td>
     <td>
      <form:errors path="addresses['present']"/>
     </td>
    </tr>	       
    <tr>
     <th>
      <spring:message code="com.spring.mvc.employee.native.address"/>
     </th>
    </tr>
    <tr>
     <td>
      <form:label path="addresses['native'].street">
       <spring:message code="com.spring.mvc.employee.addresses.street"/>
      </form:label>
     </td>
     <td>
      <form:input path="addresses['native'].street"/>
      </td>
     <td>
       <form:errors path="addresses['native']"/>
     </td>
    </tr>
    <tr>
     <td>
      <form:label path="addresses['native'].city">
       <spring:message code="com.spring.mvc.employee.addresses.city"/>
      </form:label>
     </td>
     <td>
      <form:input path="addresses['native'].city"/>
     </td>
     <td>
      <form:errors path="addresses['native']"/>
     </td>
    </tr>
    <tr>
     <td>
      <form:label path="addresses['native'].state">
       <spring:message code="com.spring.mvc.employee.addresses.state"/>
      </form:label>
     </td>
     <td>
      <form:input path="addresses['native'].state"/>
     </td>
     <td>
      <form:errors path="addresses['native']"/>
     </td>
    </tr>
    <tr>
     <td>
      <form:label path="addresses['native'].pin">
       <spring:message code="com.spring.mvc.employee.addresses.pin"/>
      </form:label>
     </td>
     <td>
      <form:input path="addresses['native'].pin"/>
     </td>
     <td>
      <form:errors path="addresses['native']"/>
     </td>
    </tr> 
    <tr>
     <td>
      <form:label path="addresses['native'].country">
       <spring:message code="com.spring.mvc.employee.addresses.country"/>
      </form:label>
     </td>
     <td>
      <form:input path="addresses['native'].country"/>
     </td>
     <td>
      <form:errors path="addresses['native']"/>
     </td>
    </tr>
   </table>     
   <table style="border:solid black">
    <tr>
     <td>
      <spring:message code="com.spring.mvc.employee.project.details"/>
     </td>
    </tr>
    <tr>
     <td>
      <table id="projectTable">
      	<tr>
     	 <td colspan="6">
          <form:errors path="projects"/>
         </td>
    	</tr>
        <tr>
         <th>
          <spring:message code="com.spring.mvc.employee.project.title"/>
         </th>
         <th>
           <spring:message code = "com.spring.mvc.employee.project.desc"/>
         </th>
          <th>
           <spring:message code="com.spring.mvc.employee.project.role"/>
         </th>
         <th>
          <spring:message code="com.spring.mvc.employee.project.responsibilities"/>
         </th>
         <th>
          <spring:message code="com.spring.mvc.employee.project.client"/>
         </th>
         <th>
          <spring:message code = "com.spring.mvc.employee.project.technologies"/>
         </th>
        </tr>
       <c:forEach items="${employee.projects}" varStatus="vs">
        <tr>
         <td>
          <form:input path="projects[${vs.index}].title"/>
         </td>
         <td>
          <form:input path="projects[${vs.index}].desc"/>
         </td>
         <td>
          <form:input path="projects[${vs.index}].role.roleName"/>
         </td>
         <td>
          <form:input path="projects[${vs.index}].role.responsiblities"/>
         </td>
         <td>
          <form:input path="projects[${vs.index}].client"/>
          <form:errors path="projects[${vs.index}].client"/>
         </td>
         <td>
          <form:select path="projects[${vs.index}].technologies" items="${technologies}" multiple="true" size="3"/>
         </td>
        </tr>
       </c:forEach>
      </table>
     <td>
    </tr>
   </table>
   <table>
   <tr> 
   	 <td>
	  <spring:message code = "com.spring.mvc.employee.upload.profile"/>       
     </td>
     <td>
	  <input type="file" name = "profile" id="profile">       
     </td>
     <td>
      <form:errors path="profile"/>
     </td>
    </tr>
    <tr>
     <td>
	  <input type="submit"  id = "previousId" value="<spring:message code='com.spring.mvc.employee.action.previous'/>">       
     </td>
     <td>
	  <input type="submit" value="<spring:message code='com.spring.mvc.employee.action.add'/>">       
     </td>
    </tr>
   </table>
  </form:form>
</body>
 <script type="text/javascript">
   $(document).ready(function() {
	 $("#previousId").click(function(e) {
		 e.preventDefault();
		 $("#employeeFormLast").attr('action', 'addEmployeePrevious').submit();
	 }); 
   });
 </script> 
</html>