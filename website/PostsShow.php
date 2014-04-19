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

	
	
	
	
	
	
	
	$query = "SELECT * FROM " . $postTable . " WHERE threadID = " . $_GET['tID'] . " ORDER BY postID";
	
	$result = mysqli_query($connect,$query);
	//WHERE threadID = COOKIE[threadID]

	
	
	
	
	
	
	
	echo "<table border='1'>";
	echo "<tr>";
	
	echo "<th>Thread ID</th>";
	echo "<th>Post ID</th>";
	echo "<th>User ID</th>";
	echo "<th>User Name</th>";
	echo "<th>Content</th>";
	
	echo "</tr>";
	
	while($row = mysqli_fetch_array($result))
	{
	    echo "<tr>";
	    
	    echo "<td>" . $row['threadID'] . "</td>";
	    echo "<td>" . $row['postID'] . "</td>";
	    echo "<td>" . $row['userID'] . "</td>";
	    echo "<td>" . $row['userName'] . "</td>";
	    echo "<td>" . $row['postContent'] . "</td>";
	    
	    echo "</tr>";
	}
	echo "</table>";
	
	
	
	//@Debugging
	//echo $_COOKIE[uID];
	//include 'Functions.php';
	//whatIsVisible();
	
	

	mysqli_close($connect);
?>

