package model;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;

//Da controllare: va bene aver inserito il DB_URL in maniera statica o andrebbe
//fatto dinamicamente?


public class Filtri {
	
	

    /*//Metodo che cerca hoodie specifica nel db
    public static ArrayList <Hoodie> filtra (Hoodie hoodie) throws SQLException{

        //ArrayList con tutto DB
		final String DB_URL = "jdbc:sqlite:sample.db";


        String sql = "SELECT * FROM DESCRIZIONE";

        ArrayList <Hoodie> risultati = DataBase.selectFromTabel(sql);

        //Unione di tutti gli altri filtri per colonna
        ArrayList <Hoodie> filtrato = new ArrayList <Hoodie>();
        
        
        filtrato = Filtri.filtraColore(Filtri.filtraTaglia(Filtri.filtraModello(risultati, hoodie), hoodie), hoodie);
       // filtrato = Filtri.filtraTaglia(Filtri.filtraModello(risultati, hoodie), hoodie);

        return filtrato;
    }


    public static ArrayList <Hoodie> filtraModello (ArrayList <Hoodie> risultati, Hoodie hoodie){

        ArrayList <Hoodie> risultatiModello = new ArrayList <Hoodie>();
        int count = 0;

        if (hoodie.getModello() != null) {

            for(int i=0; i<risultati.size(); i++) {

                if (hoodie.getModello().equals(risultati.get(i).getModello()) ) {

                    risultatiModello.add(risultati.get(i));
                    count++;
                }
            }

            //Caso in cui non ci siano felpe desiderate, quindi ritorno i risultati originali
            if (count==0) {
                System.out.println("Nessuna felpa di questo modello trovata");

                for (int j=0; j<risultati.size(); j++) {
                    risultatiModello.add(risultati.get(j));
                }
            }


        }else {for (int b=0; b<risultati.size(); b++) {

            risultatiModello.add(risultati.get(b));
        }

        }

        return risultatiModello;
    }




    public static ArrayList <Hoodie> filtraTaglia (ArrayList <Hoodie> risultati, Hoodie hoodie){

        ArrayList <Hoodie> risultatiTaglia = new ArrayList <Hoodie>();
        int count = 0;


        if (hoodie.getTaglia() != null) {

            for(int i=0; i<risultati.size(); i++) {

                if (hoodie.getTaglia().equals(risultati.get(i).getTaglia()) ) {

                    risultatiTaglia.add(risultati.get(i));
                    count++;
                }
            }

            //Caso in cui non ci siano felpe desiderate, quindi ritorno i risultati originali
            if (count==0) {
                System.out.println("Nessuna felpa di questa taglia trovata");

                for (int j=0; j<risultati.size(); j++) {
                    risultatiTaglia.add(risultati.get(j));
                }
            }


        }else {for (int b=0; b<risultati.size(); b++) {

            risultatiTaglia.add(risultati.get(b));
        }

        }

        return risultatiTaglia;
    }



    public static ArrayList <Hoodie> filtraColore (ArrayList <Hoodie> risultati, Hoodie hoodie){

        ArrayList <Hoodie> risultatiColore = new ArrayList <Hoodie>();
        int count = 0;


        if (hoodie.getColore() != null) {

            for(int i=0; i<risultati.size(); i++) {

                if (hoodie.getColore().equals(risultati.get(i).getColore()) ) {

                    risultatiColore.add(risultati.get(i));
                    count++;
                }
            }

            //Caso in cui non ci siano felpe desiderate, quindi ritorno
            //un arraylist in cui c'è solo una felpa null

            if (count==0) {
                System.out.println("Nessuna felpa di questo colore trovata");

                Hoodie hoodieVuota = new Hoodie(null, null, null, null);
                risultatiColore.add(hoodieVuota);

            }


        }else {for (int b=0; b<risultati.size(); b++) {

            risultatiColore.add(risultati.get(b));
        }

        for(int i = 0; i< risultati.size(); i++) {
        	
        }
    }
        return risultatiColore;

}*/
}
