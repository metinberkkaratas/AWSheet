<?php
	$servername = "localhost";
	$username = "id8251698_root";
	$password = "123456";
	$dbname="id8251698_awsheet";
	$connect = mysqli_connect($servername, $username, $password) or die("Unable to Connect to '$dbhost'");
	mysqli_select_db($connect , $dbname) or die("Could not open the db '$dbname'");
	
    $ExamName = $_POST['ExamName'];
    $CourseCode = $_POST['coursecode'];
    $PercentGrade = $_POST['PercentGrade'];	
	
	$sql= "insert into coursegrade values=('".$CourseCode"','".$ExamName"','".$PercentGrade"') ";
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


