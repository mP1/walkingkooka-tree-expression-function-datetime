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
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.FunctionExpressionName;
import walkingkooka.tree.expression.function.ExpressionFunctionContext;
import walkingkooka.tree.expression.function.ExpressionFunctionParameter;
import walkingkooka.tree.expression.function.ExpressionFunctionParameterName;

import java.time.LocalDate;
import java.util.List;
import java.util.function.Function;

/**
 * Given a {@link LocalDate} extracts a component.
 */
final class NumberExpressionFunctionLocalDate<C extends ExpressionFunctionContext> extends NumberExpressionFunction<C> {

    /**
     * DAY Instance getter.
     */
    static <C extends ExpressionFunctionContext> NumberExpressionFunctionLocalDate<C> day() {
        return Cast.to(DAY);
    }

    /**
     * MONTH Instance getter.
     * https://exceljet.net/excel-functions/excel-month-function
     * <pre>
     * The Excel MONTH function extracts the month from a given date as number between 1 to 12.
     * </pre>
     */
    static <C extends ExpressionFunctionContext> NumberExpressionFunctionLocalDate<C> month() {
        return Cast.to(MONTH);
    }

    /**
     * YEAR Instance getter.
     */
    static <C extends ExpressionFunctionContext> NumberExpressionFunctionLocalDate<C> year() {
        return Cast.to(YEAR);
    }

    /**
     * DAY Singleton
     */
    private static final NumberExpressionFunctionLocalDate<?> DAY = new NumberExpressionFunctionLocalDate<>(
            "day",
            LocalDate::getDayOfMonth
    );

    /**
     * MONTH Singleton
     */
    private static final NumberExpressionFunctionLocalDate<?> MONTH = new NumberExpressionFunctionLocalDate<>(
            "month",
            LocalDate::getMonthValue
    );

    /**
     * YEAR Singleton
     */
    private static final NumberExpressionFunctionLocalDate<?> YEAR = new NumberExpressionFunctionLocalDate<>(
            "year",
            LocalDate::getYear
    );

    /**
     * Private ctor
     */
    private NumberExpressionFunctionLocalDate(final String name,
                                              final Function<LocalDate, Integer> mapper) {
        super();
        this.name = FunctionExpressionName.with(name);
        this.mapper = mapper;
    }

    @Override
    public FunctionExpressionName name() {
        return this.name;
    }

    private final FunctionExpressionName name;

    @Override
    public ExpressionNumber apply(final List<Object> parameters,
                                  final C context) {
        this.checkOnlyRequiredParameters(parameters);

        return context.expressionNumberKind()
                .create(
                        this.mapper.apply(
                                this.DATE.getOrFail(parameters, 0)
                        )
                );
    }

    private final Function<LocalDate, Integer> mapper;

    @Override
    public List<ExpressionFunctionParameter<?>> parameters() {
        return PARAMETERS;
    }

    final static ExpressionFunctionParameter<LocalDate> DATE = ExpressionFunctionParameterName.with("date")
            .setType(LocalDate.class);

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = ExpressionFunctionParameter.list(
            DATE
    );
}
