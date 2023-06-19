package com.scanners.qrcodes.generator;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.WriterException;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

@Component
public class QRCodeGenerator {

    /**
     * This method generates qr code in image form
     *
     * @param text - text to be encoded in the qr code
     * @param width - width the qr code will take
     * @param height - height the qr code will take
     * @param pathToImage - the path the generated image will be stored
     * @throws WriterException
     * @throws IOException
     */
    public static void generateQRCodeImage(String text, int width, int height, String pathToImage)
            throws WriterException, IOException {

        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE,width,height);
        Path path = FileSystems.getDefault().getPath(pathToImage);
        MatrixToImageWriter.writeToPath(bitMatrix,"PNG",path);

    }
    /**
     * This method generates the QR Code in the form of a byte array which can be used to
     * return a HTTP response
     *
     * @param text - the encoded text
     * @param width - sets the width of the qr code image
     * @param height - sets the height of the qr code image
     * @return - returns the generated qr code image
     * @throws WriterException
     * @throws IOException
     */
    public static byte[] getQRCodeImage(String text, int width, int height)
            throws WriterException, IOException {
        QRCodeWriter qrCodeWriter = new QRCodeWriter();
        BitMatrix bitMatrix = qrCodeWriter.encode(text, BarcodeFormat.QR_CODE, width, height);

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();

        MatrixToImageWriter.writeToStream(bitMatrix, "PNG", byteArrayOutputStream);

        byte[] qrCodeImageData = byteArrayOutputStream.toByteArray();
        return qrCodeImageData;
    }
}
