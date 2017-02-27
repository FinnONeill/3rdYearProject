<?php

	require_once("connect.php");
	$conn = connectToDatabase();

	session_start();

	if(isset($_SESSION['logged_in']) && $_SESSION['logged_in'] == true){
		header("Location: success.php");
	}

	if(isset($_POST['username']) && isset($_POST['password']) ){
		if($_POST['username'] == $username && $_POST['password'] == $password){
			$_SESSION['logged_in'] = true;
			header("Location: success.php");
		}
	}

	$conn->close();
?>