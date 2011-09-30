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
package de.patrickkulling.air.mobile.extensions.toast.functions;

import android.widget.Toast;

import com.adobe.fre.FREContext;
import com.adobe.fre.FREFunction;
import com.adobe.fre.FREInvalidObjectException;
import com.adobe.fre.FREObject;
import com.adobe.fre.FRETypeMismatchException;
import com.adobe.fre.FREWrongThreadException;

public class ShowToastMessage implements FREFunction
{
	public FREObject call(FREContext context, FREObject[] params)
	{
		String message = getMessage(params[0]);
		int toastType = getToastType(params[1]);

		if (message != null)
		{
			Toast toast = Toast.makeText(context.getActivity(), message, toastType);

			toast.show();
		}

		return null;
	}

	protected String getMessage(FREObject messageObject)
	{
		String message = null;

		try
		{
			message = messageObject.getAsString();
		} catch (IllegalStateException e)
		{
			e.printStackTrace();
		} catch (FRETypeMismatchException e)
		{
			e.printStackTrace();
		} catch (FREInvalidObjectException e)
		{
			e.printStackTrace();
		} catch (FREWrongThreadException e)
		{
			e.printStackTrace();
		}

		return message;
	}

	protected int getToastType(FREObject toastTypeObject)
	{
		try
		{
			boolean isLongToastType = toastTypeObject.getAsBool();

			if (isLongToastType == true)
				return Toast.LENGTH_LONG;

		} catch (IllegalStateException e)
		{
			e.printStackTrace();
		} catch (FRETypeMismatchException e)
		{
			e.printStackTrace();
		} catch (FREInvalidObjectException e)
		{
			e.printStackTrace();
		} catch (FREWrongThreadException e)
		{
			e.printStackTrace();
		}

		return Toast.LENGTH_SHORT;
	}
}