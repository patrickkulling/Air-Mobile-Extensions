package de.patrickkulling.air.mobile.extensions.ambientlight.listener;

import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.util.Log;
import de.patrickkulling.air.mobile.extensions.ambientlight.AmbientLightContext;
import de.patrickkulling.air.mobile.extensions.ambientlight.events.AmbientLightStatus;

public class AmbientLightListener implements SensorEventListener
{
	private final AmbientLightContext context;

	public AmbientLightListener(AmbientLightContext context)
	{
		this.context = context;
	}

	public void onAccuracyChanged(Sensor sensor, int accuracy)
	{
		if (context != null)
		{
			try
			{
				context.dispatchStatusEventAsync(AmbientLightStatus.ACCURACY_CHANGE, Integer.toString(accuracy));
			} catch (IllegalArgumentException e)
			{
				Log.e("AmbientLightListener", "context is not available anymore.");
			}
		}
	}

	public void onSensorChanged(SensorEvent event)
	{
		if (context != null)
		{
			float lightLevel = event.values[0];

			try
			{
				context.dispatchStatusEventAsync(AmbientLightStatus.SENSOR_CHANGE, Float.toString(lightLevel));
			} catch (IllegalArgumentException e)
			{
				Log.e("AmbientLightListener", "context is not available anymore.");
			}
		}
	}
}