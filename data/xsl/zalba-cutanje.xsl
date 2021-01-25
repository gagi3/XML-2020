<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:cmn="http://www.pijz.rs/common" xmlns:zc="http://www.pijz.rs/zalba-cutanje" version="2.0">

    <xsl:import href="common.xsl"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Ж А Л Б А - Ћ У Т А Њ Е</title>

                <style>
                    body { padding: 20px; }
                    p { text-align: justify; }

                    .c-person { display: flex; justify-content: flex-end; margin-top: 20px; }
                    .c-centered { text-align: center; }
                </style>
            </head>

            <body>
                <div>

                    <p class="c-centered"> <b> <xsl:value-of select="zc:ZalbaCutanje/zc:predmet"/> </b> </p>
                    <p>
                        <b> <xsl:value-of select="zc:ZalbaCutanje/zc:kome_je_upucena/zc:naziv"/> </b> <br/>

                        Адреса за пошту: 
                        <xsl:call-template name="Adresa">
                            <xsl:with-param name="adresa" select="zc:ZalbaCutanje/zc:kome_je_upucena/zc:adresa_za_postu"/>
                        </xsl:call-template>
                    </p>

                    <p> У складу са чланом 22. Закона о слободном приступу информацијама од јавног значаја подносим: </p>
                    <p class="c-centered"> ЖАЛБУ <br/> против </p>
                    <p>
                        <u> <xsl:value-of select="zc:ZalbaCutanje/zc:protiv_organa"/> </u> <br/>
                        <div class="c-centered"> (навести назив органа) </div>
                    </p>
                    <p class="c-centered">
                        због тога што орган власти: <br/>
                        <b> <xsl:value-of select="zc:ZalbaCutanje/zc:razlog"/> </b> <br/>
                        (подвући због чега се изјављује жалба)
                    </p>
                    <p>
                        по мом захтеву за слободан приступ информацијама од јавног значаја који сам поднео том органу 
                        дана <xsl:value-of select="zc:ZalbaCutanje/@datum_zahteva"/> годинe, а којим сам 
                        тражио/ла да ми се у складу са Законом о слободном приступу информацијама од јавног значаја омогући увид - копија 
                        документа који садржи информације о /у вези са :
                    </p>
                    <p>
                        <u> <xsl:value-of select="zc:ZalbaCutanje/zc:podaci_o_zahtevu"/> </u> <br/>
                        <div class="c-centered"> (навести податке о захтеву и информацији/ама) </div>
                    </p>

                    <p> На основу изнетог, предлажем да Повереник уважи моју жалбу и омогући ми приступ траженој/им информацији/ма. </p>
                    <p> Као доказ, уз жалбу достављам копију захтева са доказом о предаји органу власти. </p>
                    <p> <b> Напомена: </b> Код жалбе због непоступању по захтеву у целости, треба приложити и добијени одговор органа власти. </p>

                    <div class="c-person">
                        <div>
                            <p> 
                                <u>
                                    <xsl:call-template name="FizickoLiceSimple">
                                        <xsl:with-param name="fizickoLice" select="zc:ZalbaCutanje/zc:podnosilac_zalbe/zc:osoba"/>
                                    </xsl:call-template>
                                </u> <br/> Подносилац жалбе / Име и презиме
                            </p>

                            <p> 
                                <u>
                                    <xsl:call-template name="Adresa">
                                        <xsl:with-param name="adresa" select="zc:ZalbaCutanje/zc:podnosilac_zalbe/zc:osoba/cmn:adresa"/>
                                    </xsl:call-template> 
                                </u> <br/> адреса
                            </p>

                            <p>
                                <u>
                                    <xsl:value-of select="zc:ZalbaCutanje/zc:podnosilac_zalbe/zc:drugi_kontakt"/>
                                </u> <br/> други контакт
                            </p>
                        </div>
                    </div>
                </div>
                <div>
                    <div>
                        У <xsl:value-of select="zc:ZalbaCutanje/zc:mesto_podnosenja_zalbe/zc:grad"/>, 
                        дана <xsl:value-of select="zc:ZalbaCutanje/zc:mesto_podnosenja_zalbe/zc:datum"/> године
                    </div>
                </div>
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>