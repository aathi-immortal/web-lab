<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <!-- xslt -->
    <xsl:template match="/">
        <html>
            <table>
                <tr>
                    <th>Name</th>
                    <th>Cost</th>
                </tr>
                <!-- <xsl:for-each select="foods/food-items">
                    <tr>
                        <td>
                            <xsl:value-of select="name" />
                        </td>
                        <td>
                            <xsl:value-of select="cost" />
                        </td>
                    </tr>
                </xsl:for-each> -->
            </table>

        </html>
    </xsl:template>
</xsl:stylesheet>