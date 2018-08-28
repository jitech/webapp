<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Teste</title>
</head>
<body>
    
    Bem vindo ${user.name}</body>
    
    <form action="/upload" method="POST" enctype="multipart/form-data" style="width: 250px; margin: 5px">
    
    	<link href="https://cdnjs.cloudflare.com/ajax/libs/ratchet/2.0.2/css/ratchet.css" rel="stylesheet"/>
		<label for="file" class="btn btn-primary btn-block btn-outlined">Selecionar .jar</label>
		<input type="file" id="file" name="file" accept="jar/*" style="display: none">

 		<input type="submit" name="submit" value="Enviar" class="btn btn-primary btn-block btn-outlined"/>
	</form>
    
</body>
</html>