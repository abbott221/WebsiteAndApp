<!DOCTYPE html>

<html>
<head>
	<title>MedZapp</title>
	
	
</head>


<body>
    
    <div id="myForm1">
	<h2> Create Thread </h2>
	
	<form method="post" action="ThreadsForm.php">
	Subject: <input name="postSubject" type="text" /><br>
	<input class="submit" name="submit" type="submit" />
	</form>
	
    </div>
    
    
    <?php
    include 'ThreadsShow.php';
    
    ?>
    
    
    
    
</body>
</html>
