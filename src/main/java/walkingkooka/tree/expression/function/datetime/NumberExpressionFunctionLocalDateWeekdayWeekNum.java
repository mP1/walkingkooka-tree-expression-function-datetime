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
import walkingkooka.tree.expression.function.ExpressionFunctionParameterName;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.TemporalField;
import java.time.temporal.WeekFields;
import java.util.List;
import java.util.Optional;
import java.util.function.BiFunction;

/**
 * Given a {@link LocalDate} extracts the weekday or weeknum
 */
final class NumberExpressionFunctionLocalDateWeekdayWeekNum<C extends ExpressionEvaluationContext> extends NumberExpressionFunctionLocalDate<C> {

    /**
     * WEEKDAY Instance getter.
     * <br>
     * https://support.microsoft.com/en-us/office/weekday-function-60e44483-2ed1-439f-8bd0-e404c190949a
     * <pre>
     * 1 or omitted
     * Numbers 1 (Sunday) through 7 (Saturday). Behaves like previous versions of Microsoft Excel.
     *
     * 2
     * Numbers 1 (Monday) through 7 (Sunday).
     *
     * 3
     * Numbers 0 (Monday) through 6 (Sunday).
     *
     * 11
     * Numbers 1 (Monday) through 7 (Sunday).
     *
     * 12
     * Numbers 1 (Tuesday) through 7 (Monday).
     *
     * 13
     * Numbers 1 (Wednesday) through 7 (Tuesday).
     *
     * 14
     * Numbers 1 (Thursday) through 7 (Wednesday).
     *
     * 15
     * Numbers 1 (Friday) through 7 (Thursday).
     *
     * 16
     * Numbers 1 (Saturday) through 7 (Friday).
     *
     * 17
     * Numbers 1 (Sunday) through 7 (Saturday).
     * </pre>
     */
    static <C extends ExpressionEvaluationContext> NumberExpressionFunctionLocalDateWeekdayWeekNum<C> weekday() {
        return Cast.to(WEEKDAY);
    }

    /**
     * WEEKNUM Instance getter.
     * https://exceljet.net/excel-functions/excel-weeknum-function
     * <pre>
     * The Excel WEEKNUM function extracts the weeknum from a given date as number between 1 to 12.
     * </pre>
     */
    static <C extends ExpressionEvaluationContext> NumberExpressionFunctionLocalDateWeekdayWeekNum<C> weeknum() {
        return Cast.to(WEEKNUM);
    }

    /**
     * WEEKDAY Singleton
     */
    private static final NumberExpressionFunctionLocalDateWeekdayWeekNum<?> WEEKDAY = new NumberExpressionFunctionLocalDateWeekdayWeekNum<>(
            "weekday",
            NumberExpressionFunctionLocalDateWeekdayWeekNum::weekday
    );

    private static int weekday(final LocalDate d, final int type) {
        final DayOfWeek dayOfWeek = d.getDayOfWeek();
        final DayOfWeek start;
        final int bias;

        switch (type) {
            case 1:
            case 17:
                bias = 1;
                start = DayOfWeek.SUNDAY;
                break;
            case 2:
            case 11:
                bias = 1;
                start = DayOfWeek.MONDAY;
                break;
            case 3:
                bias = 0;
                start = DayOfWeek.MONDAY;
                break;
            case 12:
                bias = 1;
                start = DayOfWeek.TUESDAY;
                break;
            case 13:
                bias = 1;
                start = DayOfWeek.WEDNESDAY;
                break;
            case 14:
                bias = 1;
                start = DayOfWeek.THURSDAY;
                break;
            case 15:
                bias = 1;
                start = DayOfWeek.FRIDAY;
                break;
            case 16:
                bias = 1;
                start = DayOfWeek.SATURDAY;
                break;
            default:
                // If return_type is out of the range specified in the table above, a #NUM! error is returned.
                throw new IllegalArgumentException("Invalid type " + type);
        }

        return bias + ((7 + dayOfWeek.getValue() - start.getValue()) % 7);
    }

    // https://github.com/apache/poi/blob/trunk/poi/src/main/java/org/apache/poi/ss/formula/functions/WeekNum.java

    /**
     * WEEKNUM Singleton
     */
    private static final NumberExpressionFunctionLocalDateWeekdayWeekNum<?> WEEKNUM = new NumberExpressionFunctionLocalDateWeekdayWeekNum<>(
            "weeknum",
            NumberExpressionFunctionLocalDateWeekdayWeekNum::weeknum
    );

    private static int weeknum(final LocalDate d, final int type) {
        final TemporalField weekOfYear;

        switch (type) {
            case 1:
            case 17:
                weekOfYear = SUNDAY_START.weekOfYear();
                break;
            case 2:
            case 11:
                weekOfYear = MONDAY_START.weekOfYear();
                break;
            case 12:
                weekOfYear = TUESDAY_START.weekOfYear();
                break;
            case 13:
                weekOfYear = WEDNESDAY_START.weekOfYear();
                break;
            case 14:
                weekOfYear = THURSDAY_START.weekOfYear();
                break;
            case 15:
                weekOfYear = FRIDAY_START.weekOfYear();
                break;
            case 16:
                weekOfYear = SATURDAY_START.weekOfYear();
                break;
            case 21:
                weekOfYear = WeekFields.ISO.weekOfYear();
                break;
            default:
                // If return_type is out of the range specified in the table above, a #NUM! error is returned.
                throw new IllegalArgumentException("Invalid type " + type);
        }

        return d.get(weekOfYear);
    }

    private final static WeekFields SUNDAY_START = WeekFields.of(DayOfWeek.SUNDAY, 1);
    private final static WeekFields MONDAY_START = WeekFields.of(DayOfWeek.MONDAY, 1);
    private final static WeekFields TUESDAY_START = WeekFields.of(DayOfWeek.TUESDAY, 1);
    private final static WeekFields WEDNESDAY_START = WeekFields.of(DayOfWeek.WEDNESDAY, 1);
    private final static WeekFields THURSDAY_START = WeekFields.of(DayOfWeek.THURSDAY, 1);
    private final static WeekFields FRIDAY_START = WeekFields.of(DayOfWeek.FRIDAY, 1);
    private final static WeekFields SATURDAY_START = WeekFields.of(DayOfWeek.SATURDAY, 1);

    /**
     * Private ctor
     */
    private NumberExpressionFunctionLocalDateWeekdayWeekNum(final String name,
                                                            final BiFunction<LocalDate, Integer, Integer> mapper) {
        super(name);

        this.mapper = mapper;
    }

    @Override
    public ExpressionNumber apply(final List<Object> parameters,
                                  final C context) {
        this.checkParameterCount(parameters);

        return context.expressionNumberKind()
                .create(
                        this.mapper.apply(
                                DATE.getOrFail(parameters, 0, context),
                                TYPE.getOrFail(
                                                parameters,
                                                1,
                                        context
                                        ).intValue()
                        )
                );
    }

    final static ExpressionFunctionParameter<ExpressionNumber> TYPE = ExpressionFunctionParameterName.with("type")
            .optional(ExpressionNumber.class)
            .setDefaultValue((c) ->
                    Optional.of(
                            c.expressionNumberKind()
                                    .one()
                    )
            );

    private final BiFunction<LocalDate, Integer, Integer> mapper;

    @Override
    public List<ExpressionFunctionParameter<?>> parameters(final int count) {
        return PARAMETERS;
    }

    private final static List<ExpressionFunctionParameter<?>> PARAMETERS = ExpressionFunctionParameter.list(
            DATE,
            TYPE
    );
}
