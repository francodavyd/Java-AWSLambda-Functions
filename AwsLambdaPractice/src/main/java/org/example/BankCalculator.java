package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

import java.math.BigDecimal;
import java.math.MathContext;
import java.math.RoundingMode;

// P = cantidad, I = interes, N = plazo
//  Cuota mensual = (P * i) / (1 - (1 + i) ^ (-n))

public class BankCalculator implements RequestHandler<BankRequest, BankResponse> {


    @Override
    public BankResponse handleRequest(BankRequest bankRequest, Context context) {
        MathContext contextMath = MathContext.DECIMAL128;
        // se establece con cuantos decimales queremos y el modo de redondeo, en este caso utilizamos uno llamado el redondeo del banquero
        BigDecimal cantidad = bankRequest.getCantidad().setScale(2, RoundingMode.HALF_UP);
        BigDecimal interes = bankRequest.getInteres().setScale(2, RoundingMode.HALF_UP)
                .divide(BigDecimal.valueOf(100), contextMath);

        BigDecimal interesConCuenta = bankRequest.getInteres().subtract(BigDecimal.valueOf(0.2) , contextMath)
                .setScale(2, RoundingMode.HALF_UP).divide(BigDecimal.valueOf(100));

        Integer plazo = bankRequest.getPlazo();
        BigDecimal cuotaTotal = calcularCuota(cantidad, interes, plazo, contextMath);
        BigDecimal cuotaTotalConCuenta = calcularCuota(cantidad, interesConCuenta, plazo, contextMath);
        BankResponse response = new BankResponse(cuotaTotal, plazo, interes, cuotaTotalConCuenta, interesConCuenta, plazo);
        return response;
    }

    //  Cuota mensual = (P * i) / (1 - (1 + i) ^ (-n))
    public BigDecimal calcularCuota(BigDecimal cantidad, BigDecimal interes, Integer plazo, MathContext mathContext){
        // (1+i)
        BigDecimal operacion1 = interes.add(BigDecimal.ONE, mathContext);
        // (1+i)^ (-n)
        BigDecimal operacion2 = operacion1.pow(plazo, mathContext);
        BigDecimal operacion2ConNNegativo = BigDecimal.ONE.divide(operacion2, mathContext);
        // Calculo total
        BigDecimal numerador = cantidad.multiply(interes, mathContext);
        BigDecimal division = BigDecimal.ONE.subtract(operacion2ConNNegativo, mathContext);
        BigDecimal cuotaTotal = numerador.divide(division, mathContext);
        cuotaTotal = cuotaTotal.setScale(2, RoundingMode.HALF_UP);
    return cuotaTotal;
    }
}