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
<form method="post" action="/board/update">
    <input type="hidden" name="boardNo" value="${boardVo.boardNo}">
    <div class="mb-3">
        <label for="title" class="form-label">제목</label>
        <input type="text" class="form-control" name="title" id="title" value="${boardVo.title}">
    </div>
    <div class="mb-3">
        <label for="regId" class="form-label">작성자</label>
        <input type="text" class="form-control" name="regId" id="regId" value="${boardVo.regId}">
    </div>
    <div class="mb-3">
        <label for="contents" class="form-label">내용</label>
        <input type="text" class="form-control" name="contents" id="contents" value="${boardVo.contents}">
    </div>
    <div>

    </div>
    <button type="submit" class="btn btn-primary">수정</button>
</form>
</body>
</html>
