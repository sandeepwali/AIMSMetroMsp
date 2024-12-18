package com.solum.aims.msp.service.impl;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.solum.aims.msp.persistence.entity.Article;
import com.solum.aims.msp.persistence.entity.embeddable.ArticleCompositePK;
import com.solum.aims.msp.persistence.repository.ArticleRepository;
import com.solum.aims.msp.service.ArticleService;

@Service("articleService")
public class ArticleServiceImpl<T extends Article> implements ArticleService<T> {

	@Autowired
	private ArticleRepository<T> articleRepository;
	
	@Value("${report.split.label.count}")
	private Integer labelCount;

	@Transactional(transactionManager = "transactionManager", propagation = Propagation.REQUIRES_NEW)
	@Override
	public T saveArticle(T entity) {
		return articleRepository.save(entity);
	}

	@Transactional(transactionManager = "transactionManager", propagation = Propagation.REQUIRES_NEW)
	@Override
	public T findArticle(String stationCode, String articleId) {
		return articleRepository.findById(new ArticleCompositePK(stationCode, articleId)).orElse(null);
	}

	@Override
	public boolean isExistArticle(String stationCode, String articleId) {
		return articleRepository.existsById(new ArticleCompositePK(stationCode, articleId));
	}

	@Override
	public void deleteArticle(String stationCode, String articleId) {
		articleRepository.deleteByStationAndIdArticle(stationCode, articleId);
	}

	@Override
	public List<String> getArticleGroupByStationCode() {
		return articleRepository.getArticleGroupByStationCode();
	}

	@Override
	public List<String> getReservedList(String stationCode, String key) {

		List<String> reservedList = new ArrayList<>();

		reservedList = Optional.ofNullable(stationCode).isPresent()
				? articleRepository.getReservedListByStationCode(stationCode, key)
				: articleRepository.getReservedList(key);

		Collections.sort(reservedList);
		return reservedList;
	}

	@Override
	public Page<Object[]> getErrorList(String dept, List<String> labels, String resOne, String resTwo, String resThree,
			Integer count, String type, Pageable pageable) {

		final String finalDept;
		if ("".equals(dept))
			finalDept = null;
		else
			finalDept = dept;

		List<Object[]> data;

		if ((count > labelCount) || (type.equalsIgnoreCase("pdf") && count > labelCount)) {
			data = IntStream.range(0, (labels.size() + labelCount-1) / labelCount).mapToObj(i -> {
				int fromIndex = i * labelCount;
				int toIndex = Math.min(fromIndex + labelCount, labels.size());
				List<String> subList = labels.subList(fromIndex, toIndex);
				return Optional.ofNullable(finalDept)
						.map(d -> articleRepository.getErrorListForReserved(d, subList, resOne, resTwo, resThree))
						.orElse(articleRepository.getErrorList(subList, resTwo, resThree));
			}).flatMap(Collection::stream).collect(Collectors.toList());
		} else {
			data = Optional.ofNullable(finalDept)
					.map(d -> articleRepository.getErrorListForReserved(d, labels, resOne, resTwo, resThree))
					.orElse(articleRepository.getErrorList(labels, resTwo, resThree));
		}

		final int start = (int) pageable.getOffset();
		final int end = Math.min((start + pageable.getPageSize()), data.size());
		Page<Object[]> page;
		if (dept != null && !data.isEmpty()) {
			if (data.size() > start) {
				page = new PageImpl<>(data.subList(start, end), pageable, data.size());
			} else {
				page = new PageImpl<>(new ArrayList<>(), pageable, 0);
			}
		} else {
			if (data.size() > start) {
				page = new PageImpl<>(data.subList(start, end), pageable, data.size());
			} else {
				page = new PageImpl<>(new ArrayList<>(), pageable, 0);
			}
		}

		return page;

	}

	@Override
	public List<Object[]> getGwErrorList(List<String> labels, String resOne, String resTwo, String resThree,
			Pageable pageable) {
		return articleRepository.getGwErrorList(labels, resTwo, resThree);

	}
}
