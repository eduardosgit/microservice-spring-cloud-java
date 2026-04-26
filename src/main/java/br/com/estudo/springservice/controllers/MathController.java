package br.com.estudo.springservice.controllers;

import br.com.estudo.springservice.exception.UnsupportedMathOperationException;
import br.com.estudo.springservice.model.CalcTypes;
import br.com.estudo.springservice.services.MathService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/math")
public class MathController {

    @Autowired
    private MathService mathService;

    @GetMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(@PathVariable String numberOne, @PathVariable String numberTwo) {
        try {
            return mathService.calculate(CalcTypes.SUM, numberOne, numberTwo);
        } catch (NumberFormatException e) {
            throw new UnsupportedMathOperationException("Error parsing string to number.");
        }
    }

    @GetMapping("/subtraction/{numberOne}/{numberTwo}")
    public Double subtraction(@PathVariable String numberOne, @PathVariable String numberTwo) {
        try {
            return mathService.calculate(CalcTypes.SUBTRACTION, numberOne, numberTwo);
        } catch (NumberFormatException e) {
            throw new UnsupportedMathOperationException("Error parsing string to number.");
        }
    }

    @GetMapping("/division/{numberOne}/{numberTwo}")
    public Double division(@PathVariable String numberOne, @PathVariable String numberTwo) {

        try {

            if (numberTwo.equals("0") ||  numberTwo.equals("0.0")) {
                throw new UnsupportedMathOperationException("Error divider can't be zero.");
            }

            return mathService.calculate(CalcTypes.DIVISION, numberOne, numberTwo);
        } catch (NumberFormatException e) {
            throw new UnsupportedMathOperationException("Error parsing string to number.");
        }
    }

    @GetMapping("/multiplication/{numberOne}/{numberTwo}")
    public Double multiplication(@PathVariable String numberOne, @PathVariable String numberTwo) {
        try {
            return mathService.calculate(CalcTypes.MULTIPLICATION, numberOne,numberTwo);
        } catch (NumberFormatException e) {
            throw new UnsupportedMathOperationException("Error parsing string to number.");
        }
    }

    @GetMapping("/squareRoot/{number}")
    public Double squareRoot(@PathVariable String number) {
        try {
            return mathService.calculate(CalcTypes.SQUARE_ROOT, number,null);
        } catch (NumberFormatException e) {
            throw new UnsupportedMathOperationException("Error parsing string to number.");
        }
    }
}
