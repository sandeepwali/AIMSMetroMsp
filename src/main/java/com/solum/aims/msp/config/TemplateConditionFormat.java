package com.solum.aims.msp.config;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class TemplateConditionFormat {

    public String implementClass;
    public List<PageCondition> selector;

    @Getter
    @Setter
    public static class PageCondition {

        public int page;
        public String defaultGroup;
        public List<Condition> conditionlist;

        @Getter
        @Setter
        public static class Condition {
            public String decidingField = "";
            public String innerTag = "";
            public String checkMethod = "";
            public String checkValue = "";
            public String then = "";
        }
    }
}
