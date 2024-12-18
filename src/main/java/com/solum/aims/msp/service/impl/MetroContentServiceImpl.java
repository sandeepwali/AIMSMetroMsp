package com.solum.aims.msp.service.impl;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.Arrays;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import org.apache.xmlgraphics.util.UnitConv;
import org.krysalis.barcode4j.BarcodeClassResolver;
import org.krysalis.barcode4j.DefaultBarcodeClassResolver;
import org.krysalis.barcode4j.HumanReadablePlacement;
import org.krysalis.barcode4j.impl.AbstractBarcodeBean;
import org.krysalis.barcode4j.output.bitmap.BitmapCanvasProvider;
import org.krysalis.barcode4j.tools.MimeTypes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solum.aims.core.entity.EndDevice.EndDeviceType;
import com.solum.aims.core.entity.util.EndDeviceUtils;
import com.solum.aims.msp.persistence.entity.MetroArticle;
import com.solum.aims.msp.persistence.entity.MetroContent;
import com.solum.aims.msp.persistence.entity.MetroEnddevice;
import com.solum.aims.msp.persistence.repository.MetroContentRepository;
import com.solum.aims.msp.service.MetroContentService;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

@Transactional(
		transactionManager="transactionManager",
		propagation=Propagation.REQUIRES_NEW
)
@Slf4j
@Service("metroContentService")
public class MetroContentServiceImpl implements MetroContentService {

	@Autowired
	private MetroContentRepository repository;

	private String NOTI_MSG = "No Article Information";
	
	private int MAX_FONT_SIZE = 50;
	
	/*@Transactional(
			transactionManager="transactionManager", 
			propagation=Propagation.REQUIRES_NEW
			)*/
	@Override
	public void updateContent(MetroContent content) {
		repository.save(content);
	}
	
	/*@Transactional(
			transactionManager="transactionManager", 
			propagation=Propagation.REQUIRES_NEW
			)*/
	@Override
	public void updateContents(List<MetroContent> contents) {
		repository.saveAll(contents);
	}

	@Override
	public MetroContent getByUpdateImageParam(
			MetroArticle article, 
			int width,
			int height,
			int color,
			int page,
			int model) {
		return repository
				.findByArticleAndWidthAndHeightAndColorAndModelAndPage(
						article, width, height, color, model, page)
				.orElse(new MetroContent());
	}

	@Override
	public List<MetroContent> getByEnddevice(MetroEnddevice metroEnddevice) {
		return repository.findByArticleAndWidthAndHeightAndColorAndModelOrderByPage(
				metroEnddevice.getArticle(), metroEnddevice.getWidth(), metroEnddevice.getHeight(), metroEnddevice.getColor(), metroEnddevice.getModel()
				);
	}
	
	@Override
	public List<MetroContent> getByEnddeviceAndPage(MetroEnddevice metroEnddevice, int page) {
		return repository.findByArticleAndWidthAndHeightAndColorAndModelAndPageOrderByPage(
				metroEnddevice.getArticle(), metroEnddevice.getWidth(), metroEnddevice.getHeight(), metroEnddevice.getColor(), metroEnddevice.getModel(), page
				);
	}

	@Override
	public void removeByArticle(MetroArticle article) {
		repository.deleteByArticle(article);
	}

	@Override
	public void removeByArticleAndType(MetroArticle article, String type) {
		repository.deleteByArticleAndType(article,type);
	}

