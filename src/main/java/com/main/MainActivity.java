package com.main;
 
import android.widget.TextView;  
import android.widget.ConstraintLayout;

public class MainActivity extends android.app.Activity   
{
    @Override  
    public void onCreate(final android.os.Bundle savedInstanceState)   
    {
        super.onCreate(savedInstanceState);  
        final var body = new ConstraintLayout(this);
        final var text = new TextView(this);
        body.addView(button1);  
        super.setContentView(body, new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT));
    }
}
