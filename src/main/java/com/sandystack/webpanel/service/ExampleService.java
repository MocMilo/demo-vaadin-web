package com.sandystack.webpanel.service;


import com.vaadin.flow.component.ClickEvent;
import com.vaadin.flow.component.ComponentEventListener;
import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.spring.annotation.SpringComponent;
import org.springframework.context.annotation.Scope;



@Scope("prototype")
@SpringComponent
public class ExampleService {

    private Button button = new Button("Test Button");
    private boolean isOnState;

    public boolean isOnState() {
        return isOnState;
    }

    public Button getButton() {

        button.addClickListener(new ComponentEventListener<ClickEvent<Button>>() {
            @Override
            public void onComponentEvent(ClickEvent<Button> buttonClickEvent) {

                if (isOnState) {
                    button.setIcon(VaadinIcon.ARROW_CIRCLE_DOWN.create());
                    isOnState = false;
                } else {
                    button.setIcon(VaadinIcon.ARROW_CIRCLE_UP.create());
                    isOnState = true;
                }
            }
        });

        return button;
    }
}
