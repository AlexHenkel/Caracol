<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
    <section class="hero not-title">
        <section class="navigation fixed">
            <header>
                <div class="header-content">
                    <div class="logo"><a href="index.php"><img src="img/logo.png" alt="Sedna logo"></a></div>
                    <div class="header-nav">
                        <nav>
                            <ul class="member-actions">
                                <li>
                                    <a>
                                        Bienvenido <br>
                                        Mauro Amarante
                                    </a>
                                </li>
                            </ul>
                        </nav>
                    </div>
                    <div class="navicon">
                        <a class="nav-toggle" href="#"><span></span></a>
                    </div>
                </div>
            </header>
        </section>
    </section>
    <section class="sign-up section-padding text-center" id="download">
        <div class="container">
            <div class="row">
                <div class="col-md-6 col-md-offset-3">
                    <h1>Agregar curso</h1>
                    <form class="signup-form" action="cCurso" method="POST" role="form">
                        <div class="form-hidden">
                            <span class="input input--fumi">
                                <input class="input__field input__field--fumi" type="text" id="courseName" name="courseName" required/>
                                <label class="input__label input__label--fumi" for="courseName">
                                    <i class="fa fa-fw fa-user icon icon--fumi"></i>
                                    <span class="input__label-content input__label-content--fumi">Nombre del curso</span>
                                </label>
                            </span>
                            <!-- <span class="input input--fumi">
                                <input class="input__field input__field--fumi" type="text" id="courseName" name="courseName" />
                                <label class="input__label input__label--fumi" for="input-23">
                                    <i class="fa fa-fw fa-location-arrow icon icon--fumi"></i>
                                    <span class="input__label-content input__label-content--fumi">Categoría</span>
                                </label>
                            </span> -->
                            <span class="input input--fumi">
                                <input class="input__field input__field--fumi" type="text" id="courseDescription" name="courseDescription" required/>
                                <label class="input__label input__label--fumi" for="courseDescription">
                                    <i class="fa fa-fw fa-envelope icon icon--fumi"></i>
                                    <span class="input__label-content input__label-content--fumi">Descripción</span>
                                </label>
                            </span>
                            <span class="input input--fumi">
                                <input class="input__field input__field--fumi" type="text" id="courseUbication" name="courseUbication" required />
                                <label class="input__label input__label--fumi" for="courseUbication">
                                    <i class="fa fa-fw fa-unlock-alt icon icon--fumi"></i>
                                    <span class="input__label-content input__label-content--fumi">Ubicación</span>
                                </label>
                            </span>
                            <!-- <span class="input input--fumi">
                                <input class="input__field input__field--fumi" type="text" id="input-23" />
                                <label class="input__label input__label--fumi" for="input-23">
                                    <i class="fa fa-fw fa-user icon icon--fumi"></i>
                                    <span class="input__label-content input__label-content--fumi">Nombre del socio</span>
                                </label>
                            </span> -->
                            <button type="submit" class="btn-fill sign-up-btn" name="register" value="Register">Registrar</button>
                        </div>
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
                            <li><a href="#assets">Misión</a></li>
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