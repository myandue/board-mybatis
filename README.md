# board-mybatis


<br>

## 목차
<ul>
  <li>프로젝트 소개</li>
  <li>기술 스택</li>
  <li>구현 기능</li>
  <li>진행사항</li>
  <li>배운 점 & 아쉬운 점</li>
 </ul>

<br>

## 프로젝트 소개

<p align="justify">
기본적인 게시판 구현, 마이바티스 활용, 역할과 구현 분리
</p>

<br>

## 기술 스택

<img src="https://img.shields.io/badge/java-007396?style=for-the-badge&logo=java&logoColor=white"> 
<img src="https://img.shields.io/badge/spring-6DB33F?style=for-the-badge&logo=spring&logoColor=white"> 
<img src="https://img.shields.io/badge/mariaDB-003545?style=for-the-badge&logo=mariaDB&logoColor=white">

<br>

## 구현 기능

#### user 로그인 구현

#### social 로그인 구현

#### user 게시글 리스트 확인

#### 게시글 파일 업로드

#### 게시글 view

#### 댓글 기능

<br>

## 진행사항

<h3>nav</h3>
<ul>
<li>홈 게시글작성 내프로필 로그아웃</li>
<li>홈 게시글작성(->로그인페이지로 넘김) 회원가입 로그인</li>
</ul>

<h3>home</h3>
<ul>
<li>'/' : 게시글 리스트(게시글 타이틀, 작성자(profie링크), 조회수), 게시글 검색, 페이징처리</li>
<li>'/join' : 회원가입 -> 이름/추후 구현/이름, userId, pw, pw 확인</li>
<li>'/login' : 로그인 -> 이름/추후 구현/userId, pw</li>
</ul>

<h3>article</h3>
<small>필드 : id, 타이틀, 내용, 파일이름, 파일경로, 작성자, 조회수(추후 추가)</small>
<ul>
<li>'/article/upload : 게시글 작성</li>
<li>'/article/{id}' : 게시글 view(게시글 타이틀, 내용, 파일, 조회수, 작성자(profile링크), 댓글(댓글 내용, 작성자(profile링크))</li>
<li>'/article/{id}/edit' : 해당 게시글 수정 -> 작성자만 접근 가능</li>
<li>'/article/{id}/delete' : 해당 게시글 삭제 -> 작성자만 접근 가능, 경고 문구</li>
</ul>

<h3>user</h3>
<small>필드 : id, 이름, 게시글리스트, 패스워드(추후 추가), 프로필사진(추후 추가)</small>
<ul>
<li>'/user/{id}' : user profile -> 이름, 게시글리스트, 프로필사진 / 본인일시 수정, 삭제</li>
<li>'/user/{id}/edit' : user profile 수정 // pw 수정 창 별도 생성 
<li>'/user/{id}/delete' : user 삭제 // edit 페이지에 존재
</ul>


<br>

## 배운 점 & 아쉬운 점

<p align="justify">

</p>

<br>

## 라이센스

MIT &copy; [myandue](mailto:hyunju1041@naver.com)
