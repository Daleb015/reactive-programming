package org.example.combining_observables;

public class Employee {

  private Integer code;
  private String name;
  private Integer salary;
  private Double qualification;

  public Employee(Integer code, String name, Integer salary, Double qualification) {
    this.code = code;
    this.name = name;
    this.salary = salary;
    this.qualification = qualification;
  }

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Integer getSalary() {
    return salary;
  }

  public void setSalary(Integer salary) {
    this.salary = salary;
  }

  public Double getQualification() {
    return qualification;
  }

  public void setQualification(Double qualification) {
    this.qualification = qualification;
  }

  @Override
  public String toString() {
    return (
      "Employee{" +
      "code=" +
      code +
      ", name='" +
      name +
      '\'' +
      ", salary=" +
      salary +
      ", qualification=" +
      qualification +
      '}'
    );
  }
}
