<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<div class="mainMenu">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                        data-target="#bs-example-navbar-collapse-1">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="index"><spring:message code="menu_main.home.title" /></a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="tutorial"><spring:message code="menu_main.tutorials.title" /><span class="sr-only">(current)</span></a></li> <%--class="active"--%>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><spring:message code="menu_main.categories.title" /><span
                                class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#"><spring:message code="menu_main.categories.java_se.title" /></a></li>
                            <li><a href="#"><spring:message code="menu_main.categories.java_ee.title" /></a></li>
                            <li><a href="#"><spring:message code="menu_main.categories.hibernate.title" /></a></li>
                            <li><a href="#"><spring:message code="menu_main.categories.spring.title" /></a></li>
                            <li class="divider"></li>
                            <li><a href="#"><spring:message code="menu_main.categories.database.title" /></a></li>
                            <li class="divider"></li>
                            <li><a href="#"><spring:message code="menu_main.categories.js.title" /></a></li>
                            <li><a href="#"><spring:message code="menu_main.categories.js_jquery.title" /></a></li>
                        </ul>
                    </li>
                    <li><a href="about_site"><spring:message code="menu_main.about_site.title" /></a></li>
                    <li><a href="contact_us"><spring:message code="menu_main.contact_us.title" /></a></li>
                </ul>


                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="<spring:message code="menu_main.site_search.placeholderTB" />">
                    </div>
                    <button type="submit" class="btn btn-default"><spring:message code="menu_main.site_search.btn" /></button>
                </form>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
</div>