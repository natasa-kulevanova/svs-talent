package com.ventoelectrics.waterheater;

import acme.AcmeEfficientThermoregulator;
import acme.AcmeStandardThermoregulator;
import vento.VentoHeater;
import vento.VentoPowerSwitch;
import vento.VentoThermometer;
import vento.VentoThermoregulator;

public class EfficientVentoWaterHeaterApp {

	public static void main(String[] args) throws Exception {

		final VentoThermometer ventoThermometer = new VentoThermometer();
		final VentoHeater ventoHeater = new VentoHeater();
		final VentoPowerSwitch ventoPowerSwitch = new VentoPowerSwitch();

		final HeaterAdapter heaterAdapter = new HeaterAdapter(ventoHeater);
		final ThermometerAdapter thermoAdapter = new ThermometerAdapter(ventoThermometer);
		
		final AcmeEfficientThermoregulator aeThermo = new AcmeEfficientThermoregulator(thermoAdapter, heaterAdapter);
		
		
		final VentoThermoregulator ventoThermoregulator = new ThermoregulatorAdapter(aeThermo);


		ventoPowerSwitch.controlPowerFor(ventoThermoregulator);
		ventoPowerSwitch.controlPowerFor(ventoHeater);
		ventoPowerSwitch.controlPowerFor(ventoThermometer);

		VentoWaterHeaterApp.run(ventoThermoregulator, ventoPowerSwitch);
	}
}
