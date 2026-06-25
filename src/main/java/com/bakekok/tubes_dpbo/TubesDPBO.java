package com.bakekok.tubes_dpbo;

import com.bakekok.tubes_dpbo.database.DatabaseLokal;
import com.bakekok.tubes_dpbo.interfaces.IMetodePembayaran;
import com.bakekok.tubes_dpbo.model.lapangan.Jadwal;
import com.bakekok.tubes_dpbo.model.lapangan.Lapangan;
import com.bakekok.tubes_dpbo.model.pembayaran.EWallet;
import com.bakekok.tubes_dpbo.model.pembayaran.TransferBank;
import com.bakekok.tubes_dpbo.model.pengguna.Admin;
import com.bakekok.tubes_dpbo.model.pengguna.Pelanggan;
import com.bakekok.tubes_dpbo.model.pengguna.Pengguna;
import com.bakekok.tubes_dpbo.model.transaksi.Pembayaran;
import com.bakekok.tubes_dpbo.model.transaksi.Pemesanan;
import com.bakekok.tubes_dpbo.model.transaksi.Ulasan;

import java.util.Scanner;

/**
 *
 * @author bakekok
 */
public class TubesDPBO {
    private static DatabaseLokal db = new DatabaseLokal();
    private static Scanner scanner = new Scanner(System.in);
    private static Pengguna currentUser = null;
    
    private static int bacaInt() {
    try { return Integer.parseInt(scanner.nextLine()); }
    catch (NumberFormatException e) { System.out.println("Input tidak valid! Masukkan angka."); return -1; }
}

    private static double bacaDouble() {
    try { return Double.parseDouble(scanner.nextLine()); }
    catch (NumberFormatException e) { System.out.println("Input tidak valid! Masukkan angka."); return -1; }
}
    public static void main(String[] args) {
        inisialisasiDataAwal();

        boolean isRunning = true;
        while (isRunning) {
            if (currentUser == null) {
                System.out.println("\n=== SISTEM MANAJEMEN RESERVASI LAPANGAN FUTSAL ===");
                System.out.println("1. Login Admin");
                System.out.println("2. Login Pelanggan");
                System.out.println("3. Register Pelanggan");
                System.out.println("0. Keluar Aplikasi"); // Kembali/Keluar utama
                System.out.print("Pilih opsi: ");

                String input = scanner.nextLine();
                if (input.equals("0")) {
                    isRunning = false;
                    System.out.println("Aplikasi ditutup. Terima kasih.");
                    break;
                }

                int pilihan = Integer.parseInt(input);
                switch (pilihan) {
                    case 1: login(true); break;
                    case 2: login(false); break;
                    case 3: register(); break;
                    default: System.out.println("Opsi tidak valid.");
                }
            } else {
                if (currentUser instanceof Admin) menuAdmin();
                else if (currentUser instanceof Pelanggan) menuPelanggan();
            }
        }
    }

    private static void inisialisasiDataAwal() {
        Admin admin = new Admin("A01", "Danish Admin", "admin@futsal.com", "admin123", "ADM-001");
        Pelanggan p1 = new Pelanggan("P01", "Lukman", "lukman@gmail.com", "123", "08111222333");

        Lapangan lap1 = new Lapangan("L01", "Lapangan Sintetis A", "Sintetis", 12000);
        lap1.tambahJadwal(new Jadwal("2023-12-01", "18:00", "19:00"));
        lap1.tambahJadwal(new Jadwal("2023-12-01", "19:00", "20:00"));

        Lapangan lap2 = new Lapangan("L02", "Lapangan Vinyl B", "Vinyl", 15000);
        lap2.tambahJadwal(new Jadwal("2023-12-01", "20:00", "21:00"));
        lap2.tambahJadwal(new Jadwal("2023-12-02","20:00","22:00"));

        db.simpanData(admin);
        db.simpanData(p1);
        db.simpanData(lap1);
        db.simpanData(lap2);
    }

    private static void login(boolean isAdmin) {
        System.out.println("\n[Ketik '0' pada email untuk KEMBALI]");
        System.out.print("Masukkan Email: "); String email = scanner.nextLine();
        if (email.equals("0")) return; // Logika Kembali

        System.out.print("Masukkan Password: "); String password = scanner.nextLine();

        for (Pengguna p : db.getTabelPengguna()) {
            if (p.getEmail().equals(email) && p.getPassword().equals(password)) {
                if ((isAdmin && p instanceof Admin) || (!isAdmin && p instanceof Pelanggan)) {
                    p.login();
                    currentUser = p;
                    System.out.println("\n--- Login Sukses! Selamat datang, " + p.getNama() + " ---");
                    return;
                }
            }
        }
        System.out.println("Login Gagal. Email/Password salah atau hak akses tidak sesuai.");
    }
    
