package projsfandhtml5.book.intro;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.persistence.EntityNotFoundException;

@ManagedBean
@RequestScoped
public class RecordDisplay {

    @EJB private RecordService recordService;
    private Long id;
    private Record record;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean load() {
        try {
            record = recordService.findById(this.id);
            return true;
        } catch (EntityNotFoundException ex) {
            return false;
        }
    }
}
