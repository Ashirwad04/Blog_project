package com.blog.project.Exception;

public class ResourseNotFoundException extends RuntimeException {

    String resourceName;
    String filedName;
    String filedValue;

    public ResourseNotFoundException(String resourceName, String filedName, String filedValue) {
        super(String.format("'%s' not found with %s='%s'", resourceName, filedName, filedValue));
        this.resourceName = resourceName;
        this.filedName = filedName;
        this.filedValue = filedValue;
    }

    public String getResourceName() {
        return resourceName;
    }

    public void setResourceName(String resourceName) {
        this.resourceName = resourceName;
    }

    public String getFiledName() {
        return filedName;
    }

    public void setFiledName(String filedName) {
        this.filedName = filedName;
    }

    public String getFiledValue() {
        return filedValue;
    }

    public void setFiledValue(String filedValue) {
        this.filedValue = filedValue;
    }

    //no args constructor
    public ResourseNotFoundException() {
    }
}
