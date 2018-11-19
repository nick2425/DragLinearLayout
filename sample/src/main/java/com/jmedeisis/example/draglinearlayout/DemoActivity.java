package com.jmedeisis.example.draglinearlayout;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.jmedeisis.draglinearlayout.DragLinearLayout;

public class DemoActivity extends AppCompatActivity {

    int mIndexCount = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);

        final DragLinearLayout dragLinearLayout = findViewById(R.id.container);
        final TextView incrementTextView = findViewById(R.id.indexCountTV);

        findViewById(R.id.moveItemDownButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View child = dragLinearLayout.getChildAt(mIndexCount);
                dragLinearLayout.move(child, true);

            }
        });

        findViewById(R.id.moveItemUpButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                View child = dragLinearLayout.getChildAt(mIndexCount);
                dragLinearLayout.move(child, false);

            }
        });

        findViewById(R.id.upIndexButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mIndexCount = mIndexCount + 1;
                incrementTextView.setText(String.valueOf(mIndexCount));

            }
        });

        findViewById(R.id.downIndexButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                mIndexCount = mIndexCount - 1;
                incrementTextView.setText(String.valueOf(mIndexCount));

            }
        });

        // Set all children draggable except the first (the header)
        for(int i = 0; i < dragLinearLayout.getChildCount(); i++){

            View child = dragLinearLayout.getChildAt(i);
            dragLinearLayout.setViewDraggable(child, child); // the child is its own drag handle

        }

        findViewById(R.id.noteDemoButton).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                startActivity(new Intent(DemoActivity.this, NoteActivity.class));

            }
        });
    }
}
