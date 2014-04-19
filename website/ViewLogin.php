<?php
    include 'globals.php';
    include 'Functions.php';
?>

<?php
	
	//include 'globals.php';
	
	
	//create connection and store the data for later use
	//host, username, password, dbname
	$connect = mysqli_connect($host,$user,$pass, $db);
	
	// Check connection
	if (mysqli_connect_errno($connect))
	{
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	
	
	
	
	
	$foundUser = false;
	$foundPass = false;
	
	
	$query = "SELECT * FROM " . $userTable;
	$result = mysqli_query($connect, $query);
	
	
	while ($row = mysqli_fetch_array($result))
	{
		if ($row['userName'] == $_POST['postUser'])
		{
			$foundUser = true;
			
			if ($row['userPassword'] == $_POST['postPass'])
			{
				$foundPass = true;
				
				//@HostError
				//setcookie("uID", $row['userID'], time()+3600);
				//echo '<META HTTP-EQUIV=Refresh CONTENT="0; URL='.$url.'">';
				echo "<script>";
				echo "document.cookie=\"uID=" . $row['userID'] . "\";";
				echo "</script>";
				
				
				//@HostError
				//header('Location: http://androidtesting.x10host.com/ViewHome.php');
				
				//header('Location: http://androidtesting.x10host.com/ViewHome.html');
				
				
				//$url = 'thepageyouwanttogoto.html';
				//echo '<META HTTP-EQUIV=Refresh CONTENT="0; URL='.$url.'">';
				//@HostError
				$url = 'ViewHome.php';
				echo '<META HTTP-EQUIV=Refresh CONTENT="0; URL='.$url.'">';
				
				//user and password combination found successfully
			}
		}
		
		//This would echo for every run through the
		//while loop that has an instance that isn't the user you are looking for
		//else
		//{
		//	echo "Incorrect password";
		//	
		//	include 'index.html';
		//}
	}
	
	
	if ($foundUser)
	{
	    if ($foundPass)
	    {
	        //setcookie("uID", $row['userID'], time()+3600);
		//header('Location: http://localhost/requestPage.html');
		//header('Location: http://localhost/ViewHome.php');
		
		
		//header('Location: http://androidtesting.x10host.com/ViewHome.php');
	    }
	    else
	    {
	        echo "Incorrect password";
		include 'index.html';
		
		//header('Location: http://localhost/index.html');
	    }
	}
	else
	{
	    echo "Incorrect username";
	    include 'index.html';
	    
	    //header('Location: http://localhost/index.html');
	}
	
	
	mysqli_close($connect);
?>