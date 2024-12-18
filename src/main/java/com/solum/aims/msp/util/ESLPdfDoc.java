package com.solum.aims.msp.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.PDPageContentStream.AppendMode;
import org.apache.pdfbox.pdmodel.PDPageTree;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDFont;
import org.apache.pdfbox.pdmodel.font.PDType0Font;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import jakarta.servlet.http.HttpServletResponse;

@Component
public class ESLPdfDoc {
	@Value("${aims.dashboard.web.pdf.font.path}")
	private String fontPath;

	@Value("${aims.dashboard.web.pdf.font.mapping.file}")
	private String fontMappingFilename;

	@Value("${aims.dashboard.web.pdf.font.logo.file}")
	private String logoFile;

	@Value("${aims.dashboard.web.pdf.font.logo.size}")
	private float logoSize;

	@Value("${aims.dashboard.web.pdf.customer}")
	private String customer;

	PDDocument document;

	PDFont basicfont;
	int fontSize;

	private float marginX = 20;

	private float marginY = 20;

	private float underlineY = marginY + 33;

	private static final Logger logger = LoggerFactory.getLogger(ESLPdfDoc.class);

	public PDDocument newPDFDoc() {
		this.document = new PDDocument();
		return this.document;
	}


	public void setDefaultContryFont(String contry) {
		String fontFilename = null;
		
		String[] tmpPath = (new File("")).getAbsoluteFile().toString().split("AIMS");
		String tmpRootPath = tmpPath[0] + "/AIMS/bin/dashboardWeb/WEB-INF/classes";
		//String tmpRootPath="D:/AIMS/bin/dashboardWeb/WEB-INF/classes/font/fontmap.txt";
		try (BufferedReader mapfile = new BufferedReader(new FileReader(tmpRootPath + fontPath + fontMappingFilename))) {
			String line;
			
			while ((line = mapfile.readLine()) != null) {
				String[] tmp = line.split(":");
				if (contry.equals(tmp[0] + "_DATA"))
					fontFilename = tmp[1];
			}
		} catch (Exception e) {
			logger.error("Fail read font mapping file");
		}
		
		try {
			if (fontFilename != null) {
				basicfont = PDType0Font.load(this.document, new File(tmpRootPath + fontPath + fontFilename));
			} else {
				InputStream fontStream = new FileInputStream(tmpRootPath + "/font/ARIALUNI.ttf");
				basicfont = PDType0Font.load(this.document, fontStream);
			}
		} catch (Exception e) {
			logger.error("Fail set font : {}" , this.basicfont.getName());
		}
	}

	public void setFontSize(int size) {
		this.fontSize = size;
	}

	public PDPage newPage() {
		PDPage page = new PDPage(PDRectangle.A4);
		this.document.addPage(page);
		return page;
	}

	public int drawTable(float x, float y, float width, float height, Map<String, Object> data, boolean header) {
		int createPageCount = 1;
		
		ESLPdfTable table = new ESLPdfTable(this.document);
		
		table.setTableArea(width, height);
		table.setFont(this.basicfont, this.fontSize);
		if (header) {
			table.setColumnName((String[]) data.get("columnName"));
		}
		table.setColumnKey((String[]) data.get("columnKey"));
		table.setColWidth((float[]) data.get("columnWidth"));
		
		List<Map<String, Object>> tbody = (List<Map<String, Object>>) data.get("data");
		createPageCount = table.drawTable(x, y, tbody, Integer.parseInt(data.get("page").toString()), header);
		if (tbody.isEmpty()) {
			Map<String, Object> uiMsgMap = (Map<String, Object>) data.get("msgMap");
			
			try {
				float strWidth = basicfont.getStringWidth(uiMsgMap.get("M0016").toString()) / 1000 * this.fontSize;
				this.drawString(Integer.parseInt(data.get("page").toString()), (PDRectangle.A4.getWidth() - strWidth) / 2, y - 40, uiMsgMap.get("M0016").toString(), "center");
			} catch (Exception e) {
				logger.error("Fail Empty Query result string");
			}
		}
		return createPageCount;
	}

