import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class Projekt  {
    private JLabel label;
    private JPanel Trasa1;
    private JTextField dlugosctrasy;
    private JTextField cena;
    private JTextField iloscpasazerow;
    private JLabel koszt;
    private JTextField polekoszt;
    private JLabel przychod;
    private JTextField wartoscprzychodu;
    protected JTextField zysk;
    private JButton oblicz;
    private JButton zmniejsz;
    private JButton zwieksz;
    private JButton a1Button;
    private JTextField trasa;
    public Projekt() {
        dlugosctrasy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dlugosctrasy.setText("0");
            }
        });
        cena.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cena.setText("0");
            }
        });
        iloscpasazerow.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        polekoszt.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        wartoscprzychodu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            }
        });
        zysk.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        oblicz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                double dlugososctrasy;
                dlugososctrasy= Double.parseDouble(dlugosctrasy.getText());
                if (dlugososctrasy<0)
                {
                    String a1="długość trasy nie może być ujemna, zmieniono na 0";
                    System.out.println(a1);
                    dlugosctrasy.setText("0");
                    iloscpasazerow.setText("0");
                }
                if (dlugososctrasy>1000)
                {
                    String a1="za długa trasa, zmieniono na 1000 km";
                    System.out.println(a1);
                    dlugosctrasy.setText("1000");
                }
                System.out.println();
                double koszt= Double.parseDouble(dlugosctrasy.getText())*Koszty.cena_za_km;
                polekoszt.setText(String.valueOf(koszt));
                double cenaBiletu= Double.parseDouble(cena.getText());
                if (cenaBiletu<0) {
                    String a2="długość trasy nie może być ujemna, zmieniono na 0";
                    System.out.println(a2);
                        cena.setText("0");
                        iloscpasazerow.setText("40");
                        polekoszt.setText("0");
                }
                if (cenaBiletu>10) {System.out.println("brak pasażerów przy cenie wiekszej lub równej 10");
                    iloscpasazerow.setText("0");
                    cena.setText("10");
                }
                if (cenaBiletu==0) System.out.println("przy darmowych biletach wyniesie 0");
                if (cenaBiletu<=10 && cenaBiletu>0) {
                    double i = Double.parseDouble(cena.getText());
                    i = i * -4 + 40; //obliczenie ilosc pasazerow
                    String s1 = iloscpasazerow.getText();
                    int j = (int) i;
                    s1 = String.valueOf(j);
                    iloscpasazerow.setText(s1);
                }
                double p= Double.parseDouble(iloscpasazerow.getText());
                double t= Double.parseDouble(dlugosctrasy.getText());
                p=p*cenaBiletu*t;
                wartoscprzychodu.setText("0");
                zysk.setText("0");
                if (cenaBiletu<=10 && cenaBiletu>0) {
                    wartoscprzychodu.setText(String.valueOf(p));
                    double z = p - Double.parseDouble(polekoszt.getText());
                    zysk.setText(String.valueOf(z));
                }
            }
        });
        zmniejsz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Koszty.zmniejszCene();
                double a= Double.parseDouble(cena.getText());
                a=a-0.25;
                if (a<0) {
                    String a2="cena nie może być ujemna, zmieniono na 0";
                    System.out.println(a2);
                    cena.setText("0");
                    iloscpasazerow.setText("40");
                    polekoszt.setText("0");
                }
                cena.setText(String.valueOf(a));
            }
        });
        zwieksz.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            Koszty.zwiekszCene();
                double a= Double.parseDouble(cena.getText());
                a=a+0.25;
                if (a>10) {
                    String a2="cena nie może być wieksza niz 10, zmieniono na 10";
                    System.out.println(a2);
                    cena.setText("10");
                    iloscpasazerow.setText("0");
                }
               else cena.setText(String.valueOf(a));
            }
        });
    }
    public static void main(String[] args) {
        JFrame frame =new JFrame();
        frame.setContentPane((new Projekt().Trasa1));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}