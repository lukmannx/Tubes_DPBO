/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.bakekok.tubes_dpbo;

/**
 *
 * @author bakekok
 */
public interface IPenyimpananData {
    void simpanData(Object data);
    void hapusData(Object data);
    java.util.ArrayList<Object> ambilData();
}