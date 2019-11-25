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
    if (!(confirm("로그아웃 하기겠습니까?"))) {
        return false;
    }
    location.href = "/user/logoutPage";// 위치 지정
}

function cancealReservation() {
    if (!(confirm('예약을 취소 하시겠습니까?'))) {
        return false
    }
}