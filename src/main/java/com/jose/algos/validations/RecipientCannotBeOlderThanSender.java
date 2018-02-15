package com.jose.algos.validations;

/**
 * Created for K and M Consulting LLC.
 * Created by Jose M Leon 2017
 **/
public class RecipientCannotBeOlderThanSender implements Validation {
    private Validation validation;

    public RecipientCannotBeOlderThanSender(Validation validation) {
        this.validation = validation;
    }

    public boolean check(int recipient, int sender) {
        if (recipient > sender) {
            return false;
        }
        if (this.validation != null) {
            return this.validation.check(recipient, sender);
        }
        return true;
    }
}
