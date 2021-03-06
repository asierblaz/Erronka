<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>
                <!-- Bootstrap CSS -->
                <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
                      integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
                      crossorigin="anonymous"></link>

                <style>
                    body {
                        background-image: url("patinhos.jpg");
                        height:80vh
                    }

                    .container{
                        margin-top: 20vh;
                        background-color: #ffffff;
                        border-radius: 30px;
                        border: 1px solid black;
                        height:60vh;
                    }

                    .scroll {
                        -ms-overflow-style: none;
                        height:36vh;
                        overflow-y: scroll;
                    }
                </style>
            </head>
            <title>Patinhos Gomosos</title>
            <body>
                <div class="container" style="">
                    <br/>
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
                    </table>

                    <div class="scroll">
                        <table class="table table-striped">
                            <tbody>
                                <xsl:for-each select="document/log/acceso">
                                    <tr>
                                        <td>
                                            <xsl:value-of select="@Date"/>
                                        </td>
                                        <td>
                                            <xsl:value-of select="."/>
                                        </td>
                                    </tr>
                                </xsl:for-each>
                            </tbody>
                        </table>
                    </div>
                </div>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>