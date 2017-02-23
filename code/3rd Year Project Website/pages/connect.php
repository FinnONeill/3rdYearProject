<?php

$servername = "posApp_server";
$dbusername = "root";
$dbpassword = "";
$dbname = "posapp_database";

$company_name = $_POST['company_name'];
$company_tel = $_POST['company_tel'];
$company_address1 = $_POST['company_address1'];
$company_address2 = $_POST['company_address2'];
$company_address3 = $_POST['company_address3'];

$employer_name = $_POST['employer_name'];
//$company_name = $_POST['company_name'];
$employer_tel = $_POST['employer_tel'];
$employer_email = $_POST['employer_email'];
$employer_address1 = $_POST['employer_address1'];
$employer_address2 = $_POST['employer_address2'];
$employer_address3 = $_POST['employer_address3'];

//create connection
$conn = new mysqli($servername, $dbusername, $dbpassword, $dbname);

//check connection
if($conn->connect_error){
	die("Connection failed: " . $conn->connect_error);
}

if(empty($company_name)){
	echo "Company Name is blank";
	die();
}

if(empty($company_tel)){
	echo "Company telephone is blank";
	die();
}

if(empty($company_address1)){
	echo "Company address is blank";
	die();
}

if(empty($company_address2)){
	echo "Line 2 is blank";
	die();
}

if(empty($company_address3)){
	echo "Line 3 is blank";
	die();
}

if(empty($employer_name)){
	echo "Employer Name is blank";
	die();
}

if(empty($employer_tel)){
	echo "Employer telephone is blank";
	die();
}

if(empty($employer_email)){
	echo "Company Email is blank";
	die();
}

$sql = "INSERT INTO company_members (company_name, company_tel, company_address1, company_address2, company_address3) values ('$company_name','$company_tel','$company_address1','$company_address2','$company_address3')";

if($conn->query($sql) === FALSE){
	echo "Error: " . $sql . "<br>" . $conn->error;
} 

$sql = "INSERT INTO employers_details (employer_name, company_name, employer_tel, employers_email, employers_address1, employers_address2, employers_address3,   employers_password) values ('$employer_name', '$company_name','$employer_tel', '$employer_email', '$employer_address1', '$employer_address2', '$employer_address3', '123456Employer')";

if($conn->query($sql) === TRUE){
	echo "Thank you for joining our POS App!";
	header("location: ./dashboard.html");
}else{
	echo "Error: " . $sql . "<br>" . $conn->error;
} 

$conn->close();

?>