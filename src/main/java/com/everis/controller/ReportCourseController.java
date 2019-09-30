package com.everis.controller;

import com.everis.model.ReportCourse;
import com.everis.service.ReportCourseService;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/reports")
public class ReportCourseController {

  private final ReportCourseService reportCourseService;

  public ReportCourseController(ReportCourseService reportCourseService) {
    this.reportCourseService = reportCourseService;
  }

  @GetMapping
  public Flux<ReportCourse> list() {
    return reportCourseService.findAll();
  }

  /**
  * Method for Find By Id.
  */
  @GetMapping("{id}")
  public Mono<ResponseEntity<ReportCourse>> findById(@PathVariable String id) {
    return reportCourseService.findById(id)
      .map(ResponseEntity::ok)
     .defaultIfEmpty(ResponseEntity.notFound()
      .build());
  }

  /**
  * Method for Create ReportCourse.
  */
  
  @PostMapping
  public Mono<ResponseEntity<ReportCourse>> 
       createReportCourse(@RequestBody @Valid ReportCourse reportCourse) {
    ReportCourse reportCourseToCrete = reportCourse.toBuilder().id(null).build();
    return reportCourseService.create(reportCourseToCrete)
    .map(newReportCourse -> ResponseEntity
    .created(URI.create("/reports/" + newReportCourse.getId()))
    .body(newReportCourse));
  }

  @PutMapping("{id}")
  public Mono<ResponseEntity<ReportCourse>> updateReportCourse(@PathVariable String id, 
      @RequestBody @Valid ReportCourse reportCourse) {
    return reportCourseService.update(id, reportCourse).map(ResponseEntity::ok)
    .defaultIfEmpty(ResponseEntity.notFound().build());
  }

  @DeleteMapping("{id}")
  public Mono<ResponseEntity<Void>> deleteReportCourse(@PathVariable String id) {
    return reportCourseService.deleteById(id).map(r -> ResponseEntity.ok().<Void>build())
    .defaultIfEmpty(ResponseEntity.notFound().build());
  }

}
