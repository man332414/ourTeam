<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
	<%@ include file="header.jsp" %>
    <div class="container mt-5" style="padding:140px 0 80px 0;">
	<div class="pb-4">	
		<h1>회원정보수정 메뉴 입니다.</h1>
	</div>
		<div>
			<form:form action="updateMember" modelAttribute="member" method="post">
				<p>아이디 : <form:input path="userId" value="${member.getUserId()}" readonly="true" /></p>
				<p>비밀번호 : <form:password path="password" name="password" id="password" minlength="5" />
				비밀번호 확인 :	<input type="password" id="passwordconfirm" />
							<input type="hidden" id="pwCheck" value="false" />
							<span id="pwConfirmInfo" style="display:none; color:red;">비밀번호가 일치하지 않습니다.</span>
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
				<button id="delbtn">삭제</button>
				</p>
			</form:form>
		</div>
	</div>	
	<%@ include file="footer.jsp" %>
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
<script>
	//비밀번호 일치 여부 확인
	let passwordconfirm = document.querySelector("#passwordconfirm");
	console.log("passwordconfirm : " + passwordconfirm);
	let password = document.querySelector("#password")
	console.log("password : " + password);
	let isPwCheck = document.querySelector("#pwCheck").value;
	let pwConfirmInfo = document.querySelector("#pwConfirmInfo");
	
	passwordconfirm.addEventListener("input", pwConfirm);
	
	function pwConfirm()
	{
		console.log("pwConfirm() 입장");
		if(passwordconfirm.value == password.value)
		{
			console.log("비밀번호 일치");
			isPwCheck = 'true';
			pwConfirmInfo.style.display="none";
		}
		else
		{
			isPwCheck = 'false';
			pwConfirmInfo.style.display="inline";
		}
	}
	
</script>

</html>
