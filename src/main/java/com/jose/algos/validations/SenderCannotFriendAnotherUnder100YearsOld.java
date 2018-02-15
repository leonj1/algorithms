package com.jose.algos.validations;

/**
 * Created for K and M Consulting LLC.
 * Created by Jose M Leon 2017
 **/
public class SenderCannotFriendAnotherUnder100YearsOld implements Validation {
    private Validation validation;
    private int maxAge = 100;

    public SenderCannotFriendAnotherUnder100YearsOld(Validation validation) {
        this.validation = validation;
    }

    public boolean check(int recipient, int sender) {
        if (sender > maxAge) {
            return false;
        }
        if (sender < maxAge && recipient < maxAge) {
            if (this.validation != null) {
                return this.validation.check(recipient, sender);
            }
        }
        return true;
    }
}
