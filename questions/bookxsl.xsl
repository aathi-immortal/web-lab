<xsl:stylesheet version="1.0" xmlns:xsl="http://www.w3.org/1999/XSL/Transform">
    <xsl:template match="bookstore/book">
        <author>
            <xsl:value-of select="@author" />
        </author>
    </xsl:template>
</xsl:stylesheet>