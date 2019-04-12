package dk.acsandras.mvvmdemo.model;

import dk.acsandras.mvvmdemo.Observable;

public class Model{

    // TODO (2) Konverter dine datafelter fra primitive variable som f.eks. double til LiveData
    // Det vil gøre, at denne data member vil sende nootifikationer til alle de klasser, som observerer
    // dette felt, og de klasser vil så kunne opdatere data automatiskt.
    // Se dette forklaret i https://developer.android.com/topic/libraries/architecture/livedata
    //private String a;// Før var det "private String a;"

    private Observable<String> a = new Observable<>();

    // TODO (3) Lav getters og setters og evt. en constructor for din data
    public Model() {

    }


    public Observable getA() {



        return a;
    }


    public void setA(String a) {
        this.a.setValue(a);
    }

}
