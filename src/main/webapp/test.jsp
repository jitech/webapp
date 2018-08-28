<!DOCTYPE html>

<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Teste</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body class="body">

    <jsp:include page="header.jsp"/>
    
    <div class="content">
    	<form action="/upload" method="POST" enctype="multipart/form-data" style="width: 250px;">  
			<label for="file">Selecionar .jar</label>
			<input type="file" id="file" name="file" accept="jar/*">
 			<input type="submit" name="submit" value="Enviar"/>
		</form>
    </div>
    
    <jsp:include page="footer.jsp"/>
    
</body>
</html>