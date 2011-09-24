package de.patrickkulling.air.mobile.extensions.ambientlight;

import java.util.HashMap;
import java.util.Map;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;

import de.patrickkulling.air.mobile.extensions.ambientlight.functions.Initialize;
import de.patrickkulling.air.mobile.extensions.ambientlight.functions.IsSupported;
import de.patrickkulling.air.mobile.extensions.ambientlight.functions.StartAmbientLight;
import de.patrickkulling.air.mobile.extensions.ambientlight.functions.StopAmbientLight;
import de.patrickkulling.air.mobile.extensions.ambientlight.listener.AmbientLightListener;

public class AmbientLightContext extends FREContext
{
	private HashMap<String, FREFunction> availableFunctions;
	
	public SensorManager sensorManager;
	public Sensor ambientLightSensor;
	public AmbientLightListener ambientLightListener;

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
		availableFunctions.put("startAmbientLight", new StartAmbientLight());
		availableFunctions.put("stopAmbientLight", new StopAmbientLight());
		
		return availableFunctions;
	}
}