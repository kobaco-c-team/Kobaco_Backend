package com.kobaco.kobaco_project.presentation.trend;

import com.kobaco.kobaco_project.application.trend.TrendApplication;
import com.kobaco.kobaco_project.application.trend.dto.response.TimeStatisticResponse;
import com.kobaco.kobaco_project.application.trend.dto.response.PersonStatisticResponse;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/api/trend")
@RequiredArgsConstructor
public class TrendController {

    private final TrendApplication trendApplication;

    @Operation(summary = "트렌드 성별&나이 분석 조회")
    @GetMapping("/person")
    public PersonStatisticResponse getPersonStatistic(@RequestParam String trendKwd) {
        return trendApplication.getPersonStatistic(trendKwd);
    }

    @Operation(summary = "트렌드 월별 & 요일별 분석 조회")
    @GetMapping("/time")
    public TimeStatisticResponse getTimeStatistic(@RequestParam String trendKwd) {
        return trendApplication.getTimeStatistic(trendKwd);
    }



}
