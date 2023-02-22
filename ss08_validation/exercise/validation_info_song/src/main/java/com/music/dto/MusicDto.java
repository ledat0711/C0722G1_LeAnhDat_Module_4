package com.music.dto;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.*;

public class MusicDto implements Validator {
    private Integer id;
    @NotBlank(message = "Please enter information!")
    @Size(max = 800, message = "The song title cannot exceed 800 characters.")
    private String name;

    @NotBlank(message = "Please enter information!")
    @Size(max = 300, message = "The name of singer title cannot exceed 300 characters.")
    private String singer;

    @NotBlank(message = "Please enter information!")
    @Size(max = 1000, message = "The name of category cannot exceed 1000 characters.")
    private String category;

    public MusicDto() {
    }

    public MusicDto(Integer id, String name, String singer, String category) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
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
        MusicDto musicDto = (MusicDto) target;
        String regexCommon = "^[a-zỳọáầảấờễàạằệếýộậốũứĩõúữịỗìềểẩớặòùồợãụủíỹắẫựỉỏừỷởóéửỵẳẹèẽổẵẻỡơôưăêâđ0-9A-ZĐỲỌÁẦẢẤỜỄÀẠẰỆẾÝỘẬỐŨỨĨÕÚỮỊỖÌỀỂẨỚẶÒÙỒỢÃỤỦÍỸẮẪỰỈỎỪỶỞÓÉỬỴẲẸÈẼỔẴẺỠƠÔƯĂÊÂ ]+$";
        if(!musicDto.getName().matches(regexCommon)) {
            errors.rejectValue("name", "404.matches");
        }
        if(!musicDto.getSinger().matches(regexCommon)){
            errors.rejectValue("singer", "404.matches");
        }
        if(!musicDto.getCategory().matches(regexCommon)){
            errors.rejectValue("category", "404.matches");
        }
    }
}
