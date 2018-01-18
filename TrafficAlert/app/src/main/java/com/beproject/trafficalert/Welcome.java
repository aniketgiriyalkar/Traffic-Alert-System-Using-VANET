package com.beproject.trafficalert;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Welcome extends AppCompatActivity {

    private Button log_out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        log_out = (Button)findViewById(R.id.logout);
        log_out.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                 startActivity(new Intent(getApplicationContext(),MainActivity.class));
            }
        });
    }
    public void onwebsiteclick(View view)
    {
        Intent browserIntent=new Intent(Intent.ACTION_VIEW, Uri.parse("http://traffalert.netau.net/website/page1new.html"));
        startActivity(browserIntent);

    }
    public void onbuttonclick(View view)
    {
        String button_text;
        button_text = ((Button) view).getText().toString();
        if (button_text.equals("Google Maps"))
        {
            Intent intent = new Intent(this,MapsActivity.class);
            startActivity(intent);
        }
        else if (button_text.equals("Notifications"))
        {
            Intent intent = new Intent(this,Notifications.class);
            startActivity(intent);
        }
        else if (button_text.equals("Emergency Numbers"))
        {
            Intent intent = new Intent(this,ContactUs.class);
            startActivity(intent);
            }
    }

}
