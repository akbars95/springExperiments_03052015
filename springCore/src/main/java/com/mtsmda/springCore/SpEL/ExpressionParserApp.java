package com.mtsmda.springCore.SpEL;

import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.standard.SpelExpressionParser;
import org.springframework.expression.spel.support.StandardEvaluationContext;

/**
 * Created by MTSMDA on 06.06.2015.
 */
public class ExpressionParserApp {

    public ExpressionParserApp() {
        expressionMethod();
    }

    private void expressionMethod(){
        ExpressionParser expressionParser = new SpelExpressionParser();

        Expression expression = expressionParser.parseExpression("'This is expression'");
        String msg1 = expression.getValue(String.class);
        System.out.println(msg1);

        Expression expression1 = expressionParser.parseExpression("'lenght'.length()");
        int msg2 = (Integer)expression1.getValue();
        System.out.println(msg2);

        Expression expression2 = expressionParser.parseExpression("100 * 2");
        System.out.println(expression2.getValue());

        ListMapTest listMapTest = new ListMapTest();
        StandardEvaluationContext standardEvaluationContext = new StandardEvaluationContext(listMapTest);

        Expression expression3 = expressionParser.parseExpression("email");
        System.out.println(expression3.getValue(listMapTest, String.class));

        Expression expression4 = expressionParser.parseExpression("email == 'ivan.ivanov@mail.ru'");
        System.out.println(expression4.getValue(listMapTest, Boolean.class));

    }

}