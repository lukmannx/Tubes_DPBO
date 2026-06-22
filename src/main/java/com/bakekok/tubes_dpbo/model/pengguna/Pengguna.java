package com.bakekok.tubes_dpbo.model.pengguna;

/**
 *
 * @author bakekok
 */
public abstract class Pengguna {
    // === PILAR OOP: ENCAPSULATION ===
    // Menggunakan modifier protected agar atribut hanya bisa diakses oleh class turunannya
    protected String idPengguna;
    protected String nama;
    protected String email;
    protected String password;

    public Pengguna(String idPengguna, String nama, String email, String password) {
        this.idPengguna = idPengguna;
        this.nama = nama;
        this.email = email;
        this.password = password;
    }

    public boolean login() {
        System.out.println("Memverifikasi sesi untuk: " + this.nama);
        return true;
    }

    public void logout() {
        System.out.println("Logout berhasil. Sesi diakhiri.");
    }

    public String getNama() { return nama; }
    public String getEmail() { return email; }
    public String getPassword() { return password; }

    @Override
    public String toString() {
        return "ID: " + idPengguna + ", Nama: " + nama + ", Email: " + email;
    }
}
