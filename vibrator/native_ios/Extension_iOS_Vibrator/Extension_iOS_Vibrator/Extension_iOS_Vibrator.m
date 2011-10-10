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

#import "Extension_iOS_Vibrator.h"


void contextInitializer(void* extensionData, const uint8_t* contextType, FREContext context, uint32_t* availableFunctionsLength, const FRENamedFunction** availableFunctions);

void contextFinalizer(FREContext context);

long const FUNCTION_LENGTH = 4;

@implementation Extension_iOS_Vibrator

void extensionInitializer(void** extensionData, FREContextInitializer* pContextInitializer, 
                    FREContextFinalizer* pContextFinalizer) 
{    
    
    *extensionData = NULL;
    *pContextInitializer = &contextInitializer;
    *pContextFinalizer = &contextFinalizer;
}


void extensionFinalizer(void* extensionData) 
{    
    return;
}

void contextInitializer(void* extensionData, const uint8_t* contextType, FREContext context, 
						uint32_t* availableFunctionsLength, const FRENamedFunction** availableFunctions) {
    
	*availableFunctionsLength = FUNCTION_LENGTH;
    
	FRENamedFunction* functions = (FRENamedFunction*) malloc(sizeof(FRENamedFunction) * FUNCTION_LENGTH);
   
    functions[0].name = (const uint8_t*) "initialize";
	functions[0].functionData = NULL;
	functions[0].function = &initialize;
    
	functions[1].name = (const uint8_t*) "isSupported";
	functions[1].functionData = NULL;
    functions[1].function = &isSupported;
	
	functions[2].name = (const uint8_t*) "vibrate";
	functions[2].functionData = NULL;
	functions[2].function = &vibrate;
    
    functions[3].name = (const uint8_t*) "cancel";
	functions[3].functionData = NULL;
	functions[3].function = &cancel;
	
	*availableFunctions = functions;
}

void contextFinalizer(FREContext context) 
{
	return;
}

@end