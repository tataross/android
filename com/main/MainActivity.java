package com.main;
  
import android.widget.LinearLayout;

public class MainActivity extends android.app.Activity   
{
    /*private android.view.View parse(final org.jsoup.nodes.Element element)
    {
        if (element.childrenSize() == 0)
        {
            final var button = new android.widget.Button(this);
            button.setText(element.text());
            return button;
        }
        else
        {
            final var body = new LinearLayout(this);
            body.setOrientation(LinearLayout.VERTICAL);
            //body.setLayoutParams(new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT));
            for (final var $: element.children()) body.addView(this.parse($));
            return body;
        }
    }*/
    @Override  
    public void onCreate(final android.os.Bundle savedInstanceState)   
    {
        super.onCreate(savedInstanceState);  
        /*try (final var reader = new java.io.BufferedReader(new java.io.InputStreamReader(super.getAssets().open("index.html"), java.nio.charset.StandardCharsets.UTF_8)))
        {
            final var document = org.jsoup.Jsoup.parse(reader.lines().collect(java.util.stream.Collectors.joining("\n")));
            super.setContentView(this.parse(document.body()));
        }*/
        //catch (Exception error){}
        /*final var button = new android.widget.Button(this);
        button.setText("haha");
        super.setContentView(button);*/
        final var browserIntent = new android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse("https://www.google.com"));
        super.startActivity(browserIntent);
    }  
}
