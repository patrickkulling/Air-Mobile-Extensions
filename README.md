AIR Mobile Extensions
==================

These libraries provides different AIR 3 Native Extension adapters for the Android platform. _powered by_ [Powerflasher GmbH](http://www.powerflasher.com/)

**Use cases:**

- Extending the AIR API with additional hardware features of Android device
- Using services which can't be accessed via the AIR API itself


Available Native Extensions
-----

**Sensors**

* AmbientLight Sensor (Android)
* Barometer Sensor (Android)
* Gravity Sensor (Android)
* Gyroscope Sensor (Android)
* Magnetometer Sensor (Android)
* Orientation Sensor (Android)
* Proximity Sensor (Android)

**OS Features**

* Battery Status (Android)
* Toast Messages (Android)
* Vibrator Hardware (Android)
* Notifications (Android)

**Dependencies**

- Android 2.2 (API Level 8), some need Android 2.3.3 (API Level 9)
- AIR 3.0 SDK

Usage
-----

**Download**

Download the prefered Extension from the **Extension_Android _*_Interface** directory of the extension. I've also added the source files from native code in case you want to change the implementation for yourself.

**Installation**

* Copy the '.swc' file from the /extension folder into your library folder and add it to your project classpath.
* Copy the '.ane' file from the /extension folder into your project folder 
* Add the content of the 'descriptor_extensions.xml' into your application-descriptor.xml file
* Add all necessary permissions into your application-descriptor.xml file

**API Usage**

After adding the.swc file to your project path you've access to the containing classes. The implementation of the different services is straight forwarded and orients oneself by the Adobe AIR API of the Geolocation and Accelerometer class.

In case you want to check whether a service is available or not you should use the static method isSupported() before initializing the instance.

E.g.

	if (Vibrator.isSupported())
	{
		var vibrator : Vibrator = new Vibrator();
		vibrator.vibrate(200);
	}
	
	if (Proximity.isSupported())
	{
		proximity = new Proximity();
		proximity.setRequestedUpdateInterval(1000);
		proximity.addEventListener(ProximityEvent.UPDATE, handleProximityUpdate);
	}
	
You can dispose all Services via:

	proximity.dispose();
	
	
More information in the [wiki](https://github.com/patrickkulling/Air-Mobile-Extensions/wiki).

**Packaging**

Make sure you've added the .ane files during the packaging process of your .apk file.

E.g. via ANT

	<arg value="-extdir" />
	<arg value="/ane-dir" />


Change log
----------
**v 0.9**

* **[Added]** Notification Support (Android)

**v 0.8**

* **[Added]** Toast Messages (Android)
* **[Added]** Gravity Sensor (Android)

**v 0.7**

* **[Added]** Pressure/Barometer Sensor (Android)
* **[Added]** Magnetometer Sensor (Android)

**v 0.6**

* **[Added]** Battery status (Android)

**v 0.5**

* **[Added]** Gyroscope Sensor (Android)
* **[Added]** cancel() method for the Vibrator class

**v 0.4**

* **[Added]** getMaximumRange(), getPower() and getResolution() implementation for the Proximity, Orientation and AmbientLight sensors

**v 0.3**

* **[Modified]** Project structure (Android)

**v 0.2**

* **[Fix]** Now each Sensor can be initiated multiple times, e.g. to use different intervals to retrieved sensor updates
* **[Modified]** Renamed all *Service classes into *, e.g. ProximityService > Proximity

**v 0.1**

* **[Added]** Ambient Light Sensor (Android)
* **[Added]** Orientation Sensor (Android)
* **[Added]** Proximity Sensor (Android)
* **[Added]** Vibrator Service (Android)

Roadmap
-------
- Add additional Documentation of each service

- Add Unit Tests

- Add equivalent iOS implementations