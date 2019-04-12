package dk.acsandras.mvvmdemo.viewmodel;

import android.content.Context;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import dk.acsandras.mvvmdemo.Observer;
import dk.acsandras.mvvmdemo.model.Model;

public class Writer implements Observer {

    private Model model;
    private Context context;

    public Writer(Model model, Context context) {

        this.context = context;

        this.model = model;

        if (checkFile()) {

            try
            {
                // Reading the object from a file
                FileInputStream file = context.openFileInput("a.ser");
                ObjectInputStream in = new ObjectInputStream(file);

                // Method for deserialization of object
                model.setA(in.readObject().toString());

                in.close();
                file.close();

                System.out.println("Object has been deserialized ");

            }

            catch(IOException ex)
            {
                System.out.println("IOException is caught");
            }

            catch(ClassNotFoundException ex)
            {
                System.out.println("ClassNotFoundException is caught");
            }

        }else{
            model.setA("Startdata fra modellen");
        }
        model.getA().observe(this);

    }

    private boolean checkFile() {

        File file = context.getFileStreamPath("a.ser");
        if(file == null || !file.exists()){
            return false;
        }
        return true;
    }


    @Override
    public void update(Object value) {
        try {
            //Saving of object in a file
            FileOutputStream file =  context.openFileOutput("a.ser",Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(file);

            // Method for serialization of object
            out.writeObject(value);

            out.close();
            file.close();

            System.out.println("Object has been serialized");

        } catch (IOException ex) {
            System.out.println("IOException is caught");
        }
    }
}
