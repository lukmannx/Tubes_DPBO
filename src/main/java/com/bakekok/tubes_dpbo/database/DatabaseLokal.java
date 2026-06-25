package com.bakekok.tubes_dpbo.database;

import com.bakekok.tubes_dpbo.interfaces.IPenyimpananData;
import com.bakekok.tubes_dpbo.model.pengguna.Pengguna;
import com.bakekok.tubes_dpbo.model.lapangan.Lapangan;
import com.bakekok.tubes_dpbo.model.transaksi.Pemesanan;
import com.bakekok.tubes_dpbo.model.transaksi.Ulasan;
import java.util.ArrayList;

/**
 *
 * @author bakekok
 */
public class DatabaseLokal implements IPenyimpananData {
    private ArrayList<Pemesanan> tabelPemesanan = new ArrayList<>();
    private ArrayList<Pengguna> tabelPengguna = new ArrayList<>();
    private ArrayList<Lapangan> tabelLapangan = new ArrayList<>();
    private ArrayList<Ulasan> tabelUlasan = new ArrayList<>();
    @Override
    public void simpanData(Object data) {
        if (data instanceof Pemesanan) tabelPemesanan.add((Pemesanan) data);
        else if (data instanceof Pengguna) tabelPengguna.add((Pengguna) data);
        else if (data instanceof Lapangan) tabelLapangan.add((Lapangan) data);
        else if (data instanceof Ulasan) tabelUlasan.add((Ulasan) data);
        
    }
    
    

    @Override
    public void hapusData(Object data) {
        if (data instanceof Pemesanan) tabelPemesanan.remove(data);
        else if (data instanceof Pengguna) tabelPengguna.remove(data);
        else if (data instanceof Lapangan) tabelLapangan.remove(data);
        else if (data instanceof Ulasan) tabelUlasan.remove(data);
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
    public ArrayList<Ulasan> getTabelUlasan() { return tabelUlasan; }
}
