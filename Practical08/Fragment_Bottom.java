package com.example.practical08;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;


public class Fragment_bottom extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_bottom, container, false);

        WebView webWindow = view.findViewById(R.id.window);
        webWindow.loadUrl("https://www.google.com");
        return view;
    }
}