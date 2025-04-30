package com.virasat.user_service.Enums;

public enum Issuer{
    Client,
    Admin,
    User;
    public String getIssuer() {
        return this.name();
    }
}
