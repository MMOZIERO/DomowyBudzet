package dziennik.domowybudzet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Stats extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);
    }

    public void kategorie(View view) {
        Intent intencja = new Intent(this, WydatkiKategorie.class);
        startActivityForResult(intencja, 1);
    }
}
