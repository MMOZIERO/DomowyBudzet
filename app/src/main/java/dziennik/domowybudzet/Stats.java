package dziennik.domowybudzet;

import android.content.Intent;
import android.database.Cursor;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;
import android.widget.Toast;

public class Stats extends AppCompatActivity {

    MySQLite db;
    private SimpleCursorAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        db=new MySQLite(this);
        String Sjedz=new String();
        String Smoto=new String();
        String Sroz=new String();
        String Selek=new String();
        String Szdro=new String();
        String Srozne=new String();

        String Wydatki=new String();





        Cursor jedz= db.kategorie("Jedzenie");
        if(jedz.moveToFirst())
        {
            do{
                //assing values
                Sjedz = jedz.getString(0);


            }while(jedz.moveToNext());
        }


        Cursor moto= db.kategorie("Motoryzacja");
        if(moto.moveToFirst())
        {
            do{
                //assing values
                Smoto = moto.getString(0);


            }while(moto.moveToNext());
        }


        Cursor roz= db.kategorie("Rozrywka");
        if(roz.moveToFirst())
        {
            do{
                //assing values
                Sroz = roz.getString(0);


            }while(roz.moveToNext());
        }


        Cursor ele= db.kategorie("Elektronika");
        if(ele.moveToFirst())
        {
            do{
                //assing values
                Selek = ele.getString(0);


            }while(ele.moveToNext());
        }


        Cursor zdr= db.kategorie("Zdrowie");
        if(zdr.moveToFirst())
        {
            do{
                //assing values
                Szdro = zdr.getString(0);


            }while(zdr.moveToNext());
        }


        Cursor rozn= db.kategorie("Rozne");
        if(rozn.moveToFirst())
        {
            do{
                //assing values
                Srozne = rozn.getString(0);


            }while(rozn.moveToNext());
        }


        Cursor wydatki= db.suma();
        if(wydatki.moveToFirst())
        {
            do{

                Wydatki = wydatki.getString(0);


            }while(wydatki.moveToNext());
        }



        final TextView mTextView = (TextView) findViewById(R.id.textEveryday);
        mTextView.setText(Sjedz+" zł"); //db.kategorie("Dom")
        final TextView mTextView2 = (TextView) findViewById(R.id.textTransport);
        mTextView2.setText(Smoto+" zł"); //db.kategorie("Nauka")
        final TextView mTextView3 = (TextView) findViewById(R.id.textFun);
        mTextView3.setText(Sroz+" zł"); //db.kategorie("Motoryzacja")
        final TextView mTextView4 = (TextView) findViewById(R.id.textMedia);
        mTextView4.setText(Selek+" zł"); //db.kategorie("Dom")
        final TextView mTextView5 = (TextView) findViewById(R.id.textHealth);
        mTextView5.setText(Szdro+" zł"); //db.kategorie("Nauka")
        final TextView mTextView6 = (TextView) findViewById(R.id.textMix);
        mTextView6.setText(Srozne+" zł"); //db.kategorie("Motoryzacja")


        final TextView mTextView7 = (TextView) findViewById(R.id.textWydatki);
        mTextView7.setText(Wydatki+" zł"); //db.kategorie("Motoryzacja")
    }

    public void kategorie(View view) {

    }




}
