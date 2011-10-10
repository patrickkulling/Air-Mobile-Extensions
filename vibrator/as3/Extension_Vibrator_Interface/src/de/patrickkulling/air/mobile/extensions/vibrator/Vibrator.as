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
package de.patrickkulling.air.mobile.extensions.vibrator
{
	import flash.external.ExtensionContext;

	public class Vibrator
	{
		protected static const EXTENSION_ID : String = "de.patrickkulling.air.mobile.extensions.vibrator";

		protected static var context : ExtensionContext;
		protected static var referenceCount : int = 0;

		public function Vibrator()
		{
			if (context == null)
				initContext();

			referenceCount++;
		}

		public static function isSupported() : Boolean
		{
			var isVibratorSupported : Boolean = false;

			var localContext : ExtensionContext = ExtensionContext.createExtensionContext(EXTENSION_ID, null);

			if (localContext != null)
			{
				localContext.call("initialize");

				isVibratorSupported = localContext.call("isSupported") as Boolean;

				localContext.dispose();
				localContext = null;
			}

			return isVibratorSupported;
		}

		public function vibrate(duration : int) : void
		{
			if (context == null)
				return;

			context.call("vibrate", duration);
		}

		public function cancel() : void
		{
			if (context == null)
				return;

			context.call("cancel");
		}

		public function dispose() : void
		{
			if (context == null)
				return;

			referenceCount--;

			if (referenceCount < 0)
				referenceCount = 0;

			if (referenceCount == 0)
			{
				context.dispose();
				context = null;
			}
		}

		protected static function initContext() : void
		{
			context = ExtensionContext.createExtensionContext(EXTENSION_ID, null);

			context.call("initialize");
		}
	}
}