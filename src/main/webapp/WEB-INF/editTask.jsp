<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ page import="java.io.*,java.util.*"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>


<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>Task Manager - Edit Task</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
	<div class="container">    
        <h1>Edit ${someTask.title}</h1>
		<div>
			<a href="/logout">logout</a>
			<a href="/shows">Home</a>
		</div>
		<div>
			<form:form action="/tasks/update/${someTask.id}" method="post" modelAttribute="someTask">
				<div class="form-group">
					<label>Title</label>
                    <form:input path="title" placeholder="${someTask.title}"/>
                    <form:errors path="title" />
                </div>
                <div>
     	     		<label>Assignee</label>
                	<select name="assignee">
						<option value="Gene Smith">Gene Smith</option>
						<option value="Jack O'Conner">Jack O'Conner</option>
						<option value="James Dean" selected>James Dean</option>
					</select>
					<form:errors path="assignee" />
				</div>
				<div> 
					<label>Priority</label>
					<select name="priority">
						<option value="low">Low</option>
						<option value="medium">Medium</option>
						<option value="high" selected>High</option>
					</select>	
					<form:errors path="priority"/>			    
				</div>
				<input type="submit" value="Edit Task" />
        	</form:form> 
        </div>
    </div>
</body>
</html>