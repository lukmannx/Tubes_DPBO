package com.bakekok.tubes_dpbo.model.pembayaran;

import com.bakekok.tubes_dpbo.interfaces.IMetodePembayaran;

/**
 *
 * @author bakekok
 */
public class EWallet implements IMetodePembayaran {
    private String vendorEWallet;
    private String nomorHP;

    public EWallet(String vendorEWallet, String nomorHP) {
        this.vendorEWallet = vendorEWallet;
        this.nomorHP = nomorHP;
    }

    @Override
    public boolean prosesBayar(double jumlah) {
        System.out.println("Memproses E-Wallet " + vendorEWallet + " (" + nomorHP + ")");
        System.out.println("Transaksi Rp" + jumlah + " Berhasil diverifikasi!");
        return true;
    }

    @Override
    public String toString() { return "E-Wallet (" + vendorEWallet + ")"; }
}
