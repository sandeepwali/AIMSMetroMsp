<?xml version="1.0" encoding="utf-8"?>
<xsl:stylesheet version="1.1" xmlns:xsl="http://www.w3.org/1999/XSL/Transform" xmlns:fo="http://www.w3.org/1999/XSL/Format" xmlns:ext="http://exslt.org/common" xmlns:svg="http://www.w3.org/2000/svg" xmlns:dgext="xalan://com.diatoz.graphics.GraphicsUtils" exclude-result-prefixes="fo">
  <xsl:output method="xml" version="1.0" omit-xml-declaration="no" indent="yes"/>
  <xsl:param name="versionParam" select="1.0"/>
  <xsl:decimal-format name="euro" decimal-separator="," grouping-separator="." NaN="0"/>
  <xsl:decimal-format name="usa" decimal-separator="." grouping-separator="," NaN="0"/>
  <!-- Define variables -->
  <xsl:variable name="sale_price_1_1" select="articles/article[@index=1]/data/SALE_PRICE"/>
  <xsl:variable name="a_marker_1_1" select="articles/article[@index=1]/data/A_MARKER"/>
  <xsl:variable name="r_marker_1_1" select="articles/article[@index=1]/data/R_MARKER"/>
  <xsl:variable name="unit_dimension_1_1" select="articles/article[@index=1]/data/UNIT_DIMENSION"/>
  <xsl:variable name="weight_unit_1_1" select="articles/article[@index=1]/data/WEIGHT_UNIT"/>
  <xsl:variable name="etc_0_1_1" select="articles/article[@index=1]/data/ETC_0"/>
  <xsl:variable name="unit_price_1_1" select="articles/article[@index=1]/data/UNIT_PRICE"/>
  <xsl:variable name="etc_1_1_1" select="articles/article[@index=1]/data/ETC_1"/>
  <xsl:variable name="etc_2_1_1" select="articles/article[@index=1]/data/ETC_2"/>
  <xsl:variable name="etc_3_1_1" select="articles/article[@index=1]/data/ETC_3"/>
  <xsl:template match="articles[@page=1]">
    <fo:root xmlns:fo="http://www.w3.org/1999/XSL/Format">
      <fo:layout-master-set>
        <fo:simple-page-master master-name="simpleA4" page-height="144px" page-width="200px">
          <fo:region-body/>
        </fo:simple-page-master>
      </fo:layout-master-set>
      <fo:page-sequence master-reference="simpleA4">
        <fo:flow flow-name="xsl-region-body">
          <fo:block-container position="absolute" overflow="hidden" width="200px" height="144px" top="0px" left="0px" color="#000000" background-color="#FFFFFF">
            <fo:block line-height="0.9">
              <fo:instream-foreign-object>
                <svg xmlns="http://www.w3.org/2000/svg" xmlns:xlink="http://www.w3.org/1999/xlink" version="1.1" width="200" height="144" viewBox="0 0 200 144" xml:space="preserve">
	<g transform="translate(101 33)">
		<rect opacity="0" fill="rgb(255,255,255)" x="-96" y="-26" width="190" height="50"></rect>
		<text xml:space="preserve" font-family="Seven Segment" font-size="65" font-weight="bold" style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1; white-space: pre;" text-rendering="optimizeLegibility" id="0"><xsl:call-template name="wordwrap">
<xsl:with-param name="productFieldValue" select="$sale_price_1_1"></xsl:with-param>
<xsl:with-param name="currencyPosition" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencySign" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormat" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormatType" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyCode" select="&quot;&quot;"></xsl:with-param>         
<xsl:with-param name="textAnchor" select="&quot;end&quot;"></xsl:with-param>
<xsl:with-param name="fontFamily" select="&quot;Seven Segment&quot;"></xsl:with-param>
<xsl:with-param name="fontWeight" select="2.0f"></xsl:with-param>
<xsl:with-param name="fontStyle" select="0.0f"></xsl:with-param>
<xsl:with-param name="fontSize" select="65"></xsl:with-param>
<xsl:with-param name="textWidth" select="190"></xsl:with-param>
<xsl:with-param name="textHeight" select="50"></xsl:with-param>
<xsl:with-param name="lineHeight" select="88.13999999999999"></xsl:with-param>
<xsl:with-param name="textLineHeight" select="73"></xsl:with-param>
<xsl:with-param name="tspanX" select="94"></xsl:with-param>
<xsl:with-param name="tspanY" select="32.14"></xsl:with-param>
<xsl:with-param name="textVertAlign" select="&quot;top&quot;"></xsl:with-param>
<xsl:with-param name="zeroformatEnabled" select="&quot;false&quot;"></xsl:with-param>
</xsl:call-template></text>
	</g>
	<g transform="translate(162 84)">
		<rect opacity="0" fill="rgb(255,255,255)" x="-17" y="-19" width="33" height="36"></rect>
		<text xml:space="preserve" font-family="Arial" font-size="30" font-weight="bold" style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1; white-space: pre;" text-rendering="optimizeLegibility" id="0"><xsl:call-template name="wordwrap">
<xsl:with-param name="productFieldValue" select="$a_marker_1_1"></xsl:with-param>
<xsl:with-param name="currencyPosition" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencySign" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormat" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormatType" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyCode" select="&quot;&quot;"></xsl:with-param>         
<xsl:with-param name="textAnchor" select="&quot;start&quot;"></xsl:with-param>
<xsl:with-param name="fontFamily" select="&quot;Arial&quot;"></xsl:with-param>
<xsl:with-param name="fontWeight" select="2.0f"></xsl:with-param>
<xsl:with-param name="fontStyle" select="0.0f"></xsl:with-param>
<xsl:with-param name="fontSize" select="30"></xsl:with-param>
<xsl:with-param name="textWidth" select="33"></xsl:with-param>
<xsl:with-param name="textHeight" select="36"></xsl:with-param>
<xsl:with-param name="lineHeight" select="44.06999999999999"></xsl:with-param>
<xsl:with-param name="textLineHeight" select="34"></xsl:with-param>
<xsl:with-param name="tspanX" select="-17"></xsl:with-param>
<xsl:with-param name="tspanY" select="8.37"></xsl:with-param>
<xsl:with-param name="textVertAlign" select="&quot;top&quot;"></xsl:with-param>
<xsl:with-param name="zeroformatEnabled" select="&quot;false&quot;"></xsl:with-param>
</xsl:call-template></text>
	</g>
	<g transform="translate(187 84)">
		<rect opacity="0" fill="rgb(255,255,255)" x="-17" y="-19" width="33" height="36"></rect>
		<text xml:space="preserve" font-family="Arial" font-size="30" font-weight="bold" style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1; white-space: pre;" text-rendering="optimizeLegibility" id="0"><xsl:call-template name="wordwrap">
<xsl:with-param name="productFieldValue" select="$r_marker_1_1"></xsl:with-param>
<xsl:with-param name="currencyPosition" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencySign" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormat" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormatType" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyCode" select="&quot;&quot;"></xsl:with-param>         
<xsl:with-param name="textAnchor" select="&quot;start&quot;"></xsl:with-param>
<xsl:with-param name="fontFamily" select="&quot;Arial&quot;"></xsl:with-param>
<xsl:with-param name="fontWeight" select="2.0f"></xsl:with-param>
<xsl:with-param name="fontStyle" select="0.0f"></xsl:with-param>
<xsl:with-param name="fontSize" select="30"></xsl:with-param>
<xsl:with-param name="textWidth" select="33"></xsl:with-param>
<xsl:with-param name="textHeight" select="36"></xsl:with-param>
<xsl:with-param name="lineHeight" select="44.06999999999999"></xsl:with-param>
<xsl:with-param name="textLineHeight" select="34"></xsl:with-param>
<xsl:with-param name="tspanX" select="-17"></xsl:with-param>
<xsl:with-param name="tspanY" select="8.37"></xsl:with-param>
<xsl:with-param name="textVertAlign" select="&quot;top&quot;"></xsl:with-param>
<xsl:with-param name="zeroformatEnabled" select="&quot;false&quot;"></xsl:with-param>
</xsl:call-template></text>
	</g>
	<g transform="translate(21 123)">
		<rect opacity="0" fill="rgb(255,255,255)" x="-31" y="-18" width="60" height="35"></rect>
		<text xml:space="preserve" font-family="Seven Segment" font-size="30" font-weight="bold" style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1; white-space: pre;" text-rendering="optimizeLegibility" id="0"><xsl:call-template name="wordwrap">
<xsl:with-param name="productFieldValue" select="$unit_dimension_1_1"></xsl:with-param>
<xsl:with-param name="currencyPosition" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencySign" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormat" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormatType" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyCode" select="&quot;&quot;"></xsl:with-param>         
<xsl:with-param name="textAnchor" select="&quot;end&quot;"></xsl:with-param>
<xsl:with-param name="fontFamily" select="&quot;Seven Segment&quot;"></xsl:with-param>
<xsl:with-param name="fontWeight" select="2.0f"></xsl:with-param>
<xsl:with-param name="fontStyle" select="0.0f"></xsl:with-param>
<xsl:with-param name="fontSize" select="30"></xsl:with-param>
<xsl:with-param name="textWidth" select="60"></xsl:with-param>
<xsl:with-param name="textHeight" select="35"></xsl:with-param>
<xsl:with-param name="lineHeight" select="39.32399999999999"></xsl:with-param>
<xsl:with-param name="textLineHeight" select="34"></xsl:with-param>
<xsl:with-param name="tspanX" select="29"></xsl:with-param>
<xsl:with-param name="tspanY" select="8.87"></xsl:with-param>
<xsl:with-param name="textVertAlign" select="&quot;top&quot;"></xsl:with-param>
<xsl:with-param name="zeroformatEnabled" select="&quot;false&quot;"></xsl:with-param>
</xsl:call-template></text>
	</g>
	<g transform="translate(66 139)">
		<rect opacity="0" fill="rgb(255,255,255)" x="-16" y="-19" width="30" height="36"></rect>
		<text xml:space="preserve" font-family="Arial" font-size="20" style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1; white-space: pre;" text-rendering="optimizeLegibility" id="0"><xsl:call-template name="wordwrap">
<xsl:with-param name="productFieldValue" select="$weight_unit_1_1"></xsl:with-param>
<xsl:with-param name="currencyPosition" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencySign" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormat" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormatType" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyCode" select="&quot;&quot;"></xsl:with-param>         
<xsl:with-param name="textAnchor" select="&quot;start&quot;"></xsl:with-param>
<xsl:with-param name="fontFamily" select="&quot;Arial&quot;"></xsl:with-param>
<xsl:with-param name="fontWeight" select="1.0f"></xsl:with-param>
<xsl:with-param name="fontStyle" select="0.0f"></xsl:with-param>
<xsl:with-param name="fontSize" select="20"></xsl:with-param>
<xsl:with-param name="textWidth" select="30"></xsl:with-param>
<xsl:with-param name="textHeight" select="36"></xsl:with-param>
<xsl:with-param name="lineHeight" select="26.215999999999998"></xsl:with-param>
<xsl:with-param name="textLineHeight" select="23"></xsl:with-param>
<xsl:with-param name="tspanX" select="-16"></xsl:with-param>
<xsl:with-param name="tspanY" select="-0.42"></xsl:with-param>
<xsl:with-param name="textVertAlign" select="&quot;top&quot;"></xsl:with-param>
<xsl:with-param name="zeroformatEnabled" select="&quot;false&quot;"></xsl:with-param>
</xsl:call-template></text>
	</g>
	<g transform="translate(66 119)">
		<rect opacity="0" fill="rgb(255,255,255)" x="-16" y="-19" width="30" height="36"></rect>
		<text xml:space="preserve" font-family="Arial" font-size="20" style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1; white-space: pre;" text-rendering="optimizeLegibility" id="0"><xsl:call-template name="wordwrap">
<xsl:with-param name="productFieldValue" select="$etc_0_1_1"></xsl:with-param>
<xsl:with-param name="currencyPosition" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencySign" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormat" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormatType" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyCode" select="&quot;&quot;"></xsl:with-param>         
<xsl:with-param name="textAnchor" select="&quot;start&quot;"></xsl:with-param>
<xsl:with-param name="fontFamily" select="&quot;Arial&quot;"></xsl:with-param>
<xsl:with-param name="fontWeight" select="1.0f"></xsl:with-param>
<xsl:with-param name="fontStyle" select="0.0f"></xsl:with-param>
<xsl:with-param name="fontSize" select="20"></xsl:with-param>
<xsl:with-param name="textWidth" select="30"></xsl:with-param>
<xsl:with-param name="textHeight" select="36"></xsl:with-param>
<xsl:with-param name="lineHeight" select="26.215999999999998"></xsl:with-param>
<xsl:with-param name="textLineHeight" select="23"></xsl:with-param>
<xsl:with-param name="tspanX" select="-16"></xsl:with-param>
<xsl:with-param name="tspanY" select="-0.42"></xsl:with-param>
<xsl:with-param name="textVertAlign" select="&quot;top&quot;"></xsl:with-param>
<xsl:with-param name="zeroformatEnabled" select="&quot;false&quot;"></xsl:with-param>
</xsl:call-template></text>
	</g>
	<g transform="translate(88 121)">
		<rect opacity="0" fill="rgb(255,255,255)" x="-11" y="-16" width="20" height="30"></rect>
		<text xml:space="preserve" font-family="Arial" font-size="30" style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1; white-space: pre;" text-rendering="optimizeLegibility" id="0"><tspan x="-10" y="11.37">=</tspan></text>
	</g>
	<g transform="translate(136 124)">
		<rect opacity="0" fill="rgb(255,255,255)" x="-51" y="-19" width="100" height="36"></rect>
		<text xml:space="preserve" font-family="Seven Segment" font-size="30" font-weight="bold" style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1; white-space: pre;" text-rendering="optimizeLegibility" id="0"><xsl:call-template name="wordwrap">
<xsl:with-param name="productFieldValue" select="$unit_price_1_1"></xsl:with-param>
<xsl:with-param name="currencyPosition" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencySign" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormat" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormatType" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyCode" select="&quot;&quot;"></xsl:with-param>         
<xsl:with-param name="textAnchor" select="&quot;end&quot;"></xsl:with-param>
<xsl:with-param name="fontFamily" select="&quot;Seven Segment&quot;"></xsl:with-param>
<xsl:with-param name="fontWeight" select="2.0f"></xsl:with-param>
<xsl:with-param name="fontStyle" select="0.0f"></xsl:with-param>
<xsl:with-param name="fontSize" select="30"></xsl:with-param>
<xsl:with-param name="textWidth" select="100"></xsl:with-param>
<xsl:with-param name="textHeight" select="36"></xsl:with-param>
<xsl:with-param name="lineHeight" select="39.32399999999999"></xsl:with-param>
<xsl:with-param name="textLineHeight" select="34"></xsl:with-param>
<xsl:with-param name="tspanX" select="49"></xsl:with-param>
<xsl:with-param name="tspanY" select="8.37"></xsl:with-param>
<xsl:with-param name="textVertAlign" select="&quot;top&quot;"></xsl:with-param>
<xsl:with-param name="zeroformatEnabled" select="&quot;false&quot;"></xsl:with-param>
</xsl:call-template></text>
	</g>
	<g transform="translate(196 130)">
		<rect opacity="0" fill="rgb(255,255,255)" x="-11" y="-18" width="20" height="34"></rect>
		<text xml:space="preserve" font-family="Arial" font-size="20" font-style="normal" style="stroke: rgb(255,255,255); stroke-opacity: 0; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1; white-space: pre;" text-rendering="optimizeLegibility"><tspan x="-10" y="0.58">€</tspan></text>
	</g>
	<g transform="translate(61 89)">
		<rect opacity="0" fill="rgb(255,255,255)" x="-11" y="-19" width="20" height="36"></rect>
		<text xml:space="preserve" font-family="Arial" font-size="20" style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1; white-space: pre;" text-rendering="optimizeLegibility" id="0"><xsl:call-template name="wordwrap">
<xsl:with-param name="productFieldValue" select="$etc_1_1_1"></xsl:with-param>
<xsl:with-param name="currencyPosition" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencySign" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormat" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormatType" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyCode" select="&quot;&quot;"></xsl:with-param>         
<xsl:with-param name="textAnchor" select="&quot;start&quot;"></xsl:with-param>
<xsl:with-param name="fontFamily" select="&quot;Arial&quot;"></xsl:with-param>
<xsl:with-param name="fontWeight" select="1.0f"></xsl:with-param>
<xsl:with-param name="fontStyle" select="0.0f"></xsl:with-param>
<xsl:with-param name="fontSize" select="20"></xsl:with-param>
<xsl:with-param name="textWidth" select="20"></xsl:with-param>
<xsl:with-param name="textHeight" select="36"></xsl:with-param>
<xsl:with-param name="lineHeight" select="26.215999999999998"></xsl:with-param>
<xsl:with-param name="textLineHeight" select="23"></xsl:with-param>
<xsl:with-param name="tspanX" select="-11"></xsl:with-param>
<xsl:with-param name="tspanY" select="-0.42"></xsl:with-param>
<xsl:with-param name="textVertAlign" select="&quot;top&quot;"></xsl:with-param>
<xsl:with-param name="zeroformatEnabled" select="&quot;false&quot;"></xsl:with-param>
</xsl:call-template></text>
	</g>
	<g transform="translate(81 81)">
		<rect opacity="0" fill="rgb(255,255,255)" x="-11" y="-19" width="20" height="36"></rect>
		<text xml:space="preserve" font-family="Arial" font-size="28" style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1; white-space: pre;" text-rendering="optimizeLegibility" id="0"><xsl:call-template name="wordwrap">
<xsl:with-param name="productFieldValue" select="$etc_2_1_1"></xsl:with-param>
<xsl:with-param name="currencyPosition" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencySign" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormat" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormatType" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyCode" select="&quot;&quot;"></xsl:with-param>         
<xsl:with-param name="textAnchor" select="&quot;start&quot;"></xsl:with-param>
<xsl:with-param name="fontFamily" select="&quot;Arial&quot;"></xsl:with-param>
<xsl:with-param name="fontWeight" select="1.0f"></xsl:with-param>
<xsl:with-param name="fontStyle" select="0.0f"></xsl:with-param>
<xsl:with-param name="fontSize" select="28"></xsl:with-param>
<xsl:with-param name="textWidth" select="20"></xsl:with-param>
<xsl:with-param name="textHeight" select="36"></xsl:with-param>
<xsl:with-param name="lineHeight" select="36.70239999999999"></xsl:with-param>
<xsl:with-param name="textLineHeight" select="32"></xsl:with-param>
<xsl:with-param name="tspanX" select="-11"></xsl:with-param>
<xsl:with-param name="tspanY" select="6.62"></xsl:with-param>
<xsl:with-param name="textVertAlign" select="&quot;top&quot;"></xsl:with-param>
<xsl:with-param name="zeroformatEnabled" select="&quot;false&quot;"></xsl:with-param>
</xsl:call-template></text>
	</g>
	<g transform="translate(151 82)">
		<rect opacity="0" fill="rgb(255,255,255)" x="-61" y="-19" width="120" height="36"></rect>
		<text xml:space="preserve" font-family="Arial" font-size="30" style="stroke: none; stroke-width: 1; stroke-dasharray: none; stroke-linecap: butt; stroke-linejoin: miter; stroke-miterlimit: 4; fill: rgb(0,0,0); fill-rule: nonzero; opacity: 1; white-space: pre;" text-rendering="optimizeLegibility" id="0"><xsl:call-template name="wordwrap">
<xsl:with-param name="productFieldValue" select="$etc_3_1_1"></xsl:with-param>
<xsl:with-param name="currencyPosition" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencySign" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormat" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyFormatType" select="&quot;&quot;"></xsl:with-param>
<xsl:with-param name="currencyCode" select="&quot;&quot;"></xsl:with-param>         
<xsl:with-param name="textAnchor" select="&quot;start&quot;"></xsl:with-param>
<xsl:with-param name="fontFamily" select="&quot;Arial&quot;"></xsl:with-param>
<xsl:with-param name="fontWeight" select="1.0f"></xsl:with-param>
<xsl:with-param name="fontStyle" select="0.0f"></xsl:with-param>
<xsl:with-param name="fontSize" select="30"></xsl:with-param>
<xsl:with-param name="textWidth" select="120"></xsl:with-param>
<xsl:with-param name="textHeight" select="36"></xsl:with-param>
<xsl:with-param name="lineHeight" select="39.32399999999999"></xsl:with-param>
<xsl:with-param name="textLineHeight" select="34"></xsl:with-param>
<xsl:with-param name="tspanX" select="-61"></xsl:with-param>
<xsl:with-param name="tspanY" select="8.37"></xsl:with-param>
<xsl:with-param name="textVertAlign" select="&quot;top&quot;"></xsl:with-param>
<xsl:with-param name="zeroformatEnabled" select="&quot;false&quot;"></xsl:with-param>
</xsl:call-template></text>
	</g>
