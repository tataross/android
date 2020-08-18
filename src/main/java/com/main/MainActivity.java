package com.main;

import android.app.Activity;  
import android.os.Bundle;  
import android.widget.Button;  
import android.widget.RelativeLayout;  
import android.content.ContentValues;  
import android.content.Context;  
import android.database.Cursor;  
import android.database.sqlite.SQLiteDatabase;  
import android.database.sqlite.SQLiteOpenHelper;  
import android.graphics.Color;  
import android.os.Bundle;  
import android.app.Activity;  
import android.view.Menu;  
import android.widget.Button;  
import android.widget.RelativeLayout;

public class MainActivity extends Activity   
{
    @Override  
    public void onCreate(Bundle savedInstanceState)   
    {
        super.onCreate(savedInstanceState);  
        RelativeLayout relativeLayout = new RelativeLayout(this);  
        RelativeLayout.LayoutParams relativeLayoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.FILL_PARENT, RelativeLayout.LayoutParams.FILL_PARENT);  
        Button button1 = new Button(this);  
        button1.setText("Button1");  
        Button button2 = new Button(this);  
        button2.setText("Button2");  
        Button button3 = new Button(this);  
        button3.setText("Button3");  
        Button button4 = new Button(this);  
        button4.setText("Button4");  
        AddButtonLayout(button1, RelativeLayout.ALIGN_PARENT_LEFT);  
        AddButtonLayout(button3, RelativeLayout.CENTER_IN_PARENT);  
        AddButtonLayout(button4, RelativeLayout.ALIGN_PARENT_BOTTOM);  
        LayoutAddButton(button2, RelativeLayout.ALIGN_PARENT_LEFT, 30, 80, 0, 0);  
        relativeLayout.addView(button1);  
        relativeLayout.addView(button3);  
        relativeLayout.addView(button4);  
        relativeLayout.addView(button2);  
        setContentView(relativeLayout, relativeLayoutParams);
    }  
    private void LayoutAddButton(Button button, int centerInParent, int marginLeft, int marginTop, int marginRight, int marginBottom)   
    {
        RelativeLayout.LayoutParams buttonLayoutParameters = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);  
        buttonLayoutParameters.setMargins(marginLeft, marginTop, marginRight, marginBottom);  
        buttonLayoutParameters.addRule(centerInParent);  
        button.setLayoutParams(buttonLayoutParameters);
    }  
    private void AddButtonLayout(Button button, int centerInParent)   
    {  
        LayoutAddButton(button, centerInParent, 0, 0, 0, 0);  
    }  
}
