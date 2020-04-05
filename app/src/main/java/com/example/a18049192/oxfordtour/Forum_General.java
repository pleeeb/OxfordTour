package com.example.a18049192.oxfordtour;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.InputType;
import android.text.Spanned;
import android.text.TextWatcher;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputLayout;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.Arrays;

public class Forum_General extends AppCompatActivity {

    static ArrayList<String> topics = new ArrayList<>(Arrays.asList("How can I get directions to the restaurants on the map?","How do I logout?"));
    static ArrayList<String> user = new ArrayList<>(Arrays.asList("Pete", "Dan"));
    PopupWindow popUp;
    LinearLayout layout;
    EditText input;
    Button submit;
    boolean click = true;
    static TableLayout tbl;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forum__general);
        popUp = new PopupWindow(tbl, TableRow.LayoutParams.WRAP_CONTENT, TableRow.LayoutParams.WRAP_CONTENT, true);
        layout = new LinearLayout(this);
        input = new EditText(this);
        input.setBackgroundColor(Color.WHITE);
        input.setText("");
        input.setEnabled(true);
        input.setInputType(InputType.TYPE_TEXT_FLAG_MULTI_LINE);
        input.setHorizontallyScrolling(false);
        input.setMinLines(5);
        input.setMaxLines(5);
        input.setFilters(new InputFilter[] {new InputFilter.LengthFilter(215)});



        submit = new Button(this);
        submit.setText("Submit");

        layout.setOrientation(LinearLayout.VERTICAL);
        layout.addView(input);
        layout.addView(submit);
        popUp.setContentView(layout);


        tbl = new TableLayout(getApplicationContext());
        TableRow tablerow;
        TextView content;
        TextView ucontent;

        for(int i=0; i<topics.size(); i++){
            tablerow = new TableRow(getApplicationContext());
            content = new TextView(getApplicationContext());
            content.setText(topics.get(i));
            content.setTextColor(Color.BLUE);
            content.setPadding(5,5,5,10);
            ucontent = new TextView(getApplicationContext());
            ucontent.setText(user.get(i));
            ucontent.setPadding(5,5,5,10);
            tablerow.addView(content);
            tablerow.addView(ucontent);
            tbl.addView(tablerow);
        }
        Button createTopic = new Button(getApplicationContext());
        createTopic.setText("Create Post");
        tablerow = new TableRow(getApplicationContext());
        tablerow.addView(createTopic);
        tbl.addView(tablerow);

        setContentView(tbl);

        createTopic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (click){
                    popUp.showAtLocation(tbl, Gravity.CENTER, 10, 10);
                    popUp.update(50,50, tbl.getWidth(), tbl.getHeight());

                    click = false;
                }
                else{
                    popUp.dismiss();
                    click = true;
                }
            }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                click = true;
                topics.add(input.getText().toString());
                user.add(Signup.firstname);
                popUp.dismiss();
                tbl.removeAllViews();
                recreate();
            }
        });

    }
}


