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
            <xsl:value-of select="$fizickoLice/cmn:Adresa"/>
        </div>
    </xsl:template>

    <xsl:template name="PravnoLice">
        <xsl:param name="pravnoLice"/>
        <div>
            <xsl:value-of select="$pravnoLice/cmn:naziv"/><br/>
            <xsl:value-of select="$pravnoLice/cmn:Adresa"/>
        </div>
    </xsl:template>

    <xsl:template name="Tuzba">
        <xsl:param name="tuzba"/>
        <div>
            <xsl:value-of select="$tuzba/cmn:rok"/><br/>
            <xsl:value-of select="$tuzba/cmn:taksa"/>
        </div>
    </xsl:template>

</xsl:stylesheet>
