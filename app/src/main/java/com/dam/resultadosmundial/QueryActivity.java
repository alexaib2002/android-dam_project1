package com.dam.resultadosmundial;

import android.widget.Button;

import com.dam.resultadosmundial.javabeans.MatchResult;

import java.util.ArrayList;

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
            System.err.println("Not implemented yet :(");
            System.out.println((ArrayList<MatchResult>) getIntent().getSerializableExtra(StartActivity.KEY_MATCH_LIST));
        });
    }
}