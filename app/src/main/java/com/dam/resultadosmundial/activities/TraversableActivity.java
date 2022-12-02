package com.dam.resultadosmundial.activities;

import android.os.Bundle;
import android.view.Window;

import androidx.annotation.LayoutRes;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public abstract class TraversableActivity extends AppCompatActivity {

    @LayoutRes
    protected int layoutId;

    public TraversableActivity(@LayoutRes int layoutId) {
        this.layoutId = layoutId;
    }

    abstract protected void initActivityLayout();
    abstract protected void initListeners();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initProps();
        setContentView(layoutId);
        initActivityLayout();
        initListeners();
    }

    private void initProps() {
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        Objects.requireNonNull(getSupportActionBar()).hide();
    }
}
