/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu;

import javax.swing.JTextField;

/**
 *
 * @author juhatauriainen
 */
public class Erotus implements Komento {

    private final Sovelluslogiikka sovellus;
    private final JTextField tuloskentta;
    private final JTextField syotekentta;
    private int edellinen;

    Erotus(Sovelluslogiikka sovellus, JTextField tuloskentta, JTextField syotekentta) {
        this.sovellus = sovellus;
        this.tuloskentta = tuloskentta;
        this.syotekentta = syotekentta;
    }

    @Override
    public void suorita() {
        edellinen = sovellus.tulos();
        int arvo = 0;

        try {
            arvo = Integer.parseInt(syotekentta.getText());
        } catch (Exception e) {
        }

        sovellus.miinus(arvo);

        syotekentta.setText("");
        tuloskentta.setText("" + sovellus.tulos());
    }

    @Override
    public void peru() {
        syotekentta.setText("");
        tuloskentta.setText("" + edellinen);
    }

}
