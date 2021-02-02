<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:r="http://www.pijz.rs/resenje" 
    version="2.0"
>
    <xsl:import href="common.xsl"/>
    
    <xsl:template match="/">

        <fo:root font-family="Arial Unicode MS" font-size="10px">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="resenje-page">
                    <fo:region-body margin="1in"/>
                    <fo:region-before extent="1in"/>
                    <fo:region-after extent="1in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="resenje-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block>
                        <fo:inline-container inline-progression-dimension="50%">
                            <fo:block>
                                <fo:block>
                                    <xsl:choose>
                                        <xsl:when test="r:Resenje/@tip = 'zalba_osnovana'">
                                            Решење када је жалба основана - налаже се:
                                        </xsl:when>
                                        <xsl:when test="r:Resenje/@tip = 'zalba_neosnovana'">
                                            Решење - одбија се као неоснована:
                                        </xsl:when>
                                        <xsl:when test="r:Resenje/@tip = 'zahtev_odbijen'">
                                            Решење - одбија се захтев:
                                        </xsl:when>
                                        <xsl:when test="r:Resenje/@tip = 'ponisteno'">
                                            Решење - поништава се:
                                        </xsl:when>
                                        <xsl:otherwise>
                                            Решење:
                                        </xsl:otherwise>
                                    </xsl:choose>
                                </fo:block>
                                <fo:block>
                                    Број: <xsl:value-of select="r:Resenje/@broj"/>
                                </fo:block>
                            </fo:block>
                        </fo:inline-container>
                        <fo:inline-container inline-progression-dimension="50%">
                            <fo:block text-align="right">
                                Датум: <xsl:value-of select="r:Resenje/@datum"/>
                            </fo:block>
                        </fo:inline-container>
                    </fo:block>
                    <fo:block margin-top="20px">
                        <fo:block text-align="justify">
                            Повереник за информације од јавног значаја и заштиту података о личности, у поступку по жалби коју је изјавио
                            <xsl:call-template name="FizickoLiceSimple">
                                <xsl:with-param name="fizickoLice" select="r:Resenje/r:trazilac" />
                            </xsl:call-template>
                            због непоступања установе 
                            <xsl:call-template name="PravnoLice">
                                <xsl:with-param name="pravnoLice" select="r:Resenje/r:ustanova" />
                            </xsl:call-template>,
                            по његовом захтеву од <xsl:value-of select="r:Resenje/@datum_zahteva"/>
                            за приступ информацијама од јавног значаја, на основу члана 35. став 1. тачка 5. 
                            Закона о слободном приступу информацијама од јавног значаја (”Сл. гласник РС”, бр. 120/04, 54/07, 104/09 и 36/10),
                            а у вези са чланом 4. тачка 22. Закона о заштити података о личности (”Сл. гласник РС”, број 87/18), као и члана 
                            23. и члана 24. став 4. Закона о слободном приступу информацијама од јавног значаја и члана 173. став 2. Закона о
                            општем управном поступку (”Сл. гласник РС”, бр. 18/2016 и 95/2018 - аутентично тумачење), доноси
                        </fo:block>
                        <fo:block margin-top="20px">
                            <fo:block text-align="center">Р Е Ш Е Њ Е</fo:block>
                            <fo:block margin-top="8px">
                                <xsl:for-each select="r:Resenje/r:dispozitiv/r:stav">
                                    <xsl:call-template name="Stav">
                                        <xsl:with-param name="stav" select="." />
                                    </xsl:call-template>
                                </xsl:for-each>
                            </fo:block>
                        </fo:block>
                        <fo:block margin-top="20px">
                            <fo:block text-align="center">О б р а з л о ж е њ е</fo:block>
                            <fo:block margin-top="8px">
                                <xsl:for-each select="r:Resenje/r:obrazlozenje/r:paragraf">
                                    <xsl:call-template name="Paragraf">
                                        <xsl:with-param name="paragraf" select="." />
                                    </xsl:call-template>
                                </xsl:for-each>
                            </fo:block>

                            <fo:block> Упутство о правном средству: </fo:block>
                            <xsl:call-template name="Tuzba">
                                <xsl:with-param name="tuzba" select="r:Resenje/r:obrazlozenje/r:tuzba" />
                            </xsl:call-template>
                        </fo:block>
                    </fo:block>
                    <fo:block margin-top="20px">
                        <fo:block text-align="right">
                            ПОВЕРЕНИК
                            <fo:block>
                                <xsl:call-template name="FizickoLiceSimple">
                                    <xsl:with-param name="fizickoLice" select="r:Resenje/r:poverenik" />
                                </xsl:call-template>
                            </fo:block>
                        </fo:block>
                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>

    </xsl:template>

    <xsl:template name="Stav">
        <xsl:param name="stav"/>
        <fo:block margin-top="5px" margin-bottom="5px">
            <xsl:value-of select="$stav/@redni_broj"/>&#160;
            <xsl:value-of select="$stav/r:tekst"/>
            Документ "<xsl:value-of select="$stav/r:dokument/r:naziv"/>" са траженим информацијама:
            <xsl:for-each select="$stav/r:dokument/r:informacija">
                <xsl:value-of select="."/>
                <xsl:if test="position() != last()">
                    <xsl:text>, </xsl:text>
                </xsl:if>
            </xsl:for-each>
            доставити у року од <xsl:value-of select="$stav/r:rok_obavestenja"/> дана.
        </fo:block>
    </xsl:template>

    <xsl:template name="Paragraf">
        <xsl:param name="paragraf"/>
        <fo:block margin-top="5px" margin-bottom="5px" text-align="justify">
            <xsl:value-of select="."/>
        </fo:block>
    </xsl:template>

</xsl:stylesheet>