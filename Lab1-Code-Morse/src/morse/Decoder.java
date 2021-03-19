package morse;

import utils.Converter;

public class Decoder extends Coder {

    public Decoder(String filename, String lang) {
        super(filename, lang);
        this.codeMap = new Converter(lang).getMap(false);
    }
    public void code() {
        code(false);
    }
}
