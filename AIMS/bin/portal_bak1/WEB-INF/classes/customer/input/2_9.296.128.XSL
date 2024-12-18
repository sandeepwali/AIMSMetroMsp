<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes"/>
	<xsl:param name="versionParam" select="'1.0'"/> 
	<xsl:template match="articles">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4" page-height="128px" page-width="296px">
					<fo:region-body/>
				</fo:simple-page-master>
			</fo:layout-master-set>
			<fo:page-sequence master-reference="simpleA4">
				<fo:flow flow-name="xsl-region-body">

					<fo:block-container position="absolute" overflow="hidden"  width="296px" height="32px" top="0px" left="0px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="16pt" font-weight="bold" color="#000000" background-color="#FFFFFF" text-align="left"><xsl:value-of select="article[@index=1]/data/ITEM_NAME"/></fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" overflow="hidden"  width="70px" height="32px" top="40px" left="5px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="20pt" font-weight="bold" color="#FFFFFF" background-color="#000000" text-align="center">SALE</fo:block>
					</fo:block-container>
					
					<fo:block-container position="absolute" overflow="hidden"  width="130px" height="32px" top="70px" left="5px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="20pt" font-weight="bold" color="#000000" background-color="#FFFFFF" text-align="left" text-decoration="line-through"><xsl:value-of select="article[@index=1]/data/LIST_PRICE"/></fo:block>
					</fo:block-container>
					
					<fo:block-container position="absolute" overflow="hidden"  width="210px" height="72px" top="40px" left="86px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="64pt" font-weight="bold" color="#000000" background-color="#FFFFFF" text-align="right">$<xsl:value-of select="article[@index=1]/data/SALE_PRICE"/></fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" overflow="visible">
						<fo:block>
							<fo:instream-foreign-object xmlns:svg="http://www.w3.org/2000/svg">
								<svg:svg><svg:line  x1="0px" y1="96px" x2="296px" y2="96px" style="stroke:#000000;fill:none;stroke-width:1"/></svg:svg>
							</fo:instream-foreign-object>
						</fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" overflow="hidden"  width="100px" height="14px" top="100px" left="0px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="12pt" color="#000000" background-color="#FFFFFF" text-align="left"><xsl:value-of select="article[@index=1]/data/ORIGIN"/></fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" overflow="hidden"  width="100px" height="14px" top="114px" left="0px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="12pt" color="#000000" background-color="#FFFFFF" text-align="left"><xsl:value-of select="article[@index=1]/data/MANUFACTURER"/></fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" overflow="hidden"  width="60px" height="14px" top="100px" left="136px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="12pt" color="#000000" background-color="#FFFFFF" text-align="left">Article ID :</fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" overflow="hidden"  width="100px" height="14px" top="100px" left="198px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="12pt" color="#000000" background-color="#FFFFFF" text-align="right"><xsl:value-of select="article[@index=1]/data/ARTICLE_ID"/></fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" overflow="hidden"  width="60px" height="14px" top="114px" left="136px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="12pt" color="#000000" background-color="#FFFFFF" text-align="left">Barcode :</fo:block>
					</fo:block-container>

					<fo:block-container position="absolute" overflow="hidden"  width="100px" height="14px" top="114px" left="198px">
						<fo:block position="absolute"  line-height = "1" white-space="pre" font-family="Arial" font-size="12pt" color="#000000" background-color="#FFFFFF" text-align="right"><xsl:value-of select="article[@index=1]/data/BARCODE"/></fo:block>
					</fo:block-container>

				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>
