<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- <%@ page import="org.apache.jasper.tagplugins.jstl.core.ForEach"%>  --%>
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
		<h1>관리자 게시판 기능입니다.</h1>
		<a href="/ourProject/board/refresh">글 다시 읽어오기</a>
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
  			<div>
  				<button id="deleteBtn">삭제</button>
  				<a href="create">새 글쓰기</a>
  			</div>
		</div>
		<form id="deleteCheckBoxes" method="get" action="delete">
			<table border="1px">
				<tr>
					<th><label for="number">선택<input type="checkbox" id="number"></label></th><th>순번</th><th>분류</th><th>제목</th><th>게시일자</th><th>비고</th>					
				</tr>
				<tbody id="resultBody">
					<c:forEach var="board" items="${boards}" >
						<TR>
						    <TD>
									<input type=checkbox name="number" value="${board.number}">
							</TD>
		                    <TD><A HREF="/ourProject/board/content?number=${board.number}">${board.number}</A></TD>
		                    <TD><A HREF="/ourProject/board/content?number=${board.number}">${board.category}</A></TD>
		                    <TD><A HREF="/ourProject/board/content?number=${board.number}">${board.title}</A></TD>
		                    <TD><A HREF="/ourProject/board/content?number=${board.number}">${board.date}</A></TD>
		                    <TD><A HREF="/ourProject/board/content?number=${board.number}"></A></TD>
						</TR>
					</c:forEach>
				</tbody>
			</table>
		</form>
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
<script type="text/javascript" src="/ourProject/resources/js/(board.jsp)searchFunction.js">
</script>
<script>
// 	버튼 누르면 제출되는 함수
	let deleteBtn = document.querySelector("#deleteBtn");
	console.log(deleteBtn);
	
	deleteBtn.addEventListener("click", deleteFunction);
	
	function deleteFunction()
	{
		let deleteForm = document.querySelector("#deleteCheckBoxes");
		console.log(deleteForm);
		
		deleteForm.submit();
	}
</script>
<script>
    //선택버튼 클릭 시 해당페이지 전체 선택
	let checkAll = document.querySelector("#number");
	console.log(checkAll);

	checkAll.addEventListener("click", toggleCheckBoxes);

	function toggleCheckBoxes(event)
	{
		let numbers = document.querySelectorAll('input[name="number"]');
		console.log(numbers);
		numbers.forEach(function(number)
			{
				console.log(number);
				number.checked = event.target.checked;	
			}
		);
	}
</script>
</html>