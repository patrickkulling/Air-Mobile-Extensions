package de.patrickkulling.air.mobile.extensions.ambientlight.event
{
	import flash.events.Event;

	public class AmbientLightEvent extends Event
	{
		public static const UPDATE : String = "AmbientLight.UPDATE";
		
		private var _lightLevel : Number;
		private var _accuracy : int;

		public function AmbientLightEvent(type : String, lightLevel : Number, accuracy : int, bubbles : Boolean = false, cancelable : Boolean = false)
		{
			super(type, bubbles, cancelable);

			_lightLevel = lightLevel;

			_accuracy = accuracy;
		}

		public function get lightLevel() : Number
		{
			return _lightLevel;
		}
		
		public function get accuracy() : int
		{
			return _accuracy;
		}

		public override function clone() : Event
		{
			return new AmbientLightEvent(type, _lightLevel, _accuracy, bubbles, cancelable);
		}

	}
}