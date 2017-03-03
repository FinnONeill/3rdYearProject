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
	$result = $conn->query("SELECT * FROM employers_details WHERE employers_email = '$login_email' AND employers_password = '$login_password' ") or die("Failed to query database ".$conn->connect_error);

	$row = mysqli_fetch_array($result);

	$_SESSION["company_id"] = $row['employer_id'];

	if($row['employers_email'] == $login_email && $row['employers_password'] == $login_password){
		header("location: ./dashboard.php");
	}else{
		echo("Incorrect email and password combination!");
	}
	
	$conn->close();

?>