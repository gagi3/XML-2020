<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:zo="http://www.pijz.rs/zalba-odluka"
    version="2.0"
>
    <xsl:import href="common.xsl"/>

    <xsl:template match="/">

        <fo:root>
            <fo:layout-master-set>
                <fo:simple-page-master master-name="zalba-odluka-page">
                    <fo:region-body margin="1in"/>
                    <fo:region-before extent="1in"/>
                    <fo:region-after extent="1in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="zalba-odluka-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block margin-top="10px" font-size="8px">
                        ID: <xsl:value-of select="zo:ZalbaOdluka/@id"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Broj: <xsl:value-of select="zo:ZalbaOdluka/@broj"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Datum: <xsl:value-of select="zo:ZalbaOdluka/@datum"/>
                    </fo:block>
                    <fo:block margin-top="10px" font-size="8px">
                        Datum zahteva: <xsl:value-of select="zo:ZalbaOdluka/@datum_zahteva"/>
                    </fo:block>
                    <fo:block margin-top="20px">
                        <fo:block>
                            Predmet:
                            <xsl:value-of select="zo:ZalbaOdluka/zo:predmet"/>
                        </fo:block>
                        <fo:block>
                            Kome je upucena:
                            <xsl:value-of select="zo:ZalbaOdluka/zo:kome_je_upucena/zo:naziv"/>
                            <xsl:call-template name="Adresa">
                                <xsl:with-param name="adresa" select="zo:ZalbaOdluka/zo:kome_je_upucena/zo:adresa_za_postu"/>
                            </xsl:call-template>
                        </fo:block>
                        <fo:block>
                            Zalilac:
                            <xsl:call-template name="FizickoLice">
                                <xsl:with-param name="fizickoLice" select="zo:ZalbaOdluka/zo:zalilac/zo:osoba_zalilac"/>
                            </xsl:call-template>
                            <xsl:value-of select="zo:ZalbaOdluka/zo:zalilac/zo:sediste_zalioca"/>
                            <xsl:value-of select="zo:ZalbaOdluka/zo:zalilac/zo:naziv"/>
                        </fo:block>
                        <fo:block>
                            Donosilac odluke:
                            <xsl:value-of select="zo:ZalbaOdluka/zo:donosilac_odluke"/>
                        </fo:block>
                        <fo:block>
                            Broj resenja:
                            <xsl:value-of select="zo:ZalbaOdluka/zo:broj_resenja"/>
                        </fo:block>
                        <fo:block>
                            Godina resenja:
                            <xsl:value-of select="zo:ZalbaOdluka/zo:godina_resenja"/>
                        </fo:block>
                        <fo:block>
                            Razlog pobijanja:
                            <xsl:value-of select="zo:ZalbaOdluka/zo:razlog_pobijanja"/>
                        </fo:block>
                        <fo:block>
                            Podnosilac zalbe:
                            <xsl:call-template name="FizickoLice">
                                <xsl:with-param name="fizickoLice" select="zo:ZalbaOdluka/zo:podnosilac_zalbe/zo:osoba"/>
                            </xsl:call-template>
                            <xsl:value-of select="zo:ZalbaOdluka/zo:podnosilac_zalbe/zo:drugi_kontakt"/>
                            <xsl:value-of select="zo:ZalbaOdluka/zo:podnosilac_zalbe/zo:potpis"/>
                        </fo:block>
                        <fo:block>
                            Mesto podnosenja zalbe:
                            <xsl:value-of select="zo:ZalbaOdluka/zo:mesto_podnosenja_zalbe"/>
                        </fo:block>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>

    </xsl:template>
</xsl:stylesheet>