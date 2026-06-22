/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.lukman.tubes;

/**
 *
 * @author lukma
 */
public class TransferBank implements IMetodePembayaran {
    private String namaBank;
    private String nomorRekening;
 
    public TransferBank(String namaBank, String nomorRekening) {
        this.namaBank = namaBank;
        this.nomorRekening = nomorRekening;
    }
 
    @Override
    public boolean prosesBayar(double jumlah) {
        System.out.println("Memproses Transfer Bank " + namaBank + " (" + nomorRekening + ")");
        System.out.println("Transaksi Rp" + jumlah + " Berhasil diverifikasi!");
        return true;
    }
    
    @Override
    public String toString() { return "Transfer Bank (" + namaBank + ")"; }
}