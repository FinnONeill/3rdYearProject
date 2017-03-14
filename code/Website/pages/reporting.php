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

    <!-- Line Chart for Yearly-->
    <script type="text/javascript">
      google.charts.load('current', {'packages':['corechart']});
      google.charts.setOnLoadCallback(drawChart);

      function drawChart() {
        var data = google.visualization.arrayToDataTable([
          ['Year', 'Income', 'Outcome'],
          ['2014',  5600,      1400],
          ['2015',  4170,      1460],
          ['2016',  5660,       3120],
          ['2017',  1030,      540]
        ]);

        var options = { title:"Annual Takings",
          curveType: 'function',
          legend: { position: 'bottom' }
        };

        var chart = new google.visualization.LineChart(document.getElementById('yearly_takings'));

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
            <li class="active"><a href="reporting.php">Reports</a></li>
            <li><a href="analytics.php">Analytics</a></li>
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
                    <th>Total</th>
                    <th>Revenue</th>
                    <th>Tax</th>
                    <th>Tip</th>
                    <th>Service Charge</th>
                    <th># of Transactions</th>
                  </thead>
                  <tbody>
                    <tr>
                      <td>Gross Payments</td>
                      <td>€4,866.50</td>
                      <td>€4,401.60</td>
                      <td>€464.90</td>
                      <td><font color="grey">€0.00</font></td>
                      <td>€5.20</td>
                      <td>53</td>
                    </tr>
                    <tr>
                      <td>Gross Refunds</td>
                      <td><font color="red">€-53.03</font></td>
                      <td><font color="red">€-47.77</font></td>
                      <td><font color="red">€-4.90</font></td>
                      <td><font color="grey">-</font></td>
                      <td><font color="grey">€0.00</font></td>
                      <td>4</td>
                    </tr>
                    <tr>
                      <td>Gross Credits</td>
                      <td><font color="red">€-5.03</font></td>
                      <td><font color="red">€-3.00</font></td>
                      <td><font color="red">€-0.90</font></td>
                      <td><font color="grey">-</font></td>
                      <td><font color="grey">-</font></td>
                      <td>1</td>
                    </tr>
                    <tr>
                      <td>Net</td>
                      <td>€4,803.93</td>
                      <td><font color="red">€4348.77</font></td>
                      <td>€459.08</td>
                      <td><font color="grey">€0.00</font></td>
                      <td>€5.20</td>
                      <td><font color="grey">-</font></td>
                    </tr>
                  </tbody>
                </table>
            </div>
          </div>
        </div>

        <div class="col-xs-offset-3 col-xs-8" style="margin-top: 10px;">
          <div class="panel panel-default">
            <div class="panel-heading text-center">
              <h2>Tender Status</h2>
            </div>
            <div class="panel-content">
                <table class="table">
                  <thead>
                    <th> </th>
                    <th>Payments Total</th>
                    <th>Refunds Total</th>
                    <th>Credits Total</th>
                    <th>Net Total</th>
                  </thead>
                  <tbody>
                    <tr>
                      <td>Check</td>
                      <td>€1,036.10</td>
                      <td><font color="grey">€0,00</font></td>
                      <td><font color="grey">€0.00</font></td>
                      <td>€1036.10</td>
                    </tr>
                    <tr>
                      <td>Cash</td>
                      <td>€3731.60</td>
                      <td><font color="red">€-36.38</font></td>
                      <td><font color="red">€-5.55</font></td>
                      <td>€3689.97</td>
                    </tr>
                    <tr>
                      <td>Credit Card</td>
                      <td>€405.03</td>
                      <td><font color="red">€-3.00</font></td>
                      <td><font color="red">€-0.90</font></td>
                      <td>€401.13</td>
                    </tr>
                  </tbody>
                </table>
            </div>
          </div>
        </div>

        <div class="col-xs-offset-3 col-xs-8">
          <div id="yearly_takings"></div>
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
