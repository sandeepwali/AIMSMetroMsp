package com.solum.aims.msp;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.solum.aims.msp.persistence.entity.Article;
import com.solum.aims.msp.persistence.entity.EndDevice;
import com.solum.aims.msp.persistence.entity.MetroArticle;
import com.solum.aims.msp.persistence.repository.projection.ArticleEnddeviceProjection;
import com.solum.aims.msp.property.ApplicationProperties;
import com.solum.aims.msp.service.ArticleService;
import com.solum.aims.msp.service.EndDeviceService;
import com.solum.aims.msp.service.MetroArticleService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

@Slf4j
public class Scheduler {

	@Autowired
	private ApplicationProperties properties;
	
	@Autowired
	private EndDeviceService<EndDevice> endDeviceService;
	
	@Autowired
	private MetroArticleService metroArticleService;
	
	@Autowired
	private ArticleService<Article> articleService;
	
	
	public void runBackupSchedule() throws JsonProcessingException {
		
		log.info("[MSP] Start backup schedule.");
		
		String backupPath = properties.getBackupPath();
		String prRoot = properties.getPrRoot();
		
		File dDir = new File(backupPath);
		if(!dDir.exists()) {
			dDir.mkdirs();
		}
		
		// create today folder
		Date nowDayTime = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("-yyyyMMdd-hhmmssSS"); 
		String strNow = sdf.format(nowDayTime);
		String folderToday = backupPath + '\\' + "API" + strNow;
		dDir = new File(folderToday);
		if(!dDir.exists()) {
			dDir.mkdirs();
		}
		
		// create PR_ROOT folder
		String prRootFolder = prRoot + "\\PFIFiles\\ResultFiles\\";
		dDir = new File(prRootFolder);
		if(!dDir.exists()) {
			dDir.mkdirs();
		}
		
		List<String> stationCodes = articleService.getArticleGroupByStationCode();
		for(int i=0 ; i<stationCodes.size() ; i++) {
			
			// create stationCode folder for i1 files
			String folderStation = folderToday + '\\' + stationCodes.get(i);
			dDir = new File(folderStation);
			if(!dDir.exists()) {
				dDir.mkdirs();
			}
			
			try {
				PrintWriter writer;
				
				// create the linkbackup.i1
				List<ArticleEnddeviceProjection> ae = endDeviceService.getArticleEnddevice(stationCodes.get(i));
				String linkBackupFileI1 = folderStation + '\\' + "linkbackup.i1";
				writer = new PrintWriter(linkBackupFileI1, "utf-8");
				for(int j=0 ; j<ae.size() ; j++) {
					String model = "";
					if(ae.get(j).getModel()!=null && !ae.get(j).getModel().equals("1")) {
						model = ae.get(j).getModel();
					}
					String str = "0001 " + ae.get(j).getArticleId() + " 1 0 N 93 0 " + ae.get(j).getCode() + " 124 0 " + model + " 9100 0 GW,";				
					writer.println(str);
				}
			    writer.close();
			    				
				// create the linkbackup.m1
				String linkBackupFileM1 = folderStation + '\\' + "linkbackup.m1";
				writer = new PrintWriter(linkBackupFileM1, "utf-8");
				String strLinkBackup = "TARGETLINK,0001,,D:\\MAI\\pricer\\posif\\input\\linkbackup.i1," + prRoot + "\\PFIFiles\\ResultFiles\\linkbackup.r7";				
				writer.println(strLinkBackup);
				writer.close();
				
				// create the itembackup.i1
				List<MetroArticle> ma = metroArticleService.findByStationCode(stationCodes.get(i));
				String itemBackupFileI1 = folderStation + '\\' + "itembackup.i1";
				writer = new PrintWriter(itemBackupFileI1, "utf-8");
				for(int j=0 ; j<ma.size() ; j++) {

					if(ma.get(j).getArticleId()!=null && ma.get(j).getData()!=null) {
						Map<String, String> data = ma.get(j).getData();
						String strData = "1001 " + ma.get(j).getArticleId() + " ";	
						for(Entry<String, String> elem : data.entrySet()) {
							String keyString = elem.getKey().startsWith("F") ? elem.getKey().replace("F", "") : elem.getKey();
							if(elem.getValue()==null || elem.getValue().length()==0) {
								strData += " " + keyString + " 0 ";
							}		                
							else {
								strData += " " + keyString + " 0 " + elem.getValue() + "";
							}
			            }
						strData += ",";
						writer.println(strData);
					}
				}
			    writer.close();
			    
			    // create the itembackup.m1
				String itemBackupFileM1 = folderStation + '\\' + "itembackup.m1";
				writer = new PrintWriter(itemBackupFileM1, "utf-8");
				String strItemBackup = "UPDATE,1001,,D:\\MAI\\pricer\\posif\\input\\itembackup.i1," + prRoot + "\\PFIFiles\\ResultFiles\\itembackup.r7";				
				writer.println(strItemBackup);
				writer.close();
				
			} catch (FileNotFoundException e) {
				log.error("The station cannot be backup. [{}]  {}", stationCodes.get(i), e);
			} catch (UnsupportedEncodingException e) {
				log.error("The station cannot be backup. [{}]  {}", stationCodes.get(i), e);
			}
		    
		}
		
		log.info("[MSP] Finish backup schedule.");
	}
}
