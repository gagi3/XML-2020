<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:o="http://www.pijz.rs/obavestenje" version="2.0">

    <xsl:import href="common.xsl"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>О Б А В Е Ш Т Е Њ Е</title>

                <style>
                    body { padding: 20px; }
                    p { text-align: justify; }

                    .c-title { text-align: center; }
                    .c-footer { display: flex; justify-content: space-between; }
                </style>
            </head>

            <body>
                <div>
                    <u>
                        <xsl:value-of select="o:Obavestenje/o:organ/o:naziv"/><br/>
                        <xsl:call-template name="Adresa">
                            <xsl:with-param name="adresa" select="o:Obavestenje/o:organ/o:sediste"/>
                        </xsl:call-template>
                    </u><br/><p>(назив и седиште органа)</p>
                    <p>
                        Број предмета: <u> <xsl:value-of select="o:Obavestenje/@broj"/> </u>
                    </p>
                    <p>
                        Датум: <u> <xsl:value-of select="o:Obavestenje/@datum"/> </u>
                    </p>
                    <div>
                        <u>
                            <xsl:if test="name(o:Obavestenje/o:podnosilac/*[1]) = 'o:fizickoLice'">
                                <xsl:call-template name="FizickoLice">
                                    <xsl:with-param name="fizickoLice" select="o:Obavestenje/o:podnosilac/o:fizickoLice" />
                                </xsl:call-template>       
                            </xsl:if>
                            <xsl:if test="name(o:Obavestenje/o:podnosilac/*[1]) = 'o:pravnoLice'">
                                <xsl:call-template name="PravnoLice">
                                    <xsl:with-param name="pravnoLice" select="o:Obavestenje/o:podnosilac/o:pravnoLice" />
                                </xsl:call-template>        
                            </xsl:if>
                        </u><br/>(Име и презиме / назив / и адреса подносиоца захтева)
                    </div>
                </div>
                <div>
                    <p class="c-title">
                        <xsl:value-of select="o:Obavestenje/o:naslov"/> <br/>
                        <xsl:value-of select="o:Obavestenje/o:podnaslov"/>
                    </p>
                    <p>
                        На основу члана 16. ст. 1. Закона о слободном приступу информацијама од јавног значаја, поступајући по вашем захтеву 
                        за слободан приступ информацијама од <xsl:value-of select="o:Obavestenje/@datum_zahtevanja"/> којим сте тражили увид у документ/е са 
                        информацијама о / у вези са: (опис тражене информације), обавештавамо вас да дана <xsl:value-of select="o:Obavestenje/@datum_uvida"/>
                        у периоду од <xsl:value-of select="o:Obavestenje/@vreme_uvida_od"/> до <xsl:value-of select="o:Obavestenje/@vreme_uvida_do"/> часова
                        можете извршити увид у документ/е у коме је садржана тражена информација.
                    </p>
                    <p>
                        Том приликом, на ваш захтев, може вам се издати и копија документа са траженом информацијом.
                    </p>
                    <p>
                        Трошкови су утврђени Уредбом Владе Републике Србије („Сл. гласник РС“, бр. 8/06), и то: копија стране А4 формата износи 3 динара, 
                        А3 формата 6 динара, CD 35 динара, дискете 20 динара, DVD 40 динара, аудио-касета – 150 динара, видео-касета 300 динара, претварање 
                        једне стране документа из физичког у електронски облик – 30 динара.
                    </p>
                    <p>
                        Износ укупних трошкова израде копије документа по вашем захтеву износи ............ динара 
                        и уплаћује се на жиро-рачун Буџета Републике Србије бр. 840-742328-843-30, с позивом на број 97 – 
                        ознака шифре општине/града где се налази орган власти (из Правилника о условима и начину вођења рачуна 
                        – „Сл. гласник РС“, 20/07... 40/10). 
                    </p>

                    <div class="c-footer">
                        <div>
                            Достављено: 
                            <li>именованом</li>
                            <li>архиви</li>
                        </div>
                        <div> (М. П.) </div>
                        <div>
                            <p> 
                                <u> <xsl:value-of select="o:Obavestenje/o:podnozje/o:potpis"/> </u> <br/>
                                (потпис овлашћеног лица, односно руководиоца органа)
                            </p>
                            <xsl:value-of select="o:Obavestenje/o:podnozje/o:pecat"/>
                        </div>
                    </div>
                </div>
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>