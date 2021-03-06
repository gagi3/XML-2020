<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:cmn="http://www.pijz.rs/common"
    version="2.0"
>

    <xsl:template name="Adresa">
        <xsl:param name="adresa"/>
        <xsl:value-of select="$adresa/cmn:grad"/>, улица <xsl:value-of select="$adresa/cmn:ulica"/>&#160;<xsl:value-of select="$adresa/cmn:broj"/>
    </xsl:template>

    <xsl:template name="FizickoLiceSimple">
        <xsl:param name="fizickoLice"/>
        <xsl:value-of select="$fizickoLice/cmn:ime"/>&#160;<xsl:value-of select="$fizickoLice/cmn:prezime"/>
    </xsl:template>

    <xsl:template name="FizickoLice">
        <xsl:param name="fizickoLice"/>
        <fo:block>
            <fo:block> <xsl:value-of select="$fizickoLice/cmn:ime"/>&#160;<xsl:value-of select="$fizickoLice/cmn:prezime"/> </fo:block>
            <xsl:call-template name="Adresa">
                <xsl:with-param name="adresa" select="$fizickoLice/cmn:adresa"/>
            </xsl:call-template>
        </fo:block>
    </xsl:template>

    <xsl:template name="PravnoLiceSimple">
        <xsl:param name="pravnoLice"/>
        <fo:block>
            <xsl:value-of select="$pravnoLice/cmn:naziv"/><br/>
            <xsl:call-template name="Adresa">
                <xsl:with-param name="adresa" select="$pravnoLice/cmn:adresa"/>
            </xsl:call-template>
        </fo:block>
    </xsl:template>

    <xsl:template name="PravnoLice">
        <xsl:param name="pravnoLice"/>
        <xsl:value-of select="$pravnoLice/cmn:naziv"/> са седиштем у
        <xsl:call-template name="Adresa">
            <xsl:with-param name="adresa" select="$pravnoLice/cmn:adresa"/>
        </xsl:call-template>
    </xsl:template>

    <xsl:template name="Tuzba">
        <xsl:param name="tuzba"/>
        <fo:block text-align="justify">
            Против овог решења није допуштена жалба већ се, у складу са Законом о управним споровима, може покренути
            управни спор тужбом Управном суду у Београду, у року од <xsl:value-of select="$tuzba/cmn:rok"/> дана од дана пријема решења.
            Такса на тужбу износи <xsl:value-of select="$tuzba/cmn:taksa"/> динара. 
        </fo:block>
    </xsl:template>

</xsl:stylesheet>
