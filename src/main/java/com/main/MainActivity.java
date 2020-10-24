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
        try (final var reader = new java.io.BufferedReader(new java.io.InputStreamReader(super.getAssets().open("file.txt"), java.nio.charset.StandardCharsets.UTF_8)))
        {
            button1.setText(reader.lines().collect(java.util.stream.Collectors.joining("\n")));
        }
        catch (Exception error){}          
        relativeLayout.addView(button1);  
        super.setContentView(relativeLayout, new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT));
    }  
}
