/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bakekok.tubes_dpbo;
import java.util.ArrayList;

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
 
    public double hitungTotalBiaya() { return lapanganDipilih.getHargaPerJam(); }
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