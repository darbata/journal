package io.darbata.journal.models;

public class UserIdentity {

    private String id;

    private UserIdentity(String id) {
        this.id = id;
    }

    public static UserIdentity of (String id) {
        return new UserIdentity(id);
    }

    public String getId() {
        return this.id;
    }

}