package projsfandhtml5.book.intro;

import java.io.IOException;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.context.FacesContext;
import javax.servlet.http.Part;
import org.apache.commons.io.IOUtils;

@ManagedBean
@RequestScoped
public class MyProfile {

    @EJB
    private UserProfileService userProfileService;
    private UserProfile userProfile;
    private Part photo;

    public String uploadPhoto() throws IOException {
        // Uploading file. You don't have to do anything here, but you could
        // use it for post processing.  Don't use this method for validating
        // the uploaded file.

        byte[] photoContents = IOUtils.toByteArray(photo.getInputStream());
        userProfileService.savePhoto(userProfile, photoContents);
        FacesContext.getCurrentInstance().addMessage("frm-photo-upload", new FacesMessage(FacesMessage.SEVERITY_INFO, "Photo uploaded successfully", "Filename: " + photo.getName() + " File size: " + photo.getSize()/1024 + " KB"));
        return "/photo-uploaded";
    }

    public Part getPhoto() {
        return photo;
    }

    public void setPhoto(Part photo) {
        this.photo = photo;
    }

    public UserProfile getUserProfile() {
        return this.userProfile;
    }

    public void setUserProfile(UserProfile userProfile) {
        this.userProfile = userProfile;
    }
}
