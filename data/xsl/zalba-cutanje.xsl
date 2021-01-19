<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:zc="http://www.pijz.rs/zalba-cutanje" version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <title>zalba-cutanje</title>
            </head>

            <body>
                <div>
                    <h1>zalba-cutanje</h1>
                    <div>
                        <strong>Predmet: </strong> 
                        <xsl:value-of select="zc:ZalbaCutanje/zc:predmet"/>
                    </div>
                    <div>
                        <strong>Kome je upucena: </strong>
                        <xsl:value-of select="zc:ZalbaCutanje/zc:kome_je_upucena"/>
                    </div>
                    <div>
                        <strong>Protiv organa: </strong>
                        <xsl:value-of select="zc:ZalbaCutanje/zc:protiv_organa"/>
                    </div>
                    <div>
                        <strong>Razlog: </strong>
                        <xsl:value-of select="zc:ZalbaCutanje/zc:razlog"/>
                    </div>
                    <div>
                        <strong>Podaci o zahtevu: </strong>
                        <xsl:value-of select="zc:ZalbaCutanje/zc:podaci_o_zahtevu"/>
                    </div>
                    <div>
                        <strong>Podnosilac zalbe: </strong>
                        <xsl:value-of select="zc:ZalbaCutanje/zc:podnosilac_zalbe"/>
                    </div>
                    <div>
                        <strong>Mesto podnosenja zalbe: </strong>
                        <xsl:value-of select="zc:ZalbaCutanje/zc:mesto_podnosenja_zalbe"/>
                    </div>
                </div>
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>