<?php
	include 'globals.php';
?>

<?php

//connect to database
$connect = mysqli_connect($host,$user,$pass,$db);

//query
$query = "SELECT * FROM " . $postTable;
$result = mysqli_query($connect,$query);


//while($row=mysql_fetch_assoc($result))
while( $row = mysqli_fetch_array($result) )
{
	$output[] = $row;
}

// this will print the output in json
print(json_encode($output));

//close connection
mysqli_close($connect);

?>




