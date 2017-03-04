<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <title>POS App</title>
    <link rel="shortcut icon" href="images/icon.ico">

    <!-- Bootstrap -->
    <link href="bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="css/styles.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Bree+Serif" rel="stylesheet">

  </head>
  <body>
    <div class="fluid-container">

      <div class="heading-section"><!-- Headin Section Start -->
        <div class="col-lg-offset-2 col-lg-8 col-md-offset-1 col-md-10 col-sm-12">
          <!--Navbar Start -->
            <nav class="navbar navbar-default">
              <div class="container-fluid">
                <div class="navbar-header row">
                  <button id="collapsedBtn" type="button" class="navbar-toggle collapsed col-xs-2" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                  </button>
                  <a class="navbar-brand hidden-xs" href="#">Project name</a>
                  <a class="navbar-brand col-xs-6 visible-xs" href="#">Project name</a>
                </div>
                <div id="navbar" class="navbar-collapse collapse">
                  <ul id="primaryLinks" class="nav navbar-nav">
                    <li class="navbar-active"><a href="#">Home</a></li>
                    <li><a href="#content-section-3">Features</a></li>
                    <li><a href="pages/contactUs.php">Contact Us</a></li>
                    <li class="hidden-xs"><a href="#" data-toggle="modal" data-target="#logIn">Log In</a></li>

                    <!-- Modal -->
                    <div class="modal fade " id="logIn" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                      <div class="modal-dialog" role="document">
                        <div class="modal-content">
                          <div class="modal-header">
                            <div class="col-sm-4"><h3>Log In</h3></div>
                            <div class="col-lg-offset-2 col-sm-offset-3"><button type="button" class="close col-lg-1 col-sm-1" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button></div>
                          </div>
                          <div class="modal-body">
                            <form name="logIn" method="post" action="pages/loginHandler.php">
                              <div class="row form-group">
                                <div class="col-sm-offset-1"><label for="login_email">Email</label></div>
                                <div class="col-sm-offset-1 col-sm-10"><input type="Email" class="form-control" id="login_email" name="login_email" placeholder="johnsmith@example.ie"></div>
                              </div>

                              <div class="row form-group">
                                <div class="col-sm-offset-1"><label for="login_password">Password</label></div>
                                <div class="col-sm-offset-1 col-sm-10"><input type="password" class="form-control" id="login_password" name="login_password" placeholder="Password"></div>
                              </div>

                              <div class="row form-group">
                                <div class="col-sm-offset-5 col-sm-1"><a href="#"><button id="logInSubmit" type="submit" class="btn btn-primary" >Submit</button></a></div>
                              </div>
                            </form>
                          </div>

                        </div>
                      </div>
                    </div>
                    <li class="visible-xs"><a href="pages/login.php">Log In</a></li>
                  </ul>
                  <ul class="nav navbar-nav navbar-right">
                    <li id="signUpBtn"><a href="pages/signUp.php">Sign Up</a></li>
                  </ul>
                </div>
            </nav>
          </div>
          <!-- Navbar End -->
          <div class="row">

            <div class="col-lg-offset-2 col-lg-8 col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-12 text-center">
              <h1>Some <span class="green">Heading</span> Title</h1>

            </div>
          </div>

          <div class="row">

            <div class="col-lg-offset-5 col-lg-2 col-md-offset-5 col-md-2 col-xs-offset-4 col-xs-4">
              <button id="getStartedBtn" type="button" class="btn btn-primary btn-block" >Get Started</button>

            </div>
          </div>
        </div> <!-- Heading Section End -->

        <hr>

        <div id="content-section-1" class="row">

          <div class="col-lg-offset-5 col-lg-2 col-md-offset-3 col-md-6 col-xs-offset-2 col-xs-8 text-center">
            <h2>Some Heading</h2>
          </div>
          <div class="col-lg-offset-3 col-lg-6 col-md-offset-2 col-md-8 col-sm-offset-2 col-sm-8 col-xs-offset-1 col-xs-10 text-center">
            Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
            tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
            quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
            consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
            cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
            proident, sunt in culpa qui officia deserunt mollit anim id est laborum.

          </div>
        </div>

        <hr>

        <div id="content-section-2" class="row">
          <div class="col-lg-offset-5 col-lg-2">
            <button id="playButton" type="button" class="btn btn-default btn-lg center-block" data-toggle="modal" data-target="#myModal">
              <span class="glyphicon glyphicon-play" aria-hidden="true"></span>
            </button>

              <!-- Modal -->
              <div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
                <div class="modal-dialog" role="document">
                  <div class="modal-content">
                    <div class="modal-body">
                      <div style="position:relative;height:0;padding-bottom:56.25%"><iframe src="https://www.youtube.com/embed/E5ln4uR4TwQ?ecver=2" width="640" height="360" frameborder="0" style="position:absolute;width:100%;height:100%;left:0" allowfullscreen></iframe></div>
                    </div>
                    <div class="modal-footer">
                      <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                    </div>
                  </div>
                </div>
              </div>

          </div>
        </div>

        <hr>

        <div id="content-section-3" class="hidden-xs">
          <div class="row text-center">
            <div class="col-lg-offset-1 col-lg-3 col-sm-4">
              <h2>Some Heading</h2>
              <img src="images/test1.jpg">
            </div>

            <div class="col-lg-4 col-sm-4">
              <h2>Some Heading</h2>
              <img src="images/test2.jpg">
            </div>

            <div class="col-lg-3 col-sm-4">
              <h2>Some Heading</h2>
              <img src="images/test3.png">
            </div>
          </div>

          <div class="row text-center">
            <div class="col-lg-offset-1 col-lg-3 col-sm-4">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
              tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
              quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
              consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
              cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
              proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </div>

            <div class="col-lg-4 col-sm-4">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
              tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
              quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
              consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
              cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
              proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </div>

            <div class="col-lg-3 col-sm-4">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
              tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
              quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
              consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
              cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
              proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </div>
          </div>
        </div>

        <div id="content-section-3" class="visible-xs">
          <div class="row">
            <div class="col-xs-offset-3 xol-xs-6">
              <h2>Some Heading</h2>
              <img src="images/test1.jpg">
            </div>
            <div class="col-xs-offset-1 col-xs-10">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
              tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
              quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
              consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
              cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
              proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </div>
          </div>

          <div class="row">
            <div class="col-xs-offset-3 xol-xs-6">
              <h2>Some Heading</h2>
              <img src="images/test2.jpg">
            </div>
            <div class="col-xs-offset-1 col-xs-10">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
              tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
              quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
              consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
              cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
              proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </div>
          </div>

          <div class="row">
            <div class="col-xs-offset-3 xol-xs-6">
              <h2>Some Heading</h2>
              <img src="images/test3.png">
            </div>
            <div class="col-xs-offset-1 col-xs-10">
              <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod
              tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam,
              quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo
              consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse
              cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non
              proident, sunt in culpa qui officia deserunt mollit anim id est laborum.</p>
            </div>
          </div>

        </div>

        <hr>



      </div>
    
  
    <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
      <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
      <!-- Include all compiled plugins (below), or include individual files as needed -->
       <script src="bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
  </body>
  <!--  =============Footer Start=================== -->
  <footer id="footer" >
    <div class="row ">

      <div class="col-lg-offset-2 col-lg-2 col-xs-offset-2 col-xs-2 footer-background">

        <a href=""><img class="center-block" src="images/glyphicons-social-31-facebook.png"></a>
      </div>
      <div class="col-lg-offset-1 col-lg-2 col-xs-offset-1 col-xs-2">
        <a href="https://gitlab.computing.dcu.ie/kellyi7/pointofserviceapp"><img class="center-block" src="images/glyphicons-social-22-github.png"></a>
      </div>
      <div class="col-lg-offset-1 col-lg-2 col-xs-offset-1 col-xs-2">
        <a href=""><img class="center-block" src="images/glyphicons-social-38-rss.png"></a>
      </div>
    </div>
    <div class="row text-center">
      <div class="col-lg-offset-2 col-lg-2 col-xs-offset-2 col-xs-2">
        <h3>Facebook</h3>
      </div>
      <div class="col-lg-offset-1 col-lg-2 col-xs-offset-1 col-xs-2">
        <h3>Github</h3>
      </div>
      <div class="col-lg-offset-1 col-lg-2 col-xs-offset-1 col-xs-2">
        <h3>Blog</h3>
      </div>
    </div>
  </footer>
  <!--  =============Footer End=================== -->
</html>