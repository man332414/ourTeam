<%@ page session = "false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ page import="com.springmvc.DTO.Member" %>
<%@ page pageEncoding="UTF-8"%>
<header class="container" style="height:150px;">
    <div class="text-center fixed-top bg-light py-3">
        <h1><a href="/ourProject">임산부 정보 취합 프로젝트</a></h1>
        <nav class="nav justify-content-center">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
				<a class="nav-link" href="/ourProject/readMembers">회원 관리</a>
            </sec:authorize>
        <% 
        	HttpSession session = request.getSession(false);
           	if(session==null)
       	   	{
  	   	%>
           		<a class="nav-link" href="/ourProject/signIn">회원 가입</a>
           		<a class="nav-link" href="/ourProject/login">로그인</a>
        <%
       	   	}
           	else
           	{
	        	Member member = (Member)session.getAttribute("member");
   		%>
				<a class="nav-link" href="/ourProject/logout">로그아웃</a>
   	            <a class="nav-link" href="/ourProject/updateMember?userId=<%=member.getUserId()%>">회원정보수정</a>
	            <a class="nav-link" href="/ourProject/diarys">성장일기</a>
		<%
         	}
        %>
            <a class="nav-link" href="/ourProject/board/list">게시판</a>
            <a class="nav-link" href="/ourProject/calendar">예방접종 일정 관리</a>
            <a class="nav-link" href="/ourProject/emergencys">응급실 보유병원 검색</a>
            <a class="nav-link" href="/ourProject/products">출산/육아용품 체크리스트</a>
        </nav>
    </div>
</header>
