AIR Mobile Extensions
==================

These libraries provides different AIR 3 Native Extension adapters for the Android platform.

**Use cases:**

- Extending the AIR API with additional hardware features of Android device
- Using services which can't be accessed via the AIR API itself

**Dependencies**

- Android 2.2 (API Level 8)
- AIR 3.0 SDK RC1

Usage
-----

**Download**

Download the prefered Extension from the Extension_Android_*_Interface directory of the extension. I've also added the source files from native code in case you want to change the implementation for yourself.

**Installation**

* Copy the '.swc' file from the /build folder into your library folder and add it to your project classpath.
* Copy the '.ane' file from the /build folder into your project folder 
* Add the content of the 'descriptor_extensions.xml' into your application-descriptor.xml file

**Usage**

After adding the.swc file to your project path you've access to the containing classes. The implementation of the different services is straight forwarded and orients oneself by the Adobe AIR API of the Geolocation and Accelerometer class.

In case you want to check whether a service is available or not you should use the static method isSupported before initializing the instance.

E.g.

	if (VibratorService.isSupported())
	{
		var service : VibratorService = new VibratorService();
		service.vibrate(200);
	}

**Packaging**

Make sure you've added the .ane files during the packaging process of your .apk file.

E.g. via ANT

	<arg value="-extdir" />
	<arg value="/ane-dir" />


Change log
----------
* **[Added]** Ambient Light Service
* **[Added]** Orientation Service
* **[Added]** Proximity Service
* **[Added]** Vibrator Service 

Roadmap
-------
- Add additional Documentation of each service

- Add Unit Tests
- Add more functionality to the Vibrator Service (cancel, repeat)
- Add additional sensor support

Bugs/Todo
-------
- Fix an issue, when one service is created more than once