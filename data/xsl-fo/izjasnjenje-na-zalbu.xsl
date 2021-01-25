<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:i="http://www.pijz.rs/izjasnjenje-na-zalbu"
    version="2.0"
>
    <xsl:template match="/">

        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="izjasnjenje-na-zalbu-page">
                    <fo:region-body margin="1in"/>
                    <fo:region-before extent="1in"/>
                    <fo:region-after extent="1in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="izjasnjenje-na-zalbu-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block margin-top="10px" font-size="8px">
                        ID: <xsl:value-of select="i:izjasnjenjeNaZalbu/@id"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Broj: <xsl:value-of select="i:izjasnjenjeNaZalbu/@broj"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Broj zalbe: <xsl:value-of select="i:izjasnjenjeNaZalbu/@broj_zalbe"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Datum izjave: <xsl:value-of select="i:izjasnjenjeNaZalbu/@datum_izjave"/>
                    </fo:block>
                    <fo:block margin-top="20px">
                        <fo:block>
                            Tekst izjave: <xsl:value-of select="i:izjasnjenjeNaZalbu/i:tekst_izjave"/>
                        </fo:block>
                        <fo:block> 
                            Saglasnost sa zalbom: <xsl:value-of select="i:izjasnjenjeNaZalbu/i:saglasnost_sa_zalbom"/>
                        </fo:block>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>

    </xsl:template>
</xsl:stylesheet>