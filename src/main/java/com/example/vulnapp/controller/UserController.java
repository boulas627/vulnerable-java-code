
package com.example.vulnapp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.support.SimpleEvaluationContext;
import org.springframework.expression.EvaluationContext;

@RestController
public class UserController {

    @GetMapping("/eval")
    public String eval(@RequestParam String expression) {
        ExpressionParser parser = new SpelExpressionParser();
        EvaluationContext context = SimpleEvaluationContext.forReadOnlyDataBinding().build();
        return parser.parseExpression(expression).getValue(context, String.class);
    }
}
