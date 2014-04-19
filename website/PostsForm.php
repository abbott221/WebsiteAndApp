<?php
	include 'globals.php';
?>

<?php
	$connect = mysqli_connect($host,$user,$pass,$db);
	
	// Check connection
	if (mysqli_connect_errno($connect))
	{
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	
        
        
        
        
        
        
        $postCount = 0;
        $sql="SELECT * FROM " . $postTable;

        if ($result=mysqli_query($connect,$sql))
        {
            // Return the number of rows in result set
            $postCount=mysqli_num_rows($result);
            //printf("Result set has %d rows.\n",$rowcount);
            // Free result set
            
            //wut?
            mysqli_free_result($result);
        }
        $postCount += 1;
        
        
        
        

	//get username for the uID
	$foundName = "";
	
	$query = "SELECT * FROM " . $userTable;
	$result = mysqli_query($connect, $query);
	
	while ($row = mysqli_fetch_array($result))
	{
		if ($row['userID'] == $_COOKIE['uID'])
		{
			$foundName = $row['userName'];
		}
		
	}
	
	
	
	
	
	
	
	
	
	$sql = "INSERT INTO " . $postTable . " (threadID, postID, postContent, userID, userName)
	VALUES
	('$_GET[tID]', '$postCount', '$_POST[pContent]', '$_COOKIE[uID]', '$foundName');";
	
	
	
	$result = mysqli_query($connect, $sql);
	
	
	//if (!mysqli_query($connect,$sql))
	if (!$result)
	{
	    die('Error: ' . mysqli_error($connect));
	}
	//echo "1 record added";
	
	//$param = $_POST[pContent];
	//makeNewPost( $param );
	
	
	
	
	
	
	
	
	
	
	mysqli_close($connect);
	
	
	
	//header('Location: https://cin.kc8khl.net/cardinalCodefest2014/postsFront.php');
	//$arriveHere = "Location: http://localhost/ViewThread.php?tID=" . $_GET[tID];
	
	
	//@HostError
	//$arriveHere = "Location: http://androidtesting.x10host.com/ViewThread.php?tID=" . $_GET[tID];
	//header($arriveHere);
	
	//@HostError
	$url = "ViewThread.php?tID=" . $_GET[tID];
	echo '<META HTTP-EQUIV=Refresh CONTENT="0; URL='.$url.'">';
	
	
	
?>