<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div>
		<h1>회원정보수정 메뉴 입니다.</h1>
	</div>

	<div>
		<form:form action="updateMember" modelAttribute="member" method="post">
			<p>아이디 : <form:input path="userId" value="${member.getUserId()}" readonly="true" /></p>
			<p>비밀번호 : <form:password path="password" /></p>
			<p>E-mail : <form:input path="email" value="${member.getEmail()}" /></p>
			<p>이름 : <form:input path="name" value="${member.getName()}" /></p>
			<p>사이트에서 사용할 별명 : <form:input path="nikName" value="${member.getNikName()}" /></p>
			<p>아기생일 : <form:input path="babyBirthDay" value="${member.getBabyBirthDay()}" /></p>
			<p>통신사 : <form:select path="telecom" >
				<form:option value="skt">SKT</form:option>
				<form:option value="kt">KT</form:option>
				<form:option value="lgu+">LG U+</form:option>
				<form:option value="알뜰폰">알뜰폰</form:option>
			</form:select></p>
			<p>전화번호 : <form:input type="number" path="phone" value="${member.getPhone()}" /></p>
			<p>
			<input type="submit" value="수정">
			<a href="deleteMember?userId=${member.getUserId()}">삭제</a>
			<button id="delbtn">삭제</button>
			</p>
		</form:form>
	</div>
</body>
<script>
	let deletebtn = document.querySelector("#delbtn");
	console.log(deletebtn);
	
	deletebtn.addEventListener("click", delfunc);
	
	function delfunc(e)
	{
		console.log("함수입장");
		let result = window.confirm("정말 삭제하시겠습니까?");
		if(result)
			{
				alert("삭제합니다.")
				window.location.href = "deleteMember?userId=${member.getUserId()}";
				
			}
		else
			{
				alert("취소하였습니다.")
			}
	}	
</script>
</html>
