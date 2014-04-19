<?php
	include 'globals.php';
	include 'Functions.php';
	
	
	
	$connect = mysqli_connect($host,$user,$pass,$db);
	
	// Check connection
	if (mysqli_connect_errno($connect))
	{
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	
        
        
        
        
        
        
	
	
	$threadCount = countThis($threadTable);
	
	
	//$userCount = countThis($userTable);
	
	$postCount = countThis($postTable);
	
        

	$sql = "INSERT INTO " . $threadTable . " (threadID, threadName, usersInThread, postsInThread)
	VALUES
	('$threadCount', '$_POST[postSubject]', '1', '1');";




	$result = mysqli_query($connect, $sql);
	
	
	//if (!mysqli_query($connect,$sql))
	if (!$result)
	{
	    die('Error: ' . mysqli_error($connect));
	}
	//echo "1 record added";

	
	
	
	
	
	
	
	//$postCount = countThis($postTable);
	
	
	
	
	
	
	
	
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
	('$threadCount', '$postCount', '$_POST[postSubject]', '$_COOKIE[uID]', '$foundName');";



	$result = mysqli_query($connect, $sql);
	
	
	//if (!mysqli_query($connect,$sql))
	if (!$result)
	{
	    die('Error: ' . mysqli_error($connect));
	}
	//echo "1 record added";
	
	
	
	
	
	
	
	



	
	mysqli_close($connect);
	
	
	
	//header('Location: https://cin.kc8khl.net/cardinalCodefest2014/postsFront.php');
	//header('Location: http://localhost/ViewHome.php');
	
	//@HostError
	//header('Location: http://androidtesting.x10host.com/ViewHome.php');
	
	//@HostError
	$url = 'ViewHome.php';
	echo '<META HTTP-EQUIV=Refresh CONTENT="0; URL='.$url.'">';
	
	
?>