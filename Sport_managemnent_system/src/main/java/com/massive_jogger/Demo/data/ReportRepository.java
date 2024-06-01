package com.massive_jogger.Demo.data;

import com.massive_jogger.Demo.models.Report;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportRepository extends CrudRepository<Report,Long> {
}
