package com.alianza.fiduciaria.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
 
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;

import com.alianza.fiduciaria.DTO.ClientDTO;
import com.alianza.fiduciaria.model.ClientEntity;
import com.alianza.fiduciaria.respository.ClientRepository;

@SpringJUnitConfig({ ClientService.class  })
public class ClienteServiceTest {

	@MockBean
	private ClientRepository mockRepository;
 
	@Autowired
	private ClientService adapter;
 
	@Test
	public void findAllActive() {
		ClientDTO expected =  ClientDTO.builder()
				.businessId("1")
				.dataAdded(LocalDate.of(2024, 1, 1))
				.email("example@hotmail.com")
				.ID("1")
				.sharedKey("opino")
				.phone("+57 3108375232")
				.build();
		
		List<ClientDTO> expectedList = new ArrayList<>();
		expectedList.add(expected);
 
		ClientEntity entity = ClientEntity.builder()
				.businessId("1")
				.dataAdded(LocalDate.of(2024, 1, 1))
				.email("example@hotmail.com")
				.ID("1")
				.sharedKey("opino")
				.phone("+57 3108375232")
				.build();
		List<ClientEntity> list = new ArrayList<>();
		list.add(entity);
 
		when(mockRepository.findAll()).thenReturn(list);
 
		assertEquals(expectedList.get(0).getBusinessId(), adapter.getAllClients().get(0).getBusinessId());
		assertEquals(expectedList.get(0).getID(), adapter.getAllClients().get(0).getID());
		assertEquals(expectedList.get(0).getPhone(), adapter.getAllClients().get(0).getPhone());
		assertEquals(expectedList.get(0).getEmail(), adapter.getAllClients().get(0).getEmail());
	}
	@Test
	public void findAllActiveEmpty() {
		String error="";
		try {
			adapter.getAllClients();
		} catch (Exception e) {
			error=e.getMessage();
		}finally {
			assertEquals("There are not clients yet.",error);
		}
	}
	
	@Test
	public void createClient() {
		ClientDTO expected =  ClientDTO.builder()
				.businessId("1")
				.dataAdded(LocalDate.of(2024, 1, 1))
				.email("example@hotmail.com")
				.ID("1")
				.sharedKey("opino")
				.phone("+57 3108375232")
				.build();
		
		ClientEntity entity = ClientEntity.builder()
				.businessId("1")
				.dataAdded(LocalDate.of(2024, 1, 1))
				.email("example@hotmail.com")
				.ID("1")
				.sharedKey("opino")
				.phone("+57 3108375232")
				.build();
		
		when(mockRepository.save(entity)).thenReturn(entity);
		adapter.createStudent(expected);

	}
	@Test
	public void updateClient() {
		ClientDTO expected =  ClientDTO.builder()
				.businessId("1")
				.dataAdded(LocalDate.of(2024, 1, 1))
				.email("example@hotmail.com")
				.ID("1")
				.sharedKey("opino")
				.phone("+57 3108375232")
				.build();
		
		ClientEntity entity = ClientEntity.builder()
				.businessId("1")
				.dataAdded(LocalDate.of(2024, 1, 1))
				.email("example@hotmail.com")
				.ID("1")
				.sharedKey("opino")
				.phone("+57 3108375232")
				.build();
		
		when(mockRepository.save(entity)).thenReturn(entity);
		
		adapter.updateStudent(expected);

	}
	
	@Test
	public void deleteStudent() {
		ClientEntity entity = ClientEntity.builder()
				.businessId("1")
				.dataAdded(LocalDate.of(2024, 1, 1))
				.email("example@hotmail.com")
				.ID("1")
				.sharedKey("opino")
				.phone("+57 3108375232")
				.build();
		when(mockRepository.getReferenceById("1")).thenReturn(entity);
		adapter.deleteStudent("1");
	}
	@Test
	public void deleteStudentError() {
		ClientEntity entity = ClientEntity.builder()
				.businessId("1")
				.dataAdded(LocalDate.of(2024, 1, 1))
				.email("example@hotmail.com")
				.ID("1")
				.sharedKey("opino")
				.phone("+57 3108375232")
				.build();
		
		String error="";
		try {
			adapter.deleteStudent("1");
		} catch (Exception e) {
			error=e.getMessage();
		}finally {
			assertEquals(String.format("Does not find the Client %s.", "1"),error);
		}
	}
 
	@Test
	public void getBySharedKey() {
		ClientEntity entity = ClientEntity.builder()
				.businessId("1")
				.dataAdded(LocalDate.of(2024, 1, 1))
				.email("example@hotmail.com")
				.ID("1")
				.sharedKey("opino")
				.phone("+57 3108375232")
				.build();
		when(mockRepository.findBySharedKey("opino")).thenReturn(entity);
		adapter.getBySharedKey("opino");
	}
	
	@Test
	public void getBySharedKeyClientNull() {
		ClientEntity entity=null;
		when(mockRepository.findBySharedKey("opino")).thenReturn(entity);
		
		String error="";
		try {
			adapter.deleteStudent("opino");
		} catch (Exception e) {
			error=e.getMessage();
		}finally {
			assertEquals((String.format("Does not find the Client %s.", "opino")),error);
		}
	}
 
}


 

 
	
