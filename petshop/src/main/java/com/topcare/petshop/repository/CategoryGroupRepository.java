package com.topcare.petshop.repository;

import com.topcare.petshop.entity.CategoryGroup;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
@Transactional
public interface CategoryGroupRepository extends JpaRepository<CategoryGroup, Long> {

    Optional<CategoryGroup> findCategoryGroupByTitle(String title);

    void deleteCategoryGroupByTitle(String title);

    Boolean existsCategoryGroupByTitle(String title);
}
