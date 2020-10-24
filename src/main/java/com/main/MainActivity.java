package com.main;
 
import android.widget.Button;  
import android.widget.RelativeLayout;

public class MainActivity extends android.app.Activity   
{
    @Override  
    public void onCreate(final android.os.Bundle savedInstanceState)   
    {
        super.onCreate(savedInstanceState);  
        var relativeLayout = new RelativeLayout(this);  
        var relativeLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);  
        var button1 = new Button(this);  
        button1.setText("Button1");  
        var button2 = new Button(this);  
        button2.setText("Button2");  
        var button3 = new Button(this);  
        button3.setText("Button3");  
        var button4 = new Button(this);  
        button4.setText("Button4");  
        AddButtonLayout(button1, RelativeLayout.ALIGN_PARENT_LEFT);  
        AddButtonLayout(button3, RelativeLayout.CENTER_IN_PARENT);  
        AddButtonLayout(button4, RelativeLayout.ALIGN_PARENT_BOTTOM);  
        LayoutAddButton(button2, RelativeLayout.ALIGN_PARENT_LEFT, 30, 80, 0, 0);  
        relativeLayout.addView(button1);  
        relativeLayout.addView(button3);  
        relativeLayout.addView(button4);  
        relativeLayout.addView(button2);  
        super.setContentView(relativeLayout, relativeLayoutParams);
    }  
    private void LayoutAddButton(Button button, int centerInParent, int marginLeft, int marginTop, int marginRight, int marginBottom)   
    {
        var buttonLayoutParameters = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);  
        buttonLayoutParameters.setMargins(marginLeft, marginTop, marginRight, marginBottom);  
        buttonLayoutParameters.addRule(centerInParent);  
        button.setLayoutParams(buttonLayoutParameters);
    }  
    private void AddButtonLayout(Button button, int centerInParent)   
    {  
        LayoutAddButton(button, centerInParent, 0, 0, 0, 0);  
    }  
}
