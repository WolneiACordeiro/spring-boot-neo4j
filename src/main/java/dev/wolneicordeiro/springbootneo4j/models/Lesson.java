package dev.wolneicordeiro.springbootneo4j.models;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

@Getter
@Setter
@NoArgsConstructor
@Node
public class Lesson {
    @Id
    @GeneratedValue
    private Long id;
    private String identifier;
}
