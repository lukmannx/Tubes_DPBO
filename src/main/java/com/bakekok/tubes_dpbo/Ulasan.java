/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bakekok.tubes_dpbo;

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