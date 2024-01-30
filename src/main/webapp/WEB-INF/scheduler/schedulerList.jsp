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

    <!-- Google Web Fonts -->
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Open+Sans:wght@400;600&family=Playball&display=swap" rel="stylesheet">

    <!-- Icon Font Stylesheet -->
    <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.15.4/css/all.css"/>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.4.1/font/bootstrap-icons.css" rel="stylesheet">

    <!-- Libraries Stylesheet -->
    <link href="lib/animate/animate.min.css" rel="stylesheet">
    <link href="lib/lightbox/css/lightbox.min.css" rel="stylesheet">
    <link href="lib/owlcarousel/owl.carousel.min.css" rel="stylesheet">

    <!-- Customized Bootstrap Stylesheet -->
    <link href="css/bootstrap.min.css" rel="stylesheet">

    <!-- Template Stylesheet -->
    <link href="css/style.css" rel="stylesheet">

    <script src="https://code.jquery.com/jquery-3.6.0.js"></script>
    <script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
    <script>
        $( function() {
            $( "#datepicker" ).datepicker({ minDate: 0});
        } );
    </script>
    <title>scheduler</title>
    <link rel="stylesheet" href="/schedulerCss.css"/>
</head>
<body>

<!--일정추가 모달-->
<div id="my_modal">
    <p>일정추가</p>
    <form method="post" action="insert">
        <div>
            <p>Date: <input type="text" id="datepicker" name="fullDate" value="날짜선택" readonly></p>
        </div>
        <div>
            시작 : <input type="time" name="scheduleStartTime" min="00:00" max="23:59">
            종료 : <input type="time" name="scheduleEndTime" min="" max="23:59">
        </div>

        <div>
            <input type="text" name="text" placeholder="일정을 입력해 주세요">
        </div>
        <input type="submit" value="작성">
        <a class="modal_close_btn">닫기</a>
    </form>
</div>
<!--일정추가 모달끝-->

<!--일정수정 모달-->
<div id="editModal">
    <p>일정수정</p>
    <form method="post" action="update">
        <div class="modalContent">
        </div>
        <input type="submit" value="수정">
        <a class="modal_close_btn">닫기</a>
    </form>
</div>
<!--일정수정 모달끝-->


<div>
    <table class="table">
        <tr class="table-active">
            <td><input type="button" value="<" onclick="location.href='/scheduler/schedulerList?chgMonth=${dateDto.chgMonth-1}'"></td>
            <td>이전달</td>
            <td><c:out value="${dateDto.year}"></c:out>년</td>
            <td><c:out value="${dateDto.month}"></c:out>월</td>
            <td>다음달</td>
            <td><input type="button" value=">" onclick="location.href='/scheduler/schedulerList?chgMonth=${dateDto.chgMonth+1}'"></td>
        </tr>
    </table>
</div>

