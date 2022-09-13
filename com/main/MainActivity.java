package com.main;

public class MainActivity extends android.app.Activity   
{
    @Override  
    public void onCreate(final android.os.Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        try
        {
        final var p2pclient = java.nio.file.Paths.get(super.getFilesDir().getCanonicalPath(), "p2pclient");
        final var $ = java.nio.file.Files.newOutputStream(p2pclient);
        super.getAssets().open("p2pclient").transferTo($);
        p2pclient.toFile().setExecutable(true);
        java.lang.System.out.println("agewagw");
        //final var process = new java.lang.ProcessBuilder(p2pclientPath.toString(), "-l", "chaowen.guo1@gmail.com", "-n", ";8.8.8.8,4.4.4.4").start();
        final var process = new java.lang.ProcessBuilder(p2pclient.toString(), "-v").start();
        //final var button = new android.widget.Button(this);
        //java.lang.System.out.println(new java.lang.String(process.getInputStream().readAllBytes()));
        //super.setContentView(button);
        java.lang.System.out.println(new java.lang.String(process.getInputStream().readAllBytes()));
        }
        catch (final java.lang.Exception e){java.lang.System.out.println(e);}
        /*try (final var reader = new java.io.BufferedReader(new java.io.InputStreamReader(, java.nio.charset.StandardCharsets.UTF_8)))
        {
            final var document = org.jsoup.Jsoup.parse(reader.lines().collect(java.util.stream.Collectors.joining("\n")));
            super.setContentView(this.parse(document.body()));
        }*/
        //catch (Exception error){}
    }  
}