	public void drawPDFPageHeaderTail(PDDocument doc, boolean addHeader, boolean addTail, Map<String, Object> data) {
		int fontSize = 14;
		try {
			for (int i = 0; i < doc.getNumberOfPages(); i++) {
				PDPage page = doc.getPage(i);
				PDPageContentStream stream = new PDPageContentStream(doc, page, AppendMode.APPEND, false);
				if (addHeader) {
					drawPageHeader(data, stream);
				}
				
				if (addTail) {
					if (customer == null || "".equals(customer))
						customer = "";
					if ("METRO".equals(this.customer)) {
						//drawMetroTail(doc, stream, data);
					}
				}
				
				
				stream.addRect(marginX, underlineY, PDRectangle.A4.getWidth() - (2 * marginX), 2);
				
//				stream.addRect(85, 43, PDRectangle.A4.getWidth() - (2 * 85), 3);
				stream.fill();
				
				
				// Write Page Information
				String pageText = String.format("%d / %d", i + 1, doc.getNumberOfPages());
				stream.setFont(basicfont, fontSize);
				drawString(30, 130, "_____________________________________________________________________________________________________________", "left", stream);
//				stream.addRect(25, 55, PDRectangle.A4.getWidth() - (2 * 25), 2);
				drawString(30, 115, "Date Edited", "left", stream);
				drawString(30, 115, "Signature Dept. Head", "right", stream);
				drawString(230, 105, "Error Code", "left", stream);
				drawString(30, 90, "1. ESL No", "left", stream);
				drawString(230, 90, "4. ESL false indication info level", "left", stream);
				drawString(30, 75, "2. ESL no reception", "left", stream);
				drawString(230, 75, "5. Destroyed ESL", "left", stream);
				drawString(30, 60, "3. ESL with an incorrect price", "left", stream);
				drawString(230, 60, "6. Other", "left", stream);
		 		drawString(0f, underlineY - fontSize - 4, pageText, "center", stream);
		 		stream.close();
			}
		} catch (Exception e) {
			logger.error("Fail draw PDF Page {}", e.getMessage());
		}
	}
	
	
	public void drawPDFAllDeptPageHeaderTail(PDDocument doc, boolean addHeader, boolean addTail, Map<String, Object> data) {
		int fontSize = 14;
		try {
			for (int i = 0; i < doc.getNumberOfPages(); i++) {
				PDPage page = doc.getPage(i);
				PDPageContentStream stream = new PDPageContentStream(doc, page, AppendMode.APPEND, false);
				if (addHeader) {
					drawPageHeader(data, stream);
				}
				
				if (addTail) {
					if (customer == null || "".equals(customer))
						customer = "";
					if ("METRO".equals(this.customer)) {
						//drawMetroTail(doc, stream, data);
					}
				}
				
				
				stream.addRect(marginX, underlineY, PDRectangle.A4.getWidth() - (2 * marginX), 2);
				
//				stream.addRect(85, 43, PDRectangle.A4.getWidth() - (2 * 85), 3);
				stream.fill();
				
				
				// Write Page Information
				String pageText = String.format("%d / %d", i + 1, doc.getNumberOfPages());
				stream.setFont(basicfont, fontSize);
				drawString(30, 130, "_____________________________________________________________________________________________________________", "left", stream);
//				stream.addRect(25, 55, PDRectangle.A4.getWidth() - (2 * 25), 2);
				drawString(30, 115, "Date Edited", "left", stream);
				drawString(30, 115, "Signature Dept. Head", "right", stream);
				drawString(230, 105, "Error Code", "left", stream);
				drawString(30, 90, "1. ESL No", "left", stream);
				drawString(230, 90, "4. ESL false indication info level", "left", stream);
				drawString(30, 75, "2. ESL no reception", "left", stream);
				drawString(230, 75, "5. Destroyed ESL", "left", stream);
				drawString(30, 60, "3. ESL with an incorrect price", "left", stream);
				drawString(230, 60, "6. Other", "left", stream);
		 		//drawString(0f, underlineY - fontSize - 4, pageText, "center", stream);
		 		stream.close();
			}
		} catch (Exception e) {
			logger.error("Fail draw PDF Page {}", e.getMessage());
		}
	}
	
	public void drawCommonTail(PDDocument doc, PDPageContentStream stream, Map<String, Object> data) {
		try {
			float startX = marginX;
			float startY = underlineY + 5f;
			
			// Draw Tail Line
			stream.addRect(marginX, startY + 75f, PDRectangle.A4.getWidth() - (2 * marginX), 2);
			stream.fill();
			
			int fontSize = 9;
			stream.setFont( basicfont, fontSize );
			
			drawString(startX, startY + 60f, data.get("M0124").toString(), stream);
			drawString(startX, startY + 30f, "1. " + data.get("M0127").toString(), stream);
			drawString(startX, startY + 15f, "2. " + data.get("M0128").toString(), stream);
			drawString(startX, startY, "3. " + data.get("M0129").toString(), stream);
			
			drawString(startX+200f, startY + 45f, data.get("M0126").toString(), stream);
			drawString(startX+200f, startY + 30f, "4. " + data.get("M0130").toString(), stream);
			drawString(startX+200f, startY + 15f, "5. " + data.get("M0131").toString(), stream);
			drawString(startX+200f, startY, "6. " + data.get("M0132").toString(), stream);
			
			float strWidth = basicfont.getStringWidth(data.get("M0125").toString()) / 1000 * fontSize;
			drawString(PDRectangle.A4.getWidth() - strWidth - marginX, startY + 60f, data.get("M0125").toString(), stream);
		} catch (Exception e) {
			logger.error("Fail drawMetroTail Exception: {}" , e.getMessage());
		}
	}

