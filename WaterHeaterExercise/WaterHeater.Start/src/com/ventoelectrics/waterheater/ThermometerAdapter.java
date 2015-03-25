package com.ventoelectrics.waterheater;

import vento.VentoThermometer;
import acme.AcmeThermometer;

public class ThermometerAdapter implements AcmeThermometer{

	VentoThermometer vt;
	
	public ThermometerAdapter(VentoThermometer ventoT) {
		vt = ventoT;
	}
	
	@Override
	public int getTemperature() {
		// TODO Auto-generated method stub
		return vt.getTemperature();
	}

}
