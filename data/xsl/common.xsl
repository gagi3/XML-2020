<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:cmn="http://www.pijz.rs/common" version="2.0">

    <xsl:template name="Adresa">
        <xsl:param name="adresa"/>
        <div>
            <xsl:value-of select="$adresa/cmn:grad"/><br/>
            <xsl:value-of select="$adresa/cmn:ulica"/><br/>
            <xsl:value-of select="$adresa/cmn:broj"/>
        </div>
    </xsl:template>

    <xsl:template name="FizickoLice">
        <xsl:param name="fizickoLice"/>
        <div>
            <xsl:value-of select="$fizickoLice/cmn:ime"/><br/>
            <xsl:value-of select="$fizickoLice/cmn:prezime"/><br/>
            <xsl:call-template name="Adresa">
                <xsl:with-param name="adresa" select="$fizickoLice/cmn:adresa"/>
            </xsl:call-template>
        </div>
    </xsl:template>

    <xsl:template name="PravnoLice">
        <xsl:param name="pravnoLice"/>
        <div>
            <xsl:value-of select="$pravnoLice/cmn:naziv"/><br/>
            <xsl:call-template name="Adresa">
                <xsl:with-param name="adresa" select="$pravnoLice/cmn:adresa"/>
            </xsl:call-template>
        </div>
    </xsl:template>

    <xsl:template name="Tuzba">
        <xsl:param name="tuzba"/>
        <p>
            Против овог решења није допуштена жалба већ се, у складу са Законом о управним споровима, може покренути
            управни спор тужбом Управном суду у Београду, у року од <xsl:value-of select="$tuzba/cmn:rok"/> дана од дана пријема решења.
            Такса на тужбу износи <xsl:value-of select="$tuzba/cmn:taksa"/> динара. 
        </p>
    </xsl:template>

</xsl:stylesheet>
