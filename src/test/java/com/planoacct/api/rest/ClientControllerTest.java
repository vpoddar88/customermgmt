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

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(SpringRunner.class)
public class ClientControllerTest {

    @Mock private ClientService mockClientService;

    @InjectMocks private ClientController clientController;

    private Client expectedIndividualClient;
    private Client expectedBusinessClient;
    private List<Client> expectedIndividualClients;
    private List<Client> expectedBusinessClients;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        expectedIndividualClient = new Client("name", ClientType.INDIVIDUAL, "Plano");
        expectedBusinessClient = new Client("name", ClientType.BUSINESS, "Plano");

        expectedIndividualClients = new ArrayList<>();
        expectedIndividualClients.add(expectedIndividualClient);

        expectedBusinessClients = new ArrayList<>();
        expectedBusinessClients.add(expectedBusinessClient);
    }

    @Test
    public void testGetClient() throws Exception {
        when(mockClientService.getClientById(eq(1L))).thenReturn(expectedBusinessClient);

        Client actualClient = clientController.getClient("1");

        verify(mockClientService).getClientById(1L);
        assertEquals(expectedBusinessClient.toString(), actualClient.toString());
    }

    @Test
    public void testGetListOfIndividualClients() throws Exception {
        when(mockClientService.getAllClientsByType(eq(ClientType.INDIVIDUAL))).thenReturn(expectedIndividualClients);

        List<Client> actualClients = clientController.getClients(ClientType.INDIVIDUAL);

        verify(mockClientService).getAllClientsByType(ClientType.INDIVIDUAL);
        assertEquals(expectedIndividualClients.toString(), actualClients.toString());
    }

    @Test
    public void testGetListOfBusinessClients() throws Exception {
        when(mockClientService.getAllClientsByType(eq(ClientType.BUSINESS))).thenReturn(expectedBusinessClients);

        List<Client> actualClients = clientController.getClients(ClientType.BUSINESS);

        verify(mockClientService).getAllClientsByType(ClientType.BUSINESS);
        assertEquals(expectedBusinessClients.toString(), actualClients.toString());
    }

}