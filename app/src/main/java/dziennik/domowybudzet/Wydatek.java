package dziennik.domowybudzet;

import java.io.Serializable;
import java.util.Date;


public class Wydatek implements Serializable   {
    private int id;
    private String nazwa;
    private float kwota;
    private String data;
    private String kategoria;

    public Wydatek(){}
    public Wydatek(String nazwa, Float kwota, String data, String kategoria){
        super();
        this.nazwa= nazwa;
        this.kwota= kwota;
        this.data = data;
        this.kategoria = kategoria;
    }
    @Override
    public String toString(){

        return "Wydatek: [id=" +id +", nazwa=" + nazwa + ", kwota=" + kwota + ", data=" + data +", kategoria=" + kategoria +" ]";

    }
    public String getNazwa() {return nazwa;}
    public float getKwota(){return kwota;}
    public String getData() {return data;}
    public String getKategoria() {return kategoria;}
    public int getId(){return id;}
    public void setId(int ID) {this.id=ID;}


}
