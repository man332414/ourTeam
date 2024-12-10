<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>출산 정보 모아보기</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css"> <!-- Bootstrap CSS -->
</head>
<body>
    <header class="bg-light py-3">
        <div class="container text-center">
            <h1>출산 정보 모아보기</h1>
            <nav class="nav justify-content-center">
                <a class="nav-link" href="#home">홈</a>
                <a class="nav-link" href="emergencys">응급실 관리</a>
                <a class="nav-link" href="products">출산용품 관리</a>
                <a class="nav-link" href="diarys">성장일기</a>
                <a class="nav-link" href="#community">커뮤니티</a>
                <a class="nav-link" href="#profile">내 정보</a>
            </nav>
        </div>
    </header>

    <main class="container mt-4">
        <section id="welcome" class="text-center mb-4">
            <h2>환영합니다!</h2>
            <p>출산과 임신에 대한 다양한 정보를 제공하여 지원받을 수 있도록 돕습니다.</p>
        </section>

        <section id="features" class="mb-4">
            <h2 class="text-center">주요 기능</h2>
            <div class="row text-center">
                <div class="col-md-4">
                    <button class="btn btn-primary btn-lg" onclick="location.href='emergencys'">응급실 찾기</button>
                </div>
                <div class="col-md-4">
                    <button class="btn btn-primary btn-lg" onclick="location.href='products'">출산용품 관리</button>
                </div>
                <div class="col-md-4">
                    <button class="btn btn-primary btn-lg" onclick="location.href='diarys'">성장일기 작성</button>
                </div>
            </div>
            <div class="row text-center mt-3">
                <div class="col-md-4">
                    <button class="btn btn-primary btn-lg" onclick="location.href='#schedule'">일정 관리</button>
                </div>
                <div class="col-md-4">
                    <button class="btn btn-primary btn-lg" onclick="location.href='#consultation'">상담 요청</button>
                </div>
            </div>
        </section>

        <section id="announcements" class="mb-4">
            <h2 class="text-center">공지사항</h2>
            <ul class="list-group">
                <li class="list-group-item">다음 주에 건강 세미나가 열립니다!</li>
                <li class="list-group-item">임산부를 위한 무료 상담 서비스 시작!</li>
            </ul>
        </section>

        <section id="recommended-content" class="mb-4">
            <h2 class="text-center">추천 콘텐츠</h2>
            <ul class="list-group">
                <li class="list-group-item"><a href="#blog1">임신 초기 건강 관리</a></li>
                <li class="list-group-item"><a href="#blog2">영양 가이드</a></li>
                <li class="list-group-item"><a href="#blog3">운동과 스트레스 관리</a></li>
            </ul>
        </section>
    </main>

    <footer class="bg-light text-center py-3">
        <p>연락처: info@example.com</p>
        <p><a href="#terms">이용 약관</a> | <a href="#privacy">개인정보 처리방침</a></p>
    </footer>

    <script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.0.6/dist/umd/popper.min.js"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script> <!-- Bootstrap JS -->
</body>
</html>