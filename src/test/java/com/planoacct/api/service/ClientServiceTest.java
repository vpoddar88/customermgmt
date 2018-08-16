package com.planoacct.api.service;

import com.planoacct.api.data.ClientRepository;
import com.planoacct.api.model.Client;
import com.planoacct.api.model.ClientType;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(SpringRunner.class)
public class ClientServiceTest {
    @Mock private ClientRepository mockClientRepository;

    @InjectMocks private ClientService clientService;

    private Client expectedClient;
    private List<Client> expectedBusinessClients;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        expectedClient = new Client("name", ClientType.BUSINESS, "Plano");

        expectedBusinessClients = new ArrayList<>();
        expectedBusinessClients.add(expectedClient);
    }

    @Test
    public void testGetClientById() throws Exception {
        Optional<Client> optional = Optional.of(expectedClient);
        when(mockClientRepository.findById(eq(1L))).thenReturn(optional);

        Client actualClient = clientService.getClientById(1L);

        verify(mockClientRepository).findById(1L);
        assertEquals(expectedClient.toString(), actualClient.toString());
    }

    @Test
    public void testGetClientByIdReturnsNull() throws Exception {
        Optional<Client> optional = Optional.empty();
        when(mockClientRepository.findById(eq(1L))).thenReturn(optional);

        Client actualClient = clientService.getClientById(1L);

        verify(mockClientRepository).findById(1L);
        assertNull(actualClient);
    }

    @Test
    public void testGetClientsByType() throws Exception {
        Optional<Client> optional = Optional.of(expectedClient);
        when(mockClientRepository.findAllByClientType(eq(ClientType.INDIVIDUAL))).thenReturn(expectedBusinessClients);

        List<Client> actualClients = clientService.getAllClientsByType(ClientType.INDIVIDUAL);

        verify(mockClientRepository).findAllByClientType(ClientType.INDIVIDUAL);
        assertEquals(expectedBusinessClients.toString(), actualClients.toString());
    }

}