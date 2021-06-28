package TugasUAS;


//Import Dependencies
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.LinkedList;
import java.util.Queue;

//Inisialisasi Kelas
public class AplikasiVaksin {

    //Deklarasi Atribut GUI
    private JTextField textNama;
    private JTextField textAlamat;
    private JTextField textPekerjaan;
    private JTextField textUmur;
    private JTextField textNoHp;
    private JButton buttonSimpan;
    private JTable tableSorting;
    private JPanel rootPanel;
    private JButton prosesAntrianButton;
    private JScrollPane jumlahAntrian;
    private JScrollPane totalAntrian;
    private JScrollPane panggilanAntrian;
    private JTextField textJumlah;
    private JTextField textTotal;
    private JTextField textPanggilan;
    private JTextArea textAntrianDaftar;
    private JTextField textCari;
    private JTextArea textdaftar;
    private JList textDaftar;
    private JPanel textAntrian;
    DefaultTableModel tableModel;
    private boolean added = false;

    //Deklarasi Method Panel Utama GUI
    public JPanel getRootPanel() {
        return rootPanel;
    }

    //Deklarasi Konstruktor Kelas
    public AplikasiVaksin() {

        //Memanggil Method
        this.initComponents();
        this.inisialisasi();
        this.sort();

        //Aksi tombol simpan
        buttonSimpan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent event) {

                //Deklarasi Model Tabel
                DefaultTableModel model = (DefaultTableModel) tableSorting.getModel();

                //Inisialisasi object tabel
                //mengambil data dari inputan jtextfield
                Object[] data = new Object[6];
                data[0]=textNama.getText();
                data[1]=textAlamat.getText();
                data[2]=textPekerjaan.getText();
                data[3]=textUmur.getText();
                data[4]=textNoHp.getText();

                //menghitung jumlah baris tabel
                data[5]=tableSorting.getRowCount()+1;

                //menambah baris baru
                model.addRow(data);

                //memangiil fungsi tambahAntrian
                tambahAntrian();

                //Tampilkan data di console
                System.out.println(tableSorting.getRowCount());

                String nama=textNama.getText();
                System.out.println("Nama =" +nama);
                String alamat =textAlamat.getText();
                System.out.println("Alamat =" +alamat);
                String Pekerjaan =textPekerjaan.getText();
                System.out.println("Pekerjaan =" +Pekerjaan);
                String Umur =textUmur.getText();
                System.out.println("Umur =" +Umur);
                String NoHP =textNoHp.getText();
                System.out.println("No Hp =" +NoHP);

                //Tampilkan nomor antrian
                JOptionPane.showMessageDialog(rootPanel, "NO ANTRIAN ANDA ADALAH " +tableSorting.getRowCount(), "Information", JOptionPane.INFORMATION_MESSAGE);

                //menghilangkan nilai inputan di jtexfield
                textNama.setText("");
                textAlamat.setText("");
                textPekerjaan.setText("");
                textUmur.setText("");
                textNoHp.setText("");

            }
        });

        //aksi tombol proses antrian
        prosesAntrianButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //panggil fungsi prosesAntrian
                prosesAntrian();

                //convert jumlah antrian ke string
                String cvt = String.valueOf(antrian.size());
                //cetak jumlah antrian
                textJumlah.setText(cvt);

                //tampilkan pesan jika jumlah antrian = 0
                if (antrian.size() == 0){
                    JOptionPane.showMessageDialog(rootPanel,
                            "ANTRIAN SUDAH HABIS",
                            "Information",
                            JOptionPane.WARNING_MESSAGE);

                }
            }
        });

        //aksi inputan cari
        textCari.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                super.keyReleased(e);
                //inisialisasi variabel query dan jadikan inputan huruf kecil semua
                String query = textCari.getText().toLowerCase();
                //panggil method filter
                filter(query);
            }
        });
    }

    //Inisialisasi dan pembuatan object LinkedList
    Queue<Object> antrian = new LinkedList<>();
    //inisialisasi nomor
    int nomor = 0;

    //inisialisasi fungsi
    private void inisialisasi() {
        textJumlah.setText("0");
        textTotal.setText("0");
        textPanggilan.setText("-----");
    }

    //inisialisasi fungsi tambahAntrian
    private void tambahAntrian(){
        //nomor bertambah 1 setiap fungsi dijalankan
        nomor++;

        //inisialisasi antrian
        String antr = "Antrian "+nomor;
        antrian.add(antr);
        String cvt = String.valueOf(antrian.size());
        textJumlah.setText(cvt);
        textPanggilan.setText(""+antrian.peek());
        textTotal.setText(""+nomor);
        textAntrianDaftar.append(antr +"\n");

    }

    //inisialisasi fungsi prosesAntrian
    private void prosesAntrian() {

        textAntrianDaftar.setText("");
        antrian.poll();
        antrian.forEach((Object element) -> {
            textAntrianDaftar.append("" + element + "\n");
        });
        if (antrian.isEmpty()) {
            textPanggilan.setText("---");
        } else {
            textPanggilan.setText("" + antrian.peek());
        }

    }

    //inisialisasi fungsi filter
    private void filter(String query){
        TableRowSorter<DefaultTableModel> tr = new TableRowSorter<DefaultTableModel>(tableModel);
        tableSorting.setRowSorter(tr);
        tr.setRowFilter(RowFilter.regexFilter(query));
    }

    //inisialisasi fungsi sort
    private void sort(){
        TableRowSorter<DefaultTableModel> sorter = new TableRowSorter<DefaultTableModel>(tableModel);
        tableSorting.setRowSorter(sorter);
    }

    //inisialisasi komponen tabel
    private void initComponents(){
        Object[] tableColom = {
                "Nama",
                "Alamat",
                "Pekerjaan",
                "Umur",
                "No HP",
                "No Antrian"
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