<div class="container mt-3">
    <table class="table table-bordered" id="scheduler">
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
            <c:forEach var="firstWeekBoxNo" begin="1" end="7">
                <c:choose>
                    <c:when test="${firstWeekBoxNo==dateDto.firstDay}">
                        <td id="dateBox">
                            <c:out value="1"></c:out>
                            <c:set var="date" value="1"></c:set>
                            <c:if test="${list.size() > 0}">
                                <c:forEach var="row" items="${list}">
                                    <c:if test="${dateDto.year == row.scheduleYear and dateDto.month == row.scheduleMonth and row.scheduleDate == 1}">
                                        <form method="post" action="/scheduler/delete">
                                            <input type="hidden" value="${row.scheduleNo}" id="scheduleNo" name="scheduleNo">
                                            <input type="submit" class="delBtn" value="X">
                                        </form>
                                        <input type="button" class="editBtn" name="editBtn" value="수정" onclick="editTarget(${row.scheduleNo})">
                                        <p>
                                            <c:out value="${row.scheduleStartTime}"></c:out>
                                            ~
                                            <c:out value="${row.scheduleEndTime}"></c:out>

                                            <c:out value="${row.text}"></c:out>
                                        </p>
                                        <input type="hidden" id="scheduleDate${row.scheduleNo}" value="${row.scheduleDate}">
                                        <input type="hidden" id="scheduleStartTime${row.scheduleNo}" value="${row.scheduleStartTime}">
                                        <input type="hidden" id="scheduleEndTime${row.scheduleNo}" value="${row.scheduleEndTime}">
                                        <input type="hidden" id="text${row.scheduleNo}" value="${row.text}">
                                    </c:if>
                                </c:forEach>
                            </c:if>
                        </td>
                    </c:when>

                    <%--첫째주에서 1일이 아닌 경우의 날짜출력--%>
                    <c:when test="${firstWeekBoxNo!=dateDto.firstDay}">
                        <%--1일 이전 공란출력--%>
                        <c:if test="${firstWeekBoxNo < dateDto.firstDay}">
                            <td id="dateBox"></td>
                        </c:if>
                        <%--1일 이후 날짜출력--%>
                        <c:if test="${firstWeekBoxNo > dateDto.firstDay}">
                            <c:set var="firstWeekDate" value="${firstWeekBoxNo-dateDto.firstDay+1}"></c:set>
                            <td id="dateBox">
                                <c:out value="${firstWeekDate}"></c:out>
                                <c:if test="${list.size() > 0}">
                                    <c:forEach var="row" items="${list}">
                                        <c:if test="${dateDto.year == row.scheduleYear and dateDto.month == row.scheduleMonth and row.scheduleDate == firstWeekDate}">
                                            <form method="post" action="/scheduler/delete">
                                                <input type="hidden" value="${row.scheduleNo}" name="scheduleNo">
                                                <input type="submit" class="delBtn" value="X">
                                            </form>
                                            <input type="button" class="editBtn" name="editBtn" value="수정" onclick="editTarget(${row.scheduleNo})">
                                            <p>
                                                <c:out value="${row.scheduleStartTime}"></c:out>
                                                ~
                                                <c:out value="${row.scheduleEndTime}"></c:out>

                                                <c:out value="${row.text}"></c:out>
                                            </p>
                                            <input type="hidden" id="scheduleDate${row.scheduleNo}" value="${row.scheduleDate}">
                                            <input type="hidden" id="scheduleStartTime${row.scheduleNo}" value="${row.scheduleStartTime}">
                                            <input type="hidden" id="scheduleEndTime${row.scheduleNo}" value="${row.scheduleEndTime}">
                                            <input type="hidden" id="text${row.scheduleNo}" value="${row.text}">
                                        </c:if>
                                    </c:forEach>
                                </c:if>
                            </td>

                        </c:if>
                    </c:when>
                </c:choose>
            </c:forEach>
        </tr>
        <!----------첫째주영역끝------------>

        <!----------나머지주영역시작------------>
        <c:forEach var="weekNo" begin="0" end="3">
            <tr>
                <c:forEach var="boxNo" begin="1" end="7">
                    <c:set var="date" value="${firstWeekDate + boxNo + weekNo*7}"></c:set>
                    <c:if test="${date <= dateDto.lastDate}">
                        <td id="dateBox">
                            <c:out value="${date}"></c:out>
                        <c:if test="${list.size() > 0}">
                            <c:forEach var="row" items="${list}">
                                <c:if test="${dateDto.year == row.scheduleYear and dateDto.month == row.scheduleMonth and row.scheduleDate == date}">
                                    <form method="post" action="/scheduler/delete">
                                        <input type="hidden" value="${row.scheduleNo}" name="scheduleNo">
                                        <input type="submit" class="delBtn" value="X">
                                    </form>
                                    <input type="button" class="editBtn" name="editBtn" value="수정" onclick="editTarget(${row.scheduleNo})">
                                    <p>
                                        <c:out value="${row.scheduleStartTime}"></c:out>
                                        ~
                                        <c:out value="${row.scheduleEndTime}"></c:out>

                                        <c:out value="${row.text}"></c:out>
                                    </p>
                                    <input type="hidden" id="scheduleDate${row.scheduleNo}" value="${row.scheduleDate}">
                                    <input type="hidden" id="scheduleStartTime${row.scheduleNo}" value="${row.scheduleStartTime}">
                                    <input type="hidden" id="scheduleEndTime${row.scheduleNo}" value="${row.scheduleEndTime}">
                                    <input type="hidden" id="text${row.scheduleNo}" value="${row.text}">
                                </c:if>
                            </c:forEach>
                        </c:if>
                        </td>
                    </c:if>
                    <c:if test="${date > dateDto.lastDate}">
                        <td id="dateBox"></td>
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
    <input type="hidden" value="false" id="delFlag" name="delFlag">
    <button onclick="showDelBtn()">일정삭제</button>
    <input type="hidden" value="false" id="editFlag" name="editFlag">
    <button onclick="showEditBtn()">일정수정</button>
    <button onclick="location.href='/scheduler/schedulerList?chgMonth=0'">현재월로</button>
</div>

<script type="text/javascript" src="/schedulerJS.js"></script>

</body>
</html>