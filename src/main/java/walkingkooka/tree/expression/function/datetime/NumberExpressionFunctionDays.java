/*
 * Copyright 2020 Miroslav Pokorny (github.com/mP1)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package walkingkooka.tree.expression.function.datetime;

import walkingkooka.Cast;
import walkingkooka.tree.expression.ExpressionEvaluationContext;
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.function.ExpressionFunctionParameter;
import walkingkooka.tree.expression.function.ExpressionFunctionParameterKind;
import walkingkooka.tree.expression.function.ExpressionFunctionParameterName;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

// https://exceljet.net/excel-functions/excel-days-function
final class NumberExpressionFunctionDays<C extends ExpressionEvaluationContext> extends NumberExpressionFunction<C> {

    static <C extends ExpressionEvaluationContext> NumberExpressionFunctionDays<C> instance() {
        return Cast.to(INSTANCE);
    }

    private final static NumberExpressionFunctionDays<?> INSTANCE = new NumberExpressionFunctionDays<>();

    private NumberExpressionFunctionDays() {
        super("days");
    }

    @Override
    public ExpressionNumber apply(final List<Object> parameters,
                                  final C context) {
        this.checkParameterCount(parameters);

        final LocalDate date1 = DATE1.getOrFail(parameters, 0, context);
        final LocalDate date2 = DATE2.getOrFail(parameters, 1, context);

        return context.expressionNumberKind()
                .create(
                        ChronoUnit.DAYS.between(date2, date1)
                );
    }

    @Override
    public List<ExpressionFunctionParameter<?>> parameters(final int count) {
        return PARAMETERS;
    }

    private final static ExpressionFunctionParameter<LocalDate> DATE1 = ExpressionFunctionParameterName.with("date1")
            .required(LocalDate.class)
            .setKinds(ExpressionFunctionParameterKind.CONVERT_EVALUATE_RESOLVE_REFERENCES);

    private final static ExpressionFunctionParameter<LocalDate> DATE2 = ExpressionFunctionParameterName.with("date2")
            .required(LocalDate.class)
            .setKinds(ExpressionFunctionParameterKind.CONVERT_EVALUATE_RESOLVE_REFERENCES);

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = ExpressionFunctionParameter.list(
            DATE1,
            DATE2
    );
}
