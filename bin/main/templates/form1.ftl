<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TP2</title>
</head>
<body>
	<form id="form-1" method="POST" action="/forms/form1">
		<p>
			<label for="offset">Offset</label> <input id="offset" type="range"
				name="offset" min="0" max="100"></input>
		</p>
		<p>
			<label for="tribe">Tribe</label> <input id="tribe" type="range"
				name="tribe" min="10" max="50" step="10"></input>
		</p>
		<p>
			<label for="email">Email</label> <input id="email" type="email"
				name="email"></input>
		</p>
		<p>
			<label for="number">Nombre d'item</label> <input id="number"
				type="number" name="nombreItem"></input>
		</p>
		<p>
			<label for="description">Description</label>
			<textarea id="description" name="description"
				placeholder="Votre texte ici" rows="2" cols="15"></textarea>
		</p>
		<p>
			<label for="appliqueA">Appliqué à</label> <input id="appliqueA"
				type="datetime-local" name="appliqueA"></input>
		</p>
		<p>
			<input type="submit" value="Valider"/>
		</p>
	</form>
</body>
</html>