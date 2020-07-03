package com.example.springchaos.generic;

import com.example.springchaos.domain.Domain;
import lombok.RequiredArgsConstructor;
import org.springframework.core.GenericTypeResolver;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

// this is annotated as a repository because this is a composable repo :D
@Repository
public class GenericRepositoryWithALotOfLogicImpl<T extends Domain> implements GenericRepositoryWithALotOfLogic<T> {

    private final EntityManager em;
    private final Class<T> clazz;

    public GenericRepositoryWithALotOfLogicImpl(EntityManager em) {
        this.em = em;

        // https://stackoverflow.com/a/9202329/7988516

        // in this case, clazz is null because getClass() returns the generic class, not the expected Spring implementation
        // in which T = Todo.class, for example
        this.clazz = (Class<T>) GenericTypeResolver.resolveTypeArgument(getClass(), GenericRepositoryWithALotOfLogic.class);
    }

    @Override
    public List<T> doStuff() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<T> query = cb.createQuery(clazz);

        Root<T> root = query.from(clazz); // this line throws an IllegalArgumentException :D

        // this could be generated
        root.get("details");

        return em.createQuery(query).getResultList();
    }
}
