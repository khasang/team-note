<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Team note</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
    <style>
        .w3-theme {color:#fff !important;background-color:#4CAF50 !important}
        .w3-btn {background-color:#4CAF50;margin-bottom:4px}
        .w3-code{border-left:4px solid #4CAF50}
        .myMenu {margin-bottom:150px}
    </style>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="#">Team Note</a>
        </div>
        <ul class="nav navbar-nav">
            <li class="active"><a href="#">Home</a></li>
            <li class="dropdown"><a class="dropdown-toggle" data-toggle="dropdown" href="#">Page 1 <span class="caret"></span></a>
                <ul class="dropdown-menu">
                    <li><a href="#">Page 1-1</a></li>
                    <li><a href="#">Page 1-2</a></li>
                    <li><a href="#">Page 1-3</a></li>
                </ul>
            </li>
            <li><a href="#">Page 2</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="#"><span class="glyphicon glyphicon-user"></span> Sign Up</a></li>
            <li><a href="#"><span class="glyphicon glyphicon-log-in"></span> Login</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <div class="w3-sidebar w3-bar-block w3-collapse w3-animate-left" style="z-index:3;width:270px" id="mySidebar">
        <div class="w3-bar w3-hide-large w3-large">
            <a href="javascript:void(0)" onclick="w3_show_nav('menuTut')" class="w3-bar-item w3-button w3-theme w3-hover-white w3-padding-16" style="width:50%">Tutorials</a>
            <a href="javascript:void(0)" onclick="w3_show_nav('menuRef')" class="w3-bar-item w3-button w3-theme w3-hover-white w3-padding-16" style="width:50%">References</a>
        </div>
        <a href="javascript:void(0)" onclick="w3_close()" class="w3-button w3-right w3-xlarge w3-hide-large" title="Close Menu">×</a>
        <div id="menuTut" class="myMenu">
            <div class="w3-container">
                <h3>Tasks</h3>
            </div>
            <a class="w3-bar-item w3-button" href="/html/default.asp">Learn HTML</a>
            <a class="w3-bar-item w3-button" href="/css/default.asp">Learn CSS</a>
            <a class="w3-bar-item w3-button" href="/w3css/default.asp">Learn W3.CSS</a>
            <a class="w3-bar-item w3-button" href="/colors/default.asp">Learn Colors</a>
            <a class="w3-bar-item w3-button" href="/js/default.asp">Learn JavaScript</a>
            <a class="w3-bar-item w3-button" href="/xml/default.asp">Learn XML</a>
            <a class="w3-bar-item w3-button" href="/sql/default.asp">Learn SQL</a>
            <a class="w3-bar-item w3-button" href="/php/default.asp">Learn PHP</a>
        </div>
        <div id="menuRef" class="myMenu" style="display:none">
            <div class="w3-container">
                <h3>References</h3>
            </div>
            <a class="w3-bar-item w3-button" href='/tags/default.asp'>HTML Tag Reference</a>
            <a class="w3-bar-item w3-button" href='/colors/default.asp'>HTML Color Reference</a>
            <a class="w3-bar-item w3-button" href='/cssref/default.asp'>CSS Reference</a>
            <a class="w3-bar-item w3-button" href='/cssref/css_selectors.asp'>CSS Selector Reference</a>
            <a class="w3-bar-item w3-button" href='/w3css/w3css_references.asp'>W3.CSS Reference</a>
            <a class="w3-bar-item w3-button" href='/jsref/default.asp'>JavaScript Reference</a>
            <a class="w3-bar-item w3-button" href='/php/php_ref_array.asp'>PHP Reference</a>
            <a class="w3-bar-item w3-button" href='/sql/sql_quickref.asp'>SQL Reference</a>
        </div>
    </div>
    <!-- Overlay effect when opening sidebar on small screens -->
    <div class="w3-overlay w3-hide-large" onclick="w3_close()" style="cursor:pointer" title="close side menu" id="myOverlay"></div>

    <!-- Main content: shift it to the right by 270 pixels when the sidebar is visible -->
    <div class="w3-main w3-container" style="margin-left:270px">
        <div class="w3-container">
            <h3>Task Info</h3>
        </div>
        <table class="table table-hover">
            <thead>
            <tr>
                <th>Firstname</th>
                <th>Lastname</th>
                <th>Email</th>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td>John</td>
                <td>Doe</td>
                <td>john@example.com</td>
            </tr>
            <tr>
                <td>Mary</td>
                <td>Moe</td>
                <td>mary@example.com</td>
            </tr>
            <tr>
                <td>July</td>
                <td>Dooley</td>
                <td>july@example.com</td>
            </tr>
            </tbody>
        </table>

    </div>

</div>
</body>
</html>
