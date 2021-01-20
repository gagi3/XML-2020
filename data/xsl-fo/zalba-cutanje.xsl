<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:zc="http://www.pijz.rs/zalba-cutanje"
    version="2.0"
>

    <xsl:import href="common.xsl"/>

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
                <fo:flow flow-name="xsl-region-body">
                    <fo:block margin-top="10px" font-size="8px">
                        ID: <xsl:value-of select="zc:ZalbaCutanje/@id"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Broj: <xsl:value-of select="zc:ZalbaCutanje/@broj"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Datum: <xsl:value-of select="zc:ZalbaCutanje/@datum"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Datum zahteva: <xsl:value-of select="zc:ZalbaCutanje/@datum_zahteva"/>
                    </fo:block>
                    <fo:block margin-top="20px">
                        <fo:block>
                            Predmet:
                            <xsl:value-of select="zc:ZalbaCutanje/zc:predmet"/>
                        </fo:block>
                        <fo:block>
                            Kome je upucena:
                            <xsl:value-of select="zc:ZalbaCutanje/zc:kome_je_upucena/zc:naziv"/>
                            <xsl:call-template name="Adresa">
                                <xsl:with-param name="adresa" select="zc:ZalbaCutanje/zc:kome_je_upucena/zc:adresa_za_postu"/>
                            </xsl:call-template>
                        </fo:block>
                        <fo:block>
                            Protiv organa:
                            <xsl:value-of select="zc:ZalbaCutanje/zc:protiv_organa"/>
                        </fo:block>
                        <fo:block>
                            Razlog:
                            <xsl:value-of select="zc:ZalbaCutanje/zc:razlog"/>
                        </fo:block>
                        <fo:block>
                            Podaci o zahtevu:
                            <xsl:value-of select="zc:ZalbaCutanje/zc:podaci_o_zahtevu"/>
                        </fo:block>
                        <fo:block>
                            Podnosilac zalbe:
                            <xsl:call-template name="FizickoLice">
                                <xsl:with-param name="fizickoLice" select="zc:ZalbaCutanje/zc:podnosilac_zalbe/zc:osoba"/>
                            </xsl:call-template>
                            <xsl:value-of select="zc:ZalbaCutanje/zc:podnosilac_zalbe/zc:drugi_kontakt"/>
                        </fo:block>
                        <fo:block>
                            Mesto podnosenja zalbe:
                            <xsl:value-of select="zc:ZalbaCutanje/zc:mesto_podnosenja_zalbe"/>
                        </fo:block>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>

    </xsl:template>
</xsl:stylesheet>