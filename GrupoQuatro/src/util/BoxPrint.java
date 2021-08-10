package util;

import java.util.Map;

/**
 *
 * @author Celiculos
 */
public class BoxPrint {

    private Map<String, String> text;
    private short length;


    public BoxPrint(final Map<String, String> text, short length) {
        this.validateSize(length);
        this.text   = text;
        this.length = length;
    }

    public BoxPrint(final Map<String, String> text) {
        this(text, (short) (StringUtils.getMaxLength(text)));
    }

    private void validateSize(short size) {
        if(size <= 0) {
            throw new IllegalArgumentException("O tamanho deve ser positivo");
        }
    }

    private String format() {
        StringBuilder box = new StringBuilder(this.singleLine());
        box.append("\r\n");
        text.entrySet().forEach(pair -> {
            box.append(
              String.format(
                "| %s |%n",
                StringUtils.pad(
                  String.format(
                    "%s: %s",
                    pair.getKey(),
                    pair.getValue()
                  ),
                  this.length + 2
                )
              )
            );
        });
        box.append(this.singleLine());
        return box.toString();
    }

    private String singleLine() {
        return String.format("+%s+", StringUtils.fill('-', this.length + 4));
    }

    @Override
    public String toString() {
        return this.format();
    }

}