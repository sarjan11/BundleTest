<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>   
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%> 

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style type="text/css">





.even{
	background-color: silver;
}
</style>

<script type="text/javascript">
	function display(obj, id1, id2, id3) {
			txt = obj.options[obj.selectedIndex].value;
			document.getElementById(id1).style.display = "none";
			document.getElementById(id2).style.display = "none";
			document.getElementById(id3).style.display = "none";
			if (txt.match(id1)) {
				document.getElementById(id1).style.display = "block";
			}
			if (txt.match(id2)) {
				document.getElementById(id2).style.display = "block";
			}
			if (txt.match(id3)) {
				document.getElementById(id3).style.display = "block";
			}
			//document.write(txt);
		}
</script>
<title>Search By Brand</title>

</head>
<body>
<form:form action="listByChoice.htm" method="POST" commandName="brand" >
	<table>
		
		<tr>
			<td>Brand Name:</td>
			<td><form:select path="brand_name" onchange="display(this,'Addidas','Nike','Reebok');" >
			<form:option value="0" label="Select" />
			<form:option value="Addidas" label="Addidas" />
			<form:option value="Nike" label="Nike" />
			<form:option value="Reebok" label="Reebok" /></form:select>
			</td>
		</tr>
		
		<tbody id="Addidas" style="display: none;">
			<tr>	
			<td>Item Name:</td>
			<td><form:checkbox path="item_name" value="Bag" label="Bag" />
			<form:checkbox path="item_name" value="Shoes" label="Shoes" />
			<form:checkbox path="item_name" value="Jacket" label="Jacket" />
			<form:checkbox path="item_name" value="Cap" label="Cap" />
			<form:checkbox path="item_name" value="Football" label="Football" />
			<form:checkbox path="item_name" value="Trouser" label="Trouser" />
			</td>
			</tr>
		</tbody>
		
		<tbody id="Nike" style="display: none;">
		
		<tr>	
			<td>Item Name:</td>
			<td><form:checkbox path="item_name" value="Shoes" label="Shoes" />
			<form:checkbox path="item_name" value="Jacket" label="Jacket" />
			<form:checkbox path="item_name" value="Cap" label="Cap" />
			<form:checkbox path="item_name" value="Trouser" label="Trouser" />
			</td>
		</tr>
		</tbody>
		
		
		<tbody id="Reebok" style="display: none;">
		<tr>	
			<td>Item Name:</td>
			<td><form:checkbox path="item_name" value="Bag" label="Bag" />
			<form:checkbox path="item_name" value="Jacket" label="Jacket" />
			<form:checkbox path="item_name" value="Basketball" label="Basketball" />
			<form:checkbox path="item_name" value="Sports Wear" label="Sports Wear" />
			<form:checkbox path="item_name" value="Cap" label="Cap" />
			<form:checkbox path="item_name" value="Shoes" label="Shoes" />
			<form:checkbox path="item_name" value="Trouser" label="Trouser" />
			</td>
		</tr>
		
		</tbody>
	<%-- 	<tr>
			<td>Gender:</td>
			<td><form:radiobutton path="gender" value="M" label="M" />
			<form:radiobutton path="gender" value="F" label="F" /></td>
		</tr>
		
		<tr>
			<td>Country:</td>
			<td><form:select path="country">
				<form:option value="0" label="Select" />
				<form:option value="India" label="India" />
				<form:option value="USA" label="USA" />
				<form:option value="UK" label="UK" />
			</form:select></td>
		</tr>
		
		<tr>
			<td>About You:</td>
			<td><form:textarea path="aboutYou"/></td>
		</tr>
		
		<tr>
			<td>Community:</td>
			<td><form:checkbox path="community" value="Spring"
			label="Spring" /> <form:checkbox path="community" value="Hibernate"
			label="Hibernate" /> <form:checkbox path="community" value="Struts"
			label="Struts" /> 
			</td>
		</tr>
		
		<tr>
			<td></td>
			<td><form:checkbox path="mailingList" label="Would you Like to join our mailinglist?" /></td>
		</tr>
		--%>
		<tr>
			<td colspan="2"><input type="submit" value="Search"></td>
		</tr> 
	</table>
</form:form>	


<c:if test="${fn:length(brandList)> 0 }">
	<table cellpadding="5">
		<tr class="even">
			<th>Item No.</th>
			<th>Brand Name</th>
			<th>Item Name</th>
			<th>Item Price</th>
		</tr>
		
		<c:forEach items="${brandList}" var="branded" varStatus="status">
			<%-- <c:set var="test_brand" value="${ }" /> --%>
			<%--   <c:if test="${test_brand == branded.brand_name }"> --%>
				<tr class="<c:if test="${status.count %2 ==0 }">even</c:if>">
					<td>${branded.item_id }</td>
					<td>${branded.brand_name }</td>
					<td>${branded.item_name }</td>
					<td>${branded.item_price }</td>
				</tr>
			<%-- </c:if> --%>
		</c:forEach>
	</table>
</c:if>


</body>
</html>