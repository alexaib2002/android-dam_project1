package com.dam.resultadosmundial.activities;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.dam.resultadosmundial.R;
import com.dam.resultadosmundial.fragments.MatchResultFragment;
import com.dam.resultadosmundial.model.MatchResult;

import java.util.ArrayList;

public class QueryActivity extends TraversableActivity {

    private Button btnCountryQuery;
    private EditText txtEditCountryQuery;

    private final ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            // method reference to onActivityResult, defining it as lambda expression here
            // would break other expressions
            new ActivityResultContracts.StartActivityForResult(), this::onActivityResult);

    private final View.OnClickListener selectListener = v -> {
        Intent intent = new Intent(this, SelectionActivity.class);
        resultLauncher.launch(intent);
        clearResults();
    };

    private final View.OnClickListener clearListener = v -> {
        txtEditCountryQuery.setText("");
        clearResults();
        btnCountryQuery.setText(R.string.btn_insert_sel);
        btnCountryQuery.setOnClickListener(selectListener);
    };

    public QueryActivity() {
        super(R.layout.activity_query);
    }

    @Override
    protected void initActivityLayout() {
        btnCountryQuery = findViewById(R.id.btnCountryQuery);
        txtEditCountryQuery = findViewById(R.id.txtEditCountryQuery);
    }

    @Override
    protected void initListeners() {
        btnCountryQuery.setOnClickListener(selectListener);
    }

    private void onActivityResult(@NonNull ActivityResult result) {
        if (result.getResultCode() == SelectionActivity.RESULT_ACCEPTED) {
            assert result.getData() != null;
            txtEditCountryQuery.setText(result.getData()
                    .getStringExtra(InsertionActivity.KEY_COUNTRY_SELECTED));
            queryResults();
            btnCountryQuery.setText(R.string.btn_insert_clean_fields);
            btnCountryQuery.setOnClickListener(clearListener);
        }
    }

    private void queryResults() {
        String country = txtEditCountryQuery.getText().toString();
        FragmentTransaction addTransaction = getSupportFragmentManager().beginTransaction();
        //noinspection unchecked
        ArrayList<MatchResult> matchResults = (ArrayList<MatchResult>) getIntent().getSerializableExtra(StartActivity.KEY_MATCH_LIST);
        for (MatchResult matchResult : matchResults) {
            if (matchResult.getTeam1().equals(country) || matchResult.getTeam2().equals(country)) {
                System.out.println("Adding fragment for " + matchResult.getTeam1() + " vs " + matchResult.getTeam2());
                MatchResultFragment fragment = MatchResultFragment.newInstance(matchResult);
                addTransaction.add(R.id.scrollLayoutQuery, fragment);
            }
        }
        addTransaction.commit();
    }

    private void clearResults() {
        FragmentTransaction removalTransaction = getSupportFragmentManager().beginTransaction();
        for (Fragment fragment : getSupportFragmentManager().getFragments()) {
            removalTransaction.remove(fragment);
        }
        removalTransaction.commit();
    }
}