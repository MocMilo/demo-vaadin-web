package com.sandystack.webpanel;

import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.page.Push;
import com.vaadin.flow.router.Route;
import com.vaadin.flow.spring.annotation.UIScope;

@Push
@Route
@UIScope
public class MainView extends Div {

    public MainView() {

        Div topArea = createMainViewPage();
        VerticalLayout mainTabsLayout = new VerticalLayout();
        add(topArea, mainTabsLayout);
    }

    /**
     * Creates div above tabs menu
     */
    private Div createMainViewPage() {

        Div mainViewPage = new Div();
        VerticalLayout mainVerticalLayout = new VerticalLayout();

        Label testLabel = new Label("TEST LABEL size from core crud");
        mainVerticalLayout.add(testLabel);
        LayoutUtils.shrinkLayoutPaddingAndSpacing(mainVerticalLayout);

        mainViewPage.add(mainVerticalLayout);
        return mainViewPage;
    }


}
