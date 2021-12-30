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

import walkingkooka.tree.expression.ExpressionPurityContext;
import walkingkooka.tree.expression.function.ExpressionFunction;
import walkingkooka.tree.expression.function.ExpressionFunctionContext;

import java.time.LocalDate;

abstract class LocalDateExpressionFunction<C extends ExpressionFunctionContext> implements ExpressionFunction<LocalDate, C> {

    LocalDateExpressionFunction() {
        super();
    }

    @Override
    public final boolean lsLastParameterVariable() {
        return false;
    }

    @Override
    public final Class<LocalDate> returnType() {
        return LocalDate.class;
    }

    @Override
    public final boolean resolveReferences() {
        return true;
    }

    @Override
    public final boolean isPure(ExpressionPurityContext expressionPurityContext) {
        return !(this instanceof LocalDateExpressionFunctionToday);
    }

    @Override
    public final String toString() {
        return this.name().toString();
    }
}
