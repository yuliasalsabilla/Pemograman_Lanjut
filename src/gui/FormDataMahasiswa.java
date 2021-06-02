package gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormDataMahasiswa {
    private JTextField textNim;
    private JButton buttonPencarian;
    private JPanel lootPanel;
    private JLabel LabelNim;
    private JLabel LabelJenjang;
    private JLabel LabelAngkatan;
    private JLabel LabelFakultas;
    private JLabel LabelJurusan;
    private JLabel LabelNoUrut;
    private JLabel LabelJK;
    private JLabel LabelError;
    private JPanel bootPanel;
    private JButton selesaiButton;
    private JTextField textNama;

    public FormDataMahasiswa() {
        bootPanel.setVisible(false);
        buttonPencarian.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String nama = textNama.getText();
                String angka = textNim.getText();

                Nim nim = new Nim();
                nim.setNim(angka);
                if ((!angka.matches("[0-9]+")) || (nim.getJenisKelamin()=="") || (nim.getJenjangPendidikan()=="") || (nim.getNoUrut()=="") || (nim.getTahunMasuk()=="") || (nim.getJurusan()=="") || (nim.getFakultas()=="")){
                    LabelError.setText(nim.Error());
                    bootPanel.setVisible(false);
                }
                else {
                    bootPanel.setVisible(true);
                    LabelError.setVisible(false);

                    LabelNim.setText(angka);
                    LabelJenjang.setText(nim.getJenjangPendidikan());
                    LabelAngkatan.setText(nim.getTahunMasuk());
                    LabelFakultas.setText(nim.getFakultas());
                    LabelJurusan.setText(nim.getJurusan());
                    LabelJK.setText(nim.getJenisKelamin());
                    LabelNoUrut.setText(nim.getNoUrut());
                }
            }
        });
        selesaiButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textNim.setText("");
                textNama.setText("");
                bootPanel.setVisible(false);
                LabelError.setVisible(false);
            }
        });
    }

    public JPanel getLootPanel() {

        return lootPanel;
    }
}
