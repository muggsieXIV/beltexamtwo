<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Task Manager</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
     <div class="container">  
      	<div>
			<a href="/logout">logout</a>
	    </div>  
        <h1>Welcome, <c:out value="${user.name}"></c:out></h1>
        <div>
               <table>
                   <tr>
                       <th>Task</th>
                       <th>Creator</th>
                       <th>Assignee</th>
                       <th>Priority</th>
                   </tr>
                   <c:forEach items="${allTasks}" var="task">
                      <tr>
                          <td><a href="/tasks/${task.id}">${task.title}</a></td>
                          <td>${task.user.name}</td>
                          <td>${task.assignee}</td>
                          <td>${task.priority}</td>
                      </tr>
                   </c:forEach>
                </table>
        </div>
        <a href="/tasks/new">Create Task</a>
    </div>
    
</body>
</html>