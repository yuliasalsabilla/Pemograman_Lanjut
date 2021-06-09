package guiSwing;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FormSorting {
    private JPanel rootPanel;
    private JTextField textData;
    private JButton buttonUrut;
    private JTable tableSorting;
    private JButton buttonSelesai;
    private JTextField textJumlah;
    private DefaultTableModel tableModel;
    private boolean added = false;

    public JPanel getRootPanel() {

        return rootPanel;
    }

    public FormSorting() {
        this.initComponents();

        buttonUrut.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DefaultTableModel model = (DefaultTableModel) tableSorting.getModel();
                String input = textData.getText();
                String[] tmp = input.split(",");
                String data = textData.getText();
                int size = tmp.length;
                System.out.println(tmp.length);

                if (data.isBlank()){
                    JOptionPane.showMessageDialog(rootPanel,
                            "Inputkan Data Angka Terlebih Dahulu",
                            "Warning",
                            JOptionPane.WARNING_MESSAGE);
                    return;
                }

                if (!added) {
                    for (int i = 0; i < size; i++) {
                        model.addRow(new Object[]{});
                    }
                    added = true;
                }
                int x = 0;
                for (int i : Pengurutan.getascending(input, size)){
                    model.setValueAt(i, x, 0);
                    x++;
                }
                int y = 0;
                for (int i : Pengurutan.getdescending(input, size)){
                    model.setValueAt(i, y, 1);
                    y++;
                }

            }
        });
        buttonSelesai.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                textData.setText("");
                tableModel.setRowCount(0);
                added = false;
            }
        });
    }

    private void initComponents(){
        Object[] tableColom = {
                "ASCENDING",
                "DESCENDING"
        };
        Object[][] initData = {

        };
        tableModel = new DefaultTableModel(initData, tableColom);
        //Set table model
        tableSorting.setModel(tableModel);
        //Menampilkan Sorting di setiap colom
        tableSorting.setAutoCreateRowSorter(true);
        //Enable single selection
        tableSorting.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
}
}
