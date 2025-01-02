<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%! int numberOfRows; 
	int currentPage;
	%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
   	<script src="https://kit.fontawesome.com/c53a51a6e0.js" crossorigin="anonymous"></script>
    <style>
        body 
        {
            background-color: #f8f9fa; /* 배경색 설정 */
        }
    </style>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container justify-content-center" style="padding:140px 0 30px 0;">
        <div class="text-center">
            <h1>복지지원 게시판</h1>            
        </div>
        <div class="d-flex justify-content-between">
        	<div class="d-flex justify-content-between">
	            <form method="get" action="" class="form-select" style="width: auto; background-color: transparent; border: none;">
	                <label for="numberOfRows">페이지당 항목 수:</label>
	                <select name="numberOfRows" id="numberOfRows" class="form-control" onchange="this.form.submit()" style="display:inline; width:auto;">
	                    <option value="10" <%= numberOfRows == 10 ? "selected" : "" %>>선택</option>
	                    <option value="10" <%= numberOfRows == 10 ? "selected" : "" %>>10</option>
	                    <option value="20" <%= numberOfRows == 20 ? "selected" : "" %>>20</option>
	                    <option value="50" <%= numberOfRows == 50 ? "selected" : "" %>>50</option>
	                    <option value="100" <%= numberOfRows == 100 ? "selected" : "" %>>100</option>
	                </select>
	            </form>
        	</div>
        	<div class="d-flex justify-content-between">
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
					<label for="searchBox">검색하기 : </label>
					<input type="text" id="searchBox" class="form-control" placeholder="검색어를 입력하세요" value="<%=searchFor%>" style="display:inline; width:auto;">
					<button type="submit" class="btn btn-primary">검색</button>
				</form>
			</div>            
        </div>

		<form id="deleteCheckBoxes" method="get" action="delete">
	        <table class="table table-striped table-hover">
	            <thead class="thead-white">
	                <tr>
	                	<sec:authorize access="hasRole('ROLE_ADMIN')">
		              		<th class="col-1 text-center">
		              			<label for="number">선택
		              			<input type="checkbox" id="number"></label>
	              			</th>
	                	</sec:authorize>
	                    <th class="col-1 text-center">순번</th>
	                    <th class="col-1 text-center">분류</th>
	                    <th class="col text-center">제목</th>
	                    <th class="col-2 text-center">게시일자</th>
<!-- 	                    <th class="col text-center">비고</th> -->
	                </tr>
	            </thead>
	            <tbody id="resultBody">
	                <c:forEach var="board" items="${boards}">
	                    <tr>
	                    	<sec:authorize access="hasRole('ROLE_ADMIN')">
	                    		<td class="col-1 text-center"><input type=checkbox name="number" value="${board.number}"></td>
                    		</sec:authorize>
	                        <td class="col-1 text-center"><a href="${board.content}">${board.number}</a></td>
	                        <td class="col-1 text-center"><a href="${board.content}">${board.category}</a></td>
	                        <td class="col"><a href="${board.content}">${board.title}</a></td>
	                        <td class="col-2 text-center"><a href="${board.content}">${board.date}</a></td>
<%-- 	                        <td class="col text-center"><a href="content?number=${board.number}"></a></td> --%>
	                    </tr>
	                </c:forEach>
	            </tbody>
	        </table>
		</form>
        
		<% int totalPage = 0; %>
        <div style="text-align:center">
            <%
                totalPage = (int)request.getAttribute("totalPage");
                for(int i = 1; i <= totalPage; i++) 
                {
                	currentPage = (int)request.getAttribute("currentPage");
// 	            	System.out.println("currentPage : " + currentPage);
                	if(currentPage==i)
                	{
            %>
            			<a href="?currentPage=<%=i%>&search=<%=searchFor%>" style="font-weight:900;"><%=i%></a>
   			<%
   						continue;
           			}
   			%>
               		<a href="?currentPage=<%=i%>&search=<%=searchFor%>"><%=i%></a>
            <%
                }
            %>		
        </div>
        <sec:authorize access="hasRole('ROLE_ADMIN')">
	        <div class="d-flex" style="justify-content:space-between">
	        	<div>
					<button id="deleteBtn" class="btn btn-danger">삭제</button>
					<a href="create" class="btn btn-primary">새 글쓰기</a>
	        	</div>
				<a href="/ourProject/board/refresh">글 다시 읽어오기</a>
			</div>
		</sec:authorize>
    </div>
	<%@ include file="footer.jsp" %>    
</body>
<script type="text/javascript" src="/ourProject/resources/js/(readAllBoards.jsp)searchFunction.js"></script>
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