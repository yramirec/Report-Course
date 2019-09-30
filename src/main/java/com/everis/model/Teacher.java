package com.everis.model;

import java.util.Date;

import lombok.Data;

@Data
public class Teacher {

  private String id;
  private String name;
  private String gender;
  private Date dateOfBirth;
  private String typeDocument;
  private int numberDocument;
  private String idFamily;  

}
