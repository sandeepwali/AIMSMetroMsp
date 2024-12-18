package com.solum.aims.msp.util;

import java.util.Arrays;

import com.solum.aims.core.entity.util.EndDeviceTypeCodeDigitNotFoundException;
import com.solum.aims.core.entity.util.EndDeviceTypeNotFoundException;
import com.solum.aims.msp.persistence.core.entity.CoreEndDevice.EndDeviceType;
import com.solum.aims.msp.persistence.core.entity.CoreEndDevice.EndDeviceType.CodeDigit;

public class EndDeviceUtils {
    public static final String ORGANIZATIONALLY_UNIQUE_IDENTIFIER ="C8BA94";

    public static boolean isReactive(EndDeviceType endDeviceType) {
        return switch (endDeviceType.getClassType()) {
            case TI, TI_FREEZER, N_SYSTEM -> true;
            default -> false;
        };
    }

    public static boolean checkSLabelCodeChecksum(String code) {
        if (code.matches("[0-9A-F]+") == false) {
            return false;
        } else if (CodeDigit.TWELVE == CodeDigit.valueOf(code.length()) || CodeDigit.FOURTEEN == CodeDigit.valueOf(code.length())) {
            return EndDeviceUtils.generateCodeChecksum(code.substring(0, code.length() - 1)).equalsIgnoreCase(code.substring(code.length() - 1));
        }

        return true;
    }

    public static String generateCodeChecksum(String subCode) {
        int xorChecksum = 0;

        for (char c : subCode.toCharArray()) {
            xorChecksum ^= Character.getNumericValue(c);
        }

        return Integer.toHexString(xorChecksum).toUpperCase();
    }

    public static String getMacAddressByCode(String code) {
        String macAddress;
        CodeDigit codeDigit = CodeDigit.valueOf(code.length());

        if (codeDigit == null) {
            throw new EndDeviceTypeCodeDigitNotFoundException();
        }

        macAddress = switch (codeDigit) {
            case TWELVE -> String.format("%sFF%s", ORGANIZATIONALLY_UNIQUE_IDENTIFIER, code.substring(0, 8));
            case FOURTEEN -> String.format("%sFF%s", ORGANIZATIONALLY_UNIQUE_IDENTIFIER, code.substring(2, 10));
            case SIXTEEN -> String.format("%sFFFE%s", code.substring(0, 6), code.substring(6, 12));
            case SEVENTEEN -> String.format("%s", code.substring(0, 16));
            default -> throw new IllegalArgumentException();
        };

        return EndDeviceUtils.hyphenateMacAddress(macAddress);
    }

    public static String hyphenateMacAddress(String macAddress) {
        return macAddress.toUpperCase().replaceAll("(..)(?!$)", "$1-");
    }

    public static EndDeviceType getEndDeviceType(String code) {
        String typeCode = null;
        CodeDigit codeDigit = CodeDigit.valueOf(code.length());

        if (codeDigit == null) {
            throw new EndDeviceTypeCodeDigitNotFoundException();
        }

        switch (codeDigit) {
            case TWELVE -> typeCode = code.substring(8, 11);
            case FOURTEEN -> typeCode = code.substring(10, 13);
            case SIXTEEN -> typeCode = code.substring(12);
            case SEVENTEEN -> typeCode = code.substring(16);
            default -> {
            }
        }

        return EndDeviceUtils.searchEndDeviceType(typeCode, codeDigit);
    }

    private static EndDeviceType searchEndDeviceType(String typeCode, CodeDigit digit) {
        return Arrays.stream(EndDeviceType.values())
                     .filter(endDeviceType -> typeCode.equals(endDeviceType.getTypeCode()[digit.getIndex()]))
                     .findAny()
                     .orElseThrow(EndDeviceTypeNotFoundException::new);
    }
    
	public static EndDeviceType getEndDeviceClassType(String typeCode) {
		return searchEndDeviceClassType(typeCode);
	}

	private static EndDeviceType searchEndDeviceClassType(String typeCode) {
		return Arrays.stream(EndDeviceType.values())
					.filter(endDeviceType -> typeCode.equals(endDeviceType.name()))
					.findAny()
					.orElseThrow(RuntimeException::new);
	}
}