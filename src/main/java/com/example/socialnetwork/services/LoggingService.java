package com.example.socialnetwork.services;

import com.example.socialnetwork.utils.GsonParserUtils;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
@Slf4j
@Log4j
public class LoggingService {
    private static final String REQUEST_ID = "request_id";

    public void logRequest(HttpServletRequest httpServletRequest, Object body) {
        if (httpServletRequest.getRequestURI().contains("medias")) {
            return;
        }
        Object requestId = httpServletRequest.getAttribute(REQUEST_ID);
        StringBuilder data = new StringBuilder();
        data.append("nLOGGING REQUEST BODY-----------------------------------n")
                .append("[REQUEST-ID]: ").append(requestId).append("n")
                .append("[BODY REQUEST]: ").append("nn")
                .append(GsonParserUtils.parseObjectToString(body))
                .append("nn")
                .append("LOGGING REQUEST BODY-----------------------------------n");

        log.info(data.toString());
    }

    public void logResponse(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object body) {
        if (httpServletRequest.getRequestURI().contains("medias")) {
            return;
        }
        Object requestId = httpServletRequest.getAttribute(REQUEST_ID);
        StringBuilder data = new StringBuilder();
        data.append("nLOGGING RESPONSE-----------------------------------n")
                .append("[REQUEST-ID]: ").append(requestId).append("n")
                .append("[BODY RESPONSE]: ").append("nn")
                .append(GsonParserUtils.parseObjectToString(body))
                .append("nn")
                .append("LOGGING RESPONSE-----------------------------------n");

        log.info(data.toString());
    }
}