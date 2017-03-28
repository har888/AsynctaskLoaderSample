package com.example.harser777.asynctaskloader1;

import android.content.AsyncTaskLoader;
import android.content.Context;


import com.example.harser777.asynctaskloader1.model.BlogPost;
import com.example.harser777.asynctaskloader1.service.BlogPostService;

import java.util.List;

/**
 * Created by harser777 on 11/27/2016.
 */
public class BlogPostLoader extends AsyncTaskLoader<List<BlogPost>> {
    private BlogPostService service = new BlogPostService();

    public BlogPostLoader(Context context) {
        super(context);
    }

    @Override public List<BlogPost> loadInBackground() {
        return service.getPosts();
    }
}