package com.solum.aims.msp.util;

import java.awt.Color;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class ESLPdfTable {
	PDDocument doc = null;
	PDPageContentStream currentStream = null;
	
	private float startX;
	private float startY;
	
	private float tableWidth;
	private float tableHeight;
	
	private List<String> columnName;
	private List<String> columnKey;
	private List<Float> columnWidth;
	
	private float cellMarginX = 3f;
	private float cellMarginY = 2f;
	
	private PDFont font;
	private int fontSize;
	private float fontMargin = 1.2f;
	
	private static final Logger logger = LoggerFactory.getLogger(ESLPdfTable.class);

	public ESLPdfTable() {
	}
	
	public ESLPdfTable(PDDocument document) {
		this.doc = document;
	}
	
	public void setDoc(PDDocument doc) {
		this.doc = doc;
	}
	
	public void setTableArea(float width, float height){
		this.tableWidth = width;
		this.tableHeight = height;
	}
	
	public void setCellMargins(float marginX, float marginY){
		cellMarginX = marginX;
		cellMarginY = marginY;
	}

	public void setColumnName(String[] colname){
		this.columnName = new ArrayList<>();
		Collections.addAll(this.columnName, colname);
	}

	public void setColumnKey(String[] colkey){
		this.columnKey = new ArrayList<>();
		Collections.addAll(this.columnKey, colkey);
	}

	public void setColWidth(float[] columnWidth){
		this.columnWidth = new ArrayList<>();
		for (float v : columnWidth) {
			float tmp = this.tableWidth * 0.01f * v;
			this.columnWidth.add(tmp);
		}
	}

	// Table 시작 위치 지정
	public void setStartTableLocation(float x, float y){
		startX = x;
		startY = y;
	}

	public void setFont(PDFont font, int fontSize){
		this.font = font;
		this.fontSize = fontSize;
	}
	
	public int drawTable(float x, float y, List<Map<String, Object>> data, int pageNumber, boolean header) {
		setStartTableLocation(x, y);
		return drawTable(data, pageNumber, header);
	}

	public int drawTable(List<Map<String, Object>> data, int pageNumber, boolean tableheader) {
		int createPageCount = 1;
		float currentY = startY;
		float lastY = startY - tableHeight;
		try {
			PDPage currentPage = doc.getPage(pageNumber);
			this.currentStream = new PDPageContentStream(this.doc, currentPage, AppendMode.APPEND, false);
			this.currentStream.setFont(this.font, this.fontSize);

			if (tableheader) {
				currentY = drawTableHeader(this.startX, currentY);
			}
				
			if (!data.isEmpty()) {
				for (int row = 0; row < data.size(); row++ ) {
					currentY = drawRowData(startX, currentY, data.get(row), "center");
	
					if ( currentY - this.fontSize - cellMarginY < lastY) {
						drawVerticalLine(startX, startY, currentY);
						this.currentStream.close();

						if (row + 1 < data.size()) {
							newPage();
							currentY = startY;
							createPageCount++;
						}
					}
				}
			}
			drawVerticalLine(startX, startY, currentY);
			this.currentStream.close();
		} catch (IllegalStateException | IOException e) {
			logger.error("Fail draw Table - {}", e.getMessage());
		}
		
		return createPageCount;
	}
	
	public void newPage() {
		try {
			PDPage page = new PDPage(PDRectangle.A4);
			this.doc.addPage( page );

			this.currentStream = new PDPageContentStream(doc, page, AppendMode.APPEND, false);
			this.currentStream.setFont(font, fontSize);
		} catch (Exception e) {
			logger.error("Fail create table");
		}
	}
	
	@SuppressWarnings("deprecation")
	public float drawTableHeader(float x, float y) throws IOException, IllegalStateException {
		int headerStrLine = 1;

		if (this.columnName.isEmpty()) {
			return y;
		} else {
			for (int i = 0; i < this.columnName.size(); i++) {
				List<String> countOfRow = createMultiLine(this.columnName.get(i), this.columnWidth.get(i));
				
				if (headerStrLine < countOfRow.size()) {
					headerStrLine = countOfRow.size();
				}
			}
			float headerHeight = headerStrLine * this.fontSize* fontMargin + (2 * cellMarginY);
			
			this.currentStream.addRect(x, y - headerHeight, this.tableWidth, headerHeight);
			this.currentStream.setNonStrokingColor(Color.LIGHT_GRAY);
			this.currentStream.fill();
			this.currentStream.setNonStrokingColor(Color.BLACK);
			
			for (int i = 0; i < columnName.size(); i++) {
				String msg = this.columnName.get(i);
				drawCell(x, y - this.fontSize - cellMarginY, msg, columnWidth.get(i), "center");
				x += columnWidth.get(i);
			}
			this.currentStream.drawLine(startX, y - headerHeight, startX + tableWidth, y - headerHeight);
			
			return y - headerHeight;
		}
	}

	@SuppressWarnings("deprecation")
	public float drawRowData(float x, float y, Map<String, Object> rowData, String align) throws IOException, IllegalStateException {
		int cellLine = 1;
		float underLineY;

		y -= cellMarginY;
		
		for (int i = 0; i < columnWidth.size(); i++) {
			String msg = "";
			if (rowData.containsKey(this.columnKey.get(i))) {
				msg = rowData.get(this.columnKey.get(i)).toString();
			}

			int drawLine = drawCell(x, y - this.fontSize, msg, columnWidth.get(i), align);
			x += columnWidth.get(i);
			if ( cellLine < drawLine) {
				cellLine = drawLine;
			}
		}
		underLineY = y - cellLine * this.fontSize * fontMargin - cellMarginY;
		this.currentStream.drawLine(startX, underLineY, startX + tableWidth, underLineY);

		return underLineY;
	}

	public int drawCell(float x, float y, String text, float width, String align){
		List<String> ret = createMultiLine(text, width - (2 * cellMarginX));

		for (int i =0; i < ret.size(); i++) {
			drawStringInCell(x, y - fontSize*(i), width, ret.get(i), align);
		}
		
		return ret.size();
	}

	public List<String> createMultiLine(String text, float width){
		List<String> ret = new ArrayList<>();

		try {
			float strWidth = this.font.getStringWidth(text) / 1000 * fontSize;
			
			if ( strWidth <= width) {
				ret.add(text);
			} else {
				String[] spceSplit = text.split(" ");
	
				StringBuilder tmp = new StringBuilder();
				for (int line = 0; line < spceSplit.length; line++) {
					float wordWidth = font.getStringWidth(tmp + spceSplit[line]) / 1000 * this.fontSize;
					
					if (wordWidth < width) {
						tmp.append(spceSplit[line]).append(" ");
					} else {
						if (tmp.length()!=0 || line != 0){
							ret.add(tmp.toString().trim());
						}
						tmp = new StringBuilder(spceSplit[line]);
					}
				}
				ret.add(tmp.toString().trim());
			}
			
			if ((ret.size() == 1) && (strWidth > (width))) {
				ret.clear();
				String tmp = "";
				int index = 0;
				for (int i = 1; i <= text.length(); i++) {
					tmp = text.substring(index, i);
					float wordWidth = font.getStringWidth(tmp) / 1000 * this.fontSize;
					if (wordWidth > width) {
						index = i - 1;
						ret.add(tmp.substring(0, tmp.length() - 1));
						tmp =tmp.substring(tmp.length() - 1, tmp.length());
					}
				}
				if (tmp.length() != 0) {
					ret.add(tmp);
				}
			}
		} catch (Exception e) {
			logger.error("Fail create MultiLine {}", e.getMessage());
		}

		return ret;
	}
	
	public void drawStringInCell(float x, float y, float width, String text, String align){
		try {
			this.currentStream.beginText();
			
			if ("center".equals(align) == true) {
				float strWidth = font.getStringWidth(text) / 1000 * this.fontSize;
				this.currentStream.newLineAtOffset( x + (width - strWidth) / 2, y);
			} else if ("right".equals(align) == true) {
				float strWidth = font.getStringWidth(text) / 1000 * this.fontSize;
				this.currentStream.newLineAtOffset((x + width - strWidth - cellMarginX), y);
			} else {
				this.currentStream.newLineAtOffset(x + cellMarginX, y);
			}
			
			this.currentStream.showText(text);
			this.currentStream.endText();
		} catch (Exception e) {
			logger.error("Fail drawStringInCell {}", e.getMessage());
		}
	}

	@SuppressWarnings("deprecation")
	public void drawVerticalLine(float startX, float startY, float currentY) throws IOException, IllegalStateException {
		float currentX = startX;
		
		this.currentStream.drawLine(startX, startY, startX + tableWidth, startY);
		this.currentStream.drawLine(startX, startY, startX, currentY);
		for (Float aFloat : columnWidth) {
			currentX += aFloat;
			this.currentStream.drawLine(currentX, startY, currentX, currentY);
		}
	}
}