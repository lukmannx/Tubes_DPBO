/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lukman.tubes;

import java.util.ArrayList;

/**
 *
 * @author lukma
 */
public class RiwayatBooking {
    private ArrayList<Pemesanan> daftarPemesanan = new ArrayList<>();
 
    public void tambahRiwayat(Pemesanan pesanan) { daftarPemesanan.add(pesanan); }
    public ArrayList<Pemesanan> tampilkanSemuaRiwayat() { return daftarPemesanan; }
 
    @Override
    public String toString() {
        if (daftarPemesanan.isEmpty()) return "Riwayat Anda masih kosong.";
        StringBuilder sb = new StringBuilder("=== Riwayat Booking ===\n");
        for (Pemesanan p : daftarPemesanan) sb.append("- ").append(p.toString()).append("\n");
        return sb.toString();
    }
}