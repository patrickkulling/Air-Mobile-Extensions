package de.patrickkulling.air.mobile.extensions.battery.event
{
	import flash.events.Event;

	public class BatteryEvent extends Event
	{
		public static const UPDATE : String = "BatteryEvent.UPDATE";
		
		private var _level : Number;
		private var _scale : Number;
		private var _temperature : Number;
		private var _voltage : Number;

		public function BatteryEvent(type : String, level : Number, scale : Number, temperature : Number, voltage : Number)
		{
			super(type, false, false);
			
			_level = level;
			_scale = scale;
			_voltage = voltage;
			_temperature = temperature;
		}

		public function get level() : Number
		{
			return _level;
		}

		public function get scale() : Number
		{
			return _scale;
		}

		public function get temperature() : Number
		{
			return _temperature;
		}

		public function get voltage() : Number
		{
			return _voltage;
		}
	}
}