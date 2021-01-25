<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:o="http://www.pijz.rs/obavestenje" 
    version="2.0"
>

    <xsl:import href="common.xsl"/>

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
                <fo:flow flow-name="xsl-region-body">
                    <fo:block margin-top="10px" font-size="8px">
                        ID: <xsl:value-of select="o:Obavestenje/@id"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Broj: <xsl:value-of select="o:Obavestenje/@broj"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Datum: <xsl:value-of select="o:Obavestenje/@datum"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Datum zahtevanja: <xsl:value-of select="o:Obavestenje/@datum_zahtevanja"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Datum uvida: <xsl:value-of select="o:Obavestenje/@datum_uvida"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Vreme uvida [od]: <xsl:value-of select="o:Obavestenje/@vreme_uvida_od"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Vreme uvida [do]: <xsl:value-of select="o:Obavestenje/@vreme_uvida_do"/>
                    </fo:block>
                    <fo:block margin-top="20px">
                        <fo:block>
                            Organ: 
                            <xsl:value-of select="o:Obavestenje/o:organ/o:naziv"/>
                            <xsl:call-template name="Adresa">
                                <xsl:with-param name="adresa" select="o:Obavestenje/o:organ/o:sediste"/>
                            </xsl:call-template>
                        </fo:block>
                        <fo:block>
                            Podnosilac:
                            <xsl:value-of select="o:Obavestenje/o:podnosilac"/>
                        </fo:block>
                        <fo:block>
                            Naslov:
                            <xsl:value-of select="o:Obavestenje/o:naslov"/>
                        </fo:block>
                        <fo:block>
                            Podnaslov:
                            <xsl:value-of select="o:Obavestenje/o:podnaslov"/>
                        </fo:block>
                        <fo:block>
                            Telo:
                            <xsl:value-of select="o:Obavestenje/o:telo"/>
                        </fo:block>
                        <fo:block>
                            Podnozje:
                            <xsl:value-of select="o:Obavestenje/o:podnozje"/>
                        </fo:block>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>

    </xsl:template>
</xsl:stylesheet>