import Classes.*;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NowySamochodGUI extends JFrame {
    private JPanel mainPanel;
    private JTextField nrRejtxt;
    private JTextField modeltxt;
    private JTextField predmaxtxt;
    private JTextField nazwasilnikatxt;
    private JTextField cenasilnikatxt;
    private JTextField maxobrotytxt;
    private JTextField nazwaskrzynitxt;
    private JTextField cenaskrzynitxt;
    private JCheckBox check5biegow;
    private JCheckBox check6biegow;
    private JTextField nazwasprzeglatxt;
    private JTextField cenasprzeglatxt;
    private JButton dodajButton;
    private JButton anulujButton;
    private JSlider slider1;
    private JSlider slider2;
    private JSlider slider3;
    private JLabel infotxt;

    public NowySamochodGUI(JComboBox<Samochod> comboBox, JLabel caricon){
        JFrame panel = new JFrame("NowySamochodGUI");
        panel.setContentPane(this.mainPanel);
        panel.setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        panel.setResizable(false);
        panel.pack();
        panel.setVisible(true);

        slider1.setPaintTicks(true);
        slider1.setPaintLabels(true);
        slider1.setMajorTickSpacing(500);
        slider1.setMinimum(500);
        slider1.setMaximum(3000);
        slider2.setPaintTicks(true);
        slider2.setPaintLabels(true);
        slider2.setMajorTickSpacing(500);
        slider2.setMinimum(500);
        slider2.setMaximum(3000);
        slider3.setPaintTicks(true);
        slider3.setPaintLabels(true);
        slider3.setMajorTickSpacing(500);
        slider3.setMinimum(500);
        slider3.setMaximum(3000);

        dodajButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if ((nrRejtxt.getText().isBlank()) || (modeltxt.getText().isBlank()) || (predmaxtxt.getText().isBlank())
                    || nazwasilnikatxt.getText().isBlank() || cenasilnikatxt.getText().isBlank() || maxobrotytxt.getText().isBlank()
                    || nazwaskrzynitxt.getText().isBlank() || cenaskrzynitxt.getText().isBlank() || nazwasprzeglatxt.getText().isBlank()
                    || cenasprzeglatxt.getText().isBlank() || (!check5biegow.isSelected() && (!check6biegow.isSelected()))
                    || ((check6biegow.isSelected()) && (check5biegow.isSelected()))) {
                    infotxt.setText("Nie wybrano wszystkich ustawień bądź wprowadzono złe dane");
                } else {
                    Silnik silnik = new Silnik(nazwasilnikatxt.getText(), slider2.getValue(), Double.parseDouble(cenasilnikatxt.getText()), Integer.parseInt(maxobrotytxt.getText()));
                    Sprzeglo sprzeglo = new Sprzeglo(nazwasprzeglatxt.getText(), slider3.getValue(), Double.parseDouble(cenasprzeglatxt.getText()));
                    Pozycja start = new Pozycja(0,0);
                    int iloscbiegow;
                    if (check5biegow.isSelected()) {
                        iloscbiegow = 5;
                    } else { iloscbiegow = 6; }
                    SkrzyniaBiegow skrzynia = new SkrzyniaBiegow(nazwaskrzynitxt.getText(), slider1.getValue(), Double.parseDouble(cenaskrzynitxt.getText()), iloscbiegow, sprzeglo);
                    Samochod car = new Samochod(nrRejtxt.getText(), modeltxt.getText(), Integer.parseInt(predmaxtxt.getText()), skrzynia, silnik, start);
                    comboBox.addItem(car);
                    panel.dispose();
                    caricon.setVisible(true);
                }
            }
        });

        anulujButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                panel.dispose();
            }
        });
    }
    public static void main(String [] args){

    }
}
