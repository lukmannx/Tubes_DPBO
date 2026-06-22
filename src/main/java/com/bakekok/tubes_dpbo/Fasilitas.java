/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bakekok.tubes_dpbo;

/**
 *
 * @author lukma
 */
public class Fasilitas {
    private String idFasilitas;
    private String namaFasilitas;
    private String kondisi;
 
    public Fasilitas(String idFasilitas, String namaFasilitas, String kondisi) {
        this.idFasilitas = idFasilitas;
        this.namaFasilitas = namaFasilitas;
        this.kondisi = kondisi;
    }
 
    public void perbaruiKondisi(String kondisiBaru) { this.kondisi = kondisiBaru; }
 
    @Override
    public String toString() { return "Fasilitas [" + namaFasilitas + " | Kondisi: " + kondisi + "]"; }
}