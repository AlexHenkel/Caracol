<%@page import="java.sql.ResultSet"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file="seguridad.jsp" %>
<jsp:useBean id="curso" class="caracol.modelo.Curso" scope="request" />
<jsp:useBean id="cx" class="caracol.modelo.Conectar" scope="page" />
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
    <section class="hero" id="index-1-bg">
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
            </header>
        </section>
        <div class="container">
            <div class="row">
                <div class="col-md-10 col-md-offset-1">
                    <div class="hero-content text-center">
                        <h1>Cursos</h1>
                        <p class="intro">Slogan grande de la incubadora caracol. Slogan grande de la incubadora caracol. Slogan grande de la incubadora.</p>
                    </div>
                </div>
            </div>
        </div>
        <div class="down-arrow floating-arrow"><a href="#cursos"><i class="fa fa-angle-down"></i></a></div>
    </section>
    <section class="blog-intro" id="blog">
        <div class="container">
            <div class="row">
                <div class="col-md-12">
                    <h3>Categorías</h3>
                    <label for="" style="color: <% if(msj == 1 || msj == 3 || msj == 5) {%>green<%}else{%>red<%}%>"><%=mensaje %></label>
                </div>
            </div>
        </div>
    </section>
    <section class="blog text-center" id="cursos">
        <div class="container-fluid">
            <div class="row">
                <div class="col-md-4">
                    <article class="blog-post">
                        <figure>
                            <a data-toggle="modal" data-target=".modal-curso-1">
                                <div class="blog-img-wrap">
                                    <img src="img/coc.jpeg" alt=" blog image"/>
                                </div>
                            </a>
                            <figcaption>
                            <h2><a class="blog-category" data-toggle="modal" data-target=".modal-curso-1">Educación</a></h2>
                            </figcaption>
                        </figure>
                    </article>
                </div>
                <div class="col-md-4">
                    <article class="blog-post">
                        <figure>
                            <a data-toggle="modal" data-target=".modal-curso-2">
                                <div class="blog-img-wrap">
                                    <img src="img/tech.jpg" alt=" blog image"/>
                                </div>
                            </a>
                            <figcaption>
                            <h2><a class="blog-category" data-toggle="modal" data-target=".modal-curso-2">Tecnología</a></h2>
                            </figcaption>
                        </figure>
                    </article>
                </div>
                <div class="col-md-4">
                    <article class="blog-post">
                        <figure>
                            <a data-toggle="modal" data-target=".modal-curso-3">
                                <div class="blog-img-wrap">
                                    <img src="img/ed.jpg" class="" alt="Sedna blog image"/>
                                </div>
                            </a>
                            <figcaption>
                            <h2><a class="blog-category" data-toggle="modal" data-target=".modal-curso-3">Emprendimiento</a></h2>
                            </figcaption>
                        </figure>
                    </article>
                </div>
                <div class="col-md-4">
                    <article class="blog-post">
                        <figure>
                            <a data-toggle="modal" data-target=".modal-curso-4">
                                <div class="blog-img-wrap">
                                    <img src="img/dep.jpg" alt=" blog image"/>
                                </div>
                            </a>
                            <figcaption>
                            <h2><a class="blog-category" data-toggle="modal" data-target=".modal-curso-4">Arte</a></h2>
                            </figcaption>
                        </figure>
                    </article>
                </div>
                <div class="col-md-4">
                    <article class="blog-post">
                        <figure>
                            <a data-toggle="modal" data-target=".modal-curso-5">
                                <div class="blog-img-wrap">
                                    <img src="img/sal.jpg" alt=" blog image"/>
                                </div>
                            </a>
                            <figcaption>
                            <h2><a class="blog-category" data-toggle="modal" data-target=".modal-curso-5">Desarrollo Humano</a></h2>
                            </figcaption>
                        </figure>
                    </article>
                </div>
                <div class="col-md-4">
                    <article class="blog-post">
                        <figure>
                            <a data-toggle="modal" data-target=".modal-curso-6">
                                <div class="blog-img-wrap">
                                    <img src="img/man.jpg" class="" alt="Sedna blog image"/>
                                </div>
                            </a>
                            <figcaption>
                            <h2><a class="blog-category" data-toggle="modal" data-target=".modal-curso-6">Conciencia Cívica</a></h2>
                            </figcaption>
                        </figure>
                    </article>
                </div>
                <div class="col-md-4">
                    <article class="blog-post">
                        <figure>
                            <a data-toggle="modal" data-target=".modal-curso-7">
                                <div class="blog-img-wrap">
                                    <img src="img/man.jpg" class="" alt="Sedna blog image"/>
                                </div>
                            </a>
                            <figcaption>
                            <h2><a class="blog-category" data-toggle="modal" data-target=".modal-curso-7">Ciencias</a></h2>
                            </figcaption>
                        </figure>
                    </article>
                </div>
                <div class="col-md-4">
                    <article class="blog-post">
                        <figure>
                            <a data-toggle="modal" data-target=".modal-curso-8">
                                <div class="blog-img-wrap">
                                    <img src="img/man.jpg" class="" alt="Sedna blog image"/>
                                </div>
                            </a>
                            <figcaption>
                            <h2><a class="blog-category" data-toggle="modal" data-target=".modal-curso-8">Idiomas</a></h2>
                            </figcaption>
                        </figure>
                    </article>
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

    <jsp:include page="listCursoModal.jsp" flush="true" />
    <jsp:include page="listCursoModalEdit.jsp" flush="true" />

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
    $(document).ready(function() {
        var url = String(location);
        var edit = url.indexOf("op=up");
        if (edit != -1) {
            $('.modal-curso-edit').modal('show');
        }
        $('.modal-curso-edit').on('hidden.bs.modal', function (e) {
          // do something...
          $( "#curso-edit-form" ).submit();
        })
    });
    $(function(){
        $('.material').materialForm(); // Apply material
    });
    </script>
</body>
</html>