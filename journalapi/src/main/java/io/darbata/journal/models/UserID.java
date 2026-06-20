package io.darbata.journal.models;

public class UserID {

    private String id;

    private UserID (String id) {
        this.id = id;
    }

    public static UserID of (String id) {
        return new UserID(id);
    }

    public String getId() {
        return this.id;
    }

}