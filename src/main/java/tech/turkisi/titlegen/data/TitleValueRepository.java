package tech.turkisi.titlegen.data;

import tech.turkisi.titlegen.domain.TitleValue;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TitleValueRepository extends BaseJpaRepository<TitleValue, Long> {

    public TitleValueRepository() {
        super(TitleValue.class);
    }
}
