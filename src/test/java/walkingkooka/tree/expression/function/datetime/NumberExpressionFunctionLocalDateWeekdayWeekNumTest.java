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

import org.junit.jupiter.api.Test;
import walkingkooka.Cast;
import walkingkooka.collect.list.Lists;
import walkingkooka.tree.expression.function.ExpressionFunctionContext;

import java.time.LocalDate;
import java.util.List;

public final class NumberExpressionFunctionLocalDateWeekdayWeekNumTest extends NumberExpressionFunctionTestCase<NumberExpressionFunctionLocalDateWeekdayWeekNum<ExpressionFunctionContext>> {

    private final static int SUNDAY = 1;
    private final static int MONDAY = 2;
    private final static int TUESDAY = 3;
    private final static int WEDNESDAY = 4;
    private final static int THURSDAY = 5;
    private final static int FRIDAY = 6;
    private final static int SATURDAY = 7;

    // https://exceljet.net/excel-functions/excel-weekday-function

    @Test
    public void testWeekday20210103() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2021, 1, 3),
                SUNDAY
        );
    }

    @Test
    public void testWeekday20210103Type01() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2021, 1, 3),
                1,
                SUNDAY
        );
    }

    @Test
    public void testWeekday20210104Type01() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2021, 1, 4),
                1,
                MONDAY
        );
    }

    @Test
    public void testWeekday20210105Type01() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2021, 1, 5),
                1,
                TUESDAY
        );
    }

    @Test
    public void testWeekday20210106Type01() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2021, 1, 6),
                1,
                WEDNESDAY
        );
    }

    @Test
    public void testWeekday20210107Type01() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2021, 1, 7),
                1,
                THURSDAY
        );
    }

    @Test
    public void testWeekday20210108Type01() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2021, 1, 8),
                1,
                FRIDAY
        );
    }

    @Test
    public void testWeekday20210109Type01() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2021, 1, 9),
                1,
                SATURDAY
        );
    }

    @Test
    public void testWeekday20210103Type02() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2021, 1, 3),
                2,
                SATURDAY
        );
    }

    @Test
    public void testWeekday20210104Type02() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2021, 1, 4),
                2,
                SUNDAY
        );
    }

    @Test
    public void testWeekday20210105Type02() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2021, 1, 5),
                2,
                MONDAY
        );
    }

    @Test
    public void testWeekday20210106Type02() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2021, 1, 6),
                2,
                TUESDAY
        );
    }

    @Test
    public void testWeekday20210107Type02() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2021, 1, 7),
                2,
                WEDNESDAY
        );
    }

    @Test
    public void testWeekday20210108Type02() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2021, 1, 8),
                2,
                THURSDAY
        );
    }

    @Test
    public void testWeekday20210109Type02() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2021, 1, 9),
                2,
                FRIDAY
        );
    }

    // https://support.microsoft.com/en-us/office/weekday-function-60e44483-2ed1-439f-8bd0-e404c190949a

    @Test
    public void testWeekday20080214() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2008, 2, 14),
                THURSDAY
        );
    }

    @Test
    public void testWeekday20080214Type02() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2008, 2, 14),
                2,
                WEDNESDAY
        );
    }

    @Test
    public void testWeekday20080214Type03() {
        this.weekdayApplyAndCheck(
                LocalDate.of(2008, 2, 14),
                3,
                TUESDAY
        );
    }

    // google sheets...................................................................................................
    // 7	=weekday(30/12/2021,1)
    //6	=weekday(30/12/2021,2)
    //5	=weekday(30/12/2021,3)
    //6	=weekday(30/12/2021,11)
    //5	=weekday(30/12/2021,12)
    //4	=weekday(30/12/2021,13)
    //3	=weekday(30/12/2021,14)
    //2	=weekday(30/12/2021,15)
    //1	=weekday(30/12/2021,16)
    //7	=weekday(30/12/2021,17)

    @Test
    public void testWeekday20211230Type11() {
        this.weekdayApplyAndCheck(
                11,
                FRIDAY
        );
    }

    @Test
    public void testWeekday20211230Type12() {
        this.weekdayApplyAndCheck(
                12,
                THURSDAY
        );
    }

    @Test
    public void testWeekday20211230Type13() {
        this.weekdayApplyAndCheck(
                13,
                WEDNESDAY
        );
    }

    @Test
    public void testWeekday20211230Type14() {
        this.weekdayApplyAndCheck(
                14,
                TUESDAY
        );
    }

    @Test
    public void testWeekday20211230Type15() {
        this.weekdayApplyAndCheck(
                15,
                MONDAY
        );
    }

    @Test
    public void testWeekday20211230Type16() {
        this.weekdayApplyAndCheck(
                16,
                SUNDAY
        );
    }

    @Test
    public void testWeekday20211230Type17() {
        this.weekdayApplyAndCheck(
                17,
                SATURDAY
        );
    }

    private void weekdayApplyAndCheck(final int type,
                                      final int expected) {
        this.weekdayApplyAndCheck(
                LocalDate.of(2021, 10, 30),
                type,
                expected
        );
    }

    private void weekdayApplyAndCheck(final LocalDate date,
                                      final int expected) {
        this.weekdayApplyAndCheck(
                Lists.of(date),
                expected
        );
    }

    private void weekdayApplyAndCheck(final LocalDate date,
                                      final int type,
                                      final int expected) {
        this.weekdayApplyAndCheck(
                Lists.of(date, KIND.create(type)),
                expected
        );
    }

    private void weekdayApplyAndCheck(final List<Object> parameters, final int expected) {
        this.applyAndCheck2(
                NumberExpressionFunctionLocalDateWeekdayWeekNum.weekday(),
                parameters,
                KIND.create(expected)
        );
    }

    @Test
    public void testToStringWeekday() {
        this.toStringAndCheck(
                NumberExpressionFunctionLocalDateWeekdayWeekNum.weekday(),
                "weekday"
        );
    }

    @Override
    public NumberExpressionFunctionLocalDateWeekdayWeekNum<ExpressionFunctionContext> createBiFunction() {
        return NumberExpressionFunctionLocalDateWeekdayWeekNum.weekday();
    }

    @Override
    public Class<NumberExpressionFunctionLocalDateWeekdayWeekNum<ExpressionFunctionContext>> type() {
        return Cast.to(NumberExpressionFunctionLocalDateWeekdayWeekNum.class);
    }
}
