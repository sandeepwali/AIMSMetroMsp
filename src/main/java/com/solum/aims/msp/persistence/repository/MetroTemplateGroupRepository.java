package com.solum.aims.msp.persistence.repository;

import com.solum.aims.msp.persistence.entity.MetroTemplateGroup;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface MetroTemplateGroupRepository extends JpaRepository<MetroTemplateGroup, String> {

	@Transactional
	@Modifying
	@Query(nativeQuery = true, value = "delete from metro_template_group_map where group_name=?1 ")
	public void removeTemplateGroupMapping(String groupName);

	public Page<MetroTemplateGroup> findByNameContains(String name, Pageable pageable);

	public MetroTemplateGroup findByModel(Integer model);

	@Query(nativeQuery = true, value = "select name from metro_template_group_map where group_name=?1")
	public List<String> findTemplateByGroup(String group);

//	@Query(nativeQuery = true, value = "select mg.name as name, mp.name as mp_name from metro_template_group mg \r\n"
//			+ "		left join metro_template_group_map mp on (mg.name = mp.group_name)\r\n"
//			+ "			where mg.module_code = ?1")

	@Query(nativeQuery = true, value = "select mg.name as name, mp.name as mp_name, mg.model as module from metro_template_group mg \r\n"
			+ "					left join metro_template_group_map mp on (mg.name = mp.group_name)\r\n"
			+ "				where mg.model = ?1")
	public List<Object[]> findByModelAndGroupName(Integer model);

}
