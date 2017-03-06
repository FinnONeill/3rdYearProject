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

	// Get values from form
	$login_email = $_REQUEST['item_name'];
	$login_password = $_REQUEST['item_description'];
	$login_password = $_REQUEST['item_price'];

	// Query database for user
	$result = $conn->query("SELECT employee_email, password FROM employee_details WHERE employee_email = '$login_email'") or die("Failed to query database ".$conn->connect_error);

	$row = mysqli_fetch_array($result);
	$loginStatus= password_verify($login_password, $row['password']);;

	print($loginStatus);

	$conn->close();
?>