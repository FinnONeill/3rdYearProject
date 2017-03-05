<?php
  session_start();

  // Server details
  $servername = "localhost";
  $dbusername = "root";
  $dbpassword = "";
  $dbname = "posapp_database";
  $company_id = $_SESSION["company_id"];

  //create connection
  $conn = new mysqli($servername, $dbusername, $dbpassword, $dbname);

  //check connection
  if($conn->connect_error){
    die("Connection failed: " . $conn->connect_error);
  }

  $query = "SELECT item_name, item_description, item_price, item_catagory FROM menu_details WHERE menu_id = '$company_id' ORDER BY item_catagory";

  $result = $conn->query($query) or die ("Failed to query database ".$conn->connect_error);

  $dataRow="";
  $catagory="";

  while($row = mysqli_fetch_array($result) ){

    //if($catagory != $row[3]){
        //$catagory = $row[3];

        $dataRow = $dataRow."<tr><td>$row[0]</td><td>$row[1]</td><td>$row[2]</td></tr>";
    //}

  }
?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <meta name="description" content="">
    <meta name="author" content="">
    <link rel="icon" href="../images/logo.ico">

    <title>Order 66</title>

    <!-- Bootstrap core CSS -->
    <link href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="../css/dashboard.css" rel="stylesheet">
  </head>

  <body>

    <nav class="navbar navbar-inverse navbar-fixed-top">
      <div class="container-fluid">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="dashboard.php" style="color: #88d317; ">Order 66</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="dashboard.php">Dashboard</a></li>
            <li><a href="faq.php">Help</a></li>
            <li><a href="logout.php">Log out</a></li>
          </ul>
          <form class="navbar-form navbar-right">
            <input type="text" class="form-control" placeholder="Search...">
          </form>
        </div>
      </div>
    </nav>

    <div class="container-fluid">
      <div class="row">
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="dashboard.php">Overview <span class="sr-only">(current)</span></a></li>
            <li><a href="#">Reports</a></li>
            <li><a href="#">Analytics</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="dashboard_employee.php">Employee Overview</a></li>
            <li><a href="dashboard_employee.php">+ Add New Employee</a></li>
            <li><a href="dashboard_employee.php">- Remove Employee</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li class="active"><a href="">Menu Overview</a></li>
            <li><a href="">+ Add Menu Item</a></li>
            <li><a href="">- Remove Menu Item</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Dashboard</h1>

          <div class="row placeholders">
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Most Popular Menu Item</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Busiest Time Of Day</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Weekly Takings</h4>
              <span class="text-muted">Something else</span>
            </div>
            <div class="col-xs-6 col-sm-3 placeholder">
              <img src="data:image/gif;base64,R0lGODlhAQABAIAAAHd3dwAAACH5BAAAAAAALAAAAAABAAEAAAICRAEAOw==" width="200" height="200" class="img-responsive" alt="Generic placeholder thumbnail">
              <h4>Yearly Takings</h4>
              <span class="text-muted">Something else</span>
            </div>
          </div>

          <h2 class="sub-header">Menu Overview</h2>

          <h3 class="">Menu</h3>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Item Name</th>
                  <th>Description</th>
                  <th>Price</th>
                </tr>
              </thead>
              <tbody>
                <?php echo $dataRow; ?>
              </tbody>
            </table>
          </div>

          <div class="col-lg-6">
            <h3 class="text-center">Add Menu Item</h3>
            <form name="add_Menu_Item" method="post" action="add_Menu_Item.php">
              <div class="row">
                <div class="form-group">
                  <div class="col-lg-offset-2 col-lg-4"><label for="item_name">Item Name</label></div>
                  <div class="col-lg-6"><input type="Text" name="item_name"></div>
                </div>
              </div>
              <div class="row">
                <div class="form-group">
                  <div class="col-lg-offset-2 col-lg-4"><label for="item_description">Item Description</label></div>
                  <div class="col-lg-6"><input type="Text" name="item_description"></div>
                </div>
              </div>
              <div class="row">
                <div class="form-group">
                  <div class="col-lg-offset-2 col-lg-4"><label for="item_description">Item Price</label></div>
                  <div class="col-lg-6"><input type="Text" name="item_description"></div>
                </div>
              </div>
              <div class="row">
                <div class="form-group">
                  <div class="col-lg-offset-2 col-lg-4"><label for="item_description">Item Catagory</label></div>
                  <div class="col-lg-6">
                    <select id="item_catagory" name="item_catagory">
                      <option value="Starters">Starters</option>
                      <option value="Mains">Mains</option>
                      <option value="Desserts">Desserts</option>
                      <option value="Sides">Sides</option>
                    </select>
                  </div>
                </div>
              </div>
            </form>

          </div>

          <div class="col-lg-6">
            <h3 class="text-center">Remove Menu Item</h3>
            <form name="add_Menu_Item" method="post" action="add_Menu_Item.php">
              <div class="row">
                <div class="form-group">
                  <div class="col-lg-offset-2 col-lg-4"><label for="item_name">Item Name</label></div>
                  <div class="col-lg-6"><input type="Text" name="item_name"></div>
                </div>
              </div>
              <div class="row">
                <div class="form-group">
                  <div class="col-lg-offset-2 col-lg-4"><label for="item_description">Item Price</label></div>
                  <div class="col-lg-6"><input type="Text" name="item_description"></div>
                </div>
              </div>
              <div class="row">
                <div class="form-group">
                  <div class="col-lg-offset-2 col-lg-4"><label for="item_description">Item Catagory</label></div>
                  <div class="col-lg-6">
                    <input list="item_catagory" name="item_catagory">
                    <datalist id="item_catagory">
                      <option value="Starters">
                      <option value="Mains">
                      <option value="Desserts">
                      <option value="Sides">
                    </datalist>
                  </div>
                </div>
              </div>
            </form>

          </div>

        </div>
      </div>
    </div>

    <!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="bootstrap-3.3.7-dist/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <!-- Just to make our placeholder images work. Don't actually copy the next line! -->
    <script src="../bootstrap-3.3.7-dist/js/vendor/holder.min.js"></script>
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="../bootstrap-3.3.7-dist/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
