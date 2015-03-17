package alarm;

import mdetector.AlarmChannel;

public class Alarm implements AlarmChannel {

	@Override
	public void setAlarm() {
		// TODO Auto-generated method stub
		System.out.println("Movement detected! ALARM!");
	}

}
