package com.solum.aims.msp.persistence.repository;

import com.solum.aims.msp.persistence.entity.MetroEnddevice;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository("metroEnddeviceRepository")
public interface MetroEnddeviceRepository extends CrudRepository<MetroEnddevice, Long> {

	Optional<MetroEnddevice> findByCode(String code);

	Optional<List<MetroEnddevice>> findByArticleId(long articleId);
	Optional<List<MetroEnddevice>> findByArticleIdAndType(long articleId, String type);
	Optional<List<MetroEnddevice>> findByType(String type);

    int countByArticleIdAndType(long articleId, String type);
}
