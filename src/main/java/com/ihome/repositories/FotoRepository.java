package com.ihome.repositories;

import com.ihome.model.Foto;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface FotoRepository  extends PagingAndSortingRepository<Foto, Long> {
}
