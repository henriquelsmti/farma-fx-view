package br.com.datarey.sys.util;

import javafx.application.Platform;
import javafx.scene.control.Alert;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.lang.reflect.InvocationTargetException;

/**
 * Created by henri on 13/01/2016.
 */
public class ExceptionMessageUtil {

    public static void showError(Thread t, Throwable e) {
        if (Platform.isFxApplicationThread()) {
            Platform.runLater(() -> {
                Alert alert = null;
                alert = new Alert(Alert.AlertType.ERROR);
                String msg = obterMenssagem(e);
                alert.setHeaderText(msg);
                alert.show();
                e.printStackTrace();
            });
        }
    }

    private static String obterMenssagem(Throwable e){
        String msg = null;
        ConstraintViolationException violationException = procurarConstraintViolationException(e);
        if(violationException != null){
            msg = obterMsgBeanValidator(violationException);
        }else{
            if(e.getCause() != null && e.getCause() instanceof InvocationTargetException){
                msg = msg + "\n" + ((InvocationTargetException)e.getCause()).getTargetException().getMessage();
            }else {
                if (e.getCause() != null && e.getCause().getMessage() != null && !e.getCause().getMessage().equals(msg)) {
                    msg = msg + "\n" + e.getCause();
                }
            }
        }
        return msg == null ? "null" : msg;
    }

    private static ConstraintViolationException procurarConstraintViolationException(Throwable e){

        while (e != null){

            if(e instanceof ConstraintViolationException){
                return (ConstraintViolationException) e;
            }else if(e instanceof InvocationTargetException){
                return procurarConstraintViolationException(((InvocationTargetException)e).getTargetException());
            }else if(e.getCause() instanceof ConstraintViolationException){
                return (ConstraintViolationException) e.getCause();
            }else {
                e = e.getCause();
            }
        }

        return null;
    }


    private static String obterMsgBeanValidator(ConstraintViolationException e){
        StringBuilder builder = new StringBuilder();
        for(ConstraintViolation violation : e.getConstraintViolations()){
            builder.append(violation.getMessage());
            builder.append("\n");
        }
        return builder.toString();
    }
}
