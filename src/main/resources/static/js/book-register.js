function gotoMainPage() {
    if (!(confirm("도서 등록을 마치겠습니까?"))) {
        return false;
    }
    location.href = "/user/mainAdminPage";
}