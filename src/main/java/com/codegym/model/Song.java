package com.codegym.model;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class Song implements Validator {
    private String name;
    private String single;
    private String category;

    public Song() {
    }

    public Song(String name, String single, String category) {
        this.name = name;
        this.single = single;
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSingle() {
        return single;
    }

    public void setSingle(String single) {
        this.single = single;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        Song song = (Song) target;
        String name = song.getName();
        String single = song.getSingle();
        String category = song.getCategory();
// validate name
        ValidationUtils.rejectIfEmpty(errors,"name","name1.empty");
        if (name.length()>8000){
            errors.rejectValue("name","name1.length");
        }
        if (!name.matches("(^[a-zA-z0-9]$)")){
            errors.rejectValue("name","name1.matches");
        }
//    validate single
ValidationUtils.rejectIfEmpty(errors,"single","single.empty");
        if (single.length()>300){
            errors.rejectValue("single","single.length");
        }
        if (!single.matches("(^[a-zA-Z0-9]$)")){
            errors.rejectValue("single","single.matches");
        }

//        validate category
        ValidationUtils.rejectIfEmpty(errors,"category","category.empty");
        if (category.length()>1000){
            errors.rejectValue("category","category.length");
        }
        if (!category.matches("(^[a-zA-Z0-9,]$)")){
            errors.rejectValue("category","category.matches");
        }
    }
}
