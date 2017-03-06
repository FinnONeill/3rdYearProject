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
	$login_email = $_REQUEST['username'];
	$login_password = $_REQUEST['password'];

	// Query database for user
	$result = $conn->query("SELECT company_id FROM employee_details WHERE employee_email = '$login_email'") or die("Failed to query database ".$conn->connect_error);

	$row = mysqli_fetch_array($result);
	$company_id = $row['company_id'];

	// Query database for user
	$result = $conn->query("SELECT item_name, item_catagory, item_description, item_price FROM menu_details WHERE menu_id = '$company_id'") or die("Failed to query database ".$conn->connect_error);

	$menuItems = array();
	
	while($rowItem = mysqli_fetch_array($result)){
		$menuItems[] = $rowItem;
	}
	
	
	echo json_encode($menuItems[0][1]);

	$conn->close();
?>