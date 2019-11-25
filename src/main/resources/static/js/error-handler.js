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