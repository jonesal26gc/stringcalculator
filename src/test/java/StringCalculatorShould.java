import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class StringCalculatorShould {

    @Test
    public void
    empty_string(){
     assertThat(new StringCalculator().add(""),is(0));
    }

    @Test
    public void
    one_Number(){
        assertThat(new StringCalculator().add("2"),is(2));
    }

    @Test
    public void
    two_numbers(){
        assertThat(new StringCalculator().add("10,10"),is(20));
    }

    @Test
    public void
    three_numbers(){
        assertThat(new StringCalculator().add("101,102,103"),is(306));
    }

    @Test
    public void
    four_numbers(){
        assertThat(new StringCalculator().add("101,10,1,2"),is(114));
    }

    @Test
    public void
    four_numbers_delimited_by_newline(){
        assertThat(new StringCalculator().add("101\n10\n1\n2"),is(114));
    }

    @Test
    public void
    four_numbers_delimited_by_both_newline_and_comma(){
        assertThat(new StringCalculator().add("101\n10,1\n2"),is(114));
    }

    @Test
    public void
    four_numbers_delimited_by_optional_delimiter(){
        assertThat(new StringCalculator().add("//;\n101;1;2;8"),is(112));
    }

    @Test
    public void
    four_numbers_delimited_by_optional_delimiter_plus_others(){
        assertThat(new StringCalculator().add("//;\n101;1;2;8,10\n30"),is(152));
    }
}
