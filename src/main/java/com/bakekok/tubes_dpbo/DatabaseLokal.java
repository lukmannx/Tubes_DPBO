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
public class DatabaseLokal implements IPenyimpananData {
    private ArrayList<Pemesanan> tabelPemesanan = new ArrayList<>();
    private ArrayList<Pengguna> tabelPengguna = new ArrayList<>();
    private ArrayList<Lapangan> tabelLapangan = new ArrayList<>();

    @Override
    public void simpanData(Object data) {
        if (data instanceof Pemesanan) tabelPemesanan.add((Pemesanan) data);
        else if (data instanceof Pengguna) tabelPengguna.add((Pengguna) data);
        else if (data instanceof Lapangan) tabelLapangan.add((Lapangan) data);
    }

    @Override
    public void hapusData(Object data) {
        if (data instanceof Pemesanan) tabelPemesanan.remove(data);
        else if (data instanceof Pengguna) tabelPengguna.remove(data);
        else if (data instanceof Lapangan) tabelLapangan.remove(data);
    }

    @Override
    public ArrayList<Object> ambilData() {
        ArrayList<Object> semua = new ArrayList<>();
        semua.addAll(tabelPengguna);
        semua.addAll(tabelLapangan);
        semua.addAll(tabelPemesanan);
        return semua;
    }

    public ArrayList<Pengguna> getTabelPengguna() { return tabelPengguna; }
    public ArrayList<Lapangan> getTabelLapangan() { return tabelLapangan; }
    public ArrayList<Pemesanan> getTabelPemesanan() { return tabelPemesanan; }

    public Pemesanan cariPesanan(String idPemesanan) {
        for (Pemesanan p : tabelPemesanan) {
            if (p.getIdPemesanan().equals(idPemesanan)) return p;
        }
        return null;
    }
}