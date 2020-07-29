package com.ssil.gcp.sb.sqlserver.repository;

import com.ssil.gcp.sb.sqlserver.model.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TodoRepository extends JpaRepository<Todo, Long> {
}
