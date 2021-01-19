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
                        <xsl:for-each select="r:Resenje/r:dispozitiv/r:stav">
            				<xsl:call-template name="Stav">
                                <xsl:with-param name="stav" select="." />
                            </xsl:call-template>
            			</xsl:for-each>
                    </div>
                    <div>
                        <strong>Obrazlozenje: </strong>
                        <xsl:for-each select="r:Resenje/r:obrazlozenje/r:paragraf">
            				<xsl:call-template name="Paragraf">
                                <xsl:with-param name="paragraf" select="." />
                            </xsl:call-template>
            			</xsl:for-each>
                        <xsl:call-template name="Tuzba">
                            <xsl:with-param name="tuzba" select="r:Resenje/r:obrazlozenje/r:tuzba" />
                        </xsl:call-template>
                    </div>
                </div>
            </body>
        </html>

    </xsl:template>

    <xsl:template name="Stav">
        <xsl:param name="stav"/>
        <div>
            <i>Redni broj: </i>
            <xsl:value-of select="$stav/@redni_broj"/><br/>
            <div>
                <u>Dokument</u>: <xsl:value-of select="$stav/r:dokument/r:naziv"/> [rok obavestenja: <xsl:value-of select="$stav/r:rok_obavestenja"/>]
                <div>
                    <xsl:for-each select="$stav/r:dokument/r:informacija">
                        <li><xsl:value-of select="."/></li>
                    </xsl:for-each>
                </div>
            </div>
        </div>
    </xsl:template>

    <xsl:template name="Paragraf">
        <xsl:param name="paragraf"/>
        <p> <xsl:value-of select="."/> </p>
    </xsl:template>

</xsl:stylesheet>