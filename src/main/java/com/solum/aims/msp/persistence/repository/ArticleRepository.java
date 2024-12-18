package com.solum.aims.msp.persistence.repository;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.solum.aims.msp.persistence.entity.Article;
import com.solum.aims.msp.persistence.entity.embeddable.ArticleCompositePK;
import com.solum.aims.msp.persistence.repository.projection.ArticleProjection;

import jakarta.persistence.LockModeType;


@Transactional(readOnly = true)
@Repository("articleRepository")
public interface ArticleRepository<T extends Article> extends JpaRepository<T, ArticleCompositePK> {
	
	@Lock(LockModeType.PESSIMISTIC_WRITE)
//	@QueryHints({@QueryHint(name = "javax.persistence.lock.timeout", value = "30000")})
	public Optional<T> findById(ArticleCompositePK id);
		
	public Collection<T> findByIdArticleId(String articleId);
	
	public Collection<T> findByIdStationCodeAndNameIgnoreCaseContaining(String stationCode, String name);
	
	public Collection<T> findByIdStationCode(String stationCode);
	
	public Page<T> findByIdStationCode(String stationCode, Pageable pageable);
	
	public Long countByIdStationCode(String stationCode);

	@Transactional
	@Modifying
	@Query(nativeQuery=true, value="delete from article where station_code=?1 and article_id=?2")
	public void deleteByStationAndIdArticle(String stationCode, String articleId);
	
	public ArticleProjection findIdById(ArticleCompositePK id);
	
	@Query(value="select new Article(a.name, a.nfcUrl, a.data) from Article as a where a.id=?1")
	public T selectArticleWithJpql(ArticleCompositePK id);
	
	
	@Query(nativeQuery=true, 
			value="select "
					+ "distinct ea.label_code "
				+ "from end_device_articles as ea "
				+ "where "
					+ "ea.station_code=?1 "
					+ "and "
					+ "ea.article_id=?2")
	public List<String> selectEnddevicesByArticleWithJpql(String stationCode, String article);
	
	@Transactional
	@Modifying
	@Query(nativeQuery=true,
			value="insert into article "
			+ "(station_code, article_id, name, nfc_url, data, aims_portal_batch_id, created, last_modified) "
			+ "values(?1, ?2, ?3, ?4, ?5, ?6, ?7, ?7)")
	public void insertArticleWithJpql(
			String stationCode,
			String articleId,
			String name, 
			String nfcUrl, 
			String data, 
			Long aimsPortalBatchId, 
			Date created
			);

	public Page<T> findByIdStationCodeAndNameIgnoreCaseContaining(String stationCode, String articleName, Pageable pageable);
	public Page<T> findByIdStationCodeAndIdArticleIdIgnoreCaseContaining(String stationCode, String articleId, Pageable pageable);
	
	public Page<T> findByIdStationCodeAndReservedOne(String stationCode, String reservedOne, Pageable pageable);
	public Page<T> findByIdStationCodeAndReservedTwo(String stationCode, String reservedTwo, Pageable pageable);
	public Page<T> findByIdStationCodeAndReservedThree(String stationCode, String reservedThree, Pageable pageable);
	
	public Collection<T> findByIdStationCodeAndReservedOne(String stationCode, String reservedOne);
	public Collection<T> findByIdStationCodeAndReservedTwo(String stationCode, String reservedTwo);
	public Collection<T> findByIdStationCodeAndReservedThree(String stationCode, String reservedThree);
	
	@Query(nativeQuery=true, value="select a.article_id from article as a where a.station_code=?1 and a.article_id like %?2%")
	public List<String> selectArticleIdStationCodeAndArticleId(String stationCode, String articleId);
	
	public Collection<T> findByIdStationCodeAndIdArticleIdStartingWith(String stationCode, String id);
	
	@Query(nativeQuery=true, value="select station_code from article group by station_code")
	List<String> getArticleGroupByStationCode();
	@Query(nativeQuery = true, value = "select distinct  a.reserved->>:key from  public.article a where a.station_code=:stationCode and a.reserved->>:key is not null ")
	public List<String> getReservedListByStationCode(@Param("stationCode") String stationCode,
			@Param("key") String key);
	@Query(nativeQuery = true, value = "select distinct a.reserved->>:key from  public.article a where a.reserved->>:key is not null")
	public List<String> getReservedList(@Param("key") String key);
	
