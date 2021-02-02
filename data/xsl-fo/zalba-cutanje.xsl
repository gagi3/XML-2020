<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:zc="http://www.pijz.rs/zalba-cutanje"
    xmlns:cmn="http://www.pijz.rs/common"
    version="2.0"
>

    <xsl:import href="common.xsl"/>

    <xsl:template match="/">

        <fo:root font-family="Arial Unicode MS" font-size="10px">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="zalba-cutanje-page">
                    <fo:region-body margin="1in"/>
                    <fo:region-before extent="1in"/>
                    <fo:region-after extent="1in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="zalba-cutanje-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        <fo:block text-align="center"> <xsl:value-of select="zc:ZalbaCutanje/zc:predmet"/> </fo:block>
                        <fo:block margin-top="10px">
                            <xsl:value-of select="zc:ZalbaCutanje/zc:kome_je_upucena/zc:naziv"/>  
                            <fo:block>
                                Адреса за пошту: 
                                <xsl:call-template name="Adresa">
                                    <xsl:with-param name="adresa" select="zc:ZalbaCutanje/zc:kome_je_upucena/zc:adresa_za_postu"/>
                                </xsl:call-template>
                            </fo:block>
                        </fo:block>

                        <fo:block margin-top="20px"> У складу са чланом 22. Закона о слободном приступу информацијама од јавног значаја подносим: </fo:block>
                        <fo:block text-align="center">ЖАЛБУ</fo:block>
                        <fo:block text-align="center">против</fo:block>
                        <fo:block margin-top="10px">
                            <fo:inline text-decoration="underline"> <xsl:value-of select="zc:ZalbaCutanje/zc:protiv_organa"/> </fo:inline>
                            <fo:block margin-top="10px" text-align="center"> (навести назив органа) </fo:block>
                        </fo:block>
                        <fo:block margin-top="10px" text-align="center">
                            <fo:block> због тога што орган власти: </fo:block>
                            <fo:block>
                                <xsl:choose>
                                    <xsl:when test="zc:ZalbaCutanje/zc:razlog = 'organ_nije_postupio'">
                                        <fo:inline text-decoration="underline">није поступио</fo:inline> / није поступио у целости / у законском року
                                    </xsl:when>
                                    <xsl:when test="zc:ZalbaCutanje/zc:razlog = 'organ_nije_postupio_u_celosti'">
                                        није поступио / <fo:inline text-decoration="underline">није поступио у целости</fo:inline> / у законском року
                                    </xsl:when>
                                    <xsl:when test="zc:ZalbaCutanje/zc:razlog = 'organ_nije_postupio_u_zakonskom_roku'">
                                        није поступио / није поступио у целости / <fo:inline text-decoration="underline">у законском року</fo:inline>
                                    </xsl:when>
                                    <xsl:otherwise>
                                        <u>није поступио</u> / није поступио у целости / у законском року
                                    </xsl:otherwise>
                                </xsl:choose>
                            </fo:block>
                            <fo:block> (подвући због чега се изјављује жалба) </fo:block>
                        </fo:block>
                        <fo:block margin-top="10px" text-align="justify">
                            по мом захтеву за слободан приступ информацијама од јавног значаја који сам поднео том органу 
                            дана <xsl:value-of select="zc:ZalbaCutanje/@datum_zahteva"/> годинe, а којим сам 
                            тражио/ла да ми се у складу са Законом о слободном приступу информацијама од јавног значаја омогући увид - копија 
                            документа који садржи информације о /у вези са :
                        </fo:block>
                        <fo:block margin-top="10px">
                            <fo:inline text-decoration="underline"> <xsl:value-of select="zc:ZalbaCutanje/zc:podaci_o_zahtevu"/> </fo:inline>
                            <fo:block margin-top="10px" text-align="center"> (навести податке о захтеву и информацији/ама) </fo:block>
                        </fo:block>

                        <fo:block margin-top="10px">На основу изнетог, предлажем да Повереник уважи моју жалбу и омогући ми приступ траженој/им информацији/ма.</fo:block>
                        <fo:block margin-top="10px">Као доказ, уз жалбу достављам копију захтева са доказом о предаји органу власти.</fo:block>
                        <fo:block margin-top="10px">Напомена:  Код жалбе због непоступању по захтеву у целости, треба приложити и добијени одговор органа власти.</fo:block>

                        <fo:block margin-top="20px" text-align="right">
                            <fo:block>
                                <fo:block text-decoration="underline" margin-top="10px">
                                    <xsl:call-template name="FizickoLiceSimple">
                                        <xsl:with-param name="fizickoLice" select="zc:ZalbaCutanje/zc:podnosilac_zalbe/zc:osoba"/>
                                    </xsl:call-template>
                                </fo:block>
                                <fo:block>
                                    Подносилац жалбе / Име и презиме
                                </fo:block>

                                <fo:block text-decoration="underline" margin-top="10px"> 
                                    <xsl:call-template name="Adresa">
                                        <xsl:with-param name="adresa" select="zc:ZalbaCutanje/zc:podnosilac_zalbe/zc:osoba/cmn:adresa"/>
                                    </xsl:call-template> 
                                </fo:block>
                                <fo:block>
                                    адреса
                                </fo:block>

                                <fo:block text-decoration="underline" margin-top="10px">
                                    <xsl:value-of select="zc:ZalbaCutanje/zc:podnosilac_zalbe/zc:drugi_kontakt"/>
                                </fo:block>
                                <fo:block>
                                    други контакт
                                </fo:block>
                            </fo:block>
                        </fo:block>
                    </fo:block>
                    <fo:block margin-top="20px">
                        <fo:block>
                            У <fo:inline text-decoration="underline"> <xsl:value-of select="zc:ZalbaCutanje/zc:mesto_podnosenja_zalbe/zc:grad"/> </fo:inline>, 
                            дана <fo:inline text-decoration="underline"> <xsl:value-of select="zc:ZalbaCutanje/zc:mesto_podnosenja_zalbe/zc:datum"/> </fo:inline> године
                        </fo:block>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>

    </xsl:template>
</xsl:stylesheet>