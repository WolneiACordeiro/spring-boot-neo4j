package dev.wolneicordeiro.springbootneo4j.requests;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class CourseEnrolmentRequest {
    private String courseIdentifier;
}
