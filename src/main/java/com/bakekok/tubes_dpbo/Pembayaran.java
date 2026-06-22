/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bakekok.tubes_dpbo;

/**
 *
 * @author bakekok
 */
public class Pembayaran {
    private String idPembayaran;
    private Pemesanan pesanan;
    // === PILAR OOP: POLYMORPHISM ===
    // Penggunaan objek polymorph dari tipe interface, sehingga bisa menampung instance TransferBank maupun EWallet
    private IMetodePembayaran metode;
    private String tanggalBayar;
 
    public Pembayaran(String idPembayaran, Pemesanan pesanan, IMetodePembayaran metode, String tanggalBayar) {
        this.idPembayaran = idPembayaran;
        this.pesanan = pesanan;
        this.metode = metode;
        this.tanggalBayar = tanggalBayar;
    }
 
    public boolean eksekusiPembayaran() {
        // Pemanggilan polymorph saat runtime: sistem otomatis mengeksekusi override `prosesBayar` yg sesuai.
        boolean berhasil = metode.prosesBayar(pesanan.getTotalBiaya());
        if (berhasil) pesanan.ubahStatus("Menunggu Konfirmasi Admin");
        return berhasil;
    }
 
    public String cetakStruk() {
        return "\n========= STRUK PEMBAYARAN =========\n" +
               "ID Bayar  : " + idPembayaran + "\n" +
               "Pesanan   : " + pesanan.getIdPemesanan() + "\n" +
               "Total     : Rp" + pesanan.getTotalBiaya() + "\n" +
               "Metode    : " + metode.toString() + "\n" +
               "Status    : " + pesanan.getStatusPemesanan() + "\n" +
               "====================================";
    }
}
