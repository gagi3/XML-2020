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
                    <div>
                        <i>ID: </i>
                        <xsl:value-of select="o:Obavestenje/@id"/>
                    </div>
                    <div>
                        <i>Broj: </i>
                        <xsl:value-of select="o:Obavestenje/@broj"/>
                    </div>
                    <div>
                        <i>Datum: </i>
                        <xsl:value-of select="o:Obavestenje/@datum"/>
                    </div>
                    <div>
                        <i>Datum zahtevanja: </i>
                        <xsl:value-of select="o:Obavestenje/@datum_zahtevanja"/>
                    </div>
                    <div>
                        <i>Datum uvida: </i>
                        <xsl:value-of select="o:Obavestenje/@datum_uvida"/>
                    </div>
                    <div>
                        <i>Vreme uvida [od]: </i>
                        <xsl:value-of select="o:Obavestenje/@vreme_uvida_od"/>
                    </div>
                    <div>
                        <i>Vreme uvida [do]: </i>
                        <xsl:value-of select="o:Obavestenje/@vreme_uvida_do"/>
                    </div>
                </div>
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