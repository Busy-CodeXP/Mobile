package br.com.conectasampa.busy.util;

import android.app.Activity;
import android.app.AlertDialog;

/**
 * Created by GIS on 06/03/2018.
 */

public class MessageHelper {
    public static void MostraMensagem(Activity act, String titulo, String mensagem){
        new AlertDialog.Builder(act)
                .setTitle(titulo)
                .setMessage(mensagem)
                .setCancelable(true).show();
    }
}
