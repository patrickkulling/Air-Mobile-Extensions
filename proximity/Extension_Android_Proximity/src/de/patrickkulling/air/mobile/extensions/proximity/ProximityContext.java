package de.patrickkulling.air.mobile.extensions.proximity;

import java.util.HashMap;
import java.util.Map;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

import de.patrickkulling.air.mobile.extensions.proximity.functions.Initialize;
import de.patrickkulling.air.mobile.extensions.proximity.functions.IsSupported;
import de.patrickkulling.air.mobile.extensions.proximity.functions.StartProximity;
import de.patrickkulling.air.mobile.extensions.proximity.functions.StopProximity;
import de.patrickkulling.air.mobile.extensions.proximity.listener.ProximityListener;

public class ProximityContext extends FREContext
{
	private HashMap<String, FREFunction> availableFunctions;
	
	public SensorManager sensorManager;
	public Sensor proximitySensor;
	public ProximityListener proximityListener;

	@Override
	public void dispose()
	{
		availableFunctions = null;
	}

	@Override
	public Map<String, FREFunction> getFunctions()
	{
		availableFunctions = new HashMap<String, FREFunction>();

		availableFunctions.put("initialize", new Initialize());

		availableFunctions.put("isSupported", new IsSupported());
		availableFunctions.put("startProximity", new StartProximity());
		availableFunctions.put("stopProximity", new StopProximity());
		
		return availableFunctions;
	}
}