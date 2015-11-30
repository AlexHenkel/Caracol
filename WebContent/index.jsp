<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
    String msj = request.getParameter("error");
    if (msj == null) {
        msj = "";
    }
    else {
        if (msj.equals("v")) {
            msj = "Datos incorrectos. Vuelve a intentar";        
        }
        else if (msj.equals("m")) {
            msj = "Es obligatorio identificarse";
        }
        else {
            msj = "Acceso solo a personas autorizadas";
        }
    }
%>
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
    <script src="js/md5.js"></script>
</head>
<body id="top">
    <!--[if lt IE 8]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->
    <section class="hero" id="index-1-bg">
        <section class="navigation not-fixed">
            <header>
                <div class="header-content">
                    <div class="logo"><a href="index.jsp"><img src="img/logo.png" alt="Sedna logo"></a></div>
                    <div class="header-nav">
                        <nav>
                            <ul class="primary-nav">
                                <li><a href="#assets">Misión</a></li>
                                <li><a href="#cursos">Cursos</a></li>
                                <li><a href="#testimonios">Testimonios</a></li>
                            </ul>
                            <ul class="member-actions">
                                <li><a href="#login" class="login btn-white btn-small">Acceder</a></li>
                                <li><a href="registro.jsp" class="btn-small">Regístrate</a></li>
                            </ul>
                        </nav>
                    </div>
                    <div class="navicon">
                        <a class="nav-toggle" href="#"><span></span></a>
                    </div>
                </div>
            </header>
        </section>
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="hero-content text-center">
                        <img src="img/logo.png" alt="">
                        <p class="intro">Slogan grande de la incubadora caracol. Slogan grande de la incubadora caracol. Slogan grande de la incubadora.</p>
                        <a href="#cursos" class="btn btn-fill btn-large">Cursos</a> 
                    </div>
                </div>
            </div>
        </div>
        <div class="down-arrow floating-arrow"><a href="#assets"><i class="fa fa-angle-down"></i></a></div>
    </section>
    <section class="features-extra section-padding" id="assets">
        <div class="container">
            <div class="row">
                <div class="col-md-5">
                    <div class="feature-list">
                        <h3>Misión y Visión</h3>
                        <p><span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Sint alias ullam nulla tempora incidunt maiores iure sit nihil necessitatibus iste accusantium voluptas deleniti, cumque qui, eos aspernatur dolorem dolorum illo.</span>
                        <span>Odio totam possimus velit, quisquam voluptatem debitis atque provident id veniam enim ducimus qui, optio hic nemo, sequi aut quibusdam molestias dolorem obcaecati praesentium? Numquam aut nulla ducimus accusamus deleniti.</span>
                        <span>Ratione voluptates pariatur, maxime reprehenderit, illum numquam odio aliquam earum voluptatem voluptas, quisquam at nostrum. Neque nesciunt a, aperiam possimus reprehenderit fugiat vel ea molestias illo. Nam placeat velit est?</span>
                        </p>
                    </div>
                </div>
            </div>
        </div>
        <div class="macbook-wrap wp3"></div>
        <div class="responsive-feature-img"><img src="img/macbook-pro.png" alt="responsive devices"></div>
    </section>
    <section class="hero-strip section-padding cursos-index" id="cursos">
        <div class="container">
            <div class="col-md-12 text-center">
                <h2>
                Mira los cursos
                </h2>
                <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Praesentium ea, quasi eum non, nemo, iusto molestiae earum.</p>
                <a href="cursos.jsp" class="btn btn-ghost btn-accent btn-large">Ver Cursos</a>
                <div class="logo-placeholder floating-logo"><img src="img/img1.png" alt="Sketch Logo"></div>
            </div>
        </div>
    </section>
    <section class="blog-intro section-padding" id="blog">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <br><br>
                    <h3>Testimonios</h3>
                </div>
            </div>
        </div>
    </section>
    
    <section class="testimonial-slider section-padding text-center" id="testimonios">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <div class="flexslider">
                        <ul class="slides">
                            <li>
                                <div class="avatar"><img src="img/avatar.jpg" alt="Sedna Testimonial Avatar"></div>
                                <h2>"Lorem ipsum dolor sit amet, nullam lucia nisi."</h2>
                                <p class="author">Mauro, Estudiante.</p>
                            </li>
                            <li>
                                <div class="avatar"><img src="img/mani.jpg" alt="Sedna Testimonial Avatar"></div>
                                <h2>"Nunc vel maximus purus. Nullam ac urna ornare."</h2>
                                <p class="author">María, Socia.</p>
                            </li>
                            <li>
                                <div class="avatar"><img src="img/130.jpg" alt="Sedna Testimonial Avatar"></div>
                                <h2>"Nullam ac urna ornare, ultrices nisl ut, lacinia nisi."</h2>
                                <p class="author">David, Beneficiario</p>
                            </li>
                        </ul>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <section class="sign-up section-padding text-center" id="download">
        <div class="container" id="login">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h3>Eres colaborador?</h3>
                    <p>Accesa en este sitio</p>
                    <label for="" style="color: red"><%=msj %></label>
                    <form class="signup-form" action="cUsuario" method="POST" role="form">
                        <span class="input input--fumi">
                            <input class="input__field input__field--fumi" type="text" id="lUsuario" name="lUsuario" required />
                            <label class="input__label input__label--fumi" for="lUsuario">
                                <i class="fa fa-fw fa-envelope icon icon--fumi"></i>
                                <span class="input__label-content input__label-content--fumi">Ingresa tu email</span>
                            </label>
                        </span>
                        <span class="input input--fumi">
                            <input class="input__field input__field--fumi" type="password" size="20" id="lPass" name="lPass" required onkeyup="this.form.lPasse.value=md5(this.form.lPass.value)"/>
                            <input type="hidden" name="lPasse">
                            <label class="input__label input__label--fumi" for="lPass">
                                <i class="fa fa-fw fa-unlock-alt icon icon--fumi"></i>
                                <span class="input__label-content input__label-content--fumi">Ingresa tu contraseña</span>
                            </label>
                        </span>
                        <button type="submit" name="opc" class="btn-fill sign-up-btn">Acceder</button>
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
                            <li><a href="index.jsp#assets">Misión</a></li>
                            <li><a href="#cursos">Cursos</a></li>
                            <li><a href="#testimonios">Testimonios</a></li>
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