	public void drawPageHeader(Map<String, Object> data, PDPageContentStream stream) {
		float scale = logoSize / 100;
		int fontSize = 25;
		try {
			float y = PDRectangle.A4.getHeight();
			
			if (logoFile != null && !"".equals(logoFile.trim())) {
				String[] tmpPath = (new File("")).getAbsoluteFile().toString().split("AIMS");
				String tmpRootPath = tmpPath[0] + "/AIMS/bin/dashboardWeb/WEB-INF/classes";
//				String tmpRootPath="E:/DashwebWithoutFormatting/aims-dashboard-service/src/main/resources";
				//String tmpRootPath="D:/AIMS/bin/dashboardWeb/WEB-INF/classes";
				PDImageXObject pdImage = PDImageXObject.createFromFile(tmpRootPath + logoFile, this.document);
				
				float width = pdImage.getWidth() * scale;
				float height = pdImage.getHeight() * scale;
				y = y - height - 10;
	
				stream.drawImage(pdImage, marginX, y, width, height);
			} else {
				y -= 40;
			}
			int tmp = this.fontSize;
			this.fontSize = 25;
			drawString(0, y - fontSize, data.get("title").toString(), "center", stream);
			this.fontSize = tmp;
			
			if (customer == null || ("").equals(customer)) {
				customer = "";
			}
			if ("METRO".equals(customer)) {
				drawMetroPageHeader(marginX, y - fontSize, data, stream);
			} else {
				drawCommonPageHeader(marginX, y - fontSize, data, stream);
			}
		} catch (IOException e) {
			logger.error("Fail drawPageHeader IOException: {}", e.getMessage());
		}
	}

	public void drawCommonPageHeader(float x, float y, Map<String, Object> data, PDPageContentStream stream) throws IOException {
		int fontSize = 15;
		stream.setFont(this.basicfont, fontSize);

		y -= (fontSize * 2 + 3);
		long currentTime = System.currentTimeMillis();
    	SimpleDateFormat  dayTime = new SimpleDateFormat("dd.MM.yyyy - HH:mm");
    	String	strTime = dayTime.format(new Date(currentTime));
		drawString(0f, y, strTime, "right", stream);
	}
	
	public void drawMetroPageHeader(float x, float y, Map<String, Object> data, PDPageContentStream stream) throws IOException {
		int fontSize = 15;
		stream.setFont(this.basicfont, fontSize);
		float strWidth = 0f;

		y -= (fontSize * 2 + 3);
		drawString(marginX, y, data.get("store_name").toString(), "left", stream);

		try {
			strWidth = basicfont.getStringWidth(data.get("store_name").toString()) / 1000 * fontSize;
		} catch (IOException e) {
			logger.error("Fail drawMetroPageHeader IOException: {}", e.getMessage());
		}

		drawString(marginX + strWidth, y, data.get("MetroStorename").toString(), "left", stream);
		
		long currentTime = System.currentTimeMillis();
    	SimpleDateFormat  dayTime = new SimpleDateFormat("dd.MM.yyyy - HH:mm");
    	String	strTime = dayTime.format(new Date(currentTime));
		drawString(0f, y, strTime, "right", stream);
	}

	public void drawMetroTail(PDDocument doc, PDPageContentStream stream, Map<String, Object> data) {
		try {
			float startX = marginX;
			float startY = underlineY + 5f;
			
			// Draw Tail Line
			stream.addRect(marginX, startY + 75f, PDRectangle.A4.getWidth() - (2 * marginX), 2);
			stream.fill();
			
			int fontSize = 9;
			stream.setFont( basicfont, fontSize );
			
			drawString(startX, startY + 60f, data.get("M0124").toString(), stream);
			drawString(startX, startY + 30f, "1. " + data.get("M0127").toString(), stream);
			drawString(startX, startY + 15f, "2. " + data.get("M0128").toString(), stream);
			drawString(startX, startY, "3. " + data.get("M0129").toString(), stream);
			
			drawString(startX+200f, startY + 45f, data.get("M0126").toString(), stream);
			drawString(startX+200f, startY + 30f, "4. " + data.get("M0130").toString(), stream);
			drawString(startX+200f, startY + 15f, "5. " + data.get("M0131").toString(), stream);
			drawString(startX+200f, startY, "6. " + data.get("M0132").toString(), stream);
			
			float strWidth = basicfont.getStringWidth(data.get("M0125").toString()) / 1000 * fontSize;
			drawString(PDRectangle.A4.getWidth() - strWidth - marginX, startY + 60f, data.get("M0125").toString(), stream);
		} catch (Exception e) {
			logger.error("Fail drawMetroTail Exception: {}" , e.getMessage());
		}
	}

