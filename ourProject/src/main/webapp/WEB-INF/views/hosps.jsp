<%@ page session = "false" %>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" import="jakarta.servlet.*"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<head>
    <title>병원 목록</title>
	<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
</head>
<body>
    <h2>병원 목록</h2>
    <table>
        <thead>
            <tr>
                <th>병원 이름</th>
                <th>주소</th>
                <th>소아과 보유 여부</th>
                <th>산부인과 보유 여부</th>
                <th>위도좌표</th>
                <th>경도좌표</th>
            </tr>
        </thead>
        <tbody>
            <c:forEach var="room" items="${emergencylist}">
                <tr>
                    <td>${room.hosName}</td>
                    <td>${room.hosaddr}</td>
                    <td>${room.pediatrics ? '예' : '아니오'}</td>
                    <td>${room.obstetricsAndGynecology ? '예' : '아니오'}</td>
                    <td>${room.latitude}</td>
                    <td>${room.longitude}</td>
                </tr>
            </c:forEach>
        </tbody>
    </table>
</body>
</html>