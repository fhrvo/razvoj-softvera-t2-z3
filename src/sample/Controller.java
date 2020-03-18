package sample;

import javafx.event.ActionEvent;

import javafx.scene.control.TextField;

public class Controller {
    public TextField uneseno;
    public TextField ispis;

    public void Unesi(ActionEvent actionEvent) {
        String recenica = uneseno.getText();
        int najduza=0, brojac=0, pozicija=0, pozicija_najduzeg=0;
        for (int i=0; i<recenica.length(); i++) {
            if (recenica.charAt(i)!=' '){
                if (brojac==0) pozicija=i;
                brojac++;
            }
            else {
                if (brojac>najduza) {
                    najduza=brojac;
                    pozicija_najduzeg=pozicija;
                }
                brojac = 0;
            }
        }
        if (brojac>najduza) {
            pozicija_najduzeg=pozicija;
        }
        String rijec = new String();

        for (int i=pozicija_najduzeg; i<recenica.length(); i++) {
            if (recenica.charAt(i) == ' ') break;
            rijec += recenica.charAt(i);
        }
        rijec=rijec.toUpperCase();
        String izlaz = new String();
        for (int i=0; i<pozicija_najduzeg; i++) izlaz+= recenica.charAt(i);
        for (int i=0; i<rijec.length(); i++) izlaz+=rijec.charAt(i);
        for (int i=pozicija_najduzeg+rijec.length(); i<recenica.length(); i++) izlaz+= recenica.charAt(i);
        ispis.setText(izlaz);
    }
}
