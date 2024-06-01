package com.massive_jogger.Demo.data;

import com.massive_jogger.Demo.models.CurrentApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentApplicationRepository extends CrudRepository<CurrentApplication,Long> {
}
