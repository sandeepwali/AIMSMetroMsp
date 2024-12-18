package com.solum.aims.msp.util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

public class KeyGenerator {

	private static int serialNo = 0;
	private static String prevTime = "";
	private static final int MAX_SERIAL_NO = 999;
	
	private static final SimpleDateFormat SDF = new SimpleDateFormat("yyyyMMddHHmmssSSS");
	private static final DecimalFormat DF = new DecimalFormat("000");
	
	public static synchronized String getKeyByDateFormat() {

        String currentTime = SDF.format(new java.util.Date());

        if (serialNo == 0) {
            while (prevTime.equals(currentTime)) {
                currentTime = SDF.format(new java.util.Date());
            }
            prevTime = currentTime;
        }

        String keyStr = currentTime + DF.format(serialNo);

        serialNo = serialNo >= MAX_SERIAL_NO ? 0 : serialNo + 1;

        return keyStr;
    }
	
	public static synchronized long getLongKeyByDateFormat() {
		String key = getKeyByDateFormat();
		return Long.parseLong(key.substring(2, key.length()));
	}
}