	// Reserved One = F5,Reserved two =F6 Reserved Three =F66
	@Query(nativeQuery = true, value = "select a.reserved->>'F6' as itemgroup, a.article_id as itemId, a.name as description, e.label_code as labelId, a.reserved->>'F66' as price, c.amountLabel from article as a join end_device_articles e on a.article_id = e.article_id left outer join (select a.article_id, count(label_code) -1 as amountLabel from article a join end_device_articles e on a.article_id = e.article_id where a.reserved->>'F5' = ?1 group by a.article_id) c on e.article_id = c.article_id where a.reserved->>'F5' = ?1 and e.label_code in (?2) group by a.reserved->>'F6', a.article_id, a.name, e.label_code, a.reserved->>'F66', c.amountLabel", countQuery = "select count(a.*) from (select a.reserved->>'F6' as itemgroup, a.article_id as itemId, a.name as description, e.label_code as labelId, a.reserved->>'F6' as price, c.amountLabel from article a join end_device_articles e on a.article_id = e.article_id left outer join (select a.article_id, count(a.article_id) as amountLabel from article a join end_device_articles e on a.article_id = e.article_id where a.reserved->>'F5' = ?1 and e.label_code in (?2) group by a.article_id) c on e.article_id = c.article_id where a.reserved->>'F5' = ?1 and e.label_code in (?2) group by a.reserved->>'F6', a.article_id, a.name, e.label_code, a.reserved->>'F66', c.amountLabel) a")
	List<Object[]> getErrorListForReserved(String dept, List<String> labels, String one, String two, String three);
	@Query(nativeQuery = true, value = "select a.reserved->>'F6' as itemgroup, a.article_id as itemId, a.name as description, e.label_code as labelId, a.reserved->>'F66' as price, c.amountLabel from article a join end_device_articles e on a.article_id = e.article_id left outer join (select a.article_id, count(label_code) - 1 as amountLabel from article a join end_device_articles e on a.article_id = e.article_id group by a.article_id) c on e.article_id = c.article_id where e.label_code in (?1)  group by a.reserved->>'F6', a.article_id, a.name, e.label_code, a.reserved->>'F66', c.amountLabel ", countQuery = "select count(a.*) from (select a.reserved->>'F6' as itemgroup, a.article_id as itemId, a.name as description, e.label_code as labelId, a.reserved->>'F66' as price, c.amountLabel from article a join end_device_articles e on a.article_id = e.article_id left outer join (select a.article_id, count(a.article_id) as amountLabel from article a join end_device_articles e on a.article_id = e.article_id where e.label_code in (?1) group by a.article_id) c on e.article_id = c.article_id where e.label_code in (?1) and a.reserved->>'F6' is not null group by a.reserved->>'F6', a.article_id, a.name, e.label_code, a.reserved_three, c.amountLabel) a")
	List<Object[]> getErrorList(List<String> labels, String two, String three);
	@Query(nativeQuery = true, value = "select a.reserved->>'F6' as itemGroup, a.article_id as itemId, a.name as description, e.label_code as labelId, a.reserved ->> 'F66' as price, c.amountLabel from article a join end_device_articles e on a.article_id = e.article_id left outer join (select a.article_id, count(label_code) - 1 as amountLabel from article a join end_device_articles e on a.article_id = e.article_id group by a.article_id) c on e.article_id = c.article_id where e.label_code in (?1) group by a.reserved->>'F6', a.article_id, a.name, e.label_code, a.reserved ->> 'F66', c.amountLabel ", countQuery = "select count(a.*) from (select a.reserved->>'F6' as itemGroup, a.article_id as itemId, a.name as description, e.label_code as labelId, a.reserved ->> 'F66' as price, c.amountLabel from article a join end_device_articles e on a.article_id = e.article_id left outer join (select a.article_id, count(a.article_id) as amountLabel from article a join end_device_articles e on a.article_id = e.article_id where e.label_code in (?1) group by a.article_id) c on e.article_id = c.article_id where e.label_code in (?1) and a.reserved->>'F6' is not null group by a.reserved->>'F6', a.article_id, a.name, e.label_code, a.reserved ->> 'F66', c.amountLabel) a")
	List<Object[]> getGwErrorList(List<String> labels, String two, String three);	
}
