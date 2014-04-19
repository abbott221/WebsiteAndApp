<?php
    
    
    function countThis($tableName) {
	
	
	include 'globals.php';
	
	
	
	
	$connection = mysqli_connect($host,$user,$pass,$db);
	
	
	// Check connection
	if (mysqli_connect_errno($connection))
	{
	    echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	
	
	
	$counter = 0;
        $sql="SELECT * FROM " . $tableName;

        if ($result = mysqli_query($connection,$sql))
        {
            // Return the number of rows in result set
            $counter = mysqli_num_rows($result);
            
            //wut?
            mysqli_free_result($result);
        }
	
	$counter += 1;
	
	
	
	
	mysqli_close($connection);
	
	return $counter;
    }
    
    
    
    
    
    function makeNewPost($postedContent) {
	
	include 'globals.php';
	
	
	echo "check 1\n";
	
	$connection = mysqli_connect($host,$user,$pass,$db);
	
	
	// Check connection
	if ( mysqli_connect_errno($connection) ) {
	    echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	
	
	echo "check 2\n";
	
	$threadCount = countThis($threadTable);
	$postCount = countThis($postTable);
	
	echo "check 3\n";
	
	$sql = "INSERT INTO " . $postTable . " (threadID, postID, postContent, userID, userName)
	VALUES
	('$threadCount', '$postCount', '$postedContent', '$_COOKIE[uID]', '$foundName');";



	$result = mysqli_query($connection, $sql);
	
	echo "check 4\n";
	
	
	//if (!mysqli_query($connect,$sql))
	if (!$result) {
	    die('Error: ' . mysqli_error($connection));
	}
	
	echo "check 5\n";
	
	mysqli_close($connection);
	
	echo "check 6\n";
	
	return '1';
	
    }
    
    function whatIsVisible() {
	
	//posts are not visible
	echo $_POST[postSubject] . "lol\n";
	
	//cookies are visible
	echo $_COOKIE[uID] . "lol\n";
    }
    
    
?>

