<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div class="menu">

<script type="text/javascript">
//alert(location.pathname);
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
                    <li class="active"><spring:url value="/home" var="homeUrl"
                                                   htmlEscape="true"/> <a href="${homeUrl}"><spring:message
                            code="menu.home.title"/><span class="sr-only">(current)</span></a></li>
                    <li><spring:url value="/catalog" var="catalogUrl"
                                    htmlEscape="true"/> <a href="${catalogUrl}"><spring:message
                            code="menu.catalog.title"/></a></li>
                    <li><spring:url value="/advanced_search" var="advanced_searchUrl"
                                    htmlEscape="true"/> <a href="${advanced_searchUrl}"><spring:message
                                    code="menu.advanced_search.title"/></a></li>
                    <li><spring:url value="/about_us" var="about_usUrl"
                                    htmlEscape="true"/> <a href="${about_usUrl}"><spring:message
                            code="menu.about_us.title"/></a></li>
                    <li><spring:url value="/contact_us" var="contact_usUrl"
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