package tech.turkisi.titlegen.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@Table(name = "title_formats")
@Entity
public class TitleFormat implements Serializable {
    @Id
    @SequenceGenerator(name = "title_format_generator", sequenceName = "ge_title_format", allocationSize = 1)
    @GeneratedValue(generator = "title_format_generator")
    private Long id;
    @Column
    private String name;
    @Column
    private String format;
}
