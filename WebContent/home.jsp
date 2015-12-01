<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="true"%>
<%@ include file="seguridad.jsp" %>
<%
    String mensaje = "";
    int msj = 0;
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
            mensaje = "Se ha actualizado correctamente";
            break;
        case 4:
            mensaje = "Hubo un problema al actualizar, contacte al administrador";
            break;
        case 5:
            mensaje = "Se ha registrado correctamente";
            break;
        case 6:
            mensaje = "Hubo un problema al registrar, contacte al administrador";
            break;
        case 7:
            mensaje = "Tu usuario ha sido registrado. Bienvenido!";
            break;
        case 9:
            mensaje = "No tienes Socios Formadores registrados";
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
        <section class="navigation fixed">
            <header>
                <div class="header-content">
                    <div class="logo"><a href="#"><img src="img/logo.png" alt="Sedna logo"></a></div>
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
    <section class="sign-up section-padding text-center" id="download">
        <div class="container">
            <div class="row">
                <div class="col-xs-12">
                    <h2 class="dashboard-title">Dashboard</h2>
                    <label for="" style="color: <% if(msj == 1 || msj == 3 || msj == 5 || msj == 7) {%>green<%}else{%>red<%}%>"><%=mensaje %></label>
                    <div class="main">
                        <ul class="cbp-ig-grid">
                            <li>
                                <a href="benef_add.jsp">
                                    <span class="cbp-ig-icon cbp-ig-icon-shoe"></span>
                                    <h3 class="cbp-ig-title">Agregar beneficiario</h3>
                                </a>
                            </li>
                            <li>
                                <a href="benef_list.jsp">
                                    <span class="cbp-ig-icon cbp-ig-icon-ribbon"></span>
                                    <h3 class="cbp-ig-title">Lista de beneficiarios</h3>
                                </a>
                            </li>
                            <li>
                                <a href="curso_add.jsp">
                                    <span class="cbp-ig-icon cbp-ig-icon-milk"></span>
                                    <h3 class="cbp-ig-title">Agregar curso</h3>
                                </a>
                            </li>
                            <li>
                                <a href="curso_list.jsp">
                                    <span class="cbp-ig-icon cbp-ig-icon-whippy"></span>
                                    <h3 class="cbp-ig-title">Lista de cursos</h3>
                                </a>
                            </li>
                            <li>
                                <a href="#">
                                    <span class="cbp-ig-icon cbp-ig-icon-spectacles"></span>
                                    <h3 class="cbp-ig-title">Inscripciones</h3>
                                </a>
                            </li>
                            <li>
                                <a href="list.php">
                                    <span class="cbp-ig-icon cbp-ig-icon-doumbek"></span>
                                    <h3 class="cbp-ig-title">Tomar lista</h3>
                                </a>
                            </li>
                            <li>
                                <a href="codigo_list.jsp">
                                    <span class="cbp-ig-icon cbp-ig-icon-whippy"></span>
                                    <h3 class="cbp-ig-title">Códigos de Acceso</h3>
                                </a>
                            </li>
                            <li>
                                <a href="periodo_list.jsp">
                                    <span class="cbp-ig-icon cbp-ig-icon-milk"></span>
                                    <h3 class="cbp-ig-title">Periodos escolares</h3>
                                </a>
                            </li>
                            <li>
                                <a href="grupo_list.jsp">
                                    <span class="cbp-ig-icon cbp-ig-icon-spectacles"></span>
                                    <h3 class="cbp-ig-title">Grupos</h3>
                                </a>
                            </li>
                        </ul>
                    </div>

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
    <script src="retina.js"></script>
    <script src="js/jquery.fancybox.pack.js"></script>
    <script src="js/vendor/bootstrap.min.js"></script>
    <script src="js/scripts.js"></script>
    <script src="js/jquery.flexslider-min.js"></script>
    <script src="js/vendor/classie.js"></script>
    <script src="js/vendor/jquery.waypoints.min.js"></script>
    <script src="js/vendor/parallax.min.js"></script>
</body>
</html>