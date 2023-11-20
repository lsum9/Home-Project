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
    <h2>Bordered Table</h2>
    <p>The .table-bordered class adds borders on all sides of the table and the cells:</p>
    <table class="table table-bordered">
        <tbody>
        <tr>
            <td>제목</td>
            <td>작성자</td>
            <td>작성일</td>
            <td>내용</td>
        </tr>
        <tr>
            <td>${title}</td>
            <td>${reg_id}</td>
            <td>${reg_date}</td>
            <td>${contents}</td>
        </tr>

        </tbody>
    </table>
</div>
</body>
</html>
