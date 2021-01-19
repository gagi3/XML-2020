<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:o="http://www.pijz.rs/obavestenje" version="2.0">

    <xsl:import href="common.xsl"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>obavestenje</title>
            </head>

            <body>
                <div>
                    <h1>obavestenje</h1>
                    <div>
                        <strong>Organ: </strong> 
                        <xsl:value-of select="o:Obavestenje/o:organ/o:naziv"/>
                        <xsl:call-template name="Adresa">
                            <xsl:with-param name="adresa" select="o:Obavestenje/o:organ/o:sediste"/>
                        </xsl:call-template>
                    </div>
                    <div>
                        <strong>Podnosilac: </strong>
                        <xsl:value-of select="o:Obavestenje/o:podnosilac"/>
                    </div>
                    <div>
                        <strong>Naslov: </strong> 
                        <xsl:value-of select="o:Obavestenje/o:naslov"/>
                    </div>
                    <div>
                        <strong>Podnaslov: </strong> 
                        <xsl:value-of select="o:Obavestenje/o:podnaslov"/>
                    </div>
                    <div>
                        <strong>Telo: </strong> 
                        <xsl:value-of select="o:Obavestenje/o:telo"/>
                    </div>
                    <div>
                        <strong>Podnozje: </strong> 
                        <xsl:value-of select="o:Obavestenje/o:podnozje"/>
                    </div>
                </div>
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>