	@Override
	public BufferedImage createDefaultImage(String labelCode, String articleId) {
		
		EndDeviceType enddeviceType = EndDeviceUtils.getEndDeviceType(labelCode);
		
		int width = enddeviceType.getDisplayWidth();
		int height = enddeviceType.getDisplayHeight();
		
		int originWidth = width;
		int originHeight = height;
		
		boolean isRotated = false;
		
		if(width < height){
			isRotated = true;
			int temp = width;
			width = height;
			height = temp;
		}
		
		BufferedImage bufferedImage = null;
		String tagColorDepth;
		
		switch(enddeviceType.getColorType()) {
		case BINARY:
			bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_BYTE_BINARY);
			tagColorDepth="1";
			break;
			
		case TERNARY:
		case TERNARY_BLUE:
		case TERNARY_GREEN:
		case TERNARY_RED:
		default:
			bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
			tagColorDepth="2";
			break;
			
		case TERNARY_YELLOW:
			bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_3BYTE_BGR);
			tagColorDepth="3";
			break;
		}
		
		Graphics2D g2d = bufferedImage.createGraphics();
		g2d.setPaint ( new Color ( 255, 255, 255) );
		g2d.fillRect ( 0, 0, bufferedImage.getWidth(), bufferedImage.getHeight() );

		int fontSize = width > height ? width / 20 : height / 10;
		if (fontSize > MAX_FONT_SIZE) fontSize = MAX_FONT_SIZE;
		Font	font = null;
		font = new Font("Arial", Font.BOLD, fontSize);
		g2d.setFont(font);
		
		FontRenderContext strFrc = g2d.getFontRenderContext();
		int tempWidth = (int)font.getStringBounds(NOTI_MSG, strFrc).getWidth();
				
		do{
			if (tempWidth > width) fontSize--;
			
			font = new Font("Arial", Font.BOLD, fontSize);
			g2d.setFont(font);
			
			strFrc = g2d.getFontRenderContext();
			tempWidth = (int)font.getStringBounds(NOTI_MSG, strFrc).getWidth();			
			
		}while(tempWidth > width);
		
		fontSize--;		
		font = new Font("Arial", Font.BOLD, fontSize);
		g2d.setFont(font);
		strFrc = g2d.getFontRenderContext();

		float strWidth = (float) font.getStringBounds(NOTI_MSG, strFrc).getWidth();
		float strHeight = (float) font.getStringBounds(NOTI_MSG, strFrc).getHeight();

		int x = (int)((width-strWidth) / 2);
		int y = (int)(height/3 - strHeight) + (int)(fontSize);
		
		//Product Not Found text
		g2d.setColor(Color.BLACK);
		g2d.drawString(NOTI_MSG, x, y);
		
		//Barcode of itemId
		BarcodeType barcodeType;
		if(isRotated) {
			barcodeType = this.findBarcodeTye(originWidth, originHeight, Integer.valueOf(tagColorDepth));
		} else {
			barcodeType = this.findBarcodeTye(width, height, Integer.valueOf(tagColorDepth));
		}
		
		log.info("Found barcode type : {}", barcodeType);
		
		try {
			createBarcodeType1(g2d, barcodeType, articleId);
		} catch (Exception e) {
			log.warn("", e);
		}
		
		//itemId text
		float strWidth2 = (float) font.getStringBounds(articleId, strFrc).getWidth();	
		int x2 = (int)((width-strWidth2) / 2);
		int y2 = (int)(height/3*2) + (int)(fontSize);	
		g2d.drawString(articleId, x2, y2);
		
		if(isRotated){
			AffineTransform tx_rot = new AffineTransform();
			tx_rot.translate(bufferedImage.getHeight(), 0);
			tx_rot.rotate(Math.toRadians(90));			
			AffineTransformOp op_rot = new AffineTransformOp(tx_rot, AffineTransformOp.TYPE_NEAREST_NEIGHBOR);
			bufferedImage = op_rot.filter(bufferedImage, null);
		}
		
		return bufferedImage;
	}
	
	private boolean createBarcodeType1(Graphics2D g2d, BarcodeType barcodeType, String articleId) throws Exception {
		String type = "code128";
		String data = articleId;
		
		int x = (barcodeType.getResolutionX() - (barcodeType.getMinWidth() * barcodeType.getMaxStep())) / 2;
		int y = (barcodeType.getResolutionY() / 2) - 7;
		
		int height = barcodeType.getMaxStep() > 2 ? 30 : 15;
		int width =  barcodeType.getMinWidth() * barcodeType.getMaxStep();
		
		int dpi = barcodeType.getDpi();
		float module = (float) barcodeType.getMaxStep();

		AbstractBarcodeBean bean = null;
		BarcodeClassResolver resolver = new DefaultBarcodeClassResolver();

		Class<?> cls = resolver.resolveBean(type);
		bean = (AbstractBarcodeBean) cls.getDeclaredConstructor().newInstance();
		bean.setModuleWidth(UnitConv.in2mm(module/ dpi));
		bean.setMsgPosition(HumanReadablePlacement.HRP_NONE);
		bean.setQuietZone(UnitConv.in2mm(10*module/dpi));

		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int imgType = BufferedImage.TYPE_BYTE_BINARY;
		String mimeType = MimeTypes.MIME_PNG;
		BitmapCanvasProvider canvas = new BitmapCanvasProvider(baos, mimeType,dpi, imgType, false, 0);
		
		try {
			bean.generateBarcode(canvas, data);
		} catch (Exception e){
			return false;
		}
		canvas.finish();

		byte[] imageByteArray = baos.toByteArray();
		BufferedImage bImg = ImageIO.read(new ByteArrayInputStream(imageByteArray));
		ImageIcon imgIcon = new ImageIcon(bImg);
		Image img = imgIcon.getImage();

		Image rateImg = img.getScaledInstance(img.getWidth(null), height,Image.SCALE_FAST);
		
		//Barcode position
		x = arrangeBarcodePosition("center", width, rateImg.getWidth(null), x);
		
		g2d.drawImage(rateImg, x, y, null);
		
		return true;
	}

	private int arrangeBarcodePosition(String position, int boxWidth, int barcodeWidth, int currentX){
		int finalX = currentX;
		int diff = boxWidth - barcodeWidth;
		
		if(diff < 0) {
			//If the barcode width is bigger than the box width, draw the current position(left arrangement).
			//Do nothing.
		} else {
			if(position.equals("center")){
				//If the diff is 0 or 1, draw the current position.
				if(diff > 2) {
					finalX = currentX + diff/2;
				}
			}
			else if (position.equals("right")){
				finalX = currentX + diff;
			}
			else {  //left
				//do nothing.
			}
		}		
		return finalX;
	}
	
	private BarcodeType findBarcodeTye(int resolutionX, int resolutionY, int colorDepth) {
		return Arrays.stream(BarcodeType.values())
				.filter(type->(type.resolutionX==resolutionX) && (type.resolutionY==resolutionY) && (type.colorDepth==colorDepth))
				.findFirst()
				.get();
	}
	
	@Getter
	public enum BarcodeType {
		
		BARCODE_1_CODE128(1, 189, 1, 143, 144, 200, 1),
		BARCODE_2_CODE128(2, 189, 1, 143, 144, 200, 2),
		BARCODE_3_CODE128(3, 189, 1, 143, 144, 200, 3),
		BARCODE_4_CODE128(4, 91, 1, 143, 152, 152, 1),
		BARCODE_5_CODE128(5, 91, 1, 143, 152, 152, 2),
		BARCODE_6_CODE128(6, 91, 1, 143, 152, 152, 3),
		BARCODE_7_CODE128(7, 125, 1, 143, 152, 296, 1),
		BARCODE_8_CODE128(8, 125, 1, 143, 152, 296, 2),
		BARCODE_9_CODE128(9, 125, 1, 143, 152, 296, 3),
		BARCODE_10_CODE128(10, 125, 1, 143, 152, 522, 1),
		BARCODE_11_CODE128(11, 125, 1, 143, 152, 522, 2),
		BARCODE_12_CODE128(12, 125, 1, 143, 152, 522, 3),
		BARCODE_13_CODE128(13, 153, 1, 143, 200, 144, 1),
		BARCODE_14_CODE128(14, 153, 1, 143, 200, 144, 2),
		BARCODE_15_CODE128(15, 153, 1, 143, 200, 144, 3),
		BARCODE_16_CODE128(16, 184, 1, 143, 200, 200, 1),
		BARCODE_17_CODE128(17, 184, 1, 143, 200, 200, 2),
		BARCODE_18_CODE128(18, 184, 1, 143, 200, 200, 3),
		BARCODE_19_CODE128(19, 111, 1, 143, 212, 104, 1),
		BARCODE_20_CODE128(20, 111, 1, 143, 212, 104, 2),
		BARCODE_21_CODE128(21, 111, 1, 143, 212, 104, 3),
		BARCODE_22_CODE128(22, 129, 2, 143, 240, 416, 1),
		BARCODE_23_CODE128(23, 129, 2, 143, 240, 416, 2),
		BARCODE_24_CODE128(24, 129, 2, 143, 240, 416, 3),
		BARCODE_25_CODE128(25, 130, 2, 143, 250, 122, 1),
		BARCODE_26_CODE128(26, 130, 2, 143, 250, 122, 2),
		BARCODE_27_CODE128(27, 130, 2, 143, 250, 122, 3),
		BARCODE_28_CODE128(28, 117, 2, 143, 264, 176, 1),
		BARCODE_29_CODE128(29, 117, 2, 143, 264, 176, 2),
		BARCODE_30_CODE128(30, 117, 2, 143, 264, 176, 3),
		BARCODE_31_CODE128(31, 112, 2, 143, 296, 128, 1),
		BARCODE_32_CODE128(32, 112, 2, 143, 296, 128, 2),
		BARCODE_33_CODE128(33, 112, 2, 143, 296, 128, 3),
		BARCODE_34_CODE128(34, 125, 2, 143, 296, 152, 1),
		BARCODE_35_CODE128(35, 125, 2, 143, 296, 152, 2),
		BARCODE_36_CODE128(36, 125, 2, 143, 296, 152, 3),
		BARCODE_37_CODE128(37, 111, 2, 143, 296, 160, 1),
		BARCODE_38_CODE128(38, 111, 2, 143, 296, 160, 2),
		BARCODE_39_CODE128(39, 111, 2, 143, 296, 160, 3),
		BARCODE_40_CODE128(40, 110, 2, 143, 300, 200, 1),
		BARCODE_41_CODE128(41, 110, 2, 143, 300, 200, 2),
		BARCODE_42_CODE128(42, 110, 2, 143, 300, 200, 3),
		BARCODE_43_CODE128(43, 152, 3, 143, 360, 184, 1),
		BARCODE_44_CODE128(44, 152, 3, 143, 360, 184, 2),
		BARCODE_45_CODE128(45, 152, 3, 143, 360, 184, 3),
		BARCODE_46_CODE128(46, 112, 3, 143, 384, 168, 1),
		BARCODE_47_CODE128(47, 112, 3, 143, 384, 168, 2),
		BARCODE_48_CODE128(48, 112, 3, 143, 384, 168, 3),
		BARCODE_49_CODE128(49, 120, 3, 143, 384, 180, 1),
		BARCODE_50_CODE128(50, 120, 3, 143, 384, 180, 2),
		BARCODE_51_CODE128(51, 120, 3, 143, 384, 180, 3),
		BARCODE_52_CODE128(52, 100, 3, 143, 384, 640, 1),
		BARCODE_53_CODE128(53, 100, 3, 143, 384, 640, 2),
		BARCODE_54_CODE128(54, 100, 3, 143, 384, 640, 3),
		BARCODE_55_CODE128(55, 112, 3, 143, 400, 300, 1),
		BARCODE_56_CODE128(56, 112, 3, 143, 400, 300, 2),
		BARCODE_57_CODE128(57, 112, 3, 143, 400, 300, 3),
		BARCODE_58_CODE128(58, 126, 3, 143, 480, 800, 1),
		BARCODE_59_CODE128(59, 126, 3, 143, 480, 800, 2),
		BARCODE_60_CODE128(60, 126, 3, 143, 480, 800, 3),
		BARCODE_61_CODE128(61, 125, 4, 143, 522, 152, 1),
		BARCODE_62_CODE128(62, 125, 4, 143, 522, 152, 2),
		BARCODE_63_CODE128(63, 125, 4, 143, 522, 152, 3),
		BARCODE_64_CODE128(64, 137, 4, 143, 528, 880, 1),
		BARCODE_65_CODE128(65, 137, 4, 143, 528, 880, 2),
		BARCODE_66_CODE128(66, 137, 4, 143, 528, 880, 3),
		BARCODE_67_CODE128(67, 110, 4, 143, 600, 200, 1),
		BARCODE_68_CODE128(68, 110, 4, 143, 600, 200, 2),
		BARCODE_69_CODE128(69, 110, 4, 143, 600, 200, 3),
		BARCODE_70_CODE128(70, 128, 4, 143, 600, 448, 1),
		BARCODE_71_CODE128(71, 128, 4, 143, 600, 448, 2),
		BARCODE_72_CODE128(72, 128, 4, 143, 600, 448, 3),
		BARCODE_73_CODE128(73, 100, 4, 143, 640, 960, 1),
		BARCODE_74_CODE128(74, 100, 4, 143, 640, 960, 2),
		BARCODE_75_CODE128(75, 100, 4, 143, 640, 960, 3),
		BARCODE_76_CODE128(76, 138, 5, 143, 648, 480, 1),
		BARCODE_77_CODE128(77, 138, 5, 143, 648, 480, 2),
		BARCODE_78_CODE128(78, 138, 5, 143, 648, 480, 3),
		BARCODE_79_CODE128(79, 212, 7, 143, 1024, 758, 1),
		BARCODE_80_CODE128(80, 150, 8, 143, 1200, 1600, 1),
		BARCODE_81_CODE128(81, 150, 8, 143, 1200, 1600, 2),
		BARCODE_82_CODE128(82, 150, 8, 143, 1200, 1600, 3);
		
		private int barcodeId;
		private int dpi;
		private int maxStep;
		private int minWidth;
		private int resolutionX;
		private int resolutionY;
		private int colorDepth;
		
		private BarcodeType(int barcodeId, int dpi, int maxStep, int minWidth, int resolutionX, int resolutionY,
				int colorDepth) {
			this.barcodeId = barcodeId;
			this.dpi = dpi;
			this.maxStep = maxStep;
			this.minWidth = minWidth;
			this.resolutionX = resolutionX;
			this.resolutionY = resolutionY;
			this.colorDepth = colorDepth;
		}
	}
	
}
