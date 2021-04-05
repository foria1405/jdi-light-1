package com.epam.jdi.light.angular.asserts;

import com.epam.jdi.light.angular.elements.complex.Datepicker;
import com.epam.jdi.light.asserts.generic.ITextAssert;
import com.epam.jdi.light.asserts.generic.UIAssert;
import com.epam.jdi.light.common.JDIAction;
import org.hamcrest.Matcher;
import org.hamcrest.Matchers;

import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.util.List;
import java.util.Locale;

import static com.epam.jdi.light.asserts.core.SoftAssert.jdiAssert;

public class DatepickerAssert extends UIAssert<DatepickerAssert, Datepicker> implements ITextAssert<DatepickerAssert> {
    @JDIAction("Assert that '{name}' date '{0}'")
    public DatepickerAssert date(final Matcher<String> date) {
        jdiAssert(element().getValue(), date);
        return this;
    }

    public DatepickerAssert date(final String date) {
        return date(Matchers.is(date));
    }

    @JDIAction("Assert that '{name}' month '{0}'")
    public DatepickerAssert month(final Matcher<Month> month) {
        jdiAssert(element().getMonth(), month);
        return this;
    }

    public DatepickerAssert month(final Month month) {
        return month(Matchers.is(month));
    }

    @JDIAction("Assert that '{name}' year '{0}'")
    public DatepickerAssert year(final Matcher<Year> year) {
        jdiAssert(element().getYear(), year);
        return this;
    }

    public DatepickerAssert year(final Year year) {
        return year(Matchers.is(year));
    }

    @JDIAction("Assert that '{name}' day '{0}'")
    public DatepickerAssert day(final Matcher<Integer> day) {
        jdiAssert(element().getDay(), day);
        return this;
    }

    public DatepickerAssert day(final int day) {
        return day(Matchers.is(day));
    }

    public DatepickerAssert text(Matcher<String> condition) {
        jdiAssert(element().getValue(), condition);
        return this;
    }
}
