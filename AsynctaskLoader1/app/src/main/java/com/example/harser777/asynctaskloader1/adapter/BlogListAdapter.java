package com.example.harser777.asynctaskloader1.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import com.example.harser777.asynctaskloader1.R;
import com.example.harser777.asynctaskloader1.model.BlogPost;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by harser777 on 11/27/2016.
 */

public class BlogListAdapter extends BaseAdapter {
    private static final int MAX_SUMMARY_LEN = 100;
    private LayoutInflater inflater;
    private List<BlogPost> blogPostRows = new ArrayList<BlogPost>();

    public BlogListAdapter(Context context, List<BlogPost> blogPostRows) {
        this.blogPostRows = blogPostRows;
        inflater = LayoutInflater.from(context);
    }

    public void setData(List<BlogPost> data) {
        if (blogPostRows != null) {
            blogPostRows.clear();
        } else {
            blogPostRows = new ArrayList<BlogPost>();
        }
        if (data != null) {
            blogPostRows.addAll(data);
        }
        notifyDataSetChanged();
    }

    @Override
    public View getView(int i, View view, ViewGroup parent) {
        BlogPost post = (BlogPost) getItem(i);
        if (view == null) {
            view = inflater.inflate(R.layout.blogpostdetail, parent, false);
        }

        TextView blogTitle = (TextView) view.findViewById(R.id.blogtitle);
        blogTitle.setText(post.title);

        TextView blogSummary = (TextView) view.findViewById(R.id.blogsummary);
        String summary = post.content.substring(0, Math.min(MAX_SUMMARY_LEN, post.content.length()));
        blogSummary.setText(summary);

        return view;
    }

    @Override
    public int getCount() {
        return blogPostRows.size();
    }

    @Override
    public Object getItem(int i) {
        return blogPostRows.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }
}
