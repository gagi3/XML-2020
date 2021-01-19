<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:zo="http://www.pijz.rs/zalba-odluka" version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <title>zalba-odluka</title>
            </head>

            <body>
                <div>
                    <h1>zalba-odluka</h1>
                    <div>
                        <strong>Predmet: </strong> 
                        <xsl:value-of select="zo:ZalbaOdluka/zo:predmet"/>
                    </div>
                    <div>
                        <strong>Kome je upucena: </strong>
                        <xsl:value-of select="zo:ZalbaOdluka/zo:kome_je_upucena"/>
                    </div>
                    <div>
                        <strong>Zalilac: </strong>
                        <xsl:value-of select="zo:ZalbaOdluka/zo:zalilac"/>
                    </div>
                    <div>
                        <strong>Donosilac odluke: </strong>
                        <xsl:value-of select="zo:ZalbaOdluka/zo:donosilac_odluke"/>
                    </div>
                    <div>
                        <strong>Broj resenja: </strong>
                        <xsl:value-of select="zo:ZalbaOdluka/zo:broj_resenja"/>
                    </div>
                    <div>
                        <strong>Godina resenja: </strong>
                        <xsl:value-of select="zo:ZalbaOdluka/zo:godina_resenja"/>
                    </div>
                    <div>
                        <strong>Razlog pobijanja: </strong>
                        <xsl:value-of select="zo:ZalbaOdluka/zo:razlog_pobijanja"/>
                    </div>
                    <div>
                        <strong>Podnosilac zalbe: </strong>
                        <xsl:value-of select="zo:ZalbaOdluka/zo:podnosilac_zalbe"/>
                    </div>
                    <div>
                        <strong>Mesto podnosenja zalbe: </strong>
                        <xsl:value-of select="zo:ZalbaOdluka/zo:mesto_podnosenja_zalbe"/>
                    </div>
                </div>
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>