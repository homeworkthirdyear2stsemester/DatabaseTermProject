function gotoBookRegister() {
    if (!(confirm("책 등록 페이지로 이동하시겠습니까?"))) {
        return false;
    }
    location.href = "/book/bookRegisterPage";// 위치 지정
}

function gotoBookMangement() {
    if (!(confirm("책 관리 페이지로 이동하시겠습니까?"))) {
        return false;
    }
    location.href = "/book/bookMangementPage";// 위치 지정
}

function logout() {
    if (!(confirm("로그아웃 하시겠습니까?"))) {
        return false;
    }
    location.href = "/user/logoutPage";// 위치 지정
}

function authorizeReturn() {
    if (!(confirm("책 반납 승인 대기목록을 조회하시겠습니까?"))) {
        return false;
    }
    location.href = "/book/authorizeReturn";// 위치 지정
}

function gotoTopTenPage() {
    if (!(confirm("top 10 목록을 조회 하시겠습니까?"))) {
        return false;
    }
    location.href = "/book/topTenPage";
}