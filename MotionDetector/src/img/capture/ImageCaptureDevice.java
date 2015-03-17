package img.capture;

import java.util.NoSuchElementException;
import java.util.Scanner;

import mdetector.ImageCaptureInterface;

public class ImageCaptureDevice implements ImageCaptureInterface{

	@Override
	public byte[] captureImage(){

		String image = null;
		System.out.println("Enter image bytes:");
		Scanner input = new Scanner(System.in);
		try{
			image = input.nextLine();
		}catch (NoSuchElementException e){
			 return null;
		}
		byte[] imageBytes = image.getBytes();
		return imageBytes;
	}
}
