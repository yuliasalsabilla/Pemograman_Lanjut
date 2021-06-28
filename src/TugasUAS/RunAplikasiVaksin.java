package TugasUAS;

import javax.swing.*;

public class RunAplikasiVaksin {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ignored) {
        }

        JFrame jFrame = new JFrame("Aplikasi Untuk Pendaftaran Vaksin Covid-19");
        jFrame.setContentPane(new AplikasiVaksin().getRootPanel());
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setSize(500,400);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }
}


