package com.sandystack.webpanel.ui;


import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.context.annotation.Scope;

import java.util.Objects;

@Scope("prototype")
@SpringComponent
public abstract class BaseTab extends Div {

    protected Tab tab;
    protected Div tabContentDiv;

    public Div getTabContentDiv() {
        return tabContentDiv;
    }

    public abstract Tab create();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BaseTab baseTab = (BaseTab) o;
        return Objects.equals(tab, baseTab.tab) &&
                Objects.equals(tabContentDiv, baseTab.tabContentDiv);
    }

/*    @Override
    public int hashCode() {
        return Objects.hash(tab, tabContentDiv);
    }*/


}
