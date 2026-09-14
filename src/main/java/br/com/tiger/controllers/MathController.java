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
