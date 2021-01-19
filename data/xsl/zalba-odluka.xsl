<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:zo="http://www.pijz.rs/zalba-odluka" version="2.0">

    <xsl:import href="common.xsl"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>zalba-odluka</title>
            </head>

            <body>
                <div>
                    <div>
                        <i>ID: </i>
                        <xsl:value-of select="zo:ZalbaOdluka/@id"/>
                    </div>
                    <div>
                        <i>Broj: </i>
                        <xsl:value-of select="zo:ZalbaOdluka/@broj"/>
                    </div>
                    <div>
                        <i>Datum: </i>
                        <xsl:value-of select="zo:ZalbaOdluka/@datum"/>
                    </div>
                    <div>
                        <i>Datum zahteva: </i>
                        <xsl:value-of select="zo:ZalbaOdluka/@datum_zahteva"/>
                    </div>
                </div>
                <div>
                    <h1>zalba-odluka</h1>
                    <div>
                        <strong>Predmet: </strong> 
                        <xsl:value-of select="zo:ZalbaOdluka/zo:predmet"/>
                    </div>
                    <div>
                        <strong>Kome je upucena: </strong>
                        <xsl:value-of select="zo:ZalbaOdluka/zo:kome_je_upucena/zo:naziv"/>
                        <xsl:call-template name="Adresa">
                            <xsl:with-param name="adresa" select="zo:ZalbaOdluka/zo:kome_je_upucena/zo:adresa_za_postu"/>
                        </xsl:call-template>
                    </div>
                    <div>
                        <strong>Zalilac: </strong>
                        <xsl:call-template name="FizickoLice">
                            <xsl:with-param name="fizickoLice" select="zo:ZalbaOdluka/zo:zalilac/zo:osoba_zalilac"/>
                        </xsl:call-template>
                        <xsl:value-of select="zo:ZalbaOdluka/zo:zalilac/zo:sediste_zalioca"/>
                        <xsl:value-of select="zo:ZalbaOdluka/zo:zalilac/zo:naziv"/>
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
                        <xsl:call-template name="FizickoLice">
                            <xsl:with-param name="fizickoLice" select="zo:ZalbaOdluka/zo:podnosilac_zalbe/zo:osoba"/>
                        </xsl:call-template>
                        <xsl:value-of select="zo:ZalbaOdluka/zo:podnosilac_zalbe/zo:drugi_kontakt"/>
                        <xsl:value-of select="zo:ZalbaOdluka/zo:podnosilac_zalbe/zo:potpis"/>
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