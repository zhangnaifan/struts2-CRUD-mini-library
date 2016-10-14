<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>
	<title>Information about this book! </title>
	<link rel="stylesheet" type="text/css" href="create.css"/>
</head>
<body>

	<fieldset>
		<legend>About the book</legend>
		<table>
			<tr>
				<th>ISBN</th><th>Title</th><th>AuthorID</th>
				<th>Publisher</th><th>Publish Date</th><th>Price</th>
			</tr>
			<tr>
				<td class="book_name">${book.ISBN }</td>
				<td>${book.title }</td>
				<td>${book.authorID }</td>
				<td>${book.publisher }</td>
				<td>${book.date }</td>
				<td>${book.price }</td>
			</tr>
		</table>
	</fieldset>
	
	<br><br><br>

	<fieldset>
		<legend class="hd">About the author</legend>
		<table>
			<tr>
				<th>Name</th><th>Age</th><th>Country</th>
			</tr>
		
			<tr>
				<td>${author.name }</td>
				<td>${author.age }</td>
				<td>${author.country }</td>
			</tr>
		</table>
	</fieldset>
</body>
</html>