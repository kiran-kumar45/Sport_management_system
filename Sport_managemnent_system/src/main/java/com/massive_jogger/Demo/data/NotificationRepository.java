package com.massive_jogger.Demo.data;

import com.massive_jogger.Demo.models.Notification;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NotificationRepository extends CrudRepository<Notification,Long> {
}
