package com.example.guest.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.guest.discussionforum.R;
import com.example.guest.discussionforum.models.Category;
import com.example.guest.discussionforum.models.Post;

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

        String title = mPostTitleEditText.getText().toString();
        String body = mPostBodyEditText.getText().toString();

        Post post = new Post(title, body);

        mAddPostButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v == mAddPostButton) {
            mCategory.add(post);
        }
    }
}