</svg>
              </fo:instream-foreign-object>
            </fo:block>
          </fo:block-container>
        </fo:flow>
      </fo:page-sequence>
    </fo:root>
  </xsl:template>
  <xsl:template name="wordwrap">
		<xsl:param name="productFieldValue"/>
		<xsl:param name="textAnchor"/>
		<xsl:param name="textVertAlign"/>
		<xsl:param name="textWidth"/>
		<xsl:param name="textHeight"/>
		<xsl:param name="lineHeight"/>
		<xsl:param name="textLineHeight"/>
		<xsl:param name="fontFamily"/>
		<xsl:param name="fontStyle"/>
		<xsl:param name="fontWeight"/>
		<xsl:param name="fontSize"/>
		<xsl:param name="tspanX"/>
		<xsl:param name="tspanY"/>
		<xsl:param name="currencySign"/>
		<xsl:param name="currencyPosition"/>
		<xsl:param name="currencyFormat"/>
    <xsl:param name="currencyFormatType"/>
    <xsl:param name="currencyCode"/>
    <xsl:param name="zeroformatEnabled"/>
    <xsl:param name="text_decoration_overline"/>
    <xsl:param name="text_decoration_underline"/>
    <xsl:param name="text_decoration_strikethrough"/>
		<xsl:variable name="commaValidation">
			<xsl:value-of select="translate($productFieldValue, ',', '.')"/>
    </xsl:variable>
    <xsl:variable name="newtSpanX">
			<xsl:value-of  select="$tspanX"/>
    </xsl:variable>
		<xsl:variable name="currencyfiedString">
			<xsl:choose>
				<xsl:when test="number($productFieldValue) = $productFieldValue">
					<xsl:call-template name="addCurrencySign">
						<xsl:with-param name="productFieldValue" select="$commaValidation"/>
						<xsl:with-param name="currencySign" select="$currencySign"/>
						<xsl:with-param name="currencyPosition" select="$currencyPosition"/>
						<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
            <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
            <xsl:with-param name="currencyCode" select="$currencyCode"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:when test="number($commaValidation) = $commaValidation">
					<xsl:call-template name="addCurrencySign">
						<xsl:with-param name="productFieldValue" select="$commaValidation"/>
						<xsl:with-param name="currencySign" select="$currencySign"/>
						<xsl:with-param name="currencyPosition" select="$currencyPosition"/>
						<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
            <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
            <xsl:with-param name="currencyCode" select="$currencyCode"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$productFieldValue"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="vrtfSplitWords">
			<xsl:call-template name="split">
				<xsl:with-param name="pText" select="$currencyfiedString"/>
				<xsl:with-param name="delimiter" select="' '"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="vSplitWords" select="ext:node-set($vrtfSplitWords)/*"/>
		<!--  got the first word -->
		<xsl:variable name="word">
			<xsl:value-of select="$vSplitWords[1]"/>
		</xsl:variable>
		<xsl:variable name="linesElement">
			<xsl:call-template name="wordwrap_createtspan_cal_totalTextHeight">
				<xsl:with-param name="node" select="$vSplitWords"/>
				<xsl:with-param name="position" select="1"/>
				<xsl:with-param name="word" select="($word)"/>
				<xsl:with-param name="size" select="count($vSplitWords)"/>
				<xsl:with-param name="noOfLine" select="0"/>
				<xsl:with-param name="textAnchor" select="$textAnchor"/>
				<xsl:with-param name="textWidth" select="$textWidth"/>
				<xsl:with-param name="textHeight" select="$textHeight"/>
				<xsl:with-param name="fontFamily" select="$fontFamily"/>
				<xsl:with-param name="fontStyle" select="$fontStyle"/>
				<xsl:with-param name="fontSize" select="$fontSize"/>
				<xsl:with-param name="fontWeight" select="$fontWeight"/>
				<xsl:with-param name="lineHeight" select="$lineHeight"/>
				<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
				<xsl:with-param name="tspanX" select="$newtSpanX"/>
				<xsl:with-param name="tspanY" select="$tspanY"/>
				<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
				<xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
				<xsl:with-param name="currencySign" select="$currencySign"/>
				<xsl:with-param name="currencyfiedString" select="$currencyfiedString"/>
			</xsl:call-template>
		</xsl:variable>
		<xsl:variable name="linesArray" select="ext:node-set($linesElement)/*"/>
    <xsl:variable name="verticalAlignOffset">
      <xsl:if test="$textVertAlign = 'middle'">
        <xsl:value-of select="(($textHeight - ($lineHeight * count($linesArray))) div 2) + (($lineHeight - $textLineHeight) div 2) - (($textHeight - ($lineHeight * 1)) div 2)"/>
      </xsl:if>
      <xsl:if test="$textVertAlign = 'bottom'">
        <xsl:value-of select="(($textHeight - $lineHeight * count($linesArray))) + (($lineHeight - $textLineHeight) div 2) - ($textHeight - ($lineHeight * 1))"/>
      </xsl:if>
      <xsl:if test="$textVertAlign = 'top'">
        <xsl:value-of select="0"/>
      </xsl:if>
    </xsl:variable>
		<xsl:call-template name="wordwrap_createtspan">
			<xsl:with-param name="node" select="$vSplitWords"/>
			<xsl:with-param name="position" select="1"/>
			<xsl:with-param name="word" select="($word)"/>
			<xsl:with-param name="size" select="count($vSplitWords)"/>
			<xsl:with-param name="noOfLine" select="0"/>
			<xsl:with-param name="textAnchor" select="$textAnchor"/>
			<xsl:with-param name="textWidth" select="$textWidth"/>
			<xsl:with-param name="textHeight" select="$textHeight"/>
			<xsl:with-param name="fontFamily" select="$fontFamily"/>
			<xsl:with-param name="fontStyle" select="$fontStyle"/>
			<xsl:with-param name="fontSize" select="$fontSize"/>
			<xsl:with-param name="fontWeight" select="$fontWeight"/>
			<xsl:with-param name="lineHeight" select="$lineHeight"/>
			<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
			<xsl:with-param name="tspanX" select="$newtSpanX"/>
			<xsl:with-param name="tspanY" select="$tspanY"/>
			<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
			<xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
			<xsl:with-param name="currencySign" select="$currencySign"/>
			<xsl:with-param name="currencyfiedString" select="$currencyfiedString"/>
			<xsl:with-param name="totalLines" select="count($linesArray)"/>
      <xsl:with-param name="verticalAlignOffset" select="$verticalAlignOffset"/>
      <xsl:with-param name="text_decoration_overline" select="$text_decoration_overline"/>      
      <xsl:with-param name="text_decoration_underline" select="$text_decoration_underline"/>      
      <xsl:with-param name="text_decoration_strikethrough" select="$text_decoration_strikethrough"/>    
      <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>  
		</xsl:call-template>
	</xsl:template>
  <xsl:template name="wordwrap_createtspan_cal_totalTextHeight">
		<xsl:param name="node"/>
		<xsl:param name="position"/>
		<xsl:param name="prevWord"/>
		<xsl:param name="word"/>
		<xsl:param name="size"/>
		<xsl:param name="noOfLine"/>
		<xsl:param name="textAnchor"/>
		<xsl:param name="textWidth"/>
		<xsl:param name="textHeight"/>
		<xsl:param name="lineHeight"/>
		<xsl:param name="textLineHeight"/>
		<xsl:param name="tspanX"/>
		<xsl:param name="tspanY"/>
		<xsl:param name="fontStyle"/>
		<xsl:param name="fontFamily"/>
		<xsl:param name="fontWeight"/>
		<xsl:param name="fontSize"/>
		<xsl:param name="currencyFormat"/>
		<xsl:param name="currencyFormatType"/>
		<xsl:param name="currencyfiedString"/>
		<xsl:param name="currencySign"/>
		<xsl:choose>
			<xsl:when test="dgext:getTextWidth($word, $fontFamily , $fontWeight , $fontStyle, $fontSize) >= $textWidth and $size > 1">
				<xsl:choose>
					<!-- check if prevword can only accomodate since current word has greater width -->
					<xsl:when test="(dgext:getTextWidth($prevWord, $fontFamily , $fontWeight , $fontStyle, $fontSize) &gt; 0) and (dgext:getTextWidth($word, $fontFamily , $fontWeight , $fontStyle, $fontSize) > $textWidth) and (dgext:getTextWidth($prevWord, $fontFamily , $fontWeight , $fontStyle, $fontSize) &lt; $textWidth)">
						<xsl:if test="$noOfLine &lt; (($textHeight - $lineHeight) div $lineHeight) or ($noOfLine = 0)">
							<xsl:element name="line">
								<xsl:value-of select="$prevWord"/>
							</xsl:element>
							<!-- <xsl:element name="svg:tspan"><xsl:attribute name="text-anchor"><xsl:value-of select="$textAnchor"/></xsl:attribute><xsl:attribute name="x"><xsl:value-of select="$tspanX"/></xsl:attribute><xsl:attribute name="y"><xsl:value-of select="$lineHeight * $noOfLine + $tspanY"/></xsl:attribute><xsl:value-of select="$prevWord"/></xsl:element> -->
						</xsl:if>
						<xsl:choose>
							<xsl:when test="count($node) > $position">
								<xsl:call-template name="wordwrap_createtspan_cal_totalTextHeight">
									<xsl:with-param name="node" select="$node"/>
									<xsl:with-param name="position" select="$position+1"/>
									<xsl:with-param name="prevWord" select="$node[$position]"></xsl:with-param>
									<xsl:with-param name="word" select="(concat($node[$position],' ',$node[$position+1]))"/>
									<xsl:with-param name="size" select="$size - 1"/>
									<xsl:with-param name="noOfLine" select="$noOfLine + 1"/>
									<xsl:with-param name="textAnchor" select="$textAnchor"/>
									<xsl:with-param name="textWidth" select="$textWidth"/>
									<xsl:with-param name="textHeight" select="$textHeight"/>
									<xsl:with-param name="fontFamily" select="$fontFamily"/>
									<xsl:with-param name="fontStyle" select="$fontStyle"/>
									<xsl:with-param name="fontSize" select="$fontSize"/>
									<xsl:with-param name="fontWeight" select="$fontWeight"/>
									<xsl:with-param name="lineHeight" select="$lineHeight"/>
									<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
									<xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
									<xsl:with-param name="currencyfiedString" select="$currencyfiedString"/>
									<xsl:with-param name="currencySign" select="$currencySign"/>
									<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
									<xsl:with-param name="tspanX" select="$tspanX"/>
									<xsl:with-param name="tspanY" select="$tspanY"/>
								</xsl:call-template>
							</xsl:when>
							<xsl:otherwise>
								<xsl:call-template name="wordwrap_createtspan_cal_totalTextHeight">
									<xsl:with-param name="node" select="$node"/>
									<xsl:with-param name="position" select="$position"/>
									<xsl:with-param name="prevWord" select="$node[$position]"></xsl:with-param>
									<xsl:with-param name="word" select="($node[$position])"/>
									<xsl:with-param name="size" select="$size"/>
									<xsl:with-param name="noOfLine" select="$noOfLine + 1"/>
									<xsl:with-param name="textAnchor" select="$textAnchor"/>
									<xsl:with-param name="textWidth" select="$textWidth"/>
									<xsl:with-param name="textHeight" select="$textHeight"/>
									<xsl:with-param name="fontFamily" select="$fontFamily"/>
									<xsl:with-param name="fontStyle" select="$fontStyle"/>
									<xsl:with-param name="fontSize" select="$fontSize"/>
									<xsl:with-param name="fontWeight" select="$fontWeight"/>
									<xsl:with-param name="lineHeight" select="$lineHeight"/>
									<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
									<xsl:with-param name="tspanX" select="$tspanX"/>
									<xsl:with-param name="tspanY" select="$tspanY"/>
									<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
									<xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
									<xsl:with-param name="currencyfiedString" select="$currencyfiedString"/>
									<xsl:with-param name="currencySign" select="$currencySign"/>
								</xsl:call-template>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:when>
					<xsl:otherwise>
						<xsl:if test="$noOfLine &lt; (($textHeight - $lineHeight) div $lineHeight)">
							<xsl:variable name="finalWord" >
								<xsl:call-template name="slice_text">
									<xsl:with-param name="textField" select="$word"/>
									<xsl:with-param name="position" select="0"/>
									<xsl:with-param name="finalText" select="''"/>
									<xsl:with-param name="fontFamily" select="$fontFamily"/>
									<xsl:with-param name="fontWeight" select="$fontWeight"/>
									<xsl:with-param name="fontStyle" select="$fontStyle"/>
									<xsl:with-param name="fontSize" select="$fontSize"/>
									<xsl:with-param name="textWidth" select="$textWidth"/>
								</xsl:call-template>
							</xsl:variable>
							<xsl:element name="line">
								<xsl:value-of select="$prevWord"/>
							</xsl:element>
							<!-- <xsl:element name="svg:tspan"><xsl:attribute name="text-anchor"><xsl:value-of select="$textAnchor"/></xsl:attribute><xsl:attribute name="x"><xsl:value-of select="$tspanX"/></xsl:attribute><xsl:attribute name="y"><xsl:value-of select="$lineHeight * $noOfLine + $tspanY"/></xsl:attribute><xsl:value-of select="$finalWord"/></xsl:element> -->
						</xsl:if>
						<xsl:call-template name="wordwrap_createtspan_cal_totalTextHeight">
							<xsl:with-param name="node" select="$node"/>
							<xsl:with-param name="position" select="$position + 1"/>
							<xsl:with-param name="word" select="($node[$position+1])"/>
							<xsl:with-param name="size" select="$size - 1"/>
							<xsl:with-param name="noOfLine" select="$noOfLine + 1"/>
							<xsl:with-param name="textWidth" select="$textWidth"/>
							<xsl:with-param name="textHeight" select="$textHeight"/>
							<xsl:with-param name="fontFamily" select="$fontFamily"/>
							<xsl:with-param name="fontStyle" select="$fontStyle"/>
							<xsl:with-param name="fontSize" select="$fontSize"/>
							<xsl:with-param name="fontWeight" select="$fontWeight"/>
							<xsl:with-param name="lineHeight" select="$lineHeight"/>
							<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
							<xsl:with-param name="textAnchor" select="$textAnchor"/>
							<xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
							<xsl:with-param name="currencySign" select="$currencySign"/>
							<xsl:with-param name="tspanX" select="$tspanX"/>
							<xsl:with-param name="tspanY" select="$tspanY"/>
						</xsl:call-template>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="$size = 1 and ($textWidth >= dgext:getTextWidth($word, $fontFamily , $fontWeight , $fontStyle, $fontSize))  and $currencyFormatType = ''">
						<xsl:if test="$noOfLine &lt; (($textHeight - $lineHeight) div $lineHeight) or ($noOfLine = 0)">
							<xsl:element name="line">
								<xsl:value-of select="$prevWord"/>
							</xsl:element>
							<!-- <xsl:element  name ="svg:tspan" ><xsl:attribute  name ="text-anchor" ><xsl:value-of  select =" $textAnchor" /></xsl:attribute><xsl:attribute  name ="x" ><xsl:value-of  select =" $tspanX" /></xsl:attribute><xsl:attribute  name ="y" ><xsl:value-of  select =" $lineHeight  *  $noOfLine  +  $tspanY" /></xsl:attribute><xsl:value-of  select =" $word" /></xsl:element> -->
						</xsl:if>
					</xsl:when>
					<xsl:when  test =" $size  =  1  and  string-length ( normalize-space ( $prevWord ))  >  0" >
						<xsl:if test="$noOfLine &lt; (($textHeight - $lineHeight) div $lineHeight) or ($noOfLine = 0)">
							<xsl:variable name="finalWord" >
								<xsl:call-template name="slice_text">
									<xsl:with-param name="textField" select="$prevWord"/>
									<xsl:with-param name="position" select="0"/>
									<xsl:with-param name="finalText" select="''"/>
									<xsl:with-param name="fontFamily" select="$fontFamily"/>
									<xsl:with-param name="fontWeight" select="$fontWeight"/>
									<xsl:with-param name="fontStyle" select="$fontStyle"/>
									<xsl:with-param name="fontSize" select="$fontSize"/>
									<xsl:with-param name="textWidth" select="$textWidth"/>
								</xsl:call-template>
							</xsl:variable>
							<xsl:element name="line">
								<xsl:value-of select="$prevWord"/>
							</xsl:element>
							<!-- <xsl:element name="svg:tspan"><xsl:attribute name="text-anchor"><xsl:value-of select="$textAnchor"/></xsl:attribute><xsl:attribute name="x"><xsl:value-of select="$tspanX"/></xsl:attribute><xsl:attribute name="y"><xsl:value-of select="$lineHeight * $noOfLine + $tspanY"/></xsl:attribute><xsl:value-of select="$finalWord"/></xsl:element> -->
						</xsl:if>
						<xsl:call-template  name ="wordwrap_createtspan_cal_totalTextHeight" >
							<xsl:with-param  name ="node"  select =" $node" />
							<xsl:with-param  name ="position"  select =" $position" />
							<xsl:with-param  name ="word"  select =" normalize-space ( $node [ $position ])" />
							<xsl:with-param  name ="size"  select =" $size" />
							<xsl:with-param  name ="noOfLine"  select =" $noOfLine  +  1" />
							<xsl:with-param  name ="textWidth"  select =" $textWidth" />
							<xsl:with-param name="textHeight" select="$textHeight"/>
							<xsl:with-param  name ="fontFamily"  select =" $fontFamily" />
							<xsl:with-param  name ="fontStyle"  select =" $fontStyle" />
							<xsl:with-param  name ="fontSize"  select =" $fontSize" />
							<xsl:with-param  name ="fontWeight"  select =" $fontWeight" />
							<xsl:with-param  name ="lineHeight"  select =" $lineHeight" />
							<xsl:with-param  name ="textLineHeight"  select =" $textLineHeight" />
							<xsl:with-param  name ="textAnchor"  select =" $textAnchor" />
							<xsl:with-param  name ="currencyFormatType"  select =" $currencyFormatType" />
							<xsl:with-param  name ="currencySign"  select =" $currencySign" />
							<xsl:with-param  name ="tspanX"  select =" $tspanX" />
							<xsl:with-param  name ="tspanY"  select =" $tspanY" />
						</xsl:call-template>
					</xsl:when>
					<xsl:when test="$size = 1">
						<xsl:choose>
							<xsl:when test="contains($node, $currencySign) and $currencySign!= ''">
								<xsl:call-template name="additionalCurrencyFormatting">
									<xsl:with-param name="currencyfiedString" select="$node"/>
									<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
									<xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
									<xsl:with-param name="currencySign" select="$currencySign"/>
									<xsl:with-param name="textAnchor" select="$textAnchor"/>
									<xsl:with-param name="textWidth" select="$textWidth"/>
									<xsl:with-param name="fontFamily" select="$fontFamily"/>
									<xsl:with-param name="fontStyle" select="$fontStyle"/>
									<xsl:with-param name="fontSize" select="$fontSize"/>
									<xsl:with-param name="fontWeight" select="$fontWeight"/>
									<xsl:with-param name="lineHeight" select="$lineHeight"/>
									<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
									<xsl:with-param name="noOfLine" select="0"/>
									<xsl:with-param name="tspanX" select="$tspanX"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
								</xsl:call-template>
							</xsl:when>
							<xsl:otherwise>
								<xsl:if test="$noOfLine &lt; (($textHeight - $lineHeight) div $lineHeight) or ($noOfLine = 0)">
									<xsl:element name="line">
										<xsl:value-of select="$prevWord"/>
									</xsl:element>
									<!-- <xsl:element name="svg:tspan"><xsl:attribute name="text-anchor"><xsl:value-of select="$textAnchor"/></xsl:attribute><xsl:attribute name="x"><xsl:value-of select="$tspanX"/></xsl:attribute><xsl:attribute name="y"><xsl:value-of select="$lineHeight * $noOfLine + $tspanY"/></xsl:attribute><xsl:value-of select="$word"/></xsl:element> -->
								</xsl:if>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:when>
					<xsl:when test="$size &gt; 1">
						<xsl:call-template name="wordwrap_createtspan_cal_totalTextHeight">
							<xsl:with-param name="node" select="$node"/>
							<xsl:with-param name="position" select="$position + 1"/>
							<xsl:with-param name="prevWord" select="$word"/>
							<xsl:with-param name="word" select="(concat($word,' ',$node[$position+1]))"/>
							<xsl:with-param name="size" select="$size - 1"/>
							<xsl:with-param name="noOfLine" select="$noOfLine"/>
							<xsl:with-param name="textAnchor" select="$textAnchor"/>
							<xsl:with-param name="textWidth" select="$textWidth"/>
							<xsl:with-param name="textHeight" select="$textHeight"/>
							<xsl:with-param name="fontFamily" select="$fontFamily"/>
							<xsl:with-param name="fontStyle" select="$fontStyle"/>
							<xsl:with-param name="fontSize" select="$fontSize"/>
							<xsl:with-param name="fontWeight" select="$fontWeight"/>
							<xsl:with-param name="lineHeight" select="$lineHeight"/>
							<xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
							<xsl:with-param name="currencySign" select="$currencySign"/>
							<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
							<xsl:with-param name="tspanX" select="$tspanX"/>
							<xsl:with-param name="tspanY" select="$tspanY"/>
						</xsl:call-template>
					</xsl:when>
					<xsl:otherwise></xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
	<xsl:template name="wordwrap_createtspan">
		<xsl:param name="node"/>
		<xsl:param name="position"/>
		<xsl:param name="prevWord"/>
		<xsl:param name="word"/>
		<xsl:param name="size"/>
		<xsl:param name="noOfLine"/>
		<xsl:param name="textAnchor"/>
		<xsl:param name="textWidth"/>
		<xsl:param name="textHeight"/>
		<xsl:param name="lineHeight"/>
		<xsl:param name="textLineHeight"/>
		<xsl:param name="tspanX"/>
		<xsl:param name="tspanY"/>
		<xsl:param name="fontStyle"/>
		<xsl:param name="fontFamily"/>
		<xsl:param name="fontWeight"/>
		<xsl:param name="fontSize"/>
		<xsl:param name="currencyFormat"/>
		<xsl:param name="currencyFormatType"/>
		<xsl:param name="currencyfiedString"/>
		<xsl:param name="currencySign"/>
		<xsl:param name="totalLines"/>
    <xsl:param name="verticalAlignOffset"/>
    <xsl:param name="text_decoration_overline"/>    
    <xsl:param name="text_decoration_underline"/>    
    <xsl:param name="text_decoration_strikethrough"/> 
    <xsl:param name="zeroformatEnabled"/> 
		<xsl:choose>
			<xsl:when test="dgext:getTextWidth($word, $fontFamily , $fontWeight , $fontStyle, $fontSize) >= $textWidth and $size > 1">
				<xsl:choose>
					<!-- check if prevword can only accomodate since current word has greater width -->
					<xsl:when test="(dgext:getTextWidth($prevWord, $fontFamily , $fontWeight , $fontStyle, $fontSize) &gt; 0) and (dgext:getTextWidth($word, $fontFamily , $fontWeight , $fontStyle, $fontSize) > $textWidth) and (dgext:getTextWidth($prevWord, $fontFamily , $fontWeight , $fontStyle, $fontSize) &lt; $textWidth)">
						<xsl:if test="$noOfLine &lt; (($textHeight - $lineHeight) div $lineHeight) or ($noOfLine = 0)">
							<xsl:element name="svg:tspan">
								<xsl:attribute name="text-anchor">
									<xsl:value-of select="$textAnchor"/>
								</xsl:attribute>
								<xsl:attribute name="x">
									<xsl:value-of select="$tspanX"/>
								</xsl:attribute>
								<xsl:attribute name="y">
									<xsl:value-of select="$lineHeight * $noOfLine + $tspanY + $verticalAlignOffset"/>
								</xsl:attribute>
								<xsl:value-of select="$prevWord"/>
							</xsl:element>
						</xsl:if>
						<xsl:choose>
							<xsl:when test="count($node) > $position">
								<xsl:call-template name="wordwrap_createtspan">
									<xsl:with-param name="node" select="$node"/>
									<xsl:with-param name="position" select="$position+1"/>
									<xsl:with-param name="prevWord" select="$node[$position]"></xsl:with-param>
									<xsl:with-param name="word" select="(concat($node[$position],' ',$node[$position+1]))"/>
									<xsl:with-param name="size" select="$size - 1"/>
									<xsl:with-param name="noOfLine" select="$noOfLine + 1"/>
									<xsl:with-param name="textAnchor" select="$textAnchor"/>
									<xsl:with-param name="textWidth" select="$textWidth"/>
									<xsl:with-param name="textHeight" select="$textHeight"/>
									<xsl:with-param name="fontFamily" select="$fontFamily"/>
									<xsl:with-param name="fontStyle" select="$fontStyle"/>
									<xsl:with-param name="fontSize" select="$fontSize"/>
									<xsl:with-param name="fontWeight" select="$fontWeight"/>
									<xsl:with-param name="lineHeight" select="$lineHeight"/>
									<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
									<xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
									<xsl:with-param name="currencyfiedString" select="$currencyfiedString"/>
									<xsl:with-param name="currencySign" select="$currencySign"/>
									<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
									<xsl:with-param name="tspanX" select="$tspanX"/>
									<xsl:with-param name="tspanY" select="$tspanY"/>
									<xsl:with-param name="verticalAlignOffset" select="$verticalAlignOffset"/>
									<xsl:with-param name="text_decoration_overline" select="$text_decoration_overline"/>
									<xsl:with-param name="text_decoration_underline" select="$text_decoration_underline"/>
                  <xsl:with-param name="text_decoration_strikethrough" select="$text_decoration_strikethrough"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
								</xsl:call-template>
							</xsl:when>
							<xsl:otherwise>
								<xsl:call-template name="wordwrap_createtspan">
									<xsl:with-param name="node" select="$node"/>
									<xsl:with-param name="position" select="$position"/>
									<xsl:with-param name="prevWord" select="$node[$position]"></xsl:with-param>
									<xsl:with-param name="word" select="($node[$position])"/>
									<xsl:with-param name="size" select="$size"/>
									<xsl:with-param name="noOfLine" select="$noOfLine + 1"/>
									<xsl:with-param name="textAnchor" select="$textAnchor"/>
									<xsl:with-param name="textWidth" select="$textWidth"/>
									<xsl:with-param name="textHeight" select="$textHeight"/>
									<xsl:with-param name="fontFamily" select="$fontFamily"/>
									<xsl:with-param name="fontStyle" select="$fontStyle"/>
									<xsl:with-param name="fontSize" select="$fontSize"/>
									<xsl:with-param name="fontWeight" select="$fontWeight"/>
									<xsl:with-param name="lineHeight" select="$lineHeight"/>
									<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
									<xsl:with-param name="tspanX" select="$tspanX"/>
									<xsl:with-param name="tspanY" select="$tspanY"/>
									<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
									<xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
									<xsl:with-param name="currencyfiedString" select="$currencyfiedString"/>
									<xsl:with-param name="currencySign" select="$currencySign"/>
									<xsl:with-param name="verticalAlignOffset" select="$verticalAlignOffset"/>
									<xsl:with-param name="text_decoration_overline" select="$text_decoration_overline"/>
									<xsl:with-param name="text_decoration_underline" select="$text_decoration_underline"/>
                  <xsl:with-param name="text_decoration_strikethrough" select="$text_decoration_strikethrough"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
								</xsl:call-template>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:when>
					<xsl:otherwise>
						<xsl:if test="$noOfLine &lt; (($textHeight - $lineHeight) div $lineHeight)">
							<xsl:variable name="finalWord" >
								<xsl:call-template name="slice_text">
									<xsl:with-param name="textField" select="$word"/>
									<xsl:with-param name="position" select="0"/>
									<xsl:with-param name="finalText" select="''"/>
									<xsl:with-param name="fontFamily" select="$fontFamily"/>
									<xsl:with-param name="fontWeight" select="$fontWeight"/>
									<xsl:with-param name="fontStyle" select="$fontStyle"/>
									<xsl:with-param name="fontSize" select="$fontSize"/>
									<xsl:with-param name="textWidth" select="$textWidth"/>
								</xsl:call-template>
							</xsl:variable>
							<xsl:element name="svg:tspan">
								<xsl:attribute name="text-anchor">
									<xsl:value-of select="$textAnchor"/>
								</xsl:attribute>
								<xsl:attribute name="x">
									<xsl:value-of select="$tspanX"/>
								</xsl:attribute>
								<xsl:attribute name="y">
									<xsl:value-of select="$lineHeight * $noOfLine + $tspanY + $verticalAlignOffset"/>
								</xsl:attribute>
								<xsl:value-of select="$finalWord"/>
							</xsl:element>
						</xsl:if>
						<xsl:call-template name="wordwrap_createtspan">
							<xsl:with-param name="node" select="$node"/>
							<xsl:with-param name="position" select="$position + 1"/>
							<xsl:with-param name="word" select="($node[$position+1])"/>
							<xsl:with-param name="size" select="$size - 1"/>
							<xsl:with-param name="noOfLine" select="$noOfLine + 1"/>
							<xsl:with-param name="textWidth" select="$textWidth"/>
							<xsl:with-param name="textHeight" select="$textHeight"/>
							<xsl:with-param name="fontFamily" select="$fontFamily"/>
							<xsl:with-param name="fontStyle" select="$fontStyle"/>
							<xsl:with-param name="fontSize" select="$fontSize"/>
							<xsl:with-param name="fontWeight" select="$fontWeight"/>
							<xsl:with-param name="lineHeight" select="$lineHeight"/>
							<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
							<xsl:with-param name="textAnchor" select="$textAnchor"/>
							<xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
							<xsl:with-param name="currencySign" select="$currencySign"/>
							<xsl:with-param name="tspanX" select="$tspanX"/>
							<xsl:with-param name="tspanY" select="$tspanY"/>
							<xsl:with-param name="verticalAlignOffset" select="$verticalAlignOffset"/>
              <xsl:with-param name="text_decoration_overline" select="$text_decoration_overline"/>
              <xsl:with-param name="text_decoration_underline" select="$text_decoration_underline"/>
              <xsl:with-param name="text_decoration_strikethrough" select="$text_decoration_strikethrough"/>
              <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
              </xsl:call-template>
					</xsl:otherwise>
				</xsl:choose>
			</xsl:when>
			<xsl:otherwise>
				<xsl:choose>
					<xsl:when test="$size = 1 and ($textWidth >= dgext:getTextWidth($word, $fontFamily , $fontWeight , $fontStyle, $fontSize))  and $currencyFormatType = ''">
            <xsl:if test="$noOfLine &lt; (($textHeight - $lineHeight) div $lineHeight) or ($noOfLine = 0)">
              <xsl:variable name="horizontalAlignOffset">
                <xsl:if test="$textAnchor = 'start'">
                  <xsl:value-of select="0"/>
                </xsl:if>
                <xsl:if test="$textAnchor = 'middle'">
                  <xsl:value-of select="($textWidth - ((dgext:getTextWidth($word, $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                </xsl:if>
                <xsl:if test="$textAnchor = 'end'">
                  <xsl:value-of select="($textWidth - ((dgext:getTextWidth($word, $fontFamily, $fontWeight, $fontStyle, $fontSize ))))"/>
                </xsl:if>
              </xsl:variable>		
              <xsl:if test="$text_decoration_underline = 'underline' and $currencySign != ''">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="dgext:getTextWidth($word, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                    <xsl:with-param name="counter" select="dgext:getTextWidth($word, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="isNoCurrenctFormat2SpecialCondition" select="'true'"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline' and $currencySign != ''">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="dgext:getTextWidth($word, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                    <xsl:with-param name="counter" select="dgext:getTextWidth($word, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="isNoCurrenctFormat2SpecialCondition" select="'true'"/>
                  </xsl:call-template>
						  </xsl:if>
            <xsl:element  name ="svg:tspan" >
              <xsl:choose>
                <xsl:when test="$currencySign != ''">    
                  <xsl:attribute  name ="x" >
                    <xsl:value-of  select =" $tspanX + $horizontalAlignOffset" />
                  </xsl:attribute>
                  <xsl:attribute  name ="y" >
                    <xsl:value-of  select =" $lineHeight  *  $noOfLine  +  $tspanY + $verticalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:value-of  select =" $word" />
                </xsl:when>
                <xsl:otherwise>
                  <xsl:attribute  name ="text-anchor" >
                    <xsl:value-of  select =" $textAnchor" />
                  </xsl:attribute>
                  <xsl:attribute  name ="x" >
                    <xsl:value-of  select =" $tspanX" />
                  </xsl:attribute>
                  <xsl:attribute  name ="y" >
                    <xsl:value-of  select =" $lineHeight  *  $noOfLine  +  $tspanY + $verticalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough' and $text_decoration_overline = 'overline' and $text_decoration_underline = 'underline'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'overline underline line-through'"/>
                    </xsl:attribute>
                  </xsl:if>
                  <xsl:if test="$text_decoration_strikethrough != 'strikethrough' and $text_decoration_overline = 'overline' and $text_decoration_underline = 'underline'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'overline underline'"/>
                    </xsl:attribute>
                  </xsl:if>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough' and $text_decoration_overline = '!overline' and $text_decoration_underline = 'underline'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'underline line-through'"/>
                    </xsl:attribute>
                  </xsl:if>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough' and $text_decoration_overline = 'overline' and $text_decoration_underline != 'underline'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'overline line-through'"/>
                    </xsl:attribute>
                  </xsl:if>   
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough' and $text_decoration_overline != 'overline' and $text_decoration_underline != 'underline'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>       
                  <xsl:if test="$text_decoration_strikethrough != 'strikethrough' and $text_decoration_overline = 'overline' and $text_decoration_underline != 'underline'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'overline'"/>
                    </xsl:attribute>
                  </xsl:if>    
                  <xsl:if test="$text_decoration_strikethrough != 'strikethrough' and $text_decoration_overline != 'overline' and $text_decoration_underline = 'underline'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'underline'"/>
                    </xsl:attribute>
                  </xsl:if>           
                  <xsl:value-of  select =" $word" />	
                </xsl:otherwise>
              </xsl:choose>
            </xsl:element>
						</xsl:if>
					</xsl:when>
					<xsl:when  test =" $size  =  1  and  string-length ( normalize-space ( $prevWord ))  >  0" >
						<xsl:if test="$noOfLine &lt; (($textHeight - $lineHeight) div $lineHeight) or ($noOfLine = 0)">
							<xsl:variable name="finalWord" >
								<xsl:call-template name="slice_text">
									<xsl:with-param name="textField" select="$prevWord"/>
									<xsl:with-param name="position" select="0"/>
									<xsl:with-param name="finalText" select="''"/>
									<xsl:with-param name="fontFamily" select="$fontFamily"/>
									<xsl:with-param name="fontWeight" select="$fontWeight"/>
									<xsl:with-param name="fontStyle" select="$fontStyle"/>
									<xsl:with-param name="fontSize" select="$fontSize"/>
									<xsl:with-param name="textWidth" select="$textWidth"/>
								</xsl:call-template>
							</xsl:variable>
							<xsl:element name="svg:tspan">
								<xsl:attribute name="text-anchor">
									<xsl:value-of select="$textAnchor"/>
								</xsl:attribute>
								<xsl:attribute name="x">
									<xsl:value-of select="$tspanX"/>
								</xsl:attribute>
								<xsl:attribute name="y">
									<xsl:value-of select="$lineHeight * $noOfLine + $tspanY + $verticalAlignOffset"/>
								</xsl:attribute>
								<xsl:value-of select="$finalWord"/>
							</xsl:element>
						</xsl:if>
						<xsl:call-template  name ="wordwrap_createtspan" >
							<xsl:with-param  name ="node"  select =" $node" />
							<xsl:with-param  name ="position"  select =" $position" />
							<xsl:with-param  name ="word"  select =" normalize-space ( $node [ $position ])" />
							<xsl:with-param  name ="size"  select =" $size" />
							<xsl:with-param  name ="noOfLine"  select =" $noOfLine  +  1" />
							<xsl:with-param  name ="textWidth"  select =" $textWidth" />
							<xsl:with-param name="textHeight" select="$textHeight"/>
							<xsl:with-param  name ="fontFamily"  select =" $fontFamily" />
							<xsl:with-param  name ="fontStyle"  select =" $fontStyle" />
							<xsl:with-param  name ="fontSize"  select =" $fontSize" />
							<xsl:with-param  name ="fontWeight"  select =" $fontWeight" />
							<xsl:with-param  name ="lineHeight"  select =" $lineHeight" />
							<xsl:with-param  name ="textLineHeight"  select =" $textLineHeight" />
							<xsl:with-param  name ="textAnchor"  select =" $textAnchor" />
							<xsl:with-param  name ="currencyFormatType"  select =" $currencyFormatType" />
							<xsl:with-param  name ="currencySign"  select =" $currencySign" />
							<xsl:with-param  name ="tspanX"  select =" $tspanX" />
							<xsl:with-param  name ="tspanY"  select =" $tspanY" />
							<xsl:with-param name="verticalAlignOffset" select="$verticalAlignOffset"/>
              <xsl:with-param name="text_decoration_overline" select="$text_decoration_overline"/>
              <xsl:with-param name="text_decoration_underline" select="$text_decoration_underline"/>
              <xsl:with-param name="text_decoration_strikethrough" select="$text_decoration_strikethrough"/>
              <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
              </xsl:call-template>
					</xsl:when>
					<xsl:when test="$size = 1">
						<xsl:choose>
							<xsl:when test="contains($node, $currencySign) and $currencySign!= ''">
								<xsl:call-template name="additionalCurrencyFormatting">
									<xsl:with-param name="currencyfiedString" select="$node"/>
									<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
									<xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
									<xsl:with-param name="currencySign" select="$currencySign"/>
									<xsl:with-param name="textAnchor" select="$textAnchor"/>
									<xsl:with-param name="textWidth" select="$textWidth"/>
									<xsl:with-param name="fontFamily" select="$fontFamily"/>
									<xsl:with-param name="fontStyle" select="$fontStyle"/>
									<xsl:with-param name="fontSize" select="$fontSize"/>
									<xsl:with-param name="fontWeight" select="$fontWeight"/>
									<xsl:with-param name="lineHeight" select="$lineHeight"/>
									<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
									<xsl:with-param name="noOfLine" select="0"/>
									<xsl:with-param name="tspanX" select="$tspanX"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration_overline" select="$text_decoration_overline"/>
                  <xsl:with-param name="text_decoration_underline" select="$text_decoration_underline"/>
                  <xsl:with-param name="text_decoration_strikethrough" select="$text_decoration_strikethrough"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
								</xsl:call-template>
							</xsl:when>
							<xsl:otherwise>
												<xsl:if test="$noOfLine &lt; (($textHeight - $lineHeight) div $lineHeight) or ($noOfLine = 0)">
							<xsl:variable name="finalWord" >
								<xsl:call-template name="slice_text">
									<xsl:with-param name="textField" select="$word"/>
									<xsl:with-param name="position" select="0"/>
									<xsl:with-param name="finalText" select="''"/>
									<xsl:with-param name="fontFamily" select="$fontFamily"/>
									<xsl:with-param name="fontWeight" select="$fontWeight"/>
									<xsl:with-param name="fontStyle" select="$fontStyle"/>
									<xsl:with-param name="fontSize" select="$fontSize"/>
									<xsl:with-param name="textWidth" select="$textWidth"/>
                </xsl:call-template>
							</xsl:variable>
              <xsl:if test="$text_decoration_underline = 'underline'">
              <xsl:call-template name="createFontStyleLineEffectSpan">
                <xsl:with-param name="tspanX" select="$tspanX"/>
                <xsl:with-param name="tspanY" select="$tspanY"/>
                <xsl:with-param name="text_decoration" select="'underline'"/>
                <xsl:with-param name="lineHeight" select="$lineHeight"/>
                <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                <xsl:with-param name="textWidth" select="dgext:getTextWidth($finalWord, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                <xsl:with-param name="counter" select="dgext:getTextWidth($finalWord, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                <xsl:with-param name="spaceString" select="'&#160;'"/>
                <xsl:with-param name="fontFamily" select="$fontFamily"/>
                <xsl:with-param name="fontWeight" select="$fontWeight"/>
                <xsl:with-param name="fontStyle" select="$fontStyle"/>
                <xsl:with-param name="fontSize" select="$fontSize"/>
                <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                <xsl:with-param name="currencySign" select="$currencySign"/>
              </xsl:call-template>
            </xsl:if>
            <xsl:if test="$text_decoration_overline = 'overline'">
              <xsl:call-template name="createFontStyleLineEffectSpan">
                <xsl:with-param name="tspanX" select="$tspanX"/>
                <xsl:with-param name="tspanY" select="$tspanY"/>
                <xsl:with-param name="text_decoration" select="'overline'"/>
                <xsl:with-param name="lineHeight" select="$lineHeight"/>
                <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                <xsl:with-param name="textWidth" select="dgext:getTextWidth($finalWord, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                <xsl:with-param name="counter" select="dgext:getTextWidth($finalWord, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                <xsl:with-param name="spaceString" select="'&#160;'"/>
                <xsl:with-param name="fontFamily" select="$fontFamily"/>
                <xsl:with-param name="fontWeight" select="$fontWeight"/>
                <xsl:with-param name="fontStyle" select="$fontStyle"/>
                <xsl:with-param name="fontSize" select="$fontSize"/>
                <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                <xsl:with-param name="currencySign" select="$currencySign"/>
              </xsl:call-template>
            </xsl:if>
              <xsl:element name="svg:tspan">
								<xsl:attribute name="text-anchor">
									<xsl:value-of select="$textAnchor"/>
								</xsl:attribute>
								<xsl:attribute name="x">
									<xsl:value-of select="$tspanX"/>
								</xsl:attribute>
								<xsl:attribute name="y">
									<xsl:value-of select="$lineHeight * $noOfLine + $tspanY + $verticalAlignOffset"/>
								</xsl:attribute>
								<xsl:value-of select="$finalWord"/>
							</xsl:element>
								</xsl:if>
							</xsl:otherwise>
						</xsl:choose>
					</xsl:when>
					<xsl:when test="$size &gt; 1">
						<xsl:call-template name="wordwrap_createtspan">
							<xsl:with-param name="node" select="$node"/>
							<xsl:with-param name="position" select="$position + 1"/>
							<xsl:with-param name="prevWord" select="$word"/>
							<xsl:with-param name="word" select="(concat($word,' ',$node[$position+1]))"/>
							<xsl:with-param name="size" select="$size - 1"/>
							<xsl:with-param name="noOfLine" select="$noOfLine"/>
							<xsl:with-param name="textAnchor" select="$textAnchor"/>
							<xsl:with-param name="textWidth" select="$textWidth"/>
							<xsl:with-param name="textHeight" select="$textHeight"/>
							<xsl:with-param name="fontFamily" select="$fontFamily"/>
							<xsl:with-param name="fontStyle" select="$fontStyle"/>
							<xsl:with-param name="fontSize" select="$fontSize"/>
							<xsl:with-param name="fontWeight" select="$fontWeight"/>
							<xsl:with-param name="lineHeight" select="$lineHeight"/>
							<xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
							<xsl:with-param name="currencySign" select="$currencySign"/>
							<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
							<xsl:with-param name="tspanX" select="$tspanX"/>
							<xsl:with-param name="tspanY" select="$tspanY"/>
							<xsl:with-param name="verticalAlignOffset" select="$verticalAlignOffset"/>
              <xsl:with-param name="text_decoration_overline" select="$text_decoration_overline"/>
              <xsl:with-param name="text_decoration_underline" select="$text_decoration_underline"/>
              <xsl:with-param name="text_decoration_strikethrough" select="$text_decoration_strikethrough"/>
              <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
              </xsl:call-template>
					</xsl:when>
					<xsl:otherwise></xsl:otherwise>
				</xsl:choose>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
  <xsl:template name="split">
      <xsl:param name="pText" select="."/>
      <xsl:param name="pDelim" select="' '"/>
      <xsl:param name="pElemName" select="'word'"/>
      <xsl:if test="string-length(($pText))">
      <xsl:element name="{$pElemName}">
      <xsl:value-of select="substring-before(concat($pText,$pDelim),$pDelim)"/>
      </xsl:element>
      <xsl:variable name="ptextAfterLastSpaceCheck">
      <xsl:choose>
        <xsl:when test="string-length(substring-after($pText,$pDelim)) = 0 and substring($pText, string-length($pText)) = ' ' and $pText != ' '">
          <xsl:value-of select="' '"/>
        </xsl:when>
        <xsl:otherwise>
          <xsl:value-of select="substring-after($pText,$pDelim)"/>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:variable>  
    <xsl:call-template name="split">
      <xsl:with-param name="pText" select="$ptextAfterLastSpaceCheck"/>
    <xsl:with-param name="pDelim" select="$pDelim"/>
    <xsl:with-param name="pElemName" select="$pElemName"/>
    </xsl:call-template>
      </xsl:if>
      </xsl:template>
  <xsl:template name="charwrap">
		<xsl:param name="textAnchor"/>
		<xsl:param name="productFieldValue"/>
		<xsl:param name="textWidth"/>
		<xsl:param name="textHeight"/>
		<xsl:param name="lineHeight"/>
		<xsl:param name="textLineHeight"/>
		<xsl:param name="fontFamily"/>
		<xsl:param name="fontStyle"/>
		<xsl:param name="fontWeight"/>
		<xsl:param name="fontSize"/>
		<xsl:param name="tspanX"/>
		<xsl:param name="tspanY"/>
		<xsl:param name="currencySign"/>
		<xsl:param name="currencyPosition"/>
		<xsl:param name="currencyFormat"/>
    <xsl:param name="currencyFormatType"/>
    <xsl:param name="currencyCode"/>
    <xsl:param name="textVertAlign"/>
    <xsl:param name="zeroformatEnabled"/>
    <xsl:param name="text_decoration_overline"/>    
    <xsl:param name="text_decoration_underline"/>    
    <xsl:param name="text_decoration_strikethrough"/>    
		<xsl:variable name="commaValidation">
			<xsl:value-of select="translate($productFieldValue, ',', '.')"/>
    </xsl:variable>
    <xsl:variable name="newtSpanX">
			<xsl:value-of  select="$tspanX"/>
    </xsl:variable>
		<xsl:variable name="currencyfiedString">
			<xsl:choose>
				<xsl:when test="number($productFieldValue) = $productFieldValue">
					<xsl:call-template name="addCurrencySign">
						<xsl:with-param name="productFieldValue" select="$commaValidation"/>
						<xsl:with-param name="currencySign" select="$currencySign"/>
						<xsl:with-param name="currencyPosition" select="$currencyPosition"/>
						<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
            <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
            <xsl:with-param name="currencyCode" select="$currencyCode"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:when test="number($commaValidation) = $commaValidation">
					<xsl:call-template name="addCurrencySign">
						<xsl:with-param name="productFieldValue" select="$commaValidation"/>
						<xsl:with-param name="currencySign" select="$currencySign"/>
						<xsl:with-param name="currencyPosition" select="$currencyPosition"/>
						<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
            <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
            <xsl:with-param name="currencyCode" select="$currencyCode"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$productFieldValue"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:if test="dgext:getTextWidth($currencyfiedString,$fontFamily, $fontWeight, $fontStyle, $fontSize) &lt; $textWidth">
     <xsl:variable name="verticalAlignOffset">
      <xsl:if test="$textVertAlign = 'middle'">
        <xsl:value-of select="(($textHeight - ($lineHeight * 1)) div 2) + (($lineHeight - $textLineHeight) div 2) - (($textHeight - ($lineHeight * 1)) div 2)"/>
      </xsl:if>
      <xsl:if test="$textVertAlign = 'bottom'">
        <xsl:value-of select="(($textHeight - $lineHeight * 1)) + (($lineHeight - $textLineHeight) div 2)- ($textHeight - ($lineHeight * 1))"/>
      </xsl:if>
      <xsl:if test="$textVertAlign = 'top'">
        <xsl:value-of select="0"/>
      </xsl:if>
    </xsl:variable>
			<xsl:choose>
				<xsl:when test="contains($currencyfiedString, $currencySign) and $currencySign!= ''">
					<xsl:call-template name="additionalCurrencyFormatting">
						<xsl:with-param name="currencyfiedString" select="$currencyfiedString"/>
						<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
						<xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
						<xsl:with-param name="currencySign" select="$currencySign"/>
						<xsl:with-param name="textAnchor" select="$textAnchor"/>
						<xsl:with-param name="textWidth" select="$textWidth"/>
						<xsl:with-param name="textHeight" select="$textHeight"/>
						<xsl:with-param name="fontFamily" select="$fontFamily"/>
						<xsl:with-param name="fontStyle" select="$fontStyle"/>
						<xsl:with-param name="fontSize" select="$fontSize"/>
						<xsl:with-param name="fontWeight" select="$fontWeight"/>
						<xsl:with-param name="lineHeight" select="$lineHeight"/>
						<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
						<xsl:with-param name="noOfLine" select="0"/>
						<xsl:with-param name="tspanX" select="$newtSpanX"/>
						<xsl:with-param name="tspanY" select="$tspanY"/>
            <xsl:with-param name="text_decoration_overline" select="$text_decoration_overline"/>
            <xsl:with-param name="text_decoration_underline" select="$text_decoration_underline"/>
            <xsl:with-param name="text_decoration_strikethrough" select="$text_decoration_strikethrough"/>
            <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
            </xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<xsl:element name="svg:tspan">
						<xsl:attribute name="text-anchor">
							<xsl:value-of select="$textAnchor"/>
						</xsl:attribute>
						<xsl:attribute name="x">
							<xsl:value-of select="$newtSpanX"/>
						</xsl:attribute>
						<xsl:attribute name="y">
							<xsl:value-of select="$tspanY + $verticalAlignOffset"/>
						</xsl:attribute>
						<xsl:value-of select="$currencyfiedString"/>
					</xsl:element>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
		<xsl:if test="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize) &gt; $textWidth">
			<xsl:call-template name="parseString">
				<xsl:with-param name="productFieldValue" select="$currencyfiedString"/>
				<xsl:with-param name="textAnchor" select="$textAnchor"/>
				<xsl:with-param name="textWidth" select="$textWidth"/>
				<xsl:with-param name="textHeight" select="$textHeight"/>
				<xsl:with-param name="fontFamily" select="$fontFamily"/>
				<xsl:with-param name="fontStyle" select="$fontStyle"/>
				<xsl:with-param name="fontSize" select="$fontSize"/>
				<xsl:with-param name="fontWeight" select="$fontWeight"/>
				<xsl:with-param name="lineHeight" select="$lineHeight"/>
				<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
				<xsl:with-param name="noOfLine" select="0"/>
				<xsl:with-param name="tspanX" select="$newtSpanX"/>
				<xsl:with-param name="tspanY" select="$tspanY"/>
			  <xsl:with-param name="textVertAlign" select="$textVertAlign"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
	<xsl:template name="parseString">
		<xsl:param name="productFieldValue"/>
		<xsl:param name="textAnchor"/>
		<xsl:param name="textWidth"/>
		<xsl:param name="textHeight"/>
		<xsl:param name="lineHeight"/>
		<xsl:param name="noOfLine"/>
		<xsl:param name="textLineHeight"/>
		<xsl:param name="fontFamily"/>
		<xsl:param name="fontStyle"/>
		<xsl:param name="fontWeight"/>
		<xsl:param name="fontSize"/>
		<xsl:param name="tspanX"/>
		<xsl:param name="tspanY"/>
		<xsl:param name="position"/>
		<xsl:param name="startPosition"/>
		<xsl:param name="endPosition"/>
		<xsl:param name="textVertAlign"/>    
		<xsl:variable name="strLen">
			<xsl:value-of select="string-length($productFieldValue)"/>
		</xsl:variable>
     <xsl:variable name="linesElement">
      <xsl:call-template name="getChars_vert">
        <xsl:with-param name="productFieldValue" select="$productFieldValue"/>
        <xsl:with-param name="textAnchor" select="$textAnchor"/>
        <xsl:with-param name="textWidth" select="$textWidth"/>
        <xsl:with-param name="textHeight" select="$textHeight"/>
        <xsl:with-param name="fontFamily" select="$fontFamily"/>
        <xsl:with-param name="fontStyle" select="$fontStyle"/>
        <xsl:with-param name="fontSize" select="$fontSize"/>
        <xsl:with-param name="fontWeight" select="$fontWeight"/>
        <xsl:with-param name="lineHeight" select="$lineHeight"/>
        <xsl:with-param name="textLineHeight" select="$textLineHeight"/>
        <xsl:with-param name="noOfLine" select="$noOfLine"/>
        <xsl:with-param name="tspanX" select="$tspanX"/>
        <xsl:with-param name="tspanY" select="$tspanY"/>
        <xsl:with-param name="startPosition" select="1"/>
        <xsl:with-param name="endPosition" select="0"/>
        <xsl:with-param name="position" select="0"/>
        <xsl:with-param name="stLen" select="$strLen"/>
      </xsl:call-template>
     </xsl:variable>		
      <xsl:variable name="linesArray" select="ext:node-set($linesElement)/*"/>
      <xsl:variable name="verticalAlignOffset">
        <xsl:if test="$textVertAlign = 'middle'">
          <xsl:value-of select="(($textHeight - ($lineHeight * count($linesArray))) div 2) + (($lineHeight - $textLineHeight) div 2) - (($textHeight - ($lineHeight * 1)) div 2)"/>
        </xsl:if>
        <xsl:if test="$textVertAlign = 'bottom'">
          <xsl:value-of select="(($textHeight - $lineHeight * count($linesArray))) + (($lineHeight - $textLineHeight) div 2) - ($textHeight - ($lineHeight * 1))"/>
        </xsl:if>
        <xsl:if test="$textVertAlign = 'top'">
          <xsl:value-of select="0"/>
        </xsl:if>
		</xsl:variable>
     <xsl:call-template name="getChars">
        <xsl:with-param name="productFieldValue" select="$productFieldValue"/>
        <xsl:with-param name="textAnchor" select="$textAnchor"/>
        <xsl:with-param name="textWidth" select="$textWidth"/>
        <xsl:with-param name="textHeight" select="$textHeight"/>
        <xsl:with-param name="fontFamily" select="$fontFamily"/>
        <xsl:with-param name="fontStyle" select="$fontStyle"/>
        <xsl:with-param name="fontSize" select="$fontSize"/>
        <xsl:with-param name="fontWeight" select="$fontWeight"/>
        <xsl:with-param name="lineHeight" select="$lineHeight"/>
        <xsl:with-param name="textLineHeight" select="$textLineHeight"/>
        <xsl:with-param name="noOfLine" select="$noOfLine"/>
        <xsl:with-param name="tspanX" select="$tspanX"/>
        <xsl:with-param name="tspanY" select="$tspanY"/>
        <xsl:with-param name="startPosition" select="1"/>
        <xsl:with-param name="endPosition" select="0"/>
        <xsl:with-param name="position" select="0"/>
        <xsl:with-param name="stLen" select="$strLen"/>
        <xsl:with-param name="verticalAlignOffset" select="$verticalAlignOffset"/>        
      </xsl:call-template>
	</xsl:template>
	<xsl:template name="getChars_vert">
		<xsl:param name="productFieldValue"/>
		<xsl:param name="textAnchor"/>
		<xsl:param name="textWidth"/>
		<xsl:param name="textHeight"/>
		<xsl:param name="lineHeight"/>
		<xsl:param name="noOfLine"/>
		<xsl:param name="textLineHeight"/>
		<xsl:param name="fontFamily"/>
		<xsl:param name="fontStyle"/>
		<xsl:param name="fontWeight"/>
		<xsl:param name="fontSize"/>
		<xsl:param name="tspanX"/>
		<xsl:param name="tspanY"/>
		<xsl:param name="position"/>
		<xsl:param name="startPosition"/>
		<xsl:param name="endPosition"/>
		<xsl:param name="stLen"/>
		<xsl:variable name="charsInFocus" select="substring($productFieldValue, $startPosition, $endPosition)"/>
		<xsl:if test="$stLen >= 0">
			<xsl:call-template name="getEveryCharWidth_vert">
				<xsl:with-param name="productFieldValue" select="$productFieldValue"/>
				<xsl:with-param name="textAnchor" select="$textAnchor"/>
				<xsl:with-param name="textWidth" select="$textWidth"/>
				<xsl:with-param name="textHeight" select="$textHeight"/>
				<xsl:with-param name="fontFamily" select="$fontFamily"/>
				<xsl:with-param name="fontStyle" select="$fontStyle"/>
				<xsl:with-param name="fontSize" select="$fontSize"/>
				<xsl:with-param name="fontWeight" select="$fontWeight"/>
				<xsl:with-param name="lineHeight" select="$lineHeight"/>
				<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
				<xsl:with-param name="noOfLine" select="$noOfLine"/>
				<xsl:with-param name="tspanX" select="$tspanX"/>
				<xsl:with-param name="tspanY" select="$tspanY"/>
				<xsl:with-param name="startPosition" select="$startPosition"/>
				<xsl:with-param name="endPosition" select="$endPosition"/>
				<xsl:with-param name="position" select="$position"/>
				<xsl:with-param name="charsInFocus" select="$charsInFocus"/>
				<xsl:with-param name="stLen" select="$stLen"/>
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
  <xsl:template name="getChars">
		<xsl:param name="productFieldValue"/>
		<xsl:param name="textAnchor"/>
		<xsl:param name="textWidth"/>
		<xsl:param name="textHeight"/>
		<xsl:param name="lineHeight"/>
		<xsl:param name="noOfLine"/>
		<xsl:param name="textLineHeight"/>
		<xsl:param name="fontFamily"/>
		<xsl:param name="fontStyle"/>
		<xsl:param name="fontWeight"/>
		<xsl:param name="fontSize"/>
		<xsl:param name="tspanX"/>
		<xsl:param name="tspanY"/>
		<xsl:param name="position"/>
		<xsl:param name="startPosition"/>
		<xsl:param name="endPosition"/>
		<xsl:param name="stLen"/>
		<xsl:param name="verticalAlignOffset"/>
		<xsl:variable name="charsInFocus" select="substring($productFieldValue, $startPosition, $endPosition)"/>
		<xsl:if test="$stLen >= 0">
			<xsl:call-template name="getEveryCharWidth">
				<xsl:with-param name="productFieldValue" select="$productFieldValue"/>
				<xsl:with-param name="textAnchor" select="$textAnchor"/>
				<xsl:with-param name="textWidth" select="$textWidth"/>
				<xsl:with-param name="textHeight" select="$textHeight"/>
				<xsl:with-param name="fontFamily" select="$fontFamily"/>
				<xsl:with-param name="fontStyle" select="$fontStyle"/>
				<xsl:with-param name="fontSize" select="$fontSize"/>
				<xsl:with-param name="fontWeight" select="$fontWeight"/>
				<xsl:with-param name="lineHeight" select="$lineHeight"/>
				<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
				<xsl:with-param name="noOfLine" select="$noOfLine"/>
				<xsl:with-param name="tspanX" select="$tspanX"/>
				<xsl:with-param name="tspanY" select="$tspanY"/>
				<xsl:with-param name="startPosition" select="$startPosition"/>
				<xsl:with-param name="endPosition" select="$endPosition"/>
				<xsl:with-param name="position" select="$position"/>
				<xsl:with-param name="charsInFocus" select="$charsInFocus"/>
				<xsl:with-param name="stLen" select="$stLen"/>
				<xsl:with-param name="verticalAlignOffset" select="$verticalAlignOffset"/>        
			</xsl:call-template>
		</xsl:if>
	</xsl:template>
	<xsl:template name="getEveryCharWidth_vert">
		<xsl:param name="charsInFocus"/>
		<xsl:param name="productFieldValue"/>
		<xsl:param name="textAnchor"/>
		<xsl:param name="textWidth"/>
		<xsl:param name="textHeight"/>
		<xsl:param name="lineHeight"/>
		<xsl:param name="noOfLine"/>
		<xsl:param name="textLineHeight"/>
		<xsl:param name="fontFamily"/>
		<xsl:param name="fontStyle"/>
		<xsl:param name="fontWeight"/>
		<xsl:param name="fontSize"/>
		<xsl:param name="tspanX"/>
		<xsl:param name="tspanY"/>
		<xsl:param name="startPosition"/>
		<xsl:param name="endPosition"/>
		<xsl:param name="position"/>
		<xsl:param name="stLen"/>
		<xsl:variable name="charWidth">
			<xsl:value-of select="dgext:getTextWidth($charsInFocus, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
		</xsl:variable>
    <xsl:call-template name="decideNextStep_cal_totalTextHeight">
			<xsl:with-param name="startPosition" select="$startPosition"/>
			<xsl:with-param name="endPosition" select="$endPosition"/>
			<xsl:with-param name="position" select="$position"/>
			<xsl:with-param name="charWidth" select="$charWidth"/>
			<xsl:with-param name="productFieldValue" select="$productFieldValue"/>
			<xsl:with-param name="textAnchor" select="$textAnchor"/>
			<xsl:with-param name="textWidth" select="$textWidth"/>
			<xsl:with-param name="textHeight" select="$textHeight"/>
			<xsl:with-param name="fontFamily" select="$fontFamily"/>
			<xsl:with-param name="fontStyle" select="$fontStyle"/>
			<xsl:with-param name="fontSize" select="$fontSize"/>
			<xsl:with-param name="fontWeight" select="$fontWeight"/>
			<xsl:with-param name="lineHeight" select="$lineHeight"/>
			<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
			<xsl:with-param name="noOfLine" select="$noOfLine"/>
			<xsl:with-param name="tspanX" select="$tspanX"/>
			<xsl:with-param name="tspanY" select="$tspanY"/>
			<xsl:with-param name="stLen" select="$stLen"/>
			<xsl:with-param name="charsInFocus" select="$charsInFocus"/>
		</xsl:call-template>
	</xsl:template>
  <xsl:template name="getEveryCharWidth">
		<xsl:param name="charsInFocus"/>
		<xsl:param name="productFieldValue"/>
		<xsl:param name="textAnchor"/>
		<xsl:param name="textWidth"/>
		<xsl:param name="textHeight"/>
		<xsl:param name="lineHeight"/>
		<xsl:param name="noOfLine"/>
		<xsl:param name="textLineHeight"/>
		<xsl:param name="fontFamily"/>
		<xsl:param name="fontStyle"/>
		<xsl:param name="fontWeight"/>
		<xsl:param name="fontSize"/>
		<xsl:param name="tspanX"/>
		<xsl:param name="tspanY"/>
		<xsl:param name="startPosition"/>
		<xsl:param name="endPosition"/>
		<xsl:param name="position"/>
		<xsl:param name="stLen"/>
		<xsl:param name="verticalAlignOffset"/>
		<xsl:variable name="charWidth">
			<xsl:value-of select="dgext:getTextWidth($charsInFocus, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
		</xsl:variable>
    <xsl:call-template name="decideNextStep">
			<xsl:with-param name="startPosition" select="$startPosition"/>
			<xsl:with-param name="endPosition" select="$endPosition"/>
			<xsl:with-param name="position" select="$position"/>
			<xsl:with-param name="charWidth" select="$charWidth"/>
			<xsl:with-param name="productFieldValue" select="$productFieldValue"/>
			<xsl:with-param name="textAnchor" select="$textAnchor"/>
			<xsl:with-param name="textWidth" select="$textWidth"/>
			<xsl:with-param name="textHeight" select="$textHeight"/>
			<xsl:with-param name="fontFamily" select="$fontFamily"/>
			<xsl:with-param name="fontStyle" select="$fontStyle"/>
			<xsl:with-param name="fontSize" select="$fontSize"/>
			<xsl:with-param name="fontWeight" select="$fontWeight"/>
			<xsl:with-param name="lineHeight" select="$lineHeight"/>
			<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
			<xsl:with-param name="noOfLine" select="$noOfLine"/>
			<xsl:with-param name="tspanX" select="$tspanX"/>
			<xsl:with-param name="tspanY" select="$tspanY"/>
			<xsl:with-param name="stLen" select="$stLen"/>
			<xsl:with-param name="charsInFocus" select="$charsInFocus"/>
			<xsl:with-param name="verticalAlignOffset" select="$verticalAlignOffset"/>
		</xsl:call-template>
	</xsl:template>
	<xsl:template name="decideNextStep_cal_totalTextHeight">
		<xsl:param name="charsInFocus"/>
		<xsl:param name="charWidth"/>
		<xsl:param name="productFieldValue"/>
		<xsl:param name="textAnchor"/>
		<xsl:param name="textWidth"/>
		<xsl:param name="textHeight"/>
		<xsl:param name="lineHeight"/>
		<xsl:param name="noOfLine"/>
		<xsl:param name="textLineHeight"/>
		<xsl:param name="fontFamily"/>
		<xsl:param name="fontStyle"/>
		<xsl:param name="fontWeight"/>
		<xsl:param name="fontSize"/>
		<xsl:param name="tspanX"/>
		<xsl:param name="tspanY"/>
		<xsl:param name="startPosition"/>
		<xsl:param name="endPosition"/>
		<xsl:param name="position"/>
		<xsl:param name="stLen"/>
		<xsl:if test="$charWidth &lt; $textWidth">
			<xsl:variable name="testvalue">
				<xsl:value-of select="($lineHeight * $noOfLine )"/>
			</xsl:variable>
			<xsl:choose>
				<xsl:when test="$stLen = 0">
					<xsl:if test="($noOfLine * $lineHeight) &lt; ($textHeight - $lineHeight)  or ($noOfLine = 0)">
            <xsl:element name="line">
								<xsl:value-of select="$charsInFocus"/>
            </xsl:element>
						<!-- <xsl:element name="svg:tspan">
							<xsl:attribute name="text-anchor">
								<xsl:value-of select="$textAnchor"/>
							</xsl:attribute>
							<xsl:attribute name="x">
								<xsl:value-of select="$tspanX"/>
							</xsl:attribute>
							<xsl:attribute name="y">
								<xsl:value-of select="$lineHeight * $noOfLine + $tspanY"/>
							</xsl:attribute>
							<xsl:value-of select="$charsInFocus"/>
						</xsl:element> -->
					</xsl:if>
				</xsl:when>
				<xsl:otherwise>
					<xsl:call-template name="getChars_vert">
						<xsl:with-param name="position" select="$position + 1"/>
						<xsl:with-param name="startPosition" select="$startPosition"/>
						<xsl:with-param name="endPosition" select="$endPosition + 1"/>
						<xsl:with-param name="productFieldValue" select="$productFieldValue"/>
						<xsl:with-param name="textAnchor" select="$textAnchor"/>
						<xsl:with-param name="textWidth" select="$textWidth"/>
						<xsl:with-param name="textHeight" select="$textHeight"/>
						<xsl:with-param name="fontFamily" select="$fontFamily"/>
						<xsl:with-param name="fontStyle" select="$fontStyle"/>
						<xsl:with-param name="fontSize" select="$fontSize"/>
						<xsl:with-param name="fontWeight" select="$fontWeight"/>
						<xsl:with-param name="lineHeight" select="$lineHeight"/>
						<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
						<xsl:with-param name="noOfLine" select="$noOfLine"/>
						<xsl:with-param name="tspanX" select="$tspanX"/>
						<xsl:with-param name="tspanY" select="$tspanY"/>
						<xsl:with-param name="stLen" select="$stLen - 1"/>
					</xsl:call-template>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
		<xsl:if test="$charWidth &gt; $textWidth">
			<xsl:if test="($lineHeight * $noOfLine ) &lt; ($textHeight - $lineHeight) or ($noOfLine = 0)">
        <xsl:element name="line">
          <xsl:value-of select="substring($charsInFocus, 1, $endPosition - 1)"/>
        </xsl:element>
				<!-- <xsl:element name="svg:tspan">
					<xsl:attribute name="text-anchor">
						<xsl:value-of select="$textAnchor"/>
					</xsl:attribute>
					<xsl:attribute name="x">
						<xsl:value-of select="$tspanX"/>
					</xsl:attribute>
					<xsl:attribute name="y">
						<xsl:value-of select="$lineHeight * $noOfLine + $tspanY"/>
					</xsl:attribute>
					<xsl:value-of select="substring($charsInFocus, 1, $endPosition - 1)"/>
				</xsl:element> -->
			</xsl:if>
			<xsl:call-template name="getChars_vert">
				<xsl:with-param name="position" select="$position - 1"/>
				<xsl:with-param name="startPosition" select="$position"/>
				<xsl:with-param name="endPosition" select="0"/>
				<xsl:with-param name="productFieldValue" select="$productFieldValue"/>
				<xsl:with-param name="textAnchor" select="$textAnchor"/>
				<xsl:with-param name="textWidth" select="$textWidth"/>
				<xsl:with-param name="textHeight" select="$textHeight"/>
				<xsl:with-param name="fontFamily" select="$fontFamily"/>
				<xsl:with-param name="fontStyle" select="$fontStyle"/>
				<xsl:with-param name="fontSize" select="$fontSize"/>
				<xsl:with-param name="fontWeight" select="$fontWeight"/>
				<xsl:with-param name="lineHeight" select="$lineHeight"/>
				<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
				<xsl:with-param name="noOfLine" select="$noOfLine + 1"/>
				<xsl:with-param name="tspanX" select="$tspanX"/>
				<xsl:with-param name="tspanY" select="$tspanY"/>
				<xsl:with-param name="stLen" select="$stLen + 2"/>
			</xsl:call-template>
		</xsl:if>
		<xsl:if test="$charWidth = $textWidth">
			<xsl:if test="($noOfLine * $lineHeight) &lt; ($textHeight - $lineHeight) or ($noOfLine = 0)">
        <xsl:element name="line">
          <xsl:value-of select="$charsInFocus"/>
        </xsl:element>
				<!-- <xsl:element name="svg:tspan">
					<xsl:attribute name="text-anchor">
						<xsl:value-of select="$textAnchor"/>
					</xsl:attribute>
					<xsl:attribute name="x">
						<xsl:value-of select="$tspanX"/>
					</xsl:attribute>
					<xsl:attribute name="y">
						<xsl:value-of select="$lineHeight * $noOfLine + $tspanY"/>
					</xsl:attribute>
					<xsl:value-of select="$charsInFocus"/>
				</xsl:element> -->
			</xsl:if>
			<xsl:if test="$stLen  &gt; 0">
				<xsl:call-template name="getChars_vert">
					<xsl:with-param name="position" select="$position"/>
					<xsl:with-param name="startPosition" select="$position + 1"/>
					<xsl:with-param name="endPosition" select="0"/>
					<xsl:with-param name="productFieldValue" select="$productFieldValue"/>
					<xsl:with-param name="textAnchor" select="$textAnchor"/>
					<xsl:with-param name="textWidth" select="$textWidth"/>
					<xsl:with-param name="textHeight" select="$textHeight"/>
					<xsl:with-param name="fontFamily" select="$fontFamily"/>
					<xsl:with-param name="fontStyle" select="$fontStyle"/>
					<xsl:with-param name="fontSize" select="$fontSize"/>
					<xsl:with-param name="fontWeight" select="$fontWeight"/>
					<xsl:with-param name="lineHeight" select="$lineHeight"/>
					<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
					<xsl:with-param name="noOfLine" select="$noOfLine + 1"/>
					<xsl:with-param name="tspanX" select="$tspanX"/>
					<xsl:with-param name="tspanY" select="$tspanY"/>
					<xsl:with-param name="stLen" select="$stLen + 1"/>
				</xsl:call-template>
			</xsl:if>
		</xsl:if>
	</xsl:template>
	<xsl:template name="decideNextStep">
		<xsl:param name="charsInFocus"/>
		<xsl:param name="charWidth"/>
		<xsl:param name="productFieldValue"/>
		<xsl:param name="textAnchor"/>
		<xsl:param name="textWidth"/>
		<xsl:param name="textHeight"/>
		<xsl:param name="lineHeight"/>
		<xsl:param name="noOfLine"/>
		<xsl:param name="textLineHeight"/>
		<xsl:param name="fontFamily"/>
		<xsl:param name="fontStyle"/>
		<xsl:param name="fontWeight"/>
		<xsl:param name="fontSize"/>
		<xsl:param name="tspanX"/>
		<xsl:param name="tspanY"/>
		<xsl:param name="startPosition"/>
		<xsl:param name="endPosition"/>
		<xsl:param name="position"/>
		<xsl:param name="stLen"/>
		<xsl:param name="verticalAlignOffset"/>
		<xsl:if test="$charWidth &lt; $textWidth">
			<xsl:variable name="testvalue">
				<xsl:value-of select="($lineHeight * $noOfLine )"/>
			</xsl:variable>
			<xsl:choose>
				<xsl:when test="$stLen = 0">
					<xsl:if test="($noOfLine * $lineHeight) &lt; ($textHeight - $lineHeight)  or ($noOfLine = 0)">
						<xsl:element name="svg:tspan">
							<xsl:attribute name="text-anchor">
								<xsl:value-of select="$textAnchor"/>
							</xsl:attribute>
							<xsl:attribute name="x">
								<xsl:value-of select="$tspanX"/>
							</xsl:attribute>
							<xsl:attribute name="y">
								<xsl:value-of select="$lineHeight * $noOfLine + $tspanY + $verticalAlignOffset"/>
							</xsl:attribute>
							<xsl:value-of select="$charsInFocus"/>
						</xsl:element>
					</xsl:if>
				</xsl:when>
				<xsl:otherwise>
					<xsl:call-template name="getChars">
						<xsl:with-param name="position" select="$position + 1"/>
						<xsl:with-param name="startPosition" select="$startPosition"/>
						<xsl:with-param name="endPosition" select="$endPosition + 1"/>
						<xsl:with-param name="productFieldValue" select="$productFieldValue"/>
						<xsl:with-param name="textAnchor" select="$textAnchor"/>
						<xsl:with-param name="textWidth" select="$textWidth"/>
						<xsl:with-param name="textHeight" select="$textHeight"/>
						<xsl:with-param name="fontFamily" select="$fontFamily"/>
						<xsl:with-param name="fontStyle" select="$fontStyle"/>
						<xsl:with-param name="fontSize" select="$fontSize"/>
						<xsl:with-param name="fontWeight" select="$fontWeight"/>
						<xsl:with-param name="lineHeight" select="$lineHeight"/>
						<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
						<xsl:with-param name="noOfLine" select="$noOfLine"/>
						<xsl:with-param name="tspanX" select="$tspanX"/>
						<xsl:with-param name="tspanY" select="$tspanY"/>
						<xsl:with-param name="stLen" select="$stLen - 1"/>
						<xsl:with-param name="verticalAlignOffset" select="$verticalAlignOffset"/>
					</xsl:call-template>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:if>
		<xsl:if test="$charWidth &gt; $textWidth">
			<xsl:if test="($lineHeight * $noOfLine ) &lt; ($textHeight - $lineHeight) or ($noOfLine = 0)">
				<xsl:element name="svg:tspan">
					<xsl:attribute name="text-anchor">
						<xsl:value-of select="$textAnchor"/>
					</xsl:attribute>
					<xsl:attribute name="x">
						<xsl:value-of select="$tspanX"/>
					</xsl:attribute>
					<xsl:attribute name="y">
						<xsl:value-of select="$lineHeight * $noOfLine + $tspanY + $verticalAlignOffset"/>
					</xsl:attribute>
					<xsl:value-of select="substring($charsInFocus, 1, $endPosition - 1)"/>
				</xsl:element>
			</xsl:if>
			<xsl:call-template name="getChars">
				<xsl:with-param name="position" select="$position - 1"/>
				<xsl:with-param name="startPosition" select="$position"/>
				<xsl:with-param name="endPosition" select="0"/>
				<xsl:with-param name="productFieldValue" select="$productFieldValue"/>
				<xsl:with-param name="textAnchor" select="$textAnchor"/>
				<xsl:with-param name="textWidth" select="$textWidth"/>
				<xsl:with-param name="textHeight" select="$textHeight"/>
				<xsl:with-param name="fontFamily" select="$fontFamily"/>
				<xsl:with-param name="fontStyle" select="$fontStyle"/>
				<xsl:with-param name="fontSize" select="$fontSize"/>
				<xsl:with-param name="fontWeight" select="$fontWeight"/>
				<xsl:with-param name="lineHeight" select="$lineHeight"/>
				<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
				<xsl:with-param name="noOfLine" select="$noOfLine + 1"/>
				<xsl:with-param name="tspanX" select="$tspanX"/>
				<xsl:with-param name="tspanY" select="$tspanY"/>
				<xsl:with-param name="stLen" select="$stLen + 2"/>
				<xsl:with-param name="verticalAlignOffset" select="$verticalAlignOffset"/>
			</xsl:call-template>
		</xsl:if>
		<xsl:if test="$charWidth = $textWidth">
			<xsl:if test="($noOfLine * $lineHeight) &lt; ($textHeight - $lineHeight) or ($noOfLine = 0)">
				<xsl:element name="svg:tspan">
					<xsl:attribute name="text-anchor">
						<xsl:value-of select="$textAnchor"/>
					</xsl:attribute>
					<xsl:attribute name="x">
						<xsl:value-of select="$tspanX"/>
					</xsl:attribute>
					<xsl:attribute name="y">
						<xsl:value-of select="$lineHeight * $noOfLine + $tspanY + $verticalAlignOffset"/>
					</xsl:attribute>
					<xsl:value-of select="$charsInFocus"/>
				</xsl:element>
			</xsl:if>
			<xsl:if test="$stLen  &gt; 0">
				<xsl:call-template name="getChars">
					<xsl:with-param name="position" select="$position"/>
					<xsl:with-param name="startPosition" select="$position + 1"/>
					<xsl:with-param name="endPosition" select="0"/>
					<xsl:with-param name="productFieldValue" select="$productFieldValue"/>
					<xsl:with-param name="textAnchor" select="$textAnchor"/>
					<xsl:with-param name="textWidth" select="$textWidth"/>
					<xsl:with-param name="textHeight" select="$textHeight"/>
					<xsl:with-param name="fontFamily" select="$fontFamily"/>
					<xsl:with-param name="fontStyle" select="$fontStyle"/>
					<xsl:with-param name="fontSize" select="$fontSize"/>
					<xsl:with-param name="fontWeight" select="$fontWeight"/>
					<xsl:with-param name="lineHeight" select="$lineHeight"/>
					<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
					<xsl:with-param name="noOfLine" select="$noOfLine + 1"/>
					<xsl:with-param name="tspanX" select="$tspanX"/>
					<xsl:with-param name="tspanY" select="$tspanY"/>
					<xsl:with-param name="stLen" select="$stLen + 1"/>
					<xsl:with-param name="verticalAlignOffset" select="$verticalAlignOffset"/>
				</xsl:call-template>
			</xsl:if>
		</xsl:if>
	</xsl:template>
  <xsl:template name="divFormat">
    <xsl:param name="calcValue"/>
    <xsl:param name="calcDivFormat"/>
    <xsl:variable name="formattedString">
      <xsl:choose>
        <xsl:when test="$calcDivFormat = '1f'">
          <xsl:value-of select="string(format-number($calcValue, '0.0'))"/>
        </xsl:when>
        <xsl:when test="$calcDivFormat = '2f'">
          <xsl:value-of select="string(format-number($calcValue, '0.00'))"/>
        </xsl:when>
       <xsl:when test="$calcDivFormat = '3f'">
          <xsl:value-of select="string(format-number($calcValue, '0.000'))"/>
        </xsl:when>
        <xsl:when test="$calcDivFormat = '1f_'">
          <xsl:variable name="f1String">
            <xsl:value-of select="string(format-number($calcValue, '0.0'))"/>
          </xsl:variable>
          <xsl:value-of select="concat(substring-before($f1String, '.'), ',', substring-after($f1String, '.'))"/>
        </xsl:when>
        <xsl:when test="$calcDivFormat = '2f_'">
          <xsl:variable name="f2String">
            <xsl:value-of select="string(format-number($calcValue, '0.00'))"/>
          </xsl:variable>
          <xsl:value-of select="concat(substring-before($f2String, '.'), ',', substring-after($f2String, '.'))"/>
        </xsl:when>
        <xsl:when test="$calcDivFormat = '3f_'">
          <xsl:variable name="f3String">
            <xsl:value-of select="string(format-number($calcValue, '0.000'))"/>
          </xsl:variable>
          <xsl:value-of select="concat(substring-before($f3String, '.'), ',', substring-after($f3String, '.'))"/>
        </xsl:when>
        <xsl:otherwise>
        <xsl:variable name="f4String">
            <xsl:value-of select="string(format-number($calcValue, '0.000'))"/>
          </xsl:variable>
          <xsl:value-of select="substring-before($f4String, '.')"/>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:variable>
    <xsl:value-of select="$formattedString"/>
  </xsl:template>
  <xsl:template name="addCurrencySign">
		<xsl:param name="productFieldValue"/>
		<xsl:param name="currencySign"/>
		<xsl:param name="currencyPosition"/>
		<xsl:param name="currencyFormat"/>
		<xsl:param name="zeroformatEnabled"/>
		<xsl:param name="currencyCode"/>		
		<xsl:variable name="decimalFormat">
			<xsl:choose>
        <xsl:when test="$currencyFormat = 'euro' and $currencyCode = 'PC'">
          <xsl:variable name="decimalFormatPc">
            <xsl:value-of select='format-number(number($productFieldValue), "###.##0,00", "euro")'/>
          </xsl:variable>
          <xsl:value-of select='substring-before($decimalFormatPc, ",")'/>
        </xsl:when>
				<xsl:when test="$currencyFormat = 'euro' and $zeroformatEnabled = 'false'">
					<xsl:value-of select='format-number(number($productFieldValue), "###.##0,##", "euro")'/>
				</xsl:when>
				<xsl:when test="$currencyFormat = 'euro' and $zeroformatEnabled = 'true'">
					<xsl:value-of select='format-number(number($productFieldValue), "###.##0,00", "euro")'/>
				</xsl:when>
				<xsl:when test="$currencyFormat = 'usa' and $zeroformatEnabled = 'false'">
					<xsl:value-of select='format-number(number($productFieldValue), "###,##0.##", "usa")'/>
				</xsl:when>
				<xsl:when test="$currencyFormat = 'usa' and $zeroformatEnabled = 'true'">
					<xsl:value-of select='format-number(number($productFieldValue), "###,##0.00", "usa")'/>
				</xsl:when>
				<xsl:when test="$currencyFormat = 'thousandSeparator'">
					<xsl:value-of select='format-number(number($productFieldValue), "###,###.##", "usa")'/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$productFieldValue"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:variable name="currencyfiedString">
			<xsl:choose>
				<xsl:when test="$currencyPosition = 'end'">
					<xsl:value-of select="concat($decimalFormat, $currencySign)"/>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="concat($currencySign, $decimalFormat)"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:value-of select="$currencyfiedString"/>
	</xsl:template>
  <xsl:template name="additionalCurrencyFormatting">
    <xsl:param name="currencyfiedString"/>
    <xsl:param name="currencyFormat"/>
    <xsl:param name="currencyFormatType"/>
    <xsl:param name="currencySign"/>
    <xsl:param name="textAnchor"/>
    <xsl:param name="fontFamily"/>
    <xsl:param name="fontWeight"/>
    <xsl:param name="fontStyle"/>
    <xsl:param name="fontSize"/>
    <xsl:param name="textWidth"/>
    <xsl:param name="textHeight"/>
    <xsl:param name="lineHeight"/>
    <xsl:param name="textLineHeight"/>
    <xsl:param name="tspanX"/>
    <xsl:param name="tspanY"/>
    <xsl:param name="text_decoration_overline"/>
    <xsl:param name="text_decoration_underline"/>
    <xsl:param name="text_decoration_strikethrough"/>
    <xsl:param name="zeroformatEnabled"/>
    <xsl:choose>
      <xsl:when test="$currencyFormat = 'euro'">
        <xsl:choose>
          <!-- Format 1 EURO -->
          <xsl:when test="$currencyFormatType = '1'">
            <xsl:choose>
              <xsl:when test="substring-after($currencyfiedString, ',') = concat('00',$currencySign)">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize ))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                    <xsl:with-param name="counter" select="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                    <xsl:with-param name="counter" select="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>
                  <xsl:value-of select="$currencyfiedString"></xsl:value-of>
                </xsl:element>
              </xsl:when>
              <xsl:otherwise>
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize ))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize )"/>
                    <xsl:with-param name="counter" select="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                    <xsl:with-param name="counter" select="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                  <xsl:attribute name="text-decoration">
                    <xsl:value-of select="'line-through'"/>
                  </xsl:attribute>
                  </xsl:if>
                  <xsl:value-of select="$currencyfiedString"></xsl:value-of>
                </xsl:element>
              </xsl:otherwise>
            </xsl:choose>
          </xsl:when>
          <!-- Format 1 EURO ends -->
          <!-- Format 2 EURO -->
          <xsl:when test="$currencyFormatType = '2'">
            <xsl:choose>
              <xsl:when test="substring-after($currencyfiedString, ',') = concat('00',$currencySign)">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'underline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                  <xsl:with-param name="counter" select="((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                  <xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
              <xsl:if test="$text_decoration_overline = 'overline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'overline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                  <xsl:with-param name="counter" select="((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                  <xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                  <xsl:attribute name="text-decoration">
                    <xsl:value-of select="'line-through'"/>
                  </xsl:attribute>
                  </xsl:if>
                  <xsl:value-of select="substring-before($currencyfiedString, ',')"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                  </xsl:attribute>
                  <xsl:attribute name="dy">
                    <xsl:value-of select="- $fontSize div 2.5"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>
                  <xsl:value-of select="substring($currencyfiedString, string-length($currencyfiedString) - 2, 2)"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize)  + dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>
                  <xsl:value-of select="substring($currencyfiedString, string-length($currencyfiedString), 1)"/>
                </xsl:element>
              </xsl:when>
              <xsl:when test="substring-after($currencyfiedString, ',') != concat('00',$currencySign) and (contains($currencyfiedString, ','))">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>
                  <xsl:value-of select="substring-before($currencyfiedString, ',')"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                  </xsl:attribute>
                  <xsl:attribute name="dy">
                    <xsl:value-of select="- $fontSize div 2.5"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring($currencyfiedString, string-length($currencyfiedString) - 2, 2)"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize)  + dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring($currencyfiedString, string-length($currencyfiedString), 1)"/>
                </xsl:element>
              </xsl:when>
              <xsl:otherwise>
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring-before($currencyfiedString, $currencySign)"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + (dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) "/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring($currencyfiedString, string-length($currencyfiedString), 1)"/>
                </xsl:element>
              </xsl:otherwise>
            </xsl:choose>
          </xsl:when>
          <!-- Format 2 EURO ends -->
          <!-- Format 3 EURO -->
          <xsl:when test="$currencyFormatType = '3'">
            <xsl:choose>
              <xsl:when test="substring-after($currencyfiedString, ',') = '00'">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString,','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString,','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring-before($currencyfiedString,','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring-before($currencyfiedString,','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring-before($currencyfiedString,','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring-before($currencyfiedString,','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring-before($currencyfiedString,',')"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of
                            select="substring($currencyfiedString, string-length($currencyfiedString) - 1, 2)"/>
                </xsl:element>
              </xsl:when>
              <xsl:when test="substring-after($currencyfiedString, ',') != '00' and (contains($currencyfiedString, ','))">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString,','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString,','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth(substring-before($currencyfiedString,','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth(substring-before($currencyfiedString,','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth(substring-before($currencyfiedString,','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth(substring-before($currencyfiedString,','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring-before($currencyfiedString,',')"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of
                            select="substring($currencyfiedString, string-length($currencyfiedString) - 1, 2)"/>
                </xsl:element>
              </xsl:when>
              <xsl:otherwise>
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="$currencyfiedString"/>
                </xsl:element>
              </xsl:otherwise>
            </xsl:choose>
          </xsl:when>
          <!--- Format 3 EURO ends-->
          <!-- Format 11 EURO -->
          <xsl:when test="$currencyFormatType = '11'">
          <xsl:choose>
            <xsl:when test="substring-after($currencyfiedString, ',') = concat('00',$currencySign)">
              <xsl:variable name="horizontalAlignOffset">
                <xsl:if test="$textAnchor = 'start'">
                  <xsl:value-of select="0"/>
                </xsl:if>
                <xsl:if test="$textAnchor = 'middle'">
                  <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                </xsl:if>
                <xsl:if test="$textAnchor = 'end'">
                  <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize ))))"/>
                </xsl:if>
              </xsl:variable>
              <xsl:if test="$text_decoration_underline = 'underline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'underline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  <xsl:with-param name="counter" select="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                  <xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
              <xsl:if test="$text_decoration_overline = 'overline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'overline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  <xsl:with-param name="counter" select="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
              <xsl:element name="svg:tspan">
                <xsl:attribute name="x">
                  <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                </xsl:attribute>
                <xsl:attribute name="y">
                  <xsl:value-of select="$tspanY"/>
                </xsl:attribute>
                <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                  <xsl:attribute name="text-decoration">
                    <xsl:value-of select="'line-through'"/>
                  </xsl:attribute>
                </xsl:if>
                <xsl:value-of select="$currencyfiedString"></xsl:value-of>
              </xsl:element>
            </xsl:when>
            <xsl:otherwise>
              <xsl:variable name="horizontalAlignOffset">
                <xsl:if test="$textAnchor = 'start'">
                  <xsl:value-of select="0"/>
                </xsl:if>
                <xsl:if test="$textAnchor = 'middle'">
                  <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                </xsl:if>
                <xsl:if test="$textAnchor = 'end'">
                  <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize ))))"/>
                </xsl:if>
              </xsl:variable>
              <xsl:if test="$text_decoration_underline = 'underline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'underline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize )"/>
                  <xsl:with-param name="counter" select="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
              <xsl:if test="$text_decoration_overline = 'overline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'overline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  <xsl:with-param name="counter" select="dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
              <xsl:element name="svg:tspan">
                <xsl:attribute name="x">
                  <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                </xsl:attribute>
                <xsl:attribute name="y">
                  <xsl:value-of select="$tspanY"/>
                </xsl:attribute>
                <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                <xsl:attribute name="text-decoration">
                  <xsl:value-of select="'line-through'"/>
                </xsl:attribute>
                </xsl:if>
                <xsl:value-of select="$currencyfiedString"></xsl:value-of>
              </xsl:element>
            </xsl:otherwise>
          </xsl:choose>
          </xsl:when>
          <!--- Format 11 EURO ends-->
          <!-- Format 7 EURO -->
          <xsl:when test="$currencyFormatType = '7'">
            <xsl:choose>
              <xsl:when test="substring-after($currencyfiedString, ',') = concat('00',$currencySign)">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'underline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                  <xsl:with-param name="counter" select="((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                  <xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
              <xsl:if test="$text_decoration_overline = 'overline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'overline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                  <xsl:with-param name="counter" select="((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                  <xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                  <xsl:attribute name="text-decoration">
                    <xsl:value-of select="'line-through'"/>
                  </xsl:attribute>
                  </xsl:if>
                  <xsl:value-of select="substring-before($currencyfiedString, ',')"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                  </xsl:attribute>
                  <xsl:attribute name="dy">
                    <xsl:value-of select="- $fontSize div 2.5"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>
                  <xsl:value-of select="substring-after($currencyfiedString, ',')"/>
                </xsl:element>
              </xsl:when>
              <xsl:when test="substring-after($currencyfiedString, ',') != concat('00',$currencySign) and (contains($currencyfiedString, ','))">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>
                  <xsl:value-of select="substring-before($currencyfiedString, ',')"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(substring-before($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                  </xsl:attribute>
                  <xsl:attribute name="dy">
                    <xsl:value-of select="- $fontSize div 2.5"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring-after($currencyfiedString, ',')"/>
                </xsl:element>
              </xsl:when>
              <xsl:otherwise>
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring-before($currencyfiedString, $currencySign)"/>
                </xsl:element>
              </xsl:otherwise>
            </xsl:choose>
          </xsl:when>
          <!-- Format 7 EURO ends -->
          <!-- Format 8 EURO -->
          <xsl:when test="$currencyFormatType = '8'">
            <xsl:choose>
              <xsl:when test="substring-after($currencyfiedString, ',') = '00'">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="concat(substring-before($currencyfiedString,','),',')"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(concat(substring-before($currencyfiedString, ','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of
                    select="substring-after($currencyfiedString, ',')"/>
                </xsl:element>
              </xsl:when>
              <xsl:when test="substring-after($currencyfiedString, ',') != '00' and (contains($currencyfiedString, ','))">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="concat(substring-before($currencyfiedString,','),',')"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(concat(substring-before($currencyfiedString, ','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of
                    select="substring-after($currencyfiedString, ',')"/>
                </xsl:element>
              </xsl:when>
              <xsl:otherwise>
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="$currencyfiedString"/>
                </xsl:element>
              </xsl:otherwise>
            </xsl:choose>
          </xsl:when>
          <!--- Format 8 EURO ends-->
          <!-- Format 9 EURO -->
          <xsl:when test="$currencyFormatType = '9'">
            <xsl:choose>
              <xsl:when test="substring-after($currencyfiedString, ',') = '00'">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="concat(substring-before($currencyfiedString,','),',')"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(concat(substring-before($currencyfiedString, ','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:attribute name="dy">
                    <xsl:value-of select="- $fontSize div 2.5"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of
                    select="substring-after($currencyfiedString, ',')"/>
                </xsl:element>
              </xsl:when>
              <xsl:when test="substring-after($currencyfiedString, ',') != '00' and (contains($currencyfiedString, ','))">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth(concat(substring-before($currencyfiedString,','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, ','), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="concat(substring-before($currencyfiedString,','),',')"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(concat(substring-before($currencyfiedString, ','),','), $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:attribute name="dy">
                    <xsl:value-of select="- $fontSize div 2.5"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of
                    select="substring-after($currencyfiedString, ',')"/>
                </xsl:element>
              </xsl:when>
              <xsl:otherwise>
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="$currencyfiedString"/>
                </xsl:element>
              </xsl:otherwise>
            </xsl:choose>
          </xsl:when>
          <!--- Format 9 EURO ends-->
          <xsl:otherwise>
            <xsl:choose>
              <xsl:when test="substring-after($currencyfiedString, ',') = '00'">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after(substring($currencyfiedString, 1, string-length($currencyfiedString)-2), $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after(substring($currencyfiedString, 1, string-length($currencyfiedString)-2), $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after(substring($currencyfiedString, 1, string-length($currencyfiedString)-2), $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after(substring($currencyfiedString, 1, string-length($currencyfiedString)-2), $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after(substring($currencyfiedString, 1, string-length($currencyfiedString)-2), $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after(substring($currencyfiedString, 1, string-length($currencyfiedString)-2), $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                  </xsl:attribute>
                  <xsl:attribute name="dy">
                    <xsl:value-of select="- $fontSize div 2.5"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring($currencyfiedString, 1, 1)"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of
                            select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth($currencySign, $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring-after(substring($currencyfiedString, 1, string-length($currencyfiedString)-2), $currencySign)"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + (dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after(substring($currencyfiedString, 1, string-length($currencyfiedString)-2), $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) "/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of
                          select="substring($currencyfiedString, string-length($currencyfiedString) - 1, 2)"/>
                </xsl:element>
              </xsl:when>
              <xsl:when test="substring-after($currencyfiedString, ',') != '00' and (contains($currencyfiedString, ','))">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after(substring($currencyfiedString, 1, string-length($currencyfiedString)-2), $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after(substring($currencyfiedString, 1, string-length($currencyfiedString)-2), $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after(substring($currencyfiedString, 1, string-length($currencyfiedString)-2), $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after(substring($currencyfiedString, 1, string-length($currencyfiedString)-2), $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after(substring($currencyfiedString, 1, string-length($currencyfiedString)-2), $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after(substring($currencyfiedString, 1, string-length($currencyfiedString)-2), $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                  </xsl:attribute>
                  <xsl:attribute name="dy">
                    <xsl:value-of select="- $fontSize div 2.5"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring($currencyfiedString, 1, 1)"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of
                            select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth($currencySign, $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring-after(substring($currencyfiedString, 1, string-length($currencyfiedString)-2), $currencySign)"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + (dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after(substring($currencyfiedString, 1, string-length($currencyfiedString)-2), $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) "/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of
                          select="substring($currencyfiedString, string-length($currencyfiedString) - 1, 2)"/>
                </xsl:element>
              </xsl:when>
              <xsl:otherwise>
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                  </xsl:attribute>
                  <xsl:attribute name="dy">
                    <xsl:value-of select="- $fontSize div 2.5"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring($currencyfiedString, 1, 1)"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of
                            select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth($currencySign, $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring-after($currencyfiedString, $currencySign)"/>
                </xsl:element>
              </xsl:otherwise>
            </xsl:choose>
          </xsl:otherwise>
        </xsl:choose>
      </xsl:when>
      <xsl:when test="$currencyFormat = 'usa'">
        <xsl:choose>
        <!-- US Format 10 for no currency sign -->
          <xsl:when test="$currencyFormatType='10' and $currencySign='&#160;'">
            <xsl:choose>
              <xsl:when test="substring-after($currencyfiedString, '.') = '00&#160;'">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring($currencyfiedString, 1, string-length($currencyfiedString)-3)"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of
                      select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-4), $fontFamily, $fontWeight, $fontStyle, $fontSize)" />
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY - ($fontSize div 3.5)"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.6),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of
                    select="substring($currencyfiedString, string-length($currencyfiedString) - 2, 2)"
                  />
                </xsl:element>
              </xsl:when>
              <xsl:when test="substring-after($currencyfiedString, '.') != '00&#160;' and (contains($currencyfiedString, '.'))">
                <xsl:variable name="makeFixupto2DigitAppendZero">
                   <xsl:choose>
                    <xsl:when test="string-length ( normalize-space (substring-after($currencyfiedString,'.')))  =  2 ">
                      <xsl:value-of select="'0'"/>
                    </xsl:when>
                    <xsl:otherwise>
                      <xsl:value-of select="''"/>
                    </xsl:otherwise>
                  </xsl:choose>
                </xsl:variable>
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(concat(substring-before($currencyfiedString, '.'), '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring-after($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(concat(substring-before($currencyfiedString, '.'), '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring-after($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(concat(substring-before($currencyfiedString, '.'), '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring-after($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(concat(substring-before($currencyfiedString, '.'), '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring-after($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(concat(substring-before($currencyfiedString, '.'), '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring-after($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(concat(substring-before($currencyfiedString, '.'), '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring-after($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="concat(substring-before($currencyfiedString, '.'), '.')"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of
                      select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(substring-before($currencyfiedString,'.'), $fontFamily, $fontWeight, $fontStyle, $fontSize)" />
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY - ($fontSize div 3.5)"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.6),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of
                    select="concat(translate(substring-after($currencyfiedString, '.'),'&#160;',''), $makeFixupto2DigitAppendZero)"
                  />
                </xsl:element> 
              </xsl:when>
              <xsl:otherwise>
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize ))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize ))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize ))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize ))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize ))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring-before($currencyfiedString, $currencySign)" />
                </xsl:element>
              </xsl:otherwise>
            </xsl:choose>
          </xsl:when>
          <!-- US Format 10 for no currency sign ends here-->
          <!-- US Format 1-->
          <xsl:when test="$currencyFormatType='1' and $currencySign='&#160;'">
            <xsl:choose>
              <xsl:when test="substring-after($currencyfiedString, '.') = '00&#160;'">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring($currencyfiedString, 1, string-length($currencyfiedString)-3)"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of
                select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize)" />
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of
              select="substring($currencyfiedString, string-length($currencyfiedString) - 2, 2)"
            />
                </xsl:element>
              </xsl:when>
              <xsl:when test="substring-after($currencyfiedString, '.') != '00&#160;' and (contains($currencyfiedString, '.'))">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring($currencyfiedString, 1, string-length($currencyfiedString)-3)"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of
                select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-3), $fontFamily, $fontWeight, $fontStyle, $fontSize)" />
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of
              select="substring($currencyfiedString, string-length($currencyfiedString) - 2, 2)"
            />
                </xsl:element>
              </xsl:when>
              <xsl:otherwise>
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize ))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize ))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize ))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize ))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize ))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring-before($currencyfiedString, $currencySign)" />
                </xsl:element>
              </xsl:otherwise>
            </xsl:choose>
          </xsl:when>
          <xsl:when test="$currencyFormatType = '1'">
            <xsl:choose>
              <xsl:when test="substring-after($currencyfiedString, '.') = concat('00',$currencySign)">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring-before($currencyfiedString, $currencySign)"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + (dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                  </xsl:attribute>
                  <xsl:attribute name="dy">
                    <xsl:value-of select="- $fontSize div 2.5"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:value-of select="substring($currencyfiedString, string-length($currencyfiedString), 1)"/>
                </xsl:element>
              </xsl:when>
              <xsl:when test="substring-after($currencyfiedString, '.') != concat('00',$currencySign) and (contains($currencyfiedString, '.'))">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
              <xsl:if test="$text_decoration_underline = 'underline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'underline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                  <xsl:with-param name="counter" select="(dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                  <xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
              <xsl:if test="$text_decoration_overline = 'overline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'overline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                  <xsl:with-param name="counter" select="(dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                  <xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring-before($currencyfiedString, $currencySign)"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                  <xsl:value-of select="$tspanX + $horizontalAlignOffset + (dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                  </xsl:attribute>
                  <xsl:attribute name="dy">
                    <xsl:value-of select="- $fontSize div 2.5"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring($currencyfiedString, string-length($currencyfiedString), 1)"/>
                </xsl:element>
              </xsl:when>
              <xsl:otherwise>
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-1), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-1), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-1), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-1), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-1), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, string-length($currencyfiedString)-1), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring($currencyfiedString, 1, string-length($currencyfiedString)-1)"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(substring-before($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                  </xsl:attribute>
                  <xsl:attribute name="dy">
                    <xsl:value-of select="- $fontSize div 2.5"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;' )"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring($currencyfiedString, string-length($currencyfiedString), 1)"/>
                </xsl:element>
              </xsl:otherwise>
            </xsl:choose>
          </xsl:when>
          <!-- US Format 1 ends-->
          <!-- Format 2 USA -->
          <xsl:when test="$currencyFormatType = '2'">
            <xsl:choose>
              <xsl:when test="substring-after($currencyfiedString, '.') = concat('00',$currencySign)">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring-before($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring-before($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY - 1"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring-before($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring-before($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring-before($currencyfiedString, '.')"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of
                          select="$tspanX + $horizontalAlignOffset+ dgext:getTextWidth(substring-before($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize)" />
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                  </xsl:attribute>
                  <xsl:attribute name="dy">
                    <xsl:value-of select="- $fontSize div 2.5"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of
                        select="substring($currencyfiedString, string-length($currencyfiedString) - 2, 2)"
                      />
                </xsl:element>
                <xsl:if test="substring($currencyfiedString, string-length($currencyfiedString), 1) != '&#160;'">
                  <xsl:element name="svg:tspan">
                    <xsl:attribute name="x">
                      <xsl:value-of select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(substring-before($currencyfiedString,'.'), $fontFamily, $fontWeight, $fontStyle, $fontSize) + dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))"/>
                    </xsl:attribute>
                    <xsl:attribute name="y">
                      <xsl:value-of select="$tspanY"/>
                    </xsl:attribute>
                    <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                      <xsl:attribute name="text-decoration">
                        <xsl:value-of select="'line-through'"/>
                      </xsl:attribute>
                    </xsl:if>                  
                    <xsl:value-of
                          select="substring($currencyfiedString, string-length($currencyfiedString), 1)"/>
                  </xsl:element>
                </xsl:if>  
              </xsl:when>
              <xsl:when test="(substring-after($currencyfiedString, '.') != concat('00',$currencySign))  and (contains($currencyfiedString, '.'))">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring-before($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring-before($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring-before($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY - 1"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring-before($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="counter" select="(dgext:getTextWidth(substring-before($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize )) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString), 1), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="substring-before($currencyfiedString, '.')"/>
                </xsl:element>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of
                          select="$tspanX + $horizontalAlignOffset+ dgext:getTextWidth(substring-before($currencyfiedString, '.'), $fontFamily, $fontWeight, $fontStyle, $fontSize)" />
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                  </xsl:attribute>
                  <xsl:attribute name="dy">
                    <xsl:value-of select="- $fontSize div 2.5"/>
                  </xsl:attribute>
                  <xsl:attribute name="style">
                    <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of
                        select="substring($currencyfiedString, string-length($currencyfiedString) - 2, 2)"
                      />
                </xsl:element>
                <xsl:if test="substring($currencyfiedString, string-length($currencyfiedString), 1) != '&#160;'">
                  <xsl:element name="svg:tspan">
                    <xsl:attribute name="x">
                      <xsl:value-of select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth(substring-before($currencyfiedString,'.'), $fontFamily, $fontWeight, $fontStyle, $fontSize) + dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 2, 2), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))"/>
                    </xsl:attribute>
                    <xsl:attribute name="y">
                      <xsl:value-of select="$tspanY"/>
                    </xsl:attribute>
                    <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                      <xsl:attribute name="text-decoration">
                        <xsl:value-of select="'line-through'"/>
                      </xsl:attribute>
                    </xsl:if>                  
                    <xsl:value-of
                          select="substring($currencyfiedString, string-length($currencyfiedString), 1)"/>
                  </xsl:element>
                </xsl:if> 
              </xsl:when>
              <xsl:otherwise>
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>                    
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
<xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                    <xsl:with-param name="isNoCurrenctFormat2SpecialCondition" select="$zeroformatEnabled = 'false' and (not(contains($currencyfiedString, '.')) or not(contains($currencyfiedString, '.00')))"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>                  
                  <xsl:value-of select="$currencyfiedString"/>
                </xsl:element>
              </xsl:otherwise>
            </xsl:choose>
          </xsl:when>
          <!-- Format 2 USA ends -->
          <!-- Format 3 USA -->
          <xsl:when test="$currencyFormatType = '3'">
            <xsl:choose>
              <xsl:when test="substring-after($currencyfiedString, '.') = concat('00',$currencySign)">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - (dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth -  (dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'underline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  <xsl:with-param name="counter" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                  <xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
              <xsl:if test="$text_decoration_overline = 'overline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'overline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  <xsl:with-param name="counter" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                  <xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>
                  <xsl:value-of
                      select="$currencyfiedString"/>
                </xsl:element>
              </xsl:when>
              <xsl:otherwise>
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - (dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth -  (dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'underline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  <xsl:with-param name="counter" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                  <xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
              <xsl:if test="$text_decoration_overline = 'overline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'overline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  <xsl:with-param name="counter" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                  <xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                  <xsl:attribute name="text-decoration">
                    <xsl:value-of select="'line-through'"/>
                  </xsl:attribute>
                  </xsl:if>
                  <xsl:value-of
                      select="$currencyfiedString"/>
                </xsl:element>
              </xsl:otherwise>
            </xsl:choose>
          </xsl:when>
          <!-- Format 3 USA ends -->
          <!-- Format 11 USA -->
          <xsl:when test="$currencyFormatType = '11'">
            <xsl:choose>
              <xsl:when test="substring-after($currencyfiedString, '.') = concat('00',$currencySign)">
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - (dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth -  (dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'underline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  <xsl:with-param name="counter" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                  <xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
              <xsl:if test="$text_decoration_overline = 'overline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'overline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  <xsl:with-param name="counter" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                  <xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                    <xsl:attribute name="text-decoration">
                      <xsl:value-of select="'line-through'"/>
                    </xsl:attribute>
                  </xsl:if>
                  <xsl:value-of
                      select="$currencyfiedString"/>
                </xsl:element>
              </xsl:when>
              <xsl:otherwise>
                <xsl:variable name="horizontalAlignOffset">
                  <xsl:if test="$textAnchor = 'start'">
                    <xsl:value-of select="0"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'middle'">
                    <xsl:value-of select="($textWidth - (dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))) div 2"/>
                  </xsl:if>
                  <xsl:if test="$textAnchor = 'end'">
                    <xsl:value-of select="($textWidth -  (dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                  </xsl:if>
                </xsl:variable>
                <xsl:if test="$text_decoration_underline = 'underline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'underline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  <xsl:with-param name="counter" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                  <xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
              <xsl:if test="$text_decoration_overline = 'overline'">
                <xsl:call-template name="createFontStyleLineEffectSpan">
                  <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                  <xsl:with-param name="tspanY" select="$tspanY"/>
                  <xsl:with-param name="text_decoration" select="'overline'"/>
                  <xsl:with-param name="lineHeight" select="$lineHeight"/>
                  <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                  <xsl:with-param name="textWidth" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  <xsl:with-param name="counter" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                  <xsl:with-param name="spaceString" select="'&#160;'"/>
                  <xsl:with-param name="fontFamily" select="$fontFamily"/>
                  <xsl:with-param name="fontWeight" select="$fontWeight"/>
                  <xsl:with-param name="fontStyle" select="$fontStyle"/>
                  <xsl:with-param name="fontSize" select="$fontSize"/>
                  <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                  <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                  <xsl:with-param name="currencySign" select="$currencySign"/>
                  <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                </xsl:call-template>
              </xsl:if>
                <xsl:element name="svg:tspan">
                  <xsl:attribute name="x">
                    <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                  </xsl:attribute>
                  <xsl:attribute name="y">
                    <xsl:value-of select="$tspanY"/>
                  </xsl:attribute>
                  <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                  <xsl:attribute name="text-decoration">
                    <xsl:value-of select="'line-through'"/>
                  </xsl:attribute>
                  </xsl:if>
                  <xsl:value-of
                      select="$currencyfiedString"/>
                </xsl:element>
              </xsl:otherwise>
            </xsl:choose>
          </xsl:when>
          <!-- Format 11 USA ends -->
          <!-- Format 5 only for  USA $ and format4 for all others begins-->
          <xsl:otherwise>
            <xsl:choose>
              <xsl:when test="$currencyFormatType='5' and $currencySign='$'" >
                <xsl:choose>
                  <xsl:when test="substring-after($currencyfiedString, '.') = '00'">
                    <xsl:variable name="horizontalAlignOffset">
                      <xsl:if test="$textAnchor = 'start'">
                        <xsl:value-of select="0"/>
                      </xsl:if>
                      <xsl:if test="$textAnchor = 'middle'">
                        <xsl:value-of select="($textWidth - (dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))) div 2"/>
                      </xsl:if>
                      <xsl:if test="$textAnchor = 'end'">
                        <xsl:value-of select="($textWidth -  (dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                      </xsl:if>
                    </xsl:variable>
                    <xsl:if test="$text_decoration_underline = 'underline'">
                    <xsl:call-template name="createFontStyleLineEffectSpan">
                      <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                      <xsl:with-param name="tspanY" select="$tspanY"/>
                      <xsl:with-param name="text_decoration" select="'underline'"/>
                      <xsl:with-param name="lineHeight" select="$lineHeight"/>
                      <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                      <xsl:with-param name="textWidth" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                      <xsl:with-param name="counter" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                      <xsl:with-param name="spaceString" select="'&#160;'"/>
                      <xsl:with-param name="fontFamily" select="$fontFamily"/>
                      <xsl:with-param name="fontWeight" select="$fontWeight"/>
                      <xsl:with-param name="fontStyle" select="$fontStyle"/>
                      <xsl:with-param name="fontSize" select="$fontSize"/>
                      <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                      <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                      <xsl:with-param name="currencySign" select="$currencySign"/>
                      <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                    </xsl:call-template>
                  </xsl:if>
                  <xsl:if test="$text_decoration_overline = 'overline'">
                    <xsl:call-template name="createFontStyleLineEffectSpan">
                      <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                      <xsl:with-param name="tspanY" select="$tspanY"/>
                      <xsl:with-param name="text_decoration" select="'overline'"/>
                      <xsl:with-param name="lineHeight" select="$lineHeight"/>
                      <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                      <xsl:with-param name="textWidth" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                      <xsl:with-param name="counter" select="(dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                      <xsl:with-param name="spaceString" select="'&#160;'"/>
                      <xsl:with-param name="fontFamily" select="$fontFamily"/>
                      <xsl:with-param name="fontWeight" select="$fontWeight"/>
                      <xsl:with-param name="fontStyle" select="$fontStyle"/>
                      <xsl:with-param name="fontSize" select="$fontSize"/>
                      <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                      <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                      <xsl:with-param name="currencySign" select="$currencySign"/>
                      <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                    </xsl:call-template>
                  </xsl:if>
                    <xsl:element name="svg:tspan">
                      <xsl:attribute name="x">
                        <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                      </xsl:attribute>
                      <xsl:attribute name="y">
                        <xsl:value-of select="$tspanY"/>
                      </xsl:attribute>
                      <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                        <xsl:attribute name="text-decoration">
                          <xsl:value-of select="'line-through'"/>
                        </xsl:attribute>
                      </xsl:if>
                      <xsl:value-of select="$currencyfiedString"/>
                    </xsl:element>
                  </xsl:when>
                  <xsl:otherwise>
                    <xsl:variable name="horizontalAlignOffset">
                      <xsl:if test="$textAnchor = 'start'">
                        <xsl:value-of select="0"/>
                      </xsl:if>
                      <xsl:if test="$textAnchor = 'middle'">
                        <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                      </xsl:if>
                      <xsl:if test="$textAnchor = 'end'">
                        <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))))"/>
                      </xsl:if>
                    </xsl:variable>
                    <xsl:if test="$text_decoration_underline = 'underline'">
                    <xsl:call-template name="createFontStyleLineEffectSpan">
                      <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                      <xsl:with-param name="tspanY" select="$tspanY"/>
                      <xsl:with-param name="text_decoration" select="'underline'"/>
                      <xsl:with-param name="lineHeight" select="$lineHeight"/>
                      <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                      <xsl:with-param name="textWidth" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                      <xsl:with-param name="counter" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                      <xsl:with-param name="spaceString" select="'&#160;'"/>
                      <xsl:with-param name="fontFamily" select="$fontFamily"/>
                      <xsl:with-param name="fontWeight" select="$fontWeight"/>
                      <xsl:with-param name="fontStyle" select="$fontStyle"/>
                      <xsl:with-param name="fontSize" select="$fontSize"/>
                      <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                      <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                      <xsl:with-param name="currencySign" select="$currencySign"/>
                      <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                    </xsl:call-template>
                  </xsl:if>
                  <xsl:if test="$text_decoration_overline = 'overline'">
                    <xsl:call-template name="createFontStyleLineEffectSpan">
                      <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                      <xsl:with-param name="tspanY" select="$tspanY"/>
                      <xsl:with-param name="text_decoration" select="'overline'"/>
                      <xsl:with-param name="lineHeight" select="$lineHeight"/>
                      <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                      <xsl:with-param name="textWidth" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                      <xsl:with-param name="counter" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                      <xsl:with-param name="spaceString" select="'&#160;'"/>
                      <xsl:with-param name="fontFamily" select="$fontFamily"/>
                      <xsl:with-param name="fontWeight" select="$fontWeight"/>
                      <xsl:with-param name="fontStyle" select="$fontStyle"/>
                      <xsl:with-param name="fontSize" select="$fontSize"/>
                      <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                      <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                      <xsl:with-param name="currencySign" select="$currencySign"/>
                      <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                    </xsl:call-template>
                  </xsl:if>
                    <xsl:element name="svg:tspan">
                      <xsl:attribute name="x">
                        <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                      </xsl:attribute>
                      <xsl:attribute name="y">
                        <xsl:value-of select="$tspanY"/>
                      </xsl:attribute>
                      <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                        <xsl:attribute name="text-decoration">
                          <xsl:value-of select="'line-through'"/>
                        </xsl:attribute>
                      </xsl:if>
                      <xsl:value-of select="$currencyfiedString"/>
                    </xsl:element>
                  </xsl:otherwise>
                </xsl:choose>
              </xsl:when>
              <xsl:when test="$currencyFormatType='5' and $currencySign='&#160;'">
                <xsl:choose>
                  <xsl:when test="substring-after($currencyfiedString, '.') = '00'">
                    <xsl:variable name="horizontalAlignOffset">
                      <xsl:if test="$textAnchor = 'start'">
                        <xsl:value-of select="0"/>
                      </xsl:if>
                      <xsl:if test="$textAnchor = 'middle'">
                        <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                      </xsl:if>
                      <xsl:if test="$textAnchor = 'end'">
                        <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))))"/>
                      </xsl:if>
                    </xsl:variable>
                    <xsl:if test="$text_decoration_underline = 'underline'">
                    <xsl:call-template name="createFontStyleLineEffectSpan">
                      <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                      <xsl:with-param name="tspanY" select="$tspanY"/>
                      <xsl:with-param name="text_decoration" select="'underline'"/>
                      <xsl:with-param name="lineHeight" select="$lineHeight"/>
                      <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                      <xsl:with-param name="textWidth" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                      <xsl:with-param name="counter" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                      <xsl:with-param name="spaceString" select="'&#160;'"/>
                      <xsl:with-param name="fontFamily" select="$fontFamily"/>
                      <xsl:with-param name="fontWeight" select="$fontWeight"/>
                      <xsl:with-param name="fontStyle" select="$fontStyle"/>
                      <xsl:with-param name="fontSize" select="$fontSize"/>
                      <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                      <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                      <xsl:with-param name="currencySign" select="$currencySign"/>
                      <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                    </xsl:call-template>
                  </xsl:if>
                  <xsl:if test="$text_decoration_overline = 'overline'">
                    <xsl:call-template name="createFontStyleLineEffectSpan">
                      <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                      <xsl:with-param name="tspanY" select="$tspanY"/>
                      <xsl:with-param name="text_decoration" select="'overline'"/>
                      <xsl:with-param name="lineHeight" select="$lineHeight"/>
                      <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                      <xsl:with-param name="textWidth" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                      <xsl:with-param name="counter" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))"/>
                      <xsl:with-param name="spaceString" select="'&#160;'"/>
                      <xsl:with-param name="fontFamily" select="$fontFamily"/>
                      <xsl:with-param name="fontWeight" select="$fontWeight"/>
                      <xsl:with-param name="fontStyle" select="$fontStyle"/>
                      <xsl:with-param name="fontSize" select="$fontSize"/>
                      <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                      <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                      <xsl:with-param name="currencySign" select="$currencySign"/>
                      <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                    </xsl:call-template>
                  </xsl:if>
                    <xsl:element name="svg:tspan">
                      <xsl:attribute name="x">
                        <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                      </xsl:attribute>
                      <xsl:attribute name="y">
                        <xsl:value-of select="$tspanY"/>
                      </xsl:attribute>
                      <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                        <xsl:attribute name="text-decoration">
                          <xsl:value-of select="'line-through'"/>
                        </xsl:attribute>
                      </xsl:if>                      
                      <xsl:value-of select="$currencyfiedString"/>
                    </xsl:element>
                  </xsl:when>
                  <xsl:otherwise>
                  <xsl:variable name="horizontalAlignOffset">
                    <xsl:if test="$textAnchor = 'start'">
                      <xsl:value-of select="0"/>
                    </xsl:if>
                    <xsl:if test="$textAnchor = 'middle'">
                      <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                    </xsl:if>
                    <xsl:if test="$textAnchor = 'end'">
                      <xsl:value-of select="($textWidth - ((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize))))"/>
                    </xsl:if>
                  </xsl:variable>
                  <xsl:if test="$text_decoration_underline = 'underline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'underline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)) - dgext:getTextWidth(' ', $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)) - dgext:getTextWidth(' ', $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                <xsl:if test="$text_decoration_overline = 'overline'">
                  <xsl:call-template name="createFontStyleLineEffectSpan">
                    <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                    <xsl:with-param name="tspanY" select="$tspanY"/>
                    <xsl:with-param name="text_decoration" select="'overline'"/>
                    <xsl:with-param name="lineHeight" select="$lineHeight"/>
                    <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                    <xsl:with-param name="textWidth" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)) - dgext:getTextWidth(' ', $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                    <xsl:with-param name="counter" select="((dgext:getTextWidth($currencyfiedString, $fontFamily, $fontWeight, $fontStyle, $fontSize)) - dgext:getTextWidth(' ', $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                    <xsl:with-param name="spaceString" select="'&#160;'"/>
                    <xsl:with-param name="fontFamily" select="$fontFamily"/>
                    <xsl:with-param name="fontWeight" select="$fontWeight"/>
                    <xsl:with-param name="fontStyle" select="$fontStyle"/>
                    <xsl:with-param name="fontSize" select="$fontSize"/>
                    <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                    <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                    <xsl:with-param name="currencySign" select="$currencySign"/>
                    <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                  </xsl:call-template>
                </xsl:if>
                    <xsl:element name="svg:tspan">                      
                      <xsl:attribute name="x">
                        <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                      </xsl:attribute>
                      <xsl:attribute name="y">
                        <xsl:value-of select="$tspanY"/>
                      </xsl:attribute>
                      <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                        <xsl:attribute name="text-decoration">
                          <xsl:value-of select="'line-through'"/>
                        </xsl:attribute>
                      </xsl:if>                      
                      <xsl:value-of select="substring($currencyfiedString,2, string-length($currencyfiedString) - 1)"/>
                    </xsl:element>
                  </xsl:otherwise>
                </xsl:choose>
              </xsl:when>
              <xsl:otherwise>
                <xsl:choose>
                  <xsl:when test="substring-after($currencyfiedString, '.') = '00'">
                    <xsl:variable name="horizontalAlignOffset">
                      <xsl:if test="$textAnchor = 'start'">
                        <xsl:value-of select="0"/>
                      </xsl:if>
                      <xsl:if test="$textAnchor = 'middle'">
                        <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, 2, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                      </xsl:if>
                      <xsl:if test="$textAnchor = 'end'">
                        <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, 2, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                      </xsl:if>
                    </xsl:variable>
                    <xsl:if test="$text_decoration_underline = 'underline'">
                    <xsl:call-template name="createFontStyleLineEffectSpan">
                      <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                      <xsl:with-param name="tspanY" select="$tspanY"/>
                      <xsl:with-param name="text_decoration" select="'underline'"/>
                      <xsl:with-param name="lineHeight" select="$lineHeight"/>
                      <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                      <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, 2, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                      <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, 2, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                      <xsl:with-param name="spaceString" select="'&#160;'"/>
                      <xsl:with-param name="fontFamily" select="$fontFamily"/>
                      <xsl:with-param name="fontWeight" select="$fontWeight"/>
                      <xsl:with-param name="fontStyle" select="$fontStyle"/>
                      <xsl:with-param name="fontSize" select="$fontSize"/>
                      <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                      <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                      <xsl:with-param name="currencySign" select="$currencySign"/>
                      <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                    </xsl:call-template>
                  </xsl:if>
                  <xsl:if test="$text_decoration_overline = 'overline'">
                    <xsl:call-template name="createFontStyleLineEffectSpan">
                      <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                      <xsl:with-param name="tspanY" select="$tspanY"/>
                      <xsl:with-param name="text_decoration" select="'overline'"/>
                      <xsl:with-param name="lineHeight" select="$lineHeight"/>
                      <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                      <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, 2, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                      <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, 2, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                      <xsl:with-param name="spaceString" select="'&#160;'"/>
                      <xsl:with-param name="fontFamily" select="$fontFamily"/>
                      <xsl:with-param name="fontWeight" select="$fontWeight"/>
                      <xsl:with-param name="fontStyle" select="$fontStyle"/>
                      <xsl:with-param name="fontSize" select="$fontSize"/>
                      <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                      <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                      <xsl:with-param name="currencySign" select="$currencySign"/>
                      <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                    </xsl:call-template>
                  </xsl:if>
                    <xsl:element name="svg:tspan">
                      <xsl:attribute name="x">
                        <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                      </xsl:attribute>
                      <xsl:attribute name="y">
                        <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                      </xsl:attribute>
                      <xsl:attribute name="dy">
                        <xsl:value-of select="- $fontSize div 2.5"/>
                      </xsl:attribute>
                      <xsl:attribute name="style">
                        <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                      </xsl:attribute>
                      <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                        <xsl:attribute name="text-decoration">
                          <xsl:value-of select="'line-through'"/>
                        </xsl:attribute>
                      </xsl:if>                      
                      <xsl:value-of select="substring($currencyfiedString, 1, 1)"/>
                    </xsl:element>
                    <xsl:element name="svg:tspan">
                      <xsl:attribute name="x">
                        <xsl:value-of select="$tspanX + dgext:getTextWidth($currencySign, $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)) + $horizontalAlignOffset"/>
                      </xsl:attribute>
                      <xsl:attribute name="y">
                        <xsl:value-of select="$tspanY"/>
                      </xsl:attribute>
                      <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                        <xsl:attribute name="text-decoration">
                          <xsl:value-of select="'line-through'"/>
                        </xsl:attribute>
                      </xsl:if>                      
                      <xsl:value-of select="substring($currencyfiedString, 2, string-length($currencyfiedString) - 3)"/>
                    </xsl:element>
                    <xsl:element name="svg:tspan">
                      <xsl:attribute name="x">
                        <xsl:value-of select="($tspanX +  dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)) + dgext:getTextWidth(substring($currencyfiedString, 2, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, $fontSize) ) + $horizontalAlignOffset"/>
                      </xsl:attribute>
                      <xsl:attribute name="y">
                        <xsl:value-of select="$tspanY"/>
                      </xsl:attribute>
                      <xsl:attribute name="style">
                        <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                      </xsl:attribute>
                      <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                        <xsl:attribute name="text-decoration">
                          <xsl:value-of select="'line-through'"/>
                        </xsl:attribute>
                      </xsl:if>                      
                      <xsl:value-of select="substring($currencyfiedString, string-length($currencyfiedString) - 1, string-length($currencyfiedString) - 3)"/>
                    </xsl:element>
                  </xsl:when>
                  <xsl:when test="substring-after($currencyfiedString, '.') != '00' and (contains($currencyfiedString, '.'))">
                    <xsl:variable name="horizontalAlignOffset">
                      <xsl:if test="$textAnchor = 'start'">
                        <xsl:value-of select="0"/>
                      </xsl:if>
                      <xsl:if test="$textAnchor = 'middle'">
                        <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, 2, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))))) div 2"/>
                      </xsl:if>
                      <xsl:if test="$textAnchor = 'end'">
                        <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, 2, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))))"/>
                      </xsl:if>
                    </xsl:variable>
                    <xsl:if test="$text_decoration_underline = 'underline'">
                    <xsl:call-template name="createFontStyleLineEffectSpan">
                      <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                      <xsl:with-param name="tspanY" select="$tspanY"/>
                      <xsl:with-param name="text_decoration" select="'underline'"/>
                      <xsl:with-param name="lineHeight" select="$lineHeight"/>
                      <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                      <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, 2, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                      <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, 2, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                      <xsl:with-param name="spaceString" select="'&#160;'"/>
                      <xsl:with-param name="fontFamily" select="$fontFamily"/>
                      <xsl:with-param name="fontWeight" select="$fontWeight"/>
                      <xsl:with-param name="fontStyle" select="$fontStyle"/>
                      <xsl:with-param name="fontSize" select="$fontSize"/>
                      <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                      <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                      <xsl:with-param name="currencySign" select="$currencySign"/>
                      <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                    </xsl:call-template>
                  </xsl:if>
                  <xsl:if test="$text_decoration_overline = 'overline'">
                    <xsl:call-template name="createFontStyleLineEffectSpan">
                      <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                      <xsl:with-param name="tspanY" select="$tspanY"/>
                      <xsl:with-param name="text_decoration" select="'overline'"/>
                      <xsl:with-param name="lineHeight" select="$lineHeight"/>
                      <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                      <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, 2, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                      <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring($currencyfiedString, 2, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, $fontSize)) + (dgext:getTextWidth(substring($currencyfiedString, string-length($currencyfiedString) - 1, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)))"/>
                      <xsl:with-param name="spaceString" select="'&#160;'"/>
                      <xsl:with-param name="fontFamily" select="$fontFamily"/>
                      <xsl:with-param name="fontWeight" select="$fontWeight"/>
                      <xsl:with-param name="fontStyle" select="$fontStyle"/>
                      <xsl:with-param name="fontSize" select="$fontSize"/>
                      <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                      <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                      <xsl:with-param name="currencySign" select="$currencySign"/>
                      <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                    </xsl:call-template>
                  </xsl:if>
                    <xsl:element name="svg:tspan">
                      <xsl:attribute name="x">
                        <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                      </xsl:attribute>
                      <xsl:attribute name="y">
                        <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                      </xsl:attribute>
                      <xsl:attribute name="dy">
                        <xsl:value-of select="- $fontSize div 2.5"/>
                      </xsl:attribute>
                      <xsl:attribute name="style">
                        <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                      </xsl:attribute>
                      <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                        <xsl:attribute name="text-decoration">
                          <xsl:value-of select="'line-through'"/>
                        </xsl:attribute>
                      </xsl:if>                      
                      <xsl:value-of select="substring($currencyfiedString, 1, 1)"/>
                    </xsl:element>
                    <xsl:element name="svg:tspan">
                      <xsl:attribute name="x">
                        <xsl:value-of select="$tspanX + dgext:getTextWidth($currencySign, $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)) + $horizontalAlignOffset"/>
                      </xsl:attribute>
                      <xsl:attribute name="y">
                        <xsl:value-of select="$tspanY"/>
                      </xsl:attribute>
                      <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                        <xsl:attribute name="text-decoration">
                          <xsl:value-of select="'line-through'"/>
                        </xsl:attribute>
                      </xsl:if>                      
                      <xsl:value-of select="substring($currencyfiedString, 2, string-length($currencyfiedString) - 3)"/>
                    </xsl:element>
                    <xsl:element name="svg:tspan">
                      <xsl:attribute name="x">
                        <xsl:value-of select="($tspanX +  dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8)) + dgext:getTextWidth(substring($currencyfiedString, 2, string-length($currencyfiedString) - 3), $fontFamily, $fontWeight, $fontStyle, $fontSize) ) + $horizontalAlignOffset"/>
                      </xsl:attribute>
                      <xsl:attribute name="y">
                        <xsl:value-of select="$tspanY"/>
                      </xsl:attribute>
                      <xsl:attribute name="style">
                        <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                      </xsl:attribute>
                      <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                        <xsl:attribute name="text-decoration">
                          <xsl:value-of select="'line-through'"/>
                        </xsl:attribute>
                      </xsl:if>                      
                      <xsl:value-of select="substring($currencyfiedString, string-length($currencyfiedString) - 1, string-length($currencyfiedString) - 3)"/>
                    </xsl:element>
                  </xsl:when>
                  <xsl:otherwise>
                    <xsl:variable name="horizontalAlignOffset">
                      <xsl:if test="$textAnchor = 'start'">
                        <xsl:value-of select="0"/>
                      </xsl:if>
                      <xsl:if test="$textAnchor = 'middle'">
                        <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize)))) div 2"/>
                      </xsl:if>
                      <xsl:if test="$textAnchor = 'end'">
                        <xsl:value-of select="($textWidth - ((dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize))))"/>
                      </xsl:if>
                    </xsl:variable>
                    <xsl:if test="$text_decoration_underline = 'underline'">
                    <xsl:call-template name="createFontStyleLineEffectSpan">
                      <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                      <xsl:with-param name="tspanY" select="$tspanY"/>
                      <xsl:with-param name="text_decoration" select="'underline'"/>
                      <xsl:with-param name="lineHeight" select="$lineHeight"/>
                      <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                      <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                      <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                      <xsl:with-param name="spaceString" select="'&#160;'"/>
                      <xsl:with-param name="fontFamily" select="$fontFamily"/>
                      <xsl:with-param name="fontWeight" select="$fontWeight"/>
                      <xsl:with-param name="fontStyle" select="$fontStyle"/>
                      <xsl:with-param name="fontSize" select="$fontSize"/>
                      <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                      <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                      <xsl:with-param name="currencySign" select="$currencySign"/>
                      <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                    </xsl:call-template>
                  </xsl:if>
                  <xsl:if test="$text_decoration_overline = 'overline'">
                    <xsl:call-template name="createFontStyleLineEffectSpan">
                      <xsl:with-param name="tspanX" select="$tspanX + $horizontalAlignOffset"/>
                      <xsl:with-param name="tspanY" select="$tspanY"/>
                      <xsl:with-param name="text_decoration" select="'overline'"/>
                      <xsl:with-param name="lineHeight" select="$lineHeight"/>
                      <xsl:with-param name="style" select="'stroke:rgb(0,0,0);'"/>
                      <xsl:with-param name="textWidth" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                      <xsl:with-param name="counter" select="(dgext:getTextWidth(substring($currencyfiedString, 1, 1), $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))) + (dgext:getTextWidth(substring-after($currencyfiedString, $currencySign), $fontFamily, $fontWeight, $fontStyle, $fontSize))"/>
                      <xsl:with-param name="spaceString" select="'&#160;'"/>
                      <xsl:with-param name="fontFamily" select="$fontFamily"/>
                      <xsl:with-param name="fontWeight" select="$fontWeight"/>
                      <xsl:with-param name="fontStyle" select="$fontStyle"/>
                      <xsl:with-param name="fontSize" select="$fontSize"/>
                      <xsl:with-param name="currencyFormat" select="$currencyFormat"/>
                      <xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
                      <xsl:with-param name="currencySign" select="$currencySign"/>
                      <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
                    </xsl:call-template>
                  </xsl:if>
                    <xsl:element name="svg:tspan">
                      <xsl:attribute name="x">
                        <xsl:value-of select="$tspanX + $horizontalAlignOffset"/>
                      </xsl:attribute>
                      <xsl:attribute name="y">
                        <xsl:value-of select="$tspanY - ($fontSize div 2.5)"/>
                      </xsl:attribute>
                      <xsl:attribute name="dy">
                        <xsl:value-of select="- $fontSize div 2.5"/>
                      </xsl:attribute>
                      <xsl:attribute name="style">
                        <xsl:value-of select="concat('font-size: ',($fontSize div 1.8),'px;')"/>
                      </xsl:attribute>
                      <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                        <xsl:attribute name="text-decoration">
                          <xsl:value-of select="'line-through'"/>
                        </xsl:attribute>
                      </xsl:if>                      
                      <xsl:value-of select="substring($currencyfiedString, 1, 1)"/>
                    </xsl:element>
                    <xsl:element name="svg:tspan">
                      <xsl:attribute name="x">
                        <xsl:value-of select="$tspanX + $horizontalAlignOffset + dgext:getTextWidth($currencySign, $fontFamily, $fontWeight, $fontStyle, ($fontSize div 1.8))"/>
                      </xsl:attribute>
                      <xsl:attribute name="y">
                        <xsl:value-of select="$tspanY"/>
                      </xsl:attribute>
                      <xsl:if test="$text_decoration_strikethrough = 'strikethrough'">
                        <xsl:attribute name="text-decoration">
                          <xsl:value-of select="'line-through'"/>
                        </xsl:attribute>
                      </xsl:if>                      
                      <xsl:value-of select="substring-after($currencyfiedString, $currencySign)"/>
                    </xsl:element>
                  </xsl:otherwise>
                </xsl:choose>
              </xsl:otherwise>
            </xsl:choose>
          </xsl:otherwise>
          <!-- Format 5 only for  USA $ and format4 for all others ends-->
          <!-- Format 2 USA ends -->
        </xsl:choose>
      </xsl:when>
    </xsl:choose>
  </xsl:template>
  <xsl:template name="createFontStyleLineEffectSpan">
    <xsl:param name="tspanX"/>
    <xsl:param name="tspanY"/>
    <xsl:param name="text_decoration"/>
    <xsl:param name="lineHeight"/>
    <xsl:param name="style"/>
    <xsl:param name="textWidth"/>
    <xsl:param name="counter"/>
    <xsl:param name="spaceString"/>
    <xsl:param name="fontFamily"/>
    <xsl:param name="fontWeight"/>
    <xsl:param name="fontStyle"/>
    <xsl:param name="fontSize"/>
    <xsl:param name="currencyFormat"/>
    <xsl:param name="currencyFormatType"/>
    <xsl:param name="currencySign"/>
    <xsl:param name="isNoCurrenctFormat2SpecialCondition"/>    
    <xsl:variable name="updatedYvalue">
      <xsl:choose>
        <xsl:when test="$currencyFormat = 'usa' and $currencySign = '$' and ($currencyFormatType = '3' or $currencyFormatType = '5')">
          <xsl:value-of  select="$tspanY + 4"/>
        </xsl:when>
        <xsl:when test="$currencyFormat != '' and $currencySign = '£' and ($currencyFormatType = '3')">
          <xsl:value-of  select="$tspanY + 4"/>
        </xsl:when>
        <xsl:when test="$currencyFormat != '' and $currencySign = '￥' and ($currencyFormatType = '3')">
          <xsl:value-of  select="$tspanY + 4"/>
        </xsl:when>
        <xsl:when test="$currencyFormat != '' and $currencySign = '￥' and ($currencyFormatType = '3')">
          <xsl:value-of  select="$tspanY + 4"/>
        </xsl:when>   
        <xsl:when test="$currencyFormat != '' and $currencySign = '￦' and ($currencyFormatType = '3')">
          <xsl:value-of  select="$tspanY + 4"/>
        </xsl:when>       
        <xsl:when test="$currencyFormat != '' and $currencySign = '€' and ($currencyFormatType = '1' or $currencyFormatType = '3')">
          <xsl:value-of  select="$tspanY + 4"/>
        </xsl:when>        
        <xsl:when test="$currencyFormat != '' and $currencySign = '₹' and ($currencyFormatType = '3')">
          <xsl:value-of  select="$tspanY + 4"/>
        </xsl:when>        
        <xsl:when test="$currencyFormat != '' and $currencySign = '₫' and ($currencyFormatType = '1' or $currencyFormatType = '3')">
          <xsl:value-of  select="$tspanY + 4"/>
        </xsl:when>     
        <xsl:when test="$currencyFormat != '' and $currencySign = '₺' and ($currencyFormatType = '1' or $currencyFormatType = '3')">
          <xsl:value-of  select="$tspanY + 4"/>
        </xsl:when>   
        <xsl:when test="$currencyFormat = 'euro' and $currencySign = '$' and ($currencyFormatType = '1' or $currencyFormatType = '3')">
          <xsl:value-of  select="$tspanY + 4"/>
        </xsl:when>  
        <xsl:when test="$currencyFormat = '' and $currencySign = '' and $currencyFormatType != ''">
          <xsl:value-of  select="$tspanY + 4"/>
        </xsl:when>  
        <xsl:when test="$currencyFormat = 'usa' and $currencySign = '&#160;' and $currencyFormatType != '2'">
          <xsl:value-of  select="$tspanY + 4"/>
        </xsl:when>  
        <xsl:when test="$text_decoration = 'overline' and $currencyFormat = '' and $currencySign = '' and $currencyFormatType = ''">
          <xsl:value-of  select="$tspanY + 4"/>
        </xsl:when> 
        <xsl:when test="$text_decoration = 'overline' and $currencyFormat = 'euro' and $currencySign = '&#160;' and ($currencyFormatType = '1' or $currencyFormatType = '8' or $currencyFormatType = '9' )">
          <xsl:value-of  select="$tspanY + 4"/>
        </xsl:when>
        <xsl:when test="$isNoCurrenctFormat2SpecialCondition = 'true'">
          <xsl:value-of  select="$tspanY + 4"/>
        </xsl:when>  
        <xsl:otherwise>
          <xsl:value-of  select="$tspanY - 3"/>
        </xsl:otherwise>
      </xsl:choose>
    </xsl:variable>
    <xsl:element name="svg:tspan">
      <xsl:attribute name="x">
        <xsl:value-of select="$tspanX"/>
      </xsl:attribute>
      <xsl:attribute name="y">
        <xsl:if test="$text_decoration = 'underline'">
          <xsl:value-of select="$tspanY"/>
        </xsl:if>
        <xsl:if test="$text_decoration = 'overline'">
          <xsl:value-of select="$updatedYvalue - $lineHeight"/>
        </xsl:if>
      </xsl:attribute>
      <xsl:attribute name="text-decoration">
        <xsl:value-of select="'underline'"/>
      </xsl:attribute>
      <xsl:attribute name="style">
        <xsl:value-of select="'stroke-width: 1;'"/>
      </xsl:attribute>
      <xsl:call-template name="generateSpaces">
        <xsl:with-param name="textWidth" select="$textWidth"/>
        <xsl:with-param name="counter" select="$counter"/>
        <xsl:with-param name="spaceString" select="'&#160;'"/>
        <xsl:with-param name="fontFamily" select="$fontFamily"/>
        <xsl:with-param name="fontWeight" select="$fontWeight"/>
        <xsl:with-param name="fontStyle" select="$fontStyle"/>
        <xsl:with-param name="fontSize" select="$fontSize"/>
      </xsl:call-template>
    </xsl:element>
  </xsl:template>
  <xsl:template name="generateSpaces">
    <xsl:param name="textWidth"/>
    <xsl:param name="counter"/>
    <xsl:param name="spaceString"/>
    <xsl:param name="fontFamily"/>
    <xsl:param name="fontWeight"/>
    <xsl:param name="fontStyle"/>
    <xsl:param name="fontSize"/>
    <xsl:if test="$counter &gt; 0 and (dgext:getTextWidth($spaceString, $fontFamily, $fontWeight, $fontStyle, $fontSize)) &lt; $textWidth">
      <xsl:call-template name="generateSpaces">
        <xsl:with-param name="textWidth" select="$textWidth"/>
        <xsl:with-param name="counter" select="$counter - 1"/>
        <xsl:with-param name="spaceString" select="concat($spaceString,'&#160;')"/>
        <xsl:with-param name="fontFamily" select="$fontFamily"/>
        <xsl:with-param name="fontWeight" select="$fontWeight"/>
        <xsl:with-param name="fontStyle" select="$fontStyle"/>
        <xsl:with-param name="fontSize" select="$fontSize"/>
      </xsl:call-template>
    </xsl:if>
    <xsl:if test="$counter = 0 or (dgext:getTextWidth($spaceString, $fontFamily, $fontWeight, $fontStyle, $fontSize)) &gt; $textWidth  or (dgext:getTextWidth($spaceString, $fontFamily, $fontWeight, $fontStyle, $fontSize)) = $textWidth">
      <xsl:value-of select="$spaceString"/>
    </xsl:if>
  </xsl:template>
  <xsl:template name="slice_text">
	<xsl:param name="textField"/>
	<xsl:param name="position"/>
	<xsl:param name="finalText"/>
	<xsl:param name="fontFamily"/>
	<xsl:param name="fontWeight"/>
	<xsl:param name="fontStyle"/>
	<xsl:param name="fontSize"/>
	<xsl:param name="textWidth"/>
  <xsl:choose> 
  <xsl:when test="$textWidth >= dgext:getTextWidth($textField, $fontFamily , $fontWeight , $fontStyle, $fontSize)">
  <xsl:value-of select="$textField"/>
  </xsl:when>
		<xsl:when test="dgext:getTextWidth(concat($finalText,'V'), $fontFamily , $fontWeight , $fontStyle, $fontSize) >= $textWidth  and ($finalText != '')">
			<xsl:value-of select="$finalText"/>
		</xsl:when>
		<xsl:otherwise>
			<xsl:call-template name="slice_text">
				<xsl:with-param name="textField" select="$textField"/>
				<xsl:with-param name="position" select="$position +1"/>
				<xsl:with-param name="finalText" select="substring($textField, 0, $position +1)"/>
				<xsl:with-param name="fontFamily" select="$fontFamily"/>
				<xsl:with-param name="fontWeight" select="$fontWeight"/>
				<xsl:with-param name="fontStyle" select="$fontStyle"/>
				<xsl:with-param name="fontSize" select="$fontSize"/>
				<xsl:with-param name="textWidth" select="$textWidth"/>
			</xsl:call-template>
		</xsl:otherwise>
	</xsl:choose>
