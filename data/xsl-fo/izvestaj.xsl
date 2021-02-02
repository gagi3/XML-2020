<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet 
    xmlns:xsl="http://www.w3.org/1999/XSL/Transform" 
    xmlns:fo="http://www.w3.org/1999/XSL/Format"
    xmlns:iz="http://www.pijz.rs/izvestaj"
    version="2.0"
>
    <xsl:template match="/">

        <fo:root font-family="Arial Unicode MS" font-size="10px">
            <fo:layout-master-set>
                <fo:simple-page-master master-name="izvestaj-page">
                    <fo:region-body margin="1in"/>
                    <fo:region-before extent="1in"/>
                    <fo:region-after extent="1in"/>
                </fo:simple-page-master>
            </fo:layout-master-set>

            <fo:page-sequence master-reference="izvestaj-page">
                <fo:flow flow-name="xsl-region-body">
                    <fo:block margin-top="20px" text-align="center">
                        И З В Е Ш Т А Ј
                    </fo:block>

                    <fo:block margin-top="20px"> Број поднетих захтева: <xsl:value-of select="iz:Izvestaj/iz:brojPodnetihZahteva"/> </fo:block>
                    <fo:block margin-top="20px"> Број одбијених захтева: <xsl:value-of select="iz:Izvestaj/iz:brojOdbijenihZahteva"/> </fo:block>
                    <fo:block margin-top="20px"> Број жалби на одлуку: <xsl:value-of select="iz:Izvestaj/iz:brojZalbiOdluka"/> </fo:block>

                    <xsl:for-each select="iz:Izvestaj/iz:zalbe">
                      <fo:block margin-top="20px">
                          - Жалба <xsl:value-of select="iz:zalbaID"/>
                          <fo:block>
                            <xsl:value-of select="iz:sadrzaj"/>
                          </fo:block>
                      </fo:block>
                    </xsl:for-each>
                </fo:flow>
            </fo:page-sequence>
        </fo:root>

    </xsl:template>
</xsl:stylesheet>