h<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<script src="http://code.jquery.com/jquery-latest.min.js"></script>
<head>
<meta charset="UTF-8">
<title>회원가입</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<script src="https://kit.fontawesome.com/c53a51a6e0.js" crossorigin="anonymous"></script>
	
    <style>
        body {
            background-color: #f8f9fa; /* 배경색 설정 */
        }
    </style>
</head>
<body>
	<%@ include file="header.jsp" %>
	<div class="container d-grid justify-content-center" style="padding:140px 0 80px 0;">
		<div class="pb-4">
			<h1>회원가입</h1>
		</div>
		<table class="table" style="align-content: center;">
			<form:form modelAttribute="member" method="post" id="signInForm">
				<tr>
					<td>아이디 :</td> 
					<td> 
						<form:input path="userId" name="id" id="userId" />
						<button id="checkDupl" class="btn btn-primary">중복검사</button>
						<input type="hidden" id="idCheck" value="false" />
					</td>
				</tr>
				<tr>
					<td>비밀번호 :</td>
					<td><form:password path="password" name="password" id="password" minlength="5" /></td>
				</tr>
				<tr>
					<td>비밀번호 확인 :</td>
					<td>
						<input type="password" id="passwordconfirm" />
						<input type="hidden" id="pwCheck" value="false" />
						<span id="pwConfirmInfo" style="display: inline;color: red;right: 30%;top: 36.2%;" class="position-absolute">비밀번호가 일치하지 않습니다.</span>
					</td>
				</tr>
				<tr>
					<td>E-mail :</td>
					<td><form:input type="email" path="email" name="email" /></td>
				</tr>
				<tr>
					<td>이름 :</td>
					<td><form:input path="name" name="name" /></td>
				</tr>
				<tr>
					<td>사이트에서 사용할 별명 :</td>
					<td><form:input path="nikName" name="nikName" /></td>
				</tr>
				<tr>
					<td>아기생일 :</td>
					<td><form:input path="babyBirthDay" name="babyBirthDay" type="date" /></td>
				</tr>
				<tr>
					<td>통신사 :</td>
					<td>
						<form:select path="telecom" name="telecom">
							<form:option value="skt">SKT</form:option>
							<form:option value="kt">KT</form:option>
							<form:option value="lgu+">LG U+</form:option>
							<form:option value="알뜰">알뜰폰</form:option>
						</form:select>
					</td>
				</tr>
				<tr>
					<td>전화번호 :</td>
					<td><form:input type="tel" path="phone" name="phone" id="phoneNumber" /></td>
				</tr>
			</form:form>
		</table>
		<button class="btn btn-primary" type="submit" id="submitbtn">회원가입</button>
	</div>
	<%@ include file="footer.jsp" %>
</body>
<script type="text/javascript">
	// 전화번호 자릿수 필터
	let phoneNumber = document.querySelector("#phoneNumber");
	
	phoneNumber.addEventListener("input", function(){
		if(this.value.length > 11)
			{
				console.log("전화번호 입력 값 출력 : "+phoneNumber);
				this.value = this.value.slice(0, 13);
			}
	});
</script>
<script type="text/javascript">
	// 	아이디 중복검사
	let isDupl = document.querySelector("#checkDupl");
	console.log(isDupl);
	let isIdCheck = document.querySelector("#idCheck").value;
	
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
	                isIdCheck = 'true';
	            }
	        },
	        error: function(error) {
	            console.error("에러발생:", error);
	        }
	    });
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
<script type="text/javascript">
	// 	회원가입 성공 안내
	let signInForm = document.querySelector("#signInForm");
	let submitbtn = document.querySelector("#submitbtn");
	console.log(submitbtn);
	
	submitbtn.addEventListener("click", subFunc);
	
	function subFunc(e)
	{
		e.preventDefault();
		if(isIdCheck=='false')
		{
			alert("id 중복검사 하시기 바랍니다.");
			return false;
		}
		console.log("isPwCheck : "+ isPwCheck);
		if(isPwCheck=='false')
		{
			alert("비밀번호가 일치하지 않습니다.");
			return false;
		}
		
		alert("회원가입 성공했습니다.")
		signInForm.submit();
	}
</script>
</html>
