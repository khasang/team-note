package net.yandex.speller.services.spellservice;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class CheckTextUtil {

    private static String ADDRESS = "http://speller.yandex.net/services/spellservice?WSDL";

    public static String response (String text) throws MalformedURLException {
        URL url = new URL(ADDRESS);
        QName qName = new QName("http://speller.yandex.net/services/spellservice", "SpellService");

        Service service = Service.create(url, qName);

        SpellServiceSoap serviceSoap = service.getPort(SpellServiceSoap.class);

        CheckTextRequest request = new CheckTextRequest();
        request.setText(text);
        request.setLang("en");
        request.setFormat("plain");

        if (serviceSoap.checkText(request).getSpellResult().getError().isEmpty() || serviceSoap.checkText(request).getSpellResult().getError() == null){
            return "OK";
        } else {
            serviceSoap.checkText(request).getSpellResult().getError();
            return serviceSoap.checkText(request).getSpellResult().getError().get(0).getS().toString();
        }

    }
}
