package com.example.guest.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guest.discussionforum.Constants;
import com.example.guest.discussionforum.R;
import com.example.guest.discussionforum.models.Category;
import com.example.guest.discussionforum.models.Post;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import org.json.JSONObject;
import org.parceler.Parcels;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;

public class CategoryDetailActivity extends AppCompatActivity implements View.OnClickListener {
    private Query mSavedPosts;
    private FirebaseListAdapter<Post> mAdapter;
    private ValueEventListener mSavedPostsListener;
    private ArrayList<Post> categoryPosts = new ArrayList<Post>();
    @Bind(R.id.categoryDetailNameTextView) TextView mCategoryName;
    @Bind(R.id.categoryDetailDescriptionTextView) TextView mCategoryDescription;
    @Bind(R.id.categoryDetailPostListView) ListView mPostList;
    @Bind(R.id.newPostButton) Button mNewPostButton;
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

        mSavedPosts = FirebaseDatabase
                .getInstance()
                .getReference()
                .child(Constants.FIREBASE_CHILD_POST_TO_ADD)
                .orderByChild("categoryId")
                .equalTo(mCategory.getId());

        mSavedPostsListener = mSavedPosts.addValueEventListener(new ValueEventListener() {

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
                    String post = postSnapshot.getValue().toString();
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });

        mAdapter = new FirebaseListAdapter<Post>(this, Post.class, android.R.layout.two_line_list_item, mSavedPosts) {
            @Override
            protected void populateView(View view, Post post, int position) {
                ((TextView)view.findViewById(android.R.id.text1)).setText(post.getPostTitle());
                ((TextView)view.findViewById(android.R.id.text2)).setText(post.getPostContent());
            }
        };
        mPostList.setAdapter(mAdapter);

        mNewPostButton.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v == mNewPostButton)  {
            Intent intent = new Intent(CategoryDetailActivity.this, NewPostActivity.class);
            intent.putExtra("category", Parcels.wrap(mCategory));
            startActivity(intent);
        }
    }
}
