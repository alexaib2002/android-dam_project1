package com.dam.resultadosmundial;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;

public class QueryActivity extends TraversableActivity {

    private Button btnCountryQuery;

    public QueryActivity() {
        super(R.layout.activity_query);
    }

    @Override
    protected void initActivityLayout() {
        btnCountryQuery = findViewById(R.id.btnCountryQuery);
    }

    @Override
    protected void initListeners() {
        btnCountryQuery.setOnClickListener(v -> {

        });
    }
}