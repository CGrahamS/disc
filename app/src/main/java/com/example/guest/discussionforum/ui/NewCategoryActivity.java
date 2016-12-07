package com.example.guest.discussionforum.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
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

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

public class NewCategoryActivity extends AppCompatActivity implements View.OnClickListener {

    @Bind(R.id.addCategoryButton) Button mAddCategoryButton;
    @Bind(R.id.categoryDescriptionEditText) EditText mCategoryDescriptionEditText;
    @Bind(R.id.categoryNameEditText) EditText mCategoryNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {



        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_category);
        ButterKnife.bind(this);
        mAddCategoryButton.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if(v == mAddCategoryButton) {
            String categoryName = mCategoryNameEditText.getText().toString();
            String categoryDescription = mCategoryDescriptionEditText.getText().toString();
            Category mCategory = new Category(categoryName, categoryDescription);
            DatabaseReference categoriesReference = FirebaseDatabase
                    .getInstance()
                    .getReference()
                    .child(Constants.FIREBASE_CHILD_CATEGORY_TO_ADD);
            DatabaseReference ref = categoriesReference.push();
            String categoryId = ref.getKey();
            mCategory.setId(categoryId);
            ref.setValue(mCategory);
            mCategoryNameEditText.setText("");
            mCategoryDescriptionEditText.setText("");
            Toast.makeText(NewCategoryActivity.this, "Saved", Toast.LENGTH_SHORT).show();
        }
    }
}