    private static void lihatUlasan() {
        System.out.println("\n=== DAFTAR ULASAN ===");
        if (db.getTabelUlasan().isEmpty()) {
            System.out.println("Belum ada ulasan masuk.");
            return;
        }
        for (Ulasan u : db.getTabelUlasan()) {
            System.out.println(u);
        }
    }

    private static void register() {
        System.out.println("\n[Ketik '0' pada nama untuk KEMBALI]");
        System.out.print("Nama: "); String nama = scanner.nextLine();
        if (nama.equals("0")) return; // Logika Kembali

        System.out.print("Email: "); String email = scanner.nextLine();
        //fix email double
            for (Pengguna p : db.getTabelPengguna()) {
                if (p.getEmail().equals(email)) {
                System.out.println("Gagal: Email sudah terdaftar!");
                return;
              }
            }
        System.out.print("Password: "); String password = scanner.nextLine();
        System.out.print("No Telp: "); String noTelp = scanner.nextLine();

        String id = "P" + System.currentTimeMillis();
        Pelanggan p = new Pelanggan(id, nama, email, password, noTelp);
        db.simpanData(p);
        System.out.println("Registrasi berhasil. Silakan kembali untuk login.");
    }

    private static void menuAdmin() {
        Admin admin = (Admin) currentUser;
        System.out.println("\n=== DASHBOARD ADMIN ===");
        System.out.println("1. Lihat Daftar Lapangan");
        System.out.println("2. Lihat Daftar Pemesanan Masuk");
        System.out.println("3. Konfirmasi Pemesanan");
        System.out.println("4. Hapus Pemesanan");
        System.out.println("5. Tambah Lapangan Baru");
        System.out.println("6. Lihat Ulasan/Komentar");
        System.out.println("0. Logout");
        System.out.print("Pilih aksi: ");
        int pilihan = bacaInt();

        switch (pilihan) {
            case 1:
                System.out.println("\n[Daftar Lapangan]");
                for (Lapangan l : db.getTabelLapangan()) System.out.println(l);
                break;
            case 2:
                System.out.println("\n[Daftar Pemesanan Masuk]");
                if (db.getTabelPemesanan().isEmpty()) System.out.println("Belum ada pemesanan.");
                for (Pemesanan p : db.getTabelPemesanan()) System.out.println(p);
                break;
            case 3:
                System.out.print("Masukkan ID Pemesanan yang dikonfirmasi (atau '0' untuk kembali): ");
                String idKonfirm = scanner.nextLine();
                if (idKonfirm.equals("0")) break;

                Pemesanan pesananKonfirm = db.cariPesanan(idKonfirm);
                if (pesananKonfirm != null) admin.konfirmasiPemesanan(pesananKonfirm);
                else System.out.println("Pemesanan tidak ditemukan.");
                break;
            case 4:
                System.out.print("Masukkan ID Pemesanan yang akan DIHAPUS (atau '0' untuk kembali): ");
                String idHapus = scanner.nextLine();
                if (idHapus.equals("0")) break;

                Pemesanan pesananHapus = db.cariPesanan(idHapus);
                if (pesananHapus != null) admin.hapusPemesanan(pesananHapus, db);
                else System.out.println("Pemesanan tidak ditemukan.");
                break;
            case 5:
                tambahLapanganBaru(admin);
                break;
                case 6:
                lihatUlasan();
                break;
            case 0:
                currentUser.logout();
                currentUser = null;
                break;
            default: System.out.println("Opsi tidak valid.");
        }
    }

