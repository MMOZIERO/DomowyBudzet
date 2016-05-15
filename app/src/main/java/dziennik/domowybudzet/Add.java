package dziennik.domowybudzet;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.google.android.gms.appindexing.Action;
import com.google.android.gms.appindexing.AppIndex;
import com.google.android.gms.common.api.GoogleApiClient;

import java.io.ByteArrayOutputStream;

public class Add extends AppCompatActivity {

    ImageView mImageView;
    private int modyfi_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        ArrayAdapter kategorie = new ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, new String[]{"Dom", "Nauka", "Motoryzacja"});
        Spinner kategoria = (Spinner) findViewById(R.id.spinner);
        mImageView=(ImageView) findViewById(R.id.imageView2);
        kategoria.setAdapter(kategorie);
        Bundle extras = getIntent().getExtras();
        try {
            if (extras.getSerializable("element") != null) {
                Wydatek item = (Wydatek) extras.getSerializable("element");
                EditText nazwa = (EditText) findViewById(R.id.editText1);
                EditText kwota = (EditText) findViewById(R.id.editText2);
                EditText data = (EditText) findViewById(R.id.editText3);
                ImageView mImageView = (ImageView) findViewById(R.id.imageView2);
                nazwa.setText(item.getNazwa());
                kwota.setText(Float.toString(item.getKwota()));
                data.setText(item.getData());
                byte[] byteArray = item.getBm();
                Bitmap bm = BitmapFactory.decodeByteArray(byteArray, 0 ,byteArray.length);
                mImageView.setImageBitmap(bm);
                this.modyfi_id = item.getId();
            }
        } catch (Exception ex) {
            this.modyfi_id = 0;
        }
        final Button button = (Button) findViewById(R.id.button2);
        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                dispatchTakePictureIntent();
            }
        });

    }


    public void wyslij(View view) {
        EditText nazwa = (EditText) findViewById(R.id.editText1);
        EditText data = (EditText) findViewById(R.id.editText3);
        EditText kwota = (EditText) findViewById(R.id.editText2);
        ImageView ImageView = (ImageView) findViewById(R.id.imageView2);
        Bitmap yourBitmap=((BitmapDrawable)ImageView.getDrawable()).getBitmap();
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        yourBitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
        byte[] bArray = bos.toByteArray();
        Spinner kategoria = (Spinner) findViewById(R.id.spinner);
        Wydatek item = new Wydatek(nazwa.getText().toString(), Float.valueOf(kwota.getText().toString()), data.getText().toString(), kategoria.getSelectedItem().toString(),  bArray);
        item.setId(this.modyfi_id);
        Intent intencja = new Intent();
        intencja.putExtra("nowy", item);
        setResult(RESULT_OK, intencja);
        finish();
    }


    static final int REQUEST_IMAGE_CAPTURE = 1;

    private void dispatchTakePictureIntent() {
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (takePictureIntent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");
            mImageView.setImageBitmap(imageBitmap);
        }
    }





}
