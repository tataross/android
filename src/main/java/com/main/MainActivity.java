package com.main;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity
{
    @Override
    protected void onCreate(final Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        final var text = new TextView(this);
        text.setText("hellow");
        setContentView(text);
    }
}
