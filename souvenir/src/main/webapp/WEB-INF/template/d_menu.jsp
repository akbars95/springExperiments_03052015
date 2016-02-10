<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="menu">

<script type="text/javascript">
    $(document).ready(function(){
        var home = $("li#home");
        var catalog = $("li#catalog");
        var advanced_search = $("li#advanced_search");
        var about_us = $("li#about_us");
        var contact_us = $("li#contact_us");

        var pages = [home, catalog, advanced_search, about_us, contact_us];

        var activeClass = "active";

        var arr = location.pathname.split("/");
        if(arr.length > 0){
            var pathName = arr[arr.length - 1];
            switch (pathName) {
                case "home":
                case "":
                case "index":
                    removeActiveClass();
                    home[0].setClass(activeClass);
                    break;
                case "catalog":
                    removeActiveClass();
                    catalog[0].setClass(activeClass);
                    break;
                case "advanced_search":
                    removeActiveClass();
                    advanced_search[0].setClass(activeClass);
                    break;
                case "about_us":
                    removeActiveClass();
                    about_us[0].setClass(activeClass);
                    break;
                case  "contact_us":
                    removeActiveClass();
                    contact_us[0].setClass(activeClass);
                    break;
            }
        }

        function removeActiveClass(){
            for(i = 0; i < pages.length; i++){
                if(pages[i][0].hasClass(activeClass)){
                    pages[i][0].removeClass(activeClass);
                }
            }
        }
    });
</script>

    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <!-- Brand and toggle get grouped for better mobile display -->
            <div class="navbar-header">
                <button type="button" class="navbar-toggle collapsed"
                        data-toggle="collapse" data-target="#bs-example-navbar-collapse-1"
                        aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span> <span
                        class="icon-bar"></span> <span class="icon-bar"></span> <span
                        class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#"><spring:message
                        code="menu.name.souvenir"/></a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse"
                 id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li id="home" class="active"><spring:url value="/home" var="homeUrl"
                                                   htmlEscape="true"/> <a href="${homeUrl}"><spring:message
                            code="menu.home.title"/><span class="sr-only">(current)</span></a></li>
                    <li id="catalog"><spring:url value="/catalog" var="catalogUrl"
                                    htmlEscape="true"/> <a href="${catalogUrl}"><spring:message
                            code="menu.catalog.title"/></a></li>
                    <li id="advanced_search"><spring:url value="/advanced_search" var="advanced_searchUrl"
                                    htmlEscape="true"/> <a href="${advanced_searchUrl}"><spring:message
                                    code="menu.advanced_search.title"/></a></li>
                    <li id="about_us"><spring:url value="/about_us" var="about_usUrl"
                                    htmlEscape="true"/> <a href="${about_usUrl}"><spring:message
                            code="menu.about_us.title"/></a></li>
                    <li id="contact_us"><spring:url value="/contact_us" var="contact_usUrl"
                                    htmlEscape="true"/> <a href="${contact_usUrl}"><spring:message
                            code="menu.contact_us.title"/></a></li>
                    <!-- <li class="dropdown"><a href="#" class="dropdown-toggle"
                        data-toggle="dropdown" role="button" aria-haspopup="true"
                        aria-expanded="false">Dropdown <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">One more separated link</a></li>
                        </ul></li> -->
                </ul>
                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control"
                               placeholder="<spring:message code="menu.search.form.text.placeholder" />">
                    </div>
                    <button type="submit" class="btn btn-default">
                        <spring:message code="menu.search.form.button.search"/>
                    </button>
                </form>
                <!-- <ul class="nav navbar-nav navbar-right">
                    <li><a href="#">Link</a></li>
                    <li class="dropdown"><a href="#" class="dropdown-toggle"
                        data-toggle="dropdown" role="button" aria-haspopup="true"
                        aria-expanded="false">Dropdown <span class="caret"></span></a>
                        <ul class="dropdown-menu">
                            <li><a href="#">Action</a></li>
                            <li><a href="#">Another action</a></li>
                            <li><a href="#">Something else here</a></li>
                            <li role="separator" class="divider"></li>
                            <li><a href="#">Separated link</a></li>
                        </ul></li>
                </ul> -->
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>

</div>