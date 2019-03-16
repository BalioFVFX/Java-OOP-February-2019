package models;

import interfaces.Spy;

public class SpyImpl extends BaseSoldier implements Spy {

    private String codeNumber;

    public SpyImpl(String firstName, String lastName, String id, String codeNumber) {
        super(firstName, lastName, id);
        this.codeNumber = codeNumber;
    }

    @Override
    public String getCodeNumber() {
        return this.codeNumber;
    }

    @Override
    public String toString() {
        return super.toString() + "\n" + "Code Number: " + this.getCodeNumber();
    }
}
