package com.everis.model;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "reports")
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class ReportCourse {

  @EqualsAndHashCode.Exclude
  @Id
  private String id;
  
  @EqualsAndHashCode.Exclude
  @NotBlank(message = "'Course' is required")
  private String idCourse;
  
  @EqualsAndHashCode.Exclude
  @NotBlank(message = "'Student' is required")
  private String idStudent;
  
  @EqualsAndHashCode.Exclude
  @NotNull(message = "'PC1' is required")
  @Positive(message = "'PC1' must be greater than zero")
  private float pc1;
  
  @EqualsAndHashCode.Exclude
  @NotNull(message = "'PC2' is required")
  @Positive(message = "'PC2' must be greater than zero")
  private float pc2;
  
  @EqualsAndHashCode.Exclude
  @NotNull(message = "'PC3' is required")
  @Positive(message = "'PC3' must be greater than zero")
  private float pc3;
  
  @EqualsAndHashCode.Exclude
  @NotNull(message = "'Promedio' is required")
  @Positive(message = "'promedio' must be greater than zero")
  private float promedio;
  
  @EqualsAndHashCode.Exclude
  @NotBlank(message = "'Relationship' is required")
  private String relationship;
  
  @EqualsAndHashCode.Exclude
  @NotBlank(message = "'Teacher' is required")
  private String idTeacher;

}
