package tech.turkisi.titlegen.data;

import tech.turkisi.titlegen.domain.TitleFormat;

import javax.enterprise.context.RequestScoped;

@RequestScoped
public class TitleFormatRepository extends BaseJpaRepository<TitleFormat, Long> {

    public TitleFormatRepository() {
        super(TitleFormat.class);
    }

    public TitleFormat findByName(String name) {

        return (TitleFormat) entityManager.createQuery(
                "select titleFormat from TitleFormat titleFormat where titleFormat.name = :name").setParameter("name", name)
                .getSingleResult();
    }
}
