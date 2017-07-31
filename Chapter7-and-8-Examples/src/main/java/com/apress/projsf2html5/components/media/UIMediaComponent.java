package com.apress.projsf2html5.components.media;

import java.io.IOException;
import javax.el.ValueExpression;
import javax.faces.component.FacesComponent;
import javax.faces.component.UIComponent;
import javax.faces.component.UINamingContainer;
import javax.faces.context.FacesContext;

/**
 * Composite component for the {@code <audio/>} and {@code <video/>} elements.
 */
@FacesComponent("UIMediaComponent")
public class UIMediaComponent extends UINamingContainer {

    private static final String ELEMENT_ID = "media-player";
    private static final String ATTRIBUTE_AUTOPLAY = "autoplay";
    private static final String ATTRIBUTE_LOOP = "loop";
    private static final String ATTRIBUTE_MUTED = "muted";
    private static final String ATTRIBUTE_CONTROLS = "controls";
    private static final String ATTRIBUTE_POSTER = "poster";
    private static final String ATTRIBUTE_WIDTH = "width";
    private static final String ATTRIBUTE_HEIGHT = "height";

    public String getElementId() {
        return ELEMENT_ID;
    }

    @Override
    public void encodeBegin(FacesContext context) throws IOException {
        super.encodeBegin(context);
        UIComponent element = findMediaElement();
        
        addAttributeIfTrue(element, ATTRIBUTE_AUTOPLAY);
        addAttributeIfTrue(element, ATTRIBUTE_LOOP);
        addAttributeIfTrue(element, ATTRIBUTE_MUTED);
        addAttributeIfTrue(element, ATTRIBUTE_CONTROLS);
        addAttributeIfNotNull(element, ATTRIBUTE_POSTER);
        addAttributeIfNotNull(element, ATTRIBUTE_WIDTH);
        addAttributeIfNotNull(element, ATTRIBUTE_HEIGHT);
    }

    private void addAttributeIfNotNull(UIComponent component, String attributeName) {
        Object attributeValue = getAttribute(attributeName);
        if (attributeValue != null) {
            component.getPassThroughAttributes().put(attributeName, attributeValue);
        }
    }

    private void addAttributeIfTrue(UIComponent component, String attributeName) {
        if (isAttributeTrue(attributeName)) {
            component.getPassThroughAttributes().put(attributeName, attributeName);
        }
    }

    /**
     * Finds the {@code <video/>} or {@code <audio/>} element in the
     * composite component.
     *
     * @return {@link UIComponent} representing the {@code <video/>} or
     * {@code <audio/>} element
     * @throws IOException If the the {@link UIComponent} could not be found.
     * There is no way to recover from this exception at run-time. Ensure that
     * the ID of the element corresponds to ID specified in the
     * {@link #ELEMENT_ID} constant
     */
    private UIComponent findMediaElement() throws IOException {
        UIComponent element = findComponent(getElementId());

        if (element == null) {
            throw new IOException("Media element with ID "
                    + getElementId() + " could not be found");
        }
        return element;
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

    /**
     * Utility method that evaluates if the value in the given attribute is
     * {@link Boolean.TRUE}.
     *
     * @param attributeName Name of the attribute to evaluate
     * @return {@code true} if the value of the attribute evaluates to
     * {@link Boolean.TRUE}, otherwise {@code false} is returned
     */
    private boolean isAttributeTrue(String attributeName) {
        boolean isBoolean = getAttribute(attributeName) instanceof java.lang.Boolean;
        boolean isTrue = ((boolean) getAttribute(attributeName)) == Boolean.TRUE;
        return isBoolean && isTrue;
    }
}
