package de.patrickkulling.air.mobile.extensions.orientation.event
{
	import flash.events.Event;

	public class OrientationEvent extends Event
	{
		public static const UPDATE : String = "OrientationEvent.UPDATE";
		
		private var _azimuth : Number;
		private var _pitch : Number;
		private var _roll : Number;
		private var _accuracy : int;

		public function OrientationEvent(type : String, azimuth : Number, pitch : Number, roll : Number, accuracy : int, bubbles : Boolean = false, cancelable : Boolean = false)
		{
			super(type, bubbles, cancelable);

			_azimuth = azimuth;
			_pitch = pitch;
			_roll = roll;

			_accuracy = accuracy;
		}

		public function get azimuth() : Number
		{
			return _azimuth;
		}

		public function get pitch() : Number
		{
			return _pitch;
		}

		public function get roll() : Number
		{
			return _roll;
		}

		public function get accuracy() : int
		{
			return _accuracy;
		}

		public override function clone() : Event
		{
			return new OrientationEvent(type, _azimuth, _pitch, _roll, _accuracy, bubbles, cancelable);
		}
	}
}