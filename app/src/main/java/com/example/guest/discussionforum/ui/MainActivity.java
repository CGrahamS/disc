package com.example.guest.discussionforum.ui;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.guest.discussionforum.Constants;
import com.example.guest.discussionforum.R;
import com.example.guest.discussionforum.models.Category;
import com.firebase.ui.database.FirebaseListAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import org.parceler.Parcels;

import butterknife.Bind;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private DatabaseReference mSavedCategories;
    private FirebaseListAdapter<Category> mAdapter;
    @Bind(R.id.categoryListView) ListView mCategoryListView;
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
        });

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        mAdapter = new FirebaseListAdapter<Category>(this, Category.class, android.R.layout.two_line_list_item, mSavedCategories) {
            @Override
            protected void populateView(View view, Category category, int position) {
                ((TextView)view.findViewById(android.R.id.text1)).setText(category.getName());
                ((TextView)view.findViewById(android.R.id.text2)).setText(category.getDescription());
            }
        };
        mCategoryListView.setAdapter(mAdapter);

        mNewCategoryButton.setOnClickListener(this);

        mCategoryListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Object clickedItem = parent.getItemAtPosition(position);
                Intent intent = new Intent(MainActivity.this, CategoryDetailActivity.class);
                intent.putExtra("category", Parcels.wrap(clickedItem));
                startActivity(intent);
                Log.d("ListView", clickedItem.toString());
            }
        });


    }

    @Override
    public void onClick(View v) {
        if (v == mNewCategoryButton) {
            Intent intent = new Intent(MainActivity.this, NewCategoryActivity.class);
            startActivity(intent);
        }
    }
}
