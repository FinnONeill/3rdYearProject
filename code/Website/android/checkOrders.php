<?php
	
	// Server details
	$servername = "localhost";
	$dbusername = "root";
	$dbpassword = "";
	$dbname = "posapp_database";

	//create connection
	$conn = new mysqli($servername, $dbusername, $dbpassword, $dbname);

	//check connection
	if($conn->connect_error){
		die("Connection failed: " . $conn->connect_error);
	}

	// Get values from user
	$login_email = $_REQUEST['username'];
	$login_password = $_REQUEST['password'];

	// Query database for user
	$result = $conn->query("SELECT company_id FROM employee_details WHERE employee_email = '$login_email'") or die("Failed to query database ".$conn->connect_error);

	$row = mysqli_fetch_array($result);
	$company_id = $row['company_id'];

	// Query database for user
	$result = $conn->query("SELECT order_number, order_details, order_price, order_status FROM orders WHERE order_id = '$company_id' AND order_status='OPEN'") or die("Failed to query database ".$conn->connect_error);

	$menuItems = array();
	while($rowItem = mysqli_fetch_array($result)){
		$menuItems[] = $rowItem;
	}

	echo json_encode($menuItems);

	$conn->close();
?>