<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
		<a href="refresh">글 다시 읽어오기</a>
	</div>
	
	<div>
		<div>
			<form action="searching">
				검색하기 : <input type="text" id="searchBox">
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
	</div>
</body>
<script type="text/javascript">
	// 	검색기능
	let search = document.querySelector("#searchBox");
	console.log(search);

	search.addEventListener("input", searchFunction);
	
	function searchFunction(e)
	{
		e.preventDefault();
		let searchFor = search.value;
		let searchFortoJsonify = {"searchFor" : searchFor};
// 		console.log("searchFortoJsonify : "+searchFortoJsonify);
		$.ajax({
	        url: "/ourProject/board/list/searching",
	        type: "POST",
	        contentType: "application/json",
	        data: JSON.stringify(searchFortoJsonify),
	        dataType: "json",
	        success: function(hello) 
	        {
	        	console.log(hello);
	        	let resultHtml = '';
	        	if(hello == null || hello=="")
	        		{
	        			resultHtml = '<tr><td colspan = "5"> 검색 결과가 없습니다.</td></tr>';
	        		}
	        	else
	        		{
		    			hello.forEach(function(board){
		    				resultHtml += `<tr>
			                    <td><a href="content?number=${board.number}">${board.number}</a></td>
			                    <td><a href="content?number=${board.number}">${board.category}</a></td>
			                    <td><a href="content?number=${board.number}">${board.title}</a></td>
			                    <td><a href="content?number=${board.number}">${board.date}</a></td>
			                    <td><a href="content?number=${board.number}"></a></td>
							</tr>`;
		    			});
	        		}
	        	$('#resultBody').html(resultHtml);
	        },
	        error: function(error) {
	            console.error("에러발생:", error);
	        }
	    });
	}
</script>

</html>