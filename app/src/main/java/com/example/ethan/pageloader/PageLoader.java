package com.example.ethan.pageloader;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v4.content.AsyncTaskLoader;

import java.io.IOException;

public class PageLoader extends AsyncTaskLoader<String> {

    private String mQueryString;

    PageLoader(Context context, String queryString) {
        super(context);
        mQueryString = queryString;
    }

    @Override
    protected void onStartLoading() {
        super.onStartLoading();

        forceLoad();
    }

    @Nullable
    @Override
    public String loadInBackground() {
       //Do the other thing
        try {
            return NetworkUtils.downloadURL(mQueryString);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
