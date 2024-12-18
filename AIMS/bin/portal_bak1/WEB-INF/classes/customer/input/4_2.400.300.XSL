<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes"/>
	<xsl:param name="versionParam" select="'1.0'"/> 
	<xsl:template match="articles">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4" page-height="300px" page-width="400px">
					<fo:region-body/>
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="simpleA4">
				<fo:flow flow-name="xsl-region-body">

					<fo:block-container position="absolute" overflow="hidden"  width="400px" height="50px" top="0px" left="0px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="36pt" color="#FFFFFF" background-color="#FF0000" text-align="center">SOLUM Co., Ltd.</fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" overflow="hidden"  width="400px" height="64px" top="50px" left="0px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="32pt" color="#000000" background-color="#FFFFFF" text-align="left" wrap-option="wrap"><xsl:value-of select="article[@index=1]/data/ITEM_NAME"/></fo:block>
					</fo:block-container>
					
					<fo:block-container position="absolute" overflow="hidden"  width="110px" height="36px" top="157px" left="5px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="36pt" font-weight="bold" color="#FFFFFF" background-color="#000000" text-align="center">SALE</fo:block>
					</fo:block-container>
						
					<fo:block-container position="absolute" overflow="hidden"  width="130px" height="36px" top="190px" left="5px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="36pt" font-weight="bold" color="#000000" background-color="#FFFFFF" text-align="left" text-decoration="line-through"><xsl:value-of select="article[@index=1]/data/LIST_PRICE"/></fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" overflow="hidden"  width="283px" height="80px" top="157px" left="117px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-weight="bold"  font-size="72pt" color="#FF0000" background-color="#FFFFFF" text-align="right">$<xsl:value-of select="article[@index=1]/data/SALE_PRICE"/></fo:block>
					</fo:block-container>
					
					<fo:block-container position="absolute" >
						<fo:block>
							<fo:instream-foreign-object xmlns:svg="http://www.w3.org/2000/svg">
								<svg:svg><svg:line  x1="0px" y1="240px" x2="400px" y2="240px" style="stroke:#000000;fill:none;stroke-width:1"/></svg:svg>
							</fo:instream-foreign-object>
						</fo:block>
					</fo:block-container>
					
					<fo:block-container position="absolute" overflow="hidden"  width="100px" height="14px" top="245px" left="0px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="12pt" color="#000000" background-color="#FFFFFF" text-align="left"><xsl:value-of select="article[@index=1]/data/ARTICLE_ID"/></fo:block>
					</fo:block-container>
				
					<fo:block-container position="absolute" overflow="hidden"  width="100px" height="14px" top="245px" left="300px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="12pt" color="#000000" background-color="#FFFFFF" text-align="right"><xsl:value-of select="article[@index=1]/data/BARCODE"/></fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" overflow="hidden"  width="100px" height="16px" top="284px" left="0px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="16pt" color="#000000" background-color="#FFFFFF" text-align="left"><xsl:value-of select="article[@index=1]/data/ORIGIN"/></fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" overflow="hidden"  width="200px" height="16px" top="284px" left="200px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="16pt" color="#000000" background-color="#FFFFFF" text-align="right"><xsl:value-of select="article[@index=1]/data/MANUFACTURER"/></fo:block>
					</fo:block-container>

				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>
