package com.example.guest.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guest.discussionforum.R;
import com.example.guest.discussionforum.models.Category;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryDetailActivity extends AppCompatActivity {
    @Bind(R.id.categoryDetailNameTextView) TextView mCategoryName;
    @Bind(R.id.categoryDetailDescriptionTextView) TextView mCategoryDescription;
    @Bind(R.id.categoryDetailPostListView) ListView mPostList;
    Category mCategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_detail);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        mCategory = Parcels.unwrap(getIntent().getParcelableExtra("category"));
        mCategoryName.setText(mCategory.getName());
        mCategoryDescription.setText(mCategory.getDescription());

    }
}