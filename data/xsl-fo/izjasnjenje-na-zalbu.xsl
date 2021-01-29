<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:i="http://www.pijz.rs/izjasnjenje-na-zalbu"
    version="2.0"
>
    <xsl:template match="/">

        <fo:root font-family="Arial Unicode MS">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="izjasnjenje-na-zalbu-page">
                    <fo:region-body margin="1in"/>
                    <fo:region-before extent="1in"/>
                    <fo:region-after extent="1in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="izjasnjenje-na-zalbu-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block margin-top="20px" text-align="center">
                        И З Ј А Ш Њ Е Њ Е
                    </fo:block>
                    <fo:block margin-top="20px" text-align="center">
                        број <xsl:value-of select="i:izjasnjenjeNaZalbu/@broj"/>
                        на жалбу број <xsl:value-of select="i:izjasnjenjeNaZalbu/@broj_zalbe"/>
                        датума <xsl:value-of select="i:izjasnjenjeNaZalbu/@datum_izjave"/>
                    </fo:block>
                    <fo:block margin-top="20px" text-align="justify">
                        <xsl:value-of select="i:izjasnjenjeNaZalbu/i:tekst_izjave"/>
                    </fo:block>
                    <fo:block margin-top="20px" text-align="justify"> 
                        <xsl:choose>
                            <xsl:when test="i:izjasnjenjeNaZalbu/i:saglasnost_sa_zalbom = 'true'">
                                Постоји сагласност са жалбом.
                            </xsl:when>
                            <xsl:otherwise>
                                Не постоји сагласност са жалбом.
                            </xsl:otherwise>
                        </xsl:choose>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>

    </xsl:template>
</xsl:stylesheet>