package com.bakekok.tubes_dpbo.model.transaksi;

import com.bakekok.tubes_dpbo.model.pengguna.Pelanggan;
import com.bakekok.tubes_dpbo.model.lapangan.Lapangan;

/**
 *
 * @author bakekok
 */
public class Ulasan {
    private String idUlasan;
    private Pelanggan pelanggan;
    private Lapangan lapangan;
    private int rating;
    private String komentar;

    public Ulasan(String idUlasan, Pelanggan pelanggan, Lapangan lapangan, int rating, String komentar) {
        this.idUlasan = idUlasan;
        this.pelanggan = pelanggan;
        this.lapangan = lapangan;
        this.rating = rating;
        this.komentar = komentar;
    }

    public void tambahUlasan() {
        System.out.println("Ulasan dari " + pelanggan.getNama() + " berhasil dipublikasikan!");
    }

    @Override
    public String toString() {
        return "Ulasan [" + lapangan.getNamaLapangan() + " | Rating: " + rating + "/5 | Komentar: " + komentar + "]";
    }
}
