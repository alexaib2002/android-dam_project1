package com.dam.resultadosmundial;

import android.content.Intent;
import android.widget.Button;

public class StartActivity extends TraversableActivity {

    private Button insertBtn;
    private Button queryBtn;

    public StartActivity() {
        super(R.layout.activity_start);
    }

    @Override
    protected void initActivityLayout() {
        insertBtn = findViewById(R.id.insertBtn);
        queryBtn = findViewById(R.id.queryBtn);
    }

    @Override
    protected void initListeners() {
        insertBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, InsertionActivity.class);
            startActivity(intent);
        });
        queryBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, QueryActivity.class);
            startActivity(intent);
        });
    }
}