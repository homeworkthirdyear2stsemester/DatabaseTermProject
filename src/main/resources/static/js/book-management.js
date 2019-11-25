function gotoMainAdminPage(){
    if (!(confirm("도서 관리를 마치겠습니까?"))) {
        return false;
    }
    location.href = "/user/mainAdminPage";
}