package com.jose.algos.validations;

/**
 * Created for K and M Consulting LLC.
 * Created by Jose M Leon 2017
 **/
public class HalfPlusSevenValidation implements Validation {
    private Validation validation;

    public HalfPlusSevenValidation(Validation validation) {
        this.validation = validation;
    }

    public boolean check(int recipient, int sender) {
        if (recipient/2 + 7 < sender) {
            if (this.validation != null) {
                this.validation.check(recipient, sender);
            }
            return true;
        }
        return false;
    }
}
