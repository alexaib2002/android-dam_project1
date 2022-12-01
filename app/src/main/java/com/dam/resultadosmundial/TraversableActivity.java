package com.dam.resultadosmundial;

import android.os.Bundle;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

public abstract class TraversableActivity extends AppCompatActivity {

    @LayoutRes
    protected int layoutId;

    public TraversableActivity(@LayoutRes int layoutId) {
        this.layoutId = layoutId;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layoutId);
        initActivityLayout();
        initListeners();
    }

    abstract protected void initActivityLayout();
    abstract protected void initListeners();
}
