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
  <form:form action="addEmployeeNext" commandName="employee" method="post">
   <table>
    <tr>
     <td>
      <form:label path="firstName">
       <spring:message code="com.spring.mvc.employee.firstName"/>
      </form:label>
     </td>
     <td>
      <form:input path="firstName"/>
     </td>
     <td>
      <form:errors path="firstName"/>
     </td>
    </tr>
    <tr>
     <td>
      <form:label path="lastName">
       <spring:message code="com.spring.mvc.employee.lastName"/>
      </form:label>
     </td>
     <td>
      <form:input path="lastName"/>
     </td>
     <td>
      <form:errors path="lastName"/>
     </td>
    </tr>
    <tr>
     <td>
      <form:label path="gender">
       <spring:message code="com.spring.mvc.employee.gender"/>
      </form:label>
     </td>
     <td>
      <form:select path="gender" items="${genders}"/>
     </td>
     <td>
      <form:errors path="gender"/>
     </td>
    </tr>
    <tr>
     <td>
      <form:label path="joiningDate">
       <spring:message code="com.spring.mvc.employee.joiningDate"/>
      </form:label>
     </td>
     <td>
      <form:input path="joiningDate"/>
     </td>
    <td>
      <form:errors path="joiningDate"/>
     </td>
    </tr>
    <tr>
     <td>
      <form:label path="releaseDate">
       <spring:message code="com.spring.mvc.employee.releaseDateDate"/>
      </form:label>
     </td>
     <td>
      <form:input path="releaseDate"/>
     </td>
     <td>
      <form:errors path="releaseDate"/>
     </td>
    </tr>
    <tr>
     <td>
      <form:label path="skills">
       <spring:message code="com.spring.mvc.employee.skills"/>
      </form:label>
     </td>
     <td>
      <form:select path="skills" items="${skillsSet}" multiple="true" size="7"/>
     </td>
     <td>
      <form:errors path="skills"/>
     </td>
    </tr>
   <tr>
     <td>
      <form:label path="experience">
       <spring:message code="com.spring.mvc.employee.experience"/>
      </form:label>
     </td>
     <td>
      <form:select path="experience" items="${experenceList}"/>
     </td>
     <td>
      <form:errors path="experience"/>
     </td>
    </tr>
    <tr>
     <td>
      <form:label path="salary">
       <spring:message code="com.spring.mvc.employee.salary"/>
      </form:label>
     </td>
     <td>
      <form:input path="salary"/>
     </td>
     <td>
      <form:errors path="salary"/>
     </td>
    </tr>
    <tr>
     <td>
      <form:label path="annualPkg">
       <spring:message code="com.spring.mvc.employee.annualPkg"/>
      </form:label>
     </td>
     <td>
      <form:input path="annualPkg"/>
     </td>
     <td>
      <form:errors path="annualPkg"/>
     </td>
    </tr>
    <tr>
     <td>
      <form:label path="contacts['contact']">
       <spring:message code="com.spring.mvc.employee.contacts.contact"/>
      </form:label>
     </td>
     <td>
      <form:input path="contacts['contact']"/>
     </td>
     <td>
      <form:errors path="contacts"/>
     </td>
    </tr>
    <tr>
     <td>
      <form:label path="contacts['contactType']">
       <spring:message code="com.spring.mvc.employee.contacts.contactType"/>
      </form:label>
     </td>
     <td>
      <form:select path="contacts['contactType']" items="${contactTypes}"/>
     </td>
     <td>
       <form:errors path="contacts"/>
     </td>
    </tr>
    <tr>
    <tr>
     <td>
	  <input type="submit"  id = "nextId" value="<spring:message code='com.spring.mvc.employee.action.next'/>">       
     </td>
    </tr>
   </table>
  </form:form>
 </body>
</html>