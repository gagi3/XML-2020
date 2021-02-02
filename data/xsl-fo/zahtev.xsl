<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:z="http://www.pijz.rs/zahtev" 
    xmlns:cmn="http://www.pijz.rs/common"
    version="2.0"
>

    <xsl:import href="common.xsl"/>

    <xsl:template match="/">

        <fo:root font-family="Arial Unicode MS" font-size="10px">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="zahtev-page">
                    <fo:region-body margin="1in"/>
                    <fo:region-before extent="1in"/>
                    <fo:region-after extent="1in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="zahtev-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block text-align="center">
                        <fo:inline text-decoration="underline">
                            <xsl:call-template name="PravnoLice">
                                <xsl:with-param name="pravnoLice" select="z:Zahtev/z:poverenik" />
                            </xsl:call-template> 
                        </fo:inline>
                        <fo:block text-align="center">(назив и седиште органа коме се захтев упућује)</fo:block>
                    </fo:block>

                    <fo:block margin-top="20px">
                        <fo:block text-align="center">З А Х Т Е В</fo:block>
                        <fo:block text-align="center">за приступ информацији од јавног значаја</fo:block>

                        <fo:block margin-top="10px" text-align="justify">
                            На основу члана 15. ст. 1. Закона о слободном приступу информацијама од јавног значаја (”Службени гласник РС”, бр. 120/04, 54/07, 104/09 и 36/10),
                            од горе наведеног органа захтевам: <fo:inline font-size="75%" baseline-shift="super">*</fo:inline>
                        </fo:block>

                        <fo:block margin-top="10px">
                            <fo:list-block>
                                <fo:list-item>
                                    <fo:list-item-label start-indent="body-start()"> <fo:block></fo:block> </fo:list-item-label>
                                    <fo:list-item-body start-indent="body-start()"> 
                                        <fo:block>
                                            <xsl:if test="z:Zahtev/z:tip = 'obavestenje'"><fo:inline color="red">×</fo:inline></xsl:if>
                                            обавештење да ли поседује тражену информацију;
                                        </fo:block>
                                    </fo:list-item-body>
                                </fo:list-item>
                                <fo:list-item>
                                    <fo:list-item-label start-indent="body-start()"> <fo:block></fo:block> </fo:list-item-label>
                                    <fo:list-item-body start-indent="body-start()"> 
                                        <fo:block>
                                            <xsl:if test="z:Zahtev/z:tip = 'uvid'"><fo:inline color="red">×</fo:inline></xsl:if>
                                            увид у документ који садржи тражену информацију;
                                        </fo:block>
                                    </fo:list-item-body>
                                </fo:list-item>
                                <fo:list-item>
                                    <fo:list-item-label start-indent="body-start()"> <fo:block></fo:block> </fo:list-item-label>
                                    <fo:list-item-body start-indent="body-start()"> 
                                        <fo:block>
                                            <xsl:if test="z:Zahtev/z:tip = 'kopija'"><fo:inline color="red">×</fo:inline></xsl:if>
                                            копију документа који садржи тражену информацију;
                                        </fo:block>
                                    </fo:list-item-body>
                                </fo:list-item>
                                <fo:list-item>
                                    <fo:list-item-label start-indent="body-start()"> <fo:block></fo:block> </fo:list-item-label>
                                    <fo:list-item-body start-indent="body-start()">
                                        <fo:block>
                                            <xsl:if test="z:Zahtev/z:tip = 'dostava'"><fo:inline color="red">×</fo:inline></xsl:if>
                                            достављање копије документа који садржи тражену информацију: <fo:inline font-size="75%" baseline-shift="super">**</fo:inline>
                                        </fo:block>
                                    </fo:list-item-body>
                                </fo:list-item>
                                <fo:list-item>
                                    <fo:list-item-label start-indent="body-start()"> <fo:block></fo:block> </fo:list-item-label>
                                    <fo:list-item-body start-indent="body-start()">
                                        <fo:list-block>
                                            <fo:list-item>
                                                <fo:list-item-label start-indent="body-start()"> <fo:block></fo:block> </fo:list-item-label>
                                                <fo:list-item-body start-indent="body-start()">
                                                    <fo:block>
                                                        <xsl:if test="z:Zahtev/z:dostava = 'posta'"><fo:inline color="red">×</fo:inline></xsl:if>
                                                        поштом
                                                    </fo:block>
                                                </fo:list-item-body>
                                            </fo:list-item>
                                            <fo:list-item>
                                                <fo:list-item-label start-indent="body-start()"> <fo:block></fo:block> </fo:list-item-label>
                                                <fo:list-item-body start-indent="body-start()">
                                                    <fo:block>
                                                        <xsl:if test="z:Zahtev/z:dostava = 'email'"><fo:inline color="red">×</fo:inline></xsl:if>
                                                        електронском поштом
                                                    </fo:block>
                                                </fo:list-item-body>
                                            </fo:list-item>
                                            <fo:list-item>
                                                <fo:list-item-label start-indent="body-start()"> <fo:block></fo:block> </fo:list-item-label>
                                                <fo:list-item-body start-indent="body-start()">
                                                    <fo:block>
                                                        <xsl:if test="z:Zahtev/z:dostava = 'faks'"><fo:inline color="red">×</fo:inline></xsl:if>
                                                        факсом
                                                    </fo:block>
                                                </fo:list-item-body>
                                            </fo:list-item>
                                            <fo:list-item>
                                                <fo:list-item-label start-indent="body-start()"> <fo:block></fo:block> </fo:list-item-label>
                                                <fo:list-item-body start-indent="body-start()">
                                                    <fo:block>
                                                        <xsl:if test="z:Zahtev/z:dostava = 'drugo'"><fo:inline color="red">×</fo:inline></xsl:if>
                                                        на други начин: <fo:inline font-size="75%" baseline-shift="super">***</fo:inline> 
                                                        <fo:inline text-decoration="underline"> <xsl:value-of select="z:Zahtev/z:drugiNacinDostave"/> </fo:inline>
                                                    </fo:block>
                                                </fo:list-item-body>
                                            </fo:list-item>
                                        </fo:list-block>
                                    </fo:list-item-body>
                                </fo:list-item>
                            </fo:list-block>
                        </fo:block>
                        
                        <fo:block margin-top="10px">
                            <fo:block> Овај захтев се односи на следеће информације: </fo:block>
                            <fo:block text-decoration="underline" margin-top="8px"> <xsl:value-of select="z:Zahtev/z:opisInformacije"/> </fo:block>
                            <fo:block margin-top="8px" font-size="8px">
                                (навести што прецизнији опис информације која се тражи као и друге податке који олакшавају проналажење тражене информације)
                            </fo:block>
                        </fo:block>

                        <fo:block margin-top="10px">
                            <fo:block margin-top="20px" text-align="right">
                                <fo:block>
                                    <fo:block margin-top="10px">
                                        <fo:block text-decoration="underline"> 
                                            <xsl:call-template name="FizickoLiceSimple">
                                                <xsl:with-param name="fizickoLice" select="z:Zahtev/z:trazilac"/>
                                            </xsl:call-template>
                                        </fo:block>
                                        <fo:block>
                                            Подносилац жалбе / Име и презиме
                                        </fo:block>
                                    </fo:block>

                                    <fo:block margin-top="10px">
                                        <fo:block text-decoration="underline"> 
                                            <xsl:call-template name="Adresa">
                                                <xsl:with-param name="adresa" select="z:Zahtev/z:trazilac/cmn:adresa"/>
                                            </xsl:call-template> 
                                        </fo:block>
                                        <fo:block>
                                            адреса
                                        </fo:block>
                                    </fo:block>

                                    <fo:block margin-top="10px">
                                        <fo:block text-decoration="underline">
                                            <xsl:value-of select="z:Zahtev/z:trazilacDodatniKontakt"/>
                                        </fo:block>
                                        <fo:block>
                                            други контакт
                                        </fo:block>
                                    </fo:block>
                                </fo:block>
                            </fo:block>

                            <fo:block>
                                У <fo:inline text-decoration="underline"> <xsl:value-of select="z:Zahtev/z:mesto"/> </fo:inline>,
                                дана <fo:inline text-decoration="underline"> <xsl:value-of select="z:Zahtev/@datum"/> </fo:inline> године.
                            </fo:block>

                        </fo:block>

                        <fo:block margin-top="40px">
                            <fo:footnote>
                                <fo:inline font-size="75%" baseline-shift="super"></fo:inline>
                                <fo:footnote-body font-size="8pt" text-align="justify" margin-left="0pc">
                                    <fo:block>
                                        <fo:inline font-size="75%" baseline-shift="super">*</fo:inline>
                                        У кућици означити која законска права на приступ информацијама желите да остварите.
                                    </fo:block>
                                </fo:footnote-body>
                            </fo:footnote>
                            <fo:footnote>
                                <fo:inline font-size="75%" baseline-shift="super"></fo:inline>
                                <fo:footnote-body font-size="8pt" text-align="justify" margin-left="0pc">
                                    <fo:block>
                                        <fo:inline font-size="75%" baseline-shift="super">**</fo:inline>
                                        У кућици означити начин достављања копије докумената.
                                    </fo:block>
                                </fo:footnote-body>
                            </fo:footnote>
                            <fo:footnote>
                                <fo:inline font-size="75%" baseline-shift="super"></fo:inline>
                                <fo:footnote-body font-size="8pt" text-align="justify" margin-left="0pc">
                                    <fo:block>
                                        <fo:inline font-size="75%" baseline-shift="super">***</fo:inline>
                                        Када захтевате други начин достављања обавезно уписати који начин достављања захтевате.
                                    </fo:block>
                                </fo:footnote-body>
                            </fo:footnote>
                        </fo:block>

                    </fo:block>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>

    </xsl:template>
</xsl:stylesheet>