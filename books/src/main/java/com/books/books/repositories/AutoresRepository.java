package com.books.books.repositories;

import com.books.books.models.AutoresModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AutoresRepository extends JpaRepository<Long, AutoresModel> {
}
