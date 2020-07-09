package tech.turkisi.titlegen.biz;

import tech.turkisi.titlegen.data.TitleFormatRepository;
import tech.turkisi.titlegen.data.TitleValueRepository;
import tech.turkisi.titlegen.domain.TitleFormat;
import tech.turkisi.titlegen.domain.TitleValue;

import javax.inject.Inject;
import javax.persistence.NoResultException;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class TitleGenerator {

    @Inject
    private TitleValueRepository titleValueRepository;

    @Inject
    private TitleFormatRepository titleFormatRepository;

    public String getRandomTitle() {
        return getRandomTitle(RandomSelector.pickOne(titleFormatRepository.findAll()).getFormat());
    }

    public String getRandomTitleByFormatName(String formatName) {
        final TitleFormat format;
        try {
            format = titleFormatRepository.findByName(formatName);
        } catch (NoResultException e) {
            throw new NonExistingFormatException(formatName);
        }
        return getRandomTitle(format.getFormat());
    }

    public String getRandomTitle(String format) {

        final Map<String, List<TitleValue>> valuesBySegmentFormats =
                titleValueRepository.findAll().stream().collect(Collectors.groupingBy(value -> value.getSegment().getFormat()));

        StringBuilder stringBuilder = new StringBuilder();
        final String[] segments = format.split("\\s");
        for (String segment : segments) {
            final List<TitleValue> values = valuesBySegmentFormats.get(segment);
            if (values == null) {
                throw new NonExistingFormatException(segment);
            }
            stringBuilder.append(RandomSelector.pickOne(values).getValue()).append(' ');
        }
        return stringBuilder.toString().trim();
    }
}
