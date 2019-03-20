package com.anshumansekhar.objectclassification;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;

import com.anshumansekhar.objectclassification.R;

public class LanguageChooseActivity extends Activity {
    String language;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_language_choose);

        CharSequence options[] = new CharSequence[] {"English", "Odia","Hindi"};

        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(false);
        builder.setTitle("Choose your Language");
        builder.setItems(options, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // the user clicked on options[which]
                switch (which){
                    case 0:language="en";break;
                    case 1:language="or";break;
                    case 2:language="hi";break;
                }
                Intent intent=new Intent(LanguageChooseActivity.this, CameraActivity.class);
                intent.putExtra("code",language);
                startActivity(intent);
                finish();
            }
        });
        builder.setNegativeButton("cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        builder.show();
    }
}
