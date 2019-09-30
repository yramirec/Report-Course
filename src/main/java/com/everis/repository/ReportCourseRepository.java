package com.everis.repository;

import com.everis.model.ReportCourse;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface ReportCourseRepository extends ReactiveMongoRepository<ReportCourse, String> {

}
