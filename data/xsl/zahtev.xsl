<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:cmn="http://www.pijz.rs/common" xmlns:z="http://www.pijz.rs/zahtev" version="2.0">

    <xsl:import href="common.xsl"/>

    <xsl:template match="/">
      <html>
        <head>
          <title>З А Х Т Е В</title>
          <style>
            body { padding: 10px; }
            p { text-align: justify; text-indent: 1rem; }
            ul { list-style-type: none; }

            .c-centered { text-align: center; }

            .c-info { margin-bottom: 10px; }
            .c-header { margin-bottom: 20px; }
            .c-footer { margin-top: 20px; display: flex; justify-content: space-between; }

            .c-footnote ul {
              margin-left: -20px;
            }
          </style>
        </head>

        <body>
          <div class="c-header c-centered">
            <u> 
              <xsl:call-template name="PravnoLice">
                <xsl:with-param name="pravnoLice" select="z:Zahtev/z:poverenik" />
              </xsl:call-template> 
            </u>
            <div class="c-centered">назив и седиште органа коме се захтев упућује</div>
          </div>

          <div class="c-content">
            <div class="c-centered"><b>З А Х Т Е В</b></div>
            <div class="c-centered"><b>за приступ информацији од јавног значаја</b></div>

            <p>
              На основу члана 15. ст. 1. Закона о слободном приступу информацијама од јавног значаја (”Службени гласник РС”, бр. 120/04, 54/07, 104/09 и 36/10),
              од горе наведеног органа захтевам:*
            </p>

            <p>
              <ul>
                <li>обавештење да ли поседује тражену информацију;</li>
                <li>увид у документ који садржи тражену информацију;</li>
                <li>копију документа који садржи тражену информацију;</li>
                <li>
                  достављање копије документа који садржи тражену информацију:**
                  <ul>
                    <li>поштом</li>
                    <li>електронском поштом</li>
                    <li>факсом</li>
                    <li>на други начин:*** <u><xsl:value-of select="z:Zahtev/z:drugiNacinDostave"/></u></li>
                  </ul>
                </li>
              </ul>
            </p>

            <p> Овај захтев се односи на следеће информације: </p>
            <p> <u> <xsl:value-of select="z:Zahtev/z:opisInformacije"/> </u> </p>
            <small> (навести што прецизнији опис информације која се тражи као и друге податке који олакшавају проналажење тражене информације) </small>

            <div class="c-footer">
              <div>
                У <u><xsl:value-of select="z:Zahtev/z:mesto"/></u>, <br/>
                дана <u><xsl:value-of select="z:Zahtev/@datum"/></u> године.
              </div>

              <div>
                <div class="c-person">
                  <div >
                    <div class="c-info"> 
                      <u>
                        <xsl:call-template name="FizickoLiceSimple">
                          <xsl:with-param name="fizickoLice" select="z:Zahtev/z:trazilac"/>
                        </xsl:call-template>
                        </u> <br/> Подносилац жалбе / Име и презиме
                    </div>

                    <div class="c-info"> 
                      <u>
                        <xsl:call-template name="Adresa">
                          <xsl:with-param name="adresa" select="z:Zahtev/z:trazilac/cmn:adresa"/>
                        </xsl:call-template> 
                      </u> <br/> адреса
                    </div>

                    <div class="c-info">
                      <u>
                        <xsl:value-of select="z:Zahtev/z:trazilacDodatniKontakt"/>
                      </u> <br/> други контакт
                    </div>
                  </div>
                </div>
              </div>

            </div>

            <div class="c-footnote">
              <hr/>
              <ul>
                <li>* У кућици означити која законска права на приступ информацијама желите да остварите.</li>
                <li>** У кућици означити начин достављања копије докумената.</li>
                <li>*** Када захтевате други начин достављања обавезно уписати који начин достављања захтевате.</li>
              </ul>
            </div>

          </div>
        </body>
      </html>

    </xsl:template>
</xsl:stylesheet>