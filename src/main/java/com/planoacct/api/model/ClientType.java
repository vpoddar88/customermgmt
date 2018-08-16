package com.planoacct.api.model;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

public enum ClientType {
    @JsonProperty("INDIVIDUAL")
    INDIVIDUAL("INDIVIDUAL"),
    @JsonProperty("BUSINESS")
    BUSINESS("BUSINESS");

    private String clientType;

    ClientType(String clientType){this.clientType = clientType;}

    public String getClientType(){return this.clientType;}

    @Override public String toString() { return clientType; }

    @JsonCreator
    public static ClientType fromText(String text){
        for(ClientType r : ClientType.values()){
            if(r.getClientType().equals(text)){
                return r;
            }
        }
        throw new IllegalArgumentException("Value is not a supported type.");
    }
}
