package com.main;
 
import android.widget.TextView;  
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends android.app.Activity   
{
    @Override  
    public void onCreate(final android.os.Bundle savedInstanceState)   
    {
        super.onCreate(savedInstanceState);  
        final var body = new ConstraintLayout(this);
        final var text = new TextView(this);
        text.setText(new BufferedReader(new java.io.InputStreamReader(super.getAsserts().open("file.txt"), java.nio.charset.StandardCharset.UTF_8))).lines().collect(Collectors.joining("\n")));
        body.addView(text);  
        super.setContentView(body, new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT));
    }                
}
