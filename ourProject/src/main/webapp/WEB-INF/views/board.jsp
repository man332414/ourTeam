<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%! int numberOfRows; 
	int currentPage;
	%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>게시판</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="http://code.jquery.com/jquery-latest.min.js"></script>
    <style>
        body {
            background-color: #f8f9fa; /* 배경색 설정 */
        }
        h1 {
            color: #007bff; /* 제목 색상 */
        }
        .search-container {
            margin-bottom: 20px;
        }
        .table {
            margin-top: 20px;
            background-color: white; /* 테이블 배경색 */
        }
        #pages {
            text-align: center;
            margin-top: 20px;
        }
        #pages a {
            margin: 0 5px;
            color: #007bff; /* 링크 색상 */
        }
        #pages a:hover {
            text-decoration: underline; /* 마우스 오버 시 밑줄 */
        }
    </style>
</head>
<body>
    <div class="container mt-5">
        <div class="text-center">
            <h1>게시판 기능입니다.</h1>
        </div>
        
        <div class="search-container">
            
            <form action="list/searching" class="form-inline justify-content-center">
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
				검색하기 : <input type="text" id="searchBox" class="form-control mr-2" placeholder="검색어를 입력하세요" value="<%=searchFor%>">
				<button type="submit" class="btn btn-primary">검색</button>
			</form>

            <form method="get" action="" class="form-inline justify-content-center mt-2">
                <label for="numberOfRows" class="mr-2">페이지당 항목 수:</label>
                <select name="numberOfRows" id="numberOfRows" class="form-control" onchange="this.form.submit()">
					<option value="10" <%= numberOfRows == 10 ? "selected" : "" %>>선택</option>
                    <option value="10" <%= numberOfRows == 10 ? "selected" : "" %>>10</option>
                    <option value="20" <%= numberOfRows == 20 ? "selected" : "" %>>20</option>
                    <option value="50" <%= numberOfRows == 50 ? "selected" : "" %>>50</option>
                    <option value="100" <%= numberOfRows == 100 ? "selected" : "" %>>100</option>
                </select>
            </form>
        </div>

        <table class="table table-bordered">
            <thead class="thead-light">
                <tr>
                    <th>순번</th>
                    <th>분류</th>
                    <th>제목</th>
                    <th>게시일자</th>
                    <th>비고</th>
                </tr>
            </thead>
            <tbody id="resultBody">
                <c:forEach var="board" items="${boards}">
                    <tr>
                        <td><a href="content?number=${board.number}">${board.number}</a></td>
                        <td><a href="content?number=${board.number}">${board.category}</a></td>
                        <td><a href="content?number=${board.number}">${board.title}</a></td>
                        <td><a href="content?number=${board.number}">${board.date}</a></td>
                        <td><a href="content?number=${board.number}">보기</a></td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
		<% int totalPage = 0; %>
        <div id="pages">
            <%
                totalPage = (int)request.getAttribute("totalPage");
                for(int i = 1; i <= totalPage; i++) {
            %>
                <a href="?currentPage=<%=i%>&search=<%=searchFor%>"><%=i%></a>
            <%
                }
            %>		
        </div>
    </div>
</body>
<script type="text/javascript" src="/ourProject/resources/js/(board.jsp)searchFunction.js"></script>
</html>