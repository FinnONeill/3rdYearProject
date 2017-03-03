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

  $query = "SELECT employee_pps, employee_name, employee_tel, employee_email, password FROM employee_details WHERE company_id = '$company_id'";

  $result = $conn->query($query) or die ("Failed to query database ".$conn->connect_error);

  $dataRow="";

  while($row = mysqli_fetch_array($result)){
    $dataRow = $dataRow."<tr><td>$row[0]</td><td>$row[1]</td><td>$row[2]</td><td>$row[3]</td><td>$row[4]</td><td>123 Abc Street, Town Name, Letterland.</td></tr>";
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
    <link rel="icon" href="../../favicon.ico">

    <title>Dashboard Template for Bootstrap</title>

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
          <a class="navbar-brand" href="#">Project name</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
          <ul class="nav navbar-nav navbar-right">
            <li><a href="#">Dashboard</a></li>
            <li><a href="#">Profile</a></li>
            <li><a href="#">Help</a></li>
            <li><a href="../index.php">Homepage</a></li>
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
            <li class="active"><a href="#">Overview <span class="sr-only">(current)</span></a></li>
            <li><a href="#">Reports</a></li>
            <li><a href="#">Analytics</a></li>
            <li><a href="#">Export</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="dashboard_employee.php">Employee Overview</a></li>
            <li><a href="dashboard_employee.php">+ Add New Employee</a></li>
            <li><a href="dashboard_employee.php">- Remove Employee</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="">Menu Overview</a></li>
            <li><a href="">+ Add Menu Item</a></li>
            <li><a href="">- Remove Menu Item</a></li>
          </ul>
        </div>
        <div class="col-sm-9 col-sm-offset-3 col-md-10 col-md-offset-2 main">
          <h1 class="page-header">Employee Overview</h1>

          <div class="col-lg-6">
            <h2 class="sub-header text-center">Add Employee</h2>
            <form name="add_employee" method="post" action="add_employee.php">
            
            <div class="row">
              <div class="form-group">
                <div class="col-lg-offset-2 col-lg-4"><label for="employee_pps">Employee PPS Number</label></div>
                <div class="col-lg-6"><input type="Number" name="employee_pps"></div>
              </div>
            </div>

            <div class="row">
              <div class="form-group">
                <div class="col-lg-offset-2 col-lg-4"><label for="employee_name">Employee Name</label></div>
                <div class="col-lg-6"><input type="text" name="employee_name"></div>
              </div>
            </div>

            <div class="row">
              <div class="form-group">
                <div class="col-lg-offset-2 col-lg-4"><label for="employee_tel">Employee Tel</label></div>
                <div class="col-lg-6"><input type="Number" name="employee_tel"></div>
              </div>
            </div>
            
            <div class="row">
              <div class="form-group">
                <div class="col-lg-offset-2 col-lg-4"><label for="employee_email">Employee Email</label></div>
                <div class="col-lg-6"><input type="Email" name="employee_email"></div>
              </div>
            </div>

            <div class="row">
              <div class="form-group">
                <div class="col-lg-offset-2 col-lg-4"><label for="password">Password</label></div>
                <div class="col-lg-6"><input type="Password" name="password"></div>
              </div>
            </div>

            </form>
          </div>

          <div class="col-lg-6">
            <h2 class="sub-header text-center">Remove Employee</h2>
            <form name="add_employee" method="post" action="add_employee.php">
            
            <div class="row">
              <div class="form-group">
                <div class="col-lg-offset-2 col-lg-4"><label for="employee_pps">Employee PPS Number</label></div>
                <div class="col-lg-6"><input type="Number" name="employee_pps"></div>
              </div>
            </div>

            <div class="row">
              <div class="form-group">
                <div class="col-lg-offset-2 col-lg-4"><label for="employee_name">Employee Name</label></div>
                <div class="col-lg-6"><input type="text" name="employee_name"></div>
              </div>
            </div>

            </form>
          </div>

          <div class="col-lg-12">
            <h2 class="sub-header">Employee's</h2>
          <div class="table-responsive">
            <table class="table table-striped">
              <thead>
                <tr>
                  <th>Employee Number</th>
                  <th>Name</th>
                  <th>Phone Number</th>
                  <th>Email</th>
                  <th>Address</th>
                </tr>
              </thead>
              <tbody>
                <?php echo $dataRow; ?>
              </tbody>
            </table>
          </div>
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
