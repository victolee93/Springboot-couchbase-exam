package com.victolee.couchbaseexam.controller;

import com.victolee.couchbaseexam.dto.MessageLogDto;
import com.victolee.couchbaseexam.service.MessageLogService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@AllArgsConstructor
@RequestMapping(value = "/log")
public class MessageLogController {
    private final MessageLogService messageLogService;

    @GetMapping
    public List<Map<String, Object>> getLogList(String startDateTime, String endDateTime) {
        List<MessageLogDto> messageLogDtos = messageLogService.getLogList(LocalDateTime.parse(startDateTime), LocalDateTime.parse(endDateTime));

        List<Map<String, Object>> messageLogList = new ArrayList<>();
        for (MessageLogDto mailLogDto : messageLogDtos) {
            Map<String, Object> result = new HashMap<>();
            result.put("sender", mailLogDto.getSender());
            result.put("receiver", mailLogDto.getReceiver());
            result.put("content", mailLogDto.getContent());
            result.put("date", mailLogDto.getDate());
            messageLogList.add(result);
        }

        return messageLogList;
    }

    @PostMapping
    public String setLog(MessageLogDto messageLogDto) {
        messageLogService.setLog(messageLogDto);

        return "success";
    }
}
