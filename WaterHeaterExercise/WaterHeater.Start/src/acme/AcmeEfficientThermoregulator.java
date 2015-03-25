package acme;

import java.util.concurrent.TimeUnit;

public class AcmeEfficientThermoregulator implements AcmeThermoregulator{

	AcmeThermometer at;
	AcmeHeater ah;
	int temperature;
	boolean powerEnabled = false;
	
	public AcmeEfficientThermoregulator(AcmeThermometer t, AcmeHeater h){
		at = t;
		ah = h;
	}
	
	@Override
	public void enable() {
		// TODO Auto-generated method stub
		powerEnabled = true;
		Thread thread = new Thread(new Runnable() {
			
			@Override
			public void run() {
				while(powerEnabled){
					int t = at.getTemperature();
					int currentTemp = at.getTemperature();
					if(currentTemp > temperature){
						System.out.println("Momentalnata temperatura e: "+currentTemp+
								", a posakuvanata e: "+temperature+". Iskluci go grejacot.");
						ah.disable();
					}else{
						System.out.println("Momentalnata temperatura e: "+currentTemp+
								", a posakuvanata e: "+temperature+". Ukluci go grejacot.");
						ah.enable();
					}
					try{
						TimeUnit.SECONDS.sleep(1);
					}
					catch (InterruptedException e){
					}
				}
				
			}
		});
		thread.start();
	}

	@Override
	public void disable() {
		// TODO Auto-generated method stub
		powerEnabled = false;
	}

	@Override
	public void setTemperature(int t) {
		// TODO Auto-generated method stub
		temperature = t;
	}
}
