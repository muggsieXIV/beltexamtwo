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
<title>${someTask.title}</title>
<link rel="stylesheet" type="text/css" href="css/style.css">
</head>
<body>
    <div class="container">  
		<div>
			<a href="/logout">logout</a>
			<a href="/tasks">Home</a>      
		</div>  
		<div>
			<div><h1>Task: ${someTask.title}</h1></div>
            <div>
				<h3>Creator: ${someTask.user.name}</h3>
            </div>
			<div>
                <h3>Assignee: ${someTask.assignee}</h3>
            </div>
            <div>
                <h3>Priority: ${someTask.priority}</h3>
            </div>
		</div>
        <div>
			<br>
			<a href="/edit/tasks/${someTask.id}"> Edit ${someTask.title}</a>
			<form action="/tasks/destroy/${someTask.id}" method="post">
				<input type="hidden" name="_method" value="delete">
		    	<input type="submit" value="Delete">
			</form>
        </div>
    </div>
</body>
</html>