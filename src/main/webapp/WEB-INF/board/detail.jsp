<%--
  Created by IntelliJ IDEA.
  User: suminlee
  Date: 23. 11. 20.
  Time: 오전 10:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>detail</title>
</head>
<body>

<div class="container mt-3">
    <h2>Board Detail</h2>
    <table class="table table-bordered">
        <tbody>
        <tr>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
            <td>내용</td>
        </tr>
        <tr>
            <td>${boardVo.title}</td>
            <td>${boardVo.regId}</td>
            <td>${boardVo.regDate}</td>
            <td>${boardVo.contents}</td>
        </tr>
        </tbody>
    </table>
</div>

<div>
    <input type="button" value="목록으로" onclick="location.href='/board/boardList'">
    <input type="button" value="삭제" onclick="location.href='delete?boardNo=${boardVo.boardNo}'">
    <input type="button" value="수정" onclick="location.href='updateForm?boardNo=${boardVo.boardNo}'">


</div>
</body>
</html>
