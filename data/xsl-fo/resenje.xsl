<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:r="http://www.pijz.rs/resenje" 
    version="2.0"
>
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
                <fo:static-content flow-name="xsl-region-before">
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        ID: <xsl:value-of select="r:Resenje/@ID"/>
                    </fo:block>
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        Broj: <xsl:value-of select="r:Resenje/@broj"/>
                    </fo:block>
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        Datum zahteva: <xsl:value-of select="r:Resenje/@datum_zahteva"/>
                    </fo:block>
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        Datum zalbe: <xsl:value-of select="r:Resenje/@datum_zalbe"/>
                    </fo:block>
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        Datum postupka: <xsl:value-of select="r:Resenje/@datum_postupka"/>
                    </fo:block>
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        Tip: <xsl:value-of select="r:Resenje/@tip"/>
                    </fo:block>
                </fo:static-content>

                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        @TODO: [resenje]
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>

    </xsl:template>
</xsl:stylesheet>