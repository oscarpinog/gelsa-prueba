package com.alianza.fiduciaria.service;

import com.alianza.fiduciaria.DTO.RecargaDTO;
import com.alianza.fiduciaria.model.RecargaEntity;
import com.alianza.fiduciaria.respository.RecargaRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RecargaService {

	private static final Logger logger = LoggerFactory.getLogger(RecargaService.class);

	private final RecargaRepository recargaRepository;

	public RecargaService(final RecargaRepository recargaRepository) {
		this.recargaRepository = recargaRepository;
	}

	public List<RecargaDTO> getAllRecarga() {
		logger.info("Ejecutando metodo getAllClients()");
		List<RecargaEntity> recargaEntities = this.recargaRepository.findAll();
		if (CollectionUtils.isEmpty(recargaEntities)) {
			throw new RuntimeException("There are not clients yet.");
		}

		return recargaEntities.stream()
				.map(recargaEntity -> new RecargaDTO(recargaEntity.getID(), recargaEntity.getCantidad(),recargaEntity.getValor(),
						recargaEntity.getOperador(),recargaEntity.getVendedor()))
				.collect(Collectors.toList());
	}

	public RecargaDTO createRecarga(final RecargaDTO recargaToCreate) {
		RecargaEntity recargaEntity = RecargaEntity.builder()
				// .ID(clientToCreate.getID())
				.cantidad(recargaToCreate.getCantidad())
				.valor(recargaToCreate.getValor())
				.operador(recargaToCreate.getOperador())
				.vendedor(recargaToCreate.getVendedor())
				.build();
		System.out.println("IDClienteCreate:" + recargaToCreate.getID());

		this.recargaRepository.save(recargaEntity);

		logger.info("cliente creado exitosamente!");
		return recargaToCreate;
	}

	public RecargaDTO updateRecarga(final RecargaDTO recargaToUpdate) {
		RecargaEntity recargaEntity = RecargaEntity.builder().ID(recargaToUpdate.getID())
				.cantidad(recargaToUpdate.getCantidad())
				.valor(recargaToUpdate.getValor())
				.operador(recargaToUpdate.getOperador())
				.vendedor(recargaToUpdate.getVendedor())
				.build();

		System.out.println("IDClienteUpdate:" + recargaToUpdate.getID());

		this.recargaRepository.save(recargaEntity);
		logger.info("cliente actualizado exitosamente!");
		return recargaToUpdate;

	}

	public RecargaDTO deleteRecarga(final String ID) {
		RecargaEntity recargaEntity = this.recargaRepository.getReferenceById(ID);
		if (recargaEntity == null) {
			throw new RuntimeException(String.format("Does not find the Recarga %s.", ID));
		}
		this.recargaRepository.delete(recargaEntity);

		logger.info("cliente Eliminado exitosamente!");

		return new RecargaDTO(recargaEntity.getID(), recargaEntity.getCantidad(),recargaEntity.getValor(),
				recargaEntity.getOperador(),recargaEntity.getVendedor());
	}

	public RecargaDTO getBySharedKey(String sharedKey) {

		Optional<RecargaEntity> recargaEntity = this.recargaRepository.findById(sharedKey); 
		if (recargaEntity == null) {
			logger.info("cliente no encontrado sharedKey:" + sharedKey);
			throw new RuntimeException(String.format("Does not find the Recarga %s.", sharedKey));
		}

		logger.info("cliente encontrado exitosamente!");
		return new RecargaDTO(recargaEntity.get().getID(), recargaEntity.get().getCantidad(),recargaEntity.get().getValor(),
				recargaEntity.get().getOperador(),recargaEntity.get().getVendedor());
	}
}
