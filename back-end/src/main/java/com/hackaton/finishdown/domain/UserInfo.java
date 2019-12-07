package com.hackaton.finishdown.domain;

import org.springframework.stereotype.Component;

@Component
public class UserInfo {

    private String city;
    private Desires desires;
    private TypeHuman type;
    private AcademicPerformance ap;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Desires getDesires() {
        return desires;
    }

    public void setDesires(Desires desires) {
        this.desires = desires;
    }

    public TypeHuman getType() {
        return type;
    }

    public void setType(TypeHuman type) {
        this.type = type;
    }

    public AcademicPerformance getAp() {
        return ap;
    }

    public void setAp(AcademicPerformance ap) {
        this.ap = ap;
    }
}
