<%@ page contentType="text/html; charset=UTF-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<html>
<head>

	<link rel="stylesheet" type="text/css" href="style.css"/>

</head>
<body>
	<h1>Welcome to use our tiny library system!</h1>

	<form action="popCreate" target="_blank">
		<input class="create_book" type="submit" value="Create a new book!"/>
	</form>		
	
	<form action="Query" method="post">
		<table class="transparent">
			<tr>
				<td class="transparent">
					<input class="search_input" type="text" name="author.name" placeholder="Author' Name" pattern="^\w+[\w\s]+\w+$"/>
				</td>
				<td class="transparent">
					<input class="search_button" type="submit" value="Search!"/>
				</td>
			</tr>
		</table>
	</form>
	
	<p>Try author: znf(1), zhangnaifan(2), zhangnf(3)</p>

</body>
</html>