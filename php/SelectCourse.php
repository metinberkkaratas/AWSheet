<?php
	$servername = "localhost";
	$username = "id8251698_root";
	$password = "123456";
	$dbname="id8251698_awsheet";
	$connect = mysqli_connect($servername, $username, $password) or die("Unable to Connect to '$dbhost'");
	mysqli_select_db($connect , $dbname) or die("Could not open the db '$dbname'");
	
	$mailAdress = $_POST['mailAdress'];
    $CourseCode = $_POST['coursecode'];
    $syllabus = $_POST['syllabus'];	
		
	$sql= "update course (Assistantmail,syllabus) set ('".mailAdress."','".syllabus"') where CourseCode = ('".coursecode"') ";
	$result = mysqli_query($connect ,$sql);
	$response = array();
	if($result){

    $response["success"] = 1;
    $response["message"] = "Attandance has been added!";

    echo json_encode($response);
  }
  else{

    $response["success"] = 0;
    $response["message"] = "Unsuccessful";

    echo json_encode($response);

  }
  
?>


