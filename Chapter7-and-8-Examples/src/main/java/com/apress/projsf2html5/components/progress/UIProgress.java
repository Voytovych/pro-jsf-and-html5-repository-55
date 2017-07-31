package com.apress.projsf2html5.components.progress;

import java.io.IOException;
import javax.el.ValueExpression;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.component.UINamingContainer;

/**
 * Composite component for the {@code <progress/>} element.
 */
@FacesComponent("UIProgress")
public class UIProgress extends UINamingContainer {

    private static final String ATTRIBUTE_FOR = "for";
    private UIComponent forComponent;

    /**
     * Finds the component specified in the {@code for} attribute.
     *
     * @return {@link UIComponent} specified in the {@code for} attribute
     * @throws IOException If a {@link UIComponent} with the name specified in
     * the {@code for} attribute could not be found
     */
    public UIComponent getForComponent() throws IOException {
        if (getAttributes().containsKey(ATTRIBUTE_FOR)) {
            String forAttribute = (String) getAttribute(ATTRIBUTE_FOR);

            this.forComponent = findComponent(forAttribute);

            if (this.forComponent == null) {
                throw new IOException("Component with ID "
                        + forAttribute + " could not be found");
            }
        } else {
            throw new IOException("The for attribute was not set on the component");
        }
        return forComponent;
    }

    /**
     * Gets the client id of the {@link #getForComponent()}
     *
     * @return Client id of the {@link #getForComponent()}
     * @throws IOException If the component specified in the {@code for}
     * attribute could not be found
     */
    public String getForClientId() throws IOException {
        UIComponent element = getForComponent();
        return element.getClientId(getFacesContext());
    }

    /**
     * Utility method for retrieving the attributes of a component. This method
     * first checks if the attribute is an EL Expression followed by checking if
     * it is a simple value.
     *
     * @param name Name of the attribute to retrieve
     * @return The value of the attribute. If the contents of the attribute is
     * an EL Expression, the expression will be executed and returned. If the
     * contents of the attribute is a simple value, it will be returned as is.
     * If the attribute cannot be found {@code null} is returned.
     */
    private Object getAttribute(String name) {

        ValueExpression ve = getValueExpression(name);
        if (ve != null) {
            // Attribute is a value expression
            return ve.getValue(getFacesContext().getELContext());
        } else if (getAttributes().containsKey(name)) {
            // Attribute is a fixed value
            return getAttributes().get(name);
        } else {
            // Attribute doesn't exist
            return null;
        }
    }
}
