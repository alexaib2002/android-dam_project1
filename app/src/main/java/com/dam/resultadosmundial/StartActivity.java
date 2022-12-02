package com.dam.resultadosmundial;

import android.content.Intent;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import com.dam.resultadosmundial.javabeans.MatchResult;

import java.util.ArrayList;

public class StartActivity extends TraversableActivity {

    public static final String KEY_MATCH_LIST = "DataList";

    private Button insertBtn;
    private Button queryBtn;

    private final ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == InsertionActivity.RESULT_SAVED) {
                    assert result.getData() != null;
                    getIntent().putExtra(KEY_MATCH_LIST, (ArrayList<MatchResult>) result.getData()
                            .getSerializableExtra(KEY_MATCH_LIST));
                    System.out.println("Updated list");
                }
            });

    public StartActivity() {
        super(R.layout.activity_start);
    }

    @Override
    protected void initActivityLayout() {
        insertBtn = findViewById(R.id.insertBtn);
        queryBtn = findViewById(R.id.queryBtn);
        ArrayList<MatchResult> matchResults = new ArrayList<MatchResult>();
        getIntent().putExtra(KEY_MATCH_LIST, matchResults);
    }

    @Override
    protected void initListeners() {
        insertBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, InsertionActivity.class);
            intent.putExtra(KEY_MATCH_LIST, getIntent().getSerializableExtra(KEY_MATCH_LIST));
            resultLauncher.launch(intent);
        });
        queryBtn.setOnClickListener(v -> {
            Intent intent = new Intent(this, QueryActivity.class);
            intent.putExtra(KEY_MATCH_LIST, getIntent().getSerializableExtra(KEY_MATCH_LIST));
            startActivity(intent);
        });
    }
}