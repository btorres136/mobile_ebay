import $ from 'jquery';
$(document).ready(() => {


    /**
     * Password Validation
     */
    const $password = $("#SignUppassword #password");
    const $message = $("#SignUppassword #passworderror");
    $password.on("input", () => {
        const password = $password.val();
        if(password.length < 8){
            $message.removeClass("accepted").addClass("rejected");
            $message.text("Password must have at least 8 characters");
        }else{
            $message.removeClass("rejected").addClass("accepted");
            $message.text("Good Password");
        }
    });


    /**
     * Unique ID validation
     */
    const uid = document.querySelector("#SignUpuid #uid");
    $("#SignUpuid #uid").on("input", () => {
        var $message = $("#SignUpuid #uiderror");
        if(uid.value != "" && uid.value.length >= 6 && !/\s/.test(uid.value) && uid.value.length < 11 && !/[`!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?~]/.test(uid.value)){
            fetch("http://localhost:8080/mobile/api/CheckUsername?uid="+uid.value, {
                method: 'POST',
                headers:{}
            }).then(data => {
                return data.json();
            }).then(info => {
                if(info){
                    $message.removeClass("rejected").addClass("accepted");
                    $message.text('Username is available');
                }else{
                    $message.removeClass("accepted").addClass("rejected");
                    $message.text('Sorry, username is not available');
                }
            })
        }else{
            $message.removeClass("accepted").addClass("rejected");
            $message.text('UID must not contain white spaces or be empty, must have at least 6 characters and less than 11. Can`t contain special characters');
        }
    });
});

