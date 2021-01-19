<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:r="http://www.pijz.rs/resenje" version="2.0">

    <xsl:import href="common.xsl"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>resenje</title>
            </head>

            <body>
                <div>
                    <div>
                        <i>ID: </i>
                        <xsl:value-of select="r:Resenje/@ID"/>
                    </div>
                    <div>
                        <i>Broj: </i>
                        <xsl:value-of select="r:Resenje/@broj"/>
                    </div>
                    <div>
                        <i>Datum zahteva: </i>
                        <xsl:value-of select="r:Resenje/@datum_zahteva"/>
                    </div>
                    <div>
                        <i>Datum zalbe: </i>
                        <xsl:value-of select="r:Resenje/@datum_zalbe"/>
                    </div>
                    <div>
                        <i>Datum postupka: </i>
                        <xsl:value-of select="r:Resenje/@datum_postupka"/>
                    </div>
                    <div>
                        <i>Tip: </i>
                        <xsl:value-of select="r:Resenje/@tip"/>
                    </div>
                </div>
                <div>
                    <h1>resenje</h1>
                    <div>
                        <strong>Trazilac: </strong> 
                        <xsl:call-template name="FizickoLice">
                            <xsl:with-param name="fizickoLice" select="r:Resenje/r:trazilac" />
                        </xsl:call-template>
                    </div>
                    <div>
                        <strong>Poverenik: </strong>
                        <xsl:call-template name="FizickoLice">
                            <xsl:with-param name="fizickoLice" select="r:Resenje/r:poverenik" />
                        </xsl:call-template>
                    </div>
                    <div>
                        <strong>Ustanova: </strong>
                        <xsl:call-template name="PravnoLice">
                            <xsl:with-param name="pravnoLice" select="r:Resenje/r:ustanova" />
                        </xsl:call-template>
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