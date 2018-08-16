package com.planoacct.api.rest;

import com.planoacct.api.model.Client;
import com.planoacct.api.model.ClientType;
import com.planoacct.api.service.ClientService;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ClientControllerTest {

    @Mock private ClientService mockClientService;

    @InjectMocks private ClientController clientController;

    private Client expectedClient;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        expectedClient = new Client("name", ClientType.BUSINESS, "Plano");

        when(mockClientService.getClientById(eq(1L))).thenReturn(expectedClient);
    }

    @Test
    public void testGetClient() throws Exception {
        Client actualClient = clientController.getClient("1");

        verify(mockClientService).getClientById(1L);
        assertEquals(expectedClient.toString(), actualClient.toString());
    }

}