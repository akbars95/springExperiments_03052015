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
                <a class="navbar-brand" href="index.jsp">Home</a>
            </div>

            <!-- Collect the nav links, forms, and other content for toggling -->
            <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li><a href="#">Tutorials<span class="sr-only">(current)</span></a></li> <%--class="active"--%>
                    <li class="dropdown">
                        <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false">Categories<span
                                class="caret"></span></a>
                        <ul class="dropdown-menu" role="menu">
                            <li><a href="#">JAVA SE</a></li>
                            <li><a href="#">JAVA EE</a></li>
                            <li><a href="#">Hibernate</a></li>
                            <li><a href="#">Spring</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Database</a></li>
                            <li class="divider"></li>
                            <li><a href="#">Javascript</a></li>
                            <li><a href="#">Javascript/jQuery</a></li>
                        </ul>
                    </li>
                    <li><a href="#">About site</a></li>
                    <li><a href="#">Contact Us</a></li>
                </ul>


                <form class="navbar-form navbar-right" role="search">
                    <div class="form-group">
                        <input type="text" class="form-control" placeholder="Site search">
                    </div>
                    <button type="submit" class="btn btn-default">Search</button>
                </form>
            </div>
            <!-- /.navbar-collapse -->
        </div>
        <!-- /.container-fluid -->
    </nav>
</div>