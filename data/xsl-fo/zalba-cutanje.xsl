<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:zc="http://www.pijz.rs/zalba-cutanje"
    version="2.0"
>
    <xsl:template match="/">

        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="zalba-cutanje-page">
                    <fo:region-body margin="1in"/>
                    <fo:region-before extent="1in"/>
                    <fo:region-after extent="1in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="zalba-cutanje-page">
                <fo:static-content flow-name="xsl-region-before">
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        ID: <xsl:value-of select="zc:ZalbaCutanje/@id"/>
                    </fo:block>
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        Broj: <xsl:value-of select="zc:ZalbaCutanje/@broj"/>
                    </fo:block>
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        Datum: <xsl:value-of select="zc:ZalbaCutanje/@datum"/>
                    </fo:block>
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        Datum zahteva: <xsl:value-of select="zc:ZalbaCutanje/@datum_zahteva"/>
                    </fo:block>
                </fo:static-content>

                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        @TODO: [zalba-cutanje]
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>

    </xsl:template>
</xsl:stylesheet>