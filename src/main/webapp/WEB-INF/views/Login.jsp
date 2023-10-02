<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">

<head>
  <meta charset="UTF-8" />
  <meta name="viewport" content="width=device-width, initial-scale=1.0" />
  <title>Login</title>
  <link rel="stylesheet" href="<c:url value="/resources/assets/css/fontawesome-free-6.4.2-web/css/all.min.css" />" />
  <link href="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" />" rel="stylesheet"
    integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous" />
  <link rel="stylesheet" href="<c:url value="/resources/assets/css/main.css" />" />
  <style>
    .form-control-lg {
      width: 100%;
    }
    .form-check-input:checked {
      background-color: #009687;
      border-color: #009687;
    }

    .btn {
      background-color: #009687;
    }
  </style>
</head>

<body>
  <div class="header">
    <div class="container">
      <div class="row">
        <div class="col-lg-12">
          <div class="content-header">
            <div class="logo">
              <a href="#">
                <img src="<c:url value="/resources/assets/img/logo.png" />" alt="" width="40" />
              </a>
            </div>
            <div class="icon-search">
              <span>
                <i class="fa-solid fa-magnifying-glass"></i>
              </span>
            </div>
          </div>
        </div>
      </div>
    </div>
  </div>
  <section class="vh-100">
    <div class="container py-5 h-100">
      <div class="row d-flex align-items-center justify-content-center h-100">
        <div class="col-md-8 col-lg-7 col-xl-6">
          <img src="https://mdbcdn.b-cdn.net/img/Photos/new-templates/bootstrap-login-form/draw2.svg" class="img-fluid"
            alt="Phone image">
        </div>
        <div class="col-md-7 col-lg-5 col-xl-5 offset-xl-1">
          <form>
            <div class="form-outline mb-4">
              <h2>Login to the Vaccine project:</h2>
            </div>

            <div class="form-outline mb-4">
              <label class="form-label" for="form1Example13">Account:</label>
              <input type="text" id="form1Example13" class="form-control form-control-lg" />

            </div>

            <div class="form-outline mb-4">
              <label class="form-label" for="form1Example23">Password:</label>
              <input type="password" id="form1Example23" class="form-control form-control-lg" />

            </div>

            <div class="d-flex justify-content-around align-items-center mb-4">

              <div class="form-check">
                <input class="form-check-input" type="checkbox" value="" id="form1Example3" checked />
                <label class="form-check-label" for="form1Example3"> Remember me </label>
              </div>
              <a href="#!">Register</a>
              <a href="#!">Forgot password?</a>
            </div>

            <button type="submit" class="btn btn-lg btn-block">Sign in</button>
          </form>
        </div>
      </div>
    </div>
  </section>

  <script src="<c:url value="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" />"
    integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL"
    crossorigin="anonymous"></script>
  <script src="<c:url value="/resources/assets/js/main.js"/>"></script>
</body>

</html>