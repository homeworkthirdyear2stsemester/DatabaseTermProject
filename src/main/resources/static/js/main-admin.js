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