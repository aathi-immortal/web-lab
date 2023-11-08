<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="/">
        <html>
            <head>

            </head>
            <body>
                <h1>Student Details</h1>
                <table>
                    <tr>
                        <th>ID</th>
                        <th>Name</th>
                        <th>Age</th>
                        <th>Grade</th>
                        <th>Address</th>
                    </tr>
                    <xsl:for-each select="students/student">
                        <tr>
                            <td>
                                <xsl:value-of select="id" />
                            </td>
                            <td>
                                <xsl:value-of select="name" />
                            </td>
                            <td>
                                <xsl:value-of select="age" />
                            </td>
                            <td>
                                <xsl:value-of select="grade" />
                            </td>
                            <td>
                                <xsl:value-of select="address/street" />
                                <xsl:text>, </xsl:text>
                                <xsl:value-of select="address/city" />
                                <xsl:text>, </xsl:text>
                                <xsl:value-of select="address/state" />
                                <xsl:text> - </xsl:text>
                                <xsl:value-of select="address/zip" />
                            </td>
                        </tr>
                    </xsl:for-each>
                </table>
            </body>
        </html>
    </xsl:template>
</xsl:stylesheet>