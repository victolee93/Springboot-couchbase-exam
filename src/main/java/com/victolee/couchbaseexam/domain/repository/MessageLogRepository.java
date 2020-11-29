package com.victolee.couchbaseexam.domain.repository;

import com.victolee.couchbaseexam.domain.document.MessageLogDocument;
import org.springframework.data.repository.CrudRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface MessageLogRepository extends CrudRepository<MessageLogDocument, String> {
    List<MessageLogDocument> findAllByDateBetween(LocalDateTime startDateTime, LocalDateTime endDateTime);
}
