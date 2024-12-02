<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
</head>
<body>
	<div>
		<h1>회원정보수정 메뉴 입니다.</h1>
	</div>

	<div>
		<form:form modelAttribute="member" method="post">
			<p>아이디 : <form:input path="userId" name="id" value="${member.getUserId}" /></p>
			<p>비밀번호 : <form:password path="password" name="id" /></p>
			<p>E-mail : <form:input path="email" name="email" value="${member.getEmail}" /></p>
			<p>이름 : <form:input path="name" name="name" value="${member.getName}" /></p>
			<p>사이트에서 사용할 별명 : <form:input path="nikName" name="nikName" value="${member.getNikName}" /></p>
			<p>아기생일 : <form:input path="babyBirthDay" name="babyBirthDay" value="${member.getBabyBirthDay}" /></p>
			<p>통신사 : <form:select path="telecom" name="telecom" >
				<form:option value="skt">SKT</form:option>
				<form:option value="kt">KT</form:option>
				<form:option value="lgu+">LG U+</form:option>
				<form:option value="알뜰">알뜰폰</form:option>
			</form:select></p>
			<p>전화번호 : <form:input type="number" path="phone" name="phone" value="${member.getPhone}" /></p>
			<p><input type="submit" value="수정"></p>
		</form:form>
	</div>
</body>
</html>
