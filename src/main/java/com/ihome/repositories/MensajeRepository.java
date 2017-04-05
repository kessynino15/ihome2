package com.ihome.repositories;

import com.ihome.model.Mensaje;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface MensajeRepository  extends PagingAndSortingRepository<Mensaje, Long> {
}
