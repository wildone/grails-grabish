<!DOCTYPE html>
<html>
	<head>
		<meta name="layout" content="main"/>
		<title>Form</title>
	</head>
	<body>
        <g:form controller="NeighbourhoodFinder" action="save">
            <label>Website: </label>
            <g:textField name="website"/><br/>

            <g:actionSubmit value="Search"/>
        </g:form>
	</body>
</html>