package com.planoacct.api.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;


public class ClientTypeTest {

    private ClientType clientType;

    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void testToString() throws Exception {
        clientType = ClientType.INDIVIDUAL;

        assertEquals("INDIVIDUAL", clientType.toString());
    }

    @Test
    public void testFromText() throws Exception {
        ClientType business = ClientType.fromText("BUSINESS");

        assertEquals("BUSINESS", business.toString());
    }

    @Test(expected = IllegalArgumentException.class)
    public void testFromTextThrowsExceptionForInvalidType() throws Exception {
        try {
            ClientType.fromText("INVALID");
        } catch (Exception e) {
            assertEquals("Value is not a supported type.", e.getMessage());
            throw e;
        }
    }

}