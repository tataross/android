package com.main;
 
import android.widget.Button;  
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends android.app.Activity   
{
    @Override  
    public void onCreate(final android.os.Bundle savedInstanceState)   
    {
        super.onCreate(savedInstanceState);  
        var relativeLayout = new ConstraintLayout(this);  
        var relativeLayoutParams = new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT);  
        var button1 = new Button(this);  
        button1.setText("Button1");  
        relativeLayout.addView(button1);
        super.setContentView(relativeLayout, relativeLayoutParams);
    } 
}
