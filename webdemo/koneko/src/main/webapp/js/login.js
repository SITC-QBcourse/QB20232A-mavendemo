window.onload = function() {
    document.getElementById("mid").addEventListener("blur",validateMid,false) ;
    document.getElementById("password").addEventListener("blur",validatePassword,false) ;
    document.getElementById("memberform").addEventListener("submit",function(event){
        if (!(validateMid() & validatePassword())) {
            event.preventDefault() ;
        }
    },false) ;
}
function validateMid() {
    return validateEmpty("mid") ;
}
function validatePassword() {
    return validateEmpty("password") ;
}