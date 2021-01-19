<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:zc="http://www.pijz.rs/zalba-cutanje" version="2.0">

    <xsl:import href="common.xsl"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>zalba-cutanje</title>
            </head>

            <body>
                <div>
                    <div>
                        <i>ID: </i>
                        <xsl:value-of select="zc:ZalbaCutanje/@id"/>
                    </div>
                    <div>
                        <i>Broj: </i>
                        <xsl:value-of select="zc:ZalbaCutanje/@broj"/>
                    </div>
                    <div>
                        <i>Datum: </i>
                        <xsl:value-of select="zc:ZalbaCutanje/@datum"/>
                    </div>
                    <div>
                        <i>Datum zahteva: </i>
                        <xsl:value-of select="zc:ZalbaCutanje/@datum_zahteva"/>
                    </div>
                </div>
                <div>
                    <h1>zalba-cutanje</h1>
                    <div>
                        <strong>Predmet: </strong> 
                        <xsl:value-of select="zc:ZalbaCutanje/zc:predmet"/>
                    </div>
                    <div>
                        <strong>Kome je upucena: </strong>
                        <xsl:value-of select="zc:ZalbaCutanje/zc:kome_je_upucena/zc:naziv"/>
                        <xsl:call-template name="Adresa">
                            <xsl:with-param name="adresa" select="zc:ZalbaCutanje/zc:kome_je_upucena/zc:adresa_za_postu"/>
                        </xsl:call-template>
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
                        <xsl:call-template name="FizickoLice">
                            <xsl:with-param name="fizickoLice" select="zc:ZalbaCutanje/zc:podnosilac_zalbe/zc:osoba"/>
                        </xsl:call-template>
                        <xsl:value-of select="zc:ZalbaCutanje/zc:podnosilac_zalbe/zc:drugi_kontakt"/>
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