package com.mygdx.imageeditor;

import java.io.FileOutputStream;
import java.io.IOException;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Pixmap;

public class ImageInputOutput {
    public static ImageInputOutput Instance;
    private byte[] _fileHeader;
    private Pixmap _pixels;
    private int startPoint;

    public ImageInputOutput() {
        Instance = this;
    }

    public void saveImage(String filePath) throws IOException {
        FileOutputStream output = new FileOutputStream(filePath);
        byte[] color;
        byte[] colorData = new byte[_pixels.getWidth() * _pixels.getHeight() * 3];
        //Pixmap doodle = EditWindow.Instance.DoodleMap;
        int colorIndex = 0;
        for (int y = _pixels.getHeight() - 1; y >= 0; y--) {
            for (int x = 0; x < _pixels.getWidth(); x++) {
                int tempColor = _pixels.getPixel(x, y);
                color = Util.intToSignedBytes(_pixels.getPixel(x, y));
                colorData[colorIndex] = color[2];
                colorData[colorIndex + 1] = color[1];
                colorData[colorIndex + 2] = color[0];
                colorIndex += 3;
            }
        }
        byte[] fileBytes = Gdx.files.internal(filePath).readBytes();
        output.write(fileBytes);
        output.write(_fileHeader);
        output.write(colorData);
        output.close();
    }

    public Pixmap loadImage(String filePath) {
        //_fileHeader[] = new byte[startPoint];
        byte[] bytes = Gdx.files.internal(filePath).readBytes();
        if (bytes[0] != 'B' || bytes[1] != 'M') {
            System.out.println(filePath + " is NOT a bitmap image");
            //return;
        }
        byte[] fileSize = { bytes[2], bytes[3], bytes[4], bytes[5] };
        byte[] start = { bytes[10], bytes[11], bytes[12], bytes[13] };
        byte[] widthBytes = { bytes[18], bytes[19], bytes[20], bytes[21] };
        byte[] heightBytes = { bytes[22], bytes[23], bytes[24], bytes[25] };
        byte[] bitsPerPixel = { bytes[28], bytes[29] };
        int startPoint = Util.bytesToInt(start);
        int width = Util.bytesToInt(widthBytes);
        int height = Util.bytesToInt(heightBytes);
        int bytesPerPixel = Util.bytesToInt(bitsPerPixel) / 8;
        if (bytesPerPixel != 3) {
            System.out.println("Unsupported image pixel format. Incorrect bits per pixel");
            //return;
        }
        return null;
    }

    public static int[] unsignBytes(byte[] bytes) {
        int[] ints = new int[bytes.length];
        for (int i = 0; i < bytes.length; i++) {
        }
        return ints;
    }

}
