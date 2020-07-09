package tech.turkisi.titlegen.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Table(name = "title_values")
@Entity
public class TitleValue implements Serializable {

    @Id
    @SequenceGenerator(name = "title_value_generator", sequenceName = "ge_title_value", allocationSize = 1)
    @GeneratedValue(generator = "title_value_generator")
    private Long id;
    @ManyToOne
    @JoinColumn(name = "segment_id")
    private TitleSegment segment;
    @Column
    private String value;
}
