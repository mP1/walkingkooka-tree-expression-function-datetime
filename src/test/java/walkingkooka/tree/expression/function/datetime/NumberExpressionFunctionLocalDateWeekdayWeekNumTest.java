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
import walkingkooka.tree.expression.ExpressionEvaluationContext;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;

public final class NumberExpressionFunctionLocalDateWeekdayWeekNumTest extends NumberExpressionFunctionTestCase<NumberExpressionFunctionLocalDateWeekdayWeekNum<ExpressionEvaluationContext>> {

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

    // https://exceljet.net/excel-functions/excel-weeknum-function

    @Test
    public void testWeeknum20210101Type1() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 1),
                1,
                1
        );
    }

    @Test
    public void testWeeknum20210102Type1() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 2),
                1,
                1
        );
    }

    @Test
    public void testWeeknum20210103Type1() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 3),
                1,
                2
        );
    }

    @Test
    public void testWeeknum20210104Type1() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 4),
                1,
                2
        );
    }

    @Test
    public void testWeeknum20210105Type1() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 5),
                1,
                2
        );
    }

    @Test
    public void testWeeknum20210106Type1() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 6),
                1,
                2
        );
    }

    @Test
    public void testWeeknum20210107Type1() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 7),
                1,
                2
        );
    }

    @Test
    public void testWeeknum20210108Type1() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 8),
                1,
                2
        );
    }

    @Test
    public void testWeeknum20210109Type1() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 9),
                1,
                2
        );
    }

    @Test
    public void testWeeknum20210110Type1() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 10),
                1,
                3
        );
    }

    @Test
    public void testWeeknum20211231Type1() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 12, 31),
                1,
                53
        );
    }
    
    // type 2

    @Test
    public void testWeeknum20210101Type2() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 1),
                2,
                1
        );
    }

    @Test
    public void testWeeknum20210102Type2() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 2),
                2,
                1
        );
    }

    @Test
    public void testWeeknum20210103Type2() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 3),
                2,
                1
        );
    }

    @Test
    public void testWeeknum20210104Type2() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 4),
                2,
                2
        );
    }

    @Test
    public void testWeeknum20210105Type2() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 5),
                2,
                2
        );
    }

    @Test
    public void testWeeknum20210106Type2() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 6),
                2,
                2
        );
    }

    @Test
    public void testWeeknum20210107Type2() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 7),
                2,
                2
        );
    }

    @Test
    public void testWeeknum20210108Type2() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 8),
                2,
                2
        );
    }

    @Test
    public void testWeeknum20210109Type2() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 9),
                2,
                2
        );
    }

    @Test
    public void testWeeknum20210110Type2() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 10),
                2,
                2
        );
    }

    @Test
    public void testWeeknum20210111Type2() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 11),
                2,
                3
        );
    }

    @Test
    public void testWeeknum20211231Type2() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 12, 31),
                2,
                53
        );
    }

    // type 2

    @Test
    public void testWeeknum20210101Type12() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 1),
                12,
                1
        );
    }

    @Test
    public void testWeeknum20210102Type12() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 2),
                12,
                1
        );
    }

    @Test
    public void testWeeknum20210103Type12() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 3),
                12,
                1
        );
    }

    @Test
    public void testWeeknum20210104Type12() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 4),
                12,
                1
        );
    }

    @Test
    public void testWeeknum20210105Type12() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 5),
                12,
                2
        );
    }

    @Test
    public void testWeeknum20210106Type12() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 6),
                12,
                2
        );
    }

    @Test
    public void testWeeknum20210107Type12() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 7),
                12,
                2
        );
    }

    @Test
    public void testWeeknum20210108Type12() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 8),
                12,
                2
        );
    }

    @Test
    public void testWeeknum20210109Type12() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 9),
                12,
                2
        );
    }

    @Test
    public void testWeeknum20210110Type12() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 10),
                12,
                2
        );
    }

    @Test
    public void testWeeknum20210111Type12() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 1, 11),
                12,
                2
        );
    }

    @Test
    public void testWeeknum20211231Type12() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 12, 31),
                12,
                53
        );
    }

    @Test
    public void testWeeknum20211231Type21() {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 12, 31),
                21,
                52
        );
    }

    @Test
    public void testWeeknumType1() {
        this.testWeeknum(1, DayOfWeek.SUNDAY);
    }

    @Test
    public void testWeeknumType2() {
        this.testWeeknum(2, DayOfWeek.MONDAY);
    }

    @Test
    public void testWeeknumType11() {
        this.testWeeknum(11, DayOfWeek.MONDAY);
    }

    @Test
    public void testWeeknumType12() {
        this.testWeeknum(12, DayOfWeek.TUESDAY);
    }

    @Test
    public void testWeeknumType13() {
        this.testWeeknum(13, DayOfWeek.WEDNESDAY);
    }

    @Test
    public void testWeeknumType14() {
        this.testWeeknum(14, DayOfWeek.THURSDAY);
    }

    @Test
    public void testWeeknumType15() {
        this.testWeeknum(15, DayOfWeek.FRIDAY);
    }

    @Test
    public void testWeeknumType16() {
        this.testWeeknum(16, DayOfWeek.SATURDAY);
    }

    @Test
    public void testWeeknumType17() {
        this.testWeeknum(17, DayOfWeek.SUNDAY);
    }

    private void testWeeknum(final int type, final DayOfWeek dayOfWeek) {
        for(int y = 2000; y < 2021; y++) {
            final LocalDate date = LocalDate.of(y, 1, 1);
            int week = 1;

            for(int i = 0; i < 365; i++) {
                final LocalDate date2 = date.plusDays(i);
                if(i > 0 && date2.getDayOfWeek() == dayOfWeek) {
                    week++;
                }

                this.weeknumApplyAndCheck(
                        date2,
                        type,
                        week
                );
            }
        }
    }


    private void weeknumApplyAndCheck(final int type,
                                      final int expected) {
        this.weeknumApplyAndCheck(
                LocalDate.of(2021, 10, 30),
                type,
                expected
        );
    }

    private void weeknumApplyAndCheck(final LocalDate date,
                                      final int expected) {
        this.weeknumApplyAndCheck(
                Lists.of(date),
                expected
        );
    }

    private void weeknumApplyAndCheck(final LocalDate date,
                                      final int type,
                                      final int expected) {
        this.weeknumApplyAndCheck(
                Lists.of(date, KIND.create(type)),
                expected
        );
    }

    private void weeknumApplyAndCheck(final List<Object> parameters, final int expected) {
        this.applyAndCheck2(
                NumberExpressionFunctionLocalDateWeekdayWeekNum.weeknum(),
                parameters,
                KIND.create(expected)
        );
    }
    // toString........................................................................................................
    
    @Test
    public void testToStringWeekday() {
        this.toStringAndCheck(
                NumberExpressionFunctionLocalDateWeekdayWeekNum.weekday(),
                "weekday"
        );
    }

    @Override
    public NumberExpressionFunctionLocalDateWeekdayWeekNum<ExpressionEvaluationContext> createBiFunction() {
        return NumberExpressionFunctionLocalDateWeekdayWeekNum.weekday();
    }

    @Override
    public Class<NumberExpressionFunctionLocalDateWeekdayWeekNum<ExpressionEvaluationContext>> type() {
        return Cast.to(NumberExpressionFunctionLocalDateWeekdayWeekNum.class);
    }
}
