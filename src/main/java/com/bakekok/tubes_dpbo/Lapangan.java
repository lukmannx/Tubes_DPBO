/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bakekok.tubes_dpbo;

/**
 *
 * @author bakekok
 */
import java.util.ArrayList;
 
public class Lapangan {
    // === PILAR OOP: ENCAPSULATION ===
    // State objek dijaga secara private dan hanya diakses/dimanipulasi melalui Method yang terstruktur
    private String idLapangan;
    private String namaLapangan;
    private String jenisRumput;
    private double hargaPerJam;
    private ArrayList<Fasilitas> fasilitas;
    private ArrayList<Jadwal> daftarJadwal;
 
    public Lapangan(String idLapangan, String namaLapangan, String jenisRumput, double hargaPerJam) {
        this.idLapangan = idLapangan;
        this.namaLapangan = namaLapangan;
        this.jenisRumput = jenisRumput;
        this.hargaPerJam = hargaPerJam;
        this.fasilitas = new ArrayList<>();
        this.daftarJadwal = new ArrayList<>();
    }
 
    public void tambahFasilitas(Fasilitas f) { fasilitas.add(f); }
    public void tambahJadwal(Jadwal j) { daftarJadwal.add(j); }
    
    public boolean cekKetersediaan(Jadwal jadwal) { return jadwal.isTersedia(); }
 
    public ArrayList<Jadwal> getDaftarJadwal() { return daftarJadwal; }
    public String getIdLapangan() { return idLapangan; }
    public String getNamaLapangan() { return namaLapangan; }
    public double getHargaPerJam() { return hargaPerJam; }
 
    @Override
    public String toString() {
        return "Lapangan [ID: " + idLapangan + ", Nama: " + namaLapangan + 
               ", Rumput: " + jenisRumput + ", Harga/Jam: Rp" + hargaPerJam + "]";
    }
}