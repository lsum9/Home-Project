<%--
  Created by IntelliJ IDEA.
  User: 이수민
  Date: 2023-11-18
  Time: 오전 10:19
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
    <title>writeForm</title>
</head>
<body>
<form>
    <div class="mb-3">
        <label for="exampleInputEmail1" class="form-label">제목</label>
        <input type="email" class="form-control" id="exampleInputEmail1" aria-describedby="emailHelp">
        <div id="emailHelp" class="form-text">We'll never share your email with anyone else.</div>
    </div>
    <div class="mb-3">
        <label for="exampleInputPassword1" class="form-label">내용</label>
        <input type="password" class="form-control" id="exampleInputPassword1">
    </div>
    <button type="submit" class="btn btn-primary">Submit</button>
</form>
</body>
</html>
