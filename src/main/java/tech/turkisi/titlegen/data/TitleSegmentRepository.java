package tech.turkisi.titlegen.data;

import tech.turkisi.titlegen.domain.TitleSegment;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TitleSegmentRepository extends BaseJpaRepository<TitleSegment, Long> {

    public TitleSegmentRepository() {
        super(TitleSegment.class);
    }
}
