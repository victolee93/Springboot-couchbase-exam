package com.victolee.couchbaseexam.dto;

import lombok.*;

import java.time.LocalDateTime;

@Builder
@Getter
@Setter
@ToString
@AllArgsConstructor
public class MessageLogDto {
    private String id;
    private String sender;
    private String receiver;
    private String content;
    private LocalDateTime date;
}
