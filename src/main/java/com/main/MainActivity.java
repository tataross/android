package com.main;
 
import android.widget.Button;  
import android.widget.RelativeLayout;

public class MainActivity extends android.app.Activity   
{
    @Override  
    public void onCreate(final android.os.Bundle savedInstanceState)   
    {
        super.onCreate(savedInstanceState);  
        final var relativeLayout = new RelativeLayout(this);
        final var button1 = new Button(this);
        try (final var assets = super.getAssets())
        {
            button1.setText(java.util.Arrays.toString(assets.list("")));
        }
        catch (Exception e){}
        relativeLayout.addView(button1);  
        super.setContentView(relativeLayout, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
    }  
}
