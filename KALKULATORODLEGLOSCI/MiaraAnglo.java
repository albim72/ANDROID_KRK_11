package com.marcin.kalkulatorodleglosci;

public abstract class MiaraAnglo {
    protected double odl;
    protected double mang;

    public MiaraAnglo(double odl, double mang) {
        this.odl = odl;
        this.mang = mang;
    }
    
    public abstract double policzOdl();
}
