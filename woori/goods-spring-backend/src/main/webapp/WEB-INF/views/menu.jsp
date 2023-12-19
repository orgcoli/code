<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%--부트스트랩의 효과는 클래스명이 결정한다. 임의로 클래스명 변경X--%>
<%--include를 이용해서 사용하는 페이지는 내용만 존재(body내에 표현)--%>
<%--navbar(메뉴바) navbar-expand-sm(크기) bg-dark navbar-dark(메뉴 배경색)--%>

<nav class="navbar navbar-expand-sm bg-dark navbar-dark">
    <%--container(작업영역) fluid(가로형)--%>
    <div class="container-fluid">
        <%--로고 작업--%>
        <a class="navbar-brand" href="/">인싸</a>   <%--img src 그림으로 로고가능--%>
        <%--반응형 웹처리를 위해서 스마트폰, 태블릿에 헤상도에 3선버튼 메뉴--%>
        <%--data-bs-toggle 펼침효과, data-bs-target 클릭시 보일 클래스명(id명과 일치)--%>
        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#collapsibleNavbar">
            <span class="navbar-toggler-icon"></span>
        </button>
        <div class="collapse navbar-collapse" id="collapsibleNavbar">
            <ul class="navbar-nav"> <%--메뉴항목은 순서없는 목록으로 작업(ul)필요 navbar-nav(메뉴바의 메뉴구성)--%>
                <li class="nav-item dropdown">   <%--하나의 항목이 메뉴항목 1개, 관리자가 상품을 관리--%>
                    <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown">상품관리</a>
                    <ul class="dropdown-menu">
                        <li><a class="dropdown-item" href="/goods-insert">상품등록</a></li>
                        <li><a class="dropdown-item" href="/goods-list2">상품목록</a></li>
                    </ul>   <%--#에 해당하는 맵핑을 지정, ppt, Controller를 참고--%>
                </li>
                <li class="nav-item">   <%--이용자에게 제공할 목록--%>
                    <a class="nav-link" href="/goods-list">최신상품</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
