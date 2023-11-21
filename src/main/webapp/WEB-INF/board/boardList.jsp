<%--
  Created by IntelliJ IDEA.
  User: 이수민
  Date: 2023-10-07
  Time: 오전 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">
    <c:if test="${list == null}">
        <table class="table table-hover">
            <thead>
            <tr>
                <th>번호</th>
                <th>제목</th>
                <th>작성자</th>
                <th>작성일</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>게시글이 없습니다.</td>
            </tr>
            </tbody>
        </table>

    </c:if>
    <c:if test="${list != null}">
  <%--  <div><c:out value="${rowCnt}"></c:out></div>--%>
    <table class="table table-hover">
        <thead>
        <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>작성일</th>
        </tr>
        </thead>

        <tbody>
        <c:forEach var="row" items="${list}">
            <tr>
                <td><c:out value="${row.boardNo}"></c:out></td>
                <td><a href="detail/${row.boardNo}">${row.title}</a></td>
                <td><c:out value="${row.regId}"></c:out></td>
                <td><c:out value="${row.regDate}"></c:out></td>
            </tr>

        </c:forEach>
        </tbody>
    </table>

        <%--<div>
            <ul class="pagination">
                <li class="page-item"><a class="page-link" href="boardList?startPageNum=${pagingVo.startPageNum-pagingVo.pageNumCnt}">이전</a></li>
                <c:forEach var="i" begin="${pagingVo.startPageNum}" end="${pagingVo.endPageNum}" >
                    <li class="page-item"><a class="page-link" href="boardList?nowPage=${i}"> ${i} </a></li>
                </c:forEach>
                <li class="page-item"><a class="page-link" href="boardList?startPageNum=${pagingVo.startPageNum+pagingVo.pageNumCnt}">다음</a></li>
            </ul>

        </div>--%>
    </c:if>
</div>

<div>
    <input type="button" value="글작성" onclick="location.href='writeForm'">
</div>
</body>
</html>
