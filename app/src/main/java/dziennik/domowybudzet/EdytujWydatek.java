package dziennik.domowybudzet;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class EdytujWydatek extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edytuj_wydatek);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.dodaj_wydatek) {
            Intent startAnotherActivity = new Intent(this, DodajWydatek.class);
            startActivity(startAnotherActivity);
        }
        if (id == R.id.edytuj_wydatek) {
            Intent startAnotherActivity = new Intent(this, EdytujWydatek.class);
            startActivity(startAnotherActivity);
        }
        if (id == R.id.usun_wydatek) {
            Intent startAnotherActivity = new Intent(this, UsunWydatek.class);
            startActivity(startAnotherActivity);
        }
        if (id == R.id.historia) {
            Intent startAnotherActivity = new Intent(this, HistoriaWydatkow.class);
            startActivity(startAnotherActivity);
        }
        if (id == R.id.statystyki) {
            Intent startAnotherActivity = new Intent(this, Statystyki.class);
            startActivity(startAnotherActivity);
        }
        if (id == R.id.kopia) {
            Intent startAnotherActivity = new Intent(this, Kopia.class);
            startActivity(startAnotherActivity);
        }
        if (id == R.id.ustawienia) {
            Intent startAnotherActivity = new Intent(this, Ustawienia.class);
            startActivity(startAnotherActivity);
        }
        if (id == R.id.autorzy) {
            Intent startAnotherActivity = new Intent(this, Autorzy.class);
            startActivity(startAnotherActivity);
        }

        return super.onOptionsItemSelected(item);
    }

}
