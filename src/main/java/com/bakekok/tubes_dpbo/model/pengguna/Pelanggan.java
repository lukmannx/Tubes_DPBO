package com.bakekok.tubes_dpbo.model.pengguna;

import com.bakekok.tubes_dpbo.model.lapangan.Jadwal;
import com.bakekok.tubes_dpbo.model.lapangan.Lapangan;
import com.bakekok.tubes_dpbo.model.transaksi.Pemesanan;
import com.bakekok.tubes_dpbo.model.transaksi.RiwayatBooking;

/**
 *
 * @author bakekok
 */
public class Pelanggan extends Pengguna {
    private String noTelepon;
    private RiwayatBooking riwayat;

    public Pelanggan(String idPengguna, String nama, String email, String password, String noTelepon) {
        super(idPengguna, nama, email, password);
        this.noTelepon = noTelepon;
        this.riwayat = new RiwayatBooking();
    }

    public Pemesanan buatPesanan(Lapangan lapangan, Jadwal jadwal) {
        String idPesanan = "PES-" + System.currentTimeMillis();
        Pemesanan pesanan = new Pemesanan(idPesanan, this, lapangan, jadwal);
        riwayat.tambahRiwayat(pesanan);
        jadwal.setTersedia(false); // Blokir jadwal karena sudah di-booking
        return pesanan;
    }

    public boolean batalkanPesanan(String idPemesanan) {
        for (Pemesanan p : riwayat.tampilkanSemuaRiwayat()) {
            // Cek apakah ID cocok
            if (p.getIdPemesanan().equals(idPemesanan)) {

                // Bisa dibatalkan HANYA JIKA statusnya "Pending" ATAU "Menunggu Konfirmasi Admin"
                if (p.getStatusPemesanan().equals("Pending") ||
                    p.getStatusPemesanan().equals("Menunggu Konfirmasi Admin")) {

                    p.ubahStatus("Dibatalkan");
                    p.getWaktuMain().setTersedia(true); // Jadwal kembali kosong/tersedia
                    System.out.println("Pesanan " + idPemesanan + " berhasil dibatalkan secara mandiri.");
                    return true;
                } else {
                    System.out.println("Gagal: Pesanan ini sudah berstatus '" + p.getStatusPemesanan() + "' dan tidak bisa dibatalkan lagi.");
                    return false;
                }
            }
        }
        System.out.println("Gagal: Pesanan dengan ID " + idPemesanan + " tidak ditemukan di riwayat Anda.");
        return false;
    }

    public RiwayatBooking getRiwayat() { return riwayat; }

    @Override
    public String toString() {
        return "Pelanggan [" + super.toString() + ", No Telp: " + noTelepon + "]";
    }
}
