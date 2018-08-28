<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Teste</title>
</head>
<body>
    
    <form action="/enter" method="POST">
    	<input type="text" name="email" id="email"/>
    	<input type="password" name="password" id="password"/>
    	<button type="submit">Entrar</button>
    </form>
    
    <form action="/upload" method="POST" enctype="multipart/form-data">
 		<label for="file">Arquivo</label>
 		<input type="file" name="file" />
 		<input type="submit" name="submit" value="Upload" />
	</form>
    
</body>
</html>