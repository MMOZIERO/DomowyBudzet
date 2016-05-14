package dziennik.domowybudzet;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;


public class MySQLite extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;

    public MySQLite(Context context) {
        super(context, "wydatkiDB",
                null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        String DATABASE_CREATE =
                "create table wydatki " +
                        "(_id integer primary key autoincrement," +
                        "nazwa text not null," +
                        "kwota real not null," +
                        "data text not null," +
                        "kategoria text not null);";
        database.execSQL(DATABASE_CREATE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS wydatki");
        onCreate(db);
    }

    public void dodaj(Wydatek element) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("kwota", element.getKwota());
        values.put("kategoria", element.getKategoria());
        values.put("nazwa", element.getNazwa());
        values.put("data", element.getData());
        db.insert("wydatki", null, values);
        db.close();
    }

    public void usun(String id) {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("wydatki", "_id = ?", new String[]{id});
        db.close();
    }

    public int aktualizuj(Wydatek element) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nazwa", element.getNazwa());
        values.put("kwota", element.getKwota());
        values.put("data", element.getData());
        values.put("kategoria", element.getKategoria());
        int i = db.update("wydatki", values, "_id =?", new String[]{String.valueOf(element.getId())});
        db.close();
        return i;
    }

    public Wydatek pobierz(int id) {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.query("wydatki", new String[]{"_id", "nazwa", "kwota", "data", "kategoria"}, " _id = ?", new String[]{String.valueOf(id)},  null, null, null, null);
        if (cursor != null)
            cursor.moveToFirst();
        Wydatek element = new Wydatek(cursor.getString(1), cursor.getFloat(2), cursor.getString(3), cursor.getString(4));
        element.setId(Integer.parseInt(cursor.getString(0)));
        return element;
    }

    public Cursor lista() {
        SQLiteDatabase db = this.getReadableDatabase();
        return db.rawQuery("Select * from wydatki", null);
    }

}