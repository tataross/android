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
        try {
            final var is = this.getAssets().open("file.txt");
            final var size = is.available();
            final var buffer = new byte[size];
            is.read(buffer);
            is.close();
            button.setText(new String(buffer, "UTF-8"));
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
