import Classes.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SamochodGUI extends Thread {
    private JTextField model;
    private JTextField nrRejestr;
    private JTextField aktPredk;
    private JTextField cena;
    private JButton STARTButton;
    private JButton STOPButton;
    private JTextField samochódTextField;
    private JComboBox<Samochod> comboBox1;
    private JButton dodajNowyButton;
    private JButton usuńButton;
    private JPanel Mapa;
    private JPanel MainPanel;
    private JPanel Komponenty;
    private JPanel Naglowek;
    private JTextField nazwaSkrzyni;
    private JTextField cenaSkrzyni;
    private JTextField aktbieg;
    private JTextField wagaSkrzyni;
    private JTextField nazwaSilnika;
    private JTextField cenaSilnika;
    private JTextField wagaSilnika;
    private JTextField aktObroty;
    private JTextField nazwaSprzegla;
    private JTextField cenaSprzegla;
    private JTextField wagaSprzegla;
    private JTextField stanSprzegla;
    private JButton zwiekszBiegButton;
    private JButton zmniejszBiegButton;
    private JButton gazButton;
    private JButton hamulecButton;
    private JButton wcisnijsprzegloButton;
    private JButton zwolnijsprzegloButton;
    private JLabel carIcon;

    private Samochod auto;

    public SamochodGUI(Samochod car) {
        this.auto = car;
        comboBox1.addItem(auto);
        start();
        STARTButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auto.wlacz();
                refresh();
            }
        });
        STOPButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auto.wylacz();
                refresh();
            }
        });
        zwiekszBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auto.getSkrzyniaBiegow().zwiekszBieg();
                refresh();
            }
        });
        zmniejszBiegButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auto.getSkrzyniaBiegow().zmnniejszBieg();
                refresh();
            }
        });
        gazButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auto.getSilnik().zwiekszObroty();
                refresh();
            }
        });
        hamulecButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auto.getSilnik().zmniejszObroty();
                refresh();
            }
        });
        wcisnijsprzegloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auto.getSkrzyniaBiegow().getSprzeglo().wcisnij();
                refresh();
            }
        });
        zwolnijsprzegloButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                    auto.getSkrzyniaBiegow().getSprzeglo().zwolnij();
                    refresh();
            }
        });
        Mapa.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                super.mousePressed(e);
                Pozycja cel = new Pozycja(e.getX(), e.getY());
                auto.jedzDo(cel);
            }
        });

        dodajNowyButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame newCarGUI = new NowySamochodGUI(comboBox1, carIcon);
                newCarGUI.pack();
            }
        });
        comboBox1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                auto = (Samochod) comboBox1.getSelectedItem();
                refresh();
            }
        });
        usuńButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                comboBox1.removeItem(auto);
                auto.interrupt();
                refresh();
            }
        });
    }

    public void refresh(){
        if (auto != null) {
            this.model.setText(auto.getModel());
            this.nrRejestr.setText(auto.getNrRejestracyjny());
            this.aktPredk.setText(Double.toString(auto.getAktPredk()));
            this.cena.setText(Double.toString(auto.getCena()));
            this.nazwaSkrzyni.setText(auto.getSkrzyniaBiegow().getNazwa());
            this.cenaSkrzyni.setText(Double.toString(auto.getSkrzyniaBiegow().getCena()));
            this.aktbieg.setText(Integer.toString(auto.getSkrzyniaBiegow().getAktBieg()));
            this.wagaSkrzyni.setText(Double.toString(auto.getSkrzyniaBiegow().getWaga()));
            this.nazwaSilnika.setText(auto.getSilnik().getNazwa());
            this.cenaSilnika.setText(Double.toString(auto.getSilnik().getCena()));
            this.wagaSilnika.setText(Double.toString(auto.getSilnik().getWaga()));
            this.aktObroty.setText(Double.toString(auto.getSilnik().getObroty()));
            this.nazwaSprzegla.setText(auto.getSprzeglo().getNazwa());
            this.cenaSprzegla.setText(Double.toString(auto.getSprzeglo().getCena()));
            this.wagaSprzegla.setText(Double.toString(auto.getSprzeglo().getWaga()));
            this.stanSprzegla.setText(auto.getSkrzyniaBiegow().getStanSprzegla());
            carIcon.setLocation((int) auto.getX(), (int) auto.getY());
        } else {
            model.setText("");
            nrRejestr.setText("");
            aktPredk.setText("");
            cena.setText("");
            nazwaSkrzyni.setText("");
            cenaSkrzyni.setText("");
            aktbieg.setText("");
            wagaSkrzyni.setText("");
            nazwaSilnika.setText("");
            cenaSilnika.setText("");
            wagaSilnika.setText("");
            aktObroty.setText("");
            nazwaSprzegla.setText("");
            cenaSprzegla.setText("");
            wagaSprzegla.setText("");
            stanSprzegla.setText("");
        }
    }

    public static void main(String[] args) {
        Sprzeglo sprzeglo1 = new Sprzeglo("Survivor", 250, 3000);
        SkrzyniaBiegow skrzynia1 = new SkrzyniaBiegow("Killer", 470, 9900.99, 6, sprzeglo1);
        Silnik silnik1 = new Silnik("V12 Turbo", 1200.78, 24678, 5000);
        Pozycja pozycja1 = new Pozycja(0, 0);
        Samochod car1 = new Samochod("KTT347U", "Ford Mustang 1956", 220, skrzynia1, silnik1, pozycja1);

        JFrame frame = new JFrame("SamochodGUI");
        frame.setContentPane(new SamochodGUI(car1).MainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);

    }

    public void run() {
        try {
            while(true) {
                refresh();
                if (auto == null) {
                    carIcon.setVisible(false);
                } else {
                    carIcon.setLocation((int) auto.getPozycja().getX(), (int) auto.getPozycja().getY());
                    }
                    Thread.sleep(10);
            }
        } catch (InterruptedException ignored) {}
    }
}
