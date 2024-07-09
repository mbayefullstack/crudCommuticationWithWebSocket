<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Add Product</title>
</head>
<body>
   <h3>Add Product</h3>
   <form action="${pageContext.request.contextPath}/products/add" method="post">
      Name: <input type="text" name="name"><br>
      Price: <input type="text" name="price"><br>
      Stock: <input type="text" name="stock"><br>
      <input type="submit" value="Add Product">
   </form>
</body>
</html>