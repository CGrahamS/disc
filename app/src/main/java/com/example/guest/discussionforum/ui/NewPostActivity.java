package com.example.guest.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.guest.discussionforum.Constants;
import com.example.guest.discussionforum.R;
import com.example.guest.discussionforum.models.Category;
import com.example.guest.discussionforum.models.Post;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewPostActivity extends AppCompatActivity implements View.OnClickListener {
    Category mCategory;
    @Bind(R.id.postTitleInput) EditText mPostTitleEditText;
    @Bind(R.id.postBodyInput) EditText mPostBodyEditText;
    @Bind(R.id.addPostButton) Button mAddPostButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_post);
        ButterKnife.bind(this);

        mCategory = Parcels.unwrap(getIntent().getParcelableExtra("category"));

        mAddPostButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mAddPostButton) {
            String title = mPostTitleEditText.getText().toString();
            String body = mPostBodyEditText.getText().toString();
            String parentCategory = mCategory.getName();
            Post post = new Post(title, body, parentCategory);
            DatabaseReference postsReference = FirebaseDatabase
                    .getInstance()
                    .getReference()
                    .child(Constants.FIREBASE_CHILD_POST_TO_ADD);
            postsReference.push().setValue(post);
            Toast.makeText(NewPostActivity.this, "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}
