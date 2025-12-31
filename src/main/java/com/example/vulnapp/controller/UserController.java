
package com.example.vulnapp.controller;

import org.springframework.web.bind.annotation.*;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.ExpressionParser;

@RestController
public class UserController {

    // Spring Expression Language is used to convert a string expression into an expression object

    @GetMapping("/eval")
    public String eval(@RequestParam String expression) {
        ExpressionParser parser = new SpelExpressionParser();

    // the fix below assumes that SpEL usage is required and imposes various restrictions on its usage. The best case scenario would be to remove it entirely if possible. 

        StandardEvaluationContext context = new StandardEvaluationContext();

        context.setTypeLocator(typeName -> {
            throw new EvaluationException("Type access is not allowed");
        });

        context.setMethodResolvers(Collections.emptyList());

        context.setPropertyAccessors(Collections.emptyList());

        Object value = parser.parseExpression(expression).getValue(context);
        
        return String.valueOf(value);

    }
}
