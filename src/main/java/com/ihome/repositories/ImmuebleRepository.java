package com.ihome.repositories;

import com.ihome.model.Immueble;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ImmuebleRepository extends PagingAndSortingRepository<Immueble, Long> {
}
