package com.sandystack.webpanel.ui;


import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.context.annotation.Scope;

@Scope("prototype")
@SpringComponent
public class Tab3 extends BaseTab {

    private static final String TAB3_LABEL = "Tab 3";
    private VerticalLayout verticalLayout;

    @Override
    public Tab create() {
        tab = new Tab();
        tab.add(TAB3_LABEL);
        verticalLayout = new VerticalLayout();
        tabContentDiv = new Div();
        createContent();
        return tab;
    }

    private void createContent() {
        Button button = new Button("test 3");
        verticalLayout.add(button);
        tabContentDiv.add(verticalLayout);
    }


}
