package com.kobaco.kobaco_project.presentation.trend;

import com.kobaco.kobaco_project.application.trend.TrendApplication;
import com.kobaco.kobaco_project.application.trend.dto.TrendAnalysisResponse;
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

    @Operation(summary = "SNS 트렌드 검색 api 입니다.\n"
            + "kwdVal은 검색어, snsType은 sns 유형입니다. "
            + "kwdVal이 없으면 빈 문자열을 넣어주세요. "
            + "snsType은 {INSTAGRAM, YOUTUBE} 중 하나를 넣어주세요."
    )
    @GetMapping("")
    public TrendAnalysisResponse getTrendAnalysis(
            @RequestParam(value = "kwdVal") String kwdVal,
            @RequestParam(value = "snsType") String snsType
    ){
        return trendApplication.getTrendAnalysis(kwdVal, snsType);
    }
}
