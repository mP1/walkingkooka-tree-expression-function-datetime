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

import static org.junit.jupiter.api.Assertions.assertThrows;

public final class LocalDateExpressionFunctionDateTest extends LocalDateExpressionFunctionTestCase<LocalDateExpressionFunctionDate<ExpressionFunctionContext>>  {

    @Test
    public void testInvalidYearFails() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    this.apply2(
                            Lists.of(
                                    KIND.create(-1),
                                    KIND.create(12),
                                    KIND.create(30)
                            )
                    );
                });
    }

    @Test
    public void testInvalidMonthFails() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    this.apply2(
                            Lists.of(
                                    KIND.create(2021),
                                    KIND.create(-1),
                                    KIND.create(30)
                            )
                    );
                });
    }

    @Test
    public void testInvalidDayFails() {
        assertThrows(
                IllegalArgumentException.class,
                () -> {
                    this.apply2(
                            Lists.of(
                                    KIND.create(2021),
                                    KIND.create(12),
                                    KIND.create(-1)
                            )
                    );
                });
    }

    @Test
    public void test211230() {
        this.applyAndCheck2(
                Lists.of(
                        KIND.create(21),
                        KIND.create(12),
                        KIND.create(30)
                ),
                LocalDate.of(TWO_DIGIT_YEAR + 21, 12, 30)
        );
    }

    @Test
    public void test20211230() {
        this.applyAndCheck2(
                Lists.of(
                        KIND.create(2021),
                        KIND.create(12),
                        KIND.create(30)
                ),
                LocalDate.of(2021, 12, 30)
        );
    }

    @Test
    public void test20211232() {
        this.applyAndCheck2(
                Lists.of(
                        KIND.create(2021),
                        KIND.create(12),
                        KIND.create(32)
                ),
                LocalDate.of(2022, 1, 1)
        );
    }

    @Test
    public void test20211200() {
        this.applyAndCheck2(
                Lists.of(
                        KIND.create(2021),
                        KIND.create(12),
                        KIND.create(00)
                ),
                LocalDate.of(2021, 11, 30)
        );
    }

    @Test
    public void test20210001() {
        this.applyAndCheck2(
                Lists.of(
                        KIND.create(2021),
                        KIND.zero(),
                        KIND.create(2)
                ),
                LocalDate.of(2020, 12, 2)
        );
    }

    @Test
    public void testToString(){
        this.toStringAndCheck(this.createBiFunction(), "date");
    }

    @Override
    public LocalDateExpressionFunctionDate<ExpressionFunctionContext> createBiFunction() {
        return LocalDateExpressionFunctionDate.instance();
    }

    @Override
    public Class<LocalDateExpressionFunctionDate<ExpressionFunctionContext>> type() {
        return Cast.to(LocalDateExpressionFunctionDate.class);
    }
}
