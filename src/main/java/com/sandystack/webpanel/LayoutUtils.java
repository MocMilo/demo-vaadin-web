package com.sandystack.webpanel;

import com.vaadin.flow.component.orderedlayout.FlexComponent;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;

public final class LayoutUtils {

    private LayoutUtils() {
    }

    public static void shrinkLayoutPaddingAndSpacing(VerticalLayout verticalLayout){

        verticalLayout.setPadding(false);
        verticalLayout.setSpacing(false);
        verticalLayout.setAlignItems(FlexComponent.Alignment.START);
    }
}
