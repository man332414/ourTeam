<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
</head>
<body>
	<div>
		<h1>회원가입 메뉴 입니다.</h1>
	</div>
	<div>
		<form:form modelAttribute="member" method="post" id="signInForm">
			<p>
				아이디 : <form:input path="userId" name="id" id="userId" />
				<button id="checkDupl">중복검사</button>
				<input type="hidden" id="idCheck" value="false" />
			</p>
			<p>비밀번호 : <form:password path="password" name="password" /></p>
			<p>E-mail : <form:input type="email" path="email" name="email" /></p>
			<p>이름 : <form:input path="name" name="name" /></p>
			<p>사이트에서 사용할 별명 : <form:input path="nikName" name="nikName" /></p>
			<p>아기생일 : <form:input path="babyBirthDay" name="babyBirthDay" type="date" /></p>
			<p>통신사 : <form:select path="telecom" name="telecom">
				<form:option value="skt">SKT</form:option>
				<form:option value="kt">KT</form:option>
				<form:option value="lgu+">LG U+</form:option>
				<form:option value="알뜰">알뜰폰</form:option>
			</form:select></p>
			<p>전화번호 : <form:input type="tel" path="phone" name="phone" minlength="11" maxlenght="11" id="phoneNumber" /></p>
			<p>
				<input type="submit" value="회원가입" id="submitbtn">
			</p>
		</form:form>
	</div>
</body>
<script type="text/javascript">
	// 전화번호 자릿수 필터
	let phoneNumber = document.querySelector("#phoneNumber");
	
	phoneNumber.addEventListener("input", function(){
		if(this.value.length > 11)
			{
				console.log("전화번호 입력 값 출력 : "+phoneNumber);
				this.value = this.value.slice(0, 11);
			}
	});
</script>
<script type="text/javascript">
	// 	아이디 중복검사
	let isDupl = document.querySelector("#checkDupl");
	console.log(isDupl);
	let isCheck = document.querySelector("#idCheck").value;
	
	isDupl.addEventListener("click", duplconfirm);
	
	function duplconfirm(e)
	{
		e.preventDefault();
		let userId = document.querySelector("#userId").value;
		let userIdtoJsonify = {"userId" : userId};
		console.log("userIdtoJsonify : "+userIdtoJsonify);
		$.ajax({
	        url: "/ourProject/isDuplicate",
	        type: "POST",
	        contentType: "application/json",
	        data: JSON.stringify(userIdtoJsonify),
	        dataType: "json",
	        success: function(response) {
	        	console.log("response : " + response.isDuplicate);
	            if (response.isDuplicate == "true") 
	            {
	                alert("중복 ID가 있습니다.");
	            }
	            else 
	            {
	                alert("사용 가능한 ID입니다.");
	                isCheck = 'true';
	            }
	        },
	        error: function(error) {
	            console.error("에러발생:", error);
	        }
	    });
	}
</script>

<script type="text/javascript">
	// 	회원가입 성공 안내
	let signInForm = document.querySelector("#signInForm");
	let submitbtn = document.querySelector("#submitbtn");
	console.log(submitbtn);
	
	submitbtn.addEventListener("click", subFunc);
	
	function subFunc(e)
	{
		e.preventDefault();
		if(isCheck=='false')
		{
			alert("id 중복검사 하시기 바랍니다.");
			return false;
		}
		
		alert("회원가입 성공했습니다.")
		signInForm.submit();
	}
</script>
</html>
