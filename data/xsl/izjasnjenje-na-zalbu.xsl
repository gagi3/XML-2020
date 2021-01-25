<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:i="http://www.pijz.rs/izjasnjenje-na-zalbu" version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <title>И З Ј А Ш Њ Е Њ Е</title>

                <style>
                    body { padding: 20px; }
                    p { text-align: justify; }

                    .c-centered { text-align: center; }
                </style>
            </head>

            <body>
                <p class="c-centered"> И З Ј А Ш Њ Е Њ Е </p> 
                <p class="c-centered"> 
                    број <xsl:value-of select="i:izjasnjenjeNaZalbu/@broj"/>
                    на жалбу број <xsl:value-of select="i:izjasnjenjeNaZalbu/@broj_zalbe"/>
                    датума <xsl:value-of select="i:izjasnjenjeNaZalbu/@datum_izjave"/>
                </p>
                <div>
                    <p> <xsl:value-of select="i:izjasnjenjeNaZalbu/i:tekst_izjave"/> </p>
                    <p>
                        <xsl:choose>
                            <xsl:when test="i:izjasnjenjeNaZalbu/i:saglasnost_sa_zalbom = 'true'">
                                <b> Постоји сагласност са жалбом. </b>
                            </xsl:when>
                            <xsl:otherwise>
                                <b> Не постоји сагласност са жалбом. </b>
                            </xsl:otherwise>
                        </xsl:choose>
                    </p>
                </div>
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>