package com.mygdx.imageeditor;

public class Util {
    public static int bytesToInt(byte[] bytes) {
        int result = 0;
        for (int i = 0; i < bytes.length; i++) {
            result += (int) bytes[i] << (8 * i);
        }
        return result;
    }

    public static byte[] intToSignedBytes(int value) {
        byte[] result = new byte[4];
        return result;
    }

    public static void testIntToSignedBytes() {
        byte[] testResults = intToSignedBytes(543152314);
        int[] expectedResults = { 32, 95, -40, -70 };
        for (int i = 0; i < testResults.length; i++) {
            if ((int) testResults[i] != expectedResults[i])
                System.out.println("TEST FAILED! INDEX " + i + " IS "
                        + testResults[i] + " EXPECTED: " + expectedResults[i]);
        }
    }
}
