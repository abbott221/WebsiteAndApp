<?php
	include 'globals.php';
	include 'Functions.php';
	
	
	
	
	
	$connect = mysqli_connect($host,$user,$pass,$db);
	
	
	// Check connection
	if (mysqli_connect_errno($connect))
	{
	    echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}

	
	
	
	
	
	
	
	$query = "SELECT * FROM " . $threadTable . " ORDER BY threadID";
	
	$result = mysqli_query($connect,$query);
	//WHERE threadID = COOKIE[threadID]

	
	
	
	
	
	
	echo "<table border='1'>\n";
	echo "<tr>\n";
	
	//@RemoveLater
	echo "<th>Thread ID</th>\n";
	
	echo "<th>Thread Subject</th>\n";
	echo "<th>Users In Thread</th>\n";
	echo "<th>Posts In Thread</th>\n";
	echo "</tr>\n";
	
	while($row = mysqli_fetch_array($result))
	{
	    echo "<tr>\n";
	    echo "<td>" . $row['threadID'] . "</td>\n";
	    
	    //make this a link later
	    //<a href="http://www.w3schools.com/">Visit W3Schools</a>
	    echo "<td>";
	    echo "<a href=\"ViewThread.php?tID=" . $row['threadID'] . "\">";
	    echo "" . $row['threadName'] . "</a>";
	    echo "</td>\n";
	    
	    echo "<td>" . $row['usersInThread'] . "</td>\n";
	    echo "<td>" . $row['postsInThread'] . "</td>\n";
	    echo "</tr>";
	}
	echo "</table>\n";
	
	
	
	
	
	
	
	
	
	
	
	

	mysqli_close($connect);
?>

