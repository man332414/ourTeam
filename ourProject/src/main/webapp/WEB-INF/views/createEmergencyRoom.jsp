<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="jakarta.servlet.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<html>
<head>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
	<link rel="stylesheet" href="/resources/css/emergency.css">
<title>병원 등록</title>
	<style>
        body{
        	background-color:#fefcf8;
        }
    </style>
</head>
<body>
	<%@ include file="header.jsp"%>

	<div class="container emergency">
		<div class="float-right"></div>
		<form:form modelAttribute="NewRoom"
			action="./add?${_csrf.parameterName}=${_csrf.token}"
			class="form-horizontal">
			<fieldset>
				<legend>${addTitle}</legend>

				<div class="form-group row">
					<label class="col-sm-2 control-label">병원이름</label>
					<form:input path="hosName" class="form-control" size="30" />
					<form:errors path="hosName" class="form-danger" />
				</div>
				<br>
				<div class="form-group row">
					<label class="col-sm-2 control-label">순번</label>
					<form:input path="number" class="form-control" />
					<form:errors path="number" class="form-danger" />
				</div>
				<br>
				<div class="form-group row">
					<label class="col-sm-2 control-label">병원주소</label>
					<form:input path="hosaddr" cols="50" rows="2" class="form-control"
						size="100" />
				</div>
				<br>
				<div class="form-group row">
					<label class="col-sm-2 control-label">이동거리</label>
					<form:input path="distance" class="form-control" />
					<form:errors path="distance" class="text-danger" />
				</div>
				<br>
				<div class="form-group row">
					<label class="col-sm-2 control-label">이동시간</label>
					<form:input path="travelTime" class="form-control" />
				</div>
				<br>

				<div class="form-group row">
					<label class="col-sm-2 control-label">응급실병상수</label>
					<form:input path="numOfBad" class="form-control" />
				</div>
				<br>
				<div class="form-group">
					<label for="pediatrics" class="col-sm-2 control-label">소아과보유</label>
					<form:checkbox path="pediatrics" id="pediatrics" />
				</div>
				<br>
				<div class="form-group">	
					<label for="obstetricsAndGynecology" class="col-sm-2 control-label">산부인과보유</label>
					<form:checkbox path="obstetricsAndGynecology" id="obstetricsAndGynecology" />
				</div>
				<br>
				<div class="form-group row">
					<div class="col-sm-offset-2 col-sm-10">
						<input type="submit" class="btn btn-primary" value="병원등록" />
					</div>
				</div>
			</fieldset>
		</form:form>
		<hr>
	</div>
</body>
</html>