<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:r="http://www.pijz.rs/resenje" version="2.0">

    <xsl:import href="common.xsl"/>

    <xsl:template match="/">
        <html>
            <head>
                <title>Р Е Ш Е Њ Е</title>

                <style>
                    body { padding: 20px; }
                    p { text-align: justify; }

                    .c-header { display: flex; justify-content: space-between; margin-bottom: 20px; }
                    .c-footer { display: flex; justify-content: flex-end; margin-top: 20px; }
                    .c-subtitle { text-align: center; }
                </style>
            </head>

            <body>
                <div class="c-header">
                    <div>
                        <div>
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
                        </div>
                        <div>
                            Број: <xsl:value-of select="r:Resenje/@broj"/>
                        </div>
                    </div>
                    <div>
                        Датум: <xsl:value-of select="r:Resenje/@datum"/>
                    </div>
                </div>
                <div>
                    <p>
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
                    </p>
                    <p class="c-subtitle">Р Е Ш Е Њ Е</p>
                    <div>
                        <xsl:for-each select="r:Resenje/r:dispozitiv/r:stav">
            				<xsl:call-template name="Stav">
                                <xsl:with-param name="stav" select="." />
                            </xsl:call-template>
            			</xsl:for-each>
                    </div>
                    <div>
                        <p class="c-subtitle">О б р а з л о ж е њ е</p>
                        <xsl:for-each select="r:Resenje/r:obrazlozenje/r:paragraf">
            				<xsl:call-template name="Paragraf">
                                <xsl:with-param name="paragraf" select="." />
                            </xsl:call-template>
            			</xsl:for-each>

                        <p> Упутство о правном средству: </p>
                        <xsl:call-template name="Tuzba">
                            <xsl:with-param name="tuzba" select="r:Resenje/r:obrazlozenje/r:tuzba" />
                        </xsl:call-template>
                    </div>
                </div>
                <div class="c-footer">
                    <div>
                        ПОВЕРЕНИК
                        <p>
                            <xsl:call-template name="FizickoLiceSimple">
                                <xsl:with-param name="fizickoLice" select="r:Resenje/r:poverenik" />
                            </xsl:call-template>
                        </p>
                    </div>
                </div>
            </body>
        </html>

    </xsl:template>

    <xsl:template name="Stav">
        <xsl:param name="stav"/>
        <p>
            <xsl:value-of select="$stav/@redni_broj"/>
            Документ "<xsl:value-of select="$stav/r:dokument/r:naziv"/>" са траженим информацијама:
            <xsl:for-each select="$stav/r:dokument/r:informacija">
                <xsl:value-of select="."/>
                <xsl:if test="position() != last()">
                    <xsl:text>, </xsl:text>
                </xsl:if>
            </xsl:for-each>
            доставити у року од <xsl:value-of select="$stav/r:rok_obavestenja"/> дана.
        </p>
    </xsl:template>

    <xsl:template name="Paragraf">
        <xsl:param name="paragraf"/>
        <p> <xsl:value-of select="."/> </p>
    </xsl:template>

</xsl:stylesheet>