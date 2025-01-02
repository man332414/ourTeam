<link rel="preconnect" href="https://fonts.googleapis.com">
<link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
<link href="https://fonts.googleapis.com/css2?family=Montserrat:ital,wght@0,100..900;1,100..900&display=swap" rel="stylesheet">
<%@ page session = "false" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page import="com.springmvc.DTO.Member" %>
<%@ page pageEncoding="UTF-8"%>
<header class="header align-items-center fixed-top">
    <div class="container-fluid py-4 position-relative d-flex align-items-center justify-content-between" style="background-image: url(${pageContext.request.contextPath}/resources/images/main_banner.jpg);" id="mainBanner">
        <h1 style="font-family:montserrat;"><a href="/ourProject" class="text-decoration-none" style="color:#0d6efd;">MombyGrow<span style="color:red;">.</span></a></h1>
        <nav class="navmenu">
        	<ul class="d-flex justify-content-between" style="list-style: none; margin:0; padding:0; font-family:poppins;">
        		<li>
		        <% 
		        	HttpSession session = request.getSession(false);
		        	Member member = null;
		        	if(session!=null)
		        	{
	  		      	 	member = (Member)session.getAttribute("member");	        		
		        	}
		        %>
	            <sec:authorize access="hasRole('ROLE_ADMIN')">
	          		<li>
						<a class="p-2 text-decoration-none link-light" href="/ourProject/readMembers">회원 관리</a>
            		</li>
	            </sec:authorize>
           		<%
           			if(member!=null)
           			{
           		%>
           		<li>
		            <a class="p-2 text-decoration-none link-light" href="/ourProject/diarys?userId=<%=member.getUserId()%>">성장일기</a>
		        </li>
	        	<%
           			}
	        	%>
           		<li>
		            <a class="p-2 text-decoration-none link-light" href="/ourProject/board/list">게시판</a>
	            </li>
           		<li>
		            <a class="p-2 text-decoration-none link-light" href="/ourProject/calendar">백신접종 일정관리</a>
	            </li>
           		<li>
		            <a class="p-2 text-decoration-none link-light" href="/ourProject/emergencys">응급실 보유병원 검색</a>
	            </li>
           		<li>
		            <a class="p-2 text-decoration-none link-light" href="/ourProject/products">출산/육아용품 체크리스트</a>
        		</li>
        	</ul>	
        </nav>
        	<div>
        		<%
		           	if(member==null)
		       	   	{
		  	   	%>
		           		<a class="btn btn-primary text-decoration-none" href="/ourProject/signIn">회원 가입</a>
		           		<a class="btn btn-danger text-decoration-none" href="/ourProject/login">로그인</a>
		        <%
		       	   	}
		           	else
		           	{
           		%>
		   				<span style="color:#f9fafb; margin-right:10px;"><%=member.getNikName()%>님 안녕하세요!</span>
		   	            <a class="btn btn-primary text-decoration-none" href="/ourProject/updateMember?userId=<%=member.getUserId()%>">회원정보수정</a>
						<a class="btn btn-danger text-decoration-none" href="/ourProject/logout">로그아웃</a>
				<%
		         	}
		        %>
        	</div>
    </div>
</header>
