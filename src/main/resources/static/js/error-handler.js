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

function returnBookErrorHandler() {
    alert("return trascation is failed");
    location.href = "/book/authorizeReturn";
}

function requestReturnError() {
    alert("return request is failed please do again later");
    location.href = "/user/mainUserPage";
}