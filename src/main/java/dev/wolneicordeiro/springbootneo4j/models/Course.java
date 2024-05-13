package dev.wolneicordeiro.springbootneo4j.models;

import lombok.*;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
@Setter
@Node
public class Course {
    @Id @GeneratedValue
    private Long id;
    private String identifier;
    private String title;
    private String teacher;

    @Setter(AccessLevel.NONE)
    @Relationship(type = "BELONGS_TO", direction = Relationship.Direction.INCOMING)
    private List<Lesson> lessons = new ArrayList<>();
}
