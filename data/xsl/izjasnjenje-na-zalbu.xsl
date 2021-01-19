<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:i="http://www.pijz.rs/izjasnjenje-na-zalbu" version="2.0">
    <xsl:template match="/">
        <html>
            <head>
                <title>izjasnjenje-na-zalbu</title>
            </head>

            <body>
                <div>
                    <h1>izjasnjenje-na-zalbu</h1>
                    <div>
                        <strong>Tekst izjave: </strong> 
                        <xsl:value-of select="i:izjasnjenjeNaZalbu/i:tekst_izjave"/>
                    </div>
                    <div>
                        <strong>Saglasnost sa zalbom: </strong>
                        <xsl:value-of select="i:izjasnjenjeNaZalbu/i:saglasnost_sa_zalbom"/>
                    </div>
                </div>
            </body>
        </html>

    </xsl:template>
</xsl:stylesheet>