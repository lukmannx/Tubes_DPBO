package com.bakekok.tubes_dpbo.model.lapangan;

/**
 *
 * @author bakekok
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
    
        public String getJamMulai() { return jamMulai; }
        public String getJamSelesai() { return jamSelesai; }
        
    @Override
    public String toString() {
        return tanggal + " | " + jamMulai + " - " + jamSelesai + " | Status: " + (isTersedia ? "Tersedia" : "Penuh");
    }
}
