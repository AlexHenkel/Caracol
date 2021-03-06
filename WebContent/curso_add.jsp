<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="seguridad.jsp" %>
<%
    String mensaje = "";
    int msj;
    if (request.getParameter("msj") != null) {
        msj = Integer.valueOf(request.getParameter("msj"));
    }
    else {
        msj = 0;
    }

    switch (msj) {
        case 1:
            mensaje = "Se ha eliminado correctamente";
            break;
        case 2:
            mensaje = "Hubo un problema al eliminar, contacte al administrador";
            break;
        case 3: 
            mensaje = "Los datos se han actualizado correctamente";
            break;
        case 4:
            mensaje = "Hubo un problema al actualizar, contacte al administrador";
            break;
        case 5:
            mensaje = "Datos registrados correctamente";
            break;
        case 6:
            mensaje = "Hubo un problema al registrar, contacte al administrador";
        default:
            break;           
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
</head>
<body id="top">
    <!--[if lt IE 8]>
    <p class="browserupgrade">You are using an <strong>outdated</strong> browser. Please <a href="http://browsehappy.com/">upgrade your browser</a> to improve your experience.</p>
    <![endif]-->
    <section class="not-title">
        <section class="navigation not-fixed">
            <header>
                <div class="header-content">
                    <div class="logo"><a href="home.jsp"><img src="img/logo.png" alt="Sedna logo"></a></div>
                    <div class="header-nav">
                        <nav>
                            <ul class="member-actions">
                                <li>
                                    <a>
                                        Bienvenido <br>
                                        <%= sesionOK.getAttribute("nombre") %>
                                    </a>
                                </li>
                                <br class="hidden-xs">
                                <li>
                                    <a class="cerrar-sesion" href="cerrarsesion.jsp">Cerrar Sesión</a>
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
    <section class="sign-up section-padding text-center page-content" id="download">
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
                            <span class="input input--fumi">
                                <input class="input__field input__field--fumi" type="text" id="courseDescription" name="courseDescription" required/>
                                <label class="input__label input__label--fumi" for="courseDescription">
                                    <i class="fa fa-fw fa-envelope icon icon--fumi"></i>
                                    <span class="input__label-content input__label-content--fumi">Descripción</span>
                                </label>
                            </span>
                            <div class="material">
                                <select name="courseCategory" placeholder="Categoría">
                                    <option value="1" selected>Educación</option>
                                    <option value="2">Tecnología</option>
                                    <option value="3">Emprendimiento</option>
                                    <option value="4">Arte</option>
                                    <option value="5">Desarrollo Humano</option>
                                    <option value="6">Conciencia Cívica</option>
                                    <option value="7">Ciencias</option>
                                    <option value="8">Idiomas</option>
                                </select>
                            </div>
                            <span class="input input--fumi">
                                <input class="input__field input__field--fumi" type="text" id="courseIncubadora" name="courseIncubadora" required/>
                                <label class="input__label input__label--fumi" for="courseIncubadora">
                                    <i class="fa fa-fw fa-home icon icon--fumi"></i>
                                    <span class="input__label-content input__label-content--fumi">Incubadora Social</span>
                                </label>
                            </span>
                            <span class="input input--fumi">
                                <input class="input__field input__field--fumi" type="text" id="courseEspacio" name="courseEspacio" required/>
                                <label class="input__label input__label--fumi" for="courseEspacio">
                                    <i class="fa fa-fw fa-map-marker icon icon--fumi"></i>
                                    <span class="input__label-content input__label-content--fumi">Espacio Formativo</span>
                                </label>
                            </span>
                            <input type="hidden" name="op" value="in">
                            <input type="submit" class="btn-fill sign-up-btn" name="register" value="Registrar">
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
            $(function(){
                $('.material').materialForm(); // Apply material
            });
		</script>
</body>
</html>