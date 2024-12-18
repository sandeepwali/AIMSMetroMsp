package com.solum.aims.msp.persistence.repository;

import com.solum.aims.msp.persistence.entity.MetroTemplateGroupMap;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;

@Repository("templateGroupMapRepository")
public interface MetroTemplateGroupMapRepository  extends JpaRepository<MetroTemplateGroupMap,String> {

    public Collection<MetroTemplateGroupMap> findByIdName(String typeName);

    public Collection<MetroTemplateGroupMap> findByIdGroupName(String groupName);

    public void deleteByIdName(String typeName);

    @Modifying
    @Transactional
    @Query(nativeQuery=true, value="delete from metro_template_group_map where group_name = ?1")
    public void deleteByIdGroupName(String groupName);
}
