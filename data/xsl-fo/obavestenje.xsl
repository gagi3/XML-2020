<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:o="http://www.pijz.rs/obavestenje" 
    version="2.0"
>
    <xsl:template match="/">

        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="obavestenje-page">
                    <fo:region-body margin="1in"/>
                    <fo:region-before extent="1in"/>
                    <fo:region-after extent="1in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="obavestenje-page">
                <fo:static-content flow-name="xsl-region-before">
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        ID: <xsl:value-of select="o:Obavestenje/@id"/>
                    </fo:block>
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        Broj: <xsl:value-of select="o:Obavestenje/@broj"/>
                    </fo:block>
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        Datum: <xsl:value-of select="o:Obavestenje/@datum"/>
                    </fo:block>
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        Datum zahtevanja: <xsl:value-of select="o:Obavestenje/@datum_zahtevanja"/>
                    </fo:block>
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        Datum uvida: <xsl:value-of select="o:Obavestenje/@datum_uvida"/>
                    </fo:block>
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        Vreme uvida [od]: <xsl:value-of select="o:Obavestenje/@vreme_uvida_od"/>
                    </fo:block>
                    <fo:block text-align="center" margin-top="20px" font-size="7px">
                        Vreme uvida [do]: <xsl:value-of select="o:Obavestenje/@vreme_uvida_do"/>
                    </fo:block>
                </fo:static-content>

                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        @TODO: [obavestenje]
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>

    </xsl:template>
</xsl:stylesheet>