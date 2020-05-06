<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>VEXOM-Login</title>
    <link rel="shortcut icon" href="/IMG/logo.png">

    <link rel="shortcut icon" href="" type="image/x-icon">

    <link rel="stylesheet" href="/CSS/style.css">
</head>
<body>
    <div class="login-page">
        <div class="login">
            <form method="POST" action="/process_login" class="login__form">
                <div class="mb-5">
                    <h2 class="heading-form">
                        LogIn
                    </h2>
                </div>
                <div class="form__group">
                    <input type="text" name="username" id="username" placeholder="Username" class="form__input">
                </div>
                <div class="form__group mb-5">
                    <input type="password" name="password" id="password" placeholder="Password" class="form__input">
                </div>
                <div class="form__group">
                    <button class="btn-submit" type="submit">Login</button>
                </div>
                <input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
            </form>
        </div>
    </div>
</body>
</html>