<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" isELIgnored="false"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags"%>    
<%@taglib prefix="c" uri ="http://java.sun.com/jstl/core_rt" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link rel="stylesheet" href="<spring:theme code='css'/>" type="text/css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<title><spring:message code="com.spring.mvc.employee.add.title"/></title>
</head>
<body>
  <h3><spring:message code="com.spring.mvc.employee.add.title"/></h3>
  <c:if test="${not empty employee}">
   <c:set var="employee" value="${employee}" scope="session"/>
  </c:if>
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
   	   <a href="?currentTheme=default" id="defaultId">Default</a>|
       <a href="?currentTheme=wheat" id="wheatId">Wheat</a>|
       <a href="?currentTheme=purple" id="purpleId">Purple</a>
     </span>
    </td>
   </tr>
  </table>
  <table>
    <tr>
     <td>
      <spring:message code="com.spring.mvc.employee.firstName"/>
     </td>
     <td>
      <c:out value="${employee.firstName}"/>
     </td>
    </tr>
    <tr>
     <td>
      <spring:message code="com.spring.mvc.employee.lastName"/>
     </td>
     <td>
      <c:out value="${employee.lastName}"/>
     </td>
    </tr>
    <tr>
     <td>
      <spring:message code="com.spring.mvc.employee.gender"/>
     </td>
     <td>
      <c:out value="${employee.gender}"/>
     </td>
    </tr>
    <tr>
     <td>
      <spring:message code="com.spring.mvc.employee.joiningDate"/>
     </td>
     <td>
      <fmt:formatDate pattern="dd/mm/yyyy" value="${employee.joiningDate}"/>
     </td>
    </tr>
    <tr>
     <td>
      <spring:message code="com.spring.mvc.employee.releaseDateDate"/>
     </td>
     <td>
      <fmt:formatDate pattern = "dd/mm/yyyy" value="${employee.releaseDate}"/>
     </td>
    </tr>
    <tr>
     <td>
      <spring:message code="com.spring.mvc.employee.experience"/>
     </td>
     <td>
      <c:out value="${employee.experience}"/>
     </td>
    </tr>
    <tr>
     <td>
      <spring:message code="com.spring.mvc.employee.skills"/>
     </td>
     <td>
      <c:out value="${employee.skills}"/>
     </td>
    </tr>
    <tr>
     <td>
      <spring:message code="com.spring.mvc.employee.salary"/>
     </td>
     <td>
      <c:out value="${employee.salary}"/>
     </td>
    </tr>
    <tr>
     <td>
      <spring:message code="com.spring.mvc.employee.annualPkg"/>
     </td>
     <td>
      <c:out value="${employee.annualPkg}"/>
     </td>
    </tr>
    <tr>
     <td>
      <spring:message code="com.spring.mvc.employee.contacts.contact"/>
     </td>
     <td>
      <c:out value="${employee.contacts['contact']}"/>
     </td>
    </tr>
    <tr>
     <td>
      <spring:message code="com.spring.mvc.employee.contacts.contactType"/>
     </td>
     <td>
      <c:out value="${employee.contacts['contactType']}"/>
     </td>
    </tr>
    <tr>
     <td>
      <spring:message code="com.spring.mvc.employee.addresses.street"/>
     </td>
     <td>
      <c:out value="${employee.addresses['present'].street}"/>
     </td>
    </tr>
    <tr>
     <td>
      <spring:message code="com.spring.mvc.employee.addresses.street"/>
     </td>
     <td>
      <c:out value="${employee.addresses['present'].city}"/>
     </td>
     </tr>
     <tr>
      <td>
       <spring:message code="com.spring.mvc.employee.addresses.state"/>
      </td>
      <td>
       <c:out value="${employee.addresses['present'].state}"/>
      </td>
     </tr>
     <tr>
      <td>
       <spring:message code="com.spring.mvc.employee.addresses.pin"/>
      </td>
      <td>
       <c:out value="${employee.addresses['present'].pin}"/>
      </td>
     </tr>
     <tr>
      <td>
       <spring:message code="com.spring.mvc.employee.addresses.country"/>
      </td>
      <td>
       <c:out value="${employee.addresses['present'].country}"/>
      </td>
     </tr>
     <tr>
      <td>
       <spring:message code="com.spring.mvc.employee.addresses.street"/>
      </td>
      <td>
       <c:out value="${employee.addresses['native'].street}"/>
      </td>
     </tr>
     <tr>
      <td>
       <spring:message code="com.spring.mvc.employee.addresses.city"/>
      </td>
      <td>
       <c:out value="${employee.addresses['native'].city}"/>
       </td>
     </tr>
     <tr>
      <td>
       <spring:message code="com.spring.mvc.employee.addresses.state"/>
      </td>
      <td>
       <c:out value="${employee.addresses['native'].state}"/>
      </td>
     </tr>
     <tr>
      <td>
       <spring:message code="com.spring.mvc.employee.addresses.state"/>
      </td>
      <td>
       <c:out value="${employee.addresses['native'].pin}"/>
      </td>
     </tr>
     <tr>
      <td>
       <spring:message code="com.spring.mvc.employee.addresses.country"/>
      </td>
       <td>
        <c:out value="${employee.addresses['present'].country}"/>
      </td>
     </tr>
   </table>
   <table id="projectTable">
    <c:forEach var="proj" items="${employee.projects}" varStatus="vs">
     <tr>
      <th>
       <spring:message code="com.spring.mvc.employee.project.details"/>
      </th>
      </tr>
     <tr>
      <th>
       <spring:message code="com.spring.mvc.employee.project.title"/>
      </th>
      <td>
       <c:out value="${proj.title}"/>
      </td>
      </tr>
       <tr> 
      <th>
       <spring:message code="com.spring.mvc.employee.project.desc"/>
      </th>
      <td>
       <c:out value="${proj.desc}"/>
      </td>
     </tr>
     <tr> 
      <th>
       <spring:message code="com.spring.mvc.employee.project.role"/>
      </th>
      <td>
       <c:out value="${proj.role.roleName}"/>
      </td>
     </tr>
     <tr> 
      <th>
       <spring:message code="com.spring.mvc.employee.project.responsibilities"/>
      </th>
      <td>
       <c:out value="${proj.role.responsiblities}"/>
      </td>
     </tr>
     <tr>
      <th>
       <spring:message code="com.spring.mvc.employee.project.client"/>
      </th>
      <td>
       <c:out value="${proj.client}"/>
       </td>
     </tr>
     <tr>
      <th>
       <spring:message code = "com.spring.mvc.employee.project.technologies"/>
      </th>
      <td>
       <c:out value="${proj.technologies}"/>
      </td>
     </tr>
     <tr>
     <td>
      <hr></hr>
     </td>
    </tr>
   </c:forEach>
   <tr> 
   	 <td>
	  <spring:message code = "com.spring.mvc.employee.upload.profile"/>       
     </td>
     <td> 
      <table border="1">
       <tr>
        <th>
         <spring:message code = "com.spring.mvc.employee.upload.profile.name"/>
        </th>
        <th>
         <spring:message code = "com.spring.mvc.employee.upload.profile.contenttype"/>
        </th>
        <th>
         <spring:message code = "com.spring.mvc.employee.upload.profile.size"/>
        </th>
       </tr>
       <tr>
        <td>
         <c:out value = "${employee.profile.name}"/>
        </td>
        <td>
         <c:out value = "${employee.profile.contentType}"/>
        </td>
        <td>
         <c:out value = "${employee.profile.size}"/>
        </td>
       </tr>
      </table>
     </td>
    </tr>
   </table>
 </body>
 <script type="text/javascript">
  $(document).ready(function() {
	  $("#defaultId").click(function(event) {
		  event.preventDefault();
		  window.location = "http://localhost:8080/springMVCJavaConfig/viewAddEmployee?currentTheme=default";
	  });
	  
	  $("#wheatId").click(function(event) {
		  event.preventDefault();
		  window.location = "http://localhost:8080/springMVCJavaConfig/viewAddEmployee?currentTheme=wheat";
	  });
	  
	  $("#purpleId").click(function(event) {
		  event.preventDefault();
		  window.location = "http://localhost:8080/springMVCJavaConfig/viewAddEmployee?currentTheme=purple";
	  });
  });
 </script>
</html>