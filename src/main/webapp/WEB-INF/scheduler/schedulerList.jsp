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
    <link rel="stylesheet" href="//code.jquery.com/ui/1.13.1/themes/base/jquery-ui.css">
    <link rel="stylesheet" href="/resources/demos/style.css">
    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker();
        } );
    </script>
    <title>scheduler</title>
    <link rel="stylesheet" href="/schedulerCss.css"/>
</head>
<body>
<!--일정추가 모달-->
<div id="my_modal">
    <form method="post" action="insert">
        <div>
            <p>Date: <input type="text" id="datepicker" name="fullDate" value="날짜선택" readonly></p>
        </div>
        <div>
            시작 : <input type="time" name="scheduleStartTime">
            종료 : <input type="time" name="scheduleEndTime">
        </div>
        <div>
            <input type="text" name="text" placeholder="일정을 입력해 주세요">
        </div>
        <input type="submit" value="작성">
        <a class="modal_close_btn">닫기</a>
    </form>

</div>
<div>
    <%--<c:set var="showDate" value="${dateDto.date}">--%>
    <table class="table">
        <tr class="table-active">
            <td><input type="button" value="<" onclick="location.href='scheduler?chgMonth=-1'"></td>
            <td>이전달</td>
            <td><c:out value="${dateDto.year}"></c:out>년</td>
            <td><c:out value="${dateDto.month}"></c:out>월</td>

            <td>다음달</td>
            <td><input type="button" value=">" onclick="location.href='scheduler?chgMonth=1'"></td>
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
                    <c:when test="${i==dateDto.firstDay}">
                        <td>
                            <c:out value="1"></c:out>
                            <br>
                            <table>
                                <tr></tr>
                            </table>
                        </td>
                    </c:when>

                    <c:when test="${i!=dateDto.firstDay}">
                        <c:if test="${i < dateDto.firstDay}">
                        <td></td>
                        </c:if>
                        <c:if test="${i > dateDto.firstDay}">
                        <td><c:out value="${i-dateDto.firstDay+1}"></c:out></td>
                            <c:set var="n" value="${i-dateDto.firstDay+1}"></c:set>
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
                <c:if test="${n+a+b*7 <= dateDto.lastDate}">
                    <td><c:out value="${n+a+b*7}"></c:out></td>
                </c:if>
                <c:if test="${n+a+b*7 > dateDto.lastDate}">
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
    <button id="popup_open_btn">일정작성</button>
</div>

<script type="text/javascript" src="/schedulerJS.js"></script>

</body>
</html>
