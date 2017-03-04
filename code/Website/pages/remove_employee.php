<?php
	session_start();
	$servername = "localhost";
	$dbusername = "root";
	$dbpassword = "";
	$dbname = "posapp_database";

	$company_id = $_SESSION["company_id"];
	$employee_pps = $_POST['employee_pps'];
	$employee_name = $_POST['employee_name'];

	//create connection
	$conn = new mysqli($servername, $dbusername, $dbpassword, $dbname);

	//check connection
	if($conn->connect_error){
		die("Connection failed: " . $conn->connect_error);
	}

	if(empty($employee_pps)){
		echo "Employee PPS Number is blank";
		die();
	}

	if(empty($employee_name)){
		echo "Employee name is blank";
		die();
	}

	//Remove employee data into employee_details table
	$sql = "DELETE FROM employee_details WHERE company_id='$company_id' AND employee_pps='$employee_pps' AND employee_name='$employee_name'";

	//Send query and print error if it failed
	if($conn->query($sql) === FALSE){
		echo "Error: " . $sql . "<br>" . $conn->error;
	}else{
		header("location: ./dashboard_employee.php");
	}

	$conn->close();
?>