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

import java.time.LocalTime;
import java.util.List;
import java.util.function.Function;

/**
 * Given a {@link LocalTime} extracts a component.
 */
final class NumberExpressionFunctionLocalTime<C extends ExpressionFunctionContext> extends NumberExpressionFunction<C> {

    /**
     * HOUR Instance getter.
     * https://exceljet.net/excel-functions/excel-hour-function
     * <pre>
     * The Excel HOUR function returns the hour component of a time as a number between 0-23. For example,
     * with a time of 9:30 AM, HOUR will return 9. You can use the HOUR function to extract the hour into a cell,
     * or feed the result into another formula, like the TIME function.
     * </pre>
     */
    static <C extends ExpressionFunctionContext> NumberExpressionFunctionLocalTime<C> hour() {
        return Cast.to(HOUR);
    }

    /**
     * MINUTE Instance getter.
     * https://exceljet.net/excel-functions/excel-minute-function
     * <pre>
     * The Excel MINUTE function extracts the minute from a given time as number between 1 to 12.
     * </pre>
     */
    static <C extends ExpressionFunctionContext> NumberExpressionFunctionLocalTime<C> minute() {
        return Cast.to(MINUTE);
    }

    /**
     * SECOND Instance getter.
     */
    static <C extends ExpressionFunctionContext> NumberExpressionFunctionLocalTime<C> second() {
        return Cast.to(SECOND);
    }

    /**
     * HOUR Singleton
     */
    private static final NumberExpressionFunctionLocalTime<?> HOUR = new NumberExpressionFunctionLocalTime<>(
            "hour",
            LocalTime::getHour
    );

    /**
     * MINUTE Singleton
     */
    private static final NumberExpressionFunctionLocalTime<?> MINUTE = new NumberExpressionFunctionLocalTime<>(
            "minute",
            LocalTime::getMinute
    );

    /**
     * SECOND Singleton
     */
    private static final NumberExpressionFunctionLocalTime<?> SECOND = new NumberExpressionFunctionLocalTime<>(
            "second",
            LocalTime::getSecond
    );

    /**
     * Private ctor
     */
    private NumberExpressionFunctionLocalTime(final String name,
                                              final Function<LocalTime, Integer> mapper) {
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
                                TIME.getOrFail(parameters, 0)
                        )
                );
    }

    private final Function<LocalTime, Integer> mapper;

    @Override
    public List<ExpressionFunctionParameter<?>> parameters() {
        return PARAMETERS;
    }

    final static ExpressionFunctionParameter<LocalTime> TIME = ExpressionFunctionParameterName.with("time")
            .setType(LocalTime.class);

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = ExpressionFunctionParameter.list(
            TIME
    );
}
