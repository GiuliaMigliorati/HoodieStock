package controller;

import model.Hoodie;
import java.sql.SQLException;
import java.util.ArrayList;
import model.DataBase;

public class Controller {

    //Metodo che restituisce quantità presente di una felpa desiderata
    public static int conta (Hoodie hoodie) throws SQLException {

        String sql = "SELECT * FROM DESCRIZIONE";
        ArrayList <Hoodie> db = DataBase.selectFromTabel(sql);

        int count = 0;

        //attenzione, se entra un id null non funziona!
        for (int i=0; i<db.size(); i++) {

            if(hoodie.getId().equals(db.get(i).getId())) {
                count++;
            }
        }

        return count;
    }
}
