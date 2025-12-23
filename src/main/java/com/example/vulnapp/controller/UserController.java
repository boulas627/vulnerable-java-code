
package com.example.vulnapp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.ExpressionParser;

@RestController
public class UserController {

    @GetMapping("/eval")
    public String eval(@RequestParam String expression) {

        // The line of code below is vulnerable to a spring expression injection vulnerability
        ExpressionParser parser = new SpelExpressionParser();
        return parser.parseExpression(expression).getValue().toString();
    }
}
