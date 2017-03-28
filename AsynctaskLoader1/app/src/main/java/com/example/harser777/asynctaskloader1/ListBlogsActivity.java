package com.example.harser777.asynctaskloader1;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Loader;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.widget.ListView;
import com.example.harser777.asynctaskloader1.adapter.BlogListAdapter;
import com.example.harser777.asynctaskloader1.model.BlogPost;
import java.util.ArrayList;
import java.util.List;

public class ListBlogsActivity extends AppCompatActivity {

    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        context=this;

        final BlogListAdapter blogListAdapter = new BlogListAdapter(this, new ArrayList<BlogPost>());
        ListView blogPostListView = (ListView) findViewById(R.id.blogposts);

        blogPostListView.setAdapter(blogListAdapter);


        getLoaderManager().initLoader(0, savedInstanceState,
                new LoaderManager.LoaderCallbacks<List<BlogPost>>() {
                    @Override public Loader<List<BlogPost>> onCreateLoader(int id, Bundle args) {
                        return new BlogPostLoader(context);//ListBlogsActivity.this);
                    }

                    @Override public void onLoadFinished(Loader<List<BlogPost>> loader, List<BlogPost> data) {
                        blogListAdapter.setData(data);
                    }

                    @Override public void onLoaderReset(Loader<List<BlogPost>> loader) {
                        blogListAdapter.setData(new ArrayList<BlogPost>());
                    }
                }
        ).forceLoad();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i("ListBlogsActivity:", "onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i("ListBlogsActivity:", "onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i("ListBlogsActivity:", "onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i("ListBlogsActivity:", "onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i("ListBlogsActivity:", "onDestroy");
    }
}
