function goToEditProfilePage() {
    location.href = "/user/editProfile"; // 위치 지정
}

function goToSearchBookPage() {
    if (!(confirm("도서검색을 하시겠습니까?"))) {
        return false;
    }
    location.href = "/book/bookSearchPage";
}

function logout() {
    if (!(confirm("로그아웃 하시겠습니까?"))) {
        return false;
    }
    location.href = "/user/logoutPage";// 위치 지정
}

function requestReturn() {
    if (!(confirm("반납요청을 하시겠습니까?"))) {
        return false;
    }
    location.href = "/book/waitingForReturn";
}