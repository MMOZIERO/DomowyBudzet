package dziennik.domowybudzet;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by ASUS on 24.04.2016.
 */
public class Wydatek implements Serializable   {
    private int id;
    private float kwota;
    private String data;

    public Wydatek(float kwota, String data){
        super();
        this.kwota= kwota;
        this.data = data;
    }
    @Override
    public String toString(){

        return "Wydatek: [id=" +id +", Kwota=" + kwota + ",Data=" + data +" ]";

    }
    public float getKwota(){return kwota;}
    public String getData() {return data;}
    public int getId(){return id;}
    public void setId(int id) {this.id=id;}


}
