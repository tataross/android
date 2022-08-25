package com.main;

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
        try
        {
            //final var ls = new java.lang.ProcessBuilder("ls", "-al", "/data/data/com.main").start();
            final var button = new android.widget.Button(this);
            //button.setText(new java.lang.String(ls.getInputStream().readAllBytes()));
            button.setText(this.getFilesDir().getCanonicalPath());
            super.setContentView(button);
        }
        catch (java.lang.Exception e){}
        //super.startActivity(new android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse("https://www.alexamaster.net/ads/autosurf/180120")));
    }  
}
