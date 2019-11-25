function completeTask() {
    if (!(confirm("반납 리스트 작업을 종료하시겠습니까?"))) {
        return false;
    }
    location.href = "/user/mainAdminPage"
}