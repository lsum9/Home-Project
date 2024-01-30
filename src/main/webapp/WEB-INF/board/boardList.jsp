<%--
  Created by IntelliJ IDEA.
  User: 이수민
  Date: 2023-10-07
  Time: 오전 9:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js"></script>
</head>
<body>

<div class="container mt-3">
    <div>
        <form method="get" action="/board/search" >
            <input type="text">
            <input type="submit" value="검색">
        </form>
    </div>
    <div>
    <c:if test="${fn:length(list) == 0}">
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
                <td colspan="4">게시글이 없습니다.</td>
            </tr>
            </tbody>
        </table>

    </c:if>
    <c:if test="${fn:length(list) != 0}">
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
                <td><a href="detail?boardNo=${row.boardNo}">${row.title}</a></td>
                <td><c:out value="${row.regId}"></c:out></td>
                <td><c:out value="${row.regDate}"></c:out></td>
            </tr>

        </c:forEach>
        </tbody>
    </table>
    </div>
        <div>
            <ul class="pagination">
                <c:if test="${pagingVo.nowPage != 1}">
                    <li class="page-item"><a class="page-link" href="boardList?nowPage=1"> << </a></li>
                    <li class="page-item"><a class="page-link" href="boardList?nowPage=${pagingVo.nowPage-1}"> < </a></li>
                </c:if>
                <c:forEach var="i" begin="${pagingVo.startPageNum}" end="${pagingVo.endPageNum}">
                    <c:choose>
                        <c:when test="${pagingVo.nowPage == i}">
                            <li class="page-item active"><a class="page-link" href="boardList?nowPage=${i}"> ${i} </a></li>
                        </c:when>
                        <c:when test="${pagingVo.nowPage != i}">
                            <li class="page-item"><a class="page-link" href="boardList?nowPage=${i}"> ${i} </a></li>
                        </c:when>
                    </c:choose>
                </c:forEach>
                <c:if test="${pagingVo.nowPage != pagingVo.totalPage}">
                    <li class="page-item"><a class="page-link" href="boardList?nowPage=${pagingVo.nowPage+1}"> > </a></li>
                    <li class="page-item"><a class="page-link" href="boardList?nowPage=${pagingVo.totalPage}"> >> </a></li>
                </c:if>
            </ul>

        </div>
    </c:if>
</div>

<div>
    <input type="button" value="글작성" onclick="location.href='writeForm'">
</div>
</body>
</html>
