<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 수정</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
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
    <div class="container d-grid justify-content-center" style="padding:140px 0 140px 0;">
		<div class="pb-4">	
			<h1>회원정보수정</h1>
		</div>
		<div>
			<table class="table">
				<form:form action="updateMember" modelAttribute="member" method="post" class="form">
					<tr>
						<td>아이디 : </td><td><input id="userId" name="userId" value="${member.userId}" class="form-control-plaintext" type="text" style="display: inline;width: auto;"></td>
					</tr>
					<tr>
						<td>비밀번호 : </td><td><form:password path="password" name="password" id="password" minlength="5" /></td>
					</tr>
					<tr>
						<td>비밀번호 확인 :	</td><td><input type="password" id="passwordconfirm" />
								<input type="hidden" id="pwCheck" value="false" />
								<span id="pwConfirmInfo" style="display:none; color:red;">비밀번호가 일치하지 않습니다.</span>
						</td>
					</tr>
					<tr>
						<td>E-mail : </td><td><form:input path="email" value="${member.getEmail()}" /></td>
					</tr>
					<tr>
						<td>이름 : </td><td><form:input path="name" value="${member.getName()}" /></td>
					</tr>
					<tr>
						<td>사이트에서 사용할 별명 : </td><td><form:input path="nikName" value="${member.getNikName()}" /></td>
					</tr>
					<tr>
						<td>아기생일 : </td><td><form:input path="babyBirthDay" value="${member.getBabyBirthDay()}" /></td>
					</tr>
					<tr>
						<td>통신사 : </td><td><form:select path="telecom" >
							<form:option value="skt">SKT</form:option>
							<form:option value="kt">KT</form:option>
							<form:option value="lgu+">LG U+</form:option>
							<form:option value="알뜰폰">알뜰폰</form:option>
						</form:select></td>
					</tr>
					<tr>
						<td>전화번호 : </td><td><form:input type="tel" path="phone" value="${member.getPhone()}" /></td>
					</tr>
					<tr>
						<td colspan="2" style="text-align:right;border-style: none;">
							<br>
							<input type="submit" value="수정" class="btn btn-primary">
							<button id="delbtn" class="btn btn-danger">삭제 ${updateSuccess}</button>
						</td>
					</tr>
				</form:form>
			</table>
		</div>
	</div>	
	<%@ include file="footer.jsp" %>
</body>
<script type="text/javascript">
	document.addEventListener("DOMContentLoaded", updateStatus);
	
	function updateStatus()
	{
// 		console.log("updateStatus() 입장" + ${updateStatus});
		if(${updateStatus == "success"})
			{
				alert("업데이트 완료했습니다.");
			}
	}
</script>
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
				e.preventDefault();
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
