<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:cmn="http://www.pijz.rs/common" xmlns:zo="http://www.pijz.rs/zalba-odluka" version="2.0">

    <xsl:import href="common.xsl"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Ж А Л Б А - О Д Л У К А</title>

                <style>
                    body { padding: 20px; }
                    p { text-align: justify; }

                    .c-person { display: flex; justify-content: flex-end; margin-top: 20px; }
                    .c-centered { text-align: center; }
                </style>
            </head>

            <body> 
                <div>
                    <p class="c-centered"> <b> <xsl:value-of select="zo:ZalbaOdluka/zo:predmet"/> </b> </p>
                    <p>
                        <b> <xsl:value-of select="zo:ZalbaOdluka/zo:kome_je_upucena/zo:naziv"/> </b> <br/>

                        Адреса за пошту: 
                        <xsl:call-template name="Adresa">
                            <xsl:with-param name="adresa" select="zo:ZalbaOdluka/zo:kome_je_upucena/zo:adresa_za_postu"/>
                        </xsl:call-template>
                    </p>

                    <p class="c-centered"> <b> ЖАЛБA </b> </p>

                    <p>
                        <u> 
                            <xsl:value-of select="zo:ZalbaOdluka/zo:zalilac/zo:osoba_zalilac/cmn:ime"/>&#160;
                            <xsl:value-of select="zo:ZalbaOdluka/zo:zalilac/zo:osoba_zalilac/cmn:prezime"/> 
                            (
                                <xsl:call-template name="Adresa">
                                    <xsl:with-param name="adresa" select="zo:ZalbaOdluka/zo:zalilac/zo:osoba_zalilac/cmn:adresa"/>
                                </xsl:call-template>
                            ) - 
                            <xsl:value-of select="zo:ZalbaOdluka/zo:zalilac/zo:naziv"/>,&#160;
                            <xsl:value-of select="zo:ZalbaOdluka/zo:zalilac/zo:sediste_zalioca"/> 
                        
                        </u> <br/>
                        <div class="c-centered"> (Име, презиме, односно назив, адреса и седиште жалиоца) </div>
                    </p>
                    <p class="c-centered"> против решења-закључка </p>
                    <p>
                        <u> <xsl:value-of select="zo:ZalbaOdluka/zo:donosilac_odluke"/> </u> <br/>
                        <div class="c-centered"> (назив органа који је донео одлуку) </div>
                    </p>

                    <p>
                        Број <xsl:value-of select="zo:ZalbaOdluka/zo:broj_resenja"/> од <xsl:value-of select="zo:ZalbaOdluka/zo:godina_resenja"/> године.
                    </p>
                    <p>
                        Наведеном одлуком органа власти (решењем, закључком, обавештењем у писаној форми са елементима одлуке), супротно закону, 
                        одбијен-одбачен је мој захтев који сам поднео/ла-упутио/ла дана <xsl:value-of select="zo:ZalbaOdluka/@datum_zahteva"/> године и тако 
                        ми ускраћено-онемогућено остваривање уставног и законског права на слободан приступ информацијама од јавног значаја. Oдлуку побијам
                        у целости, односно у делу којим <xsl:value-of select="zo:ZalbaOdluka/zo:razlog_pobijanja"/> јер није заснована на Закону о слободном 
                        приступу информацијама од јавног значаја.
                    </p>
                    <p>
                        На основу изнетих разлога, предлажем да Повереник уважи моју жалбу, поништи одлука првостепеног органа и омогући ми приступ траженој/им информацији/ма.
                    </p>
                    <p>
                        Жалбу подносим благовремено, у законском року утврђеном у члану 22. ст. 1. Закона о слободном приступу информацијама од јавног значаја.
                    </p>

                    <div class="c-person">
                        <div>
                            <p> 
                                <u>
                                    <xsl:call-template name="FizickoLiceSimple">
                                        <xsl:with-param name="fizickoLice" select="zo:ZalbaOdluka/zo:podnosilac_zalbe/zo:osoba"/>
                                    </xsl:call-template>
                                </u> <br/> Подносилац жалбе / Име и презиме
                            </p>

                            <p> 
                                <u>
                                    <xsl:call-template name="Adresa">
                                        <xsl:with-param name="adresa" select="zo:ZalbaOdluka/zo:podnosilac_zalbe/zo:osoba/cmn:adresa"/>
                                    </xsl:call-template> 
                                </u> <br/> адреса
                            </p>

                            <p>
                                <u>
                                    <xsl:value-of select="zo:ZalbaOdluka/zo:podnosilac_zalbe/zo:drugi_kontakt"/>
                                </u> <br/> други контакт
                            </p>
                        </div>
                    </div>
                    <div>
                        <div>
                            У <xsl:value-of select="zo:ZalbaOdluka/zo:mesto_podnosenja_zalbe/zo:grad"/>, 
                            дана <xsl:value-of select="zo:ZalbaOdluka/zo:mesto_podnosenja_zalbe/zo:datum"/> године
                        </div>
                    </div>
                    <p>
                        <b> Напомена: </b> У жалби се мора навести одлука која се побија (решење, закључак, обавештење), назив органа који је одлуку донео, 
                        као и број и датум одлуке. Довољно је да жалилац наведе у жалби у ком погледу је незадовољан одлуком, с тим да жалбу не мора посебно 
                        образложити. Ако жалбу изјављује на овом обрасцу, додатно образложење може посебно приложити. Уз жалбу обавезно приложити копију 
                        поднетог захтева и доказ о његовој предаји-упућивању органу као и копију одлуке органа која се оспорава жалбом.
                    </p>
                </div>
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>