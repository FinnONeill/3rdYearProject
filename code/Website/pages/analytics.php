<?php
  // Start the login session
  session_start();

  // Database information
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

  // Retrieve employee information from the database using the company_id
  $query = "SELECT employee_pps, employee_name, employee_tel, employee_email FROM employee_details WHERE company_id = '$company_id'";

  $result = $conn->query($query) or die (header("location: ./error.php"));

  // Add the employee information to the table
  $dataRow="";
  while($row = mysqli_fetch_array($result)){
    $dataRow = $dataRow."<tr><td>$row[0]</td><td>$row[1]</td><td>$row[2]</td><td>$row[3]</td></tr>";
  }
?>

<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>Order 66</title>
    <link rel="icon" href="../images/logo.ico">

    <!-- CSS -->
    <link href="../bootstrap-3.3.7-dist/css/bootstrap.min.css" rel="stylesheet">
    <link href="../css/dashboard.css" rel="stylesheet">

    <!-- JS for Charts-->
    <script type="text/javascript" src="https://www.gstatic.com/charts/loader.js"></script>

    <!-- Pie Chart for most popular item-->
    <script type="text/javascript">

      // Load the Visualization API and the corechart package.
      google.charts.load('current', {'packages':['corechart']});

      // Set a callback to run when the Google Visualization API is loaded.
      google.charts.setOnLoadCallback(drawChart);

      // Callback that creates and populates a data table,
      // instantiates the pie chart, passes in the data and
      // draws it.
      function drawChart() {

        // Create the data table.
        var data = new google.visualization.DataTable();
        data.addColumn('string', 'Topping');
        data.addColumn('number', 'Slices');
        data.addRows([
          ['Pizza', 507],
          ['Pasta', 239],
          ['Soup', 60],
          ['Roast Chicken', 587],
          ['Steak', 123],
          ['Selection of Ice-cream', 237]
        ]);

        // Set chart options
        var options = { title:"Most Popular Item",
                       'width':600,
                       'height':300};

        // Instantiate and draw our chart, passing in some options.
        var chart = new google.visualization.PieChart(document.getElementById('chart_div'));
        chart.draw(data, options);
      }
    </script>

    <script type="text/javascript">
      google.charts.load('current', {packages: ['corechart', 'bar']});
      google.charts.setOnLoadCallback(drawBasic);

      function drawBasic() {

            var data = new google.visualization.DataTable();
            data.addColumn('timeofday', 'Time of Day');
            data.addColumn('number', 'Number of Orders');

            data.addRows([
              [{v: [8, 0, 0], f: '8 am'}, 1],
              [{v: [9, 0, 0], f: '9 am'}, 2],
              [{v: [10, 0, 0], f:'10 am'}, 3],
              [{v: [11, 0, 0], f: '11 am'}, 4],
              [{v: [17, 0, 0], f: '12 pm'}, 5],
              [{v: [13, 0, 0], f: '1 pm'}, 6],
              [{v: [14, 0, 0], f: '2 pm'}, 7],
              [{v: [20, 0, 0], f: '3 pm'}, 8],
              [{v: [16, 0, 0], f: '4 pm'}, 9],
              [{v: [12, 0, 0], f: '5 pm'}, 10],
            ]);

            var options = { title:"Busiest Time Of Day",
              hAxis: {
                title: 'Time of Day',
                format: 'h:mm a',
                viewWindow: {
                  min: [7, 30, 0],
                  max: [20, 30, 0]
                }
              },
              vAxis: {
                title: 'Rating (scale of 1-10)'
              }
            };

            var chart = new google.visualization.ColumnChart(
              document.getElementById('busiest_tod'));

            chart.draw(data, options);
          }
    </script>

  </head>

  <body>

    <!--Navbar Start -->
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
    <!--Navbar End -->

    <div class="container-fluid">
      <div class="row">

        <!--Sidebar Start -->
        <div class="col-sm-3 col-md-2 sidebar">
          <ul class="nav nav-sidebar">
            <li><a href="dashboard.php">Overview <span class="sr-only">(current)</span></a></li>
            <li><a href="reporting.php">Reports</a></li>
            <li class="active"><a href="analytics.php">Analytics</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="dashboard_employee.php">Employee Overview</a></li>
            <li><a href="dashboard_employee.php">+ Add New Employee</a></li>
            <li><a href="dashboard_employee.php">- Remove Employee</a></li>
          </ul>
          <ul class="nav nav-sidebar">
            <li><a href="dashboard_menu.php">Menu Overview</a></li>
            <li><a href="dashboard_menu.php">+ Add Menu Item</a></li>
            <li><a href="dashboard_menu.php">- Remove Menu Item</a></li>
          </ul>
        </div>
        <!--Sidebar End -->

        <!--Content Start -->
        <div class="col-xs-offset-3 col-xs-8" style="margin-top: 10px;">
          <div class="panel panel-default">
            <div class="panel-heading text-center">
              <h2>Overview</h2>
            </div>
            <div class="panel-content">
                <table class="table">
                  <thead>
                    <th> </th>
                    <th># Sold</th>
                    <th>Profit per Transation</th>
                    <th>Most sold during</th>
                    <th>Sell by date</th>
                    <th># of Transactions</th>
                  </thead>
                  <tbody>
                    <tr>
                      <td>Roast Chicken</td>
                      <td>587</td>
                      <td>€4.50</td>
                      <td>11:36 - 18:50</td>
                      <td>26/03/2017</td>
                      <td>563</td>
                    </tr>
                    <tr>
                      <td>Pizza</td>
                      <td>507</td>
                      <td>€3.56</td>
                      <td>16:00 - 18:50</td>
                      <td>16/04/2017</td>
                      <td>498</td>
                    </tr>
                    <tr>
                      <td>Selection of Ice-cream</td>
                      <td>237</td>
                      <td>€0.50</td>
                      <td>19:36PM - 22:50PM</td>
                      <td>16/06/2017</td>
                      <td>203</td>
                    </tr>
                    <tr>
                      <td>Steak</td>
                      <td>123</td>
                      <td>€3.10</td>
                      <td>11:36 - 18:50</td>
                      <td>16/03/2017</td>
                      <td>121</td>
                    </tr>
                    <tr>
                      <td>Pasta</td>
                      <td>239</td>
                      <td>€5.50</td>
                      <td>16:36AM - 18:50PM</td>
                      <td>26/03/2017</td>
                      <td>226</td>
                    </tr>
                    <tr>
                      <td>Soup</td>
                      <td>60</td>
                      <td>€1.50</td>
                      <td>10:36AM - 15:50PM</td>
                      <td>26/03/2017</td>
                      <td>53</td>
                    </tr>
                  </tbody>
                </table>
            </div>
          </div>
        </div>
        <div class="col-xs-offset-3 col-xs-4">
          <div id="chart_div"></div>
        </div>
        <div class="col-xs-4">
          <div id="busiest_tod"></div>
        </div>
        <!--Content End -->


      </div>
    </div>

    <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
    <script>window.jQuery || document.write('<script src="bootstrap-3.3.7-dist/js/vendor/jquery.min.js"><\/script>')</script>
    <script src="../bootstrap-3.3.7-dist/js/bootstrap.min.js"></script>
    <script src="../bootstrap-3.3.7-dist/js/ie10-viewport-bug-workaround.js"></script>
  </body>
</html>
