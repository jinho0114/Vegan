package project.projecttest.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum Grade {
    Semi("SEMI"),
    Vegan("Vegan"),
    Fruitarian("Fruitarian");

    private final String value;
}
