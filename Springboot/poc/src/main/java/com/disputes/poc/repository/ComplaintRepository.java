package com.disputes.poc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.disputes.poc.Entity.complaints;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ComplaintRepository extends JpaRepository<complaints,Long> {
    @Query(value = """
        SELECT id, text, label, issue, sub_issue
        FROM complaints
        ORDER BY embedding <-> CAST(:embedding AS vector)
        LIMIT 3
    """, nativeQuery = true)
    List<Object[]> findTop3Similar(@Param("embedding") String embedding);
}
