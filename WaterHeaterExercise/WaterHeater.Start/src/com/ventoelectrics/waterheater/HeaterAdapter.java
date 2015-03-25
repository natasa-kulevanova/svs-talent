package com.ventoelectrics.waterheater;

import vento.VentoHeater;
import acme.AcmeHeater;

public class HeaterAdapter implements AcmeHeater{

	VentoHeater vh;
	public HeaterAdapter(VentoHeater ventoH) {
		vh = ventoH;
	}
	
	@Override
	public void enable() {
		vh.enable();
		
	}

	@Override
	public void disable() {
		vh.disable();
	}

}
