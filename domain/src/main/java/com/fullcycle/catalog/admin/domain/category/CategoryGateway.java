package com.fullcycle.catalog.admin.domain.category;

import com.fullcycle.catalog.admin.domain.pagination.Pagination;
import com.fullcycle.catalog.admin.domain.pagination.SearchQuery;

import java.util.Optional;

public interface CategoryGateway {
    Category create(Category aCategory);

    void deleteBy(CategoryID anId);

    Optional<Category> findById(CategoryID anId);

    Category update(Category aCategory);

    Pagination<Category> findAll(SearchQuery aQuery);
}
