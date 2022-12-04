package com.dam.resultadosmundial.activities;

import android.content.Intent;
import android.widget.Button;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;

import com.dam.resultadosmundial.R;
import com.dam.resultadosmundial.model.MatchResult;

import java.util.ArrayList;

public class StartActivity extends TraversableActivity {

    public static final String KEY_MATCH_LIST = "DataList";

    private Button insertBtn;
    private Button queryBtn;

    private final ActivityResultLauncher<Intent> resultLauncher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(), result -> {
                if (result.getResultCode() == InsertionActivity.RESULT_SAVED) {
                    assert result.getData() != null;
                    //noinspection unchecked
                    getIntent().putExtra(KEY_MATCH_LIST, (ArrayList<MatchResult>) result.getData()
                            .getSerializableExtra(KEY_MATCH_LIST));
                }
            });

    public StartActivity() {
        super(R.layout.activity_start);
    }

    @Override
    protected void initActivityLayout() {
        insertBtn = findViewById(R.id.insertBtn);
        queryBtn = findViewById(R.id.queryBtn);
        ArrayList<MatchResult> matchResults = new ArrayList<>();
        loadInitialData(matchResults);
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

    private void loadInitialData(ArrayList<MatchResult> matchResults) {
        matchResults.add(new MatchResult("Fase de grupos", "20/11/2022", "17:00", "Qatar", 0, "Ecuador", 2));
        matchResults.add(new MatchResult("Fase de grupos", "21/11/2022", "14:00", "Inglaterra", 6, "Irán", 2));
        matchResults.add(new MatchResult("Fase de grupos", "21/11/2022", "17:00", "Senegal", 0, "Países Bajos", 2));
        matchResults.add(new MatchResult("Fase de grupos", "21/11/2022", "20:00", "Estados Unidos", 1, "Gales", 1));
        matchResults.add(new MatchResult("Fase de grupos", "22/11/2022", "11:00", "Argentina", 1, "Arabia Saudí", 2));
        matchResults.add(new MatchResult("Fase de grupos", "22/11/2022", "14:00", "Dinamarca", 0, "Túnez", 0));
        matchResults.add(new MatchResult("Fase de grupos", "22/11/2022", "17:00", "México", 0, "Polonia", 0));
        matchResults.add(new MatchResult("Fase de grupos", "22/11/2022", "20:00", "Francia", 4, "Australia", 1));
        matchResults.add(new MatchResult("Fase de grupos", "23/11/2022", "11:00", "Marruecos", 0, "Croacia", 0));
        matchResults.add(new MatchResult("Fase de grupos", "23/11/2022", "14:00", "Alemania", 1, "Japón", 2));
        matchResults.add(new MatchResult("Fase de grupos", "23/11/2022", "17:00", "España", 7, "Costa Rica", 0));
        matchResults.add(new MatchResult("Fase de grupos", "23/11/2022", "20:00", "Bélgica", 1, "Canadá", 0));
        matchResults.add(new MatchResult("Fase de grupos", "24/11/2022", "11:00", "Suiza", 1, "Camerún", 0));
        matchResults.add(new MatchResult("Fase de grupos", "24/11/2022", "14:00", "Uruguay", 0, "Corea del Sur", 0));
        matchResults.add(new MatchResult("Fase de grupos", "24/11/2022", "17:00", "Portugal", 3, "Ghana", 2));
        matchResults.add(new MatchResult("Fase de grupos", "24/11/2022", "20:00", "Brasil", 2, "Serbia", 0));
        matchResults.add(new MatchResult("Fase de grupos", "25/11/2022", "11:00", "Gales", 0, "Irán", 2));
        matchResults.add(new MatchResult("Fase de grupos", "25/11/2022", "14:00", "Qatar", 1, "Senegal", 3));
        matchResults.add(new MatchResult("Fase de grupos", "25/11/2022", "17:00", "Países Bajos", 1, "Ecuador", 1));
        matchResults.add(new MatchResult("Fase de grupos", "25/11/2022", "20:00", "Inglaterra", 0, "Estados Unidos", 0));
        matchResults.add(new MatchResult("Fase de grupos", "26/11/2022", "11:00", "Túnez", 0, "Australia", 1));
        matchResults.add(new MatchResult("Fase de grupos", "26/11/2022", "14:00", "Polonia", 2, "Arabia Saudí", 0));
        matchResults.add(new MatchResult("Fase de grupos", "26/11/2022", "17:00", "Francia", 2, "Dinamarca", 1));
        matchResults.add(new MatchResult("Fase de grupos", "26/11/2022", "20:00", "Argentina", 2, "México", 0));
        matchResults.add(new MatchResult("Fase de grupos", "27/11/2022", "11:00", "Japón", 0, "Costa Rica", 1));
        matchResults.add(new MatchResult("Fase de grupos", "27/11/2022", "14:00", "Bélgica", 0, "Marruecos", 2));
        matchResults.add(new MatchResult("Fase de grupos", "27/11/2022", "17:00", "Croacia", 4, "Canadá", 1));
        matchResults.add(new MatchResult("Fase de grupos", "27/11/2022", "20:00", "España", 1, "Alemania", 1));
        matchResults.add(new MatchResult("Fase de grupos", "28/11/2022", "11:00", "Camerún", 3, "Serbia", 3));
        matchResults.add(new MatchResult("Fase de grupos", "28/11/2022", "14:00", "Corea del Sur", 2, "Ghana", 3));
        matchResults.add(new MatchResult("Fase de grupos", "28/11/2022", "17:00", "Brasil", 1, "Suiza", 0));
        matchResults.add(new MatchResult("Fase de grupos", "28/11/2022", "20:00", "Portugal", 2, "Uruguay", 0));
    }
}