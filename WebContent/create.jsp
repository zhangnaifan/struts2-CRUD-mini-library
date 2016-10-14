<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>Creating</title>
	<link rel="stylesheet" type="text/css" href="create.css"/>
</head>
<body>
<form action="Create" method="post" id="form">
	<table>
	
		<tr>
			<th>ISBN</th>
			<th>Title</th>
			<th>AuthorID</th>
			<th>Publisher</th>
			<th>Publish Date</th>
			<th>Price</th>
		</tr>
		
		<tr>
			<td><input required class="input" type="text" name="book.ISBN" placeholder="7-111-19947-2" pattern="^(\d[- ]*){9}[\dxX]$"/></td>
			<td><input required class="input" type="text" name="book.title" placeholder="title" pattern="^\w+[\w\s]+\w+$" /></td>
			<td><input required class="input" type="number" min="1" step="1" max="10000" name="book.authorID" placeholder="99" pattern="^[0-9]*[1-9][0-9]*$"/></td>
			<td><input required class="input" type="text" name="book.publisher" placeholder="publisher" pattern="^\w+[\w\s]+\w+$"/></td>
			<td><input required class="input" type="date" name="book.date" placeholder="2016-09-20" pattern="^\d{4}-\d{1,2}-\d{1,2}"/></td>
			<td><input required class="input" type="number" min="0" step="0.01" max="100000" name="book.price" placeholder="20.00" /></td>
		</tr>
	
	</table>
	
	<input class="submit" type="submit" value="Create!"/>
</form>
</body>
</html>