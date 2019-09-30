package com.everis.service;

import com.everis.model.ReportCourse;
import com.everis.repository.ReportCourseRepository;

import org.springframework.stereotype.Service;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class ReportCourseService {

  private final ReportCourseRepository reportCourseRepository;

  public ReportCourseService(ReportCourseRepository reportCourseRepository) {
    this.reportCourseRepository = reportCourseRepository;
  }

  public Mono<ReportCourse> create(ReportCourse reportCourse) {
    return reportCourseRepository.save(reportCourse);
  }

  public Mono<ReportCourse> findById(String id) {
    return reportCourseRepository.findById(id);
  }

  public Flux<ReportCourse> findAll() {
    return reportCourseRepository.findAll();
  }
  
  /**
  * Method for Update ReportCourse By Id.
  */
  
  public Mono<ReportCourse> update(String id, ReportCourse updateReportCourse) {
    return reportCourseRepository.findById(id)
      .map(existingReportCourse -> existingReportCourse.toBuilder()
      .idCourse(updateReportCourse.getIdCourse())
      .idStudent(updateReportCourse.getIdStudent())
      .pc1(updateReportCourse.getPc1())
      .pc2(updateReportCourse.getPc2())
      .pc3(updateReportCourse.getPc3())
      .promedio(updateReportCourse.getPromedio())
      .relationship(updateReportCourse.getRelationship())
      .idTeacher(updateReportCourse.getIdTeacher())
      .build())
      .flatMap(reportCourseRepository::save);
  }
  
  /**
   * Method for Delete ReportCourse By Id.
   */

  public Mono<ReportCourse> deleteById(String id) {
    return reportCourseRepository.findById(id)
     .flatMap(reportCourse -> reportCourseRepository
     .delete(reportCourse).then(Mono.just(reportCourse)));
  }

}
