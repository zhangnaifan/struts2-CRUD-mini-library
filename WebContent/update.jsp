<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
	<link rel="stylesheet" type="text/css" href="update.css"/>
<head>
<title>Updating</title>

<script type="text/javascript">
	function subform(){
		if (confirm("Are you sure to update the book?")){
			var form = document.getElementById("form");
			form.submit();
		}
	}
</script>

</head>
<body>
<form action="Update" method="post" id="form">
	<fieldset>
		<legend>Update the book</legend>
		<table>
			<tr>
				<th>ISBN</th>
				<th>Title</th>
				<th>AuthorID</th>
				<th>Publisher</th>
				<th>Publish Date</th>
				<th>Price</th>
			</tr>
				<tr><td><input readonly class="update_input" type="text" name="book.ISBN" value="${book.ISBN }" /></td>
				<td><input readonly class="update_input" type="text" name="book.title" value="${book.title }" /></td>
				<td><input readonly class="update_input" type="number" name="book.authorID" value="${book.authorID }" /></td>			
				<td><input required class="update_input" type="text" name="book.publisher" value="${book.publisher }" pattern="^\w+[\w\s]+\w+$"/></td>
				<td><input required class="update_input" type="date" name="book.date" value="${book.date }"/></td>
				<td><input required class="update_input" type="number" min="0" step="0.01" max="100000" name="book.price" value="${book.price }" pattern="^//d+(//.//d+)?$"/></td>
			</tr>
		</table>
	</fieldset>
	<fieldset>
		<legend>Update the author</legend>
		<table>
			<tr>
				<th>AuthorID</th>
				<th>Name</th>
				<th>Age</th>
				<th>Country</th>
			</tr>
			<tr>
				<td><input class="update_input" type="number" name="author.id" value="${author.id }" readonly /></td>			
				<td><input required class="update_input" type="text" name="author.name" value="${author.name }" pattern="^\w+[\w\s]+\w+$"/></td>
				<td><input required class="update_input" type="number" min="1" step="1" max="500" name="author.age" value="${author.age }"/></td>
				<td><input required class="update_input" type="text" name="author.country" value="${author.country }" pattern="^\w+[\w\s]+\w+$"/></td>
			</tr>
		</table>
	</fieldset>
	
	
	<input class="submit" type="button" onclick="subform()" value="Update"/>
</form>
</body>
</html>