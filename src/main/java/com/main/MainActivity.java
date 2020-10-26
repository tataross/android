package com.main;
  
import androidx.constraintlayout.widget.ConstraintLayout;

public class MainActivity extends android.app.Activity   
{
    private android.view.View parse(final org.jsoup.nodes.Element element)
    {
        if (element.childrenSize() == 0)
        {
            final var button = new android.widget.Button(this);
            button.setText(element.text());
            return button;
        }
        else
        {
            final var body = new ConstraintLayout(this);
            body.setLayoutParams(ConstraintLayout);
            for (final var $: element.children()) body.addView(this.parse($));
            return body;
        }
    }
    @Override  
    public void onCreate(final android.os.Bundle savedInstanceState)   
    {
        super.onCreate(savedInstanceState);  
        try (final var reader = new java.io.BufferedReader(new java.io.InputStreamReader(super.getAssets().open("index.html"), java.nio.charset.StandardCharsets.UTF_8)))
        {
            final var document = org.jsoup.Jsoup.parse(reader.lines().collect(java.util.stream.Collectors.joining("\n")));
            super.setContentView(this.parse(document.body()));
        }
        catch (Exception error){} 
    }  
}
