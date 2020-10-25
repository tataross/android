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
        try (final var reader = new java.io.BufferedReader(new javs.io.InputStreamReader(this.getAssets().open("file.txt"), java.nio.charset.StandardCharsets.UTF_8)))
        {
            button.setText(reader.lines().collect(java.util.stream.Collectors.joining("\n")));
        }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        /*try (final var assets = super.getAssets())
        {
            button1.setText(java.util.Arrays.toString(assets.list("")));
        }
        catch (Exception e){}*/
        body.addView(button);  
        super.setContentView(body, new ConstraintLayout.LayoutParams(ConstraintLayout.LayoutParams.MATCH_PARENT, ConstraintLayout.LayoutParams.MATCH_PARENT));
    }  
}
