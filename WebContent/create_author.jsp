<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>Creating</title>
	<link rel="stylesheet" type="text/css" href="create.css"/>

</head>
<body>
<form action="CreateAuthor?book.ISBN=${book.ISBN }&book.title=${book.title}
	&book.authorID=${book.authorID}&book.publisher=${book.publisher}
	&book.date=${book.date}&book.price=${book.price}" method="post">
	
	<p>Please complete information whose AuthorID is ${book.authorID } </p>
	<table>
	
		<tr>
			<th>AuthorID</th>
			<th>Name</th>
			<th>Age</th>
			<th>Country</th>
		</tr>
		
		<tr>
			<td><input class="input" type="number" min="1" step="1" max="10000" name="author.id" value="${book.authorID }" pattern="^[0-9]*[1-9][0-9]*$" readonly /></td>
			<td><input class="input" type="text" name="author.name" pattern="^\w+[\w\s]+\w+$"/></td>
			<td><input class="input" type="number" min="1" step="1" max="1000" name="author.age" pattern="^[0-9]*[1-9][0-9]*$"/></td>
			<td><input class="input" type="text" name="author.country" pattern="^\w+[\w\s]+\w+$"/></td>
		</tr>
	
	</table>
	<input type="submit" value="Create an author!" class="submit"/>
</form>
</body>
</html>