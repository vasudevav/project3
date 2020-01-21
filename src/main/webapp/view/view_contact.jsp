<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<a href="/" >+add New Contact</a><br>
<b style="color:red">${delete} </b>
<table border="1" style="background-color:cyan">
 
  <thead>
     <tr style="background-color: magenta">
       <td>ContactId</td>
       <td>ContactName</td>
       <td>Email</td>
       <td>PhoneNumber</td>
       <td>Action</td>
     </tr>
  </thead>
  <tbody>
       <c:forEach items="${listContact}" var="domain" varStatus="status">
         <tr style="background-color: pink">
           <td>${status.index+1}</td>
           <td>${domain.contactName}</td>
           <td>${domain.email }</td>
           <td>${domain.phNo }</td>
           <td><a href="/editContact?contactId=${domain.contactId}">edit</a></td>
           <td><a href="/deleteContact?contactId=${domain.contactId}" onclick="return deleteConfirm()">delete</a></td> 
         </tr>
       </c:forEach>
  </tbody>
  
</table>
<script type="text/javascript">
    function deleteConfirm(){
    	return confirm("Do you want to Delete,Are You sure")
    }

</script>