package com.bakekok.tubes_dpbo.model.pembayaran;

import com.bakekok.tubes_dpbo.interfaces.IMetodePembayaran;

/**
 *
 * @author bakekok
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
