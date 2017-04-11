package com.sushantmagoo.focus4d;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @BindView(R.id.posts_rv) RecyclerView postsRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        postsRv.setLayoutManager(new LinearLayoutManager(this));

        final PostItem[] items =
                new JSONResourceReader(getResources(), R.raw.content).constructUsingGson(
                        PostItem[].class);

        for (PostItem item : items) {
            Log.d(TAG, " item : " + item);
        }
        postsRv.setAdapter(new PostsAdapter(this, Arrays.asList(items)));
    }

}