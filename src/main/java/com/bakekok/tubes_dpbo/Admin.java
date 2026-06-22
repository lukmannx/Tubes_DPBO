/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bakekok.tubes_dpbo;

/**
 *
 * @author bakekok
 */
public class Admin extends Pengguna {
    private String kodeAdmin;

    public Admin(String idPengguna, String nama, String email, String password, String kodeAdmin) {
        super(idPengguna, nama, email, password);
        this.kodeAdmin = kodeAdmin;
    }

    public void konfirmasiPemesanan(Pemesanan pesanan) {
        pesanan.ubahStatus("Lunas");
        System.out.println("Pemesanan " + pesanan.getIdPemesanan() + " telah dikonfirmasi.");
    }

    // Fitur Baru: Hapus Pesanan (Hard Delete)
    public void hapusPemesanan(Pemesanan pesanan, IPenyimpananData db) {
        // 1. Hapus dari database sentral
        db.hapusData(pesanan);
        // 2. Hapus dari riwayat individu pelanggan
        pesanan.getPemesan().getRiwayat().tampilkanSemuaRiwayat().remove(pesanan);
        // 3. Bebaskan kembali jadwal lapangan (Sangat penting!)
        pesanan.getWaktuMain().setTersedia(true);
        
        System.out.println("Pemesanan " + pesanan.getIdPemesanan() + " berhasil DIHAPUS permanen oleh Admin.");
    }

    @Override
    public String toString() {
        return "Admin [" + super.toString() + ", Kode: " + kodeAdmin + "]";
    }
}