package de.patrickkulling.air.mobile.extensions.vibrator
{
	import flash.external.ExtensionContext;

	public class VibratorService
	{
		private static const EXTENSION_ID : String = "de.patrickkulling.air.mobile.extensions.vibrator";

		private static var context : ExtensionContext;

		public function VibratorService()
		{
			initContext();
		}

		public static function isSupported() : Boolean
		{
			if (context == null)
				initContext();

			return context.call("isSupported") as Boolean;;
		}

		public function vibrate(duration : int) : void
		{
			if (context == null)
				initContext();
				
			context.call("vibrate", duration);
		}

		private static function initContext() : void
		{
			context = ExtensionContext.createExtensionContext(EXTENSION_ID, null);

			context.call("initialize");
		}
	}
}
