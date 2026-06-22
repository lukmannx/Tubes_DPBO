/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lukman.tubes;

/**
 *
 * @author lukma
 */
public class Jadwal {
    private String tanggal;
    private String jamMulai;
    private String jamSelesai;
    private boolean isTersedia;
 
    public Jadwal(String tanggal, String jamMulai, String jamSelesai) {
        this.tanggal = tanggal;
        this.jamMulai = jamMulai;
        this.jamSelesai = jamSelesai;
        this.isTersedia = true;
    }
 
    public void setTersedia(boolean status) { this.isTersedia = status; }
    public boolean isTersedia() { return isTersedia; }
 
    @Override
    public String toString() {
        return tanggal + " | " + jamMulai + " - " + jamSelesai + " | Status: " + (isTersedia ? "Tersedia" : "Penuh");
    }
}