package com.until;

import java.awt.image.BufferedImage;
import java.util.HashMap;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.EncodeHintType;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.WriterException;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.decoder.ErrorCorrectionLevel;

public class TwoDimensionalCode {

	public TwoDimensionalCode() {
		// TODO Auto-generated constructor stub
	}
	
	public BufferedImage createCode(String content) {
		
		int width=300;
		int height=300;
		String format="png";
//		String content="llllllll";
		
		
		HashMap hashMap=new HashMap();
		
		hashMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hashMap.put(EncodeHintType.MARGIN, 2);
		BitMatrix bitMatrix=null;
		
		try {
			bitMatrix= new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE , width, height,hashMap);
			
			
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}
	        
	        
		
		return image;
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		int width=300;
		int height=300;
		String format="png";
		String content="llllllll";
		
		
		HashMap hashMap=new HashMap();
		
		hashMap.put(EncodeHintType.CHARACTER_SET, "utf-8");
		hashMap.put(EncodeHintType.ERROR_CORRECTION, ErrorCorrectionLevel.M);
		hashMap.put(EncodeHintType.MARGIN, 2);
		BitMatrix bitMatrix=null;
		
		try {
			bitMatrix= new MultiFormatWriter().encode(content, BarcodeFormat.QR_CODE , width, height,hashMap);
			
			
		} catch (WriterException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		 BufferedImage image = new BufferedImage(width, height,BufferedImage.TYPE_INT_RGB);
		for (int x = 0; x < width; x++) {
			for (int y = 0; y < height; y++) {
				image.setRGB(x, y, bitMatrix.get(x, y) ? 0xFF000000 : 0xFFFFFFFF);
			}
		}
	        
	        
		
		
	}
	
	
	
	
}
