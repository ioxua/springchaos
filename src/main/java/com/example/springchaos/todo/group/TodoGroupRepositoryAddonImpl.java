package com.example.springchaos.todo.group;

import com.example.springchaos.todo.Todo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Tuple;
import javax.persistence.criteria.*;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor

@Repository
public class TodoGroupRepositoryAddonImpl implements TodoGroupRepositoryAddon {

    private final EntityManager em;

    @Override
    public List<TodoGroup> findTodoGroupsOrderBySize() {
        CriteriaBuilder cb = em.getCriteriaBuilder();
        CriteriaQuery<Tuple> query = cb.createTupleQuery();

        Root<TodoGroup> root = query.from(TodoGroup.class);

        Subquery<Long> subquery = query.subquery(Long.class);
        Root<?> subqueryRoot = subquery.from(Todo.class);

        Expression<Long> count = cb.count(subqueryRoot);
        subquery.select(count);
        subquery.where(cb.equal(root, subqueryRoot.get("group")));

        Expression<Long> selection = subquery.getSelection();
        query.multiselect(root, selection);
        query.orderBy(cb.asc(selection));

        return em.createQuery(query).getResultStream().map(r ->
                (TodoGroup) r.get(0)
        ).collect(Collectors.toList());
    }

}
