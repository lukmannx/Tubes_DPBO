package com.bakekok.tubes_dpbo.model.lapangan;

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