	public void drawString(int pageNum, float x, float y, String text, String align) {
		try {
			PDPageContentStream stream = new PDPageContentStream(this.document, this.document.getPage(pageNum), AppendMode.APPEND, false);
			stream.setFont(this.basicfont, this.fontSize);
			
			this.drawString(x, y, text, align, stream);
			stream.close();
		} catch (IOException e) {
			logger.error("Fail drawString IOException : {}" , text);
		}
	}

	public void drawString(float x, float y, String text, String align, PDPageContentStream stream) throws IOException {
		float width = PDRectangle.A4.getWidth();

		stream.beginText();
		stream.setFont(basicfont, fontSize);
		
		if ("center".equals(align) == true) {
			float strWidth = basicfont.getStringWidth(text) / 1000 * fontSize;
			stream.newLineAtOffset( (width - strWidth) / 2, y);
		} else if ("right".equals(align) == true) {
			float strWidth = basicfont.getStringWidth(text) / 1000 * fontSize;
			stream.newLineAtOffset( (width - strWidth - marginX), y);
		} else {
			stream.newLineAtOffset(x, y);
		}
		
		stream.showText(text);
 		stream.endText();
	}

	public void drawString(float x, float y, String text, PDPageContentStream stream) {
 		try {
	 		stream.beginText();
	 		stream.newLineAtOffset( x, y );
	 		stream.showText(text);
	 		stream.endText();
 		} catch (Exception e) {
 			logger.error("Fail drawString Exception : {}" , text);
 		}
 	}
	
	public void addPageNumbersToMergedPDF(PDDocument mergedDoc, int totalPageCount) {
	    try {
	        PDType1Font font = PDType1Font.HELVETICA_BOLD;
	        int fontSize = 12;

	        int currentPageNumber = 1;

	        // Loop over all the pages in the merged document and add the page number to the footer
	        for (int i = 0; i < mergedDoc.getNumberOfPages(); i++) {
	            PDPage page = mergedDoc.getPage(i);
	            PDPageContentStream stream = new PDPageContentStream(mergedDoc, page, AppendMode.APPEND, false);

	            // Create the footer text in the format "currentPage / totalPageCount"
	            String pageText = String.format("%d / %d", currentPageNumber, totalPageCount);

	            // Set the font and size for the page number
	            stream.setFont(font, fontSize);

	            // Calculate the position for the footer text (centered horizontally)
	            float textWidth = font.getStringWidth(pageText) / 1000 * fontSize;
	            float xPosition = (page.getMediaBox().getWidth() - textWidth) / 2;
	            float yPosition = page.getMediaBox().getLowerLeftY() + 20; // Positioning at the bottom

	            // Begin text, position it, and add the page number
	            stream.beginText();
	            stream.newLineAtOffset(xPosition, yPosition);
	            stream.showText(pageText);
	            stream.endText();
	            stream.close();

	            // Increment the current page number
	            currentPageNumber++;
	        }
	    } catch (IOException e) {
	        logger.error("Error adding page numbers to merged PDF: {}", e.getMessage(), e);
	    }
	}
	
	
	public void addPageNumbersToMergedPDF1(PDDocument mergedDocument, int totalPageCount) throws IOException {
	    PDPageTree pages = mergedDocument.getPages();
	    int currentPageNumber = 1;

	    for (PDPage page : pages) {
	        PDPageContentStream contentStream = new PDPageContentStream(mergedDocument, page, PDPageContentStream.AppendMode.APPEND, true);

	        // Use a built-in font (e.g., Helvetica)
	        PDType1Font font = PDType1Font.HELVETICA_BOLD;

	        contentStream.setFont(font, 10); // Set font to Helvetica
	        contentStream.beginText();

	        // Format the page number text
	        String pageText = String.format("%d / %d", currentPageNumber, totalPageCount);

	        // Get the width of the page text
	        float textWidth = font.getStringWidth(pageText) / 1000 * 10; // Adjust font size (10 here)

	        // Calculate the X position to center the text (page width minus text width, divided by 2)
	        float xPosition = (page.getMediaBox().getWidth() - textWidth) / 2;

	        // Set Y position for the bottom of the page
	        float yPosition = 20; // Adjust as needed for positioning closer or farther from the bottom

	        // Set the position and draw the text
	        contentStream.newLineAtOffset(xPosition, yPosition);
	        contentStream.showText(pageText);
	        
	        contentStream.endText();
	        contentStream.close();

	        currentPageNumber++;
	    }
	}


}