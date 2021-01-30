<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:zo="http://www.pijz.rs/zalba-odluka"
    xmlns:cmn="http://www.pijz.rs/common"
    version="2.0"
>
    <xsl:import href="common.xsl"/>

    <xsl:template match="/">

        <fo:root font-family="Arial Unicode MS" font-size="10px">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="zalba-odluka-page">
                    <fo:region-body margin="1in"/>
                    <fo:region-before extent="1in"/>
                    <fo:region-after extent="1in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="zalba-odluka-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        <fo:block text-align="center"> <xsl:value-of select="zo:ZalbaOdluka/zo:predmet"/> </fo:block>
                        <fo:block margin-top="10px">
                            <xsl:value-of select="zo:ZalbaOdluka/zo:kome_je_upucena/zo:naziv"/>  
                            <fo:block>
                                Адреса за пошту: 
                                <xsl:call-template name="Adresa">
                                    <xsl:with-param name="adresa" select="zo:ZalbaOdluka/zo:kome_je_upucena/zo:adresa_za_postu"/>
                                </xsl:call-template>
                            </fo:block>
                        </fo:block>

                        <fo:block margin-top="20px" text-align="center">ЖАЛБA</fo:block>

                        <fo:block margin-top="10px">
                            <xsl:value-of select="zo:ZalbaOdluka/zo:zalilac"/>  
                            <fo:block margin-top="10px" text-align="center">(Име, презиме, односно назив, адреса и седиште жалиоца)</fo:block>
                        </fo:block>
                        <fo:block margin-top="10px" text-align="center">против решења-закључка</fo:block>
                        <fo:block margin-top="10px">
                            <xsl:value-of select="zo:ZalbaOdluka/zo:donosilac_odluke"/>  
                            <fo:block margin-top="10px" text-align="center">(назив органа који је донео одлуку)</fo:block>
                        </fo:block>

                        <fo:block margin-top="10px">
                            Број <xsl:value-of select="zo:ZalbaOdluka/zo:broj_resenja"/> од <xsl:value-of select="zo:ZalbaOdluka/zo:godina_resenja"/> године.
                        </fo:block>
                        <fo:block margin-top="20px" text-align="justify">
                            Наведеном одлуком органа власти (решењем, закључком, обавештењем у писаној форми са елементима одлуке), супротно закону, 
                            одбијен-одбачен је мој захтев који сам поднео/ла-упутио/ла дана <xsl:value-of select="zo:ZalbaOdluka/@datum_zahteva"/> године и тако 
                            ми ускраћено-онемогућено остваривање уставног и законског права на слободан приступ информацијама од јавног значаја. Oдлуку побијам
                            у целости, односно у делу којим <xsl:value-of select="zo:ZalbaOdluka/zo:razlog_pobijanja"/> јер није заснована на Закону о слободном 
                            приступу информацијама од јавног значаја.
                        </fo:block>
                        <fo:block margin-top="10px" text-align="justify">
                            На основу изнетих разлога, предлажем да Повереник уважи моју жалбу, поништи одлука првостепеног органа и омогући ми приступ траженој/им информацији/ма.
                        </fo:block>
                        <fo:block margin-top="10px" text-align="justify">
                            Жалбу подносим благовремено, у законском року утврђеном у члану 22. ст. 1. Закона о слободном приступу информацијама од јавног значаја.
                        </fo:block>

                        <fo:block margin-top="20px" text-align="right">
                            <fo:block>
                                <fo:block margin-top="10px">  
                                    <xsl:call-template name="FizickoLiceSimple">
                                        <xsl:with-param name="fizickoLice" select="zo:ZalbaOdluka/zo:podnosilac_zalbe/zo:osoba"/>
                                    </xsl:call-template>
                                </fo:block>
                                <fo:block>
                                    Подносилац жалбе / Име и презиме
                                </fo:block>

                                <fo:block margin-top="10px"> 
                                    <xsl:call-template name="Adresa">
                                        <xsl:with-param name="adresa" select="zo:ZalbaOdluka/zo:podnosilac_zalbe/zo:osoba/cmn:adresa"/>
                                    </xsl:call-template> 
                                </fo:block>
                                <fo:block>
                                    адреса
                                </fo:block>

                                <fo:block margin-top="10px">
                                    <xsl:value-of select="zo:ZalbaOdluka/zo:podnosilac_zalbe/zo:drugi_kontakt"/>
                                </fo:block>
                                <fo:block>
                                    други контакт
                                </fo:block>
                            </fo:block>
                        </fo:block>
                        <fo:block margin-top="10px">
                            <fo:block>
                                У <xsl:value-of select="zo:ZalbaOdluka/zo:mesto_podnosenja_zalbe/zo:grad"/>, 
                                дана <xsl:value-of select="zo:ZalbaOdluka/zo:mesto_podnosenja_zalbe/zo:datum"/> године
                            </fo:block>
                        </fo:block>
                        <fo:block margin-top="20px" text-align="justify">
                            Напомена:  У жалби се мора навести одлука која се побија (решење, закључак, обавештење), назив органа који је одлуку донео, 
                            као и број и датум одлуке. Довољно је да жалилац наведе у жалби у ком погледу је незадовољан одлуком, с тим да жалбу не мора посебно 
                            образложити. Ако жалбу изјављује на овом обрасцу, додатно образложење може посебно приложити. Уз жалбу обавезно приложити копију 
                            поднетог захтева и доказ о његовој предаји-упућивању органу као и копију одлуке органа која се оспорава жалбом.
                        </fo:block>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>

    </xsl:template>
</xsl:stylesheet>