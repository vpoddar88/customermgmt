package com.planoacct.api.service;

import com.planoacct.api.data.ClientRepository;
import com.planoacct.api.model.Client;
import com.planoacct.api.model.ClientType;
import com.planoacct.api.rest.ClientController;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;

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

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);

        expectedClient = new Client("name", ClientType.BUSINESS, "Plano");
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

}