    private static void menuPelanggan() {
        Pelanggan pelanggan = (Pelanggan) currentUser;
        System.out.println("\n=== DASHBOARD PELANGGAN ===");
        System.out.println("1. Lihat Daftar Lapangan & Jadwal");
        System.out.println("2. Buat Pesanan Baru");
        System.out.println("3. Batalkan Pesanan");
        System.out.println("4. Lihat Riwayat Booking");
        System.out.println("5. Beri Ulasan Lapangan");
        System.out.println("0. Logout");
        System.out.print("Pilih aksi: ");
        int pilihan = bacaInt();

        switch (pilihan) {
            case 1:
                for (Lapangan l : db.getTabelLapangan()) {
                    System.out.println("\n" + l);
                    for (int i = 0; i < l.getDaftarJadwal().size(); i++) {
                        System.out.println("  " + (i + 1) + ". " + l.getDaftarJadwal().get(i));
                    }
                }
                break;
            case 2:
                System.out.print("\nPilih Lapangan (1 - " + db.getTabelLapangan().size() + ") atau ketik '0' untuk KEMBALI: ");
               int inputLap = bacaInt();
                if (inputLap == 0) break;

                int idxLap = inputLap - 1;
                if (idxLap >= 0 && idxLap < db.getTabelLapangan().size()) {
                    Lapangan lap = db.getTabelLapangan().get(idxLap);
                    System.out.print("Pilih Jadwal (1 - " + lap.getDaftarJadwal().size() + ") atau ketik '0' untuk KEMBALI: ");
                    int inputJadwal = bacaInt();
                    if (inputJadwal == 0) break;

                    int idxJadwal = inputJadwal - 1;
                    if (idxJadwal >= 0 && idxJadwal < lap.getDaftarJadwal().size()) {
                        Jadwal jadwalTerpilih = lap.getDaftarJadwal().get(idxJadwal);
                        if (!lap.cekKetersediaan(jadwalTerpilih)) {
                            System.out.println("Maaf, Jadwal sudah dipesan oleh orang lain.");
                            break;
                        }

                        Pemesanan pesananBaru = pelanggan.buatPesanan(lap, jadwalTerpilih);
                        db.simpanData(pesananBaru);

                        System.out.println("\n--- SILAKAN LAKUKAN PEMBAYARAN ---");
                        System.out.println("1. Transfer Bank (BCA) \n2. E-Wallet (GoPay)");
                        System.out.print("Pilih metode (atau '0' untuk batal bayar): ");
                        int pilBayar = bacaInt();
                        if (pilBayar == 0) {
                            pelanggan.batalkanPesanan(pesananBaru.getIdPemesanan());
                            break;
                        }

                        IMetodePembayaran metode = (pilBayar == 1) ?
                            new TransferBank("BCA", "123456789") : new EWallet("GoPay", "08111222333");

                        Pembayaran bayar = new Pembayaran("PAY-" + System.currentTimeMillis(), pesananBaru, metode, "Hari Ini");
                        bayar.eksekusiPembayaran();
                        System.out.println(bayar.cetakStruk());
                    }
                }
                break;
            case 3:
                System.out.print("Masukkan ID Pesanan yang dibatalkan (atau '0' untuk kembali): ");
                String idBatal = scanner.nextLine();
                if (idBatal.equals("0")) break;

                pelanggan.batalkanPesanan(idBatal);
                break;
            case 4:
                System.out.println("\n" + pelanggan.getRiwayat());
                break;
            case 5:
                System.out.print("Masukkan ID Lapangan (atau '0' untuk kembali): ");
                String idLap = scanner.nextLine();
                if (idLap.equals("0")) break;

                System.out.print("Beri Rating (1-5): "); int rating = bacaInt();
                System.out.print("Komentar: "); String komentar = scanner.nextLine();

                Lapangan targetLap = null;
                for (Lapangan l : db.getTabelLapangan()) {
                    if (l.getIdLapangan().equals(idLap)) targetLap = l;
                }

                if (targetLap != null) {
                    Ulasan ulasan = new Ulasan("UL-" + System.currentTimeMillis(), pelanggan, targetLap, rating, komentar);
                    ulasan.tambahUlasan();
                    db.simpanData(ulasan);
                } else {
                    System.out.println("Lapangan tidak ditemukan.");
                }
                break;
            case 0:
                currentUser.logout();
                currentUser = null;
                break;
            default: System.out.println("Opsi tidak valid.");
        }
    }

    private static void tambahLapanganBaru(Admin admin) {
        System.out.println("\n[Ketik '0' pada ID untuk KEMBALI]");
        System.out.print("ID Lapangan   : "); String id = scanner.nextLine();
        if (id.equals("0")) return;

        System.out.print("Nama Lapangan : "); String nama = scanner.nextLine();
        System.out.print("Jenis Rumput  : "); String rumput = scanner.nextLine();
        System.out.print("Harga per Jam : "); double harga = Double.parseDouble(scanner.nextLine());

        Lapangan lapanganBaru = new Lapangan(id, nama, rumput, harga);

        System.out.print("Tambah jadwal sekarang? (y/n): ");
        String jawab = scanner.nextLine();
        if (jawab.equalsIgnoreCase("y")) {
            boolean tambahLagi = true;
            while (tambahLagi) {
                System.out.print("  Tanggal (yyyy-mm-dd) : "); String tgl = scanner.nextLine();
                System.out.print("  Jam Mulai (HH:mm)    : "); String jamMulai = scanner.nextLine();
                System.out.print("  Jam Selesai (HH:mm)  : "); String jamSelesai = scanner.nextLine();
                lapanganBaru.tambahJadwal(new Jadwal(tgl, jamMulai, jamSelesai));
                System.out.println("  Jadwal berhasil ditambahkan.");
                System.out.print("  Tambah jadwal lagi? (y/n): ");
                tambahLagi = scanner.nextLine().equalsIgnoreCase("y");
            }
        }

        admin.tambahLapangan(lapanganBaru, db);
    }
}
