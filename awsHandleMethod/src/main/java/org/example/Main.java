package org.example;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;

public class Main implements RequestHandler<Input, Output> {

    @Override
    public Output handleRequest(Input input, Context context) {
        String response = "Hola " + input.getNombre();
        Output output = new Output();
        output.setResponse(response);
        return output;
    }
}