</xsl:template>
  <xsl:template name="fit_text">
		<xsl:param name="productFieldValue"/>
		<xsl:param name="textAnchor"/>
		<xsl:param name="textWidth"/>
		<xsl:param name="textHeight"/>
		<xsl:param name="lineHeight"/>
		<xsl:param name="textLineHeight"/>
		<xsl:param name="fontFamily"/>
		<xsl:param name="fontStyle"/>
		<xsl:param name="fontWeight"/>
		<xsl:param name="fontSize"/>
		<xsl:param name="tspanX"/>
		<xsl:param name="tspanY"/>
		<xsl:param name="currencySign"/>
		<xsl:param name="currencyPosition"/>
		<xsl:param name="currencyFormat"/>
		<xsl:param name="currencyFormatType"/>
		<xsl:param name="currencyCode"/>
		<xsl:param name="xmlSpace" />
		<xsl:param name="style"/>
		<xsl:param name="textRendering"/>
    <xsl:param name="textVertAlign"/>
    <xsl:param name="zeroformatEnabled"/>
    <xsl:param name="text_decoration_overline"/>
		<xsl:param name="text_decoration_underline"/>
    <xsl:param name="text_decoration_strikethrough"/>
    <xsl:param name="textFitMin"/>
    <xsl:param name="textFitMax"/>
		<xsl:variable name="commaValidation">
			<xsl:value-of select="translate($productFieldValue, ',', '.')"/>
		</xsl:variable>
		<xsl:variable name="currencyfiedString">
			<xsl:choose>
				<xsl:when test="number($productFieldValue) = $productFieldValue">
					<xsl:call-template name="addCurrencySign">
						<xsl:with-param name="productFieldValue" select="$commaValidation"/>
						<xsl:with-param name="currencySign" select="$currencySign"/>
						<xsl:with-param name="currencyPosition" select="$currencyPosition"/>
						<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
						<xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
						<xsl:with-param name="currencyCode" select="$currencyCode"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:when test="number($commaValidation) = $commaValidation">
					<xsl:call-template name="addCurrencySign">
						<xsl:with-param name="productFieldValue" select="$commaValidation"/>
						<xsl:with-param name="currencySign" select="$currencySign"/>
						<xsl:with-param name="currencyPosition" select="$currencyPosition"/>
						<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
            <xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
            <xsl:with-param name="currencyCode" select="$currencyCode"/>
					</xsl:call-template>
				</xsl:when>
				<xsl:otherwise>
					<xsl:value-of select="$productFieldValue"/>
				</xsl:otherwise>
			</xsl:choose>
		</xsl:variable>
		<xsl:choose>
			<xsl:when test="(dgext:getTextWidth($currencyfiedString, $fontFamily , $fontWeight , $fontStyle, number($fontSize)) &gt;= $textWidth) or (dgext:getTextWidth($currencyfiedString, $fontFamily , $fontWeight , $fontStyle, number($fontSize)) &lt; $textWidth)">
        <xsl:variable name="new_font_size_withoutMinMaxCheck">
          <xsl:value-of select="floor($fontSize * $textWidth div (dgext:getTextWidth($currencyfiedString, $fontFamily , $fontWeight , $fontStyle, number($fontSize)) + 1))"/>
        </xsl:variable>
        <xsl:variable name="new_font_size">
          <xsl:choose>
            <xsl:when test="($textFitMin != '') and ($new_font_size_withoutMinMaxCheck &lt; $textFitMin)">
              <xsl:value-of select="$textFitMin"/>
            </xsl:when>
            <xsl:when test="($textFitMax != '') and ($new_font_size_withoutMinMaxCheck &gt; $textFitMax)">
              <xsl:value-of select="$textFitMax"/>
            </xsl:when>
            <xsl:otherwise>
              <xsl:value-of select="$new_font_size_withoutMinMaxCheck"/>
            </xsl:otherwise>
          </xsl:choose>
        </xsl:variable>
        <xsl:variable name="font_reduction_ratio">
					<xsl:value-of select="$fontSize div $new_font_size"/>
				</xsl:variable>
        <xsl:variable name="verticalAlignOffset">
          <xsl:if test="$textVertAlign = 'middle'">
            <xsl:value-of select="(($textHeight - (($lineHeight div $font_reduction_ratio) * 1)) div 2) + ((($lineHeight div $font_reduction_ratio) - ($textLineHeight div $font_reduction_ratio)) div 2)"/>
          </xsl:if>
          <xsl:if test="$textVertAlign = 'bottom'">
            <xsl:value-of select="(($textHeight - ($lineHeight div $font_reduction_ratio) * 1)) + ((($lineHeight div $font_reduction_ratio) - ($textLineHeight div $font_reduction_ratio)) div 2)"/>
          </xsl:if>
          <xsl:if test="$textVertAlign = 'top'">
            <xsl:value-of select="0"/>
          </xsl:if>
        </xsl:variable>
				<xsl:element name="svg:text">
					<xsl:attribute name="xml:space">
						<xsl:value-of select="string($xmlSpace)"/>
					</xsl:attribute>
					<xsl:attribute name="font-size">
						<xsl:value-of select="$new_font_size"/>
          </xsl:attribute>
          <xsl:attribute name="font-style">
				    <xsl:choose>
				      <xsl:when test="$fontStyle = 0.20f">
				        <xsl:value-of  select="'italic'"/>
				      </xsl:when>
				      <xsl:otherwise>
				        <xsl:value-of  select="'normal'"/>
				      </xsl:otherwise>
			      </xsl:choose>
          </xsl:attribute>
          <xsl:attribute name="font-weight">
				    <xsl:choose>
				      <xsl:when test="$fontWeight = 2.0f">
				        <xsl:value-of  select="'bold'"/>
				      </xsl:when>
				      <xsl:otherwise>
				        <xsl:value-of  select="'normal'"/>
				      </xsl:otherwise>
				    </xsl:choose>
				  </xsl:attribute>
					<xsl:attribute name="font-family">
						<xsl:value-of select="$fontFamily"/>
          </xsl:attribute>
					<xsl:attribute name="style">
						<xsl:value-of select="string($style)"/>
					</xsl:attribute>
					<xsl:attribute name="text-rendering">
						<xsl:value-of select="$textRendering"/>
					</xsl:attribute>
					<xsl:choose>
						<xsl:when test="not($currencyFormatType ='')">
							<xsl:call-template name="additionalCurrencyFormatting">
								<xsl:with-param name="currencyfiedString" select="$currencyfiedString"/>
								<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
								<xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
								<xsl:with-param name="currencySign" select="$currencySign"/>
								<xsl:with-param name="textAnchor" select="$textAnchor"/>
								<xsl:with-param name="textWidth" select="$textWidth"/>
								<xsl:with-param name="fontFamily" select="$fontFamily"/>
								<xsl:with-param name="fontStyle" select="$fontStyle"/>
								<xsl:with-param name="fontSize" select="$new_font_size"/>
								<xsl:with-param name="fontWeight" select="$fontWeight"/>
								<xsl:with-param name="lineHeight" select="($new_font_size * 1.13) + 4"/>
								<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
								<xsl:with-param name="noOfLine" select="0"/>
								<xsl:with-param name="tspanX" select="$tspanX"/>
								<xsl:with-param name="tspanY" select="(-($textHeight div 2) + (($new_font_size * ($lineHeight div $textLineHeight) * 1.13) * ((1 - 0.222) div ($lineHeight div $textLineHeight)))) + $verticalAlignOffset"/>
								<xsl:with-param name="text_decoration_overline" select="$text_decoration_overline"/>
                <xsl:with-param name="text_decoration_underline" select="$text_decoration_underline"/>
                <xsl:with-param name="text_decoration_strikethrough" select="$text_decoration_strikethrough"/>
								<xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
							</xsl:call-template>
						</xsl:when>
						<xsl:otherwise>
							<xsl:element name="svg:tspan">
								<xsl:attribute name="text-anchor">
									<xsl:value-of select="$textAnchor"/>
								</xsl:attribute>
								<xsl:attribute name="x">
									<xsl:value-of select="$tspanX"/>
								</xsl:attribute>
								<xsl:attribute name="y">
									<xsl:value-of select="(-($textHeight div 2) + (($new_font_size * ($lineHeight div $textLineHeight) * 1.13) * ((1 - 0.222) div ($lineHeight div $textLineHeight)))) + $verticalAlignOffset"/>
								</xsl:attribute>
								<xsl:attribute name="style">
									<xsl:value-of select="'white-space: pre'"/>
                </xsl:attribute>
                <xsl:if test="$text_decoration_strikethrough = 'strikethrough' and $text_decoration_overline = 'overline' and $text_decoration_underline = 'underline'">
							    <xsl:attribute name="text-decoration">
							      <xsl:value-of select="'overline underline line-through'"/>
							    </xsl:attribute>
							  </xsl:if>
							  <xsl:if test="$text_decoration_strikethrough != 'strikethrough' and $text_decoration_overline = 'overline' and $text_decoration_underline = 'underline'">
							    <xsl:attribute name="text-decoration">
							      <xsl:value-of select="'overline underline'"/>
							    </xsl:attribute>
							  </xsl:if>
							  <xsl:if test="$text_decoration_strikethrough = 'strikethrough' and $text_decoration_overline = '!overline' and $text_decoration_underline = 'underline'">
							    <xsl:attribute name="text-decoration">
							      <xsl:value-of select="'underline line-through'"/>
							    </xsl:attribute>
							  </xsl:if>
							  <xsl:if test="$text_decoration_strikethrough = 'strikethrough' and $text_decoration_overline = 'overline' and $text_decoration_underline != 'underline'">
							    <xsl:attribute name="text-decoration">
							      <xsl:value-of select="'overline line-through'"/>
							    </xsl:attribute>
							  </xsl:if>
							  <xsl:if test="$text_decoration_strikethrough = 'strikethrough' and $text_decoration_overline != 'overline' and $text_decoration_underline != 'underline'">
							    <xsl:attribute name="text-decoration">
							      <xsl:value-of select="'line-through'"/>
							    </xsl:attribute>
							  </xsl:if>
							  <xsl:if test="$text_decoration_strikethrough != 'strikethrough' and $text_decoration_overline = 'overline' and $text_decoration_underline != 'underline'">
							    <xsl:attribute name="text-decoration">
							      <xsl:value-of select="'overline'"/>
							    </xsl:attribute>
							  </xsl:if>
							  <xsl:if test="$text_decoration_strikethrough != 'strikethrough' and $text_decoration_overline != 'overline' and $text_decoration_underline = 'underline'">
							    <xsl:attribute name="text-decoration">
							      <xsl:value-of select="'underline'"/>
							    </xsl:attribute>
							  </xsl:if>
								<xsl:value-of select="$currencyfiedString"/>
							</xsl:element>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:element>
      </xsl:when>      
			<xsl:otherwise>
        <xsl:variable name="verticalAlignOffset">
          <xsl:if test="$textVertAlign = 'middle'">
            <xsl:value-of select="(($textHeight - ($lineHeight * 1)) div 2) + (($lineHeight - $textLineHeight) div 2)"/>
          </xsl:if>
          <xsl:if test="$textVertAlign = 'bottom'">
            <xsl:value-of select="(($textHeight - $lineHeight * 1)) + (($lineHeight - $textLineHeight) div 2)"/>
          </xsl:if>
          <xsl:if test="$textVertAlign = 'top'">
            <xsl:value-of select="0"/>
          </xsl:if>
      </xsl:variable>
				<xsl:element name="svg:text">
					<xsl:attribute name="xml:space">
						<xsl:value-of select="string($xmlSpace)"/>
					</xsl:attribute>
					<xsl:attribute name="font-size">
						<xsl:value-of select="$fontSize"/>
          </xsl:attribute>
          <xsl:attribute name="font-style">
				    <xsl:choose>
				      <xsl:when test="$fontStyle = 0.20f">
				        <xsl:value-of  select="'italic'"/>
				      </xsl:when>
				      <xsl:otherwise>
				        <xsl:value-of  select="'normal'"/>
				      </xsl:otherwise>
			      </xsl:choose>
          </xsl:attribute>
          <xsl:attribute name="font-weight">
				    <xsl:choose>
				      <xsl:when test="$fontWeight = 2.0f">
				        <xsl:value-of  select="'bold'"/>
				      </xsl:when>
				      <xsl:otherwise>
				        <xsl:value-of  select="'normal'"/>
				      </xsl:otherwise>
				    </xsl:choose>
				  </xsl:attribute>
					<xsl:attribute name="font-family">
						<xsl:value-of select="$fontFamily"/>
          </xsl:attribute>
					<xsl:attribute name="style">
						<xsl:value-of select="string($style)"/>
					</xsl:attribute>
					<xsl:attribute name="text-rendering">
						<xsl:value-of select="$textRendering"/>
					</xsl:attribute>
					<xsl:choose>
						<xsl:when test="not($currencyFormatType ='')">
							<xsl:call-template name="additionalCurrencyFormatting">
								<xsl:with-param name="currencyfiedString" select="$currencyfiedString"/>
								<xsl:with-param name="currencyFormat" select="$currencyFormat"/>
								<xsl:with-param name="currencyFormatType" select="$currencyFormatType"/>
								<xsl:with-param name="currencySign" select="$currencySign"/>
								<xsl:with-param name="textAnchor" select="$textAnchor"/>
								<xsl:with-param name="textWidth" select="$textWidth"/>
								<xsl:with-param name="fontFamily" select="$fontFamily"/>
								<xsl:with-param name="fontStyle" select="$fontStyle"/>
								<xsl:with-param name="fontSize" select="$fontSize"/>
								<xsl:with-param name="fontWeight" select="$fontWeight"/>
								<xsl:with-param name="lineHeight" select="$lineHeight"/>
								<xsl:with-param name="textLineHeight" select="$textLineHeight"/>
								<xsl:with-param name="noOfLine" select="0"/>
								<xsl:with-param name="tspanX" select="$tspanX"/>
								<xsl:with-param name="tspanY" select="$tspanY"/>
								<xsl:with-param name="text_decoration_overline" select="$text_decoration_overline"/>
                <xsl:with-param name="text_decoration_underline" select="$text_decoration_underline"/>
                <xsl:with-param name="text_decoration_strikethrough" select="$text_decoration_strikethrough"/>
								<xsl:with-param name="zeroformatEnabled" select="$zeroformatEnabled"/>
							</xsl:call-template>
						</xsl:when>
						<xsl:otherwise>
							<xsl:element name="svg:tspan">
								<xsl:attribute name="text-anchor">
									<xsl:value-of select="$textAnchor"/>
								</xsl:attribute>
								<xsl:attribute name="x">
									<xsl:value-of select="$tspanX"/>
								</xsl:attribute>
								<xsl:attribute name="y">
									<xsl:value-of select="$tspanY"/>
								</xsl:attribute>
							  <xsl:if test="$text_decoration_strikethrough = 'strikethrough' and $text_decoration_overline = 'overline' and $text_decoration_underline = 'underline'">
							    <xsl:attribute name="text-decoration">
							      <xsl:value-of select="'overline underline line-through'"/>
							    </xsl:attribute>
							  </xsl:if>
							  <xsl:if test="$text_decoration_strikethrough != 'strikethrough' and $text_decoration_overline = 'overline' and $text_decoration_underline = 'underline'">
							    <xsl:attribute name="text-decoration">
							      <xsl:value-of select="'overline underline'"/>
							    </xsl:attribute>
							  </xsl:if>
							  <xsl:if test="$text_decoration_strikethrough = 'strikethrough' and $text_decoration_overline = '!overline' and $text_decoration_underline = 'underline'">
							    <xsl:attribute name="text-decoration">
							      <xsl:value-of select="'underline line-through'"/>
							    </xsl:attribute>
							  </xsl:if>
							  <xsl:if test="$text_decoration_strikethrough = 'strikethrough' and $text_decoration_overline = 'overline' and $text_decoration_underline != 'underline'">
							    <xsl:attribute name="text-decoration">
							      <xsl:value-of select="'overline line-through'"/>
							    </xsl:attribute>
							  </xsl:if>
							  <xsl:if test="$text_decoration_strikethrough = 'strikethrough' and $text_decoration_overline != 'overline' and $text_decoration_underline != 'underline'">
							    <xsl:attribute name="text-decoration">
							      <xsl:value-of select="'line-through'"/>
							    </xsl:attribute>
							  </xsl:if>
							  <xsl:if test="$text_decoration_strikethrough != 'strikethrough' and $text_decoration_overline = 'overline' and $text_decoration_underline != 'underline'">
							    <xsl:attribute name="text-decoration">
							      <xsl:value-of select="'overline'"/>
							    </xsl:attribute>
							  </xsl:if>
							  <xsl:if test="$text_decoration_strikethrough != 'strikethrough' and $text_decoration_overline != 'overline' and $text_decoration_underline = 'underline'">
							    <xsl:attribute name="text-decoration">
							      <xsl:value-of select="'underline'"/>
							    </xsl:attribute>
							  </xsl:if>
								<xsl:value-of select="$currencyfiedString"/>
							</xsl:element>
						</xsl:otherwise>
					</xsl:choose>
				</xsl:element>
			</xsl:otherwise>
		</xsl:choose>
	</xsl:template>
</xsl:stylesheet>