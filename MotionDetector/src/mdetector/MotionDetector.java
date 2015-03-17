package mdetector;

import alarm.Alarm;

import img.capture.ImageCaptureDevice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class MotionDetector{

	ImageCaptureInterface ic;
	ArrayList<AlarmChannel> alarmChannels = new ArrayList<AlarmChannel>();
	boolean first = true;
	boolean run = true;
	
	public MotionDetector(ImageCaptureInterface ic){
		this.ic = ic;
	}
	
	public void start(){
		byte[] imageOne = ic.captureImage();
		while(imageOne!=null){
			byte[] imageTwo = ic.captureImage();
			if(imageOne==null || imageTwo==null)
				break;
			if(!Arrays.equals(imageOne, imageTwo)){
				for(AlarmChannel alarm : alarmChannels)
					alarm.setAlarm();
				imageOne=imageTwo;
			}
			else{
				continue;
			}
		}
	}
	
	public void registerAlarm(AlarmChannel alarmCh){
		alarmChannels.add(alarmCh);
	}
	
}