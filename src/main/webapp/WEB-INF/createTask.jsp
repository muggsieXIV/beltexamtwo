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
<title>Task Manager - Create</title>
</head>
<body>
	 <div>
		<form:form action="/createTask" method="POST" modelAttribute="newTask">
            <div>
                <label>Task</label>
                <form:input path="title" />
            	<form:errors path="title"/>
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
					<option value="Low">Low</option>
					<option value="Medium">Medium</option>
					<option value="High" selected>High</option>
				</select>	
				<form:errors path="priority"/>			    
			</div>				
			<br>
			<input type="submit" value="Create" />
		</form:form>
     </div>
</body>
</html>