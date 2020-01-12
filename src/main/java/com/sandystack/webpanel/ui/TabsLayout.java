package com.sandystack.webpanel.ui;

import com.sandystack.webpanel.LayoutUtils;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.component.tabs.Tab;
import com.vaadin.flow.component.tabs.Tabs;
import com.vaadin.flow.spring.annotation.SpringComponent;
import com.vaadin.flow.spring.annotation.UIScope;
import org.springframework.context.annotation.Scope;

import java.util.*;

@Scope("prototype")
@SpringComponent
@UIScope
public class TabsLayout {

    private Tab1 tab1;
    private Tab2 tab2;
    private Tab3 tab3;

    private Tabs tabHeaders = new Tabs();
    private Div shownBodyPage = new Div();
    private List<BaseTab> tabContainer = new ArrayList<>();
    private Set<Component> pagesShown = new HashSet<>();
    private Map<Tab, Component> tabsToBodyPagesMap = new LinkedHashMap<>();


    public TabsLayout(Tab1 tab1, Tab2 tab2, Tab3 tab3) {

        this.tab1 = tab1;
        this.tab2 = tab2;
        this.tab3 = tab3;

        addTabsLayoutToContainer();
        initTabsAndTabPages();
        setTabChangeContentListener();
    }

    /**
     * Tab layout creation is based on tabs stored in container.
     * Container persists tabs order.
     */
    private void addTabsLayoutToContainer() {
        tabContainer.add(tab1);
        tabContainer.add(tab2);
        tabContainer.add(tab3);
    }

    private void initTabsAndTabPages() {

        for (int i = 0; i < tabContainer.size(); i++) {

            BaseTab tab = tabContainer.get(i);
            Tab tabInstance = tab.create();
            tabHeaders.add(tabInstance);

            Div page = tab.getTabContentDiv();

            if (i == 1) page.setVisible(true);
            else page.setVisible(false);

            shownBodyPage.add(page);
            tabsToBodyPagesMap.put(tabInstance, page);
        }
    }

    public VerticalLayout create() {

        VerticalLayout mainVerticalLayout = new VerticalLayout();
        HorizontalLayout tabsHorizontalLayout = new HorizontalLayout();
        tabsHorizontalLayout.add(tabHeaders);
        mainVerticalLayout.add(tabsHorizontalLayout);
        mainVerticalLayout.add(shownBodyPage);

        LayoutUtils.shrinkLayoutPaddingAndSpacing(mainVerticalLayout);
        return mainVerticalLayout;
    }

    private void setTabChangeContentListener() {

        tabHeaders.addSelectedChangeListener(event -> {

            shownBodyPage.getChildren().forEach(p -> p.setVisible(false));
            pagesShown.forEach(p -> p.setVisible(false));
            pagesShown.clear();

            Component selectedPage = tabsToBodyPagesMap.get(tabHeaders.getSelectedTab());
            selectedPage.setVisible(true);
            pagesShown.add(selectedPage);
        });
        tabHeaders.setFlexGrowForEnclosedTabs(1);
    }
}
