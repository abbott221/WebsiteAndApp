<!DOCTYPE html>

<html>
<head>
	<link type="text/css" rel="stylesheet" href="stylesheet.css"/>
	<title>Title goes here</title>
</head>

<body>



<?php include 'PostsShow.php'; ?>



<!-- Type for input can be password, text, or submit -->




<div id="forms">
	
	
	<?php
	//$formCall = "PostsForm.php?tID=" . $_GET['tID'];
	echo "<form method=\"post\" action=\"PostsForm.php?tID=" . $_GET['tID'] . "\">";
	//<form method="post" action="PostsForm.php">
	?>
	
	Post content: <input name="pContent" type="text" /><br>
	<input name="submit" type="submit" />
	</form>
</div>



<!-- <a href="ViewHome.php">Return</a> -->
<!-- <a href="http://androidtesting.x10host.com/ViewHome.php">Return</a> -->

<?php
//$formCall = "PostsForm.php?tID=" . $_GET['tID'];
echo "<a href=\"http://" . $websiteURL . "/ViewHome.php\">Return</a>";
//<form method="post" action="PostsForm.php">
?>





</body>

</html>