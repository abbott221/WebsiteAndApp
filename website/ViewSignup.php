<?php
    include 'globals.php';
    include 'Functions.php';
?>


<?php
	//create connection and store the data for later use
	//host, username, password, dbname
	$connect = mysqli_connect($host,$user,$pass, $db);
	
	// Check connection
	if (mysqli_connect_errno($connect))
	{
		echo "Failed to connect to MySQL: " . mysqli_connect_error();
	}
	
	
	
	//@BEGIN
	
	
	$uniqueName = true;
	
	$query = "SELECT * FROM " . $userTable;
	$result = mysqli_query($connect, $query);
	
	while ($row = mysqli_fetch_array($result))
	{
		if ($row['userName'] == $_POST['postUser2'])
		{
			$uniqueName = false;
		}
		
		
	}
	
	if ( $uniqueName )
	{
	    $userCount = 0;
            $sql = "SELECT * FROM " . $userTable;
	    
            if ($result = mysqli_query($connect,$sql))
            {
                // Return the number of rows in result set
                $userCount = mysqli_num_rows($result);
	        
                // Free result set
                
                //wut?
                mysqli_free_result($result);
            }
            
            
            
            
            
	    $sql = "INSERT INTO " . $userTable . " (userID, userName, userPassword)
	    VALUES
	    ('$userCount', '$_POST[postUser2]', '$_POST[postPass2]');";
	    $result = mysqli_query($connect, $sql);
	    
	    
	    //if (!mysqli_query($connect,$sql))
	    if (!$result)
	    {
	        die('Error: ' . mysqli_error($connect));
	    }
	    //echo "1 record added";
	    
	    
	    
	    //@END
	    
	    echo "Account successfully created";
	    include 'index.html';
	    
	}
	else
	{
	    echo "That username has already been used";
	    include 'index.html';
	    
	    //header('Location: http://localhost/index.html');
	}
	
	
	
	
	
	
	
	
	
	
	mysqli_close($connect);
	
	
	//header('Location: https://cin.kc8khl.net/cardinalCodefest2014/postsFront.php');
	
	
?>

