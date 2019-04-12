package dk.acsandras.mvvmdemo.viewmodel;

import android.content.Context;

public class Initializer {

    Writer writer;



    public Initializer(Context context, ModelViewModel viewModel){

        writer = new Writer(viewModel.getModel(),context);

    }
}
