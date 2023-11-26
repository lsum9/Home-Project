<%--
  Created by IntelliJ IDEA.
  User: suminlee
  Date: 23. 11. 27.
  Time: 오후 1:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>scheduler</title>
</head>
<body>
<div>
    <table class="table">
        <tr class="table-active">
            <td><input type="button" value="<"></td>
            <td>이전달</td>
            <td><c:out value="${year}"></c:out>년</td>
            <td><c:out value="${month}"></c:out>월</td>

            <td>다음달</td>
            <td><input type="button" value=">"></td>
        </tr>
    </table>

</div>
<div class="container mt-3">
    <table class="table table-bordered">
        <thead>
        <tr>
            <th>일</th>
            <th>월</th>
            <th>화</th>
            <th>수</th>
            <th>목</th>
            <th>금</th>
            <th>토</th>
        </tr>
        </thead>
        <tbody>
        <!----------첫째주영역시작------------>
        <tr>
            <c:forEach var="i" begin="1" end="7">
                <c:choose>
                    <c:when test="${i==firstDay}">
                        <td>
                            <c:out value="1"></c:out>
                            <br>

                        </td>
                    </c:when>

                    <c:when test="${i!=firstDay}">
                        <c:if test="${i < firstDay}">
                        <td></td>
                        </c:if>
                        <c:if test="${i > firstDay}">
                        <td><c:out value="${i-firstDay+1}"></c:out></td>
                            <c:set var="n" value="${i-firstDay+1}"></c:set>
                        </c:if>
                    </c:when>
                </c:choose>
            </c:forEach>
        </tr>
        <!----------첫째주영역끝------------>

        <!----------나머지주영역시작------------>
    <c:forEach var="b" begin="0" end="3">
        <tr>
            <c:forEach var="a" begin="1" end="7">
                <c:if test="${n+a+b*7 <= lastDate}">
                    <td><c:out value="${n+a+b*7}"></c:out></td>
                </c:if>
                <c:if test="${n+a+b*7 > lastDate}">
                    <td></td>
                </c:if>
            </c:forEach>
        </tr>
    </c:forEach>
        <!----------나머지주영역끝------------>
        </tbody>
    </table>
</div>
<div>
    <input type="button" value="일정작성">
</div>


</body>
</html>
