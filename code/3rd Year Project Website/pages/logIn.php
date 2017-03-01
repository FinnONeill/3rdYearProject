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
	$login_email = $_POST['login_email'];
	$login_password = $_POST['login_password'];

	// SQL Injection prevention
	$login_email = stripcslashes($login_email);
	$login_password = stripcslashes($login_password);

	// Query database for user
	$result = $conn->query("SELECT * FROM employers_details WHERE employers_email = '$login_email'") or die("Failed to query database ".$conn->connect_error);

	$row = mysqli_fetch_array($result);

	if($row['employers_email'] == $login_email && password_verify($login_password,$row['employers_password'])){
		header("location: ./dashboard.html");
	}else{
		echo("Incorrect email and password combination!");
	}
	
	$conn->close();

?>