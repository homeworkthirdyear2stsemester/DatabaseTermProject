function deleteErrorHandelr() {
    alert("delete fail");
    location.href = "/user/login";
}

function loginErrorHandelr() {
    alert("please login first");
    location.href = "/user/login";
}

function registerErrorHandelr() {
    alert("register fail");
    location.href = "/book/bookManagementPage";
}

function deleteBookErrorHandelr() {
    alert("delete fail please do again later");
    location.href = "/book/bookMangementPage";
}

function deleteReservationErrorHander() {
    alert("wrong reservation data");
    location.href = "/user/mainUserPage";
}