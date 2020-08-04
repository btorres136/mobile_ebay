<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VEXOM-SignUp</title>
    <link rel="shortcut icon" href="/IMG/logo.png">

    <link rel="shortcut icon" href="" type="image/x-icon">

    <link rel="stylesheet" href="/CSS/style.css">
</head>
<body>
    <div class="login-page">
        <div class="login">
            <form method="POST" name="SignUp" action="/SignUp" class="login__form">
                <div class="mb-5">
                    <h2 class="heading-form">
                        LogIn
                    </h2>
                </div>
                <div class="form-group" id="SignUpusername">
                    <input type="text" name="username" id="username" placeholder="Name" class="form-control">
                    <label id="usernameerror"></label>
                </div>
                <div class="form-group" id="SignUplastname">
                    <input type="text" name="lastname" id="lastname" placeholder="Lastname" class="form-control">
                    <label id="lastnameerror"></label>
                </div>
                <div class="form-group" id="SignUpuid">
                    <input type="text" name="uid" id="uid" placeholder="Unique ID" class="form-control">
                    <label id="uiderror"></label>
                </div>
                <div class="form-group" id="SignUpemail">
                    <input type="text" name="email" id="email" placeholder="email" class="form-control">
                    <label id="emailerror"></label>
                </div>
                <div class="form-group mb-5" id="SignUppassword">
                    <input type="password" name="password" id="password" placeholder="Password" class="form-control">
                    <label id="passworderror"></label>
                </div>
                <div class="form-group">
                    <button class="btn-submit" type="submit" id="SignUpButton">SignUp</button>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
    </div>
</body>
<script type="application/javascript" src="/JS/bundle.js"></script>
</html>