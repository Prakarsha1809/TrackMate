package com.rtls.trackmate.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.rtls.trackmate.R;
import com.orhanobut.hawk.Hawk;

import androidx.appcompat.app.AppCompatActivity;

public class AboutActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE_NAME = "com.rtls.trackmate.SENDNAME";
    public static final String EXTRA_MESSAGE_EMAIL = "com.rtls.trackmate.SENDEMAIL";

    private String name;
    private String email;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.about_page);

        Intent intent = getIntent();
        name = intent.getStringExtra(MainMenuActivity.EXTRA_MESSAGE_NAME);
        email = intent.getStringExtra(MainMenuActivity.EXTRA_MESSAGE_EMAIL);

        // Reset tutorial in main menu
        Boolean skipMainMenuTutorial = false;
        Hawk.put("skipMainMenuTutorial", skipMainMenuTutorial);
        //*Back Button//
        final ImageButton buttonBack = (ImageButton) findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        //END OF: Back Button--//
        Button buttonContact = (Button) findViewById(R.id.buttonContact);
        buttonContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), ContactUsActivity.class);
                i.putExtra(EXTRA_MESSAGE_NAME, name);
                i.putExtra(EXTRA_MESSAGE_EMAIL, email);
                startActivity(i);
            }
        });

        //Button buttonManual = (Button) findViewById(R.id.buttonManual);
//        buttonManual.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent browserIntent = new Intent(
//                        Intent.ACTION_VIEW,
//                        Uri.parse("https://firebasestorage.googleapis.com/v0/b/myjadytrack.appspot.com/o/AndroidUserManual.pdf?alt=media&token=e44a6b4a-d3be-4f0e-bf11-69f6343030b9"));
//                startActivity(browserIntent);
//            }
//        });
    }
}
