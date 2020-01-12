package com.sandystack.webpanel.ui;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@SpringComponent
public class Tab2 extends BaseTab {

    private static final String TAB2_LABEL = "Tab 2";
    private VerticalLayout verticalLayout;

    @Override
    public Tab create() {
        tab = new Tab();
        tab.add(TAB2_LABEL);
        verticalLayout = new VerticalLayout();
        tabContentDiv = new Div();
        createContent();
        return tab;
    }

    private void createContent() {
        Button button = new Button("test 2");
        verticalLayout.add(button);
        tabContentDiv.add(verticalLayout);
    }

}
