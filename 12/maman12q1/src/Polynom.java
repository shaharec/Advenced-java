package com.company;
import java.util.ArrayList; //array list for the polinom
import java.util.Collections;

public class Polynom  {

    private ArrayList<PolynomElem> polynom ; // Polynoms element array.

    public Polynom(double[] coef, int[] power) throws Exception {

        this.polynom = new ArrayList<>();
        if (coef.length != power.length)  // check thet the arrays length match.
            throw new Exception("Error! \nThe arrays doesnt have the same length.");
        // Creat the array list of the polynom.
        for(int i= 0; i<coef.length; i++)
            polynom.add(new PolynomElem(coef[i],power[i]));
        // Sort the polynom element by there power.
        Collections.sort(this.polynom);

    }

    public Polynom(){
        this.polynom = new ArrayList<>();
    }

    // Preform plus operation between two polynoms.
    public Polynom plus(Polynom p) throws Exception {
        int pol_index = 0;
        Polynom new_polynom = new Polynom();
        for(int p_index= 0;p_index<p.getPolynom().size();p_index++) {
            PolynomElem p_elem = p.getPolynom().get(p_index);
            // Add element to the new polinom if the power is not equal or lower.
            while (pol_index < this.polynom.size() && this.polynom.get(pol_index).getPower() > p_elem.getPower()){
                new_polynom.getPolynom().add(this.polynom.get(pol_index).copy());
                pol_index++;
            }
            if(pol_index >= this.polynom.size())  // If where finished looking at all the element in this.polynom.
                new_polynom.getPolynom().add(p_elem.copy());
            else {
                PolynomElem this_elem = this.polynom.get(pol_index);
                if (this_elem.getPower() == p_elem.getPower()) {  // if the power is equal preform sum operation.
                    if (this_elem.getCoef() + p_elem.getCoef() != 0)  // Add only if the coef is not zero.
                        new_polynom.getPolynom().add(polElemSum(this_elem, p_elem));
                    pol_index++;
                } else  // If the powers not equal add the element from p polynom.
                    new_polynom.getPolynom().add(p_elem.copy());
            }
        }
        while(pol_index < this.polynom.size()){
            new_polynom.getPolynom().add(this.polynom.get(pol_index).copy());
            pol_index++;
        }

        return new_polynom;
    }
    // Preform minus operation between two polynoms.
    public Polynom minus(Polynom p) throws Exception {
        int pol_index = 0;
        Polynom new_polynom = new Polynom();
        for(int p_index= 0;p_index<p.getPolynom().size();p_index++) {
            PolynomElem p_elem = p.getPolynom().get(p_index).copy();
            p_elem.setCoef(-1* p_elem.getCoef());  // turn the coef to minus for the sum operation later.
            // Add element to the new polinom if the power is not equal or lower.
            while (pol_index < this.polynom.size() && this.polynom.get(pol_index).getPower() > p_elem.getPower()){
                new_polynom.getPolynom().add(this.polynom.get(pol_index).copy());
                pol_index++;
            }

            if(pol_index >= this.polynom.size())  // If where finished looking at all the element in this.polynom.
                new_polynom.getPolynom().add(p_elem.copy());
            else {
                PolynomElem this_elem = this.polynom.get(pol_index);
                if (this_elem.getPower() == p_elem.getPower()) {  // If the power is equal preform sum operation.
                    if (this_elem.getCoef() + p_elem.getCoef() != 0)  // Add only if the coef is not zero.
                        new_polynom.getPolynom().add(polElemSum(this_elem, p_elem));
                    pol_index++;
                } else  // If the powers not equal add the element from p polynom.
                    new_polynom.getPolynom().add(p_elem.copy());
            }
        }
        while(pol_index < this.polynom.size()){ // Add all the elements that weren't checked.
            new_polynom.getPolynom().add(this.polynom.get(pol_index).copy());
            pol_index++;
        }
        return new_polynom;
    }

    public ArrayList<PolynomElem> getPolynom() {
        return polynom;
    }

    // Return new polinum element with the sum of coeficients and same power.
    private PolynomElem polElemSum(PolynomElem p1, PolynomElem p2) throws Exception {
        if(p1.getPower() != p2.getPower())
            throw new Exception("Error in sum of polynom element.") ;
        return new PolynomElem(p1.getCoef()+ p2.getCoef(),p1.getPower());
    }

    // Return the derivative of the polynomial.
    public Polynom derivative(){
        Polynom new_polynom = new Polynom();
        for(int i= 0;i<this.polynom.size();i++) {
            if(this.polynom.get(i).getPower()>=1)
                new_polynom.getPolynom().add(this.polynom.get(i).derivative());
        }
        return new_polynom;
    }

    @Override
    public String toString(){
        String str = new String();
        for(int i= 0;i<this.polynom.size();i++) {
            if(this.polynom.get(i).getCoef()>0 && str.length()>0)
                str +="+";
            if(this.polynom.get(i).getCoef() == 1) {  // If the coef =1 show x^power
                if( this.polynom.get(i).getPower()>0) {//If the power is 0 show 1.
                    if (this.polynom.get(i).getPower() == 1)
                        str += "x";
                    else
                        str += "x^" + this.polynom.get(i).getPower();
                }else
                    str += this.polynom.get(i).getCoef();
            } else
                if(this.polynom.get(i).getCoef()!= 0) { //If the coef is 0 dont show the element.
                    if (this.polynom.get(i).getPower() == 1) { // If the power is 1 show coef*x.
                        str += this.polynom.get(i).getCoef() + "x";
                    }else {// Power !=1, if the power is 0 show only coef else show coef*x^power.
                        if (this.polynom.get(i).getPower() == 0)
                            str += this.polynom.get(i).getCoef();
                        else
                            str += this.polynom.get(i).getCoef() + "x^" + this.polynom.get(i).getPower();
                    }
                }
        }
        if(str.length() == 0) // if no element exist show 0.
            str+="0";

        return str;
    }

    @Override
    public boolean equals(Object o) {
        Polynom p = (Polynom) o;
        for(int i= 0;i<this.polynom.size();i++)
            if(! p.getPolynom().get(i).equals(this.polynom.get(i)))
                return false;
        return true;
    }





}
