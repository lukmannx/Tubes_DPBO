package com.bakekok.tubes_dpbo.model.pengguna;

import com.bakekok.tubes_dpbo.interfaces.IPenyimpananData;
import com.bakekok.tubes_dpbo.model.lapangan.Lapangan;
import com.bakekok.tubes_dpbo.model.transaksi.Pemesanan;

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
    String status = pesanan.getStatusPemesanan();

    if (status.equals("Dibatalkan")) {
        System.out.println("Gagal: Pemesanan " + pesanan.getIdPemesanan() + 
                           " sudah DIBATALKAN, tidak bisa dikonfirmasi.");
        return;
    }

    if (status.equals("Lunas")) {
        System.out.println("Gagal: Pemesanan " + pesanan.getIdPemesanan() + 
                           " sudah LUNAS sebelumnya.");
        return;
    }

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

    // Fitur  Tambah Lapangan
    public void tambahLapangan(Lapangan lapangan, IPenyimpananData db) {
        db.simpanData(lapangan);
        System.out.println("Lapangan '" + lapangan.getNamaLapangan() + "' berhasil ditambahkan oleh Admin.");
    }

    @Override
    public String toString() {
        return "Admin [" + super.toString() + ", Kode: " + kodeAdmin + "]";
    }
}
