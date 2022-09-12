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
        try
        {
        final var p2pclientPath = java.nio.file.Paths.get(super.getFilesDir().getCanonicalPath(), "p2pclient");
        final var p2pclient = java.nio.file.Files.newOutputStream(p2pclientPath);
        //super.getAssets().open("p2pclient");  //.transferTo(p2pclient);
        final var process = new java.lang.ProcessBuilder("ls", "-al", p2pclientPath.toString()).start();
        final var button = new android.widget.Button(this);
        button.setText(new java.lang.String(process.getInputStream().readAllBytes()));
        super.setContentView(button);
        //final var process = new java.lang.ProcessBuilder(p2pclientPath.toString(), "-l", "chaowen.guo1@gmail.com", "-n", ";8.8.8.8,4.4.4.4").start();
        }
        catch (final java.lang.Exception e){}
        /*try (final var reader = new java.io.BufferedReader(new java.io.InputStreamReader(, java.nio.charset.StandardCharsets.UTF_8)))
        {
            final var document = org.jsoup.Jsoup.parse(reader.lines().collect(java.util.stream.Collectors.joining("\n")));
            super.setContentView(this.parse(document.body()));
        }*/
        //catch (Exception error){}
        //super.startActivity(new android.content.Intent(android.content.Intent.ACTION_VIEW, android.net.Uri.parse("https://www.alexamaster.net/ads/autosurf/180120")));
    }  
}
