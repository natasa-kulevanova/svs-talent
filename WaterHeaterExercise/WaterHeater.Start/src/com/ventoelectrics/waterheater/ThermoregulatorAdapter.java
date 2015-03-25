package com.ventoelectrics.waterheater;

import vento.VentoThermometer;
import vento.VentoThermoregulator;
import acme.AcmeThermoregulator;

public class ThermoregulatorAdapter implements VentoThermoregulator{

	AcmeThermoregulator at;
	
	public ThermoregulatorAdapter(AcmeThermoregulator acmeT) {
		at = acmeT;
	}

	@Override
	public void enablePower() {
		// TODO Auto-generated method stub
		at.enable();
	}

	@Override
	public void disablePower() {
		// TODO Auto-generated method stub
		at.disable();
	}

	@Override
	public void setTemperature(Integer temperature) {
		// TODO Auto-generated method stub
		at.setTemperature(temperature);
	}
	
	

}
