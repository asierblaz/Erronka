<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
<xsl:template match="/">


<html> 

<head>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous"></link>
</head>
    <title>Hello, world!</title>

<body>
<div class="container"><br></br>
<h1>Pathinhos Gomosos</h1>
<br></br>
<h4>Log-a</h4>


  <table class="table table-striped">
    <thead>
      <tr>
        <th>Data</th>
        <th>Informazioa</th>
      </tr>
    </thead>
    <tbody>
	<xsl:for-each select="document/log/acceso">
      <tr>
        <td><xsl:value-of select="@Date" /></td>
        <td><xsl:value-of select="." /></td>
      </tr>
	  </xsl:for-each>
    </tbody>
  </table>
</div>

		


</body>
</html>
</xsl:template>
</xsl:stylesheet>