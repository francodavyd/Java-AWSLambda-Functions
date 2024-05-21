package org.francodavyd;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class AlgebraCalculator implements RequestHandler<AlgebraRequest, AlgebraResponse> {
    @Override
    public AlgebraResponse handleRequest(AlgebraRequest algebraRequest, Context context) {
        double numeroA = algebraRequest.getNumeroA();
        double numeroB = algebraRequest.getNumeroB();
        String operacion = algebraRequest.getOperacion();
        double respuesta = this.obtenerRespuesta(operacion, numeroA, numeroB);
        return new AlgebraResponse(respuesta);
    }
    private Double obtenerRespuesta(String operacion, double numeroA, double numeroB){
        double respuesta = 0.0;
        if (operacion.equalsIgnoreCase("suma")){
            respuesta = numeroA + numeroB;
        } else if ( operacion.equalsIgnoreCase("resta")){
            respuesta = numeroA - numeroB;
        } else if (operacion.equalsIgnoreCase("division")) {
            respuesta = numeroA / numeroB;
        } else if (operacion.equalsIgnoreCase("multiplicacion")) {
            respuesta = numeroA * numeroB;
        }
        return respuesta;
    }
}