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

	$login_email = $_REQUEST['username'];
	$login_password = $_REQUEST['password'];

	// Query database for user
	$result = $conn->query("SELECT company_id FROM employee_details WHERE employee_email = '$login_email'") or die("Failed to query database ".$conn->connect_error);

	$row = mysqli_fetch_array($result);
	$company_id = $row['company_id'];

	// Get values from form
	$order_number = $_REQUEST['order_number'];
	$order_details = $_REQUEST['order_details'];
	$order_price = $_REQUEST['order_price'];

	// Query database for user
	$result = "INSERT INTO orders(order_id, order_number ,order_details, order_price) VALUES ('$company_id','$order_number','$order_details','$order_price')";

	//Send query and print error is it failed
	if($conn->query($result) === FALSE){
		echo "Error: " . $result . "<br>" . $conn->error;
	}else{
		echo(TRUE);
	}

	$conn->close();
?>