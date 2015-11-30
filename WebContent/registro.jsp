<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String msj = request.getParameter("error");
    if (msj == null) {
        msj = "";
    }
    else {
        if (msj.equals("n")) {
            msj = "Código no encontrado.";        
        }
        else {
            msj = "Necesitas un código para ingresar";
        }
    }
%>
<jsp:useBean id="curso" class="caracol.modelo.Curso" scope="request" />
<jsp:useBean id="cx" class="caracol.modelo.Conectar" scope="page" />
<!doctype html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7" lang=""> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8" lang=""> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9" lang=""> <![endif]-->
<!--[if gt IE 8]><!--> <html class="no-js" lang=""> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <!--<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">-->
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <title>Incubadora Caracol</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="icon" href="img/favicon.ico">
    <link rel="apple-touch-icon" href="img/apple-touch-icon.png">
    <link rel="stylesheet" href="css/app.css">
    <script src="js/vendor/modernizr-2.8.3-respond-1.4.2.min.js"></script>
</head>
<body id="top">
    <!--[if lt IE 8]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->
    <section class="not-title">
        <section class="navigation not-fixed">
            <header>
                <div class="header-content">
                    <div class="logo"><a href="index.jsp"><img src="img/logo.png" alt="Sedna logo"></a></div>
                    <div class="header-nav">
                        <nav>
                            <ul class="member-actions">
                                <li><a href="index.jsp#login" class="login btn-white btn-small">Acceder</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="navicon">
                        <a class="nav-toggle" href="#"><span></span></a>
                    </div>
                </div>
            </header>
        </section>

    <section class="sign-up section-padding text-center" id="download">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h1>Registro</h1>
                    <label for="" style="color: red"><%=msj %></label>
                    <form class="signup-form" action="cCodigo" method="POST" role="form">
                        <span class="input input--fumi">
                            <input class="input__field input__field--fumi" type="text" id="codigoR" name="codigo" required />
                            <label class="input__label input__label--fumi" for="codigoR">
                                <i class="fa fa-fw fa-key icon icon--fumi"></i>
                                <span class="input__label-content input__label-content--fumi">Ingresa tu codigo de registro</span>
                            </label>
                        </span>
                        <input type="hidden" name="op" value="ve">
                        <input type="submit" class="btn-fill sign-up-btn" name="register" value="Acceder">
                    </form>

                </div>
            </div>
        </div>
    </section>
    
    <section class="to-top">
        <div class="container">
            <div class="row">
                <div class="to-top-wrap">
                    <a href="#top" class="top"><i class="fa fa-angle-up"></i></a>
                </div>
            </div>
        </div>
    </section>
    <footer>
        <div class="container">
            <div class="row">
                <div class="col-md-7">
                    <div class="footer-links">
                        <ul class="footer-group">
                            <li><a href="index.jsp">Inicio</a></li>
                        </ul>
                        <p>Copyright © 2015 <a href="#">Alejandro Henkel</a><br>
                    </div>
                </div>
                <div class="social-share">
                    <p>Síguenos en Redes Sociales</p>
                    <a href="https://twitter.com/" class="twitter-share"><i class="fa fa-twitter"></i></a> <a href="#" class="facebook-share"><i class="fa fa-facebook"></i></a>
                </div>
            </div>
        </div>
    </footer>

    <jsp:include page="listCursoModalShow.jsp" flush="true" />

    <script src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.2/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="js/vendor/jquery-1.11.2.min.js"><\/script>')</script>
    <script src="js/vendor/retina.js"></script>
    <script src="js/jquery.fancybox.pack.js"></script>
    <script src="js/vendor/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    <script src="js/jquery.flexslider-min.js"></script>
    <script src="js/vendor/classie.js"></script>
    <script src="js/vendor/jquery.waypoints.min.js"></script>
    <script src="js/vendor/parallax.min.js"></script>
    <script type="text/javascript" src="js/vendor/jquery.material.form.min.js"></script>
    <script>
    (function() {
        // trim polyfill : https://developer.mozilla.org/en-US/docs/Web/JavaScript/Reference/Global_Objects/String/Trim
        if (!String.prototype.trim) {
            (function() {
                // Make sure we trim BOM and NBSP
                var rtrim = /^[\s\uFEFF\xA0]+|[\s\uFEFF\xA0]+$/g;
                String.prototype.trim = function() {
                    return this.replace(rtrim, '');
                };
            })();
        }

        [].slice.call( document.querySelectorAll( 'input.input__field' ) ).forEach( function( inputEl ) {
            // in case the input is already filled..
            if( inputEl.value.trim() !== '' ) {
                classie.add( inputEl.parentNode, 'input--filled' );
            }

            // events:
            inputEl.addEventListener( 'focus', onInputFocus );
            inputEl.addEventListener( 'blur', onInputBlur );
        } );

        function onInputFocus( ev ) {
            classie.add( ev.target.parentNode, 'input--filled' );
        }

        function onInputBlur( ev ) {
            if( ev.target.value.trim() === '' ) {
                classie.remove( ev.target.parentNode, 'input--filled' );
            }
        }
    })();
    </script>
</body>
</html>