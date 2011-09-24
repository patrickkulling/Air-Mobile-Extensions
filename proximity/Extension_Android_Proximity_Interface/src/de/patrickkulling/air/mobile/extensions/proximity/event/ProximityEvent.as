package de.patrickkulling.air.mobile.extensions.proximity.event
{
	import flash.events.Event;

	public class ProximityEvent extends Event
	{
		public static const UPDATE : String = "ProximityEvent.UPDATE";
		
		private var _distance : Number;
		private var _accuracy : int;

		public function ProximityEvent(type : String, distance : Number, accuracy : int, bubbles : Boolean = false, cancelable : Boolean = false)
		{
			super(type, bubbles, cancelable);

			_distance = distance;

			_accuracy = accuracy;
		}

		public function get distance() : Number
		{
			return _distance;
		}
		
		public function get accuracy() : int
		{
			return _accuracy;
		}

		public override function clone() : Event
		{
			return new ProximityEvent(type, _distance, _accuracy, bubbles, cancelable);
		}

	}
}