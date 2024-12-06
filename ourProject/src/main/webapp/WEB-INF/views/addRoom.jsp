<%@ page contentType="text/html; charset=utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>

<html>
<head>
<link rel="stylesheet" href="/ourProject/resources/css/bootstrap.min.css" />
<script type="text/javascript" src="./resources/js/validation.js"></script>
<title>병원 등록</title>
</head>
<body>

<div class="container">	
	<div class="float-right" style="padding-right:30px"></div>
	<br><br>
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
		
		<div class="form-group row">
			<label class="col-sm-2 control-label">순번</label>
			<form:input path="number" class="form-control"/>
			<form:errors path="number" class="form-danger"/>
		</div>

		<div class="form-group row">
			<label class="col-sm-2 control-label">병원주소</label>
			<form:input path="hosaddr" cols="50" rows="2" class="form-control" size="100" />
		</div>
					
		<div class="form-group row">
			<label class="col-sm-2 control-label">이동거리</label>
			<form:input path="distance" class="form-control" />
			<form:errors path="distance" class="text-danger" />
		</div>

		<div class="form-group row">
			<label class="col-sm-2 control-label">이동시간</label>
			<form:input path="travelTime" class="form-control" />
		</div>
		
		<div class="form-group row">
			<label class="col-sm-2 control-label">응급실병상수</label>
			<form:input path="numOfBad" class="form-control" />
		</div>
		
		<div class="form-group row">
			<label class="col-sm-2 control-label">소아과보유여부</label>
			<form:checkbox  path="pediatrics" class="form-control" />
		</div>
		
		<div class="form-group row">
			<label class="col-sm-2 control-label">산부인과보유여부</label>
			<form:checkbox  path="obstetricsAndGynecology" class="form-control" />
		</div>

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