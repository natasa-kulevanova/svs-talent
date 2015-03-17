package app;

import img.capture.ImageCaptureDevice;
import alarm.Alarm;
import mdetector.MotionDetector;

public class MotionDetectorApplication {

	
	
	public static void main(String[] args){
		ImageCaptureDevice ic = new ImageCaptureDevice();
		MotionDetector motionDetector = new MotionDetector(ic);		
		Alarm a1 = new Alarm();
		Alarm a2 = new Alarm();
		motionDetector.registerAlarm(a1);
		motionDetector.registerAlarm(a2);
		motionDetector.start();
		
	}
}
