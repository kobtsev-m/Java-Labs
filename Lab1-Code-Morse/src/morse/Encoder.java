package morse;

import utils.Converter;

public class Encoder extends Coder {

    public Encoder(String filename, String lang) {
        super(filename, lang);
        this.codeMap = new Converter(lang).getMap("code");
    }
    public void code() {
        code(true);
    }
}
