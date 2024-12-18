<?xml version="1.0" encoding="UTF-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" exclude-result-prefixes="fo">
	<xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes"/>
	<xsl:param name="versionParam" select="'1.0'"/> 
	<xsl:template match="articles">
		<fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">

			<!-- The size of the label -->
			<xsl:variable name="labelWidth"><xsl:value-of select="enddevice/displayWidth"/></xsl:variable>
			<xsl:variable name="labelHeight"><xsl:value-of select="enddevice/displayHeight"/></xsl:variable>
			
			<!-- The size of the image -->
			<xsl:variable name="pageWidth"><xsl:value-of select='$labelWidth'/></xsl:variable>
			<xsl:variable name="pageHeight"><xsl:value-of select='$labelHeight'/></xsl:variable>
			
			<!-- The notification Message -->
			<xsl:variable name="notiMessage">No Article Information</xsl:variable>
			<xsl:variable name="notiMessageFontSize"><xsl:value-of select='$labelWidth div 15'/></xsl:variable>
			<xsl:variable name="notiMessageHeight"><xsl:value-of select='$notiMessageFontSize + 2'/></xsl:variable>
			<xsl:variable name="notiMessageTop"><xsl:value-of select='($labelHeight div 3.5)'/></xsl:variable>
			<xsl:variable name="notiMessageLeft">0</xsl:variable>
			
			<!-- The barcode image -->
			<xsl:variable name="barcodeMessage"><xsl:value-of select="article[@index=1]/data/ARTICLE_ID"/></xsl:variable>
			<xsl:variable name="barcodeModule">
				<xsl:choose>
					<xsl:when test="$labelWidth &lt; 260">1</xsl:when> 
					<xsl:when test="$labelWidth &lt; 410">2</xsl:when> 
					<xsl:when test="$labelWidth &lt; 1000 and $labelHeight &lt; 200">2</xsl:when>
					<xsl:when test="$labelWidth &lt; 1000">3</xsl:when>
					<xsl:when test="$labelWidth &lt; 1200">5</xsl:when> 
					<xsl:otherwise>8</xsl:otherwise>
				</xsl:choose>
			</xsl:variable>
			<xsl:variable name="barcodeHeight"><xsl:value-of select='$barcodeModule * 7'/></xsl:variable>
			<xsl:variable name="barcodeTop"><xsl:value-of select='$notiMessageTop + $notiMessageHeight'/></xsl:variable>
			<xsl:variable name="barcodeLeft">0</xsl:variable>
			
			<!-- The article ID -->
			<xsl:variable name="articleId"><xsl:value-of select="article[@index=1]/data/ARTICLE_ID"/> (<xsl:value-of select="article[@index=1]/data/STATION_CODE"/>)</xsl:variable>
			<xsl:variable name="articleIdFontSize"><xsl:value-of select='$labelWidth div 18'/></xsl:variable>
			<xsl:variable name="articleIdHeight"><xsl:value-of select='$articleIdFontSize + 2'/></xsl:variable>
			<xsl:variable name="articleIdTop"><xsl:value-of select='$barcodeTop + ($barcodeHeight*3)'/></xsl:variable>
			<xsl:variable name="articleIdLeft">0</xsl:variable>
			
			<fo:layout-master-set>
				<fo:simple-page-master master-name="simpleA4" page-height="{$pageHeight}" page-width="{$pageWidth}">
					<fo:region-body/>
				</fo:simple-page-master>
			</fo:layout-master-set>
			
			<fo:page-sequence master-reference="simpleA4">
				<fo:flow flow-name="xsl-region-body">
					<!-- The notification Message -->
					<fo:block-container top="{$notiMessageTop}" left="{$notiMessageLeft}" width="{$pageWidth}" height="{$notiMessageHeight}"  position="absolute" overflow="hidden"  >
						<fo:block font-family="Arial" font-size="{$notiMessageFontSize}" font-weight="bold" text-align="center" color="#000000" background-color="#FFFFFF" position="absolute" line-height = "1" white-space="pre">
							<xsl:value-of select="$notiMessage"/>
						</fo:block>
					</fo:block-container>
					
					<!-- The barcode image -->
					<fo:block-container position="absolute" top="{$barcodeTop}" left="{$barcodeLeft}" width="{$pageWidth}" background-color="#FFFFFF">
						<fo:block text-align="center">
							<fo:instream-foreign-object>
								<barcode:barcode xmlns:barcode="http://barcode4j.krysalis.org/ns" message="{$barcodeMessage}">
									<barcode:CODE128>
										<barcode:height><xsl:value-of select='$barcodeHeight'/></barcode:height>
										<barcode:module-width><xsl:value-of select='$barcodeModule'/>pt</barcode:module-width>
										<barcode:human-readable>
											<barcode:placement>none</barcode:placement>
										</barcode:human-readable>
									</barcode:CODE128>
								</barcode:barcode>
							</fo:instream-foreign-object>
						</fo:block>
					</fo:block-container>
					
					<!-- The article ID -->
					<fo:block-container top="{$articleIdTop}" left="{$articleIdLeft}" width="{$pageWidth}" height="{$articleIdHeight}"  position="absolute" overflow="hidden"  >
						<fo:block font-family="Arial" font-size="{$articleIdFontSize}" font-weight="bold" text-align="center" color="#000000" background-color="#FFFFFF" position="absolute" line-height = "1" white-space="pre">
							<xsl:value-of select="$articleId"/>
						</fo:block>
					</fo:block-container>
				</fo:flow>
			</fo:page-sequence>
		</fo:root>
	</xsl:template>
</xsl:stylesheet>
