package com.example.demo.dao;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

/**
 * 数据操作基础类
 * 
 * @author xuly
 * @param <T>
 * @since 2018-04-12
 */

@Component
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {
	@Autowired
	private MongoTemplate mongoTemplate;

	@Override
	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	@SuppressWarnings("unchecked")
	private Class<T> getClazz() {
		return (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	private Field[] getField(Class<T> entityClass) {
		Field[] fields = entityClass.getDeclaredFields();
		for (Field f : fields) {
			f.setAccessible(true);
		}
		return fields;
	}

	private String determineEntityCollectionName(Class<T> clazz) {
		if (!StringUtils.isEmpty(clazz.getSimpleName())) {
			return clazz.getSimpleName().substring(0, 1).toLowerCase()
					+ clazz.getSimpleName().substring(1, clazz.getSimpleName().length());
		}

		return null;
	}

	@Override
	public T save(T t) {
		try {
			mongoTemplate.save(t);
			return t;

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public int deleteById(Object id) {
		Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		Query query = new Query(Criteria.where("_id").is(id));
		mongoTemplate.remove(query, entityClass);
		return 0;
	}

	@Override
	public T update(T t) {
		try {
			Class<T> entityClass = this.getClazz();
			Field[] fields = this.getField(entityClass);

			Query query = null;
			Update update = new Update();
			for (int i = 0; i < fields.length; i++) {
				if (fields[i].getName().equals("id")) {
					if (fields[i].get(t) != null) {
						query = new Query(Criteria.where("_id").is(fields[i].get(t)));
					}
				} else {
					update.set(fields[i].getName(), fields[i].get(t));
				}
			}

			if (query != null) {
				mongoTemplate.updateFirst(query, update, determineEntityCollectionName(entityClass));
				return t;
			} else {
				throw new RuntimeException("entity id must be set, and id can not be null!");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@Override
	public List<T> selectAll() {
		Query query = new Query();
		// 按照objectId逆序排列
		query.with(new Sort(Direction.DESC, "id"));
		return mongoTemplate.find(query, this.getClazz());
	}

	@Override
	public T getById(Object id) {
		return mongoTemplate.findById(id, this.getClazz());
	}

	@Override
	public T selectOne(T t) {
		List<T> rs = this.select(t);

		if (rs != null && rs.size() > 0) {
			return this.select(t).get(0);
		} else {
			return null;
		}
	}

	@Override
	public List<T> select(T t) {
		try {
			Class<T> entityClass = this.getClazz();
			Field[] fields = this.getField(entityClass);

			Query query = null;
			for (int i = 0; i < fields.length; i++) {
				if (fields[i].getName().equals("serialVersionUID"))
					continue;

				if (fields[i].getName().equals("id")) {
					if (fields[i].get(t) != null) {
						if (query == null) {
							query = new Query(Criteria.where("id").is(fields[i].get(t)));
						} else {
							query.addCriteria(Criteria.where("id").is(fields[i].get(t)));
						}

					}
				} else {

					if (fields[i].get(t) != null && !StringUtils.isEmpty(fields[i].get(t))) {
						// 左匹配
						Pattern pattern = Pattern.compile("^" + fields[i].get(t) + ".*$", Pattern.CASE_INSENSITIVE);

//						//完全匹配
//						Pattern pattern = Pattern.compile("^" + fields[i].get(t) + "$", Pattern.CASE_INSENSITIVE);
//						//右匹配
//						Pattern pattern = Pattern.compile("^.*" + fields[i].get(t) + "$", Pattern.CASE_INSENSITIVE);
//						//模糊匹配
//						Pattern pattern = Pattern.compile("^.*" + fields[i].get(t) + ".*$", Pattern.CASE_INSENSITIVE);

						if (query == null) {
							query = new Query(Criteria.where(fields[i].getName()).regex(pattern));
						} else {
							query.addCriteria(Criteria.where(fields[i].getName()).regex(pattern));
						}
					}
				}
			}

			if (query != null) {
				return ((List<T>) mongoTemplate.find(query, this.getClazz()));
			} else {
				return this.selectAll();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public void deleteAll() {
		Class<T> entityClass = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass())
				.getActualTypeArguments()[0];
		// 左匹配
		Pattern pattern = Pattern.compile("^.*$", Pattern.CASE_INSENSITIVE);

		Query query = new Query(Criteria.where("_id").regex(pattern));
		mongoTemplate.remove(query, entityClass);
	}

	// @Override
	// public List<T> selectAndPaging(T t, Integer pageNum, Integer pageSize)
	// {
	// // TODO Auto-generated method stub
	// return null;
	// }

}
