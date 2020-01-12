package com.sandystack.webpanel;

import com.sandystack.webpanel.ui.TabsLayout;
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

    private TabsLayout tabsLayout;

    public MainView(TabsLayout tabsLayout) {
        this.tabsLayout = tabsLayout;

        Div topArea = createMainViewPage();
        VerticalLayout mainTabsLayout = createMainTabsLayout();

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

    /**
     * Creates main tabs menu with content (tab headers with selected tab content page)
     */
    private VerticalLayout createMainTabsLayout() {
        return tabsLayout.create();
    }
}
