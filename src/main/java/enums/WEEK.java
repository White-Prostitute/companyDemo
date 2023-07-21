package enums;

import java.lang.annotation.Annotation;

public enum WEEK{

    MONDAY(1),FRIDAY(5);

    private int day;

    WEEK(int day){
        this.day = day;
    }
}
