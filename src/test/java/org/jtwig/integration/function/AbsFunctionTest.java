package org.jtwig.integration.function;

import org.jtwig.JtwigModel;
import org.jtwig.JtwigTemplate;
import org.jtwig.integration.AbstractIntegrationTest;
import org.junit.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;

public class AbsFunctionTest extends AbstractIntegrationTest {
    @Test
    public void absInteger() throws Exception {

        String result = JtwigTemplate.inlineTemplate("{{ abs(-1) }}")
                .render(JtwigModel.newModel());

        assertThat(result, is("1"));
    }
    @Test
    public void absFloat() throws Exception {

        String result = JtwigTemplate.inlineTemplate("{{ abs(-1.1) }}")
                .render(JtwigModel.newModel());

        assertThat(result, is("1.1"));
    }

    @Test
    public void absVarInteger() throws Exception {

        String result = JtwigTemplate.inlineTemplate("{{ abs(var) }}")
                .render(JtwigModel.newModel().with("var", -1));

        assertThat(result, is("1"));
    }

    @Test
    public void absVarDouble() throws Exception {

        String result = JtwigTemplate.inlineTemplate("{{ abs(var) }}")
                .render(JtwigModel.newModel().with("var", "-1.1"));

        assertThat(result, is("1.1"));
    }
}
