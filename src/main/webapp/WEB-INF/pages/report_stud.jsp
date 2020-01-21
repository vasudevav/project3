<%@ page language="java" contentType="text/html; charset=ISO-8859-1" isELIgnored="false" pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<p align="center">
   <a title="insert" href="insert_stud.htm"><img src="images/add.jpg" width="30" height="30"></a>
     &nbsp; &nbsp;
 <a title="home" href="welcome.htm"><img title="home" src="images/home.png" width="30" height="30"></a>
 </p>
 <br>
 <c:if test="${!empty msg}">
         <p align="center"><b>${msg} </b></p>
   </c:if>
<br>
<c:choose>
 <c:when test="${!empty reportData}">
   <table border="1" bgcolor="cyan" align="center">
     <tr>
       <th>sno</th><th>sname</th><th>sadd</th><th>course</th><th>operations</th>
     </tr>
     <c:forEach var="dto" items="${reportData}">
       <tr>
         <td>${dto.sno}</td>
         <td>${dto.sname} </td>
         <td>${dto.sadd} </td>
         <td>${dto.course} </td>
         <td><a title="edit" href="edit_stud.htm?sno=${dto.sno}"><img src="images/edit.jpg" width="30" height="15"></a> 
         <a title="delete" href="delete_stud.htm?sno=${dto.sno}" onclick="checkOnce(${dto.sno})"><img src="images/delete.jpg" width="30" height="15"></a> </td>
       </tr>
     </c:forEach>
   </table>
 </c:when>
  <c:otherwise>
     <h1 style="color:red;text-align:center">No Data Found</h1>
  </c:otherwise>
</c:choose><br>
   <c:if test="${!empty msg}">
         <p align="center"><b>${msg} </b></p>
   </c:if>
   <br>
 <p align="center">
   <a title="insert" href="insert_stud.htm"><img src="images/add.jpg" width="30" height="30"></a>
     &nbsp; &nbsp;
 <a title="home" href="welcome.htm"><img title="home" src="images/home.png" width="30" height="30"></a>
 </p>
 
 <script language="JavaScript">
    function checkOnce(sno){
      confirm("<b>Are u sure about deleting student with sno"+sno+"? </b>")
    }
 
 </script>