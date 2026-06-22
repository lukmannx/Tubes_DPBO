package com.bakekok.tubes_dpbo.interfaces;

import java.util.ArrayList;

/**
 *
 * @author bakekok
 */
public interface IPenyimpananData {
    void simpanData(Object data);
    void hapusData(Object data);
    ArrayList<Object> ambilData();
}
