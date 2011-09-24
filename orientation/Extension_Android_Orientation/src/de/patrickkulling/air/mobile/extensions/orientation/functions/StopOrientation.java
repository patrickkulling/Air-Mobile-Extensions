/*
 * Copyright (c) 2011 Patrick Kulling
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 */
package de.patrickkulling.air.mobile.extensions.orientation.functions;

import android.hardware.Sensor;
import android.hardware.SensorManager;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREObject;

import de.patrickkulling.air.mobile.extensions.orientation.OrientationContext;
import de.patrickkulling.air.mobile.extensions.orientation.listener.OrientationListener;

public class StopOrientation implements FREFunction
{
	public FREObject call(FREContext context, FREObject[] params)
	{
		OrientationContext orientationContext = (OrientationContext) context;

		SensorManager sensorManager = orientationContext.sensorManager;
		Sensor orientationSensor = orientationContext.orientationSensor;
		OrientationListener orientationListener = orientationContext.orientationListener;

		if (orientationSensor != null)
			sensorManager.unregisterListener(orientationListener, orientationSensor);

		return null;
	}
}