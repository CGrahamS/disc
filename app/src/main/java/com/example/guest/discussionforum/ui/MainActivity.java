package com.example.guest.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.guest.discussionforum.Constants;
import com.example.guest.discussionforum.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mSavedCategories;
    @Bind(R.id.newCategoryButton) Button mNewCategoryButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        mSavedCategories = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_CATEGORY_TO_ADD);

        mSavedCategories.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot categorySnapshot: dataSnapshot.getChildren()) {
                    String category = categorySnapshot.getValue().toString();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        })

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mNewCategoryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mNewCategoryButton) {
            Intent intent = new Intent(MainActivity.this, NewCategoryActivity.class);
            startActivity(intent);
        }
    }
}
