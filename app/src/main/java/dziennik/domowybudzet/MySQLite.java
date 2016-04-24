package dziennik.domowybudzet;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

/**
 * Created by ASUS on 24.04.2016.
 */
public class MySQLite extends
        SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1 ;
    public MySQLite(Context context){
        super(context,"DomowyBudzetDB",null,DATABASE_VERSION);
    }



    @Override
    public void onCreate(SQLiteDatabase database){
        String DATABASE_CREATE = "create table wydatki " +
                "( id integer primary key autoincrement,"
                + "kwota real not null,"
                + "data text not null);";
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db,
                          int oldVersion, int newVersion){

        db.execSQL("DROP TABLE IF EXIST wydatki");
        onCreate(db);
    }

    public void dodaj(Wydatek pay){
        SQLiteDatabase db =
                this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("kwota",pay.getKwota());
        values.put("data",pay.getData());
        db.insert("wydatki", null, values);
        db.close();
    }

    public void usun(String id){
        SQLiteDatabase db=
                this.getWritableDatabase();
        db.delete("wydatki", "_id = ?",
                new String[]{id});
        db.close();
    }

    public int aktualizuj(Wydatek pay) {
        SQLiteDatabase db =
                this.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put("wielkosc", pay.getKwota());
        values.put("opis", pay.getData());
        int i = db.update("wydatki", values, "_id =?", new String[]{String.valueOf(pay.getId())});
        db.close();

        return i;
    }

    public Wydatek pobierz(int id){
        SQLiteDatabase db =
                this.getWritableDatabase();
        Cursor cursor = db.query("wydatki", //a. table name
                new String[]{"_id", "kwota", "data"}, //b.column names
                " id = ?",//c.selections
                new String[]{
                        String.valueOf(id)}, //d. sel args
                null, //e. group by
                null, //f. having
                null, //g.order by
                null); //h. limit
        if(cursor != null)
            cursor.moveToFirst();

        Wydatek pay = new
                Wydatek(cursor.getFloat(1),cursor.getString(2));

        pay.setId(Integer.parseInt(cursor.getString(0)));

        return pay;
    }

    public Cursor lista(){
        SQLiteDatabase db = this.getWritableDatabase();
        return db.rawQuery("Select * from wydatki",null);
    }



}
