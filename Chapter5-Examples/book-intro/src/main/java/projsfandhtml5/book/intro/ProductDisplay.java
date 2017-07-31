package projsfandhtml5.book.intro;

import java.util.HashMap;
import java.util.Map;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;

@ManagedBean
@ViewScoped
public class ProductDisplay {

    private Map<String, Object> attributes;

    public Map<String, Object> getProductAttributes() {
        if (this.attributes == null) {
            this.attributes = new HashMap<>();
            this.attributes.put("data-popup-title", "Click to see more information");
            this.attributes.put("data-product-id", "1234");
        }
        return this.attributes;
    }
}
