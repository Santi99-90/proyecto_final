/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package modelo;

/**
 *
 * @author Hplay
 */
public class Cajero {
    private int id;
    private int ndiez;
    private int nveinte;
    private int ncincuenta;
    private int ncien;
    private int estado;

    public Cajero() {
    }

    public Cajero(int id, int ndiez, int nveinte, int ncincuenta, int ncien, int estado) {
        this.id = id;
        this.ndiez = ndiez;
        this.nveinte = nveinte;
        this.ncincuenta = ncincuenta;
        this.ncien = ncien;
        this.estado = estado;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getNdiez() {
        return ndiez;
    }

    public void setNdiez(int ndiez) {
        this.ndiez = ndiez;
    }

    public int getNveinte() {
        return nveinte;
    }

    public void setNveinte(int nveinte) {
        this.nveinte = nveinte;
    }

    public int getNcincuenta() {
        return ncincuenta;
    }

    public void setNcincuenta(int ncincuenta) {
        this.ncincuenta = ncincuenta;
    }

    public int getNcien() {
        return ncien;
    }

    public void setNcien(int ncien) {
        this.ncien = ncien;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
    
    
}//fin de la clase
