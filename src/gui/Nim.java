package gui;

public class Nim {
    private String nama;
    private String nim;

    public Nim() {
    }

    public Nim(String nama, String nim) {
        this.nama = nama;
        this.nim = nim;
    }

    public String getNama() {

        return nama;
    }

    public void setNama(String nama) {

        this.nama = nama;
    }

    public String getNim() {

        return nim;
    }

    public void setNim(String nim) {

        this.nim = nim;
    }

    @Override
    public String toString() {
        return "Mahasiswa{" +
                "nama='" + nama + '\'' +
                ", nim='" + nim + '\'' +
                '}';
    }
    public String getJenjangPendidikan() {
        char a = nim.charAt(0);
        if (a == '1') {
            return "S1 (Sarjana)";
        } else if (a == '2') {
            return "S2 (Magister)";
        } else if (a == '3') {
            return "S3 (Doktor)";
        }
        else {
            return "";
        }
    }
    public String getTahunMasuk() {
        char g = nim.charAt(1);
        char h = nim.charAt(2);
        int i = 20;
        return "" +i +g +h;
    }
    public String getFakultas() {
        char x = nim.charAt(3);
        if (x == '1') {
            return "Tarbiyah dan Keguruan";
        } else if (x == '2') {
            return "Syariah dan Hukum";
        } else if (x == '3') {
            return "Ushuluddin";
        } else if (x == '4') {
            return "Dakwah dan Komunikasi";
        } else if (x == '5') {
            return "Sains dan Teknologi";
        } else if (x == '6') {
            return "Psikologi";
        } else if (x == '7') {
            return "Ekonomi dan Ilmu Sosial";
        } else if (x == '8') {
            return "Pertanian dan Peternakan";
        }
        else{
            return "";
        }

    }

    public String getJurusan() {
        char p = nim.charAt(4);
        char q = nim.charAt(5);
        if (p == '0' && q == '1') {
            return "Teknik Informatika";
        } else if (p == '0' && q == '2') {
            return "Teknik Industri";
        } else if (p == '0' && q == '3') {
            return "Sistem Informasi";
        } else if (p == '0' && q == '4') {
            return "Matematika";
        } else if (p == '0' && q == '5'){
            return "Teknik Elektro";
        }
        return "";
    }

    public String getJenisKelamin(){
        char s = nim.charAt(6);
        if(s == '1'){
            return "Laki-Laki";
        }else if(s == '2'){
            return "Perempuan";
        }
        return "";
    }

    public String getNoUrut(){
        char c = nim.charAt(7);
        char d = nim.charAt(8);
        char e = nim.charAt(9);
        char f = nim.charAt(10);
        return "" +c +d +e +f;
    }
    public String Error(){
        return "NIM ANDA TIDAK VALID";
    }

}
