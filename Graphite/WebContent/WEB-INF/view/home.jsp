<html>
<head>
<title>Home</title>
</head>
<body>

	<P>The index search result is {{completeResult}}</P>

	<ul>
		{{#searchResult}}
		<li>{{id}} :  {{getSource}} </li>
		 {{/searchResult}}

	</ul>
	
	<ul>
	{{#searchResult.getSource.keySet}}
	<li>{{key}}</li>
	{{/searchResult.getSource.keySet}}
	</ul>

</body>
</html>
