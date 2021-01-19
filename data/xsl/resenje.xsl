<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:r="http://www.pijz.rs/resenje" version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <title>resenje</title>
            </head>

            <body>
                <div>
                    <h1>resenje</h1>
                    <div>
                        <strong>Trazilac: </strong> 
                        <xsl:value-of select="r:Resenje/r:trazilac"/>
                    </div>
                    <div>
                        <strong>Poverenik: </strong>
                        <xsl:value-of select="r:Resenje/r:poverenik"/>
                    </div>
                    <div>
                        <strong>Ustanova: </strong>
                        <xsl:value-of select="r:Resenje/r:ustanova"/>
                    </div>
                    <div>
                        <strong>Dispozitiv: </strong>
                        <xsl:value-of select="r:Resenje/r:dispozitiv"/>
                    </div>
                    <div>
                        <strong>Obrazlozenje: </strong>
                        <xsl:value-of select="r:Resenje/r:obrazlozenje"/>
                    </div>
                </div>
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>