package com.training.keyskillback.generator;

import java.util.Random;

import java.util.Random;

public class Generator {
    private static final String FIRST_ZONE = "АПМИКЕ РОТЬНГ ";
    private static final String SECOND_ZONE = "ВСУ ЛБШ ";
    private static final String THIRD_ZONE = "ЫЧЦ ДЮЩ ";
    private static final String FOURTH_ZONE = "ФЯЙЁ ЖЭЗХЪ ";

    private static boolean firstZoneFlag;
    private static boolean secondZoneFlag;
    private static boolean thirdZoneFlag;
    private static boolean fourthZoneFlag;

    private static StringBuffer stringBuffer;

    public static String generateRandomString (int strLength, String keyZones) {
        stringBuffer = new StringBuffer();
        firstZoneFlag = false;
        secondZoneFlag = false;
        thirdZoneFlag = false;
        fourthZoneFlag = false;
        if (keyZones.contains("1")) {
            firstZoneFlag = true;
        }

        if (keyZones.contains("2")) {
            secondZoneFlag = true;
        }

        if (keyZones.contains("3")) {
            thirdZoneFlag = true;
        }

        if (keyZones.contains("4")) {
            fourthZoneFlag = true;
        }

        if (firstZoneFlag) stringBuffer.append(FIRST_ZONE);
        if (secondZoneFlag) stringBuffer.append(SECOND_ZONE);
        if (thirdZoneFlag) stringBuffer.append(THIRD_ZONE);
        if (fourthZoneFlag) stringBuffer.append(FOURTH_ZONE);

        StringBuffer resultStringBuffer = new StringBuffer();
        String stringBufferWithoutSpaces = stringBuffer.toString();
        stringBufferWithoutSpaces = stringBufferWithoutSpaces.replace(" ","");
        Random random = new Random();
        for (int i = 0; i < strLength; i++) {
            if (i == 1) {
                resultStringBuffer.append(stringBufferWithoutSpaces.charAt(random.nextInt(stringBufferWithoutSpaces.length())));
            } else if (i != 0 && (' ' == resultStringBuffer.charAt(i-2))) {
                resultStringBuffer.append(stringBufferWithoutSpaces.charAt(random.nextInt(stringBufferWithoutSpaces.length())));
            } else if (i == strLength - 1 || i == strLength - 2) {
                resultStringBuffer.append(stringBufferWithoutSpaces.charAt(random.nextInt(stringBufferWithoutSpaces.length())));
            } else if (i > 9 && (' ' != resultStringBuffer.charAt(i-1))  && (' ' != resultStringBuffer.charAt(i-2))  && (' ' != resultStringBuffer.charAt(i-3))
                    && (' ' != resultStringBuffer.charAt(i-4)  && (' ' != resultStringBuffer.charAt(i-5))  && (' ' != resultStringBuffer.charAt(i-6))
                    && (' ' != resultStringBuffer.charAt(i-7))  && (' ' != resultStringBuffer.charAt(i-8))
                    && (' ' != resultStringBuffer.charAt(i-9)) && (' ' != resultStringBuffer.charAt(i-10)))) {
                resultStringBuffer.append(" ");
            } else {
                resultStringBuffer.append(stringBuffer.charAt(random.nextInt(stringBuffer.length())));
            }

            if (i != 0 && (' ' == resultStringBuffer.charAt(i-1)) && (' ' == resultStringBuffer.charAt(i))) {
                resultStringBuffer.deleteCharAt(i);
                resultStringBuffer.append(stringBufferWithoutSpaces.charAt(random.nextInt(stringBufferWithoutSpaces.length())));
            }
        }
        return resultStringBuffer.toString();
    }
}