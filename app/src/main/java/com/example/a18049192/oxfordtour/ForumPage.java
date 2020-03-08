package com.example.a18049192.oxfordtour;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class ForumPage extends AppCompatActivity {

    TextView faq;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum_page);
        faq = findViewById(R.id.FAQText);

        faq.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), FAQPage.class);
                startActivity(intent);
            }
        });
    }
}
