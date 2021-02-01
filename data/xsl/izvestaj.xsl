<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:iz="http://www.pijz.rs/izvestaj" version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <title>И З В Е Ш Т А Ј</title>

                <style>
                    body { padding: 20px; }
                    p { text-align: justify; }

                    .c-centered { text-align: center; }
                    .c-zalba { margin-bottom: 20px; }
                </style>
            </head>

            <body>
              <p class="c-centered"> И З В Е Ш Т А Ј </p>

              <p> Број поднетих захтева: <xsl:value-of select="iz:Izvestaj/iz:brojPodnetihZahteva"/> </p>
              <p> Број одбијених захтева: <xsl:value-of select="iz:Izvestaj/iz:brojOdbijenihZahteva"/> </p>
              <p> Број жалби на одлуку: <xsl:value-of select="iz:Izvestaj/iz:brojZalbiOdluka"/> </p>

              <xsl:for-each select="iz:Izvestaj/iz:zalbe">
                <div class="c-zalba">
                    <u> Жалба <xsl:value-of select="iz:zalbaID"/> </u>
                    <div>
                      <xsl:value-of select="iz:sadrzaj"/>
                    </div>
                </div>
              </xsl:for-each>
                
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>