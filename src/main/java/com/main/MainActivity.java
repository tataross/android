package com.main;
 
import android.widget.Button;  
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends android.app.Activity   
{
    @Override  
    public void onCreate(final android.os.Bundle savedInstanceState)   
    {
        super.onCreate(savedInstanceState);  
        final var body = new ConstraintLayout(this);
        final var button = new Button(this);
        try (final var reader = new java.io.BufferedReader(new java.io.InputStreamReader(super.getAssets().open("index.html"), java.nio.charset.StandardCharsets.UTF_8)))
        {
            final var document = org.jsoup.Jsoup.parse(reader.lines().collect(java.util.stream.Collectors.joining("\n")));
            button.setText(document.body.html());
        }
        catch (Exception error) {}
        body.addView(button);  
        super.setContentView(body, new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT));
    }  
}
