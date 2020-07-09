package tech.turkisi.titlegen.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Table(name = "title_segments")
@Entity
public class TitleSegment implements Serializable {
    @Id
    @SequenceGenerator(name = "title_segment_generator", sequenceName = "ge_title_segment", allocationSize = 1)
    @GeneratedValue(generator = "title_segment_generator")
    private Long id;
    @Column
    private String description;
    @Column
    private String format;
}
