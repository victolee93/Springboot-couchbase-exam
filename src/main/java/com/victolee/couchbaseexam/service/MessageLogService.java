package com.victolee.couchbaseexam.service;

import com.victolee.couchbaseexam.domain.document.MessageLogDocument;
import com.victolee.couchbaseexam.domain.repository.MessageLogRepository;
import com.victolee.couchbaseexam.dto.MessageLogDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class MessageLogService {
    private final MessageLogRepository messageLogRepository;

    /**
     * get log
     */
    public List<MessageLogDto> getLogList(LocalDateTime startDateTime, LocalDateTime endDateTime) {
        List<MessageLogDto> messageLogDtos = new ArrayList<>();
        List<MessageLogDocument> messageLogDocuments = messageLogRepository.findAllByDateBetween(startDateTime, endDateTime);

        for (MessageLogDocument messageLogDocument : messageLogDocuments) {
            messageLogDtos.add(this.convertDocumentToDto(messageLogDocument));
        }

        return messageLogDtos;
    }

    /**
     * add log
     */
    public void setLog(MessageLogDto messageLogDto) {
        messageLogRepository.save(this.createLogDocument(messageLogDto));
    }

    /**
     * convert Dto to Document
     */
    private MessageLogDocument createLogDocument(MessageLogDto messageLogDto) {
        return MessageLogDocument.builder()
                .content(messageLogDto.getContent())
                .sender(messageLogDto.getSender())
                .receiver(messageLogDto.getReceiver())
                .date(LocalDateTime.now())
                .build();
    }

    /**
     * convert Document to Dto
     */
    private MessageLogDto convertDocumentToDto(MessageLogDocument messageLogDocument) {
        return MessageLogDto.builder()
                .sender(messageLogDocument.getSender())
                .receiver(messageLogDocument.getReceiver())
                .content(messageLogDocument.getContent())
                .date(messageLogDocument.getDate())
                .build();
    }
}
