/*
 *   Copyright 2013-2017 Clockwork Solutions LLC
 *  
 *   All Rights Reserved.
 */

package com.ihome.repositories;/*
 *   Copyright 2013-2017 Clockwork Solutions LLC
 *  
 *   All Rights Reserved.
 */

import com.ihome.model.Vendedor;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface VendedorRepository  extends PagingAndSortingRepository<Vendedor, Long> {
	public Vendedor findByEmail(String email);
}
