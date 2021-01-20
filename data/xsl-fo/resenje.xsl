<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:r="http://www.pijz.rs/resenje" 
    version="2.0"
>
    <xsl:import href="common.xsl"/>
    
    <xsl:template match="/">

        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="resenje-page">
                    <fo:region-body margin="1in"/>
                    <fo:region-before extent="1in"/>
                    <fo:region-after extent="1in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="resenje-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block margin-top="10px" font-size="8px">
                        ID: <xsl:value-of select="r:Resenje/@ID"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Broj: <xsl:value-of select="r:Resenje/@broj"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Datum zahteva: <xsl:value-of select="r:Resenje/@datum_zahteva"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Datum zalbe: <xsl:value-of select="r:Resenje/@datum_zalbe"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Datum postupka: <xsl:value-of select="r:Resenje/@datum_postupka"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Tip: <xsl:value-of select="r:Resenje/@tip"/>
                    </fo:block>
                    <fo:block margin-top="20px">
                        <fo:block>
                            Trazilac:
                            <xsl:call-template name="FizickoLice">
                                <xsl:with-param name="fizickoLice" select="r:Resenje/r:trazilac" />
                            </xsl:call-template>
                        </fo:block>
                        <fo:block>
                            Poverenik:
                            <xsl:call-template name="FizickoLice">
                                <xsl:with-param name="fizickoLice" select="r:Resenje/r:poverenik" />
                            </xsl:call-template>
                        </fo:block>
                        <fo:block>
                            Ustanova:
                            <xsl:call-template name="PravnoLice">
                                <xsl:with-param name="pravnoLice" select="r:Resenje/r:ustanova" />
                            </xsl:call-template>
                        </fo:block>
                        <fo:block>
                            Dispozitiv:
                            <xsl:for-each select="r:Resenje/r:dispozitiv/r:stav">
                                <xsl:call-template name="Stav">
                                    <xsl:with-param name="stav" select="." />
                                </xsl:call-template>
                            </xsl:for-each>
                        </fo:block>
                        <fo:block>
                            Obrazlozenje:
                            <xsl:for-each select="r:Resenje/r:obrazlozenje/r:paragraf">
                                <xsl:call-template name="Paragraf">
                                    <xsl:with-param name="paragraf" select="." />
                                </xsl:call-template>
                            </xsl:for-each>
                            <xsl:call-template name="Tuzba">
                                <xsl:with-param name="tuzba" select="r:Resenje/r:obrazlozenje/r:tuzba" />
                            </xsl:call-template>
                        </fo:block>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>

    </xsl:template>

    <xsl:template name="Stav">
        <xsl:param name="stav"/>
        <fo:block>
            Redni broj:
            <xsl:value-of select="$stav/@redni_broj"/><br/>
            <fo:block>
                Dokument: <xsl:value-of select="$stav/r:dokument/r:naziv"/> [rok obavestenja: <xsl:value-of select="$stav/r:rok_obavestenja"/>]
                <fo:block>
                    <xsl:for-each select="$stav/r:dokument/r:informacija">
                        <xsl:value-of select="."/>
                    </xsl:for-each>
                </fo:block>
            </fo:block>
        </fo:block>
    </xsl:template>

    <xsl:template name="Paragraf">
        <xsl:param name="paragraf"/>
        <xsl:value-of select="."/>
    </xsl:template>

</xsl:stylesheet>