package com.main;
/*https://developer.android.com/studio/build/application-id
And although the application ID looks like a traditional Java package name, the naming rules for the application ID are a bit more restrictive:

It must have at least two segments (one or more dots).
Each segment must start with a letter.
All characters must be alphanumeric or an underscore [a-zA-Z0-9_].*/

import android.app.Activity;
import android.os.Bundle;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}
