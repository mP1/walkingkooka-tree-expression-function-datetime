/*
 * Copyright 2019 Miroslav Pokorny (github.com/mP1)
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

import walkingkooka.collect.list.Lists;
import walkingkooka.reflect.PublicStaticHelper;
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.function.ExpressionFunction;
import walkingkooka.tree.expression.function.ExpressionFunctionContext;

import java.util.function.Consumer;

/**
 * Collection of static factory methods for numerous {@link ExpressionFunction}.
 */
public final class DateTimeExpressionFunctions implements PublicStaticHelper {

    /**
     * Visit all {@link ExpressionFunction functions}.
     */
    public static void visit(final Consumer<ExpressionFunction<?, ?>> consumer) {
        Lists.<ExpressionFunction<?, ?>>of(
                day(),
                hour(),
                minute(),
                month(),
                second(),
                weekday(),
                year()
        ).forEach(consumer);
    }

    /**
     * {@see NumberExpressionFunctionLocalDateComponent#day}
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> day() {
        return NumberExpressionFunctionLocalDateComponent.day();
    }

    /**
     * {@see NumberExpressionFunctionLocalTime#hour}
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> hour() {
        return NumberExpressionFunctionLocalTime.hour();
    }

    /**
     * {@see NumberExpressionFunctionLocalTime#minute}
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> minute() {
        return NumberExpressionFunctionLocalTime.minute();
    }

    /**
     * {@see NumberExpressionFunctionLocalDateComponent#month}
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> month() {
        return NumberExpressionFunctionLocalDateComponent.month();
    }

    /**
     * {@see NumberExpressionFunctionLocalTime#second}
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> second() {
        return NumberExpressionFunctionLocalTime.second();
    }

    /**
     * {@see NumberExpressionFunctionLocalDateWeekdayWeekNum#weekday}
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> weekday() {
        return NumberExpressionFunctionLocalDateWeekdayWeekNum.weekday();
    }

    /**
     * {@see NumberExpressionFunctionLocalDateComponent#year}
     */
    public static <C extends ExpressionFunctionContext> ExpressionFunction<ExpressionNumber, C> year() {
        return NumberExpressionFunctionLocalDateComponent.year();
    }

    /**
     * Stops creation
     */
    private DateTimeExpressionFunctions() {
        throw new UnsupportedOperationException();
    }
}
