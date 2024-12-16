<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%! int numberOfRows; 
	int currentPage;
	%>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<head>
<meta charset="UTF-8">
<title>Board</title>
</head>
<body>
	<div style="display:flex; justify-content: space-between; text-align: center;">
		<h1>게시판 기능입니다.</h1>
	</div>
	
	<div>
		<div>
			<form action="searching">
			<% 
				String searchFor;
				if(request.getAttribute("searchFor") == null)
				{
					searchFor="";							
				}
				else
				{
					searchFor = (String)request.getAttribute("searchFor"); 
				}
			%>
				검색하기 : <input type="text" id="searchBox" value="<%=searchFor%>">
			</form>
	    	<form method="get" action="">
        		<label for="numberOfRows">페이지당 항목 수:</label>
        		<select name="numberOfRows" id="numberOfRows" onchange="this.form.submit()">
	            	<option value="10" <%= numberOfRows == 10 ? "selected" : "" %>>선택</option>
	            	<option value="10" <%= numberOfRows == 10 ? "selected" : "" %>>10</option>
	            	<option value="20" <%= numberOfRows == 20 ? "selected" : "" %>>20</option>
	            	<option value="50" <%= numberOfRows == 50 ? "selected" : "" %>>50</option>
	            	<option value="100" <%= numberOfRows == 100 ? "selected" : "" %>>100</option>
        		</select>
  			</form>
		</div>
		<table border="1px">
			<tr>
				<th>순번</th><th>분류</th><th>제목</th><th>게시일자</th><th>비고</th>
			</tr>
			<tbody id="resultBody">
				<c:forEach var="board" items="${boards}" >
					<TR>
	                    <TD><A HREF="content?number=${board.number}">${board.number}</A></TD>
	                    <TD><A HREF="content?number=${board.number}">${board.category}</A></TD>
	                    <TD><A HREF="content?number=${board.number}">${board.title}</A></TD>
	                    <TD><A HREF="content?number=${board.number}">${board.date}</A></TD>
	                    <TD><A HREF="content?number=${board.number}"></A></TD>
					</TR>
				</c:forEach>
			</tbody>
		</table>
		<% int totalPage = 0; %>
		<div id="pages">
			<%
				totalPage = (int)request.getAttribute("totalPage");
				for(int i = 1; i <= totalPage; i++)
				{
			%>
				<a href="?currentPage=<%=i%>&search=<%=searchFor%>"><%=i%></a>
			<%
				}
			%>		
		</div>
	</div>
</body>
<script type="text/javascript" src="/ourProject/resources/js/searchFunction.js">
</script>

</html>