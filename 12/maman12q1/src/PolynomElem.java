package com.company;

public class PolynomElem implements Comparable{
    private double coef; //Coefficient
    private int power; // power

    public PolynomElem(double coef, int power) {
        this.coef = coef;
        this.power = power;
    }


    public double getCoef() {
        return coef;
    }

    public void setCoef(double coef) {
        this.coef = coef;
    }

    public int getPower() {
        return power;
    }

    // Returns a copy of the polynom element
    public PolynomElem copy(){
        return new PolynomElem(this.coef,this.power);
    }

    // Derivative of the element.
    public PolynomElem derivative() {
        return new PolynomElem(this.coef*this.power,this.power-1);
    }

    // Returns true if o is equal to this element, else false
    @Override
    public boolean equals(Object o) {
        PolynomElem pe = (PolynomElem) o;
        if(pe.getCoef() != this.coef || pe.getPower() != this.power)
            return false;
        return true;
    }

    // Compare element by the power of the polynom
    @Override
    public int compareTo(Object o) {
        PolynomElem pe = (PolynomElem)o;
        //Descending order
        return pe.getPower()-this.power;
    }
}
