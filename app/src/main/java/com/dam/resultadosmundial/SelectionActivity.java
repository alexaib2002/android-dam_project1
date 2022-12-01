package com.dam.resultadosmundial;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.helper.widget.Flow;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class SelectionActivity extends TraversableActivity {

    public static int RESULT_CANCELLED = 0;
    public static int RESULT_ACCEPTED = 1;

    private Flow flowCountryListSelect;
    private EditText txtEditCountrySelect;
    private Button btnAcceptSelect;
    private Button btnCancelSelect;

    public SelectionActivity() {
        super(R.layout.activity_selection);
    }

    @Override
    protected void initActivityLayout() {
        flowCountryListSelect = findViewById(R.id.flowCountryListSelect);
        txtEditCountrySelect = findViewById(R.id.txtEditCountrySelect);
        btnAcceptSelect = findViewById(R.id.btnAcceptSelect);
        btnCancelSelect = findViewById(R.id.btnCancelSelect);
    }

    @Override
    protected void initListeners() {
        btnAcceptSelect.setOnClickListener(v -> {
            getIntent().putExtra(InsertionActivity.KEY_TEAM_SELECTED,
                    getIntent().getStringExtra(InsertionActivity.KEY_TEAM_SELECTED));
            getIntent().putExtra(InsertionActivity.KEY_COUNTRY_SELECTED,
                    txtEditCountrySelect.getText().toString());
            setResult(RESULT_ACCEPTED, this.getIntent());
            finish();
        });
        btnCancelSelect.setOnClickListener(v -> {
            setResult(RESULT_CANCELLED, this.getIntent());
            finish();
        });
    }
}