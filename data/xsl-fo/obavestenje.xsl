<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:o="http://www.pijz.rs/obavestenje" 
    version="2.0"
>

    <xsl:import href="common.xsl"/>

    <xsl:template match="/">

        <fo:root font-family="Arial Unicode MS" font-size="10px">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="obavestenje-page">
                    <fo:region-body margin="1in"/>
                    <fo:region-before extent="1in"/>
                    <fo:region-after extent="1in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="obavestenje-page">
                <fo:flow flow-name="xsl-region-body">

                    <fo:block>
                        <fo:block> <xsl:value-of select="o:Obavestenje/o:organ/o:naziv"/> </fo:block>
                        <xsl:call-template name="Adresa">
                            <xsl:with-param name="adresa" select="o:Obavestenje/o:organ/o:sediste"/>
                        </xsl:call-template>
                    </fo:block>
                    <fo:block>(назив и седиште органа)</fo:block>

                    <fo:block margin-top="10px">
                        Број предмета: <xsl:value-of select="o:Obavestenje/@broj"/>
                    </fo:block>

                    <fo:block margin-top="10px">
                        Датум: <xsl:value-of select="o:Obavestenje/@datum"/>
                    </fo:block>

                    <fo:block margin-top="10px">
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
                    </fo:block>
                    <fo:block>(Име и презиме / назив / и адреса подносиоца захтева)</fo:block>

                    <fo:block margin-top="20px">
                        <fo:block text-align="center"> <xsl:value-of select="o:Obavestenje/o:naslov"/> </fo:block>
                        <fo:block text-align="center"> <xsl:value-of select="o:Obavestenje/o:podnaslov"/> </fo:block>

                        <fo:block margin-top="10px" text-align="justify">
                            На основу члана 16. ст. 1. Закона о слободном приступу информацијама од јавног значаја, поступајући по вашем захтеву 
                            за слободан приступ информацијама од <xsl:value-of select="o:Obavestenje/@datum_zahtevanja"/> којим сте тражили увид у документ/е са 
                            информацијама о / у вези са: <xsl:value-of select="o:Obavestenje/o:informacija"/>, обавештавамо вас да дана <xsl:value-of select="o:Obavestenje/@datum_uvida"/>
                            у периоду од <xsl:value-of select="o:Obavestenje/@vreme_uvida_od"/> до <xsl:value-of select="o:Obavestenje/@vreme_uvida_do"/> часова
                            можете извршити увид у документ/е у коме је садржана тражена информација.
                        </fo:block>
                        <fo:block margin-top="10px" text-align="justify">
                            Том приликом, на ваш захтев, може вам се издати и копија документа са траженом информацијом.
                        </fo:block>
                        <fo:block margin-top="10px" text-align="justify">
                            Трошкови су утврђени Уредбом Владе Републике Србије („Сл. гласник РС“, бр. 8/06), и то: копија стране А4 формата износи 3 динара, 
                            А3 формата 6 динара, CD 35 динара, дискете 20 динара, DVD 40 динара, аудио-касета – 150 динара, видео-касета 300 динара, претварање 
                            једне стране документа из физичког у електронски облик – 30 динара.
                        </fo:block>
                        <fo:block margin-top="10px" text-align="justify">
                            Износ укупних трошкова израде копије документа по вашем захтеву износи <xsl:value-of select="o:Obavestenje/o:cena"/> динара 
                            и уплаћује се на жиро-рачун Буџета Републике Србије бр. 840-742328-843-30, с позивом на број 97 – 
                            ознака шифре општине/града где се налази орган власти (из Правилника о условима и начину вођења рачуна 
                            – „Сл. гласник РС“, 20/07... 40/10). 
                        </fo:block>
                    </fo:block>

                    <fo:block margin-top="20px" span="all">
                        <fo:inline-container inline-progression-dimension="40%">
                            <fo:block margin-top="10px">
                                Достављено: 
                                <fo:list-block>
                                    <fo:list-item>
                                        <fo:list-item-label end-indent="label-end()"> <fo:block>-</fo:block> </fo:list-item-label>
                                        <fo:list-item-body start-indent="body-start()"> <fo:block>именованом</fo:block> </fo:list-item-body>
                                    </fo:list-item>
                                    <fo:list-item>
                                        <fo:list-item-label end-indent="label-end()"> <fo:block>-</fo:block> </fo:list-item-label>
                                        <fo:list-item-body start-indent="body-start()"> <fo:block>архиви</fo:block> </fo:list-item-body>
                                    </fo:list-item>
                                </fo:list-block>
                            </fo:block>
                        </fo:inline-container>
                        <fo:inline-container inline-progression-dimension="20%">
                            <fo:block margin-top="10px"> (М. П.) </fo:block>
                        </fo:inline-container>
                        <fo:inline-container inline-progression-dimension="40%">
                            <fo:block margin-top="10px">
                                <fo:block> 
                                    <xsl:value-of select="o:Obavestenje/o:podnozje/o:potpis"/>
                                    <fo:block> (потпис овлашћеног лица, односно руководиоца органа) </fo:block>
                                </fo:block>
                                <xsl:value-of select="o:Obavestenje/o:podnozje/o:pecat"/>
                            </fo:block>
                        </fo:inline-container>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>

    </xsl:template>
</xsl:stylesheet>