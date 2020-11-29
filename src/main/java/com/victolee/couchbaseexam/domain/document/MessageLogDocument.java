package com.victolee.couchbaseexam.domain.document;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.couchbase.core.mapping.Document;
import org.springframework.data.couchbase.core.mapping.Field;
import org.springframework.data.couchbase.core.mapping.id.GeneratedValue;
import org.springframework.data.couchbase.core.mapping.id.GenerationStrategy;

import java.time.LocalDateTime;

@Builder
@Data
@AllArgsConstructor
@Document
public class MessageLogDocument {
    @Id
    @GeneratedValue(strategy = GenerationStrategy.UNIQUE)
    private final String id;

    @Field
    private String sender;

    @Field
    private String receiver;

    @Field
    private String content;

    @Field
    @CreatedDate
    private LocalDateTime date;
}
