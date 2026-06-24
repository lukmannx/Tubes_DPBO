package com.bakekok.tubes_dpbo.model.transaksi;

import com.bakekok.tubes_dpbo.model.pengguna.Pelanggan;
import com.bakekok.tubes_dpbo.model.lapangan.Lapangan;
import com.bakekok.tubes_dpbo.model.lapangan.Jadwal;

/**
 *
 * @author bakekok
 */
public class Pemesanan {
    private String idPemesanan;
    private Pelanggan pemesan;
    private Lapangan lapanganDipilih;
    private Jadwal waktuMain;
    private double totalBiaya;
    private String statusPemesanan;

    public Pemesanan(String idPemesanan, Pelanggan pemesan, Lapangan lapanganDipilih, Jadwal waktuMain) {
        this.idPemesanan = idPemesanan;
        this.pemesan = pemesan;
        this.lapanganDipilih = lapanganDipilih;
        this.waktuMain = waktuMain;
        this.statusPemesanan = "Pending";
        this.totalBiaya = hitungTotalBiaya();
    }

    public double hitungTotalBiaya() {
    String[] mulai   = waktuMain.getJamMulai().split(":");
    String[] selesai = waktuMain.getJamSelesai().split(":");
    int menitMulai   = Integer.parseInt(mulai[0]) * 60 + Integer.parseInt(mulai[1]);
    int menitSelesai = Integer.parseInt(selesai[0]) * 60 + Integer.parseInt(selesai[1]);
    double durasiJam = (menitSelesai - menitMulai) / 60.0;
    return lapanganDipilih.getHargaPerJam() * durasiJam;
    }
    public void ubahStatus(String statusBaru) { this.statusPemesanan = statusBaru; }

    public String getIdPemesanan() { return idPemesanan; }
    public String getStatusPemesanan() { return statusPemesanan; }
    public Jadwal getWaktuMain() { return waktuMain; }
    public double getTotalBiaya() { return totalBiaya; }
    public Pelanggan getPemesan() { return pemesan; }

    @Override
    public String toString() {
        return "Pemesanan [ID: " + idPemesanan + ", Pemesan: " + pemesan.getNama() +
               ", Lapangan: " + lapanganDipilih.getNamaLapangan() +
               ", Waktu: " + waktuMain.toString() + ", Total: Rp" + totalBiaya +
               ", Status: " + statusPemesanan + "]";
    }
}
