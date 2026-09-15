package br.com.tiger.controllers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.tiger.exception.UnsupportedMathOperationException;

@RestController
@RequestMapping("/math")
public class MathController {

    @RequestMapping("/sum/{numberOne}/{numberTwo}")
    public Double sum(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Invalid number");
        }
        return convertToDouble(numberOne) + convertToDouble(numberTwo);
    }
    
    @RequestMapping("/sub/{numberOne}/{numberTwo}")
    public Double sub(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Invalid number");
        }
        return convertToDouble(numberOne) - convertToDouble(numberTwo);
    }

    @RequestMapping("/mul/{numberOne}/{numberTwo}")
    public Double mul(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Invalid number");
        }
        return convertToDouble(numberOne) * convertToDouble(numberTwo);
    }

    @RequestMapping("/div/{numberOne}/{numberTwo}")
    public Double div(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Invalid number");
        }
        Double divisor = convertToDouble(numberTwo);
        if (divisor == 0D) {
            throw new UnsupportedMathOperationException("Division by zero");
        }
        return convertToDouble(numberOne) / divisor;
    }

    @RequestMapping("/avg/{numberOne}/{numberTwo}")
    public Double avg(
            @PathVariable("numberOne") String numberOne,
            @PathVariable("numberTwo") String numberTwo) {
        if (!isNumeric(numberOne) || !isNumeric(numberTwo)) {
            throw new UnsupportedMathOperationException("Invalid number");
        }
        return (convertToDouble(numberOne) + convertToDouble(numberTwo)) / 2D;
    }

    @RequestMapping("/sqrt/{number}")
    public Double sqrt(@PathVariable("number") String number) {
        if (!isNumeric(number)) {
            throw new UnsupportedMathOperationException("Invalid number");
        }
        Double value = convertToDouble(number);
        if (value < 0D) {
            throw new UnsupportedMathOperationException("Square root of negative number");
        }
        return Math.sqrt(value);
    }

    private boolean isNumeric(String strNumber) {
        if (strNumber == null || strNumber.isBlank()) {
            return false;
        }
        String number = strNumber.replace(",", ".");
        return number.matches("[-+]?\\d*\\.?\\d+");
    }

    private Double convertToDouble(String strNumber) {
        if (strNumber == null) {
            return 0D;
        }
        return Double.parseDouble(strNumber.replace(",", "."));
    }
}
