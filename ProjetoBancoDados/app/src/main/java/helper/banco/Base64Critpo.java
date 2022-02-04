package helper.banco;

import android.util.Base64;

public class Base64Critpo {
    Base64Critpo(){

    }

    public static String codificar(String texto){
        return Base64.encodeToString(texto.getBytes(),Base64.NO_WRAP);
    }

    public static String decodificar(String texto){
        return new String(Base64.decode(texto, Base64.NO_WRAP));
    }
}