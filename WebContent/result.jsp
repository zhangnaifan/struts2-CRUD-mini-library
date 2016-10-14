<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

	<link rel="stylesheet" type="text/css" href="style.css"/>
	
</head>
<body>

	<h1>Welcome to use our tiny library!</h1>
		
	<form action="popCreate" target="_blank">
		<input class="create_book" type="submit" value="Create a new book!"/>
	</form>		
	
	<form action="Query" method="post">
		<table class="transparent">
			<tr>
				<td class="transparent">
					<input class="search_input" type="text" name="author.name" placeholder="Author' Name" />
				</td>
				<td class="transparent">
					<input class="search_button" type="submit" value="Search!"/>
				</td>
			</tr>
		</table>
	</form>
		
	<p>${info }</p>
	
	<table>
		<tr class="header">
			<th class="book_name">Book Name</th>
			<th>Delete</th>
			<th>Update</th>
		</tr>
		<s:iterator value="books">
			<tr>
				<td><a href="Show.action?book.ISBN=${ISBN }&author.id=${authorID}" target="_blank" class="book_name"><s:property value="title"></s:property></a></td>
				<td><a href="Delete.action?book.ISBN=${ISBN}&author.name=${author.name}">Delete!</a></td>
				<td><a href="popUpdate.action?book.ISBN=${ISBN}&author.id=${authorID}">Update!</a></td>
			</tr>
		</s:iterator>

	</table>
</body>
</html>