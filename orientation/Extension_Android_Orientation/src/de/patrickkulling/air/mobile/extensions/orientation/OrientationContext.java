package de.patrickkulling.air.mobile.extensions.orientation;

import java.util.HashMap;
import java.util.Map;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

import de.patrickkulling.air.mobile.extensions.orientation.functions.Initialize;
import de.patrickkulling.air.mobile.extensions.orientation.functions.IsSupported;
import de.patrickkulling.air.mobile.extensions.orientation.functions.StartOrientation;
import de.patrickkulling.air.mobile.extensions.orientation.functions.StopOrientation;
import de.patrickkulling.air.mobile.extensions.orientation.listener.OrientationListener;

public class OrientationContext extends FREContext
{
	private HashMap<String, FREFunction> availableFunctions;
	
	public SensorManager sensorManager;
	public Sensor orientationSensor;
	public OrientationListener orientationListener;

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
		availableFunctions.put("startOrientation", new StartOrientation());
		availableFunctions.put("stopOrientation", new StopOrientation());
		
		return availableFunctions;
	}
}