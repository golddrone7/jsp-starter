<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

    <!-- 1부터 3이하 step은 증감  -->
    <!-- 자바코드를 최대한 줄이기 위해 나온 태그 -->
    <!-- 반복문 -->
    <!-- 게시판 페이징 기능을 많이 씀 -->
    <c:forEach var="i" begin="1" end="3" step="1"> 
        <h1>hello!!! ${i}</h1>
    </c:forEach>

    <!-- 변수 만들기 -->
    <c:set var="age" value="10" />

    <!-- 조건문 -->
    <c:if test="${age > 19}">
        <h2>성인입니다.</h2>
    </c:if>
    <c:if test="${age <= 19}">
        <h2>미성년자입니다.</h2>
    </c:if>


</body>
</html>