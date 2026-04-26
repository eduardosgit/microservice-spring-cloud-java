package br.com.estudo.springservice.services;

import br.com.estudo.springservice.exception.UnsupportedMathOperationException;
import br.com.estudo.springservice.model.CalcTypes;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class MathService {

    public Double calculate(CalcTypes type, String numberOne, String numberTwo) {
        try {
            Double arg01 = Double.parseDouble(numberOne);
            Double arg02 = 0.0;

            if (!StringUtils.isEmpty(numberTwo)) {
                arg02 = Double.parseDouble(numberTwo);
            }


            switch (type){
                case SUM:
                    return arg01 + arg02;
                case SUBTRACTION:
                    return arg01 - arg02;
                case DIVISION:
                    return arg01 / arg02;
                case MULTIPLICATION:
                    return arg01 * arg02;
                case AVERAGE:
                    return (arg01 + arg02) / 2;
                case SQUARE_ROOT:
                    return Math.sqrt(arg01);
                default:
                    throw  new UnsupportedMathOperationException("Error unknown Math Operation");
            }

        }catch (NumberFormatException e){
            throw new UnsupportedMathOperationException("Error parsing String to number");
        } catch (RuntimeException e){
            throw new UnsupportedMathOperationException("Error calculating Math Operation");
        }
    }
}

