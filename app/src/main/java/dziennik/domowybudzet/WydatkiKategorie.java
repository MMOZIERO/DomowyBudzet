package dziennik.domowybudzet;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.database.Cursor;

public class WydatkiKategorie extends AppCompatActivity {

    MySQLite db;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kategorie);
        db=new MySQLite(this);
        //potrzeba zmienic to co zwraca Cursor z bazy danych na String i wpisac odpowiednio w textView + layout
        final TextView mTextView = (TextView) findViewById(R.id.textView5);
        mTextView.setText("Dom"); //db.kategorie("Dom")
        final TextView mTextView2 = (TextView) findViewById(R.id.textView6);
        mTextView2.setText("Nauka"); //db.kategorie("Nauka")
        final TextView mTextView3 = (TextView) findViewById(R.id.textView7);
        mTextView3.setText("Motoryzacja"); //db.kategorie("Motoryzacja")
    }
}
