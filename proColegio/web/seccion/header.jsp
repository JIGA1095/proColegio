<%-- 
    Document   : header
    Created on : 21-07-2018, 12:44:30
    Author     : Ghaos
--%>
<%@page import="proColegio.modelos.Usuario"%>
<%@page import="proColegio.beans.BNUsuario"%>
<%
    BNUsuario BNU = new BNUsuario(request);
    Usuario usu = BNU.getUsuarioSession();
%>

<head>
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <title> <%= (String) session.getAttribute("menu")%> </title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="apple-touch-icon" href="apple-touch-icon.html">
    <!-- Place favicon.ico in the root directory -->
    <link rel="stylesheet" href="css/vendor.css">
    <!-- Theme initialization -->
    <script>
        var themeSettings = (localStorage.getItem('themeSettings')) ? JSON.parse(localStorage.getItem('themeSettings')) :
                {};
        var themeName = themeSettings.themeName || '';
        if (themeName)
        {
            document.write('<link rel="stylesheet" id="theme-style" href="css/app-' + themeName + '.css">');
        } else
        {
            document.write('<link rel="stylesheet" id="theme-style" href="css/app.css">');
        }
    </script>
    <script src="template/js/jquery-2.1.3.min.js" type="text/javascript"></script>
    <script src="template/js/adminFile.js"></script>
    <link href="template/iosNotify/css/notify.css" rel="stylesheet" type="text/css"/>
    <script src="template/iosNotify/js/ios.notify.js" type="text/javascript"></script>
    <script src="template/js/jquery.blockUI.js" type="text/javascript"></script>

</head>

<header class="header">

    <div class="header-block header-block-collapse d-lg-none d-xl-none">
        <button class="collapse-btn" id="sidebar-collapse-btn">
            <i class="fa fa-bars"></i>
        </button>
    </div>
    <div class="header-block header-block-nav">
        <ul class="nav-profile">
            <li class="notifications new">
                <a href="#" data-toggle="dropdown">
                    <i class="fa fa-bell-o"></i>
                    <sup>
                        <span class="counter">8</span>
                    </sup>
                </a>
                <div class="dropdown-menu notifications-dropdown-menu">
                    <ul class="notifications-container">
                        <li>
                            <a href="#" class="notification-item">
                                <div class="body-col">
                                    <p>
                                        <span class="accent">Zack Alien</span> pushed new commit:
                                        <span class="accent">Fix page load performance issue</span>. </p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="notification-item">
                                <div class="body-col">
                                    <p>
                                        <span class="accent">Amaya Hatsumi</span> started new task:
                                        <span class="accent">Dashboard UI design.</span>. </p>
                                </div>
                            </a>
                        </li>
                        <li>
                            <a href="#" class="notification-item">
                                <div class="body-col">
                                    <p>
                                        <span class="accent">Andy Nouman</span> deployed new version of
                                        <span class="accent">NodeJS REST Api V3</span>
                                    </p>
                                </div>
                            </a>
                        </li>
                    </ul>
                    <footer>
                        <ul>
                            <li>
                                <a href="#"> View All </a>
                            </li>
                        </ul>
                    </footer>
                </div>
            </li>
            <li class="profile dropdown">
                <a class="nav-link dropdown-toggle" data-toggle="dropdown" href="#" role="button" aria-haspopup="true" aria-expanded="false">
                    <!--<div class="img" style="background-image: url('https://avatars3.githubusercontent.com/u/3959008?v=3&amp;s=40')"> </div>-->
                    <span class="name"> <%= usu.getUsu_nombre() + " " + usu.getUsu_apellido()%> </span>
                </a>
                <div class="dropdown-menu profile-dropdown-menu" aria-labelledby="dropdownMenu1">

                    <a class="dropdown-item" href="#" onclick="go('logout')">
                        <i class="fa fa-power-off icon"></i> Salir </a>
                </div>
            </li>
        </ul>
    </div>        
</header>
