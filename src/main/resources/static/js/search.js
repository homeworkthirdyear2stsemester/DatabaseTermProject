function goToUserMainPage() {
    location.href = "/user/mainUserPage";
}

function goToSearhPage() {
    location.href = "/book/bookSearchPage";
}

function borrowBookButton(event){
    if (!(confirm('대출을 하시겠습니까?'))){
        return false
    }
}