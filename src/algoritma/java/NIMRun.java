package algoritma.java;

import java.util.Scanner;

public class NIMRun {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Masukkan NIM Kamu =");
        String nim = input.nextLine();
        NIM objNim = new NIM();
        objNim.setNim(nim);
        System.out.println("Jenjang Pendidikan = "+objNim.getJenjangPendidikan());
        System.out.println("Tahun Masuk = "+objNim.getTahunMasuk());
        System.out.println("Fakultas = "+objNim.getFakultas());
        System.out.println("Jurusan = "+objNim.getJurusan());
        System.out.println("Jenis Kelamin = "+objNim.getJenisKelamin());
        System.out.println("No Urut = "+objNim.getNoUrut());

    }
}