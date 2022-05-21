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
import walkingkooka.tree.expression.ExpressionEvaluationContext;
import walkingkooka.tree.expression.ExpressionNumber;
import walkingkooka.tree.expression.function.ExpressionFunction;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.function.Consumer;

/**
 * Collection of static factory methods for numerous {@link ExpressionFunction}.
 */
public final class DateTimeExpressionFunctions implements PublicStaticHelper {

    /**
     * Visit all {@link ExpressionFunction functions}.
     */
    public static void visit(final Consumer<ExpressionFunction<?, ?>> consumer) {
        Lists.of(
                date(),
                dateMonthAdd(),
                dateValue(),
                day(),
                days(),
                hour(),
                isDate(),
                isoWeekNum(),
                minute(),
                month(),
                now(),
                second(),
                time(),
                timeValue(),
                today(),
                weekday(),
                weekNum(),
                year()
        ).forEach(consumer);
    }

    /**
     * {@see LocalDateExpressionFunctionDate}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<LocalDate, C> date() {
        return LocalDateExpressionFunctionDate.instance();
    }

    /**
     * {@see LocalDateExpressionFunctionDateMonthAdd}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<LocalDate, C> dateMonthAdd() {
        return LocalDateExpressionFunctionDateMonthAdd.instance();
    }

    /**
     * {@see NumberExpressionFunctionDateValue}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> dateValue() {
        return NumberExpressionFunctionDateValue.instance();
    }

    /**
     * {@see NumberExpressionFunctionLocalDateComponent#day}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> day() {
        return NumberExpressionFunctionLocalDateComponent.day();
    }

    /**
     * {@see NumberExpressionFunctionDays}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> days() {
        return NumberExpressionFunctionDays.instance();
    }

    /**
     * {@see NumberExpressionFunctionLocalTime#hour}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> hour() {
        return NumberExpressionFunctionLocalTime.hour();
    }

    /**
     * {@see BooleanExpressionFunctionIsDate}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<Boolean, C> isDate() {
        return BooleanExpressionFunctionIsDate.instance();
    }

    /**
     * {@see NumberExpressionFunctionIsoWeekNum}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> isoWeekNum() {
        return NumberExpressionFunctionIsoWeekNum.instance();
    }

    /**
     * {@see NumberExpressionFunctionLocalTime#minute}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> minute() {
        return NumberExpressionFunctionLocalTime.minute();
    }

    /**
     * {@see NumberExpressionFunctionLocalDateComponent#month}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> month() {
        return NumberExpressionFunctionLocalDateComponent.month();
    }

    /**
     * {@see LocalDateTimeExpressionFunctionNow}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<LocalDateTime, C> now() {
        return LocalDateTimeExpressionFunctionNow.instance();
    }

    /**
     * {@see NumberExpressionFunctionLocalTime#second}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> second() {
        return NumberExpressionFunctionLocalTime.second();
    }

    /**
     * {@see LocalTimeExpressionFunctionTime}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<LocalTime, C> time() {
        return LocalTimeExpressionFunctionTime.instance();
    }

    /**
     * {@see LocalTimeExpressionFunctionTimeValue}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> timeValue() {
        return NumberExpressionFunctionTimeValue.instance();
    }

    /**
     * {@see LocalDateExpressionFunctionToday}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<LocalDate, C> today() {
        return LocalDateExpressionFunctionToday.instance();
    }

    /**
     * {@see NumberExpressionFunctionLocalDateWeekdayWeekNum#weekday}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> weekday() {
        return NumberExpressionFunctionLocalDateWeekdayWeekNum.weekday();
    }

    /**
     * {@see NumberExpressionFunctionLocalDateWeekdayWeekNum#weeknum}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> weekNum() {
        return NumberExpressionFunctionLocalDateWeekdayWeekNum.weeknum();
    }

    /**
     * {@see NumberExpressionFunctionLocalDateComponent#year}
     */
    public static <C extends ExpressionEvaluationContext> ExpressionFunction<ExpressionNumber, C> year() {
        return NumberExpressionFunctionLocalDateComponent.year();
    }

    /**
     * Stops creation
     */
    private DateTimeExpressionFunctions() {
        throw new UnsupportedOperationException();
    }
}
